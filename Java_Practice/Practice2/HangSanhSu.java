package Java_core.Practice.practice2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class HangSanhSu extends HangHoa {
  private String nhaSanXuat;
  private LocalDate ngayNhapKho;

  public HangSanhSu(String maHang, String tenHang, double donGia, int soLuong, String nhaSanXuat, LocalDate ngayNhapKho) {
    super(maHang, tenHang, donGia, soLuong);
    this.nhaSanXuat = nhaSanXuat;
    this.ngayNhapKho = ngayNhapKho;
  }

  public String getNhaSanXuat() {
    return nhaSanXuat;
  }
  public LocalDate getNgayNhapKho() {
    return ngayNhapKho;
  }

  public void setNhaSanXuat(String nhaSanXuat) {
    this.nhaSanXuat = nhaSanXuat;
  }
  public void setNgayNhapKho(LocalDate ngayNhapKho) {
    this.ngayNhapKho = ngayNhapKho;
  }

  @Override
  public double tinhVAT() {
    return getDonGia() * 0.1; 
  }
  @Override
  public String danhGiaMucDoTieuThu() {
      long daysInStock = ChronoUnit.DAYS.between(ngayNhapKho, LocalDate.now());
      if (getSoLuong() > 50 && daysInStock > 10) {
          return "Ban cham";
      }
      return "Khong danh gia";
  }
  @Override
  public String toString() {
      return super.toString() + String.format(" | Nha san xuat: %s | Ngay nhap kho: %s | VAT: %.1f%% | Danh gia: %s",
              nhaSanXuat, ngayNhapKho.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), 10.0, danhGiaMucDoTieuThu());
  }
}
