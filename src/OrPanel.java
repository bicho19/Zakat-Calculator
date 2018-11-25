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

class OrPanel extends JPanel {
    private final Color bgColor = MaterialColors.AMBER_400;
    private final String zakatTitle = "Total Zakat: ";

    OrPanel() {
        //To position the elements manually with setBounds
        this.setLayout(null);
        setBackground(bgColor);


        /*
                Main Blick
         */
        JLabel panelTitle  =new JLabel("Or (Gold)");
        panelTitle.setBounds(250, 30, 300, 40);
        panelTitle.setForeground(Color.black);
        panelTitle.setFont(panelTitle.getFont().deriveFont(40f));
        add(panelTitle);


        JLabel goldTypeLabelTxt =new JLabel("Quel est le type d'or ? ");
        goldTypeLabelTxt.setBounds(100, 110, 200, 20);
        goldTypeLabelTxt.setForeground(Color.black);
        add(goldTypeLabelTxt);

        ButtonGroup  goldTypeBG =new ButtonGroup ();

        JCheckBoxMenuItem choix1=new JCheckBoxMenuItem("24 carats");
        choix1.setBounds(110, 130, 100, 20);
        choix1.setForeground(Color.black);
        choix1.setBackground(bgColor);
        goldTypeBG.add(choix1);
        add(choix1);

        JCheckBoxMenuItem choix2=new JCheckBoxMenuItem("21 carats");
        choix2.setBounds(110, 150, 100, 20);
        choix2.setForeground(Color.black);
        choix2.setBackground(bgColor);
        goldTypeBG.add(choix2);
        add(choix2);

        JCheckBoxMenuItem choix3=new JCheckBoxMenuItem("18 carats");
        choix3.setBounds(110, 170, 100, 20);
        choix3.setForeground(Color.black);
        choix3.setBackground(bgColor);
        goldTypeBG.add(choix3);
        add(choix3);

        JLabel quantite =new JLabel("Quantité (g): ");
        quantite.setBounds(110, 220, 200, 20);
        quantite.setForeground(Color.black);
        add(quantite);



        JLabel prix =new JLabel("prix de gramme(DA): ");
        prix.setBounds(110, 250, 200, 20);
        prix.setForeground(Color.black);
        add(prix);

        JLabel errorTxt = new JLabel("Error ! Please check all the fields");
        errorTxt.setBounds(250, 290, 300, 20);
        errorTxt.setForeground(Color.RED);
        errorTxt.setVisible(false);
        add(errorTxt);

        JLabel zakatPrice = new JLabel(zakatTitle);
        zakatPrice.setBounds(180, 340, 300, 20);
        zakatPrice.setForeground(Color.black);
        zakatPrice.setVisible(false);
        add(zakatPrice);

        JTextField quantityTextField = new JTextField();
        quantityTextField.setBounds(250, 210, 100, 40);
        add(quantityTextField);
        quantityTextField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (errorTxt.isVisible()) errorTxt.setVisible(false);
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c=='.')
                )) {
                    e.consume();
                }
            }
        });


        JTextField priceTextField = new JTextField();
        priceTextField.setBounds(250, 240, 100, 40);
        add(priceTextField);
        priceTextField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (errorTxt.isVisible()) errorTxt.setVisible(false);
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c=='.')
                )) {
                    e.consume();
                }
            }
        });

        JButton calculBtn = new JButton("Calculer");
        calculBtn.setBounds(430, 230, 120, 40);
        calculBtn.setBackground(MaterialColors.BLUE_GRAY_500);
        MaterialUIMovement.add(calculBtn, MaterialColors.BLUE_GRAY_300);
        calculBtn.setForeground(Color.white);
        add(calculBtn);


        calculBtn.addActionListener(e -> {

            /*
                    Calcuation Block
             */

            if ((quantityTextField.getText().length() > 0) && (priceTextField.getText().length() > 0)) {
                errorTxt.setVisible(false);
                zakatPrice.setVisible(true);
                float quantity = Float.parseFloat(quantityTextField.getText());
                float price = Float.parseFloat(priceTextField.getText());

                if ((quantity >= 85) && (choix1.isSelected()))
                    zakatPrice.setText(zakatTitle + quantity * price * 1 / 40 + " DA, prix de " + quantity * 1 / 40 + "g");
                else {
                    if ((quantity >= 97) && (choix2.isSelected()))
                        zakatPrice.setText(zakatTitle + quantity * price * 1 / 40 + " DA, prix de " + quantity * 1 / 40 + "g");
                    else {
                        if ((quantity >= 113) && (choix3.isSelected()))
                            zakatPrice.setText(zakatTitle + quantity * price * 1 / 40 + " DA, prix de " + quantity * 1 / 40 + "g");
                        else
                            zakatPrice.setText(zakatTitle + " Quorum n'est pas atteint ");
                    }


                }

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
