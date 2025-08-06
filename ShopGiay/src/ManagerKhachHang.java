import java.util.*;

public class ManagerKhachHang {
    private List<KhachHang> list = new ArrayList<>();

    // Tìm khách hàng theo số điện thoại
    public KhachHang findByPhone(String soDienThoai) {
        for (KhachHang c : list) {
            if (c.getSoDienThoai().equals(soDienThoai)) {
                return c;
            }
        }
        return null;
    }

    // Thêm khách hàng
    public boolean addKhachHang(KhachHang c) {
        if (findByPhone(c.getSoDienThoai()) != null) {
            return false; // Đã tồn tại số điện thoại
        }
        list.add(c);
        return true;
    }

    // Xóa khách hàng theo mã
    public boolean deleteKhachHang(String maKH) {
        return list.removeIf(c -> c.getMaKH().equals(maKH));
    }

    // Sửa thông tin khách hàng theo mã
    public boolean suaKhachHang(String maKH, String tenMoi, String sdtMoi) {
        for (KhachHang c : list) {
            if (c.getMaKH().equals(maKH)) {
                c.setTenKH(tenMoi);
                c.setSoDienThoai(sdtMoi);
                return true;
            }
        }
        return false;
    }

    // Lấy danh sách khách hàng
    public List<KhachHang> getDanhSachKhachHang() {
        return list;
    }
}