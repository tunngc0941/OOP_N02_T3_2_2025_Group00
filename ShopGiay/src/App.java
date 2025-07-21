public class App {
     public static void main(String[] args) {
        CuaHang cuaHang = new CuaHang();

        KhachHang kh1 = new KhachHang("KH001", "Nguyen Van A", "0901234567");

        SanPham sp1 = new SanPham("SP001", "Giay Nike", 1500000);
        SanPham sp2 = new SanPham("SP002", "Giay Adidas", 1300000);

        cuaHang.themSanPham(sp1);
        cuaHang.themSanPham(sp2);

        cuaHang.hienThiSanPham();

        cuaHang.banSanPham(kh1, "Giay Nike", 2);

        cuaHang.hienThiTatCaGiaoDich();
}
