package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/")
	public ResponseEntity<String> index() {
		return ResponseEntity.ok("Hello World - API đang hoạt động!");
	}

	@GetMapping("/ping")
	public ResponseEntity<String> ping() {
		return ResponseEntity.ok("Pong! Server đang chạy");
	}

	@GetMapping("/time")
	public ResponseEntity<String> getTime() {
		return ResponseEntity.ok("Thời gian hiện tại: " + System.currentTimeMillis());
	}

	@GetMapping("/health")
	public ResponseEntity<String> health() {
		return ResponseEntity.ok("Server khỏe mạnh!");
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e) {
		return ResponseEntity.internalServerError()
				.body("Có lỗi xảy ra: " + e.getMessage());
	}
}
