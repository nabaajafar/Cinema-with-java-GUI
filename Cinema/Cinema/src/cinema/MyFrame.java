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
import java.applet.Applet;
import java.applet.AudioClip;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.net.URL;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame {

    public static Connection cont = null;
    public static Statement s = null;

    public static Connection OpenConnection() throws Exception {
        try {
            String dburl = "jdbc:mysql://localhost:3306/copy_cinema?usersSSL=true";
            String dbuser = "root";
            String dbpass = "24680";
            Connection cont = DriverManager.getConnection(dburl, dbuser, dbpass);
            System.out.println("Connected Successfully!!!");
            if (cont != null) {
                System.out.println("Detabase Connection Estabilshed");
            }
        } catch (SQLException exp) {
            System.out.println("Detabase Connection Faild");
            System.out.println(exp);
        }
        return cont;

    }

    JLabel lbl = new JLabel("Online reservation");
    JLabel namelabel = new JLabel("Username: ");
    JLabel passlabel = new JLabel("Password: ");
    JLabel namelbl = new JLabel("Enter the Username: ");
    JLabel reallbl = new JLabel("Enter your full name: ");
    JLabel cardlbl = new JLabel("Enter your credit card number: ");
    JLabel wordlbl = new JLabel("Enter your Password: ");
    JLabel done = new JLabel("Your will be automatically register after last step ");

    JTextField text = new JTextField(15);
    JTextField nametxt = new JTextField(15);
    JTextField realtxt = new JTextField(15);
    JTextField cardtxt = new JTextField(15);
    JTextField passtext = new JPasswordField(15);
    JTextField wordtxt = new JPasswordField(15);

    URL url = getClass().getResource("1.jpg");
    Icon icn = new ImageIcon(url);
    JLabel icnlbl = new JLabel(icn);

    JButton log = new JButton("Login");
    JButton create = new JButton("Create");

    JTabbedPane pane = new JTabbedPane();
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();

    JCheckBox cb1 = new JCheckBox("Iam not a reporter");

    URL url1 = getClass().getResource("Yanni-Nostalgia-Live-at-Royal-Albert-Hall.wav");
    AudioClip music = Applet.newAudioClip(url1);

    public static String usen;

    public MyFrame() {
        super("CINEMA");

        pane.addTab("Welcom to Cinema", p1);
        p1.setLayout(new FlowLayout());
        p2.setLayout(new GridLayout(10, 2, 25, 5));

        lbl.setFont(new Font("Calibri", Font.BOLD, 20));
        p1.add(lbl);
        p1.add(icnlbl);
        p1.add(namelabel);
        p1.add(text);
        p1.add(passlabel);
        p1.add(passtext);
        this.add(pane);

        log.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                music.loop();
                //log to db

                try {
                    String dburl = "jdbc:mysql://localhost:3306/copy_cinema?usersSSL=true";
                    String dbuser = "root";
                    String dbpass = "24680";
                    Connection cont = DriverManager.getConnection(dburl, dbuser, dbpass);
                    System.out.println("login Connected Successfully!!!");
                    //1. get username and password
                    String xusername = text.getText();
                    String xpss = passtext.getText();
                    //2. get all username and password
                    String query = "select * from users ; ";
                    Statement s = cont.createStatement();
                    ResultSet rs = s.executeQuery(query);
                    //3. compare every username and password from db 
                    //to the username and password from user
                    boolean flag = false;
                    while (rs.next()) {
                        if (rs.getObject(1).equals(xusername) && rs.getObject(4).equals(xpss)) {
                            usen = xusername;

                            Register ch = new Register();
                            ch.setVisible(true);
                            ch.setSize(720, 650);
                            ch.setDefaultCloseOperation(2);
                            flag = true;
                            break;
                        }
                    }
                    if (flag == false) {
                        JOptionPane.showMessageDialog(rootPane, "Username or password is not correct!!!", "Login", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (SQLException exp) {
                    System.out.println(exp.getMessage());
                }

            }

        }
        );
        p1.add(log);

        create.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                pane.addTab("Register", p2);
                add(pane);
                done.setFont(new Font("Calibri", Font.BOLD, 20));
                p2.add(done);
                p2.add(namelbl);
                p2.add(nametxt);
                p2.add(reallbl);
                p2.add(realtxt);
                p2.add(cardlbl);
                p2.add(cardtxt);
                p2.add(wordlbl);
                p2.add(wordtxt);
                p2.add(cb1);
                cb1.addItemListener(
                        new ItemListener() {

                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if (cb1.isSelected()) {
                            String a = null;
                            a = JOptionPane.showInputDialog(rootPane, "Enter what you see \n GM59H3!!!", "CHEACKING", JOptionPane.QUESTION_MESSAGE);
                            if (a.equals("GM59H3")) {
                                //db
                                String dburl = "jdbc:mysql://localhost:3306/copy_cinema?usersSSL=true";
                                String dbuser = "root";
                                String dbpass = "24680";

                                try {

                                    Connection cont = DriverManager.getConnection(dburl, dbuser, dbpass);
                                    System.out.printf("%s Register Connected Successfully!!!", dbuser);
                                    //1.input user 1
                                    String xfname = nametxt.getText();
                                    String xlname = realtxt.getText();
                                    String xusername = cardtxt.getText();
                                    String xpss = wordtxt.getText();
                                    //2.insert into db table
                                    String sql = String.format("insert into users(username,fullname,card,pass)  values"
                                            + " ('%s','%s','%s','%s');", xfname, xlname, xusername, xpss);

                                    Statement st = cont.createStatement();
                                    st.executeUpdate(sql);
                                    JOptionPane.showMessageDialog(rootPane, "Register");
                                    cont.close();
                                } catch (SQLException exp) {
                                    System.out.println(exp.getMessage());
                                }
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Sorry you are not able to register!!!", "REGISTERTION", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }

                }
                );

            }
        }
        );
        p1.add(create);
        create.setToolTipText("Create a new account");
    }

    private void closeConnection() throws SQLException {
        try {
            if (s != null) {
                s.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
