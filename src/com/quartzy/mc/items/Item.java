package com.quartzy.mc.items;

import com.quartzy.mc.tiles.Tile;
import com.quartzy.mc.tiles.Tiles;

import java.awt.image.BufferedImage;
import java.util.Objects;

public abstract class Item {

    private int maxStackAmmount;
    private BufferedImage texture;
    private int id;

    public Item(int maxStankAmmount, Tile tile) {
        this.maxStackAmmount = maxStankAmmount;
        this.texture = tile.getImage();
        this.id = tile.getId();
    }

    public Item(int maxStankAmmount, int id, BufferedImage texture) {
        this.maxStackAmmount = maxStankAmmount;
        this.texture = texture;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return getMaxStackAmmount() == item.getMaxStackAmmount() &&
                getId() == item.getId() &&
                Objects.equals(texture, item.texture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaxStackAmmount(), texture, getId());
    }

    public int getMaxStackAmmount() {
        return maxStackAmmount;
    }

    public Tile getTile() {
        return Tiles.findById(id);
    }

    public int getId() {
        return id;
    }
}
