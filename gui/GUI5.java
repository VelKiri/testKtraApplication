package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class GUI5 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tìm Số Lớn Nhất");
        frame.setSize(450, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Nhãn và ô nhập liệu
        JLabel lblA = new JLabel("Nhập a:");
        lblA.setBounds(30, 30, 80, 25);
        frame.add(lblA);
        JTextField txtA = new JTextField();
        txtA.setBounds(120, 30, 250, 25);
        frame.add(txtA);

        JLabel lblB = new JLabel("Nhập b:");
        lblB.setBounds(30, 70, 80, 25);
        frame.add(lblB);
        JTextField txtB = new JTextField();
        txtB.setBounds(120, 70, 250, 25);
        frame.add(txtB);

        JLabel lblC = new JLabel("Nhập c:");
        lblC.setBounds(30, 110, 80, 25);
        frame.add(lblC);
        JTextField txtC = new JTextField();
        txtC.setBounds(120, 110, 250, 25);
        frame.add(txtC);

        // Khu vực hiển thị kết quả
        JTextArea txtResult = new JTextArea();
        txtResult.setEditable(false);
        txtResult.setFont(new Font("Arial", Font.BOLD, 13));
        JScrollPane scrollPane = new JScrollPane(txtResult);
        scrollPane.setBounds(30, 200, 370, 80);
        frame.add(scrollPane);

        // Nút tính toán
        JButton btnFindMax = new JButton("Tìm Số Lớn Nhất");
        btnFindMax.setBounds(120, 155, 180, 30);
        frame.add(btnFindMax);

        btnFindMax.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Double> numbers = new ArrayList<>();
                try {
                    // Kiểm tra và lấy giá trị từ các ô (nếu rỗng thì bỏ qua)
                    if (!txtA.getText().trim().isEmpty()) 
                        numbers.add(Double.parseDouble(txtA.getText().trim()));
                    if (!txtB.getText().trim().isEmpty()) 
                        numbers.add(Double.parseDouble(txtB.getText().trim()));
                    if (!txtC.getText().trim().isEmpty()) 
                        numbers.add(Double.parseDouble(txtC.getText().trim()));

                    if (numbers.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Vui lòng nhập ít nhất một số!");
                        return;
                    }

                    // Tìm số lớn nhất
                    double max = Collections.max(numbers);
                    
                    // Định dạng chuỗi hiển thị số đã nhập
                    String inputStr = numbers.toString().replace("[", "").replace("]", "");
                    txtResult.setText("Số lớn nhất của các số (" + inputStr + ") là: " + max);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Lỗi: Vui lòng chỉ nhập chữ số!");
                }
            }
        });

        frame.setLocationRelativeTo(null); // Hiển thị giữa màn hình
        frame.setVisible(true);
    }
}