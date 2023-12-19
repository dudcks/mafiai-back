package com.mafiai.back;

import java.util.*;

public class GameStarter {

    private DataStorage dataStorage;
    public GameStarter(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    public List<MyData> startGame(int count,int category) {
        // 저장된 데이터 가져오기
        List<MyData> allData = dataStorage.getAllData();
        List<MyData> selectedDataList = new ArrayList<>();

        List<MyData> filteredData = filterDataByCategory(allData, category);

        // 랜덤하게 데이터 선택
        if (!filteredData.isEmpty()) {
            Random random = new Random();
            Set<Integer> selectedIndexes = new HashSet<>();

            while (selectedDataList.size() < count && selectedIndexes.size() < filteredData.size()) {
                int randomIndex = random.nextInt(filteredData.size());

                // 중복된 인덱스를 방지
                if (selectedIndexes.add(randomIndex)) {
                    MyData selectedData = filteredData.get(randomIndex);
                    selectedDataList.add(selectedData);
                }
            }
        }

        return selectedDataList;
    }

    private List<MyData> filterDataByCategory(List<MyData> allData, int category) {
        List<MyData> filteredData = new ArrayList<>();

        for (MyData data : allData) {
            if (data.getCategory() == category) {
                filteredData.add(data);
            }
        }

        return filteredData;
    }

    public List<MyData> getAllGameData(int category) {
        // 저장된 모든 데이터 가져오기
        List<MyData> allData = dataStorage.getAllData();

        List<MyData> filteredData = new ArrayList<>();

        for (MyData data : allData) {
            if (data.getCategory() == category) {
                filteredData.add(data);
            }
        }

        return filteredData;
    }

    public List<MyData> getAllGameData() {
        // 저장된 모든 데이터 가져오기
        List<MyData> allData = dataStorage.getAllData();

        return allData;
    }
}
