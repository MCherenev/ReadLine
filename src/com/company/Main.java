package com.company;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public Main() {

        JFrame frame = new JFrame("Окно");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JTextArea area = new JTextArea("Здесь будет текст");
        frame.add(area, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        frame.add(scrollPane);
        frame.setVisible(true);

        panel.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btnIncrease = new JButton("Прочитать");
        frame.add(btnIncrease, BorderLayout.SOUTH);


        btnIncrease.addActionListener(e -> {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException classNotFoundException) {
                JOptionPane.showMessageDialog(null,"Соединение не успешно");
                classNotFoundException.printStackTrace();
            }
            JOptionPane.showMessageDialog(null,"Соединение успешно");
            try {
                con = DriverManager.getConnection(url, username, password);
            } catch (SQLException throwables) {
                JOptionPane.showMessageDialog(null,"Ошибка при подключении к БД");
                throwables.printStackTrace();
            }
        });
        frame.setSize(500, 500);
    }

    private static final String url = "jdbc:mysql://127.0.0.1:3306/bakery";
   // private static final String url = "jdbc:mysql://localhost:3306/MySQL80";
    private static final String driverName = "oracle.jdbc.driver.OracleDriver";
    private static final String username = "root";
    private static final String password = "Ab12345@";
    public static Connection con;

    public static void main(String[] args) {
        Main app = new Main();
    }
}