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


System.out.println("\n>> Thông tin sản phẩm:");
System.out.printf("%-15s %-10s %-10s %-10s\n", "Tên SP", "Đơn giá", "Số lượng", "Thành tiền");
System.out.printf("%-15s %-10.2f %-10d %-10.2f\n",sanPham.getTenSp(),sanPham.getGiaBan(),soLuongMua,tinhTongTien());

System.out.println("----------------------------------------");
System.out.printf("TỔNG CỘNG: %.2f VND\n", tinhTongTien());
System.out.println("========================================");
}