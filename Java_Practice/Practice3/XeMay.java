package Java_core.Practice.practice3;

public class XeMay extends PhuongTienGiaoThong {
    private int congSuat; 

    public XeMay(String bienSo, String hangSanXuat, int namSanXuat, String mauXe, ChuSoHuu chuSoHuu, int congSuat) {
        super(bienSo, hangSanXuat, namSanXuat, mauXe, chuSoHuu);
        this.congSuat = congSuat;
    }

    @Override
    public String toString() {
        return "Xe May: " + super.toString() + String.format(" | Cong suat: %dcc", congSuat);
    }
}