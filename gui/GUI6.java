package gui;

import javax.swing.*;
import java.awt.*;

public class GUI6 {
    public static void main(String[] args) {
        // Thiết lập khung cửa sổ chính
        JFrame frame = new JFrame("Câu 6: Tính số ngày trong tháng");
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Nhãn và ô nhập Tháng
        JLabel lblMonth = new JLabel("Nhập tháng:");
        lblMonth.setBounds(30, 30, 100, 25);
        frame.add(lblMonth);

        JTextField txtMonth = new JTextField();
        txtMonth.setBounds(130, 30, 200, 25);
        frame.add(txtMonth);

        // Nhãn và ô nhập Năm
        JLabel lblYear = new JLabel("Nhập năm:");
        lblYear.setBounds(30, 70, 100, 25);
        frame.add(lblYear);

        JTextField txtYear = new JTextField();
        txtYear.setBounds(130, 70, 200, 25);
        frame.add(txtYear);

        // Nút bấm tính toán
        JButton btnCheck = new JButton("Kiểm tra");
        btnCheck.setBounds(130, 110, 100, 35);
        frame.add(btnCheck);

        // Khu vực hiển thị kết quả
        JLabel lblResultTitle = new JLabel("In ra:");
        lblResultTitle.setBounds(30, 160, 50, 25);
        frame.add(lblResultTitle);

        JTextArea txtResult = new JTextArea();
        txtResult.setEditable(false);
        txtResult.setFont(new Font("Arial", Font.BOLD, 14));
        txtResult.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        txtResult.setBounds(30, 190, 320, 80);
        frame.add(txtResult);

        // Xử lý sự kiện khi nhấn nút
        btnCheck.addActionListener(e -> {
            try {
                String monthStr = txtMonth.getText().trim();
                String yearStr = txtYear.getText().trim();

                if (monthStr.isEmpty()) {
                    txtResult.setText("Vui lòng nhập tháng!");
                    return;
                }

                int month = Integer.parseInt(monthStr);
                int days = 0;

                switch (month) {
                    case 1, 3, 5, 7, 8, 10, 12 -> days = 31;
                    case 4, 6, 9, 11 -> days = 30;
                    case 2 -> {
                        if (yearStr.isEmpty()) {
                            txtResult.setText("Nhập thêm năm để kiểm tra\ntháng 2 chính xác hơn.");
                            return;
                        }
                        int year = Integer.parseInt(yearStr);
                        // Công thức kiểm tra năm nhuận
                        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                            days = 29;
                        } else {
                            days = 28;
                        }
                    }
                    default -> {
                        txtResult.setText("Tháng không hợp lệ!");
                        return;
                    }
                }

                // Hiển thị kết quả theo format yêu cầu
                String output = days + " ngày";
                if (month == 2 && !yearStr.isEmpty()) {
                    txtResult.setText("Tháng " + month + ", năm " + yearStr + "\n" + output);
                } else {
                    txtResult.setText("Tháng " + month + "\n" + output);
                }

            } catch (NumberFormatException ex) {
                txtResult.setText("Lỗi: Vui lòng nhập số nguyên!");
            }
        });

        // Hiển thị khung cửa sổ giữa màn hình
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}