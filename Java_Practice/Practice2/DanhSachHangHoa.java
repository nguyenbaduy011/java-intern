package Java_core.Practice.practice2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachHangHoa {
  public ArrayList<HangHoa> danhSach;
  public DanhSachHangHoa() {
    danhSach = new ArrayList<>();
  }

  // tim kiem hang hoa theo ma hang, neu khong tim thay tra ve null
  public HangHoa timHangHoa(String maHang) {
    for (HangHoa hangHoa : danhSach) {
      if (hangHoa.getMaHang().equals(maHang)) {
        return hangHoa;
      }
    }
    return null;
  }

  // them hang hoa vao danh sach
  public void themHangHoa() {
    Scanner scanner = new Scanner(System.in);
    int choice;

    System.out.println("======================================");
    System.out.println("Chon loai hang hoa can them:");
    System.out.println("1. Hang thuc pham");
    System.out.println("2. Hang dien may");
    System.out.println("3. Hang sanh su");
    System.out.println("0. Quay lai menu chinh");
    System.out.print("Lua chon cua ban: ");
    choice = scanner.nextInt();
    scanner.nextLine(); // Consume newline

    if (choice == 0) {
      return; // Quay lai menu chinh
    }

    System.out.print("Nhap ma hang: ");
    String maHang = scanner.nextLine();
    if(timHangHoa(maHang) != null) {
      System.out.println("Ma hang da ton tai. Vui long nhap ma hang khac.");
      return;
    }
    System.out.print("Nhap ten hang: ");
    String tenHang = scanner.nextLine();
    System.out.print("Nhap don gia: ");
    double donGia = scanner.nextDouble();
    System.out.print("Nhap so luong ton kho: ");
    int soLuong = scanner.nextInt();
    scanner.nextLine(); // Consume newline

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    switch(choice) {
      case 1: // Hang thuc pham
        System.out.print("Nhap ngay san xuat (dd/MM/yyyy): ");
        LocalDate ngaySanXuat = LocalDate.parse(scanner.nextLine(), dtf);
        System.out.print("Nhap ngay het han (dd/MM/yyyy): ");
        LocalDate ngayHetHan = LocalDate.parse(scanner.nextLine(), dtf);
        System.out.print("Nhap nha cung cap: ");
        String nhaCungCap = scanner.nextLine();
        HangThucPham hangThucPham = new HangThucPham(maHang, tenHang, donGia, soLuong, ngaySanXuat, ngayHetHan, nhaCungCap);
        danhSach.add(hangThucPham);
        break;

      case 2: // Hang dien may
        System.out.print("Nhap thoi gian bao hanh (thang): ");
        int thoiGianBaoHanh = scanner.nextInt();
        System.out.print("Nhap cong suat (watt): ");
        double congSuat = scanner.nextDouble();
        HangDienMay hangDienMay = new HangDienMay(maHang, tenHang, donGia, soLuong, thoiGianBaoHanh, congSuat);
        danhSach.add(hangDienMay);
        break;

      case 3: // Hang sanh su
        System.out.print("Nhap nha san xuat: ");
        String nhaSanXuat = scanner.nextLine();
        System.out.print("Nhap ngay nhap kho (dd/MM/yyyy): ");
        LocalDate ngayNhapKho = LocalDate.parse(scanner.nextLine(), dtf);
        HangSanhSu hangSanhSu = new HangSanhSu(maHang, tenHang, donGia, soLuong, nhaSanXuat, ngayNhapKho);
        danhSach.add(hangSanhSu);
        break;

      default:
        System.out.println("Lua chon khong hop le. Vui long chon lai.");
    }
    System.out.println("Da them hang hoa thanh cong!");
  }

  // hien thi danh sach hang hoa
  public void hienThiDanhSach() {
    if (danhSach.isEmpty()) {
      System.out.println("Danh sach hang hoa trong.");
      return;
    }
    System.out.println("Danh sach hang hoa:");
    for (HangHoa hangHoa : danhSach) {
      System.out.println(hangHoa);
    }
  }
}
