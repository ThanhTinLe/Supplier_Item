package DAO;

import DTO.SupplierDTO;
import Utils.myConection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ray Khum
 */
public class SupplierDAO {

    public static Vector<SupplierDTO> getSupplier() {
        Vector<SupplierDTO> result = new Vector<>();
        Connection cn = null;
        try {
            cn = myConection.makeConnection();
            if (cn != null) {
                String sql = "select supCode,supName,address,collaborating\n"
                        + "from tblSuppliers";
                PreparedStatement pst = cn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    String supCode = rs.getString("supCode");
                    String supName = rs.getString("supName");
                    String address = rs.getString("address");
                    boolean collaborating = rs.getBoolean("collaborating");
                    SupplierDTO s = new SupplierDTO(supCode, supName, address, collaborating);
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
                String sql = "select supCode,supName,address\n"
                        + "from tblSuppliers";
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

    public static int insertSupplier(String code, String Name, String Address, boolean collaborating) {
        int result = 0;
        Connection cn = null;
        try {
            cn = myConection.makeConnection();
            if (cn != null) {
                String sql = "insert tblSuppliers values(?,?,?,?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, code);
                pst.setString(2, Name);
                pst.setString(3, Address);
                pst.setBoolean(4, collaborating);
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

    public static int updateSupplier(String code, String Name, String Address, boolean collaborating) {
        int result = 0;
        Connection cn = null;
        try {
            cn = myConection.makeConnection();
            if (cn != null) {
                String sql = "UPDATE tblSuppliers\n"
                        + "SET supName =?, address =? , collaborating =? \n"
                        + "WHERE supCode = ? ";
                PreparedStatement pst = cn.prepareCall(sql);
                pst.setString(1, Name);
                pst.setString(2, Address);
                pst.setBoolean(3, collaborating);
                pst.setString(4, code);
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

    public static int deleteSupplier(String code) {
        int result = 0;
        Connection cn = null;
        try {
            cn = myConection.makeConnection();
            if (cn != null) {
                String sql = "DELETE FROM tblSuppliers WHERE supCode=?";
                PreparedStatement pst = cn.prepareCall(sql);
                pst.setString(1, code);
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

    public static ArrayList<String> checkSupCod() {
        Connection cn = null;
        ArrayList<String> list = new ArrayList<>();
        ResultSet result = null;
        PreparedStatement pst = null;
        try {
            cn = myConection.makeConnection();
            if (cn != null) {
                String sql = "SELECT tblSuppliers.supCode\n"
                        + "FROM	tblSuppliers , tblItems\n"
                        + "where  tblSuppliers.supCode = tblItems.supCode ";

                pst = cn.prepareStatement(sql);
                result = pst.executeQuery();
                while (result.next()) {
                    String supCode = result.getString("supCode");
                    list.add(supCode);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
            }
        }
        return list;
    }
}
