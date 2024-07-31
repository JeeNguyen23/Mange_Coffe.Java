
package BUS;

public class Ban {
    private String Id_Ban;
    private String ten_Ban;
    private String viTri;
    private int tinhTrang;


    public Ban() {
    }

  
    public Ban(String Id_Ban, String ten_Ban, String viTri, int tinhTrang) {
        this.Id_Ban = Id_Ban;
        this.ten_Ban = ten_Ban;
        this.viTri = viTri;
        this.tinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        return "Ban{" + "Id_Ban=" + Id_Ban + ", ten_Ban=" + ten_Ban + ", viTri=" + viTri + ", tinhTrang=" + tinhTrang + '}';
    }

   

    public String getId_Ban() {
        return Id_Ban;
    }

    public void setId_Ban(String Id_Ban) {
        this.Id_Ban = Id_Ban;
    }

    public String getTen_Ban() {
        return ten_Ban;
    }

    public void setTen_Ban(String ten_Ban) {
        this.ten_Ban = ten_Ban;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

  
    
    
}
