
package BUS;

public class SanPham {
    private String Id_sanPham;
    private String tenSanPham;
    private Double gia;
    private LoaiSanPham loaiSP;
    private String mota;
    public SanPham(){
        
    }
    public SanPham(String Id_sanPham, String tenSanPham, Double gia, LoaiSanPham loaiSP, String mota) {
        this.Id_sanPham = Id_sanPham;
        this.tenSanPham = tenSanPham;
        this.gia = gia;
        this.loaiSP = loaiSP;
        this.mota = mota;
    }

    @Override
    public String toString() {
        return tenSanPham;
    }

    public String getId_sanPham() {
        return Id_sanPham;
    }

    public void setId_sanPham(String Id_sanPham) {
        this.Id_sanPham = Id_sanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public LoaiSanPham getLoaiSP() {
        return loaiSP;
    }

    public void setLoaiSP(LoaiSanPham loaiSP) {
        this.loaiSP = loaiSP;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
    
}
