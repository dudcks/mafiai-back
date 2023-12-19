package com.mafiai.back;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackApplication {

	@Autowired
	private DataStorage dataStorage;

	@PostConstruct
	public void init() {
		// 초기 데이터를 저장`
		//id, 캐릭터 이름, (만화 제목)의 (캐릭터 이름)
		//애니
		dataStorage.saveData(new MyData( 0,1,"도라에몽", "도라에몽의 도라에몽"));
		dataStorage.saveData(new MyData(0, 2,"손오공", "드래곤볼의 손오공"));
		dataStorage.saveData(new MyData(0, 3,"아따맘마", "아따맘마의 아따맘마"));
		dataStorage.saveData(new MyData(0, 4,"코난", "명탐정 코난의 코난"));
		dataStorage.saveData(new MyData(0, 5,"짱구", "짱구는 못 말려의 짱구"));
		dataStorage.saveData(new MyData( 0,6,"스폰지밥", "보글보글 스폰지밥의 스폰지밥"));
		dataStorage.saveData(new MyData( 0,7,"나루토", "나루토의 나루토"));
		dataStorage.saveData(new MyData( 0,8,"뚱이", "보글보글 스폰지밥의 뚱이"));
		dataStorage.saveData(new MyData( 0,9,"둘리", "아기공룡 둘리의 둘리"));
		dataStorage.saveData(new MyData( 0,10,"기영이", "검정 고무신의 기영이"));
		dataStorage.saveData(new MyData( 0,11,"루피", "원피스의 루피"));
		dataStorage.saveData(new MyData( 0,12,"노진구", "도라에몽의 노진구"));
		dataStorage.saveData(new MyData( 0,13,"지우", "포켓몬스터의 지우"));
		dataStorage.saveData(new MyData( 0,14,"루나", "달빛천사의 루나"));
		dataStorage.saveData(new MyData( 0,15,"뽀로로", "뽀로로와 친구들의 뽀로로"));
		dataStorage.saveData(new MyData( 0,16,"나미", "원피스의 나미"));
		dataStorage.saveData(new MyData( 0,17,"세일러문", "세일러문의 세일러문"));
		dataStorage.saveData(new MyData( 0,18,"엘사", "겨울왕국의 엘사"));
		dataStorage.saveData(new MyData( 0,19,"올라프", "겨울왕국의 올라프"));
		dataStorage.saveData(new MyData( 0,20,"체리", "카드캡터 체리의 체리"));
		// 더 많은 초기 데이터를 추가할 수 있습니다.
		dataStorage.saveData(new MyData(1,21,"아이언맨", "어벤져스의 아이언맨"));
		dataStorage.saveData(new MyData(1,22,"잭(타이타닉)", "타이타닉의 잭"));
		dataStorage.saveData(new MyData(1,23,"마석도(범죄도시)", "범죄도시의 마석도"));
		dataStorage.saveData(new MyData(1,24,"해리 포터", "해리 포터의 해리 포터"));
		dataStorage.saveData(new MyData(1,25,"이순신", "명량의 이순신"));
		dataStorage.saveData(new MyData(1,26,"이자성(신세계)", "신세계의 이자성"));
		dataStorage.saveData(new MyData(1,27,"한치원(검사외전)", "검사외전의 한치원"));
		dataStorage.saveData(new MyData(1,28,"자홍(신과함께)", "신과함께의 자홍"));
		dataStorage.saveData(new MyData(1,29,"용구(7번방의 선물)", "7번방의 선물의 용구"));
		dataStorage.saveData(new MyData(1,30,"콘래드(킹스맨)", "킹스맨의 콘래드"));
		dataStorage.saveData(new MyData(1,31,"스파이더맨", "어벤져스의 스파이더맨"));
		dataStorage.saveData(new MyData(1,32,"덕수(국제시장)", "국제시장의 덕수"));
		dataStorage.saveData(new MyData(1,33,"고반장(극한직업)", "극한직업의 고반장"));
		dataStorage.saveData(new MyData(1,34,"서도철(베테랑)", "베테랑의 서도철"));
		dataStorage.saveData(new MyData(1,35,"안옥윤(암살)", "암살의 안옥윤"));
		dataStorage.saveData(new MyData(1,36,"쿠퍼(인터스텔라)", "인터스텔라의 쿠퍼"));
		dataStorage.saveData(new MyData(1,37,"기택(기생충)", "기생충의 기택"));
		dataStorage.saveData(new MyData(1,38,"케빈(나홀로집에)", "나홀로집에의 케빈"));
		dataStorage.saveData(new MyData(1,39,"존윅", "존윅의 존윅"));
		dataStorage.saveData(new MyData(1,40,"커티스(설국열차)", "설국열차의 커티스"));
		//
		dataStorage.saveData(new MyData(2, 41, "마스터이", "리그오브레전드의 마스터이"));
		dataStorage.saveData(new MyData(2, 42, "D.Va", "오버워치의 D.Va"));
		dataStorage.saveData(new MyData(2, 43, "아리", "리그오브레전드의 아리"));
		dataStorage.saveData(new MyData(2, 44, "가렌", "리그오브레전드의 가렌"));
		dataStorage.saveData(new MyData(2, 45, "잭스", "리그오브레전드의 잭스"));
		dataStorage.saveData(new MyData(2, 46, "카타리나", "리그오브레전드의 카타리나"));
		dataStorage.saveData(new MyData(2, 47, "메르시", "오버워치의 메르시"));
		dataStorage.saveData(new MyData(2, 48, "유미", "리그오브레전드의 유미"));
		dataStorage.saveData(new MyData(2, 49, "한조", "오버워치의 한조"));
		dataStorage.saveData(new MyData(2, 50, "겐지", "오버워치의 겐지"));
		dataStorage.saveData(new MyData(2, 51, "마리오", "슈퍼마리오의 마리오"));
		dataStorage.saveData(new MyData(2, 52, "소닉", "소닉 더 헤지혹의 소닉"));
		dataStorage.saveData(new MyData(2, 53, "팩맨", "스페이스 인베이더의 팩맨"));
		dataStorage.saveData(new MyData(2, 54, "케리건", "스타크래프트의 케리건"));
		dataStorage.saveData(new MyData(2, 55, "쿠파", "슈퍼마리오의 쿠파"));
		dataStorage.saveData(new MyData(2, 56, "루이지", "슈퍼마리오의 루이지"));
		dataStorage.saveData(new MyData(2, 57, "요시", "슈퍼마리오의 요시"));
		dataStorage.saveData(new MyData(2, 58, "링크", "The Legend of Zelda의 링크"));
		dataStorage.saveData(new MyData(2, 59, "젤다", "The Legend of Zelda의 젤다"));
		dataStorage.saveData(new MyData(2, 60, "레드", "Pokemon Red/Green의 레드"));
	}
	public static void main(String[] args) {
		SpringApplication.run(BackApplication.class, args);
	}
}
