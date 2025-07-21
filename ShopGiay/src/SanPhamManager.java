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
        return danhSachSanPham;
        // choice();
        } catch(Exception e) {
            e.printStackTrace();
            return danhSachSanPham;
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
            return danhSachSanPham;
        }
        // choice();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE
  
    public ArrayList<SanPham> suaSanPham(String giayID) {
        try {
            for (SanPham sp : danhSachSanPham) {
            if (sp.getID().equalsIgnoreCase(giayID)) {
                System.out.print("Nhập tên mới: ");
                sp.setTenSp(scanner.nextLine());
                System.out.print("Nhập giá mới: ");
                sp.setGiaBan(Double.parseDouble(scanner.nextLine()));
                System.out.println(" Đã cập nhật.");
                return danhSachSanPham;
            }
        }
        System.out.println(" Không tìm thấy sản phẩm voi ma:" + giayID);
        } catch (Exception e) {
            e.printStackTrace();
            return danhSachSanPham;
        }
    }

    // DELETE
    public ArrayList<SanPham> xoaSanPham(String giayID) {
        try {
            danhSachSanPham.removeIf(sp -> sp.getID().equalsIgnoreCase(giayID));
            System.out.println("Xoa san pham thanh cong.");
            return danhSachSanPham;
        // choice();
        } catch(Exception e) {
            e.printStackTrace();
            return danhSachSanPham;
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