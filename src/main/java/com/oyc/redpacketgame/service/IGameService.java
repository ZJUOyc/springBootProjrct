package com.oyc.redpacketgame.service;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

public interface IGameService {
    Map<String, Object> createGame(String user_id);
}
