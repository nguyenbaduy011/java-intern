package Java_core.Practice.practice3;

public class ChuSoHuu {
    private String soCMND;
    private String hoTen;
    private String email;

    public ChuSoHuu(String soCMND, String hoTen, String email) {
        this.soCMND = soCMND;
        this.hoTen = hoTen;
        this.email = email;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("Chu so huu: %s - CMND: %s - Email: %s", hoTen, soCMND, email);
    }
}
