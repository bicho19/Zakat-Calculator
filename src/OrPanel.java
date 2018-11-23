import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class OrPanel extends JPanel {
    private final Color bgColor = MaterialColors.AMBER_400;

    OrPanel() {
        //To position the elements manually with setBounds
        this.setLayout(null);
        setBackground(bgColor);


        /*
                Main Blick
         */
        JLabel panelTitle  =new JLabel("Or (Gold)");
        panelTitle.setBounds(250, 30, 300, 40);
        panelTitle.setForeground(Color.white);
        panelTitle.setFont(panelTitle.getFont().deriveFont(40f));
        add(panelTitle);


        JLabel goldTypeLabelTxt =new JLabel("Quel est le type d'or ? ");
        goldTypeLabelTxt.setBounds(10, 100, 200, 20);
        goldTypeLabelTxt.setForeground(Color.white);
        add(goldTypeLabelTxt);

        ButtonGroup  goldTypeBG =new ButtonGroup ();

        JCheckBoxMenuItem choix1=new JCheckBoxMenuItem("24 carats");
        choix1.setBounds(10, 120, 100, 20);
        choix1.setForeground(Color.white);
        choix1.setBackground(bgColor);
        goldTypeBG.add(choix1);
        add(choix1);

        JCheckBoxMenuItem choix2=new JCheckBoxMenuItem("21 carats");
        choix2.setBounds(10, 140, 100, 20);
        choix2.setForeground(Color.white);
        choix2.setBackground(bgColor);
        goldTypeBG.add(choix2);
        add(choix2);

        JCheckBoxMenuItem choix3=new JCheckBoxMenuItem("18 carats");
        choix3.setBounds(10, 160, 100, 20);
        choix3.setForeground(Color.white);
        choix3.setBackground(bgColor);
        goldTypeBG.add(choix3);
        add(choix3);

        JLabel quantite =new JLabel("Quantité (g): ");
        quantite.setBounds(10, 210, 200, 20);
        quantite.setForeground(Color.white);
        add(quantite);



        JLabel prix =new JLabel("prix de gramme(DA): ");
        prix.setBounds(10, 240, 200, 20);
        prix.setForeground(Color.white);
        add(prix);

        JLabel total  =new JLabel("Total Zakat: ");
        total.setBounds(180, 350, 300, 20);
        total.setForeground(Color.white);
        add(total);

		 /*JLabel t  =new JLabel("Tapez des chiffres seulement! ");
		  	t.setBounds(300, 220, 300, 20);
		  	t.setForeground(Color.red);
		  	t.setFont(font1);
		  	pan.add(t);
		*/
        JTextField textquantite =new JTextField();
        textquantite.setBounds(180, 210, 100, 40);
        add(textquantite);
        textquantite.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c=='.')
                )) {
                    e.consume();
                }
            }
        });


        JTextField textprix =new JTextField();
        textprix.setBounds(180, 240, 100, 40);
        add(textprix);
        textprix.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c=='.')
                )) {
                    e.consume();
                }
            }
        });

        JButton calculer =new JButton("Calculer");
        calculer.setBounds(400, 210, 120, 40);
        calculer.setBackground(MaterialColors.BLUE_GRAY_500);
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
