import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;

import javax.swing.*;
import java.awt.*;

public class NumerairesPanel extends JPanel {


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
