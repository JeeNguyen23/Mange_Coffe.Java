package DAO;

import BUS.NhanVien;
import BUS.TaiKhoanNhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO_Dangnhap {

    private Connection con;

    public DAO_Dangnhap() {
        try {
            this.con = DataConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<TaiKhoanNhanVien> getTKNV() {
        ArrayList<TaiKhoanNhanVien> listTK = new ArrayList<>();
        DAO_Quanlynhanvien daonv = new DAO_Quanlynhanvien();
        try {
            String sql = "Select * from TkNhanVien";
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                String id1 = rs.getString("ID_TaiKhoan");
                String tentk = rs.getString("Taikhoan");
                String mk = rs.getString("MatKhau");
                String manv = rs.getString("MaNV");

                NhanVien nhanvien = null;
                for (NhanVien nv : daonv.getNhanViens()) {
                    if (nv.getId_NV().equals(rs.getString("MaNV"))) {
                        nhanvien = nv;
                        break;
                    }
                }

                TaiKhoanNhanVien tknv = new TaiKhoanNhanVien(id1, tentk, mk, nhanvien);
                listTK.add(tknv);
            }
        } catch (Exception e) {
        }
        return listTK;
    }

    public int checkChucVu(String chucvu) {
        for (TaiKhoanNhanVien tk : getTKNV()) {
            if (tk.getNv().getChucVu().getTenChucVu().equals(chucvu)) {
                return 1;
            }
        }
        return 0;
    }
//    public int CheckDangNhap(String Taikhoan, String Matkhau) {
//        for (TaiKhoanNhanVien tk : getTKNV()) {
//            if (tk.getTaikhoan().equals(Taikhoan) && tk.getMatkhau().equals(Matkhau) ) {
//                return 1;
//            }
//        }
//        return 0;
//    }

    public int CheckDangNhap(String Taikhoan, String Matkhau) {
     
        for (TaiKhoanNhanVien tk : getTKNV()) {
        
            if (tk.getTaikhoan().equals(Taikhoan) && tk.getMatkhau().equals(Matkhau)) {
             
                if (tk.getNv().getChucVu().getTenChucVu().equals("Quản lý")) {
                    return 1; 
                } else {
                    return -1; 
                }
            }
        }
        return 0; 
    }
    public String layMaNV(String Taikhoan, String Matkhau) {
     
        for (TaiKhoanNhanVien tk : getTKNV()) {
        
            if (tk.getTaikhoan().equals(Taikhoan) && tk.getMatkhau().equals(Matkhau)) {
             
                return tk.getNv().getId_NV();
            }
        }
        return "Không có NV"; 
    }
}
