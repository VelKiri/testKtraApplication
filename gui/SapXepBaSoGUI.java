package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class SapXepBaSoGUI extends JFrame {

    private JTextField txtA, txtB, txtC;
    private JLabel lblKetQua;
    private JButton btnSapXep, btnReset;

    public SapXepBaSoGUI() {
        setTitle("Sắp xếp số tăng dần");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JLabel lblTitle = new JLabel("Sắp Xếp 3 Số Tăng Dần", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        add(lblTitle, BorderLayout.NORTH);

        JPanel pnlInput = new JPanel(new GridLayout(3, 2, 10, 10));
        pnlInput.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        
        pnlInput.add(new JLabel("Nhập số a:"));
        txtA = new JTextField();
        pnlInput.add(txtA);

        pnlInput.add(new JLabel("Nhập số b:"));
        txtB = new JTextField();
        pnlInput.add(txtB);

        pnlInput.add(new JLabel("Nhập số c:"));
        txtC = new JTextField();
        pnlInput.add(txtC);

        add(pnlInput, BorderLayout.CENTER);

        JPanel pnlBottom = new JPanel(new GridLayout(3, 1, 5, 5));
        
        btnSapXep = new JButton("Sắp xếp ngay");
        btnReset = new JButton("Làm mới");
        lblKetQua = new JLabel("Kết quả: ", SwingConstants.CENTER);
        lblKetQua.setFont(new Font("Arial", Font.BOLD, 15));
        lblKetQua.setForeground(Color.RED);

        pnlBottom.add(btnSapXep);
        pnlBottom.add(btnReset);
        pnlBottom.add(lblKetQua);

        add(pnlBottom, BorderLayout.SOUTH);

        btnSapXep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thucHienSapXep();
            }
        });

        btnReset.addActionListener(e -> {
            txtA.setText("");
            txtB.setText("");
            txtC.setText("");
            lblKetQua.setText("Kết quả: ");
        });
    }

    private void thucHienSapXep() {
        try {
            int a = Integer.parseInt(txtA.getText());
            int b = Integer.parseInt(txtB.getText());
            int c = Integer.parseInt(txtC.getText());

            int[] numbers = {a, b, c};
            Arrays.sort(numbers);

            String result = formatNumber(numbers[0]) + ", " + 
                            formatNumber(numbers[1]) + ", " + 
                            formatNumber(numbers[2]);
            
            lblKetQua.setText("Kết quả: " + result);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi: Vui lòng chỉ nhập số thực!", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String formatNumber(double d) {
        if (d == (long) d) return String.format("%d", (long) d);
        else return String.format("%s", d);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SapXepBaSoGUI().setVisible(true);
        });
    }
}