package com.mainapp.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mainapp.client.UserServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisComponent {

    @Autowired
    private ValueOperations<String, Object> redisOps;
    @Autowired
    private UserServiceClient userServiceClient;

    public static final Long CACHE_TIMEOUT = 30L;
    public static final String USER = "user-%s";

    public void syncUserData() throws JsonProcessingException {
        userServiceClient.fetchUsers().forEach(userDto -> redisOps.set(String.format(USER, userDto.getId()), CACHE_TIMEOUT));
    }

}
