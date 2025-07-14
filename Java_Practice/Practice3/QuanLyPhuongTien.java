package Java_core.Practice.practice3;

import java.time.LocalDate;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class QuanLyPhuongTien {
    private List<PhuongTienGiaoThong> danhSachPT;
    private static final List<String> HANG_SAN_XUAT_HOP_LE = Arrays.asList("Honda", "Yamaha", "Toyota", "Suzuki");
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

    public QuanLyPhuongTien() {
        danhSachPT = new ArrayList<>();
    }

    // kiem tra du lieu dau vao
    
    private boolean kiemTraTrungBienSo(String bienSo) {
        return danhSachPT.stream().anyMatch(pt -> pt.getBienSo().equalsIgnoreCase(bienSo));
    }

    private boolean kiemTraTrungCMND(String cmnd) {
        return danhSachPT.stream().anyMatch(pt -> pt.getChuSoHuu().getSoCMND().equals(cmnd));
    }

    // chuc nang chinh cua chuong trinh

    // Thêm phương tiện
    public void themPhuongTien(Scanner sc) {
        System.out.println("Chon loai phuong tien (1: Oto, 2: Xe May, 3: Xe Tai): ");
        int choice = sc.nextInt();
        sc.nextLine(); // Doc bo dong moi

        // Nhap thong tin chu so huu
        String soCMND;
        while (true) {
            System.out.print("Nhap so CMND (12 so): ");
            soCMND = sc.nextLine();
            if (soCMND.matches("\\d{12}") && !kiemTraTrungCMND(soCMND)) {
                break;
            }
            System.out.println("Loi: So CMND phai co 12 so va khong duoc trung. Vui long nhap lai.");
        }

        System.out.print("Nhap ho ten chu so huu: ");
        String hoTen = sc.nextLine();
        
        String email;
        while (true) {
            System.out.print("Nhap email: ");
            email = sc.nextLine();
            if (Pattern.matches(EMAIL_REGEX, email)) {
                break;
            }
            System.out.println("Loi: Email khong dung dinh dang. Vui long nhap lai.");
        }
        ChuSoHuu chuSoHuu = new ChuSoHuu(soCMND, hoTen, email);

        // Nhap thong tin phuong tien
        String bienSo;
        while (true) {
            System.out.print("Nhap bien so (5 ky tu): ");
            bienSo = sc.nextLine();
            if (bienSo.length() == 5 && !kiemTraTrungBienSo(bienSo)) {
                break;
            }
            System.out.println("Loi: Bien so phai co 5 ky tu va khong duoc trung. Vui long nhap lai.");
        }

        String hangSX;
        while (true) {
            System.out.print("Nhap hang san xuat (Honda, Yamaha, Toyota, Suzuki): ");
            String inputHangSX = sc.nextLine();
            if (HANG_SAN_XUAT_HOP_LE.stream().anyMatch(h -> h.equalsIgnoreCase(inputHangSX))) {
                // Chuẩn hóa tên hãng
                hangSX = HANG_SAN_XUAT_HOP_LE.stream().filter(h -> h.equalsIgnoreCase(inputHangSX)).findFirst().get();
                break;
            }
            System.out.println("Loi: Hang san xuat khong hop le. Vui long nhap lai.");
        }

        int namSX;
        int currentYear = LocalDate.now().getYear();
        while (true) {
            System.out.print("Nhap nam san xuat: ");
            namSX = sc.nextInt();
            sc.nextLine(); // Doc bo dong moi
            if (namSX > 2000 && namSX <= currentYear) {
                break;
            }
            System.out.println("Loi: Nam san xuat phai > 2000 va <= " + currentYear + ". Vui long nhap lai.");
        }

        System.out.print("Nhap mau xe: ");
        String mauXe = sc.nextLine();

        // Nhap thong tin rieng va tao doi tuong
        switch (choice) {
            case 1:
                System.out.print("Nhap so cho ngoi: ");
                int soCho = sc.nextInt(); sc.nextLine();
                System.out.print("Nhap kieu dong co: ");
                String dongCo = sc.nextLine();
                danhSachPT.add(new Oto(bienSo, hangSX, namSX, mauXe, chuSoHuu, soCho, dongCo));
                break;
            case 2:
                System.out.print("Nhap cong suat (cc): ");
                int congSuat = sc.nextInt(); sc.nextLine();
                danhSachPT.add(new XeMay(bienSo, hangSX, namSX, mauXe, chuSoHuu, congSuat));
                break;
            case 3:
                System.out.print("Nhap trong tai (tan): ");
                double trongTai = sc.nextDouble(); sc.nextLine();
                danhSachPT.add(new XeTai(bienSo, hangSX, namSX, mauXe, chuSoHuu, trongTai));
                break;
            default:
                System.out.println("Lua chon khong hop le.");
                return;
        }
        System.out.println("Them phuong tien thanh cong!");
    }
    
    // In toàn bộ danh sách
    public void inDanhSach() {
        if (danhSachPT.isEmpty()) {
            System.out.println("Danh sach phuong tien rong.");
            return;
        }
        System.out.println("\n--- DANH SACH PHUONG TIEN GIAO THONG ---");
        for (PhuongTienGiaoThong pt : danhSachPT) {
            System.out.println(pt);
        }
    }

    // Tìm theo biển số
    public void timKiemTheoBienSo(String bienSo) {
        Optional<PhuongTienGiaoThong> ptOpt = danhSachPT.stream()
                .filter(pt -> pt.getBienSo().equalsIgnoreCase(bienSo))
                .findFirst();

        if (ptOpt.isPresent()) {
            System.out.println("Tim thay phuong tien:");
            System.out.println(ptOpt.get());
        } else {
            System.out.println("Khong tim thay phuong tien voi bien so: " + bienSo);
        }
    }

    // Tìm theo CMND
    public void timKiemTheoCMND(String cmnd) {
        List<PhuongTienGiaoThong> ketQua = danhSachPT.stream()
                .filter(pt -> pt.getChuSoHuu().getSoCMND().equals(cmnd))
                .collect(Collectors.toList());

        if (ketQua.isEmpty()) {
            System.out.println("Khong tim thay phuong tien nao cua chu so huu co CMND: " + cmnd);
        } else {
            System.out.println("Cac phuong tien cua chu so huu co CMND " + cmnd + ":");
            ketQua.forEach(System.out::println);
        }
    }

    // Xóa theo hãng sản xuất
    public void xoaTheoHangSanXuat(String hangSX) {
        long soLuongTruocKhiXoa = danhSachPT.size();
        danhSachPT.removeIf(pt -> pt.getHangSanXuat().equalsIgnoreCase(hangSX));
        long soLuongSauKhiXoa = danhSachPT.size();
        
        if (soLuongTruocKhiXoa > soLuongSauKhiXoa) {
            System.out.println("Da xoa " + (soLuongTruocKhiXoa - soLuongSauKhiXoa) + " phuong tien cua hang " + hangSX);
        } else {
            System.out.println("Khong tim thay phuong tien nao cua hang " + hangSX + " de xoa.");
        }
    }

    // Hãng có nhiều xe nhất
    public void timHangCoNhieuXeNhat() {
        if (danhSachPT.isEmpty()) {
            System.out.println("Danh sach rong, khong the thong ke.");
            return;
        }

        Map<String, Long> demTheoHang = danhSachPT.stream()
                .collect(Collectors.groupingBy(PhuongTienGiaoThong::getHangSanXuat, Collectors.counting()));
        
        Optional<Map.Entry<String, Long>> maxEntry = demTheoHang.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        if (maxEntry.isPresent()) {
            System.out.println("Hang co nhieu xe nhat la: " + maxEntry.get().getKey() + " voi " + maxEntry.get().getValue() + " xe.");
        }
    }

    // Sắp xếp giảm dần theo biển số
    public void sapXepGiamDanTheoBienSo() {
        danhSachPT.sort(Comparator.comparing(PhuongTienGiaoThong::getBienSo).reversed());
        System.out.println("Da sap xep danh sach giam dan theo bien so.");
        inDanhSach();
    }
    
    // Thống kê số lượng từng loại xe
    public void thongKeSoLuongXe() {
        long soOto = danhSachPT.stream().filter(pt -> pt instanceof Oto).count();
        long soXeMay = danhSachPT.stream().filter(pt -> pt instanceof XeMay).count();
        long soXeTai = danhSachPT.stream().filter(pt -> pt instanceof XeTai).count();

        System.out.println("\n--- THONG KE SO LUONG XE ---");
        System.out.println("So luong Oto: " + soOto);
        System.out.println("So luong Xe May: " + soXeMay);
        System.out.println("So luong Xe Tai: " + soXeTai);
        System.out.println("----------------------------");
    }
    
    // Thêm dữ liệu mẫu để test
    public void themDuLieuMau() {
        ChuSoHuu chu1 = new ChuSoHuu("001200123456", "Nguyen Van A", "a@gmail.com");
        ChuSoHuu chu2 = new ChuSoHuu("001200654321", "Tran Thi B", "b@yahoo.com");
        ChuSoHuu chu3 = new ChuSoHuu("001201789012", "Le Van C", "c@outlook.com");
        ChuSoHuu chu4 = new ChuSoHuu("001202345678", "Pham Thi D", "d@gmail.com");

        danhSachPT.add(new Oto("29A01", "Toyota", 2022, "Den", chu1, 5, "Xang"));
        danhSachPT.add(new XeMay("30B12", "Honda", 2023, "Trang", chu2, 150));
        danhSachPT.add(new XeTai("51C34", "Suzuki", 2021, "Xanh", chu3, 2.5));
        danhSachPT.add(new Oto("99D56", "Honda", 2020, "Do", chu2, 7, "Dau"));
        danhSachPT.add(new XeMay("88E78", "Yamaha", 2022, "Vang", chu4, 125));
        danhSachPT.add(new XeTai("77F90", "Toyota", 2023, "Trang", chu1, 3.0));
        danhSachPT.add(new Oto("66G12", "Suzuki", 2021, "Den", chu3, 4, "Dau"));
        danhSachPT.add(new XeMay("55H34", "Honda", 2022, "Xanh", chu4, 110));
        danhSachPT.add(new XeTai("44I56", "Yamaha", 2020, "Do", chu2, 5.0));
        System.out.println("Da them du lieu mau.");
    }
}
