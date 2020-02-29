package com.liyj.demo.backup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 */
@SpringBootApplication(scanBasePackages = {"com.liyj.demo"})
public class DemoBackupApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoBackupApplication.class, args);
    }
}
