package com.quartzy.mc.entities.player;

import com.quartzy.mc.Assets;
import com.quartzy.mc.input.Mouse;
import com.quartzy.mc.input.MouseWheelMoved;
import com.quartzy.mc.input.Pressed;
import com.quartzy.mc.items.ItemStack;
import com.quartzy.mc.items.Items;
import com.quartzy.mc.util.Handler;

import java.awt.*;
import java.awt.event.MouseWheelEvent;

public class Inventory {

    private ItemStack[] items = new ItemStack[27];
    private ItemStack[] itemsInHotbar = new ItemStack[9];
    private int selectedHotbarSlot = 1;
    boolean opened = false;
    private Handler handler;
    private int selectedStackIndex = 0;
    private ItemStack selectedItemStack;
    private int ShiftSelectedItemStack;

    public Inventory(Handler handler) {
        this.handler = handler;
        handler.ONE.addOnPressed(() -> {
            if (!opened) {
                selectedHotbarSlot = 1;
            }
        });
        handler.TWO.addOnPressed(() -> {
            if (!opened) {
                selectedHotbarSlot = 2;
            }
        });
        handler.THREE.addOnPressed(() -> {
            if (!opened) {
                selectedHotbarSlot = 3;
            }
        });
        handler.FOUR.addOnPressed(() -> {
            if (!opened) {
                selectedHotbarSlot = 4;
            }
        });
        handler.FIVE.addOnPressed(() -> {
            if (!opened) {
                selectedHotbarSlot = 5;
            }
        });
        handler.SIX.addOnPressed(() -> {
            if (!opened) {
                selectedHotbarSlot = 6;
            }
        });
        handler.SEVEN.addOnPressed(() -> {
            if (!opened) {
                selectedHotbarSlot = 7;
            }
        });
        handler.EIGHT.addOnPressed(() -> {
            if (!opened) {
                selectedHotbarSlot = 8;
            }
        });
        handler.NINE.addOnPressed(() -> {
            if (!opened) {
                selectedHotbarSlot = 9;
            }
        });
        Mouse.addMouseWheelEvent(new MouseWheelMoved() {
            @Override
            public void moved(MouseWheelEvent e) {
                if (e.getUnitsToScroll() < 0) {
                    selectedHotbarSlot++;
                } else {
                    selectedHotbarSlot--;
                }
                if (selectedHotbarSlot > 9) {
                    selectedHotbarSlot = 1;
                }
                if (selectedHotbarSlot < 1) {
                    selectedHotbarSlot = 9;
                }
            }
        });
        handler.W.addOnPressed(new Pressed() {
            @Override
            public void pressed() {
                if (opened && (selectedStackIndex-9 == 0 || !(selectedStackIndex-9<=0))){
                    selectedStackIndex-=9;
                }
                if (handler.SHIFT.isPressed() && opened){
                    if (ShiftSelectedItemStack<27){
                        items[ShiftSelectedItemStack] = null;
                        if (selectedStackIndex<27){
                            items[selectedStackIndex] = selectedItemStack;
                        }else {
                            itemsInHotbar[selectedStackIndex-27] = selectedItemStack;
                        }
                    }else {
                        itemsInHotbar[ShiftSelectedItemStack-27] = null;
                        if (selectedStackIndex<27){
                            items[selectedStackIndex] = selectedItemStack;
                        }else {
                            itemsInHotbar[selectedStackIndex-27] = selectedItemStack;
                        }
                    }
                }
            }
        });
        handler.S.addOnPressed(new Pressed() {
            @Override
            public void pressed() {
                if (opened && (selectedStackIndex+9 == 0 || !(selectedStackIndex+9>=36))){
                    selectedStackIndex+=9;
                }
                if (handler.SHIFT.isPressed() && opened){
                    if (ShiftSelectedItemStack<27){
                        items[ShiftSelectedItemStack] = null;
                        if (selectedStackIndex<27){
                            items[selectedStackIndex] = selectedItemStack;
                        }else {
                            itemsInHotbar[selectedStackIndex-27] = selectedItemStack;
                        }
                    }else {
                        itemsInHotbar[ShiftSelectedItemStack-27] = null;
                        if (selectedStackIndex<27){
                            items[selectedStackIndex] = selectedItemStack;
                        }else {
                            itemsInHotbar[selectedStackIndex-27] = selectedItemStack;
                        }
                    }
                }
            }
        });
        handler.D.addOnPressed(new Pressed() {
            @Override
            public void pressed() {
                if ((selectedStackIndex+1 == 0 || (selectedStackIndex+1) % 9 != 0) && opened){
                    selectedStackIndex++;
                }
                if (handler.SHIFT.isPressed() && opened){
                    if (ShiftSelectedItemStack<27){
                        items[ShiftSelectedItemStack] = null;
                        if (selectedStackIndex<27){
                            items[selectedStackIndex] = selectedItemStack;
                        }else {
                            itemsInHotbar[selectedStackIndex-27] = selectedItemStack;
                        }
                    }else {
                        itemsInHotbar[ShiftSelectedItemStack-27] = null;
                        if (selectedStackIndex<27){
                            items[selectedStackIndex] = selectedItemStack;
                        }else {
                            itemsInHotbar[selectedStackIndex-27] = selectedItemStack;
                        }
                    }
                }
            }
        });
        handler.A.addOnPressed(new Pressed() {
            @Override
            public void pressed() {
                if ((selectedStackIndex-1 == 0 || (selectedStackIndex) % 9 != 0) && opened){
                    selectedStackIndex--;
                }
                if (handler.SHIFT.isPressed() && opened){
                    if (ShiftSelectedItemStack<27){
                        items[ShiftSelectedItemStack] = null;
                        if (selectedStackIndex<27){
                            items[selectedStackIndex] = selectedItemStack;
                        }else {
                            itemsInHotbar[selectedStackIndex-27] = selectedItemStack;
                        }
                    }else {
                        itemsInHotbar[ShiftSelectedItemStack-27] = null;
                        if (selectedStackIndex<27){
                            items[selectedStackIndex] = selectedItemStack;
                        }else {
                            itemsInHotbar[selectedStackIndex-27] = selectedItemStack;
                        }
                    }
                }
            }
        });
        handler.SHIFT.addOnPressed(new Pressed() {
            @Override
            public void pressed() {
                if (opened){
                    if (selectedStackIndex<27){
                        selectedItemStack = items[selectedStackIndex];
                    }else {
                        selectedItemStack = itemsInHotbar[selectedStackIndex-27];
                    }
                    ShiftSelectedItemStack = selectedStackIndex;
                }
            }
        });
        addItemToInventoty(new ItemStack(Items.DIRT, 64));
        addItemToInventoty(new ItemStack(Items.BRICK, 64));
        addItemToInventoty(new ItemStack(Items.SAND, 64));
        addItemToInventoty(new ItemStack(Items.WATER, 64));
        addItemToInventoty(new ItemStack(Items.GRASS, 64));
        addItemToInventoty(new ItemStack(Items.PLANK, 64));
    }

    public ItemStack getSelectedItem(){
        return itemsInHotbar[selectedHotbarSlot-1];
    }

    public ItemStack[] getItems() {
        return items;
    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    public ItemStack[] getItemsInHotbar() {
        return itemsInHotbar;
    }

    public void addItemToInventoty(ItemStack itemStack){
        int spotsToChooseFromInventory = 0;
        int spotsToChooseFromHotbar = 0;
        for (int a = 0;a<itemsInHotbar.length;a++){
            if (itemsInHotbar[a]==null || itemsInHotbar[a].getItem().equals(itemStack.getItem())){
                spotsToChooseFromHotbar++;
            }
        }
        for (int a = 0;a<items.length;a++){
            if (items[a]==null || items[a].getItem().equals(itemStack.getItem())){
                spotsToChooseFromInventory++;
            }
        }
        int[] hotbarIndex = new int[spotsToChooseFromHotbar];
        int[] inventoryIndex = new int[spotsToChooseFromInventory];
        int countaaaaaa = 0;
        int countbbbbb = 0;
        for (int a = 0;a<itemsInHotbar.length;a++){
            if (itemsInHotbar[a]==null || itemsInHotbar[a].getItem().equals(itemStack.getItem())){
                hotbarIndex[countaaaaaa] = a;
                countaaaaaa++;
            }
        }
        for (int a = 0;a<items.length;a++){
            if (items[a]==null || items[a].getItem().equals(itemStack.getItem())){
                inventoryIndex[countbbbbb] = a;
                countbbbbb++;
            }
        }
        if (hotbarIndex.length == 0 && inventoryIndex.length == 0){
            return;
        }
        int leftover = itemStack.getAmmount();
        for (int a = 0;a<hotbarIndex.length;a++){
            if (itemsInHotbar[hotbarIndex[a]]!=null) {
                int amm1 = itemsInHotbar[hotbarIndex[a]].getAmmount();
                itemsInHotbar[hotbarIndex[a]].setAmmount(Math.min(leftover+itemsInHotbar[hotbarIndex[a]].getAmmount(), itemsInHotbar[hotbarIndex[a]].getItem().getMaxStackAmmount()));
                int amm2 = itemsInHotbar[hotbarIndex[a]].getAmmount();
                leftover-=(amm2-amm1);
            }else {
                itemsInHotbar[hotbarIndex[a]] = new ItemStack(itemStack.getItem(), Math.min(leftover, itemStack.getItem().getMaxStackAmmount()));
                int amm2 = itemsInHotbar[hotbarIndex[a]].getAmmount();
                leftover-=amm2;
            }
            if (leftover<=0){
                return;
            }
        }
        for (int a = 0;a<inventoryIndex.length;a++){
            if (items[inventoryIndex[a]]!=null) {
                int amm1 = items[inventoryIndex[a]].getAmmount();
                items[inventoryIndex[a]].setAmmount(Math.min(leftover+items[inventoryIndex[a]].getAmmount(), items[inventoryIndex[a]].getItem().getMaxStackAmmount()));
                int amm2 = items[inventoryIndex[a]].getAmmount();
                leftover-=(amm2-amm1);
            }else {
                items[inventoryIndex[a]] = new ItemStack(itemStack.getItem(), Math.min(leftover, itemStack.getItem().getMaxStackAmmount()));
                int amm2 = items[inventoryIndex[a]].getAmmount();
                leftover-=amm2;
            }
            if (leftover<=0){
                return;
            }
        }
    }

    public void removeItemFromInventory(ItemStack itemStack){
        int spotsToChooseFromInventory = 0;
        int spotsToChooseFromHotbar = 0;
        for (int a = 0;a<itemsInHotbar.length;a++){
            if (itemsInHotbar[a]!=null && itemsInHotbar[a].getItem().equals(itemStack.getItem())){
                spotsToChooseFromHotbar++;
            }
        }
        for (int a = 0;a<items.length;a++){
            if (items[a]!=null && items[a].getItem().equals(itemStack.getItem())){
                spotsToChooseFromInventory++;
            }
        }
        int[] hotbarIndex = new int[spotsToChooseFromHotbar];
        int[] inventoryIndex = new int[spotsToChooseFromInventory];
        int countaaaaaa = 0;
        int countbbbbb = 0;
        for (int a = 0;a<itemsInHotbar.length;a++){
            if (itemsInHotbar[a]!=null && itemsInHotbar[a].getItem().equals(itemStack.getItem())){
                hotbarIndex[countaaaaaa] = a;
                countaaaaaa++;
            }
        }
        for (int a = 0;a<items.length;a++){
            if (items[a]!=null && items[a].getItem().equals(itemStack.getItem())){
                inventoryIndex[countbbbbb] = a;
                countbbbbb++;
            }
        }
        if (hotbarIndex.length == 0 && inventoryIndex.length == 0){
            return;
        }
        int leftover = itemStack.getAmmount();
        for (int a = inventoryIndex.length-1;a>=0;a--) {
            System.out.println(a);
            int amm1 = items[hotbarIndex[a]].getAmmount();
            items[hotbarIndex[a]].setAmmount(Math.max(items[hotbarIndex[a]].getAmmount() - leftover, 0));
            int amm2 = items[hotbarIndex[a]].getAmmount();
            leftover -= (amm1 - amm2);
            if (leftover <= 0) {
                return;
            }
        }
        for (int a = hotbarIndex.length-1;a>=0;a--){
            int amm1 = itemsInHotbar[hotbarIndex[a]].getAmmount();
            itemsInHotbar[hotbarIndex[a]].setAmmount(Math.max(itemsInHotbar[hotbarIndex[a]].getAmmount()-leftover, 0));
            int amm2 = itemsInHotbar[hotbarIndex[a]].getAmmount();
            leftover-=(amm1-amm2);
            if (leftover<=0){
                return;
            }
        }
    }

    public void tick(){
        for (int a = 0;a<itemsInHotbar.length;a++){
            if (itemsInHotbar[a]!=null && itemsInHotbar[a].getAmmount()<=0){
                itemsInHotbar[a] = null;
            }
        }
        for (int a = 0;a<items.length;a++) {
            if (items[a] != null && items[a].getAmmount() <= 0) {
                items[a] = null;
            }
        }
        if (selectedStackIndex>35 || selectedStackIndex<0){
            selectedStackIndex = 0;
        }
    }

    public void render(Graphics g){
        if (opened){
            int counter1 = 0;
            int counter2 = 0;
            g.drawImage(Assets.inventory, 224, 314, null);
            for (int a = 0;a<items.length;a++){
                if (items[a]!=null){
                    g.drawImage(items[a].getItem().getTile().getImage(), 234 + (50 * counter1), 320 + (50 * counter2), 40, 40, null);
                    g.setColor(Color.WHITE);
                    g.setFont(new Font("default", Font.BOLD, 20));
                    g.drawString(items[a].getAmmount() + "", 234 + (50 * counter1)+23, 320 + (50 * counter2)+41);
                }
                counter1++;
                if (a % 9 == 0 && a != 0) {
                    counter1 = 0;
                    counter2++;
                }
            }
            for (int a = 0;a<itemsInHotbar.length;a++){
                if (itemsInHotbar[a]!=null) {
                    g.drawImage(itemsInHotbar[a].getItem().getTile().getImage(), 234 + (50 * a), 320+156, 40, 40, null);
                    g.setColor(Color.WHITE);
                    g.setFont(new Font("default", Font.BOLD, 20));
                    g.drawString(itemsInHotbar[a].getAmmount() + "", 234 + (50 * a)+23, 320+156+41);
                }
            }
            if (selectedStackIndex>26) {
                g.drawImage(Assets.inventorySlotSelected, 229 + ((selectedStackIndex % 9) * 50), 315 + ((selectedStackIndex / 9) * 50) + 6, null);
            }else {
                g.drawImage(Assets.inventorySlotSelected, 229 + ((selectedStackIndex % 9) * 50), 315 + ((selectedStackIndex / 9) * 50), null);
            }
        }else {
            g.drawImage(Assets.hotbar, 0, 0, null);
            for (int a = 0;a<itemsInHotbar.length;a++){
                if (itemsInHotbar[a]!=null) {
                    g.drawImage(itemsInHotbar[a].getItem().getTile().getImage(), 214 + (50 * a), 736, 40, 40, null);
                    g.setColor(Color.WHITE);
                    g.setFont(new Font("default", Font.BOLD, 20));
                    g.drawString(itemsInHotbar[a].getAmmount() + "", 214+23 + (50 * a), 736+41);
                }
            }
            g.drawImage(Assets.inventorySlotSelected, 209 + (50 * (selectedHotbarSlot-1)), 731, null);
        }
    }
}
