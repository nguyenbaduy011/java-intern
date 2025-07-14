package Java_core.Practice.practice3;

public class Oto extends PhuongTienGiaoThong {
    private int soChoNgoi;
    private String kieuDongCo;

    public Oto(String bienSo, String hangSanXuat, int namSanXuat, String mauXe, ChuSoHuu chuSoHuu, int soChoNgoi, String kieuDongCo) {
        super(bienSo, hangSanXuat, namSanXuat, mauXe, chuSoHuu);
        this.soChoNgoi = soChoNgoi;
        this.kieuDongCo = kieuDongCo;
    }

    @Override
    public String toString() {
        return "Oto: " + super.toString() + String.format(" | So cho: %d | Kieu dong co: %s", soChoNgoi, kieuDongCo);
    }
}