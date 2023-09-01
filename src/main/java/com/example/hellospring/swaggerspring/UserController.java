//package com.example.hellospring.swaggerspring;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/vi")
//@RequiredArgsConstructor
//@Api(value = "User APIs")
//public class UserController {
//    private final UserRepository userRepository;
//
//    @ApiOperation(value = "Xem danh sách User", response = List.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Thành công"),
//            @ApiResponse(code = 401, message = "Chưa xác thực"),
//            @ApiResponse(code = 403, message = "Truy cập bị cấm"),
//            @ApiResponse(code = 404, message = "Không tìm thấy")
//    })
//    @GetMapping("/users")
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    @GetMapping("/users/{id}")
//    public User getUser(@PathVariable("id") Long id) {
//        return userRepository.findById(id).orElse(new User());
//    }
//
//    @PostMapping("/users")
//    public User createUser(@Valid @RequestBody User user) {
//        return userRepository.save(user);
//    }
//
//    @PutMapping("/users/{id}")
//    public User updateUser(@PathVariable("id") Long id, @Valid @RequestBody User user) {
//        user.setId(id);
//        return userRepository.save(user);
//    }
//
//    @DeleteMapping("/users/{id}")
//    public void deleteUser(@PathVariable("id") Long id) {
//        userRepository.deleteById(id);
//    }
//}
