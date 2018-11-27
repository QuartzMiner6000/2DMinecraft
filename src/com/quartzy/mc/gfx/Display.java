package com.quartzy.mc.gfx;

import com.quartzy.mc.Game;
import com.quartzy.mc.util.Handler;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Display {
    private int width;
    private int height;
    private String title;
    private JFrame jFrame;
    private Graphics g;
    private BufferStrategy b;
    private Handler handler;
    private Canvas canvas;

    public Display(int width, int height, String title, Handler handler) {
        this.width = width;
        this.height = height;
        this.title = title;
        this.handler = handler;
    }

    public void start(){
        jFrame = new JFrame(title);
        canvas = new Canvas();
        canvas.setSize(width, height);
        jFrame.setSize(width, height);
        jFrame.add(canvas);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        g = canvas.getGraphics();
        jFrame.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-jFrame.getWidth()/2, Toolkit.getDefaultToolkit().getScreenSize().height/2-jFrame.getHeight()/2-20);
        Game gameLoop = new Game(handler);
        gameLoop.start();
    }

    //Getters and setters

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getTitle() {
        return title;
    }

    public JFrame getFrame() {
        return jFrame;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public Graphics getGraphics() {
        return g;
    }

    public BufferStrategy getB() {
        return b;
    }

    public void setB(BufferStrategy b) {
        this.b = b;
    }

    public void setG(Graphics g) {
        this.g = g;
    }
}
