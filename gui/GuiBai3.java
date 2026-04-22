/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiBai3 extends JFrame implements ActionListener {
    
    // Các thành phần giao diện
    private JLabel lblA, lblB, lblResult, lblOperator;
    private JTextField txtA, txtB, txtResult;
    private JButton btnCong, btnTru, btnNhan, btnChia, btnClear, btnExit;
    
    public GuiBai3() {
        // Thiết lập cửa sổ
        setTitle("Máy Tính Đơn Giản");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // Tạo panel chính với layout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Panel nhập liệu
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        
        lblA = new JLabel("Nhập a:");
        lblA.setFont(new Font("Arial", Font.BOLD, 14));
        txtA = new JTextField();
        txtA.setFont(new Font("Arial", Font.PLAIN, 14));
        
        lblB = new JLabel("Nhập b:");
        lblB.setFont(new Font("Arial", Font.BOLD, 14));
        txtB = new JTextField();
        txtB.setFont(new Font("Arial", Font.PLAIN, 14));
        
        lblResult = new JLabel("Kết quả:");
        lblResult.setFont(new Font("Arial", Font.BOLD, 14));
        txtResult = new JTextField();
        txtResult.setFont(new Font("Arial", Font.PLAIN, 14));
        txtResult.setEditable(false);
        txtResult.setBackground(new Color(240, 240, 240));
        
        inputPanel.add(lblA);
        inputPanel.add(txtA);
        inputPanel.add(lblB);
        inputPanel.add(txtB);
        inputPanel.add(lblResult);
        inputPanel.add(txtResult);
        
        // Panel nút bấm
        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 10, 10));
        
        btnCong = new JButton("+");
        btnTru = new JButton("-");
        btnNhan = new JButton("*");
        btnChia = new JButton("/");
        btnClear = new JButton("Xóa");
        btnExit = new JButton("Thoát");
        
        // Định dạng nút
        Font btnFont = new Font("Arial", Font.BOLD, 16);
        btnCong.setFont(btnFont);
        btnTru.setFont(btnFont);
        btnNhan.setFont(btnFont);
        btnChia.setFont(btnFont);
        btnClear.setFont(new Font("Arial", Font.BOLD, 14));
        btnExit.setFont(new Font("Arial", Font.BOLD, 14));
        
        // Màu sắc nút
        btnCong.setBackground(new Color(100, 200, 100));
        btnTru.setBackground(new Color(255, 200, 100));
        btnNhan.setBackground(new Color(100, 150, 255));
        btnChia.setBackground(new Color(255, 150, 100));
        btnClear.setBackground(new Color(200, 200, 200));
        btnExit.setBackground(new Color(255, 100, 100));
        
        buttonPanel.add(btnCong);
        buttonPanel.add(btnTru);
        buttonPanel.add(btnNhan);
        buttonPanel.add(btnChia);
        buttonPanel.add(btnClear);
        buttonPanel.add(btnExit);
        
        // Panel thông báo
        JPanel infoPanel = new JPanel();
        JLabel lblInfo = new JLabel("Chọn phép tính để thực hiện");
        lblInfo.setFont(new Font("Arial", Font.ITALIC, 12));
        lblInfo.setForeground(Color.GRAY);
        infoPanel.add(lblInfo);
        
        // Thêm các panel vào mainPanel
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(infoPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
        
        // Thêm sự kiện cho các nút
        btnCong.addActionListener(this);
        btnTru.addActionListener(this);
        btnNhan.addActionListener(this);
        btnChia.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source == btnExit) {
            System.exit(0);
        }
        
        if (source == btnClear) {
            txtA.setText("");
            txtB.setText("");
            txtResult.setText("");
            txtA.requestFocus();
            return;
        }
        
        // Lấy dữ liệu từ ô nhập
        String strA = txtA.getText().trim();
        String strB = txtB.getText().trim();
        
        // Kiểm tra dữ liệu nhập
        if (strA.isEmpty() || strB.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ a và b!", 
                    "Thiếu dữ liệu", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        double a, b;
        try {
            a = Double.parseDouble(strA);
            b = Double.parseDouble(strB);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!", 
                    "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        double result = 0;
        char operator = ' ';
        boolean isValid = true;
        
        // Thực hiện phép tính
        if (source == btnCong) {
            result = a + b;
            operator = '+';
        } else if (source == btnTru) {
            result = a - b;
            operator = '-';
        } else if (source == btnNhan) {
            result = a * b;
            operator = '*';
        } else if (source == btnChia) {
            if (b == 0) {
                JOptionPane.showMessageDialog(this, "Không thể chia cho 0!", 
                        "Lỗi toán học", JOptionPane.ERROR_MESSAGE);
                return;
            }
            result = a / b;
            operator = '/';
        }
        
        // Hiển thị kết quả
        if (isValid) {
            // Kiểm tra nếu kết quả là số nguyên thì hiển thị không có .0
            if (result == (int) result) {
                txtResult.setText(String.format("%.0f %c %.0f = %.0f", a, operator, b, result));
            } else {
                txtResult.setText(String.format("%.2f %c %.2f = %.2f", a, operator, b, result));
            }
        }
    }
    
    public static void main(String[] args) {
        // Chạy giao diện trên luồng Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            new GuiBai3().setVisible(true);
        });
    }
}