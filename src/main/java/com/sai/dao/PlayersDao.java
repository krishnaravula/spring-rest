package com.sai.dao;

import com.sai.api.Player;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


public interface PlayersDao {


   List<Player> getAllPlayers();

   Player getPlayerById(int id);

   int getPlayerListSize();

   Player updatePlayer(int id,Player player);

   Player deletePlayer(int id);

   Player addPlayer(Player player);



}
