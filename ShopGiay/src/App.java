public class App {
    public static void main(String[] args) {
        KhachHang kh = new KhachHang("KH001", "Nguyễn Văn A", "0901234567");
        SanPham sp = new SanPham("SP001", "Giay bup be", "39", 150000, 20);
        GiaoDich gd = new GiaoDich(kh, sp, 3);
        gd.hienThiGiaoDich();
    }
}
