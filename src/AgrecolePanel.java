import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/*
    File Created by: Hachemi Hamadi
    Mini Project Module IHM
    Source Code published on GitHub (@bicho19)

 */

public class AgrecolePanel extends JPanel {
    private final Color bgColor = MaterialColors.GREEN_300;

    public AgrecolePanel() {
        //To position the elements manually with setBounds
        setLayout(null);
        setBackground(bgColor);



        /*
            Main Block
         */

        ButtonGroup typeBG = new ButtonGroup();
        ButtonGroup irrigationBG = new ButtonGroup();


        JLabel panelTitle  =new JLabel("Produits Agricoles ");
        panelTitle.setBounds(200, 30, 300, 40);
        panelTitle.setForeground(Color.white);
        panelTitle.setFont(panelTitle.getFont().deriveFont(30f));
        add(panelTitle);



        JLabel produitTypeTxt =new JLabel("Quel produit agricole ? ");
        produitTypeTxt.setBounds(100, 100, 200, 20);
        produitTypeTxt.setForeground(Color.white);
        add(produitTypeTxt);

        JLabel typeIrrigationTxt =new JLabel("Type d'irrigation: ");
        typeIrrigationTxt.setBounds(400, 100, 200, 20);
        typeIrrigationTxt.setForeground(Color.white);
        add(typeIrrigationTxt);

        JCheckBoxMenuItem choix1=new JCheckBoxMenuItem("ble");
        choix1.setBounds(110, 120, 150, 20);
        choix1.setForeground(Color.white);
        choix1.setBackground(bgColor);
        typeBG.add(choix1);
        add(choix1);

        JCheckBoxMenuItem choix2=new JCheckBoxMenuItem("autre");
        choix2.setBounds(110, 140, 150, 20);
        choix2.setForeground(Color.white);
        choix2.setBackground(bgColor);
        typeBG.add(choix2);
        add(choix2);

        JCheckBoxMenuItem choix3=new JCheckBoxMenuItem("irrigation naturelle");
        choix3.setBounds(410, 120, 200, 20);
        choix3.setForeground(Color.white);
        choix3.setBackground(bgColor);
        irrigationBG.add(choix3);
        add(choix3);

        JCheckBoxMenuItem choix4=new JCheckBoxMenuItem("irrigation artificiellre");
        choix4.setBounds(410, 140, 200, 20);
        choix4.setForeground(Color.white);
        choix4.setBackground(bgColor);
        irrigationBG.add(choix4);
        add(choix4);




        JLabel montant =new JLabel("Quantité (Kg): ");
        montant.setBounds(100, 210, 200, 20);
        montant.setForeground(Color.white);
        add(montant);

		/* JLabel t  =new JLabel("Tapez des chiffres  seulement! ");
		  	t.setBounds(350, 200, 300, 20);
		  	t.setForeground(Color.red);
		  	t.setFont(font1);
		  	pan.add(t);*/


        JLabel total  =new JLabel("Total Zakat: ");
        total.setBounds(180, 300, 300, 20);
        total.setForeground(Color.white);
        add(total);

        JTextField textquantite =new JTextField();
        textquantite.setBounds(200, 200, 100, 40);
        add(textquantite);
        textquantite.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') ||(c=='.')

                )) {
                    e.consume();
                }
            }
        });


        JButton calculer =new JButton("Calculer");
        calculer.setBounds(330, 210, 120, 40);
        calculer.setBackground(MaterialColors.ORANGE_300);
        //calculer.setBorder(BorderFactory.createLineBorder(Color.white,2));
        calculer.setForeground(Color.white);
        add(calculer);















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
