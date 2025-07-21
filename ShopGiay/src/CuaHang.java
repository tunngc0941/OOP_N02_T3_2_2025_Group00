import java.util.ArrayList;

public class CuaHang {
    private ArrayList<SanPham> danhSachSanPham = new ArrayList<>();
    private ArrayList<GiaoDich> danhSachGiaoDich = new ArrayList<>();

    public void themSanPham(SanPham sanPham) {
        danhSachSanPham.add(sanPham);
        System.out.println("Đã thêm sản phẩm: " + sanPham.getTenSp());
    }

    public void banSanPham(KhachHang khachHang, String tenSanPham, int soLuong) {
        for (SanPham sp : danhSachSanPham) {
            if (sp.getTenSp().equalsIgnoreCase(tenSanPham)) {
                GiaoDich gd = new GiaoDich(khachHang, sp, soLuong);
                danhSachGiaoDich.add(gd);
                gd.inHoaDon();
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm tên: " + tenSanPham);
    }

    public void hienThiSanPham() {
        System.out.println("===== DANH SÁCH SẢN PHẨM TRONG KHO =====");
        for (SanPham sp : danhSachSanPham) {
            sp.display();
            System.out.println("");
        }
    }

    public void hienThiTatCaGiaoDich() {
        System.out.println("===== DANH SÁCH GIAO DỊCH =====");
        for (GiaoDich gd : danhSachGiaoDich) {
            gd.inHoaDon();
        }
    }
}
