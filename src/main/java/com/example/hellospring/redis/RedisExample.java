package com.example.hellospring.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RedisExample implements CommandLineRunner {
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void run(String... args) throws Exception {
        redisTemplate.opsForValue().set("tiep", "Tiệp");
        System.out.println(redisTemplate.opsForValue().get("tiep"));
        List<String> list = new ArrayList<>();
        list.add("Trinh");
        list.add("Duc");
        list.add("Tiep");
        redisTemplate.opsForList().rightPushAll("my_list", list);
        System.out.println(redisTemplate.opsForList().size("my_list"));
    }
}
