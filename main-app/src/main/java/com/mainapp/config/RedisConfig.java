package com.mainapp.config;

import org.apache.commons.lang.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfig {
    @Value("${app.redis.host}")
    private String redisHost;

    @Value("${app.redis.password}")
    private String redisPass;

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();

        SingleServerConfig server = config.useSingleServer();
        server.setAddress(this.redisHost);

        if (StringUtils.isNotEmpty(this.redisPass)) {
            server.setPassword(this.redisPass);
        }

        return Redisson.create(config);
    }
}
