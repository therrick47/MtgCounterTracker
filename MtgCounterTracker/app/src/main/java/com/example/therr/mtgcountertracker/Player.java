package com.example.therr.mtgcountertracker;

public class Player {
    public Player(String newName) {
        name = newName;
        life = 20;
    }

    public int GetLife() {
        return life;
    }

    public void IncrementLife() {
        life++;
    }

    public void DecrementLife() {
        life--;
    }

    private String name;
    private int life;

    public String GetName() {
        return name;
    }

    public String GetLifeAsString() {
        return Integer.toString(life);
    }
}
