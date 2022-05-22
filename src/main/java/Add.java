import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add {
    ImageIcon image = new ImageIcon("logo.png");

    JFrame frame = new JFrame();
    JLabel label = new JLabel("Add a new product!");

    JTextField nev = new JTextField();
    JLabel Nev = new JLabel("Name");

    JTextField szin = new JTextField();
    JLabel Szin = new JLabel("Color");

    JTextField suly = new JTextField();
    JLabel Suly = new JLabel("Weight");

    JTextField tipus = new JTextField();
    JLabel Tipus = new JLabel("Type");

    JTextField gyarto = new JTextField();
    JLabel Gyarto = new JLabel("Producer");

    JButton mentes = new JButton("Save");
    Add(){
        label.setBounds(30,20,730,400);
        label.setFont(new Font("Serif", Font.PLAIN, 30));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);
        label.setForeground(Color.blue);
        frame.add(label);
        frame.setSize(800,200);
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(new Color(162,192,218));
        frame.setTitle("Add new product");
        frame.setResizable(false);
        frame.setLayout(new FlowLayout(FlowLayout.RIGHT,20,10));

        nev.setPreferredSize(new Dimension(150,25));
        Nev.setBounds(60,40,730,400);
        Nev.setFont(new Font("Serif", Font.PLAIN, 20));
        frame.add(Nev);
        frame.add(nev);

        szin.setPreferredSize(new Dimension(150,25));
        Szin.setBounds(60,40,730,400);
        Szin.setFont(new Font("Serif", Font.PLAIN,20));
        frame.add(Szin);
        frame.add(szin);

        suly.setPreferredSize(new Dimension(150,25));
        Suly.setBounds(60,40,730,400);
        Suly.setFont(new Font("Serif", Font.PLAIN,20));
        frame.add(Suly);
        frame.add(suly);

        tipus.setPreferredSize(new Dimension(150,25));
        Tipus.setBounds(60,40,730,400);
        Tipus.setFont(new Font("Serif", Font.PLAIN,20));
        frame.add(Tipus);
        frame.add(tipus);

        gyarto.setPreferredSize(new Dimension(150,25));
        Gyarto.setBounds(60,40,730,400);
        Gyarto.setFont(new Font("Serif", Font.PLAIN,20));
        frame.add(Gyarto);
        frame.add(gyarto);

        mentes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == mentes){
                    System.out.println("elmenti");
                }
            }
        });
        frame.add(mentes);
        frame.setVisible(true);
    }
}
