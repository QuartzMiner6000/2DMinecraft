package com.quartzy.mc.util;

import com.quartzy.mc.gfx.ImageLoader;
import com.quartzy.mc.worlds.WorldData;

import java.io.*;
import java.net.URISyntaxException;

public class FileManager {
    public static void saveWorld(String name, WorldData data){
        try {
            File file = new File(FileManager.class.getProtectionDomain().getCodeSource().getLocation().toURI());
            File file1 = new File(file.getAbsolutePath() + "\\data\\worlds\\"+name+".world");
            if (!file1.exists()){
                file1.createNewFile();
            }
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file1));
            os.writeObject(data);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static WorldData loadWorld(String name){
        try {
            File file1 = new File(FileManager.class.getProtectionDomain().getCodeSource().getLocation().toURI());
            File file = new File(file1.getAbsolutePath() + "\\data\\worlds\\" + name + ".world");
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(file));
            WorldData worldData = (WorldData) is.readObject();
            return worldData;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
