package Java_core.Practice.practice3;

public abstract class PhuongTienGiaoThong {
    protected String bienSo;
    protected String hangSanXuat;
    protected int namSanXuat;
    protected String mauXe;
    protected ChuSoHuu chuSoHuu;

    public PhuongTienGiaoThong(String bienSo, String hangSanXuat, int namSanXuat, String mauXe, ChuSoHuu chuSoHuu) {
        this.bienSo = bienSo;
        this.hangSanXuat = hangSanXuat;
        this.namSanXuat = namSanXuat;
        this.mauXe = mauXe;
        this.chuSoHuu = chuSoHuu;
    }

    // Getters and Setters
    public String getBienSo() { return bienSo; }
    public void setBienSo(String bienSo) { this.bienSo = bienSo; }
    public String getHangSanXuat() { return hangSanXuat; }
    public void setHangSanXuat(String hangSanXuat) { this.hangSanXuat = hangSanXuat; }
    public int getNamSanXuat() { return namSanXuat; }
    public void setNamSanXuat(int namSanXuat) { this.namSanXuat = namSanXuat; }
    public String getMauXe() { return mauXe; }
    public void setMauXe(String mauXe) { this.mauXe = mauXe; }
    public ChuSoHuu getChuSoHuu() { return chuSoHuu; }
    public void setChuSoHuu(ChuSoHuu chuSoHuu) { this.chuSoHuu = chuSoHuu; }

    @Override
    public String toString() {
        return String.format("Bien so: %-10s | Hang SX: %-10s | Nam SX: %d | Mau: %-10s | %s",
                bienSo, hangSanXuat, namSanXuat, mauXe, chuSoHuu.toString());
    }
}
