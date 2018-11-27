package com.quartzy.mc.util;

import com.quartzy.mc.Game;
import com.quartzy.mc.entities.player.Inventory;
import com.quartzy.mc.input.KeyBind;
import com.quartzy.mc.tiles.Tile;
import com.quartzy.mc.worlds.World;
import com.quartzy.mc.worlds.WorldData;

import java.awt.event.KeyEvent;
import java.util.Arrays;

public class Handler {

    private World currentWorld;
    public static GameSettings gameSettings = new GameSettings(true);
    private Tile selectedBlock;
    public KeyBind UP = new KeyBind("UP", KeyEvent.VK_UP);
    public KeyBind DOWN = new KeyBind("DOWN", KeyEvent.VK_DOWN);
    public KeyBind LEFT = new KeyBind("LEFT", KeyEvent.VK_LEFT);
    public KeyBind RIGHT = new KeyBind("RIGHT", KeyEvent.VK_RIGHT);
    public KeyBind W = new KeyBind("W", KeyEvent.VK_W);
    public KeyBind S = new KeyBind("S", KeyEvent.VK_S);
    public KeyBind A = new KeyBind("A", KeyEvent.VK_A);
    public KeyBind D = new KeyBind("D", KeyEvent.VK_D);
    public KeyBind ONE = new KeyBind("1", KeyEvent.VK_1);
    public KeyBind TWO = new KeyBind("2", KeyEvent.VK_2);
    public KeyBind THREE = new KeyBind("3", KeyEvent.VK_3);
    public KeyBind FOUR = new KeyBind("4", KeyEvent.VK_4);
    public KeyBind FIVE = new KeyBind("5", KeyEvent.VK_5);
    public KeyBind SIX = new KeyBind("6", KeyEvent.VK_6);
    public KeyBind SEVEN = new KeyBind("7", KeyEvent.VK_7);
    public KeyBind EIGHT = new KeyBind("8", KeyEvent.VK_8);
    public KeyBind NINE = new KeyBind("9", KeyEvent.VK_9);
    public KeyBind E = new KeyBind("E", KeyEvent.VK_E);
    public KeyBind CTRL = new KeyBind("CTRL", KeyEvent.VK_CONTROL);
    public KeyBind L = new KeyBind("L", KeyEvent.VK_L);
    public KeyBind F = new KeyBind("F", KeyEvent.VK_F);
    public KeyBind SHIFT = new KeyBind("SHIFT", KeyEvent.VK_SHIFT);

    public World getCurrentWorld() {
        return currentWorld;
    }

    public void setCurrentWorld(World currentWorld) {
        this.currentWorld = currentWorld;
    }

    public void saveCurrntWorld(String name){
        int[][] tileIds = new int[40][40];
        for (int a = 0;a<currentWorld.tiles.length;a++){
            for (int b = 0;b<currentWorld.tiles[0].length;b++){
                tileIds[a][b] = currentWorld.tiles[a][b].getId();
            }
        }
        FileManager.saveWorld(name, new WorldData(tileIds, name, Game.player.getPosition().x, Game.player.getPosition().y));
    }

    public Tile getSelectedBlock() {
        return selectedBlock;
    }

    public void setSelectedBlock(Tile selectedBlock) {
        this.selectedBlock = selectedBlock;
    }
}
