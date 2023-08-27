package com.example.hellospring.jpa_mysql;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user")
public class User implements Serializable {
    /*
    erialVersionUID cùng với tên lớp sẽ được sử dụng để tạo ra một mã hash, từ đó xác định phiên bản
    của lớp trong quá trình serialization. Khi deserialization, mã hash này được so sánh với phiên bản
     của lớp hiện tại để đảm bảo tính thống nhất.
     */
    private static final long serialVersionUID = -297553281792804396L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Mapping tên biến với thông tin cột
    @Column(name = "hp")
    private int hp;
    @Column(name = "stamina")
    private int stamina;

    // Nếu không đánh dấu @Column sẽ mapping tự động theo tên biến
    private int atk;
    private int def;
    private int agi;

}
