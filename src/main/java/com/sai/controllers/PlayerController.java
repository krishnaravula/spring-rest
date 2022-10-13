package com.sai.controllers;

import com.sai.api.Player;
import com.sai.dao.PlayersDao;
import com.sai.exception.PlayerErrorResponse;
import com.sai.exception.PlayerNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class PlayerController {

    @Autowired
    private PlayersDao playersDao;



    @PostMapping("/players")
    public ResponseEntity<Player> postPlayer(@Valid @RequestBody Player acceptedPlayer) {

        Player response = new Player();

        playersDao.addPlayer(acceptedPlayer);
        response.setName(acceptedPlayer.getName());
        response.setId(acceptedPlayer.getId());

        return new ResponseEntity<Player>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/players/{id}")
    public ResponseEntity<Player> getPlayer(@PathVariable("id") int id) {

        if(id<0 || id> playersDao.getPlayerListSize()){
            throw new PlayerNotFound("player not found by Id: "+id);

        }

        Player response = new Player();

        response = playersDao.getPlayerById(id);

        return new ResponseEntity<Player>(response, HttpStatus.ACCEPTED);
    }


    @GetMapping("/players")
    public ResponseEntity<List<Player>> getPlayers() {


        List<Player> allPlayers = playersDao.getAllPlayers();

        return new ResponseEntity<>(allPlayers, HttpStatus.ACCEPTED);
    }


    @PutMapping("/players/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable("id") int id,@RequestBody Player acceptedPlayer) {

        if(id<0 || id> playersDao.getPlayerListSize()){
            throw new PlayerNotFound("player not found by Id: "+id);

        }

        Player response = new Player();

        response = playersDao.updatePlayer(id,acceptedPlayer);


        return new ResponseEntity<Player>(response, HttpStatus.ACCEPTED);
    }



}
