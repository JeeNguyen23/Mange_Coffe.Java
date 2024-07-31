
package DAO;

import BUS.NhanVien;
import BUS.TaiKhoanNhanVien;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DAO_QLTkNhanVien {
    private Connection con;

    public DAO_QLTkNhanVien() {
        try {
            this.con = DataConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<TaiKhoanNhanVien> getTkNv() throws SQLException{
        ArrayList<TaiKhoanNhanVien> listtk = new ArrayList<>();
        String sql = "select * from TkNhanVien";
         try {
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                TaiKhoanNhanVien cv = new TaiKhoanNhanVien();
                cv.setId_TaiKhoan(rs.getString("ID_TaiKhoan"));
                cv.setTaikhoan(rs.getString("Taikhoan"));
                cv.setMatkhau(rs.getString("MatKhau"));
                DAO_Quanlynhanvien daonv = new DAO_Quanlynhanvien();
                NhanVien nv1 = null;
                for(NhanVien nv : daonv.getNhanViens() ){
                    if(nv.getId_NV().equals(rs.getString("ManV"))){
                        nv1 = nv;
                        cv.setNv(nv1);
                        break;
                    }
                }
                listtk.add(cv);
                
            }
        } catch (Exception e) {
        }
           
        return listtk;
    }
    public void insertTK(String id,String taikhoan,String pass,NhanVien nv){
         String query = "insert into TkNhanVien(ID_TaiKhoan, Taikhoan, MatKhau, MaNV) values(?,?,?,?)";
        try{

            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, id);
            pst.setString(2, taikhoan);
            pst.setString(3, pass);
            pst.setString(4, nv.getId_NV());

            pst.executeUpdate();
            System.out.println("Thanh cong\n");
        } catch (Exception e) {
            System.out.println("Loi");
            e.printStackTrace();
            return;
        }
        
    }
      public int delete(String manv) {
        ArrayList<NhanVien> arr = new ArrayList<>();
        String query = "delete from TkNhanVien where ID_TaiKhoan = ?";
        try (
              Connection con = DataConnection.getConnection();) {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, manv);
            return pst.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }
}
