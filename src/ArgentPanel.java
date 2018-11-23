import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class ArgentPanel extends JPanel {

     private final Color bgColor = MaterialColors.TEAL_300;
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
         quantite.setBounds(10, 160, 200, 20);
         quantite.setForeground(Color.white);
         add(quantite);



         JLabel prix =new JLabel("prix de gramme(DA): ");
         prix.setBounds(10, 200, 200, 20);
         prix.setForeground(Color.white);
         add(prix);

         JLabel total  =new JLabel("Total Zakat: ");
         total.setBounds(50, 300, 300, 20);
         total.setForeground(Color.white);
         add(total);


         JTextField textquantite =new JTextField();
         textquantite.setBounds(180, 160, 100, 20);
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
         textprix.setBounds(180, 200, 100, 20);
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

         JButton calculer =new JButton("calculer");
         calculer.setBounds(180, 240, 120, 40);
         calculer.setBackground(MaterialColors.TEAL_800);
         //calculer.setBorder(BorderFactory.createLineBorder(Color.white,2));
         calculer.setForeground(MaterialColors.WHITE);
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
