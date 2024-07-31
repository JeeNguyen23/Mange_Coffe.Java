package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO_QLBan {

    private Connection con;

    public DAO_QLBan() {
        try {
            this.con = DataConnection.getConnection();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
    public void themBan(String idBan,String ten_Ban,String viTri,int trangthai){
        String idBan1 = "";
         String sql = "INSERT INTO Ban (ID_Ban, Ten_Ban, ViTri, TinhTrang) VALUES (?, ?, ?, ?)";
         try(Connection con = DataConnection.getConnection(); PreparedStatement p_ID = con.prepareStatement("SELECT MAX(ID_Ban) FROM Ban"); ResultSet r_id = p_ID.executeQuery();) {
             if (r_id.next()) {
                idBan1 = r_id.getString(1);
            }
            int outputString = Integer.parseInt(idBan1) + 1;
            String idHD1 = String.valueOf(outputString);
             PreparedStatement pst = con.prepareStatement(sql);
             pst.setString(1, idHD1);
             pst.setString(2,ten_Ban);
             pst.setString(3,viTri);
             pst.setInt(4, trangthai);
            int rowsDeleted = pst.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Thêm thành công!");
            } else {
                System.out.println("Không thành công.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateBan(String id,String ten_Ban,String viTri,int trangthai){
        String sql = "UPDATE Ban SET Ten_Ban = ?, ViTri = ?, TinhTrang = ? WHERE ID_Ban = ?";
        try (
            Connection con = DataConnection.getConnection();) {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, ten_Ban);
            pst.setString(2, viTri);
            pst.setInt(3, trangthai);
            pst.setString(4, id);
            int rowsDeleted = pst.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Sửa thành công!");
            } else {
                System.out.println("Không thành công.");
            }
        } catch (Exception e) {
            
        }
    }
    public void delete(String maBan) {

        String query = "DELETE from Ban where ID_Ban = ? ";
        try (
                Connection con = DataConnection.getConnection();) {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, maBan);
            int rowsDeleted = pst.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Sửa thành công!");
            } else {
                System.out.println("Không thành công.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
