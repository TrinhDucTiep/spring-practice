package com.example.hellospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Girl {
    // nói với Spring Boot hãy tự inject (tiêm) một instance của Outfit vào thuộc tính này khi khởi tạo Girl
    @Autowired
    @Qualifier("Bikini") // có thể đặt @Qualifier("name") cho method, constructor và field, còn Component có thể đặt name trong @Component("name")
    private Outfit outfit;

    public Girl() {
    }

    public Girl(Outfit outfit) {
        this.outfit = outfit;
    }

    public Outfit getOutfit() {
        return outfit;
    }

    public void setOutfit(Outfit outfit) {
        this.outfit = outfit;
    }
}
