
package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui_Bai_2 extends JFrame {
    private JTextField txtKm;
    private JLabel lblKetQua;

    public Gui_Bai_2() {
        setTitle("Tính tiền Taxi");
        setSize(350, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        // Components
        panel.add(new JLabel("Số km:"));
        txtKm = new JTextField();
        panel.add(txtKm);

        JButton btnTinh = new JButton("Tính tiền");
        panel.add(btnTinh);

        lblKetQua = new JLabel("Kết quả: ");
        panel.add(lblKetQua);

        add(panel);

        // Sự kiện nút
        btnTinh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double km = Double.parseDouble(txtKm.getText());

                    if (km < 0) {
                        lblKetQua.setText("Dữ liệu sai!");
                    } else {
                        double tien = km * 10000; // bạn đang dùng 10k/km
                        lblKetQua.setText("Tiền taxi: " + tien + " VND");
                    }

                } catch (Exception ex) {
                    lblKetQua.setText("Vui lòng nhập số!");
                }
            }
        });
    }
    public static void main(String[] args) {
        new Gui_Bai_2().setVisible(true);
    }
}
