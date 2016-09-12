package com.persen.beijing.spEl;

/**
 * Created by persen on 16/9/12.
 */
public class Customer {
    private Item item;
    private String itemName;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "item=" + item +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}
