package Java_core.Practice.practice3;

public class XeTai extends PhuongTienGiaoThong {
    private double trongTai; 

    public XeTai(String bienSo, String hangSanXuat, int namSanXuat, String mauXe, ChuSoHuu chuSoHuu, double trongTai) {
        super(bienSo, hangSanXuat, namSanXuat, mauXe, chuSoHuu);
        this.trongTai = trongTai;
    }

    @Override
    public String toString() {
        return "Xe Tai: " + super.toString() + String.format(" | Trong tai: %.1f tan", trongTai);
    }
}