package DAO;

import BUS.Ban;
import BUS.ChucVuNhanVien;
import BUS.HoaDon;
import BUS.LoaiSanPham;
import BUS.NhanVien;
import BUS.SanPham;
import BUS.SanPhamChuaThanhToan;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;

public class DAO_Pos {

    private Connection con;

    public DAO_Pos() {
        try {
            this.con = DataConnection.getConnection();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public ArrayList<Ban> getDanhSachBan() {
        ArrayList<Ban> listBan = new ArrayList<>();
        try {
            String sql = "Select * from Ban";
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Ban ban = new Ban();
                ban.setId_Ban(rs.getString("Id_Ban"));
                ban.setTen_Ban(rs.getString("Ten_Ban"));
                ban.setViTri(rs.getString("ViTri"));
                ban.setTinhTrang(rs.getInt("TinhTrang"));
                listBan.add(ban);

            }
        } catch (Exception e) {
        }
        return listBan;
    }

    public ArrayList<LoaiSanPham> getLoaiSanPham() {
        ArrayList<LoaiSanPham> listLoai = new ArrayList<>();
        try {
            String sql = "Select * from LoaiSanPham";
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                LoaiSanPham loai = new LoaiSanPham(rs.getString("Id_LoaiSanPham"), rs.getString("Ten_LoaiSanPham"));
                listLoai.add(loai);
            }
        } catch (Exception e) {
        }
        return listLoai;
    }

    public ArrayList<SanPham> getSanPhamFromLoaiSP(String id) {
        ArrayList<SanPham> listsanpham = new ArrayList<>();
        if (!listsanpham.isEmpty()) {
            listsanpham.clear();
        }
        try {
            String sql = "SELECT * "
                    + "FROM SANPHAM sp "
                    + "WHERE sp.ID_LoaiSanPham = ?";;
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                String id1 = rs.getString("ID_SanPham");
                String ten = rs.getString("Ten_SanPham");
                double gia = rs.getDouble("Gia");
                String mota = rs.getString("Mota");
                String idLoaiSPDB = rs.getString("ID_LoaiSanPham");

                LoaiSanPham loaiSP = null;
                for (LoaiSanPham lsp : getLoaiSanPham()) {
                    if (lsp.getId_SanPham().equals(idLoaiSPDB)) {
                        loaiSP = lsp;
                        break;
                    }
                }

                SanPham sp = new SanPham(id1, ten, gia, loaiSP, mota);
                listsanpham.add(sp);
            }
        } catch (Exception e) {
        }
        return listsanpham;
    }

    public ArrayList<SanPhamChuaThanhToan> getSPCTT(String idBan) {
        ArrayList<SanPhamChuaThanhToan> listspctt = new ArrayList<>();
        String sql = "{CALL GetUnpaidOrderDetails(?)}";
        try (CallableStatement cstm = con.prepareCall(sql)) {
            cstm.setString(1, idBan);
            ResultSet rs = cstm.executeQuery();

            while (rs.next()) {
                SanPhamChuaThanhToan item = new SanPhamChuaThanhToan();
                item.setIdHoaDon(rs.getString("ID_HoaDon"));
                item.setTenSP(rs.getString("Ten_SanPham"));
                item.setSOLUONG(rs.getInt("SOLUONG"));
                item.setGia(rs.getDouble("gia"));
                item.setThanhtien(rs.getDouble("thanhtien"));
                item.setTOngtien(rs.getDouble("TONGTIEN"));
                listspctt.add(item);
            }

        } catch (Exception e) {
        }
        return listspctt;
    }

    public int insertCTHD(String hd, SanPham sp, int soluong) {
        try {
            String sql = "INSERT INTO CTHD (ID_HoaDon, ID_SanPham, SoLuong) VALUES (?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, hd);
            stmt.setString(2, sp.getId_sanPham());
            stmt.setInt(3, 2);
            return stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Loi");
            e.printStackTrace();
            return 0;
        }

    }

    public ArrayList<HoaDon> getHoaDon() {
        ArrayList<HoaDon> listhd = new ArrayList<>();
        try {
            String sql = "Select * from HoaDon";
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setID_HoaDon(rs.getString("ID_HoaDon"));
                for (Ban b : getDanhSachBan()) {
                    if (b.getId_Ban().equals(rs.getString("ID_Ban"))) {
                        hd.setID_Ban(b);

                    }

                }
                hd.setNgayThanhToan(rs.getString("NGAYHD"));
                hd.setTienMonAn(rs.getDouble("TIENMONAN"));
                hd.setPhuthu(null);
                hd.setTongtien(rs.getDouble("TONGTIEN"));
                hd.setTrangThai(rs.getString("TRANGTHAI"));
                DAO_Quanlynhanvien daonv = new DAO_Quanlynhanvien();
                for (NhanVien b : daonv.getNhanViens()) {
                    if (b.getId_NV().equals(rs.getString("MaNV"))) {
                        hd.setMaNV(b);
                    }

                }

                listhd.add(hd);

            }
        } catch (Exception e) {
        }
        return listhd;
    }

    public void insertHoaDon(String idhd, String idBan, String ngayHD, double tienMonAn, double tiengiam, String tt, String nv) {
        DAO_Quanlynhanvien daonv = new DAO_Quanlynhanvien();
        String idHD = "";
        String query = "insert into HoaDon(ID_HoaDon, ID_Ban, NGAYHD, TIENMONAN, TIENGIAM, TRANGTHAI, MaNV) values(?,?,?,?,?,?,?)";
        try (Connection con = DataConnection.getConnection(); PreparedStatement p_ID = con.prepareStatement("SELECT MAX(ID_HoaDon) FROM HoaDon"); ResultSet r_id = p_ID.executeQuery();) {
            if (r_id.next()) {
                idHD = r_id.getString(1);
            }

            int outputString = Integer.parseInt(idHD) + 1;
            String idHD1 = String.valueOf(outputString);
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, idHD1);
            pst.setString(2, idBan);
            pst.setString(3, ngayHD);
            pst.setDouble(4, tienMonAn);
            pst.setDouble(5, tiengiam);
            pst.setString(6, tt);
            NhanVien nhanvien = null;
            for (NhanVien cv : daonv.getNhanViens()) {
                if (cv.getId_NV().equals(nv)) {
                    nhanvien = cv;
                    pst.setString(7, nhanvien.getId_NV());
                    break;
                }
            }
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Loi");
            e.printStackTrace();
            return;
        }
    }

    public void thanhToan(String idHoaDon) {
        String sql = "UPDATE HoaDon SET TRANGTHAI = 'Da thanh toan' WHERE ID_HoaDon = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, idHoaDon);
            stmt.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteCTHD(String idHoaDon,String idSanPham) {
        String sql = "DELETE FROM CTHD WHERE ID_HoaDon = ? AND ID_SanPham = ?";
        try (
            PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, idHoaDon);
            stmt.setString(2, idSanPham);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Xóa chi tiết hóa đơn thành công!");
            } else {
                System.out.println("Không tìm thấy chi tiết hóa đơn cần xóa.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
