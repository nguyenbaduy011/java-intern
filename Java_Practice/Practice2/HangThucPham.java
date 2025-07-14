package Java_core.Practice.practice2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HangThucPham extends HangHoa {
  private LocalDate ngaySanXuat;
  private LocalDate ngayHetHan;
  private String nhaCungCap;

  public HangThucPham(String maHang, String tenHang, double donGia, int soLuong, LocalDate ngaySanXuat, LocalDate ngayHetHan, String nhaCungCap) {
    super(maHang, tenHang, donGia, soLuong);
    this.ngaySanXuat = ngaySanXuat;
    this.ngayHetHan = ngayHetHan;
    this.nhaCungCap = nhaCungCap;
  }

  public LocalDate getNgaySanXuat() {
    return ngaySanXuat;
  }

  public LocalDate getNgayHetHan() {
    return ngayHetHan;
  }

  public String getNhaCungCap() {
    return nhaCungCap;
  }

  public void setNgaySanXuat(LocalDate ngaySanXuat) {
    this.ngaySanXuat = ngaySanXuat;
  }

  public void setNgayHetHan(LocalDate ngayHetHan) {
    if (ngayHetHan.isAfter(ngaySanXuat) || ngayHetHan.isEqual(ngaySanXuat)) {
        this.ngayHetHan = ngayHetHan;
    } else {
        this.ngayHetHan = ngaySanXuat.plusDays(1);
        System.out.println("Loi: Ngay het han phai sau hoac bang ngay san xuat. Da tu dong dat lai.");
    }
  }

  public void setNhaCungCap(String nhaCungCap) {
    this.nhaCungCap = nhaCungCap;
  }

  @Override
  public double tinhVAT() {
      return getDonGia() * 0.05;
  }

  @Override
  public String danhGiaMucDoTieuThu() {
      if (getSoLuong() > 0 && LocalDate.now().isAfter(ngayHetHan)) {
          return "Kho ban";
      }
      return "Khong danh gia";
  }
  @Override
  public String toString() {
      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      return super.toString() + String.format(" | NSX: %s | HSD: %s | NCC: %s | VAT: %.1f%% | Danh gia: %s",
              ngaySanXuat.format(dtf), ngayHetHan.format(dtf), nhaCungCap, 5.0, danhGiaMucDoTieuThu());
  }
}
