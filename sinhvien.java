/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2lab2;

import java.util.Scanner;

/**
 *
 * @author A
 */
public class sinhvien {

    private int masv;
    private String hoten;
    private int diem;
    private String xeploai;
    private static final int DIEM = 0;
    private static final String XEPLOAI = "CHUA_XEP_LOAI";
    private static final int MASV = 0;
    private static final String HOTEN = "CHUA_CO_TEN";

    public sinhvien(int masv, String hoten, int diem, String xeploai) {
        this.masv = masv;
        this.hoten = hoten;
        this.diem = diem;
        this.xeploai = xeploai;
    }

    public sinhvien() {
        this(MASV, HOTEN, DIEM, XEPLOAI);
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getMasv() {
        return masv;
    }

    public void setMasv(int masv) {
        this.masv = masv;
    }

    public String getXeploai() {
        return xeploai;
    }

    public void setXeploai(String xeploai) {
        this.xeploai = xeploai;
    }

    public void setXeploai() {
        if (diem >= 8) {
            xeploai = "Gioi";
        } else if (diem >= 7) {
            xeploai = "Kha";
        } else if (diem >= 5) {
            xeploai = "Trung binh";
        } else {
            xeploai = "Kem";
        }
    }

    @Override
    public String toString() {
        return masv + "\t" + hoten + "\t" + diem + "\t" + xeploai + "\n";
    }

    public void nhapdl() {
        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
        masv = testID();//try...catch 
        hoten = testName();//dung xu ly chuoi bat loi( regex )
        diem = testPoint();//try...catch
        while (diem < -1 || diem > 10) {
            System.out.println("vui long nhap diem tu 0->10");
            diem = testPoint();
        }
    }

    public String testName() {
        Scanner input = new Scanner(System.in);
        String hotencheck = "^[a-zA-Z\\sàáạã_-]{1,50}$";//regex nhap từ 1-50 ki tự có khoảng trống (hk co số)
        System.out.print("Nhap hoten: ");
        hoten = input.nextLine();
        if (hoten.matches(hotencheck)) {//bat loi nhap ten (yeu cau khong co so o trong ten)
        } else {
            System.out.println("vui long nhap ten khong co chu so");
            sinhvien a = new sinhvien();
            hoten = testName();
        }
        return hoten;
    }

    public int testID() {
        Scanner input1 = new Scanner(System.in);
        System.out.print("Nhap ma sinh vien: ");
        try {
            masv = input1.nextInt();
        } catch (Exception e) {
            // System.out.println("loi " + e);// code de hien ten loi 
            System.out.println("vui long nhap so");
            sinhvien a = new sinhvien();
            masv = a.testID();//neu vao catch thi chay lai buoc nhap diem
        }
        this.setMasv(masv);
        return masv;
    }

    public int testPoint() {
        Scanner input1 = new Scanner(System.in);
        System.out.print("Nhap diem: ");
        try {
            diem = input1.nextInt();
        } catch (Exception e) {
            // System.out.println("loi " + e);// code de hien ten loi 
            System.out.println("vui long nhap so");
            sinhvien a = new sinhvien();
            diem = a.testPoint();//neu vao catch thi chay lai buoc nhap diem
        }
        this.setDiem(diem);
        return diem;
    }

    /*public int testPoint() {
        Scanner input1 = new Scanner(System.in);
        System.out.print("Nhap diem: ");
        String text = input1.nextLine();
        try {
            diem = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            // System.out.println("loi " + e);// code de hien ten loi (NumberFormatException)
            System.out.println("vui long nhap so");
            sinhvien a = new sinhvien();
            diem=a.testPoint();//neu vao catch thi chay lai buoc nhap diem
        }
        this.setDiem(diem);
        return diem;
    }*///cách 2 dùng String sau đó ép kiểu qua int rồi dùng try catch de kiem tra loi
    public static void main(String[] args) {
        sinhvien s = new sinhvien();
        System.out.println("Sinh vien: " + s);
        s.nhapdl();
        s.setXeploai();
        System.out.println("Sau khi nhap:");
        System.out.println(s);
    }
}
