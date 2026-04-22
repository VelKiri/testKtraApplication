package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KiemTraSoNguyenToGUI extends JFrame {

    private final int MAX_N = 1000000;
    private boolean[] isPrime;

    private JTextField txtA;
    private JLabel lblKetQua;
    private JButton btnKiemTra;

    public KiemTraSoNguyenToGUI() {
        sieve(MAX_N);

        setTitle("Kiểm Tra Số Nguyên Tố");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        add(new JLabel("Nhập số a:"));
        txtA = new JTextField(15);
        add(txtA);

        btnKiemTra = new JButton("Kiểm tra");
        add(btnKiemTra);

        lblKetQua = new JLabel("Kết quả sẽ hiển thị ở đây");
        lblKetQua.setFont(new Font("Arial", Font.BOLD, 14));
        add(lblKetQua);

        btnKiemTra.addActionListener(e -> kiemTra());
        txtA.addActionListener(e -> kiemTra());
    }

    private void sieve(int n) {
        isPrime = new boolean[n + 1];
        for (int i = 0; i <= n; ++i) isPrime[i] = true;
        
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= n; ++i) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    // Hàm kiểm tra logic
    private boolean checkIsPrime(long n) {
        if (n <= MAX_N && n >= 0) {
            return isPrime[(int) n];
        }
        if (n < 2) return false;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    private void kiemTra() {
        try {
            String input = txtA.getText().trim();
            if (input.isEmpty()) return;

            long n = Long.parseLong(input);

            if (checkIsPrime(n)) {
                lblKetQua.setText(n + " là số nguyên tố");
                lblKetQua.setForeground(new Color(0, 128, 0));
            } else {
                lblKetQua.setText(n + " không phải là số nguyên tố");
                lblKetQua.setForeground(Color.RED);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập một số nguyên hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new KiemTraSoNguyenToGUI().setVisible(true);
        });
    }
}