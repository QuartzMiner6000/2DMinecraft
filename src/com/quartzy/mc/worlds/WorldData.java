package com.quartzy.mc.worlds;

import java.io.Serializable;

public class WorldData implements Serializable {

    int[][] tileIds;
    String name;
    int playerX, playerY;

    public WorldData(int[][] tileIds, String name, int playerX, int playerY) {
        this.tileIds = tileIds;
        this.name = name;
        this.playerX = playerX;
        this.playerY = playerY;
    }
}
