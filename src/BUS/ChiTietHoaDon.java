
package BUS;

public class ChiTietHoaDon {
    private HoaDon ID_HoaDon;
    private SanPham ID_SanPham;
    private int SoLuong;
    private double ThanhTien;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(HoaDon ID_HoaDon, SanPham ID_SanPham, int SoLuong, double ThanhTien) {
        this.ID_HoaDon = ID_HoaDon;
        this.ID_SanPham = ID_SanPham;
        this.SoLuong = SoLuong;
        this.ThanhTien = ThanhTien;
    }
    
    public HoaDon getID_HoaDon() {
        return ID_HoaDon;
    }

    public void setID_HoaDon(HoaDon ID_HoaDon) {
        this.ID_HoaDon = ID_HoaDon;
    }

    public SanPham getID_SanPham() {
        return ID_SanPham;
    }

    public void setID_SanPham(SanPham ID_SanPham) {
        this.ID_SanPham = ID_SanPham;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
    
   
    
}
