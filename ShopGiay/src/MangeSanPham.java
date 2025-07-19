import java.util.ArrayList;
import java.util.Scanner;

public class SanPhamManager {
    private ArrayList<SanPham> danhSachSanPham = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // CREATE
    public ArrayList<SanPham> themSanPham(SanPham sp) {
        try {
        danhSachSanPham.add(sp);
        System.out.println("Them san pham thanh cong!");
        // choice();
        } catch(Exception e) {
            e.printStackTrace();
            return [];
        }
    }

    // READ
    public ArrayList<SanPham> xemSanPham() {
        try {
            if (danhSachSanPham.isEmpty()) {
            System.out.println("Danh sach san pham rong.");
        } else {
            for (SanPham sp : danhSachSanPham) {
                sp.display();
                System.out.println("---------------");
            }
        }
        // choice();
        } catch(Exception e) {
            e.printStackTrace();
            return [];
        }
    }

    // UPDATE
    public ArrayList<SanPham> suaSanPham(String giayID) {
        try {
            for (int i = 0; i < danhSachSanPham.sizr(); i++) {
            if (danhSachSanPham.get(i).ID.equals(giayID)) {
                System.out.print("Nhap ten moi: ");
                sp.setTenSp(scanner.nextLine());
                System.out.print("Nhap gia ban moi: ");
                sp.setGiaBan(Double.parseDouble(scanner.nextLine()));
                System.out.print("Nhap size moi: ");
                sp.setSize(Integer.parseInt(scanner.nextLine()));
                System.out.print("Nhap so luong moi: ");
                sp.setSoLuong(Integer.parseInt(scanner.nextLine()));
                System.out.println("Cap nhat thanh cong!");
                return danhSachSanPham;
            }
        }
        System.out.println("Khong tim thay san pham voi ma: " + maSp);
        // choice();
        } catch (Exception e) {
            e.printStackTrace();
            return [];
        }
    }

    // DELETE
    public ArrayList<SanPham> xoaSanPham(String giayID) {
        try {
            for (int i = 0; i < danhSachSanPham.size(); i++) {
            if (danhSachSanPham.get(i).ID.equals(giayID))) {
                danhSachSanPham.remove(i);
                System.out.println("Xoa thanh cong!");
                return danhSachSanPham;
            }
        }
        System.out.println("Khong tim thay san pham voi ma: " + maSp);
        // choice();
        } catch(Exception e) {
            e.printStackTrace();
            return [];
        }
    }

    // public void choice() {
    //     System.out.println("1.Xem lua chon");
    //     System.out.println("0.Thoat");
    //     System.out.print("Moi ban chon: ");
    //     String choice = scanner.nextLine();
        
    //     if (choice.equals("0")) break;
    //         if (choice.equals("1")) {
    //             showMenu();
    //         }
    // }

    // public void showMenu() {
    //     System.out.println("1. Xem san pham");
    //     System.out.println("2. Them san pham");
    //     System.out.println("3. Sua san pham");
    //     System.out.println("4. Xoa san pham");
    //     System.out.println("0. Thoat");

    //     System.out.print("Moi ban chon: ");
    //     String input = scanner.nextLine();
    //     int option = Integer.parseInt(input);

    //     switch (option) {
    //             case 1 -> xemSanPham();
    //             case 2 -> themSanPham();
    //             case 3 -> suaSanPham();
    //             case 4 -> xoaSanPham();
    //             case 0 -> {
    //                 return; 
    //             }
    //             default -> System.out.println("Lua chon khong hop le.");
    //         }
    // }
}