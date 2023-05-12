package edu.sample;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * Swingアプリ「足し算電卓」クラス
 */
public class AdditionCalculator extends JFrame {

  private static final long serialVersionUID = 8116650480897253904L;

  private JPanel contentPane;
  private JTextField textFieldValue1;
  private JTextField textFieldValue2;
  private JLabel lblResultLable;

  public AdditionCalculator() {
    setTitle("足し算電卓");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 717, 106);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    textFieldValue1 = new JTextField();
    textFieldValue1.setHorizontalAlignment(SwingConstants.RIGHT);
    textFieldValue1.setText("");
    textFieldValue1.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
    textFieldValue1.setBounds(12, 10, 104, 40);
    contentPane.add(textFieldValue1);
    textFieldValue1.setColumns(10);

    JLabel label = new JLabel("+");
    label.setHorizontalAlignment(SwingConstants.CENTER);
    label.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
    label.setBounds(131, 20, 21, 17);
    contentPane.add(label);

    textFieldValue2 = new JTextField();
    textFieldValue2.setHorizontalAlignment(SwingConstants.RIGHT);
    textFieldValue2.setText("");
    textFieldValue2.setFont(new Font("MS UI Gothic", Font.PLAIN, 18));
    textFieldValue2.setColumns(10);
    textFieldValue2.setBounds(177, 10, 104, 40);
    contentPane.add(textFieldValue2);

    lblResultLable = new JLabel("");
    lblResultLable.setFont(new Font("MS UI Gothic", Font.PLAIN, 28));
    lblResultLable.setBounds(375, 10, 314, 40);
    contentPane.add(lblResultLable);

    JButton button = new JButton("=");
    button.addActionListener(null/* TODO:イベントリスナーインスタンス */);
    button.setBounds(298, 11, 52, 40);
    contentPane.add(button);
  }
}
