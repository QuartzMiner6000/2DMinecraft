package com.quartzy.mc.tiles;

import com.quartzy.mc.Game;
import com.quartzy.mc.util.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Tile {

    boolean canWalThrough;
    BufferedImage image;
    int id;
    private Handler handler;

    public Tile(boolean canWalThrough, BufferedImage image, int id) {
        this.canWalThrough = canWalThrough;
        this.image = image;
        this.id = id;
        this.handler = Game.handler;
    }

    public void tick(){

    }

    public void render(Graphics g, int x, int y){
        g.drawImage(image, x, y, null);
    }

    public boolean canWalThrough() {
        return canWalThrough;
    }

    public BufferedImage getImage() {
        return image;
    }

    public int getId() {
        return id;
    }
}