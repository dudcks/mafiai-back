package com.mafiai.back;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ChatGptService {

    private DataStorage dataStorage;
    private RestTemplate restTemplate;
    private final String chatGptApiUrl="https://api.openai.com/v1/chat/completions";

    public ChatGptService(DataStorage dataStorage){
        this.restTemplate=new RestTemplate();
        this.dataStorage=dataStorage;
    }

    public String getChatResponse(int id,String userInput,String apikey){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apikey);

        List<MyData> allData = dataStorage.getAllData();
        String desiredDescription = "";
        for (MyData myData : allData) {
            if (myData != null && myData.getId() == id) {
                desiredDescription = myData.getDescription();
                break;
            }
        }

        String requestBody="{\"model\":\"gpt-4-1106-preview\",\"messages\":[{\"role\":\"system\",\"content\":\"너는[["+desiredDescription +"]]을 연기하는 ai야. 절대로 니가 ai인 것 처럼 하면 안되고,[["+desiredDescription+"]]이라는 캐릭터에 몰입해서 실제로 그 캐릭터 인 것 처럼 자연스럽게 대답해줘. 그리고 상대방은 니가 무슨 캐릭터를 연기하는 지 맞추는 게임을 하고 있어. 그렇기 때문에, 니가 누구인지 직접적으로 알 수 있는 질문에 대란 답은 절대로 주면 안돼. 최대한 그러한 것에 대한 답변은 피하고, 간접적으로 유추할 수 있는 질문에만 답변을 줘. 그리고 항상 대답은 한국어로 대답해줘.\"},{\"role\":\"user\",\"content\":\""+userInput+"\"}],\"max_tokens\":1000}";
        HttpEntity<String> requestEnity = new HttpEntity<>(requestBody,headers);

        //API 호출
        ResponseEntity<String> responseEntity = null;
        responseEntity=restTemplate.exchange(chatGptApiUrl, HttpMethod.POST,requestEnity,String.class);
        
        //API 응답 처리
        String chatResponse = responseEntity.getBody();

        return chatResponse;
    }
}
