package com.zzpzaf.restapidemo.dataObjects;

public class Item {
    
    private int itemId;
    private String itemName;
    private int itemVendorId;
    private int itemModelYear;
    private Number itemListPrice;

    public Item() {};

    public Item(int itemId, String itemName, int itemVendorId, int itemModelYear, Number itemListPrice) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemVendorId = itemVendorId;
        this.itemModelYear = itemModelYear;
        this.itemListPrice = itemListPrice;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemVendorId() {
        return itemVendorId;
    }

    public void setItemVendorId(int itemVendorId) {
        this.itemVendorId = itemVendorId;
    }

    public int getItemModelYear() {
        return itemModelYear;
    }

    public void setItemModelYear(int itemModelYear) {
        this.itemModelYear = itemModelYear;
    }

    public Number getItemListPrice() {
        return itemListPrice;
    }

    public void setItemListPrice(Number itemListPrice) {
        this.itemListPrice = itemListPrice;
    }

    @Override
    public String toString() {
        return "Items [itemId=" + itemId + ", itemListPrice=" + itemListPrice + ", itemModelYear=" + itemModelYear
                + ", itemName=" + itemName + ", itemVendorId=" + itemVendorId + "]";
    }

    

}
