/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import BUS.Ban;
import BUS.HoaDon;
import BUS.LoaiSanPham;
import BUS.NhanVien;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;
/**
 *
 * @author USER
 */
public class DAO_QLDoanhThu {
     private Connection con;
     DAO_Pos pos= new DAO_Pos();
     DAO_Quanlynhanvien daonv = new DAO_Quanlynhanvien();
    public DAO_QLDoanhThu() {
        try {
            this.con = DataConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    
    
}
