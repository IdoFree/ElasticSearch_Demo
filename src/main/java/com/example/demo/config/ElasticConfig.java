package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Ido on 2017/7/20.
 */
@ConfigurationProperties(prefix = "spring.elastic")
@Configuration
public class ElasticConfig {
    private String host;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
