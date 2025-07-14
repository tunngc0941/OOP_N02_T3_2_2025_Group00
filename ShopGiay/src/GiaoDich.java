public class GiaoDich {
    private KhachHang khachHang;
    private SanPham sanPham;
    private int soLuongMua;

    public GiaoDich(KhachHang khachHang, SanPham sanPham, int soLuongMua) {
        this.khachHang = khachHang;
        this.sanPham = sanPham;
        this.soLuongMua = soLuongMua;
    }

    public double tinhTongTien() {
        return sanPham.getGiaBan() * soLuongMua;
    }

    public void hienThiGiaoDich() {
        System.out.println("=== GIAO DỊCH ===");
        khachHang.hienThiThongTin();
        System.out.println();
        sanPham.hienThiThongTin();
        System.out.println("Số lượng mua: " + soLuongMua);
        System.out.println("Tổng tiền: " + tinhTongTien() + " VND");
    }
}
