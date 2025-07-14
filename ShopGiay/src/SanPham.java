public class SanPham {
    private String maSP;
    private String tenSP;
    private String size;
    private double giaBan;
    private int soLuong;

    public SanPham(String maSP, String tenSP, String size, double giaBan, int soLuong) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.size = size;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
    }

    public String getMaSP() {
        return maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public String getSize() {
        return size;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void hienThiThongTin() {
        System.out.println("Mã SP: " + maSP);
        System.out.println("Tên SP: " + tenSP);
        System.out.println("Size: " + size);
        System.out.println("Giá bán: " + giaBan);
        System.out.println("Số lượng: " + soLuong);
    }
}
