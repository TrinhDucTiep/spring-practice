package com.example.hellospring;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

/*
1. Khi IoC Container (ApplicationContext) tìm thấy một Bean cần quản lý, nó sẽ khởi tạo bằng Constructor
2. inject dependencies vào Bean bằng Setter, và thực hiện các quá trình cài đặt khác vào Bean như setBeanName, setBeanClassLoader, v.v..
3. Hàm đánh dấu @PostConstruct được gọi
4. Tiền xử lý sau khi @PostConstruct được gọi.
5. Bean sẵn sàng để hoạt động
6. Nếu IoC Container không quản lý bean nữa hoặc bị shutdown nó sẽ gọi hàm @PreDestroy trong Bean
7. Xóa Bean.
 */

@Component
public class LifeCycleTest {
    @PostConstruct
    public void postConstruct() {
        System.out.println("Post construct được gọi sau khi Bean được tạo");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Pre destroy được gọi trước khi Bean bị phá huỷ");
    }
}
