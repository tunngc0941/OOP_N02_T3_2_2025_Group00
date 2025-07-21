import java.util.*;

public class ManagerKhachHang {
    private List<KhachHang> list = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public KhachHang findByPhone(String soDienThoai) {
        try {
            for (KhachHang c : list) {
                if (c.getSoDienThoai().equals(soDienThoai)) {
                    return c;
                }
            }
        } catch (Exception e) {
            System.out.println("Loi khi tim khach hang theo SDT.");
            e.printStackTrace();
        }
        return null;
    }

    public void addKhachHang() {
        try {
            System.out.print("Nhap ma KH: ");
            String maKH = scanner.nextLine();
            System.out.print("Nhap ten KH: ");
            String tenKH = scanner.nextLine();
            System.out.print("Nhap so dien thoai: ");
            String sdt = scanner.nextLine();

            if (findByPhone(sdt) != null) {
                System.out.println("Khach hang voi so dien thoai nay da ton tai.");
                return;
            }

            KhachHang c = new KhachHang(maKH, tenKH, sdt);
            list.add(c);
            System.out.println("Da luu thong tin khach hang.");
        } catch (Exception e) {
            System.out.println("Loi khi them khach hang.");
            e.printStackTrace();
        }
    }

    public void deleteKhachHang() {
        try {
            System.out.print("Nhap ma KH can xoa: ");
            String maKH = scanner.nextLine();
            boolean removed = list.removeIf(c -> c.getMaKH().equals(maKH));
            if (removed) {
                System.out.println("Da xoa khach hang.");
            } else {
                System.out.println("Khong tim thay khach hang voi ma: " + maKH);
            }
        } catch (Exception e) {
            System.out.println("Loi khi xoa khach hang.");
            e.printStackTrace();
        }
    }

    public void hienThiThongTin() {
        try {
            if (list.isEmpty()) {
                System.out.println("Danh sach trong.");
            } else {
                System.out.println("Danh sach khach hang:");
                for (KhachHang c : list) {
                    c.hienThiThongTin();
                }
            }
        } catch (Exception e) {
            System.out.println("Loi khi hien thi danh sach.");
            e.printStackTrace();
        }
    }

    public void suaKhachHang() {
        try {
            System.out.print("Nhap ma KH can sua: ");
            String maKH = scanner.nextLine();
            for (KhachHang c : list) {
                if (c.getMaKH().equals(maKH)) {
                    System.out.print("Nhap ten moi: ");
                    c.setTenKH(scanner.nextLine());
                    System.out.print("Nhap so dien thoai moi: ");
                    c.setSoDienThoai(scanner.nextLine());
                    System.out.println("Da cap nhat thong tin.");
                    return;
                }
            }
            System.out.println("Khong tim thay khach hang voi ma: " + maKH);
        } catch (Exception e) {
            System.out.println("Loi khi sua thong tin khach hang.");
            e.printStackTrace();
        }
    }

    // public void menu() {
    //     while (true) {
    //         try {
    //             System.out.println("\n--- QUAN LY KHACH HANG ---");
    //             System.out.println("1. Them khach hang");
    //             System.out.println("2. Sua khach hang");
    //             System.out.println("3. Xoa khach hang");
    //             System.out.println("4. Hien thi danh sach");
    //             System.out.println("0. Thoat");
    //             System.out.print("Chon chuc nang: ");

    //             int choice = Integer.parseInt(scanner.nextLine());

    //             switch (choice) {
    //                 case 1 -> addKhachHang();
    //                 case 2 -> suaKhachHang();
    //                 case 3 -> deleteKhachHang();
    //                 case 4 -> hienThiThongTin();
    //                 case 0 -> {
    //                     System.out.println("Tam biet!");
    //                     return;
    //                 }
    //                 default -> System.out.println("Lua chon khong hop le.");
    //             }
    //         } catch (NumberFormatException e) {
    //             System.out.println("Vui long nhap so.");
    //         } catch (Exception e) {
    //             System.out.println("Loi khong xac dinh.");
    //             e.printStackTrace();
    //         }
    //     }
    // }
}