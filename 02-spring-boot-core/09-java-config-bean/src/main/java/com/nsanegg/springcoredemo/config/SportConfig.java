package com.nsanegg.springcoredemo.config;

import com.nsanegg.springcoredemo.common.Coach;
import com.nsanegg.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
