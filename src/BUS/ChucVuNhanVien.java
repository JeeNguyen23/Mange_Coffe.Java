
package BUS;

public class ChucVuNhanVien {
    private String Id_ChucVu;
    private String tenChucVu;

    @Override
    public String toString() {
        return tenChucVu;
    }
    
    public String getId_ChucVu() {
        return Id_ChucVu;
    }

    public void setId_ChucVu(String Id_ChucVu) {
        this.Id_ChucVu = Id_ChucVu;
    }

    public String getTenChucVu() {
        return tenChucVu;
    }

    public void setTenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }

    public ChucVuNhanVien() {
    }

    public ChucVuNhanVien(String Id_ChucVu, String tenChucVu) {
        this.Id_ChucVu = Id_ChucVu;
        this.tenChucVu = tenChucVu;
    }
    
}
