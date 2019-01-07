package com.example.therr.mtgcountertracker;

import java.util.ArrayList;
import java.util.List;

public  class GameData {
    public GameData(){
        playerList= new ArrayList<Player>();
        playerList.add( new Player("Player 1"));
        playerList.add(new Player("Player 2"));


    }
    public static ArrayList<Player> playerList;
    public static  void SetupPlayerList(int numPlayers){
        playerList= new ArrayList<>();
        for(int a=1;a<=numPlayers;a++){
            playerList.add(new Player(("Player "+a)));
        }
    }

    public static void AddPlayer() {
         playerList.add(new Player("Player "+playerList.size()));
    }

    public static void RemoveLastPlayer() {
        playerList.remove(playerList.size()-1);
    }
}
