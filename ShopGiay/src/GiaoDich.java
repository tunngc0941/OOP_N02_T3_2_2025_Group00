import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GiaoDich {
    private KhachHang khachHang;
    private SanPham sanPham;
    private int soLuongMua;

    public GiaoDich(KhachHang khachHang, SanPham sanPham, int soLuongMua) {
        this.khachHang = khachHang;
        this.sanPham = sanPham;
        this.soLuongMua = soLuongMua;
    }
    public KhachHang getkKhachHang(){
        return khachHang;
    }
    public void setKhachHang(KhachHang khachHang){
        this.khachHang = khachHang;
    }
    public SanPham getSanPham(){
        return sanPham;
    }
    public void setSanPham(SanPham sanPham){
        this.sanPham = sanPham;
    }
    public int getSoLuongMua(){
        return soLuongMua;
    }
    public void setSoLuongMua(int soLuongMua){
        this.soLuongMua = soLuongMua;
    }
    public double tinhTongTien() {
        return sanPham.getGiaBan() * soLuongMua;
    }

   public void inHoaDon() {
        System.out.println("=========== HÓA ĐƠN BÁN HÀNG ===========");
        System.out.println("Ngày: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        System.out.println("----------------------------------------");


        System.out.println(">> Thông tin khách hàng:");
        khachHang.hienThiThongTin();
        System.out.println("");


        System.out.println("\n>> Thông tin sản phẩm:");
        System.out.printf("%-15s %-10s %-10s %-10s\n", "Tên SP", "Đơn giá", "Số lượng", "Thành tiền");
        System.out.printf("%-15s %-10.2f %-10d %-10.2f\n",sanPham.getTenSp(),sanPham.getGiaBan(),soLuongMua,tinhTongTien());
        System.out.println("");

        System.out.println("----------------------------------------");
        System.out.printf("TỔNG CỘNG: %.2f VND\n", tinhTongTien());
        System.out.println("========================================");
        System.out.println("");
    }
}

package com.example.giaodich.model;

public class GiaoDichForm {
    private String tenKH;
    private String diaChi;
    private String soDT;
    private String tenSP;
    private double giaBan;
    private int soLuong;

    public String getTenKH() { return tenKH; }
    public void setTenKH(String tenKH) { this.tenKH = tenKH; }

    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }

    public String getSoDT() { return soDT; }
    public void setSoDT(String soDT) { this.soDT = soDT; }

    public String getTenSP() { return tenSP; }
    public void setTenSP(String tenSP) { this.tenSP = tenSP; }

    public double getGiaBan() { return giaBan; }
    public void setGiaBan(double giaBan) { this.giaBan = giaBan; }

    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) { this.soLuong = soLuong; }
}


package com.example.giaodich.controller;

import com.example.giaodich.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GiaoDichController {

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("giaodichForm", new GiaoDichForm());
        return "form";
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute GiaoDichForm form, Model model) {
        KhachHang kh = new KhachHang(form.getTenKH(), form.getDiaChi(), form.getSoDT());
        SanPham sp = new SanPham(form.getTenSP(), form.getGiaBan());
        GiaoDich gd = new GiaoDich(kh, sp, form.getSoLuong());

        model.addAttribute("giaodich", gd);
        return "hoadon";
    }
}


<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Nhập giao dịch</title>
</head>
<body>
<h2>Nhập thông tin giao dịch</h2>
<form action="/submit" method="post" th:object="${giaodichForm}">
    <h3>Khách hàng:</h3>
    Tên: <input type="text" th:field="*{tenKH}" required><br>
    Địa chỉ: <input type="text" th:field="*{diaChi}" required><br>
    SĐT: <input type="text" th:field="*{soDT}" required><br>

    <h3>Sản phẩm:</h3>
    Tên SP: <input type="text" th:field="*{tenSP}" required><br>
    Giá bán: <input type="number" step="0.01" th:field="*{giaBan}" required><br>
    Số lượng: <input type="number" th:field="*{soLuong}" required><br>

    <br><input type="submit" value="In hóa đơn">
</form>
</body>
</html>

======== templates/hoadon.html ========
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Hóa đơn</title>
</head>
<body>
<h2>HÓA ĐƠN BÁN HÀNG</h2>
<p>Thông tin khách hàng:</p>
<ul>
    <li>Tên: <span th:text="${giaodich.khachHang.tenKH}"></span></li>
    <li>Địa chỉ: <span th:text="${giaodich.khachHang.diaChi}"></span></li>
    <li>SĐT: <span th:text="${giaodich.khachHang.soDT}"></span></li>
</ul>

<p>Thông tin sản phẩm:</p>
<ul>
    <li>Tên SP: <span th:text="${giaodich.sanPham.tenSP}"></span></li>
    <li>Giá bán: <span th:text="${giaodich.sanPham.giaBan}"></span></li>
    <li>Số lượng: <span th:text="${giaodich.soLuongMua}"></span></li>
</ul>

<h3>Tổng tiền: <span th:text="${giaodich.tinhTongTien()}"></span> VNĐ</h3>
</body>
</html>