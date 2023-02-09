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
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.net.URL;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Register extends JFrame {

    public static String MovName;
    public static String MovDate;

    JLabel lbl1 = new JLabel("Enjoy");
    JLabel lbl2 = new JLabel("Select Movie:  ");
    JLabel lbl3 = new JLabel("Date & Showtime");
    JLabel lbldate = new JLabel();

    DateFormat dateFormat = new SimpleDateFormat("EEEE,MMMMM dd, yyyy");
    Date date = new Date();

    URL u = getClass().getResource("1.jpg");
    Icon i = new ImageIcon(u);
    JLabel ilbl = new JLabel(i);

    String[] movies = {"Your Selected", "The Pact", "The Grinch", "The Nutcracker and the Four Realms", "On Your Wedding Day", "Small Foot", "Aterrados", "Mirai no Mirai"};
    String[] dat = {"Date of show", "Thursday,Apr 18,2019", "Monday,Apr 22,2019", "Thursday,Apr 25,2019", "Saturday,Apr 27,2019"};

    JComboBox movie = new JComboBox(movies);
    JComboBox datee = new JComboBox(dat);

    JTextArea discrabe = new JTextArea();

    JButton book = new JButton("Book");
    JButton about = new JButton("About us");

    public Register() {
        super("WELCOME");
        setLayout(null);

        lbl1.setFont(new Font("Times New Roman", 1, 24));
        add(lbl1);
        lbl1.setBounds(60, 20, 240, 30);

        lbldate.setText(dateFormat.format(date));
        lbldate.setFont(new Font("Tahoma", 0, 12));
        lbldate.setForeground(new Color(255, 0, 0));
        add(lbldate);
        lbldate.setBounds(60, 55, 250, 20);

        add(lbl2);
        lbl2.setBounds(60, 80, 250, 20);

        discrabe.setEditable(false);
        ilbl.setBounds(400, 30, 300, 300);

        movie.setMaximumRowCount(4);
        movie.setBounds(60, 100, 240, 30);
        movie.addItemListener(
                new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (movie.getSelectedIndex() == 1) {
                    u = getClass().getResource("2.jpg");
                    i = new ImageIcon(u);
                    ilbl.setIcon(i);
                    discrabe.setText("When Monica's daughter Carla is found unconscious\n"
                            + "she soon passes away. Desperate, Monica takes part\n"
                            + " in a mysterious ritual that awakens Clara, but marks\n"
                            + "the beginning of a dark and terrifying journey.\n"
                            + "Initial release: August 17, 2018 (Spain)\n"
                            + "Director: David Victori\n"
                            + "Producers: Edmon Roch, Jordi Gasull,\n"
                            + "Ignacio Salazar-Simpson, Ricardo Marco Budé\n"
                            + "Screenplay: David Victori, Jordi Vallejo");
                    discrabe.setBounds(60, 150, 300, 150);
                    MovName = movies[1];

                }
                if (movie.getSelectedIndex() == 2) {
                    u = getClass().getResource("3.jpg");
                    i = new ImageIcon(u);
                    ilbl.setIcon(i);
                    discrabe.setText("A grumpy Grinch plots to ruin Christmas for the\n"
                            + "village of Whoville.\n"
                            + "Initial release: October 22, 2018 (Westwood)\n"
                            + "Directors: Yarrow Cheney, Scott Mosier\n"
                            + "Box office: $510.7 million\n"
                            + "Narrator: Pharrell Williams");
                    discrabe.setBounds(60, 150, 300, 150);
                    MovName = movies[2];

                }
                if (movie.getSelectedIndex() == 3) {
                    u = getClass().getResource("4.jpg");
                    i = new ImageIcon(u);
                    ilbl.setIcon(i);
                    discrabe.setText("Young Clara needs a magical, one-of-a-kind key\n"
                            + " to unlock a box that contains a priceless gift\n"
                            + " A golden thread leads her to the coveted key,\n"
                            + " but it soon disappears into a strange and\n "
                            + " mysterious parallel world. In that world,\n"
                            + " she meets a soldier named Phillip,\n"
                            + " a group of mice and the regents who preside\n"
                            + " over three realms. Clara and Phillip must now "
                            + "\n enter a fourth realm to retrieve the key.");
                    discrabe.setBounds(60, 150, 300, 150);
                    MovName = movies[3];

                }
                if (movie.getSelectedIndex() == 4) {
                    u = getClass().getResource("5.jpg");
                    i = new ImageIcon(u);
                    ilbl.setIcon(i);
                    discrabe.setText("A man receives a wedding invitation from his\n"
                            + "first love, whom he met in high school.\n"
                            + "Initial release: August 22, 2018 (South Korea)\n"
                            + "Director: Lee Sukgeun\n"
                            + "Cinematography: Lee Seong-jae\n"
                            + "Hangul: 너의 결혼식\n"
                            + "Nominations: Blue Dragon Film Award for\n"
                            + " Best New Actor, MORE");
                    discrabe.setBounds(60, 150, 300, 150);
                    MovName = movies[4];

                }
                if (movie.getSelectedIndex() == 5) {
                    u = getClass().getResource("6.jpg");
                    i = new ImageIcon(u);
                    ilbl.setIcon(i);

                    discrabe.setText("Migo is a friendly Yeti whose world gets\n"
                            + "turned upside down when he discovers \n"
                            + "something that he didn't know existed \n"
                            + "a human. He soon faces banishment from\n"
                            + "his snowy home when the rest of \n"
                            + "the villagers refuse to believe his \n"
                            + "fantastic tale. Hoping to prove them wrong\n"
                            + " Migo embarks on an epic journey to find the mysterious");
                    discrabe.setBounds(60, 150, 300, 150);
                    MovName = movies[5];

                }
                if (movie.getSelectedIndex() == 6) {
                    u = getClass().getResource("7.jpg");
                    i = new ImageIcon(u);
                    ilbl.setIcon(i);
                    discrabe.setText("Paranormal researchers investigate strange events\n"
                            + "in a neighborhood in Buenos Aires.\n"
                            + "Initial release: May 3, 2018 (Argentina)\n"
                            + "Director: Demián Rugna\n"
                            + "Language: Spanish\n"
                            + "Music composed by: Demián Rugna\n"
                            + "Screenplay: Demián Rugna");
                    discrabe.setBounds(60, 150, 300, 150);
                    MovName = movies[6];

                }
                if (movie.getSelectedIndex() == 7) {
                    u = getClass().getResource("8.jpg");
                    i = new ImageIcon(u);
                    ilbl.setIcon(i);
                    discrabe.setText("A young boy named Kun feels forgotten by his\n"
                            + " family when his little sister Mirai arrives.\n"
                            + " Running away from home, Kun stumbles upon \n"
                            + "a magical garden that serves as a time-travelling\n"
                            + " gateway where he encounters his mother as a little\n"
                            + " girl and has a series of adventures with his baby \n "
                            + "sister, who is all grown up, opening \n"
                            + "a new perspective on his world");
                    discrabe.setBounds(60, 150, 300, 150);
                    MovName = movies[7];

                }
                add(lbl3);
                lbl3.setBounds(60, 310, 110, 15);
                lbl3.setFont(new Font("Tahoma", 0, 12));
                lbl3.setForeground(new Color(0, 102, 255));

                datee.setMaximumRowCount(3);
                add(datee);
                datee.setBounds(170, 305, 150, 30);

                add(book);
                book.setBounds(60, 350, 100, 50);
            }
        }
        );
        book.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Book booked = new Book();
                booked.setVisible(true);
                booked.setSize(350, 400);
                booked.setDefaultCloseOperation(2);
                booked.setLocationRelativeTo(null);
                booked.setResizable(false);

            }

        }
        );

        add(movie);
        add(ilbl);
        add(discrabe);

        about.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(rootPane, "Nabaa Jafar\nZainab Saleh\nSara Sharaf\nReham Adnan", "About us", JOptionPane.INFORMATION_MESSAGE);
            }

        }
        );
        about.setBounds(600, 550, 100, 50);
        add(about);
        about.setToolTipText("Who make this Applcation");

        datee.addItemListener(
                new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (datee.getSelectedIndex() == 1) {
                    MovDate = dat[1];
                }
                if (datee.getSelectedIndex() == 2) {
                    MovDate = dat[2];
                }
                if (datee.getSelectedIndex() == 3) {
                    MovDate = dat[3];
                }
                if (datee.getSelectedIndex() == 4) {
                    MovDate = dat[4];
                }

            }
        }
        );

    }

}
