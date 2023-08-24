package com.example.hellospring;

public class PosgreSqlConnector extends DBConnector{
    @Override
    public void connect() {
        System.out.println("Đã kết nối với PosgreSQL " + getUrl());
    }
}
