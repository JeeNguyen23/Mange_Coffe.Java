
package BUS;

public class SanPhamChuaThanhToan {
    private String idHoaDon;
    private String tenSP;
    private int SOLUONG;
    private double gia;
    private double thanhtien;
    private double TOngtien;

    public SanPhamChuaThanhToan() {
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public SanPhamChuaThanhToan(String idHoaDon, String tenSP, int SOLUONG, double gia, double thanhtien, double TOngtien) {
        this.idHoaDon = idHoaDon;
        this.tenSP = tenSP;
        this.SOLUONG = SOLUONG;
        this.gia = gia;
        this.thanhtien = thanhtien;
        this.TOngtien = TOngtien;
    }

  

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSOLUONG() {
        return SOLUONG;
    }

    public void setSOLUONG(int SOLUONG) {
        this.SOLUONG = SOLUONG;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public double getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(double thanhtien) {
        this.thanhtien = thanhtien;
    }

    public double getTOngtien() {
        return TOngtien;
    }

    public void setTOngtien(double TOngtien) {
        this.TOngtien = TOngtien;
    }

    @Override
    public String toString() {
        return "SanPhamChuaThanhToan{" + "idHoaDon=" + idHoaDon + ", tenSP=" + tenSP + ", SOLUONG=" + SOLUONG + ", gia=" + gia + ", thanhtien=" + thanhtien + ", TOngtien=" + TOngtien + '}';
    }

 
    
}
