
package gui;
import java.util.*;

public class gui_bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap chieu dai: ");
        int dai = sc.nextInt();

        System.out.print("nhap chieu rong: ");
        int rong = sc.nextInt();

        if (dai <= 0 || rong <= 0) {
            System.out.println("du lieu khong hop le!");
        } else {
            int dienTich = dai * rong;
            System.out.println("Dien tich hinh chu nhat la: " + dienTich);
        }
    }
}
