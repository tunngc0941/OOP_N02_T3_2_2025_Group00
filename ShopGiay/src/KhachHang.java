package src;

public class KhachHang {
    private String maKH;
    private String tenKH;
    private String soDienThoai;

    public KhachHang(String maKH, String tenKH, String soDienThoai) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.soDienThoai = soDienThoai;
    }

    public String getMaKH() { return maKH; }
    public String getTenKH() { return tenKH; }
    public String getSoDienThoai() { return soDienThoai; }

    @Override
    public String toString() {
        return tenKH + " - " + soDienThoai;
    }
}
