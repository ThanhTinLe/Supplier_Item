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
public class SupplierDTO {
    String code ;
    String Name ;
    String Address;
    boolean collaborating;

    public SupplierDTO(String code, String Name, String Address, boolean collaborating) {
        this.code = code;
        this.Name = Name;
        this.Address = Address;
        this.collaborating = collaborating;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public boolean isCollaborating() {
        return collaborating;
    }

    public void setCollaborating(boolean collaborating) {
        this.collaborating = collaborating;
    }
    
    
}
