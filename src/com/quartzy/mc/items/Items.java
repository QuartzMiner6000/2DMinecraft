package com.quartzy.mc.items;

public class Items {

    public static final Item DIRT = new Dirt();
    public static final Item SAND = new Sand();
    public static final Item BRICK = new Brick();
    public static final Item GRASS = new Grass();
    public static final Item WATER = new Water();
    public static final Item PLANK = new Plank();

    public static final Item[] items = {DIRT, SAND, BRICK, GRASS, WATER, PLANK};

    public static Item fingById(int id){
        for (Item a : items){
            if (a.getId()==id){
                return a;
            }
        }
        return null;
    }

}
