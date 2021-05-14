package com.intellij.terarosa.common;

public enum SidoCategory {
    Seoul("서울특별시"),
    Busan("부산광역시"),
    Daegu("대구광역시"),
    Incheon("인천광역시"),
    Gwangju("광주광역시"),
    Daejeon("대전광역시"),
    Ulsan("울산광역시"),
    Sejong("세종특별자치시"),
    Gyeonggi("경기도"),
    Gangwon("강원도"),
    Chungbuk("충북"),
    Chungnam("충남"),
    Jeonbuk("전북"),
    Jeonnam("전남"),
    Gyeongbuk("경북"),
    Gyeongnam("경남"),
    Jeju("제주");

    public String name;

    SidoCategory(String name) {
        this.name = name;
    }
}
