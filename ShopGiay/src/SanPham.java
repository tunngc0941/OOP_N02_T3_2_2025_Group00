public class SanPham {
    private String maSp;
    private String tenSp;
    private double giaBan;
    private int size;

    public SanPham(String maSp, String tenSp, double giaBan, int size) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.giaBan = giaBan;
        this.size = size;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public String getMaSp() {
        return maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public int getSize() {
        return size;
    }

    public void display() {
        System.out.println("Thong tin san pham:");
        System.out.println("Ma SanPham: " + maSp);
        System.out.println("Ten SanPham: " + tenSp);
        System.out.println("Gia ban: " + giaBan);
        System.out.println("Size: " + size);
    }
}