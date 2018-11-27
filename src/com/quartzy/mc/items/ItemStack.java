package com.quartzy.mc.items;

public class ItemStack {

    private Item item;
    private int ammount;

    public ItemStack(Item item, int ammount) {
        this.item = item;
        this.ammount = ammount;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }
}
