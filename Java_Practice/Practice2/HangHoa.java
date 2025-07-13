package Java_core.Practice.practice2;

import java.text.NumberFormat;
import java.util.Locale;

public abstract class HangHoa {
  private String maHang;
  private String tenHang;
  private double donGia;
  private int soLuong;

  public HangHoa(String maHang, String tenHang, double donGia, int soLuong) {
    this.maHang = maHang;
    this.tenHang = tenHang;
    this.donGia = donGia;
    this.soLuong = soLuong;
  }

  public String getMaHang() {
    return maHang;
  }
  public String getTenHang() {
    return tenHang;
  }
  public double getDonGia() {
    return donGia;
  }
  public int getSoLuong() {
    return soLuong;
  }

  public void setMaHang(String maHang) {
    this.maHang = maHang;
  }
  public void setTenHang(String tenHang) {
    this.tenHang = tenHang;
  }
  public void setDonGia(double donGia) {
    this.donGia = donGia;
  }
  public void setSoLuong(int soLuong) {
    if (soLuong < 0) {
      this.soLuong = 0;
    } else {
      this.soLuong = soLuong;
    }
  }

  public abstract double tinhVAT();
  public abstract String danhGiaMucDoTieuThu();

  @Override
  public String toString() {
      Locale localeVN = new Locale("vi", "VN");
      NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(localeVN);

      return String.format("Ma hang: %-10s | TTen hang: %-20s | So luong ton: %-5d | Don gia: %-15s",
              maHang, tenHang, soLuong, currencyFormatter.format(donGia));
  }
}
