public class App {
    public static void main(String[] args) {
        
        SanPham sp = new SanPham("SP001", "Giay the thao", "39", 200000, 5);

       
        KhachHang kh = new KhachHang("KH001", "Trần Thị B", "0987654321");

        System.out.println("=== Thông tin sản phẩm ===");
        sp.hienThiThongTin();

        System.out.println("\n=== Thông tin khách hàng ===");
        kh.hienThiThongTin();
    }
}
