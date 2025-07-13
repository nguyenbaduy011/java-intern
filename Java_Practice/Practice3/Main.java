package Java_core.Practice.practice3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QuanLyPhuongTien quanLy = new QuanLyPhuongTien();
        Scanner sc = new Scanner(System.in);
        int choice = -1;

        // Thêm dữ liệu mẫu
        quanLy.themDuLieuMau();

        do {
            System.out.println("\n============= MENU QUAN LY PHUONG TIEN GIAO THONG =============");
            System.out.println("1. Them phuong tien giao thong");
            System.out.println("2. Tim kiem phuong tien theo bien so xe");
            System.out.println("3. Tim cac phuong tien cua chu so huu theo CMND");
            System.out.println("4. Xoa tat ca cac xe cua mot hang san xuat");
            System.out.println("5. Tim hang san xuat co nhieu xe nhat");
            System.out.println("6. Sap xep cac phuong tien theo bien so xe giam dan");
            System.out.println("7. Thong ke so luong tung loai phuong tien");
            System.out.println("8. In toan bo danh sach phuong tien");
            System.out.println("0. Thoat chuong trinh");
            System.out.print(">> Nhap lua chon cua ban: ");

            try {
                choice = sc.nextInt();
                sc.nextLine(); // Doc bo dong moi

                switch (choice) {
                    case 1:
                        quanLy.themPhuongTien(sc);
                        break;
                    case 2:
                        System.out.print("Nhap bien so can tim: ");
                        String bienSoTim = sc.nextLine();
                        quanLy.timKiemTheoBienSo(bienSoTim);
                        break;
                    case 3:
                        System.out.print("Nhap so CMND cua chu so huu can tim: ");
                        String cmndTim = sc.nextLine();
                        quanLy.timKiemTheoCMND(cmndTim);
                        break;
                    case 4:
                        System.out.print("Nhap hang san xuat can xoa (Honda, Yamaha, Toyota, Suzuki): ");
                        String hangXoa = sc.nextLine();
                        quanLy.xoaTheoHangSanXuat(hangXoa);
                        break;
                    case 5:
                        quanLy.timHangCoNhieuXeNhat();
                        break;
                    case 6:
                        quanLy.sapXepGiamDanTheoBienSo();
                        break;
                    case 7:
                        quanLy.thongKeSoLuongXe();
                        break;
                    case 8:
                        quanLy.inDanhSach();
                        break;
                    case 0:
                        System.out.println("Da thoat chuong trinh.");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le. Vui long chon lai.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Loi: Vui long nhap mot so nguyen.");
                sc.nextLine(); // Xoa bo du lieu nhap sai
                choice = -1; // Gan lai de vong lap tiep tuc
            }
        } while (choice != 0);
        
        sc.close();
    }
}
