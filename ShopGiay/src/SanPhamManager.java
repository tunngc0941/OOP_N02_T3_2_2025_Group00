import java.util.ArrayList;

public class SanPhamManager {
    private ArrayList<SanPham> danhSachSanPham = new ArrayList<>();

    // CREATE
    public void themSanPham(SanPham sp) {
        danhSachSanPham.add(sp);
    }

    // READ
    public ArrayList<SanPham> getDanhSachSanPham() {
        return danhSachSanPham;
    }

    // UPDATE
    public boolean suaSanPham(String giayID, String tenMoi, double giaMoi) {
        for (SanPham sp : danhSachSanPham) {
            if (sp.getID().equalsIgnoreCase(giayID)) {
                sp.setTenSp(tenMoi);
                sp.setGiaBan(giaMoi);
                return true;
            }
        }
        return false;
    }

    // DELETE
    public boolean xoaSanPham(String giayID) {
        return danhSachSanPham.removeIf(sp -> sp.getID().equalsIgnoreCase(giayID));
    }
}