
package BUS;

public class HoaDon {
    private String ID_HoaDon;
    private Ban ID_Ban;
    private String NgayThanhToan;
    private double TienMonAn;
    private String phuthu;
    private double tienGiam;
    private double Tongtien;
    private String trangThai;
    private NhanVien MaNV;

    public HoaDon() {
    }

    public String getID_HoaDon() {
        return ID_HoaDon;
    }

    public void setID_HoaDon(String ID_HoaDon) {
        this.ID_HoaDon = ID_HoaDon;
    }

    public Ban getID_Ban() {
        return ID_Ban;
    }

    public void setID_Ban(Ban ID_Ban) {
        this.ID_Ban = ID_Ban;
    }

    public String getNgayThanhToan() {
        return NgayThanhToan;
    }

    public void setNgayThanhToan(String NgayThanhToan) {
        this.NgayThanhToan = NgayThanhToan;
    }

    public double getTienMonAn() {
        return TienMonAn;
    }

    public void setTienMonAn(double TienMonAn) {
        this.TienMonAn = TienMonAn;
    }

    public String getPhuthu() {
        return phuthu;
    }

    public void setPhuthu(String phuthu) {
        this.phuthu = phuthu;
    }

    public double getTienGiam() {
        return tienGiam;
    }

    public void setTienGiam(double tienGiam) {
        this.tienGiam = 0;
    }

    public double getTongtien() {
        return Tongtien;
    }

    public void setTongtien(double Tongtien) {
        this.Tongtien = Tongtien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public NhanVien getMaNV() {
        return MaNV;
    }

    public void setMaNV(NhanVien MaNV) {
        this.MaNV = MaNV;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "ID_HoaDon=" + ID_HoaDon + ", ID_Ban=" + ID_Ban + ", NgayThanhToan=" + NgayThanhToan + ", TienMonAn=" + TienMonAn + ", phuthu=" + phuthu + ", tienGiam=" + tienGiam + ", Tongtien=" + Tongtien + ", trangThai=" + trangThai + ", MaNV=" + MaNV + '}';
    }
    


    
    
}
