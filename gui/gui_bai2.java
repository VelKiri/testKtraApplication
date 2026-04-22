
package gui;
import java.util.*;

public class gui_bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so km: ");
        double km = sc.nextDouble();

        if (km < 0) {
            System.out.println("Du lieu sai!");
        } else {
            double tien = km * 10000;
            System.out.println("Tien taxi: " + tien + " VND");
        }
    }
}
