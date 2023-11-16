package com.tnh.messageservice;

import com.tnh.messageservice.domain.FriendMessage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class MessageServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MessageServiceApplication.class, args);
    }
    @Bean
    public CommandLineRunner load() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                FriendMessage m = new FriendMessage.Builder()
                        .fillContent("Hello")
                        .setSendId("01")
                        .setRecipientId("02")
                        .build();
            }
        };
    }
}
