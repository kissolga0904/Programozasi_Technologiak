import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Main {
    public static Logger LOGGER = LogManager.getLogger("progTech");
    static boolean tablazatLathato = false;
    public static void main(String[] args){
        LOGGER.info("start");
        ImageIcon image = new ImageIcon("logo.png");

        JFrame frame = new JFrame();
        frame.setTitle("System manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(1000,800);
        JLabel label = new JLabel();
        label.setText("Welcome to GLS warehouse system manager");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);
        label.setForeground(Color.blue);
        label.setFont(new Font("Serif", Font.PLAIN, 40));
        label.setBounds(30,20,900,400);
        frame.add(label);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 80,10));

        JPanel table = new JPanel();
        table.setVisible(false);
        JPanel texts = new JPanel();
        texts.setVisible(false);
        JButton megtekintes = new JButton("View all products");

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

        /*
        String[] oszlopok = { "Név", "Szín", "Súly", "Típus", "Gyártó" };
        DefaultTableModel tableModel = new DefaultTableModel();
        String[][] data = {
                { "geci", "4031", "CSE", "geagsgt", "hbsbx" },
                { "Anand Jha", "6014", "IT", "jgjjFJJFJ", "KKKFKKF" }
        };
         */
        JTable tablazat = new JTable(new DefaultTableModel());
        DefaultTableModel tableModel = (DefaultTableModel) tablazat.getModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("Color");
        tableModel.addColumn("Weight");
        tableModel.addColumn("Type");
        tableModel.addColumn("Producer");


        Product product = new Product.Builder("Coffee maker",TermekSzin.RED,"automata", Gyartok.DELONGHI).suly(5).build();
        tableModel.addRow(new Object[]{product.getNev(),product.getSzin().toString(),product.getSuly(),product.getTipus(),product.getGyarto()});
        System.out.println(tablazat.getRowCount());

        megtekintes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == megtekintes){
                    if(tablazatLathato){
                        return;
                    }
                    tablazatLathato = true;
                    JScrollPane scrollPane = new JScrollPane(tablazat);
                    tablazat.setBounds(30,40,200,300);
                    table.add(scrollPane);
                    frame.getContentPane().add(table);
                    table.setVisible(true);

                    nev.setPreferredSize(new Dimension(100,25));
                    Nev.setBounds(60,40,400,400);
                    Nev.setFont(new Font("Serif", Font.PLAIN, 16));
                    texts.add(Nev);
                    texts.add(nev);

                    szin.setPreferredSize(new Dimension(100,25));
                    Szin.setBounds(60,40,400,400);
                    Szin.setFont(new Font("Serif", Font.PLAIN,16));
                    texts.add(Szin);
                    texts.add(szin);

                    suly.setPreferredSize(new Dimension(100,25));
                    Suly.setBounds(60,40,400,400);
                    Suly.setFont(new Font("Serif", Font.PLAIN,16));
                    texts.add(Suly);
                    texts.add(suly);

                    tipus.setPreferredSize(new Dimension(100,25));
                    Tipus.setBounds(60,40,400,400);
                    Tipus.setFont(new Font("Serif", Font.PLAIN,16));
                    texts.add(Tipus);
                    texts.add(tipus);

                    gyarto.setPreferredSize(new Dimension(100,25));
                    Gyarto.setBounds(60,40,400,400);
                    Gyarto.setFont(new Font("Serif", Font.PLAIN,16));
                    texts.add(Gyarto);
                    texts.add(gyarto);

                    frame.getContentPane().add(texts);
                    texts.setVisible(true);
                }
            }
        });

        tablazat.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tablazat.rowAtPoint(e.getPoint());
                int col = tablazat.columnAtPoint(e.getPoint());
                ArrayList data = new ArrayList();
                if(row >= 0 && col >= 0){
                    for(int i = 0; i < tablazat.getColumnCount(); i++){
                        data.add(tablazat.getValueAt(row,i).toString());
                    }
                    nev.setText(data.get(0).toString());
                    szin.setText(data.get(1).toString());
                    suly.setText(data.get(2).toString());
                    tipus.setText(data.get(3).toString());
                    gyarto.setText(data.get(4).toString());
                }
            }
        });

        frame.add(megtekintes);
        JButton hozzaadas = new JButton("Add");
        hozzaadas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == hozzaadas){
                    Add addwindow = new Add();
                }
            }
        });
        frame.add(hozzaadas);

        JButton modositas = new JButton("Modify");
        frame.add(modositas);

        JButton torles = new JButton("Delete");
        torles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == torles){
                    Delete deletewindow = new Delete();
                }
            }
        });
        frame.add(torles);
        JButton kovetkezo = new JButton("Next page");
        frame.add(kovetkezo);

        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(new Color(162,192,218));

        frame.setVisible(true);
    }
}
