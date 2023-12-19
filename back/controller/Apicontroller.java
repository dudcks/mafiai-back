package com.mafiai.back.controller;

import com.mafiai.back.DataStorage;
import com.mafiai.back.GameStarter;
import com.mafiai.back.MyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Apicontroller {

    @Autowired
    private DataStorage dataStorage;
    @Autowired
    private DataStorage moviedataStorage;
    @Autowired
    private DataStorage gamedataStorage;

    @GetMapping("/game_start")
    public List<MyData> startGame(@RequestParam(name = "count", defaultValue = "5") int count,
                                  @RequestParam(name = "category", defaultValue = "0") int category) {
        GameStarter gameStarter = new GameStarter(dataStorage);

        return gameStarter.startGame(count,category);
    }
    @GetMapping("/get_c")
    public List<MyData> getAllGamec(@RequestParam(name = "category", defaultValue = "0") int category) {
        // 저장된 모든 데이터 가져오기
        GameStarter gameStarter = new GameStarter(dataStorage);
        return gameStarter.getAllGameData(category);
    }
    @GetMapping("/get_all")
    public List<MyData> getAllGameData() {
        // 저장된 모든 데이터 가져오기
        GameStarter gameStarter = new GameStarter(dataStorage);
        return gameStarter.getAllGameData();
    }
}
