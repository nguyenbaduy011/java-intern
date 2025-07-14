package Java_core.Practice.practice2;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    DanhSachHangHoa danhSachHangHoa = new DanhSachHangHoa();
    Scanner scanner = new Scanner(System.in);
    int choice;

    danhSachHangHoa.danhSach.add(new HangThucPham("TP001", "Gao", 20000, 100, LocalDate.of(2023, 1, 1), LocalDate.of(2024, 1, 1), "Nha Cung Cap A"));
    danhSachHangHoa.danhSach.add(new HangDienMay("DM001", "Tu lanh", 8000000, 50, 24, 150));
    danhSachHangHoa.danhSach.add(new HangSanhSu("SS001", "Chen su", 50000, 200, "Nha San Xuat A", LocalDate.of(2023, 2, 1)));
    danhSachHangHoa.danhSach.add(new HangThucPham("TP002", "Thit heo", 150000, 30, LocalDate.of(2023, 3, 1), LocalDate.of(2023, 6, 1), "Nha Cung Cap B"));
    danhSachHangHoa.danhSach.add(new HangDienMay("DM002", "May giat", 6000000, 20, 12, 200));
    danhSachHangHoa.danhSach.add(new HangSanhSu("SS002", "Binh su", 30000, 150, "Nha San Xuat B", LocalDate.of(2023, 4, 1)));

    do {
      System.out.println("======================================");
      System.out.println("Menu:");
      System.out.println("1. Them hang hoa");
      System.out.println("2. Hien thi danh sach hang hoa");
      System.out.println("0. Thoat");
      System.out.print("Lua chon cua ban: ");

      try {
        choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
          case 1:
            danhSachHangHoa.themHangHoa();
            break;
          case 2:
            danhSachHangHoa.hienThiDanhSach();
            break;
          case 0:
            System.out.println("Thoat chuong trinh.");
            break;
          default:
            System.out.println("Lua chon khong hop le. Vui long chon lai.");
        }
      } catch (Exception e) {
        System.out.println("Loi: " + e.getMessage());
        scanner.nextLine();
        choice = -1; 
      }
    } while (choice != 0);
    scanner.close();
  }
}
