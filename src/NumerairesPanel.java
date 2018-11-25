import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/*

    File Created by: Hachemi Hamadi
    Mini Project Module IHM : Zakat Calculator
    Source Code published on GitHub (@bicho19)
    Link : https://github.com/bicho19/Zakat-Calculator

 */

class NumerairesPanel extends JPanel {


    private final String zakatTitle = "Total Zakat: ";

    NumerairesPanel(){

        setLayout(null);
        setBackground(MaterialColors.CYAN_300);


        /*
                Main Bock
         */

        JLabel panelTitle  =new JLabel("Numeraires");
        panelTitle.setBounds(230, 30, 300, 40);
        panelTitle.setForeground(Color.white);
        panelTitle.setFont(panelTitle.getFont().deriveFont(40f));
        add(panelTitle);


        JLabel total$ = new JLabel("Montant (DA): ");
        total$.setBounds(100, 120, 200, 20);
        total$.setForeground(Color.white);
        add(total$);


        JLabel zakatPrice = new JLabel(zakatTitle);
        zakatPrice.setBounds(200, 290, 500, 20);
        zakatPrice.setForeground(Color.white);
        zakatPrice.setVisible(false);
        add(zakatPrice);

        JLabel errorTxt = new JLabel("Error ! Please check all the fields");
        errorTxt.setBounds(370, 120, 300, 20);
        errorTxt.setForeground(Color.RED);
        errorTxt.setVisible(false);
        add(errorTxt);


        JTextField total$Text = new JTextField();
        total$Text.setBounds(200, 110, 120, 40);
        add(total$Text);
        total$Text.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (errorTxt.isVisible()) errorTxt.setVisible(false);
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == '.')
                )) {
                    e.consume();
                }


            }
        });

        JButton calculBtn = new JButton("Calculer");
        calculBtn.setBounds(200, 180, 120, 40);
        calculBtn.setBackground(MaterialColors.TEAL_800);
        MaterialUIMovement.add(calculBtn, MaterialColors.TEAL_600);
        calculBtn.setForeground(MaterialColors.WHITE);
        add(calculBtn);


        calculBtn.addActionListener(e -> {

            if (total$Text.getText().length() > 0) {
                errorTxt.setVisible(false);
                zakatPrice.setVisible(true);
                float total = Float.parseFloat(total$Text.getText());
                float quorumActuel = 45050000; //price of 85g of gold
                if (total >= quorumActuel)
                    zakatPrice.setText(zakatTitle + total * 2.5 / 100 + "DA");
                else
                    zakatPrice.setText(zakatTitle + " Quorum n'est pas atteint ");
            } else {
                errorTxt.setVisible(true);
            }


        });








        //Return Home Button Block
        JButton returnBtn = new JButton("RETURN");
        returnBtn.setBackground(MaterialColors.RED_400);
        returnBtn.setBounds(540,420,120,30);
        MaterialUIMovement.add(returnBtn,MaterialColors.RED_200);
        //Set Icon to the Button
        returnBtn.setIcon(new ImageIcon(this.getClass().getResource("/icons/arrow-left.png")));
        returnBtn.setForeground(MaterialColors.WHITE);
        returnBtn.addActionListener(e -> returnHome());
        add(returnBtn);
    }

    private void returnHome(){
        Home.swap(this,new HomePanel());
    }

}
