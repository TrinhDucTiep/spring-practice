package com.example.hellospring;

import org.springframework.stereotype.Component;

@Component // báo cho spring biết đây là Bean (dependency) và sẽ được Spring quản lý
public class Bikini implements Outfit{
    @Override
    public void wear() {
        System.out.println("Im wearing Bikini");
    }
}
