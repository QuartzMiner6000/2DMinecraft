package com.quartzy.mc.worlds;

import com.quartzy.mc.Game;
import com.quartzy.mc.tiles.Tile;
import com.quartzy.mc.tiles.Tiles;
import com.quartzy.mc.util.FileManager;

import java.awt.*;

public class World {
    public Tile[][] tiles;
    public String worldName;

    public World(String worldName) {
        this.worldName = worldName;
        WorldData worldData = FileManager.loadWorld(worldName);
        tiles = new Tile[worldData.tileIds.length][worldData.tileIds[0].length];
        for (int a = 0;a<tiles.length;a++){
            for (int b = 0;b<tiles[0].length;b++){
                tiles[a][b] = Tiles.findById(worldData.tileIds[a][b]);
            }
        }
        Game.player.setPosition(worldData.playerX, worldData.playerY);
    }

    public void tick(){
        for (int a = 0;a<tiles.length;a++){
            for (int b = 0;b<tiles[0].length;b++){
                tiles[a][b].tick();
            }
        }
    }

    public void render(Graphics g){
        for (int a = 0;a<tiles.length;a++){
            for (int b = 0;b<tiles[0].length;b++){
                tiles[a][b].render(g, b*Tiles.TILE_WIDTH, a*Tiles.TILE_HEIGHT);
            }
        }
    }
}