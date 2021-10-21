package com.oyc.redpacketgame.controller;

import com.oyc.redpacketgame.service.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/redpacket")
public class GameController {
    @Autowired
    private IGameService iGameService;


    @RequestMapping(value = "/creategame/{user_id}")
    public Map<String, Object> createGame(@PathVariable("user_id") String user_id){
        return iGameService.createGame(user_id);
    }



}
