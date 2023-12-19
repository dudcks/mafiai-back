package com.mafiai.back.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mafiai.back.ChatGptService;
import com.mafiai.back.DataStorage;
import com.mafiai.back.MyData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ChatGptController {
    @Value("${api.key}")
    private String API_KEY;
    @Autowired
    private DataStorage dataStorage;
    @Autowired
    private ChatGptService chatGptService;


    @PostMapping("api/chat")
    public ResponseEntity<String> ChatGptsPost(@RequestBody String input, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String answer = "연결 실패";

        String content = "";
        try {
            // JSON 문자열을 파싱
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(input);

            // id와 message 추출
            int id = jsonNode.get("id").asInt();
            String message = jsonNode.get("message").asText();

            answer = chatGptService.getChatResponse(id, message, API_KEY);
            JsonNode jsonNode2 = objectMapper.readTree(answer);
            content = jsonNode2
                    .path("choices")
                    .path(0)
                    .path("message")
                    .path("content")
                    .asText();
            String jsonResponse = objectMapper.createObjectNode().put("content", content).toString();
            System.out.println(jsonResponse);
            return ResponseEntity.ok(jsonResponse);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(answer);
        }
    }

    @PostMapping("api/chat/test")
    public ResponseEntity<String> testGptsPost(@RequestBody String input, HttpServletRequest request) {
        String content = "";
        String requestBody = null;
        try {
            // JSON 문자열을 파싱
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(input);

            // id와 message 추출
            int id = jsonNode.get("id").asInt();
            String message = jsonNode.get("message").asText();
            List<MyData> allData = dataStorage.getAllData();
            String desiredDescription = "";
            for (MyData myData : allData) {
                if (myData != null && myData.getId() == id) {
                    desiredDescription = myData.getDescription();
                    break;
                }
            }

            requestBody = "{\"model\":\"gpt-4-1106-preview\",\"messages\":[{\"role\":\"system\",\"content\":\"너는[[" + desiredDescription + "]]을 연기하는 ai야. 절대로 니가 ai인 것 처럼 하면 안되고,[[" + desiredDescription + "]]이라는 캐릭터에 몰입해서 실제로 그 캐릭터 인 것 처럼 자연스럽게 대답해줘. 그리고 상대방은 니가 무슨 캐릭터를 연기하는 지 맞추는 게임을 하고 있어. 그렇기 때문에, 니가 누구인지 직접적으로 알 수 있는 질문에 대란 답은 절대로 주면 안돼. 최대한 그러한 것에 대한 답변은 피하고, 간접적으로 유추할 수 있는 질문에만 답변을 줘. 그리고 항상 대답은 한국어로 대답해줘.\"},{\"role\":\"user\",\"content\":\"" + message + "\"}],\"max_tokens\":1000}";
            return ResponseEntity.ok(requestBody);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(requestBody);
        }
    }
}
