package com.quartzy.mc.tiles;

public class Tiles {

    public static final Tile DIRT = new Dirt();
    public static final Tile SAND = new Sand();
    public static final Tile BRICK = new Brick();
    public static final Tile GRASS = new Grass();
    public static final Tile PLANK = new Plank();
    public static final Tile WATER = new Water();
    public static final int TILE_WIDTH = 20, TILE_HEIGHT = 20;

    public static Tile[] tiles = {DIRT, SAND, BRICK, GRASS, PLANK, WATER};

    public static Tile findById(int id){
        for (int a = 0;a<tiles.length;a++){
            if (tiles[a].id==id){
                return tiles[a];
            }
        }
        return null;
    }

}
