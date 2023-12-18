package com.mafiai.back;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataStorage {
    private List<MyData> dataList = new ArrayList<>();

    public void saveData(MyData data) {
        dataList.add(data);
    }

    public List<MyData> getAllData() {
        return dataList;
    }
}
