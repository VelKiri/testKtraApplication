
package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui_Bai_1 extends JFrame {
    private JTextField txtDai, txtRong;
    private JLabel lblKetQua;

    public Gui_Bai_1() {
        setTitle("Tính diện tích hình chữ nhật");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel chính
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));

        // Components
        panel.add(new JLabel("Chiều dài:"));
        txtDai = new JTextField();
        panel.add(txtDai);

        panel.add(new JLabel("Chiều rộng:"));
        txtRong = new JTextField();
        panel.add(txtRong);

        JButton btnTinh = new JButton("Tính");
        panel.add(btnTinh);

        lblKetQua = new JLabel("Kết quả: ");
        panel.add(lblKetQua);

        add(panel);

        // Xử lý sự kiện nút bấm
        btnTinh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int dai = Integer.parseInt(txtDai.getText());
                    int rong = Integer.parseInt(txtRong.getText());

                    if (dai <= 0 || rong <= 0) {
                        lblKetQua.setText("Dữ liệu không hợp lệ!");
                    } else {
                        int dt = dai * rong;
                        lblKetQua.setText("Diện tích: " + dt);
                    }

                } catch (Exception ex) {
                    lblKetQua.setText("Vui lòng nhập số!");
                }
            }
        });
    }    
    public static void main(String[] args) {
        new Gui_Bai_1().setVisible(true);
    }
}
