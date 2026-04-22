
package gui;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiBai4 extends JFrame implements ActionListener {
    
    private JLabel lblA, lblB, lblResult;
    private JTextField txtA, txtB, txtResult;
    private JButton btnSolve, btnClear, btnExit;
    
    public GuiBai4() {
        setTitle("Giải Phương Trình Bậc Nhất ax + b = 0");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // Panel chính
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Panel nhập liệu
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        
        lblA = new JLabel("Nhập a (hệ số):");
        lblA.setFont(new Font("Arial", Font.BOLD, 14));
        txtA = new JTextField();
        txtA.setFont(new Font("Arial", Font.PLAIN, 14));
        
        lblB = new JLabel("Nhập b (hệ số):");
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
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        
        btnSolve = new JButton("Giải phương trình");
        btnClear = new JButton("Xóa");
        btnExit = new JButton("Thoát");
        
        btnSolve.setFont(new Font("Arial", Font.BOLD, 14));
        btnClear.setFont(new Font("Arial", Font.BOLD, 14));
        btnExit.setFont(new Font("Arial", Font.BOLD, 14));
        
        btnSolve.setBackground(new Color(100, 200, 100));
        btnClear.setBackground(new Color(200, 200, 200));
        btnExit.setBackground(new Color(255, 100, 100));
        
        buttonPanel.add(btnSolve);
        buttonPanel.add(btnClear);
        buttonPanel.add(btnExit);
        
        // Panel hiển thị phương trình mẫu
        JPanel examplePanel = new JPanel();
        JLabel lblExample = new JLabel("Ví dụ: 2x - 4 = 0 → a=2, b=-4");
        lblExample.setFont(new Font("Arial", Font.ITALIC, 12));
        lblExample.setForeground(Color.GRAY);
        examplePanel.add(lblExample);
        
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(examplePanel, BorderLayout.SOUTH);
        
        add(mainPanel);
        
        // Thêm sự kiện
        btnSolve.addActionListener(this);
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
        
        if (source == btnSolve) {
            giaiPhuongTrinh();
        }
    }
    
    private void giaiPhuongTrinh() {
        String strA = txtA.getText().trim();
        String strB = txtB.getText().trim();
        
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
        
        String result = "";
        
        // Xử lý dấu của b để hiển thị đẹp
        String dauB = (b >= 0) ? "+ " + b : "- " + Math.abs(b);
        
        if (a == 0) {
            if (b == 0) {
                result = "Phương trình 0x " + dauB + " = 0 có VÔ SỐ NGHIỆM";
            } else {
                result = "Phương trình 0x " + dauB + " = 0 VÔ NGHIỆM";
            }
        } else {
            double x = -b / a;
            
            // Định dạng kết quả
            if (x == (int) x) {
                result = String.format("Phương trình %.0fx %s = 0 có nghiệm là: x = %.0f", a, dauB, x);
            } else {
                result = String.format("Phương trình %.2fx %s = 0 có nghiệm là: x = %.2f", a, dauB, x);
            }
        }
        
        txtResult.setText(result);
        
        // Hiển thị thêm bằng JOptionPane
        JOptionPane.showMessageDialog(this, result, "Kết quả", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GuiBai4().setVisible(true);
        });
    }
}