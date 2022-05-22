import javax.swing.*;
import java.awt.*;

public class Delete {
    ImageIcon image = new ImageIcon("logo.png");

    JFrame frame = new JFrame();
    JLabel label = new JLabel("Deleted successfully");



    Delete(){
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,200);
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(new Color(162,192,218));
        frame.setTitle("Delete");
        frame.setResizable(false);
        label.setBounds(30,20,730,400);
        label.setFont(new Font("Serif", Font.PLAIN, 30));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setForeground(Color.blue);
        frame.add(label);
        frame.setVisible(true);
    }
}
