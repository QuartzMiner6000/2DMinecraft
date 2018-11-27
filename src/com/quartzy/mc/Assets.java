package com.quartzy.mc;

import com.quartzy.mc.gfx.ImageLoader;

import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class Assets {

    public static BufferedImage player;
    public static BufferedImage dirt;
    public static BufferedImage sand;
    public static BufferedImage brick;
    public static BufferedImage hotbar;
    public static BufferedImage inventory;
    public static BufferedImage inventorySlot;
    public static BufferedImage inventorySlotSelected;
    public static BufferedImage water;
    public static BufferedImage plank;
    public static BufferedImage grass;

    public static void init(){
        player = ImageLoader.loadImage("/player.png");
        dirt = ImageLoader.loadImage("/dirt.png");
        sand = ImageLoader.loadImage("/sand.png");
        brick = ImageLoader.loadImage("/brick.png");
        hotbar = ImageLoader.loadImage("/hotbar.png");
        inventory = ImageLoader.loadImage("/inventory.png");
        inventorySlot = ImageLoader.loadImage("/inventorySlot.png");
        inventorySlotSelected = ImageLoader.loadImage("/inventorySlotSelected.png");
        water = ImageLoader.loadImage("/water.png");
        plank = ImageLoader.loadImage("/plank.png");
        grass = ImageLoader.loadImage("/grass.png");
    }
}
