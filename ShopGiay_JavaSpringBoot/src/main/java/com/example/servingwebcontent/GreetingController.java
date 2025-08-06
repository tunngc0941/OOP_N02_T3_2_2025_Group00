package com.example.servingwebcontent;

import com.example.servingwebcontent.model.KhachHang;
import com.example.servingwebcontent.model.SanPham;
import com.example.servingwebcontent.model.GiaoDich;
import com.example.servingwebcontent.controller.QuanLyKhachHang;
import com.example.servingwebcontent.controller.QuanLySanPham;
import com.example.servingwebcontent.controller.QuanLyGiaoDich;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    private static final QuanLySanPham quanLySanPham = new QuanLySanPham();
    private static final QuanLyKhachHang quanLyKhachHang = new QuanLyKhachHang();
    private static final QuanLyGiaoDich quanLyGiaoDich = new QuanLyGiaoDich();

    static {
        quanLySanPham.them(new SanPham("Giày Adidas", 1500000));
        quanLySanPham.them(new SanPham("Giày Nike", 2000000));
        quanLySanPham.them(new SanPham("Giày Vans", 1000000));

        quanLyKhachHang.them(new KhachHang("Nguyễn Văn A", "0909123456"));
        quanLyKhachHang.them(new KhachHang("Trần Thị B", "0912345678"));

        quanLyGiaoDich.them(new GiaoDich(
            quanLyKhachHang.getDanhSach().get(0),
            quanLySanPham.getDanhSach().get(1),
            2
        ));
    }

    // Thêm khách hàng
    @GetMapping("/customer")
    public String customer(
            @RequestParam(name = "name", required = false, defaultValue = "Khách lạ") String name,
            @RequestParam(name = "phone", required = false, defaultValue = "Không rõ") String phone,
            Model model) {

        KhachHang kh = new KhachHang(name, phone);
        quanLyKhachHang.them(kh);
        return "redirect:/giaytnh";
    }

    // Xóa khách hàng
    @GetMapping("/customer/delete")
    public String deleteCustomer(@RequestParam(name = "index") int index) {
        quanLyKhachHang.xoa(index);
        return "redirect:/giaytnh";
    }

    // Thêm sản phẩm
    @GetMapping("/product")
    public String product(
            @RequestParam(name = "name", required = false, defaultValue = "Giày mới") String name,
            @RequestParam(name = "price", required = false, defaultValue = "999000") double price,
            Model model) {

        SanPham sp = new SanPham(name, price);
        quanLySanPham.them(sp);
        return "redirect:/giaytnh";
    }

    // Thêm giao dịch
    @GetMapping("/transaction")
    public String transaction(
            @RequestParam(name = "customer", required = false, defaultValue = "Khách A") String customerName,
            @RequestParam(name = "phone", required = false, defaultValue = "Không rõ") String phone,
            @RequestParam(name = "product", required = false, defaultValue = "Giày mới") String productName,
            @RequestParam(name = "price", required = false, defaultValue = "999000") double price,
            @RequestParam(name = "quantity", required = false, defaultValue = "1") int quantity,
            Model model) {

        KhachHang kh = new KhachHang(customerName, phone);
        SanPham sp = new SanPham(productName, price);
        GiaoDich gd = new GiaoDich(kh, sp, quantity);
        quanLyGiaoDich.them(gd);
        return "redirect:/giaytnh";
    }

    // Trang chính hiển thị danh sách
    @GetMapping("/giaytnh")
    public String giaytnh(Model model) {
        model.addAttribute("products", quanLySanPham.getDanhSach());
        model.addAttribute("customers", quanLyKhachHang.getDanhSach());
        model.addAttribute("transactions", quanLyGiaoDich.getDanhSach());
        return "giaytnh";
    }
}
