import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class ArgentPanel extends JPanel {

     private final Color bgColor = MaterialColors.TEAL_300;
    private final String zakatText = "Total Zakat: ";

    ArgentPanel(){

         //To position the elements manually with setBounds
         setLayout(null);
         setBackground(bgColor);


         /*
                Main Block
          */

         JLabel panelTitle  =new JLabel("Argent");
         panelTitle.setBounds(250, 30, 300, 40);
         panelTitle.setForeground(Color.white);
         panelTitle.setFont(panelTitle.getFont().deriveFont(40f));
         add(panelTitle);





         JLabel quantite =new JLabel("Quantité (g): ");
         quantite.setBounds(100, 120, 200, 40);
         quantite.setForeground(Color.white);
         add(quantite);



         JLabel prix =new JLabel("prix de gramme(DA): ");
         prix.setBounds(100, 180, 200, 40);
         prix.setForeground(Color.white);
         add(prix);

        JLabel errorTxt  =new JLabel("Error ! Check All Fields Please.");
        errorTxt.setBounds(250, 300, 300, 20);
        errorTxt.setForeground(Color.RED);
        errorTxt.setVisible(false);
        add(errorTxt);

         JLabel zakatTotalLabel  =new JLabel(zakatText);
         zakatTotalLabel.setBounds(150, 330, 500, 20);
         zakatTotalLabel.setForeground(Color.white);
         zakatTotalLabel.setVisible(false);
         add(zakatTotalLabel);


         JTextField quantityTextField =new JTextField();
         quantityTextField.setBounds(250, 120, 100, 40);
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



         JTextField gramePriceField =new JTextField();
         gramePriceField.setBounds(250, 180, 100, 40);
         add(gramePriceField);
         gramePriceField.addKeyListener(new KeyAdapter() {
             public void keyTyped(KeyEvent e) {
                 if (errorTxt.isVisible()) errorTxt.setVisible(false);
                 char c = e.getKeyChar();
                 if (!((c >= '0') && (c <= '9') || (c=='.')
                 )) {
                     e.consume();
                 }
             }
         });

         JButton calculBtn =new JButton("Calculer");
         calculBtn.setBounds(250, 240, 120, 40);
         calculBtn.setBackground(MaterialColors.TEAL_800);
         MaterialUIMovement.add(calculBtn,MaterialColors.TEAL_600);
         calculBtn.setForeground(MaterialColors.WHITE);
         add(calculBtn);



         /*
                Calculation Block

          */

         calculBtn.addActionListener(e -> {


             if ((quantityTextField.getText().length() > 0) && (gramePriceField.getText().length() >0)) {
                 zakatTotalLabel.setVisible(true);
                 float quantity = Float.parseFloat(quantityTextField.getText());
                 float price = Float.parseFloat(gramePriceField.getText());
                 if(quantity>=595)
                     zakatTotalLabel.setText(zakatText + quantity*price*1/40+" DA, prix de "+ quantity*1/40+" g");
                 else
                     zakatTotalLabel.setText(zakatText +" Quorum n'est pas atteint ");
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
