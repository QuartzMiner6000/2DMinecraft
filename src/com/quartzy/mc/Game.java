package com.quartzy.mc;


import com.quartzy.mc.entities.player.Player;
import com.quartzy.mc.gfx.Display;
import com.quartzy.mc.input.KeyBinds;
import com.quartzy.mc.input.KeyListener;
import com.quartzy.mc.input.MouseManager;
import com.quartzy.mc.input.Pressed;
import com.quartzy.mc.util.Handler;
import com.quartzy.mc.worlds.World;

import javax.swing.*;

public class Game extends Thread{

    boolean running = true;
    Display display;
    public int ticks = 0;
    public static Handler handler;
    public static Player player;

    public Game(Handler handler) {
        this.handler = handler;
    }

    public void init(){
        display = Main.display;
        KeyListener keyManager = new KeyListener();
        MouseManager mouseManager = new MouseManager();
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getFrame().addMouseWheelListener(mouseManager);
        display.getCanvas().addKeyListener(keyManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseWheelListener(mouseManager);
        KeyBinds.keyBinds.add(handler.UP);
        KeyBinds.keyBinds.add(handler.DOWN);
        KeyBinds.keyBinds.add(handler.LEFT);
        KeyBinds.keyBinds.add(handler.RIGHT);
        KeyBinds.keyBinds.add(handler.W);
        KeyBinds.keyBinds.add(handler.S);
        KeyBinds.keyBinds.add(handler.A);
        KeyBinds.keyBinds.add(handler.D);
        KeyBinds.keyBinds.add(handler.ONE);
        KeyBinds.keyBinds.add(handler.TWO);
        KeyBinds.keyBinds.add(handler.THREE);
        KeyBinds.keyBinds.add(handler.FOUR);
        KeyBinds.keyBinds.add(handler.FIVE);
        KeyBinds.keyBinds.add(handler.SIX);
        KeyBinds.keyBinds.add(handler.SEVEN);
        KeyBinds.keyBinds.add(handler.EIGHT);
        KeyBinds.keyBinds.add(handler.NINE);
        KeyBinds.keyBinds.add(handler.E);
        KeyBinds.keyBinds.add(handler.CTRL);
        KeyBinds.keyBinds.add(handler.SHIFT);
        KeyBinds.keyBinds.add(handler.L);
        KeyBinds.keyBinds.add(handler.F);
        player = new Player(handler);
        handler.setCurrentWorld(new World("HelloKitty"));
        handler.F.addOnPressed(new Pressed() {
            @Override
            public void pressed() {
                if (handler.CTRL.isPressed()){
                    String name = JOptionPane.showInputDialog("Enter world name:");
                    if (name!=null) {
                        handler.saveCurrntWorld(name);
                    }
                }
            }
        });
        handler.L.addOnPressed(new Pressed() {
            @Override
            public void pressed() {
                if (handler.CTRL.isPressed()){
                    String name = JOptionPane.showInputDialog("Enter world name:");
                    if (name!=null) {
                        handler.setCurrentWorld(new World(name));
                    }
                }
            }
        });
    }

    @Override
    public void run() {
        Assets.init();
        init();
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;


        while(running){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1){
                tick();
                render();
                ticks++;
                delta--;
            }

            if(timer >= 1000000000){
                System.out.println("Tick and frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }
    }

    public void tick(){
        if (handler.getCurrentWorld()!=null) {
            handler.getCurrentWorld().tick();
        }
        player.tick();
    }

    public void render(){
        display.setB(display.getCanvas().getBufferStrategy());
        if(display.getB() == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        display.setG(display.getB().getDrawGraphics());

        display.getGraphics().clearRect(0, 0, display.getWidth(), display.getHeight());

        if (handler.getCurrentWorld()!=null) {
            handler.getCurrentWorld().render(display.getGraphics());
        }
        player.render(display.getGraphics());

        display.getB().show();
        display.getGraphics().dispose();
    }
}
