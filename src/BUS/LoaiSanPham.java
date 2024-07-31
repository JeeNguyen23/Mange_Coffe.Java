
package BUS;

public class LoaiSanPham {
    private String Id_SanPham;
    private String TenSanPham;
    
    public  LoaiSanPham(){
    
    }
    public LoaiSanPham(String Id_SanPham, String TenSanPham) {
        this.Id_SanPham = Id_SanPham;
        this.TenSanPham = TenSanPham;
    }

    @Override
    public String toString() {
        return TenSanPham;
    }   

    public String getId_SanPham() {
        return Id_SanPham;
    }

    public void setId_SanPham(String Id_SanPham) {
        this.Id_SanPham = Id_SanPham;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

}
