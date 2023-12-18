package com.mafiai.back;

public class MyData {
    private int id;
    private String name;
    private String description;

    // 생성자
    public MyData(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // 기본 생성자
    public MyData() {
    }

    // Getter 메소드
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // Setter 메소드 (필요한 경우 추가)
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExplanation(String description) {
        this.description = description;
    }

    // toString() 메소드 (디버깅 및 출력용)
    @Override
    public String toString() {
        return "MyData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}