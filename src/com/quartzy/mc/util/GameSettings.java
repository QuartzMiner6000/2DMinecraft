package com.quartzy.mc.util;

import java.io.Serializable;

public class GameSettings implements Serializable {

    boolean sound;

    public GameSettings(boolean sound) {
        this.sound = sound;
    }
}
