package com.sai.dao;

import com.sai.api.Player;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PlayersDaoImpl implements PlayersDao {

    private List<Player> playerList;


    @PostConstruct
    public void setupPlayer() {
        System.out.println("Post Construct method is called");
        playerList =new ArrayList<>();

        Player player1 = new Player();
        player1.setId(33);
        player1.setName("Max");
        player1.setType("F1 Driver");

        Player player2 = new Player();
        player2.setId(3);
        player2.setName("Daniel");
        player2.setType("F1 Driver");

        Player player = new Player();
        player.setId(62);
        player.setName("Russel");
        player.setType("F1 Driver");

        playerList.add(player);
        playerList.add(player1);
        playerList.add(player2);
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerList;
    }

    @Override
    public Player getPlayerById(int id) {
        return playerList.get(id);
    }

    @Override
    public int getPlayerListSize() {
        return playerList.size();
    }

    @Override
    public Player updatePlayer(@PathVariable int id,@RequestBody Player acceptedPlayer) {
        Player player = playerList.get(--id);
        player.setName(acceptedPlayer.getName());
        player.setType(acceptedPlayer.getType());
        return player;
    }

    @Override
    public Player deletePlayer(int id) {
        return null;
    }

    @Override
    public Player addPlayer(Player player) {
        playerList.add(player);
        return player;
    }


}
