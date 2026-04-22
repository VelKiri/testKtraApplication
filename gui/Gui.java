/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui extends JFrame {
    public Gui() {
        setTitle("Main GUI");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 4)); // 2 hàng, 4 cột

        for (int i = 1; i <= 8; i++) {
            JButton button = new JButton("GUI " + i);
            int index = i; // cần biến final để dùng trong lambda
            button.addActionListener(e -> openGUI(index));
            add(button);
        }
    }

    private void openGUI(int index) {
        JFrame frame = new JFrame("GUI " + index);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(new JLabel("Đây là GUI số " + index, SwingConstants.CENTER));
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Gui().setVisible(true);
        });
    }
}
