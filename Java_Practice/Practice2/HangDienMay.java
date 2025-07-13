package Java_core.Practice.practice2;

public class HangDienMay extends HangHoa{
  private int thoiGianBaoHanh; // Thời gian bảo hành tính bằng tháng
  private double congSuat; // Công suất tính bằng watt

  public HangDienMay(String maHang, String tenHang, double donGia, int soLuong, int thoiGianBaoHanh, double congSuat) {
    super(maHang, tenHang, donGia, soLuong);
    this.thoiGianBaoHanh = thoiGianBaoHanh;
    this.congSuat = congSuat;
  }

  public int getThoiGianBaoHanh() {
    return thoiGianBaoHanh;
  }
  public double getCongSuat() {
    return congSuat;
  }

  public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
    if (thoiGianBaoHanh < 0) {
      System.out.println("Thoi gian bao hanh khong the am. Dat lai ve 0.");
      this.thoiGianBaoHanh = 0;
    } else {
      this.thoiGianBaoHanh = thoiGianBaoHanh;
    }
  }
  public void setCongSuat(double congSuat) {
    if (congSuat < 0) {
      System.out.println("Cong suat khong the am. Dat lai ve 0.");
      this.congSuat = 0;
    } else {
      this.congSuat = congSuat;
    }
  }

  @Override
  public double tinhVAT() {
    return getDonGia() * 0.1; 
  }
  @Override
  public String danhGiaMucDoTieuThu() {
    if (getSoLuong() < 3) {
      return "Ban chay";
    } else {
      return "Khong danh gia";
    }
  }
  @Override
  public String toString() {
      return super.toString() + String.format(" | Bao hanh: %d thang | Cong suat: %.1f KW | VAT: %.1f%% | Danh gia: %s",
              thoiGianBaoHanh, congSuat, 10.0, danhGiaMucDoTieuThu());
  }
}
