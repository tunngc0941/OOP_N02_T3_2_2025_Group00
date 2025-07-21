import java.util.ArrayList;

public class CuaHang {
    private ArrayList<SanPham> danhSachSanPham = new ArrayList<>();
    private ArrayList<GiaoDich> danhSachGiaoDich = new ArrayList<>();

    // Thêm sản phẩm vào kho
    public void themSanPham(SanPham sanPham) {
        danhSachSanPham.add(sanPham);
        System.out.println("Đã thêm sản phẩm: " + sanPham.getTenSanPham());
    }

    // Bán sản phẩm (tạo giao dịch mới)
    public void banSanPham(KhachHang khachHang, String tenSanPham, int soLuong) {
        for (SanPham sp : danhSachSanPham) {
            if (sp.getTenSanPham().equalsIgnoreCase(tenSanPham)) {
                GiaoDich gd = new GiaoDich(khachHang, sp, soLuong);
                danhSachGiaoDich.add(gd);
                gd.inHoaDon();
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm tên: " + tenSanPham);
    }

    // Hiển thị danh sách sản phẩm trong kho
    public void hienThiSanPham() {
        System.out.println("===== DANH SÁCH SẢN PHẨM TRONG KHO =====");
        for (SanPham sp : danhSachSanPham) {
            sp.hienThiThongTin();
        }
    }

    // Hiển thị danh sách giao dịch đã thực hiện
    public void hienThiTatCaGiaoDich() {
        System.out.println("===== DANH SÁCH GIAO DỊCH =====");
        for (GiaoDich gd : danhSachGiaoDich) {
            gd.inHoaDon();
        }
    }
}
