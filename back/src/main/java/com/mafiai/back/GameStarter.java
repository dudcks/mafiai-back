package com.mafiai.back;

import java.util.*;

public class GameStarter {

    private DataStorage dataStorage;

    public GameStarter(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    public List<MyData> startGame(int count) {
        // 저장된 데이터 가져오기
        List<MyData> allData = dataStorage.getAllData();
        List<MyData> selectedDataList = new ArrayList<>();

        // 랜덤하게 데이터 선택
        if (!allData.isEmpty()) {
            Random random = new Random();
            Set<Integer> selectedIndexes = new HashSet<>();

            while (selectedDataList.size() < count && selectedIndexes.size() < allData.size()) {
                int randomIndex = random.nextInt(allData.size());

                // 중복된 인덱스를 방지
                if (selectedIndexes.add(randomIndex)) {
                    MyData selectedData = allData.get(randomIndex);
                    selectedDataList.add(selectedData);
                }
            }
        }

        return selectedDataList;
    }

    public List<MyData> getAllGameData() {
        // 저장된 모든 데이터 가져오기
        List<MyData> allData = dataStorage.getAllData();
        return allData;
    }
}
