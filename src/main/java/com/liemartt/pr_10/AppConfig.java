package com.liemartt.pr_10;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Junior junior() {
        return new Junior();
    }
    @Bean
    public Middle middle() {
        return new Middle();
    }
    @Bean
    public Senior senior() {
        return new Senior();
    }

}
