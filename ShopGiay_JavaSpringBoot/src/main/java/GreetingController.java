
import com.example.demo.model.SanPham;
import com.example.demo.model.KhachHang;
import com.example.demo.controller.QuanLyGiaoDich;
import com.example.demo.controller.QuanLyKhachHang;
import com.example.demo.controller.QuanLySanPham;
import com.example.demo.model.GiaoDich;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    // Khởi tạo các đối tượng quản lý
    private static final QuanLySanPham quanLySanPham = new QuanLySanPham();
    private static final QuanLyKhachHang quanLyKhachHang = new QuanLyKhachHang();
    private static final QuanLyGiaoDich quanLyGiaoDich = new QuanLyGiaoDich();

    // Thêm dữ liệu mẫu ban đầu
    static {
        quanLySanPham.them(new SanPham("SP01", "Nike Air Max", "42", 3000000, 10));
        quanLySanPham.them(new SanPham("SP02", "Adidas Ultraboost", "41", 3500000, 5));

        quanLyKhachHang.them(new KhachHang("KH01", "Nguyen Van A", "0909123456"));
        quanLyKhachHang.them(new KhachHang("KH02", "Tran Thi B", "0909988776"));

        quanLyGiaoDich.them(new GiaoDich("Nguyen Van A", "SP01", 3000000));
    }

    // Trang chính hiển thị dữ liệu
    @GetMapping("/giaytnh")
    public String showAllData(Model model) {
        model.addAttribute("danhSachSanPham", quanLySanPham.layDanhSach());
        model.addAttribute("danhSachKhachHang", quanLyKhachHang.layDanhSach());
        model.addAttribute("danhSachGiaoDich", quanLyGiaoDich.layDanhSach());
        return "giaytnh";
    }

    // Thêm sản phẩm
    @GetMapping("/product/add")
    public String addProduct(
            @RequestParam String maSP,
            @RequestParam String tenSP,
            @RequestParam String size,
            @RequestParam double giaBan,
            @RequestParam int soLuong
    ) {
        quanLySanPham.them(new SanPham(maSP, tenSP, size, giaBan, soLuong));
        return "redirect:/giaytnh";
    }

    // Thêm khách hàng
    @GetMapping("/customer/add")
    public String addCustomer(
            @RequestParam String maKH,
            @RequestParam String tenKH,
            @RequestParam String soDienThoai
    ) {
        quanLyKhachHang.them(new KhachHang(maKH, tenKH, soDienThoai));
        return "redirect:/giaytnh";
    }

    // Thêm giao dịch
    @GetMapping("/transaction/add")
    public String addTransaction(
            @RequestParam String tenKH,
            @RequestParam String maSP,
            @RequestParam double tongTien
    ) {
        quanLyGiaoDich.them(new GiaoDich(tenKH, maSP, tongTien));
        return "redirect:/giaytnh";
    }
}
