package DAO;

import BUS.ChucVuNhanVien;
import BUS.LoaiSanPham;
import BUS.NhanVien;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class DAO_Quanlynhanvien {

    private Connection con;

    public DAO_Quanlynhanvien() {
        try {
            this.con = DataConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ChucVuNhanVien> getchucvu() {
        ArrayList<ChucVuNhanVien> chucvu = new ArrayList<>();
        try {
            String sql = "select * from ChucVuNhanVien";
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                ChucVuNhanVien cv = new ChucVuNhanVien();
                cv.setId_ChucVu(rs.getString("ID_ChucVu"));
                cv.setTenChucVu(rs.getString("TenChucVu"));
                chucvu.add(cv);
            }
        } catch (Exception e) {
        }
        return chucvu;
    }

    public ArrayList<NhanVien> getNhanViens() {
        ArrayList<NhanVien> listnv = new ArrayList<>();
        try {
            String sql = "select * from NhanVien";
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setId_NV(rs.getString("MaNV"));
                nv.setTen_NV(rs.getString("TenNV"));
                nv.setNgaySinh(rs.getDate("NgaySinh").toString());
                nv.setCccd(rs.getString("cccd"));
                nv.setSdt(rs.getString("sdt"));
                nv.setGioiTinh(rs.getString("GioiTinh"));
                String idchucvu = rs.getString("ID_ChucVu");
                ChucVuNhanVien chucvu = null;
                for (ChucVuNhanVien cv : getchucvu()) {
                    if (cv.getId_ChucVu().equals(idchucvu)) {
                        chucvu = cv;
                        break;
                    }
                }
                nv.setChucVu(chucvu);
                listnv.add(nv);

            }
        } catch (Exception e) {
        }
        return listnv;
    }

    public int insert(String manv, String tennv, String Ngaysinh, String cccd, String sdt, String gioitinh, String tenchucvu) {
        ArrayList<NhanVien> nv = new ArrayList<>();
        String query = "insert into NhanVien values(?,?,?,?,?,?,?)";
        try (Connection con = DataConnection.getConnection();) {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, manv);
            pst.setString(2, tennv);
            pst.setString(3, Ngaysinh);
            pst.setString(4, cccd);
            pst.setString(5, sdt);
            pst.setString(6, gioitinh);
            ChucVuNhanVien chucvu = null;
            for (ChucVuNhanVien cv : getchucvu()) {
                if (cv.getTenChucVu().equals(tenchucvu)) {
                    chucvu = cv;
                    pst.setString(7, chucvu.getId_ChucVu());
                    break;
                }
            }
            return pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Loi");
            e.printStackTrace();
            return 0;
        }
    }

    public int delete(String manv) {
        ArrayList<NhanVien> arr = new ArrayList<>();
        String query = "DELETE from NhanVien where MaNV= ? ";
        try (
                Connection con = DataConnection.getConnection();) {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, manv);
            return pst.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    public int update(String manv, String tennv, String Ngaysinh, String cccd, String sdt, String gioitinh, String tenchucvu) {
        ArrayList<NhanVien> arr = new ArrayList<>();
        String query = "Update NhanVien set TenNV = ?, NgaySinh = ?,cccd = ?,sdt = ?,GioiTinh = ?,ID_ChucVu = ? where MaNV = ? ";
        try (
                Connection con = DataConnection.getConnection();) {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, tennv);
            pst.setString(2, Ngaysinh);
            pst.setString(3, cccd);
            pst.setString(4, sdt);
            pst.setString(5, gioitinh);
            ChucVuNhanVien chucvu = null;
            for (ChucVuNhanVien cv : getchucvu()) {
                if (cv.getTenChucVu().equals(tenchucvu)) {
                    chucvu = cv;
                    pst.setString(6, chucvu.getId_ChucVu());
                    break;
                }
            }
            pst.setString(7, manv);
            return pst.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }
}
