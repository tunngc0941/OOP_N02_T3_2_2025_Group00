package src;

public class App {
    public static void main(String[] args) {
        KhachHang kh1 = new KhachHang("KH001", "Nguyễn Văn A", "0909123456");

        System.out.println("=== Thông tin khách hàng ===");
        System.out.println("Mã KH: " + kh1.getMaKH());
        System.out.println("Tên KH: " + kh1.getTenKH());
        System.out.println("SĐT: " + kh1.getSoDienThoai());
    }
}
