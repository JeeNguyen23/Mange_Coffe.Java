package DAO;

import BUS.LoaiSanPham;
import BUS.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.xml.transform.Result;

public class DAO_Quanlysanpham {

    private Connection con;

    public DAO_Quanlysanpham() {
        try {
            this.con = DataConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<LoaiSanPham> get_loaisanpham() {
        ArrayList<LoaiSanPham> loaisanpham = new ArrayList<>();
        try {
            String sql = "select * from LoaiSanPham";
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                LoaiSanPham loai = new LoaiSanPham();
                loai.setId_SanPham(rs.getString("ID_LoaiSanPham"));
                loai.setTenSanPham(rs.getString("Ten_LoaiSanPham"));
                loaisanpham.add(loai);
            }
        } catch (Exception e) {
        }
        return loaisanpham;
    }

    public ArrayList<SanPham> get_sanpham() {
        ArrayList<SanPham> listsanpham = new ArrayList<>();
        try {
            String sql = "select * from SanPham order by CONVERT(INT,ID_SanPham) ASC";
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setId_sanPham(rs.getString("ID_SanPham"));
                sp.setTenSanPham(rs.getString("Ten_SanPham"));
                sp.setGia(rs.getDouble("Gia"));
                sp.setMota(rs.getString("MoTa"));
                String idloaisp = rs.getString("ID_LoaiSanPham");
                LoaiSanPham lsp = null;
                for (LoaiSanPham loai : get_loaisanpham()) {
                    if (loai.getId_SanPham().equals(idloaisp)) {
                        lsp = loai;
                        break;
                    }
                }
                sp.setLoaiSP(lsp);
                listsanpham.add(sp);
            }
        } catch (Exception e) {
        }
        return listsanpham;
    }

    public int insert(String masp, String tensp, double gia, String tenloai, String mota) {
        String sql = "insert into SanPham values (?,?,?,?,?)";
        try (Connection con = DataConnection.getConnection();) {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, masp);
            pstm.setString(2, tensp);
            pstm.setDouble(3, gia);
            pstm.setString(5, mota);
            LoaiSanPham loaisp = null;
            for (LoaiSanPham loai : get_loaisanpham()) {
                if (loai.getTenSanPham().equals(tenloai)) {
                    loaisp = loai;
                    pstm.setString(4, loaisp.getId_SanPham());
                    break;
                }
            }
            return pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Loi");
            e.printStackTrace();
            return 0;
        }
    }

    public int delete(String masp) {
        ArrayList<SanPham> sp = new ArrayList<>();
        String sql = "Delete from SanPham where ID_SanPham = ?";
        try (Connection con = DataConnection.getConnection();) {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, masp);
            return pstm.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    public int update(String masp, String tensp, double gia, String tenloai, String mota) {
        ArrayList<SanPham> sp = new ArrayList<>();
        String sql = "update SanPham set Ten_SanPham = ?, Gia = ?, ID_LoaiSanPham = ?,MoTa = ? where ID_SanPham = ? ";
        try (Connection con = DataConnection.getConnection()) {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(5, masp);
            LoaiSanPham loai = null;
            for (LoaiSanPham loaisp : get_loaisanpham()) {
                if (loaisp.getTenSanPham().equals(tenloai)) {
                    loai = loaisp;
                    pstm.setString(3, loai.getId_SanPham());
                    break;
                }
            }
            pstm.setString(1, tensp);
            pstm.setDouble(2, gia);
            pstm.setString(4, mota);
            return pstm.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }
}
