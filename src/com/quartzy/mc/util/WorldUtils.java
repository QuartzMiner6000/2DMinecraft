package com.quartzy.mc.util;

import java.util.Random;

public class WorldUtils {

    public static int[][] generateRandomWorld(int width, int height){
        int[][] world = new int[height][width];
        Random random = new Random();
        for (int a = 0;a<world.length;a++){
            for (int b = 0;b<world[0].length;b++){
                int value = random.nextInt(300);
                if (value>200){
                    world[a][b] = 2;
                    continue;
                }
                if (value>100){
                    world[a][b] = 1;
                    continue;
                }
                world[a][b] = 0;
                continue;
            }
        }
        return world;
    }

}
