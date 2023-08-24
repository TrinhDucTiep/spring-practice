package com.example.hellospring;

public class MySqlConnector  extends DBConnector{
    @Override
    public void connect() {
        System.out.println("Đã kết nối với MySQL " + getUrl());
    }
}
