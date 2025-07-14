import java.util.ArrayList;
import java.util.Scanner;

public class SanPhamManager {
    private ArrayList<SanPham> danhSachSanPham = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // CREATE
    public void themSanPham() {
        System.out.print("Nhap ma SP: ");
        String maSp = scanner.nextLine();
        System.out.print("Nhap ten SP: ");
        String tenSp = scanner.nextLine();
        System.out.print("Nhap gia ban: ");
        double giaBan = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhap size: ");
        int size = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhap so luong: ");
        int soLuong = Integer.parseInt(scanner.nextLine());

        SanPham sp = new SanPham(maSp, tenSp, giaBan, size, soLuong);
        danhSachSanPham.add(sp);
        System.out.println("Them san pham thanh cong!");
        choice();
    }

    // READ
    public void xemSanPham() {
        if (danhSachSanPham.isEmpty()) {
            System.out.println("Danh sach san pham rong.");
        } else {
            for (SanPham sp : danhSachSanPham) {
                sp.display();
                System.out.println("---------------");
            }
        }
        choice();
    }

    // UPDATE
    public void suaSanPham() {
        System.out.print("Nhap ma SP can cap nhat: ");
        String maSp = scanner.nextLine();
        for (SanPham sp : danhSachSanPham) {
            if (sp.getMaSp().equalsIgnoreCase(maSp)) {
                System.out.print("Nhap ten moi: ");
                sp.setTenSp(scanner.nextLine());
                System.out.print("Nhap gia ban moi: ");
                sp.setGiaBan(Double.parseDouble(scanner.nextLine()));
                System.out.print("Nhap size moi: ");
                sp.setSize(Integer.parseInt(scanner.nextLine()));
                System.out.print("Nhap so luong moi: ");
                sp.setSoLuong(Integer.parseInt(scanner.nextLine()));
                System.out.println("Cap nhat thanh cong!");
                return;
            }
        }
        System.out.println("Khong tim thay san pham voi ma: " + maSp);
        choice();
    }

    // DELETE
    public void xoaSanPham() {
        System.out.print("Nhap ma SP can xoa: ");
        String maSp = scanner.nextLine();
        for (SanPham sp : danhSachSanPham) {
            if (sp.getMaSp().equalsIgnoreCase(maSp)) {
                danhSachSanPham.remove(sp);
                System.out.println("Xoa thanh cong!");
                return;
            }
        }
        System.out.println("Khong tim thay san pham voi ma: " + maSp);
        choice();
    }

    public void choice() {
        System.out.println("1.Xem lua chon");
        System.out.println("0.Thoat");
        System.out.print("Moi ban chon: ");
        String choice = scanner.nextLine();
        
        if (choice.equals("0")) break;
            if (choice.equals("1")) {
                showMenu();
            }
    }

    public void showMenu() {
        System.out.println("1. Xem san pham");
        System.out.println("2. Them san pham");
        System.out.println("3. Sua san pham");
        System.out.println("4. Xoa san pham");
        System.out.println("0. Thoat");

        System.out.print("Moi ban chon: ");
        String input = scanner.nextLine();
        int option = Integer.parseInt(input);

        switch (option) {
                case 1 -> xemSanPham();
                case 2 -> themSanPham();
                case 3 -> suaSanPham();
                case 4 -> xoaSanPham();
                case 0 -> {
                    return; 
                }
                default -> System.out.println("Lua chon khong hop le.");
            }
    }
}