/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.util.Scanner;

public class BaiTap4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== GIẢI PHƯƠNG TRÌNH BẬC NHẤT ax + b = 0 ===");
        
        // Nhập hệ số
        System.out.print("Nhập a: ");
        double a = sc.nextDouble();
        
        System.out.print("Nhập b: ");
        double b = sc.nextDouble();
        
        // Xây dựng phương trình hiển thị
        String aStr, bStr;
        
        if (a == 0) {
            aStr = "0";
        } else if (a == 1) {
            aStr = "x";
        } else if (a == -1) {
            aStr = "-x";
        } else {
            aStr = a + "x";
        }
        
        if (b == 0) {
            bStr = "0";
        } else if (b > 0) {
            bStr = " + " + b;
        } else {
            bStr = " - " + Math.abs(b);
        }
        
        String equation = aStr + bStr + " = 0";
        
        // Giải phương trình
        System.out.print("Phương trình " + equation);
        
        if (a == 0) {
            if (b == 0) {
                System.out.println(" vô số nghiệm");
            } else {
                System.out.println(" vô nghiệm");
            }
        } else {
            double nghiem = -b / a;
            if (nghiem == (int) nghiem) {
                System.out.printf(" có nghiệm là: x = %.0f\n", nghiem);
            } else {
                System.out.printf(" có nghiệm là: x = %.2f\n", nghiem);
            }
        }
        
        sc.close();
    }
}