
package BUS;

public class NhanVien {
    private String Id_NV;
    private String ten_NV;
    private String ngaySinh;
    private String cccd;
    private String sdt;
    private String gioiTinh;
    private ChucVuNhanVien chucVu;

    public NhanVien(String Id_NV, String ten_NV, String ngaySinh, String cccd, String sdt, String gioiTinh, ChucVuNhanVien chucVu) {
        this.Id_NV = Id_NV;
        this.ten_NV = ten_NV;
        this.ngaySinh = ngaySinh;
        this.cccd = cccd;
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
        this.chucVu = chucVu;
    }

    public NhanVien() {
    }

    @Override
    public String toString() {
        return ten_NV;
    }

    public String getId_NV() {
        return Id_NV;
    }

    public void setId_NV(String Id_NV) {
        this.Id_NV = Id_NV;
    }

    public String getTen_NV() {
        return ten_NV;
    }

    public void setTen_NV(String ten_NV) {
        this.ten_NV = ten_NV;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public ChucVuNhanVien getChucVu() {
        return chucVu;
    }

    public void setChucVu(ChucVuNhanVien chucVu) {
        this.chucVu = chucVu;
    }
    
}
