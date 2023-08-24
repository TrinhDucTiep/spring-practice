package com.example.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
Ngoài nhiệm vụ đi tìm @Component, thì Spring còn phải đi tìm @Configuration
1. Đi tìm class có đánh dấu @Configuration
2. Tạo ra đối tượng từ class có đánh dấu @Configuration
3. Tìm các method có đánh dấu @Bean trong đối tượng vừa tạo
4. Thực hiện gọi các method có đánh dấu @Bean để lấy ra các Bean và đưa vào `Context.
=> Note: Thường thì nếu mình muốn tự config hàm tạo ra Bean để đưa vào container (vì phức tạp, ...) thì có thể dùng cái này
    (@Configure thực ra cũng giống như @Component chỉ là khác tên để thể hiện vai trò khác nhau)
 */
@Configuration
public class AppConfig {
    /*
    Ở đây AppConfig sẽ được tạo và đưa vào context, còn khi nào cần các đối tượng của method thì spring lúc đó mới gọi sau
     */

    @Bean("MySqlConfigure")
    public DBConnector mySqlConfigure() {
        DBConnector mySqlConnector = new MySqlConnector();
        mySqlConnector.setUrl("https://mysql.db.com");
        return mySqlConnector;
    }

    @Bean("PosgreSqlConfigure")
    public DBConnector posGreConfigure() {
        DBConnector posgreSqlConnector = new PosgreSqlConnector();
        posgreSqlConnector.setUrl("https://posgreSql.db.com");
        return posgreSqlConnector;
    }

}
