import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;

import javax.swing.*;
import java.awt.*;

class BetailsPanel extends JPanel {

    private final Color bgColor = MaterialColors.INDIGO_300;
    BetailsPanel(){

        //To position the elements manually with setBounds
        this.setLayout(null);
        setBackground(bgColor);

        /*
                Main Block
         */

        JLabel panelTitle  =new JLabel("Betails");
        panelTitle.setBounds(250, 30, 300, 40);
        panelTitle.setForeground(Color.white);
        panelTitle.setFont(panelTitle.getFont().deriveFont(40f));
        add(panelTitle);



        ButtonGroup  betailsTypeBG =new ButtonGroup ();

        JLabel typeBetailsLabel =new JLabel("Quel type de betails ? ");
        typeBetailsLabel.setBounds(10, 60, 200, 20);
        typeBetailsLabel.setForeground(Color.white);
        add(typeBetailsLabel);


        JCheckBoxMenuItem choix1=new JCheckBoxMenuItem("chameaux");
        choix1.setBounds(10, 90, 100, 20);
        choix1.setForeground(Color.white);
        choix1.setBackground(bgColor);
        add(choix1);
        betailsTypeBG.add(choix1);

        JCheckBoxMenuItem choix2=new JCheckBoxMenuItem("bovins");
        choix2.setBounds(10, 110, 100, 20);
        choix2.setForeground(Color.white);
        choix2.setBackground(bgColor);
        add(choix2);
        betailsTypeBG.add(choix2);

        JCheckBoxMenuItem choix3=new JCheckBoxMenuItem("ovins");
        choix3.setBounds(10, 130, 100, 20);
        choix3.setForeground(Color.white);
        choix3.setBackground(bgColor);
        add(choix3);
        betailsTypeBG.add(choix3);

        JLabel l =new JLabel("nombre: ");
        l.setBounds(10, 200, 200, 20);
        l.setForeground(Color.white);
        add(l);

        JLabel total  =new JLabel("Total Zakat: ");
        total.setBounds(30, 300, 500, 20);
        total.setForeground(Color.white);
        add(total);



        JTextField textmontant = new JTextField();
        textmontant.setBounds(80, 200, 100, 20);
        add(textmontant);






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
