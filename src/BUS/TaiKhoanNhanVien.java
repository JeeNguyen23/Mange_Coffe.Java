
package BUS;

public class TaiKhoanNhanVien {
    private String id_TaiKhoan;
    private String taikhoan;
    private String matkhau;
    private NhanVien nv;

    public TaiKhoanNhanVien(String id_TaiKhoan, String taikhoan, String matkhau, NhanVien nv) {
        this.id_TaiKhoan = id_TaiKhoan;
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
        this.nv = nv;
    }

    public TaiKhoanNhanVien() {
    }

    public String getId_TaiKhoan() {
        return id_TaiKhoan;
    }

    public void setId_TaiKhoan(String id_TaiKhoan) {
        this.id_TaiKhoan = id_TaiKhoan;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public NhanVien getNv() {
        return nv;
    }

    public void setNv(NhanVien nv) {
        this.nv = nv;
    }

    @Override
    public String toString() {
        return "TaiKhoanNhanVien{" + "id_TaiKhoan=" + id_TaiKhoan + ", taikhoan=" + taikhoan + ", matkhau=" + matkhau + ", nv=" + nv + '}';
    }
    
}
