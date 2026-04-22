
package gui;



import java.util.Scanner;

public class BaiTap3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== MÁY TÍNH ĐƠN GIẢN ===");
        
        // Nhập hai số
        System.out.print("Nhập a: ");
        double a = sc.nextDouble();
        
        System.out.print("Nhập b: ");
        double b = sc.nextDouble();
        
        // Nhập phép tính
        System.out.print("Chọn phép tính (+, -, *, /): ");
        char phepTinh = sc.next().charAt(0);
        
        double ketQua = 0;
        boolean hopLe = true;
        
        // Thực hiện phép tính
        switch (phepTinh) {
            case '+':
                ketQua = a + b;
                break;
            case '-':
                ketQua = a - b;
                break;
            case '*':
                ketQua = a * b;
                break;
            case '/':
                if (b != 0) {
                    ketQua = a / b;
                } else {
                    System.out.println("Lỗi: Không thể chia cho 0!");
                    hopLe = false;
                }
                break;
            default:
                System.out.println("Lỗi: Phép tính không hợp lệ!");
                hopLe = false;
                break;
        }
        
        // In kết quả
        if (hopLe) {
            // Kiểm tra nếu kết quả là số nguyên
            if (ketQua == (int) ketQua) {
                System.out.printf("Kết quả: %.0f %c %.0f = %.0f\n", a, phepTinh, b, ketQua);
            } else {
                System.out.printf("Kết quả: %.2f %c %.2f = %.2f\n", a, phepTinh, b, ketQua);
            }
        }
        
        sc.close();
    }
}