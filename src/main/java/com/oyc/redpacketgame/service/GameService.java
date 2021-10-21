package com.oyc.redpacketgame.service;

import org.redisson.api.RedissonClient;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;


@Service
public class GameService implements IGameService {

    @Autowired
    private RedissonClient redisson;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RestTemplate restTemplate;



    // 需要判断这个用户今天有没有玩过游戏，玩过了直接返回
    public Map<String, Object> createGame(String user_id) {
        Map<String, Object> resultMap = new HashMap<>();

        resultMap.put("result", true);
        resultMap.put("msg", "创建成功");
        resultMap.put("user_id", user_id);
        return resultMap;
    }


}
