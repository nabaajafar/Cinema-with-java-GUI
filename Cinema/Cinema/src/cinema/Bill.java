/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema;

/**
 *
 * @author LENOVO
 */
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Bill extends JFrame {

    public static String nameuser;
    public static String chrnum;
    public static String chirtype;
    public static String moviname;
    public static String movedate;

    Book bk = new Book();

    Icon bug6 = new ImageIcon(getClass().getResource("Parcode3.png"));

    ImageIcon b = new ImageIcon(getClass().getResource("t.jpg"));
    JLabel label = new JLabel(b, JLabel.CENTER);
    Image img = b.getImage();

    JPanel jpt = new JPanel();

    JLabel lbl = new JLabel("Select Ok to confirm your booked ");

    JButton ok = new JButton("OK");

    JTextArea order = new JTextArea(15, 30);

    public Bill() {

        super("Bill");

        order.setBackground(new Color(0, 0, 0, 60));
        order.setEditable(false);

        String dburl = "jdbc:mysql://localhost:3306/copy_cinema?cinemaresveSSL=true";
        String dbuser = "root";
        String dbpass = "24680";
        try {
            Connection cont = DriverManager.getConnection(dburl, dbuser, dbpass);
            System.out.println("bill Connected Successfully!!!");
            String query = String.format("select * from cinemaresve r NATURAL JOIN users u where r.username = u.username;");

            Statement s = cont.createStatement();
            ResultSet rs = s.executeQuery(query);
            if (rs.last()) {
                nameuser = rs.getString(1);
                chrnum = rs.getString(2);
                chirtype = rs.getString(3);
                moviname = rs.getString(4);
                movedate = rs.getString(6);
            }
        } catch (SQLException exp) {
            System.out.println(exp.getMessage());
        }

        String odertext = "\tUsername: " + nameuser + "\n\tYou booked " + chrnum + " chair/s\n\tChair type: " + chirtype
                + "\n\tName of Movie: " + moviname + "\n\tDate of Movie: " + movedate;
        order.setText(odertext);
        order.setForeground(Color.WHITE);

        setLayout(null);
        b.setImage(img.getScaledInstance(400, 400, Image.SCALE_SMOOTH));

        add(label);
        label.setBounds(0, 0, 400, 400);

        lbl.setForeground(Color.WHITE);
        jpt.add(lbl);
        jpt.add(order);

        ok.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(rootPane, "Your Total Price= " + (bk.Total_Price) + "\n And you can use this parcode to enter the hall \n\t Thank you for using our application..", "Total & Parcode", JOptionPane.INFORMATION_MESSAGE, bug6);

            }

        }
        );

        jpt.add(ok);

        jpt.setBounds(20, 10, 360, 390);
        jpt.setBackground(new Color(0, 0, 0, 30));
        label.add(jpt);

    }

}
