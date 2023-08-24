package com.example.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HelloSpringApplication {

    public static void main(String[] args) {
        // Nhiệm vụ chính của Spring là tạo ra một cái Container chứa các Dependency cho chúng ta
        // ApplicationContext chính là container, chứa toàn bộ các Bean
        System.out.println("Trước khi IoC Container được khởi tạo");
        ConfigurableApplicationContext context = SpringApplication.run(HelloSpringApplication.class, args);
        System.out.println("Sau khi Ioc Container được khởi tạo");

        // Khi chạy xong, lúc này context sẽ chứa các Bean có đánh dấu là @Component
        // Mặc định thì container sẽ đi tìm tất cả các package cùng cấp hoặc cấp nhỏ hơn so với lớp chứa hàm main
        // Tuy nhiên có thể khoanh vùng phạm vi bằng 2 cách scan trong annotaion

        // Kiểm tra kết quả
//        Outfit outfit = context.getBean(Outfit.class);
//        System.out.println("Instance: " + outfit);
//        outfit.wear();

        // Thử @Autowired
        Girl girl = context.getBean(Girl.class);
        System.out.println(girl + " - " + girl.getOutfit());
        girl.getOutfit().wear();

        // Cách spring hoạt động với @Autowired (constructor -> setter -> reflection):
        // + Spring sẽ tìm xem có constructor nào dùng được không
        // + Nếu không -> tìm xem có setter nào không
        // + Nếu không -> dùng reflecttion
        // Note: @Autowired có thể được dùng cho method() và khi đó spring sẽ tự động gọi method đó và inject những bean cần thiết


        // test @PostContruct và @PreDestroy
        LifeCycleTest lifeCycleTest = context.getBean(LifeCycleTest.class);

        System.out.println("Trước khi Bean bị phá huỷ");
        context.getBeanFactory().destroyBean(lifeCycleTest);
        System.out.println("Sau khi Bean bị phá huỷ");


        // kiến trúc controller-service-repository
        /*
        + @Service: gắn với component xử lý logic
        + @Repository: gắn với component giao tiếp với DB
        => Note: về bản chất @Service & @Repository cũng giống như @Component (có thể thay thế nhau mà ko bị lỗi)
            chỉ là đặt tên khác nhau để phân biệt vai trò thôi
         */
    }

}
