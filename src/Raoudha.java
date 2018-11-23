import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Raoudha {

    public static void main(String[] args) {

        JFrame f=new JFrame("Zakat Calculator");
        f.setSize(680, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font1 = new Font("Garamnod",Font.BOLD,20);
        Font font2 = new Font("Garamnod",Font.BOLD,60);


        JPanel pan =new JPanel();
        f.setContentPane(pan);
        pan.setLayout(null);
        pan.setBackground(Color.BLUE);



        JLabel title =new JLabel("Zakat");
        title.setBackground(Color.BLUE);
        title.setFont(font2);
        title.setForeground(Color.white);
        title.setBounds(300, 180, 200, 70);
        pan.add(title);

        JLabel title1 =new JLabel("Calculator");
        title1.setBackground(Color.BLUE);
        title1.setFont(font2);
        title1.setForeground(Color.white);
        title1.setBounds(350, 240, 400, 70);
        pan.add(title1);

        JButton bbetails =new JButton("Bétails");
        bbetails.setBounds(25, 100, 200, 50);
        bbetails.setBackground(Color.GREEN);
        bbetails.setBorder(BorderFactory.createLineBorder(Color.white,2));
        bbetails.setForeground(Color.white);
        bbetails.setFont(font1);
        pan.add(bbetails);



        JButton bor =new JButton("Or");
        bor.setBounds(50, 160, 200, 50);
        pan.add(bor);
        bor.setBackground(Color.GREEN);
        bor.setBorder(BorderFactory.createLineBorder(Color.white,2));
        bor.setForeground(Color.white);
        bor.setFont(font1);



        JButton bargent =new JButton("Argent");
        bargent.setBounds(25, 220, 200, 50);
        bargent.setBackground(Color.GREEN);
        bargent.setBorder(BorderFactory.createLineBorder(Color.white,2));
        bargent.setForeground(Color.white);
        bargent.setFont(font1);

        pan.add(bargent);

        JButton bnumeraires =new JButton("Numéraires");
        bnumeraires.setBounds(50, 280, 200, 50);
        pan.add(bnumeraires);
        bnumeraires.setBackground(Color.GREEN);
        bnumeraires.setBorder(BorderFactory.createLineBorder(Color.white,2));
        bnumeraires.setForeground(Color.white);
        bnumeraires.setFont(font1);



        JButton bprodag =new JButton("Produits Agricoles");
        bprodag.setBounds(25, 340, 200, 50);
        pan.add(bprodag);
        bprodag.setBackground(Color.GREEN);
        bprodag.setBorder(BorderFactory.createLineBorder(Color.white,2));
        bprodag.setForeground(Color.white);
        bprodag.setFont(font1);


        f.setVisible(true);




    }
}
