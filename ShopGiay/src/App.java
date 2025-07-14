public class App {
    public static void main(String[] args) {
        // Tạo khách hàng
        KhachHang kh = new KhachHang("KH001", "Nguyễn Văn A", "0901234567");

        // Tạo sản phẩm
        SanPham sp = new SanPham("SP001", "Giay bup be", "39", 150000, 20);

        // Tạo giao dịch: khách hàng mua 3 sản phẩm
        GiaoDich gd = new GiaoDich(kh, sp, 3);
        gd.hienThiGiaoDich();
    }
}
