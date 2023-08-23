package com.example.hellospring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("Naked")
//@Qualifier("Naked")
//@Primary // cái này sẽ được ưu tiên khi spring không biết chọn Bikini hay Naked
public class Naked implements Outfit{
    @Override
    public void wear() {
        System.out.println("Im naked, you can do whatever you want");
    }
}
