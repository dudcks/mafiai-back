package com.mafiai.back;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackApplication {

	@Autowired
	private DataStorage dataStorage;
	private DataStorage moviedataStorage;
	private DataStorage gamedataStorage;

	@PostConstruct
	public void init() {
		// 초기 데이터를 저장`
		//id, 캐릭터 이름, (만화 제목)의 (캐릭터 이름)
		//애니
		dataStorage.saveData(new MyData( 1,"도라에몽", "도라에몽의 도라에몽"));
		dataStorage.saveData(new MyData( 2,"손오공", "드래곤볼의 손오공"));
		dataStorage.saveData(new MyData( 3,"아따맘마", "아따맘마의 아따맘마"));
		dataStorage.saveData(new MyData( 4,"코난", "명탐정 코난의 코난"));
		dataStorage.saveData(new MyData( 5,"짱구", "짱구는 못 말려의 짱구"));
		dataStorage.saveData(new MyData( 6,"스폰지밥", "보글보글 스폰지밥의 스폰지밥"));
		dataStorage.saveData(new MyData( 7,"나루토", "나루토의 나루토"));
		dataStorage.saveData(new MyData( 8,"뚱이", "보글보글 스폰지밥의 뚱이"));
		dataStorage.saveData(new MyData( 9,"둘리", "아기공룡 둘리의 둘리"));
		dataStorage.saveData(new MyData( 10,"기영이", "검정 고무신의 기영이"));
		dataStorage.saveData(new MyData( 11,"루피", "원피스의 루피"));
		dataStorage.saveData(new MyData( 12,"노진구", "도라에몽의 노진구"));
		dataStorage.saveData(new MyData( 13,"지우", "포켓몬스터의 지우"));
		dataStorage.saveData(new MyData( 14,"루나", "달빛천사의 루나"));
		dataStorage.saveData(new MyData( 15,"뽀로로", "뽀로로와 친구들의 뽀로로"));
		dataStorage.saveData(new MyData( 16,"나미", "원피스의 나미"));
		dataStorage.saveData(new MyData( 17,"세일러문", "세일러문의 세일러문"));
		dataStorage.saveData(new MyData( 18,"엘사", "겨울왕국의 엘사"));
		dataStorage.saveData(new MyData( 19,"올라프", "겨울왕국의 올라프"));
		dataStorage.saveData(new MyData( 20,"체리", "카드캡터 체리의 체리"));
		// 더 많은 초기 데이터를 추가할 수 있습니다.
		moviedataStorage.saveData(new MyData(1,"아이언맨","어밴져스의 아이언맨"));
		//
		gamedataStorage.saveData(new MyData(1,"가렌","리그오브레전드의 가렌"));
	}
	public static void main(String[] args) {
		SpringApplication.run(BackApplication.class, args);
	}
}
