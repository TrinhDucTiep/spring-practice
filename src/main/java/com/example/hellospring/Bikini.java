package com.example.hellospring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// Đặt tên để phân biệt với những implements của Outfit => sau đó có thể gọi bằng @Qualifier("name")
@Component("Bikini") // báo cho spring biết đây là Bean (dependency) và sẽ được Spring quản lý
//@Qualifier("Bikini")
public class Bikini implements Outfit{
    @Override
    public void wear() {
        System.out.println("Im wearing Bikini");
    }
}
