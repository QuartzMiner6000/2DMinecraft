package com.quartzy.mc;

import com.quartzy.mc.util.FileManager;
import com.quartzy.mc.worlds.WorldData;

public class Tester {

    public static void main(String[] args){
        int[][] tileIds = new int[40][40];
        FileManager.saveWorld("HelloKitty", new WorldData(tileIds, "HelloKitty", 1, 1));
    }

}
