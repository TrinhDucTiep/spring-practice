package com.example.hellospring.jpa_mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> { // bảng dữ liệu & kiểu dữ liệu của primary key trong bảng
}
