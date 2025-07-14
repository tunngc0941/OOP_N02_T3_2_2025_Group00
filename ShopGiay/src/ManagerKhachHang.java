import java.util.*;
public class ManagerKhachHang {
    private List<KhachHang> list = new ArrayList<>();
    public KhachHang findByPhone(String soDienThoai){
        for(KhachHang c : list){
            if(c.getSoDienThoai().equals(soDienThoai)) return c;
        }
        return null;
    }
    public void addKhachHang(KhachHang c) {
        list.add(c);
        System.out.println("Da luu thong tin khach hang.");
    }
    public void deleteKhachHang(String maKH) {
        list.removeIf(c-> c.getMaKH().equals(maKH));
        System.out.println("Da xoa khach hang.");
    }
    public void hienThiThongTin(){
        if(list.isEmpty()) {
            System.out.println("Danh sach trong.");
        } else {
            System.out.println("Danh sach khach hang:");
            for(KhachHang c : list) c.hienThi();
        }
    }

}