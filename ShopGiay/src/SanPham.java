public class SanPham {
    private String ID;
    private String tenSp;
    private double giaBan;
    private int size;

    public SanPham(String ID, String tenSp, double giaBan, int size) {
        this.ID = ID;
        this.tenSp = tenSp;
        this.giaBan = giaBan;
        this.size = size;
    }

    public void setMaSp(String ID) {
        this.ID = ID;
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

    public String getID() {
        return ID;
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
        System.out.println("Ma SanPham: " + ID);
        System.out.println("Ten SanPham: " + tenSp);
        System.out.println("Gia ban: " + giaBan);
        System.out.println("Size: " + size);
    }
}