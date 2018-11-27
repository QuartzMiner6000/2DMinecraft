package com.quartzy.mc.entities.player;

import com.quartzy.mc.Assets;
import com.quartzy.mc.input.Pressed;
import com.quartzy.mc.items.ItemStack;
import com.quartzy.mc.items.Items;
import com.quartzy.mc.tiles.Tile;
import com.quartzy.mc.tiles.Tiles;
import com.quartzy.mc.util.Handler;
import com.quartzy.mc.util.Vector2;

import java.awt.*;

public class Player {

    int tileX = 1, tileY = 1;
    Handler handler;
    Inventory inventory;

    public Player(Handler handler) {
        this.handler = handler;
        inventory = new Inventory(handler);
        handler.W.addOnPressed(new Pressed() {
            @Override
            public void pressed() {
                if (!inventory.isOpened()) {
                    Tile tile = null;
                    try {
                        tile = handler.getCurrentWorld().tiles[tileY - 1][tileX];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Cannot walk there");
                    }
                    if (tile != null && tile.canWalThrough()) {
                        tileY -= 1;
                    }
                }
            }
        });
        handler.S.addOnPressed(new Pressed() {
            @Override
            public void pressed() {
                if (!inventory.isOpened()) {
                    Tile tile = null;
                    try {
                        tile = handler.getCurrentWorld().tiles[tileY + 1][tileX];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Cannot walk there");
                    }
                    if (tile != null && tile.canWalThrough()) {
                        tileY += 1;
                    }
                }
            }
        });
        handler.A.addOnPressed(new Pressed() {
            @Override
            public void pressed() {
                if (!inventory.isOpened()) {
                    Tile tile = null;
                    try {
                        tile = handler.getCurrentWorld().tiles[tileY][tileX - 1];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Cannot walk there");
                    }
                    if (tile != null && tile.canWalThrough()) {
                        tileX -= 1;
                    }
                }
            }
        });
        handler.D.addOnPressed(new Pressed() {
            @Override
            public void pressed() {
                if (!inventory.isOpened()) {
                    Tile tile = null;
                    try {
                        tile = handler.getCurrentWorld().tiles[tileY][tileX + 1];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Cannot walk there");
                    }
                    if (tile != null && tile.canWalThrough()) {
                        tileX += 1;
                    }
                }
            }
        });
        handler.UP.addOnPressed(new Pressed() {
            @Override
            public void pressed() {
                if (!inventory.isOpened() && inventory.getSelectedItem()!=null) {
                    try {
                        inventory.addItemToInventoty(new ItemStack(Items.fingById(handler.getCurrentWorld().tiles[tileY - 1][tileX].getId()), 1));
                        handler.getCurrentWorld().tiles[tileY - 1][tileX] = inventory.getSelectedItem().getItem().getTile();
                        inventory.removeItemFromInventory(new ItemStack(inventory.getSelectedItem().getItem(), 1));
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Could not place block.");
                    }
                }
            }
        });
        handler.DOWN.addOnPressed(new Pressed() {
            @Override
            public void pressed() {
                if (!inventory.isOpened() && inventory.getSelectedItem()!=null) {
                    try {
                        inventory.addItemToInventoty(new ItemStack(Items.fingById(handler.getCurrentWorld().tiles[tileY + 1][tileX].getId()), 1));
                        handler.getCurrentWorld().tiles[tileY + 1][tileX] = inventory.getSelectedItem().getItem().getTile();
                        inventory.removeItemFromInventory(new ItemStack(inventory.getSelectedItem().getItem(), 1));
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Could not place block.");
                    }
                }
            }
        });
        handler.LEFT.addOnPressed(new Pressed() {
            @Override
            public void pressed() {
                if (!inventory.isOpened() && inventory.getSelectedItem()!=null) {
                    try {
                        inventory.addItemToInventoty(new ItemStack(Items.fingById(handler.getCurrentWorld().tiles[tileY][tileX-1].getId()), 1));
                        handler.getCurrentWorld().tiles[tileY][tileX - 1] = inventory.getSelectedItem().getItem().getTile();
                        inventory.removeItemFromInventory(new ItemStack(inventory.getSelectedItem().getItem(), 1));
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Could not place block.");
                    }
                }
            }
        });
        handler.RIGHT.addOnPressed(new Pressed() {
            @Override
            public void pressed() {
                if (!inventory.isOpened() && inventory.getSelectedItem()!=null) {
                    try {
                        inventory.addItemToInventoty(new ItemStack(Items.fingById(handler.getCurrentWorld().tiles[tileY][tileX+1].getId()), 1));
                        handler.getCurrentWorld().tiles[tileY][tileX + 1] = inventory.getSelectedItem().getItem().getTile();
                        inventory.removeItemFromInventory(new ItemStack(inventory.getSelectedItem().getItem(), 1));
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Could not place block.");
                    }
                }
            }
        });
        handler.E.addOnPressed(new Pressed() {
            @Override
            public void pressed() {
                inventory.setOpened(!inventory.isOpened());
            }
        });
    }

    public void tick(){
        inventory.tick();
    }

    public void render(Graphics g){
        g.drawImage(Assets.player, tileX* Tiles.TILE_WIDTH, tileY*Tiles.TILE_HEIGHT, null);
        inventory.render(g);
    }

    public Vector2 getPosition(){
        return new Vector2(tileX, tileY);
    }

    public void setPosition(int x, int y){
        tileX = x;
        tileY = y;
    }

    public void setPosition(Vector2 pos){
        tileX = pos.getX();
        tileY = pos.getY();
    }
}
