/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Ray Khum
 */
public class ItemDTO {
    String itemCode;
    String itemName ;
    String unit;
    float price;
    boolean Supplying;
    String supcode ;

    public ItemDTO(String itemCode, String itemName, String unit, float price, boolean Supplying, String supcode) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.unit = unit;
        this.price = price;
        this.Supplying = Supplying;
        this.supcode = supcode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isSupplying() {
        return Supplying;
    }

    public void setSupplying(boolean Supplying) {
        this.Supplying = Supplying;
    }

    public String getSupcode() {
        return supcode;
    }

    public void setSupcode(String supcode) {
        this.supcode = supcode;
    }

    
    
    
    
}
