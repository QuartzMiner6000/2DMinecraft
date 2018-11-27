package com.quartzy.mc;

import com.quartzy.mc.gfx.Display;
import com.quartzy.mc.input.KeyListener;
import com.quartzy.mc.input.MouseManager;
import com.quartzy.mc.util.Handler;

import java.applet.Applet;
import java.awt.*;

public class Main
//        extends Applet
{

    public static Display display;

    public static void main(String[] args){
        display = new Display(806, 829, "2DMC", new Handler());
        display.start();
    }

//    @Override
//    public void init() {
//        KeyListener keyManager = new KeyListener();
//        MouseManager mouseManager = new MouseManager();
//        addKeyListener(keyManager);
//        addMouseListener(mouseManager);
//        addMouseMotionListener(mouseManager);
//        addMouseWheelListener(mouseManager);
//        Canvas canvas = new Canvas();
//        canvas.setSize(getWidth(), getHeight());
//        add(canvas);
//        display = new Display(getWidth(), getHeight(), new Handler(), canvas);
//        display.start();
//    }
//
//    @Override
//    public void paint(Graphics g) {
//        super.paint(g);
//        display.setG(g);
//    }
}