/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema;

/**
 *
 * @author LENOVO
 *
 *
 */
import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Book extends JFrame {

    public static int Total_Price;

    JRadioButton vip = new JRadioButton("VIP");
    JRadioButton normal = new JRadioButton("NORMAL");

    ButtonGroup btnGroup = new ButtonGroup();

    JLabel hlbl = new JLabel("Please Choose The Hall Type");
    JLabel slbl = new JLabel(" ( Please Select Your Seet/s Number ) ");

    JTextField jl = new JTextField(" PRESS DONE To go to the bill ");

    JTextField scrlbl = new JTextField("                      SCREEN                         ");
    JTextField frountTxt = new JTextField("                                  FROUNT                                                  ");
    JTextField medTxt = new JTextField("                                     MEDDLE                                                  ");
    JTextField backTxt = new JTextField("                                     BACK                                                   ");

    JCheckBox cb1 = new JCheckBox("1");
    JCheckBox cb2 = new JCheckBox("2");
    JCheckBox cb3 = new JCheckBox("3");
    JCheckBox cb4 = new JCheckBox("4");
    JCheckBox cb5 = new JCheckBox("5");
    JCheckBox cb6 = new JCheckBox("6");
    JCheckBox cb7 = new JCheckBox("7");
    JCheckBox cb8 = new JCheckBox("8");
    JCheckBox cb9 = new JCheckBox("9");
    JCheckBox cb10 = new JCheckBox("10");
    JCheckBox cb11 = new JCheckBox("11");
    JCheckBox cb12 = new JCheckBox("12");
    JCheckBox cb13 = new JCheckBox("13");
    JCheckBox cb14 = new JCheckBox("14");
    JCheckBox cb15 = new JCheckBox("15");

    JCheckBox Done = new JCheckBox("DONE");
    ButtonGroup dg = new ButtonGroup();
    JButton btnbill = new JButton("The Bill");

    public Book() {
        super("BOOKING");
        setLayout(new FlowLayout());

        add(hlbl);
        btnGroup.add(normal);
        btnGroup.add(vip);
        add(normal);
        add(vip);

        add(slbl);
        add(scrlbl);
        scrlbl.setBackground(new Color(255, 255, 255));
        scrlbl.setEditable(false);

        add(frountTxt);
        frountTxt.setEditable(false);
        add(cb1);
        add(cb2);
        add(cb3);
        add(cb4);
        add(cb5);

        add(medTxt);
        medTxt.setEditable(false);
        add(cb6);
        add(cb7);
        add(cb8);
        add(cb9);
        add(cb10);

        add(backTxt);
        backTxt.setEditable(false);
        add(cb11);
        add(cb12);
        add(cb13);
        add(cb14);
        add(cb15);

        jl.setBackground(new Color(255, 255, 255));
        jl.setEditable(false);
        jl.setFont(new Font("SanSerif", Font.BOLD, 15));
        add(jl);

        add(Done);
        Done.addItemListener(
                new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {

                int i = 0;
                int total = 50;
                String chrtyp = "NORMAL";

                if (cb1.isSelected()) {
                    i++;
                }
                if (cb2.isSelected()) {
                    i++;
                }
                if (cb3.isSelected()) {
                    i++;
                }
                if (cb4.isSelected()) {
                    i++;
                }
                if (cb5.isSelected()) {
                    i++;
                }
                if (cb6.isSelected()) {
                    i++;
                }
                if (cb7.isSelected()) {
                    i++;
                }
                if (cb8.isSelected()) {
                    i++;
                }
                if (cb9.isSelected()) {
                    i++;
                }
                if (cb10.isSelected()) {
                    i++;
                }
                if (cb11.isSelected()) {
                    i++;
                }
                if (cb12.isSelected()) {
                    i++;
                }
                if (cb13.isSelected()) {
                    i++;
                }
                if (cb14.isSelected()) {
                    i++;
                }
                if (cb15.isSelected()) {
                    i++;
                }

                if (vip.isSelected()) {
                    total = 100;

                    chrtyp = "VIP";

                }

                if (normal.isSelected()) {
                    total = 50;

                    chrtyp = "NORMAL";
                }

                int chrno = i;

                int tol = total * chrno;

                String typchr = chrtyp;

                MyFrame frm = new MyFrame();
                Register rg = new Register();

                String dburl = "jdbc:mysql://localhost:3306/copy_cinema?cinemaresveSSL=true";
                String dbuser = "root";
                String dbpass = "24680";

                try {
                    Connection cont = DriverManager.getConnection(dburl, dbuser, dbpass);
                    System.out.println("done Connected Successfully!!!");

                    String xusername = frm.usen;
                    String MovName = rg.MovName;
                    String MovDate = rg.MovDate;

                    //2.insert into cinemaresve table
                    String sql = String.format("insert into cinemaresve (username,chairno,chairtype,mname,totalp,resDate)  values"
                            + " ('%s','%s','%s','%s','%s','%s');", xusername, chrno, typchr, MovName, tol, MovDate);
                    Total_Price = tol;

                    Statement st = cont.createStatement();
                    st.executeUpdate(sql);

                } catch (SQLException exp) {
                    System.out.println(exp.getMessage());
                }

                add(btnbill);
                btnbill.setBounds(120, 280, 90, 40);
            }
        }
        );

        btnbill.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Bill s = new Bill();
                s.setVisible(true);
                s.setDefaultCloseOperation(2);
                s.setSize(400, 400);
                s.setLocationRelativeTo(null);
                s.setResizable(false);
            }
        }
        );

    }

}
