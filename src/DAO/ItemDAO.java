/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ItemDTO;
import Utils.myConection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

/**
 *
 * @author Ray Khum
 */
public class ItemDAO {

    public static Vector<ItemDTO> getItem() {
        Vector<ItemDTO> result = new Vector<>();
        Connection cn = null;
        try {
            cn = myConection.makeConnection();
            if (cn != null) {
                String sql = "Select itemCode,itemName,unit,price,supplying,supCode\n"
                        + "from tblItems";
                PreparedStatement pst = cn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    String itemCode = rs.getString("itemCode");
                    String itemName = rs.getString("itemName");
                    String unit = rs.getString("unit");
                    float price = rs.getFloat("price");
                    boolean supplying = rs.getBoolean("supplying");
                    String supCode = rs.getString("supCode");
                    ItemDTO s = new ItemDTO(itemCode, itemName, unit, price, supplying, supCode);
                    result.add(s);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static Vector<String> getColumNames() {
        Vector<String> header = new Vector<>();
        Connection cn = null;
        try {
            cn = myConection.makeConnection();
            if (cn != null) {
                String sql = "Select itemCode,itemName,tblItems.supCode+'-'+tblSuppliers.supName Supplier,unit,price,supplying\n"
                        + "from tblItems  , tblSuppliers\n"
                        + "where  tblItems.supCode=tblSuppliers.supCode";
                PreparedStatement pst = cn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                ResultSetMetaData meta = rs.getMetaData();//lay cau truc bang trong database
                for (int i = 1; i <= meta.getColumnCount(); i++) {

                    header.add(meta.getColumnName(i));

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return header;
    }

    public static int saveItem(String itemCode, String itemName, String unit, float price, boolean Supplying, String supcode) {
        int result = 0;
        Connection cn = null;
        try {
            cn = myConection.makeConnection();
            if (cn != null) {
                String sql = "insert tblItems values(?,?,?,?,?,?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, itemCode);
                pst.setString(2, itemName);
                pst.setString(3, unit);
                pst.setFloat(4, price);
                pst.setBoolean(5, Supplying);
                pst.setString(6, supcode);

                result = pst.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static int deleteItem(String itemCode) {
        int result = 0;
        Connection cn = null;
        try {
            cn = myConection.makeConnection();
            if (cn != null) {
                String sql = "DELETE tblItems WHERE itemCode =?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, itemCode);
                result = pst.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static int updateItem(String itemCode, String itemName, String unit, float price, boolean Supplying, String supcode) {
        int result = 0;
        Connection cn = null;
        try {
            cn = Utils.myConection.makeConnection();
            if (cn != null) {
                String sql = "UPDATE tblItems \n"
                        + "SET itemName =?, unit =?, price=?, supplying = ?, supCode=?\n"
                        + "WHERE itemCode=?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, itemName);
                pst.setString(2, unit);
                pst.setFloat(3, price);
                pst.setBoolean(4, Supplying);
                pst.setString(5, supcode);
                pst.setString(6, itemCode);
                result = pst.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(cn!=null){
                cn.close();
            }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
