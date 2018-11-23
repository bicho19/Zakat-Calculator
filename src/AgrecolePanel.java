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

public class AgrecolePanel extends JPanel {
    private final Color bgColor = MaterialColors.GREEN_300;
    private final String zakatText = "Total Zakat: ";

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

        JCheckBoxMenuItem bleCheckBox = new JCheckBoxMenuItem("Ble");
        bleCheckBox.setBounds(110, 120, 150, 20);
        bleCheckBox.setForeground(Color.white);
        bleCheckBox.setBackground(bgColor);
        typeBG.add(bleCheckBox);
        add(bleCheckBox);

        JCheckBoxMenuItem autreCheckBox = new JCheckBoxMenuItem("Autre");
        autreCheckBox.setBounds(110, 140, 150, 20);
        autreCheckBox.setForeground(Color.white);
        autreCheckBox.setBackground(bgColor);
        typeBG.add(autreCheckBox);
        add(autreCheckBox);

        JCheckBoxMenuItem irrigationNaturelleCheckbox = new JCheckBoxMenuItem("Irrigation naturelle");
        irrigationNaturelleCheckbox.setBounds(410, 120, 200, 20);
        irrigationNaturelleCheckbox.setForeground(Color.white);
        irrigationNaturelleCheckbox.setBackground(bgColor);
        irrigationBG.add(irrigationNaturelleCheckbox);
        add(irrigationNaturelleCheckbox);

        JCheckBoxMenuItem irrigationArtificiellreCheckBox = new JCheckBoxMenuItem("Irrigation artificielle");
        irrigationArtificiellreCheckBox.setBounds(410, 140, 200, 20);
        irrigationArtificiellreCheckBox.setForeground(Color.white);
        irrigationArtificiellreCheckBox.setBackground(bgColor);
        irrigationBG.add(irrigationArtificiellreCheckBox);
        add(irrigationArtificiellreCheckBox);




        JLabel montant =new JLabel("Quantité (Kg): ");
        montant.setBounds(100, 210, 200, 20);
        montant.setForeground(Color.white);
        add(montant);


        JLabel total  =new JLabel(zakatText);
        total.setBounds(180, 300, 300, 20);
        total.setForeground(Color.white);
        total.setVisible(false);
        add(total);

        JLabel errorTxt  =new JLabel("Error ! you should enter a number");
        errorTxt.setBounds(180, 250, 300, 20);
        errorTxt.setForeground(Color.RED);
        errorTxt.setVisible(false);
        add(errorTxt);

        JTextField valueTxtField =new JTextField();
        valueTxtField.setBounds(200, 200, 100, 40);
        add(valueTxtField);
        valueTxtField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (errorTxt.isVisible()) errorTxt.setVisible(false);
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') ||(c=='.'))) {
                    e.consume();
                }
            }
        });


        JButton calculBtn =new JButton("Calculer");
        calculBtn.setBounds(330, 200, 120, 40);
        calculBtn.setBackground(MaterialColors.ORANGE_300);
        calculBtn.setForeground(Color.white);
        MaterialUIMovement.add(calculBtn,MaterialColors.ORANGE_500);
        add(calculBtn);


        /*
                Calculation Block

         */

        calculBtn.addActionListener(e -> {

            //Get the value from text fields and convert it
            if (valueTxtField.getText().length() > 0){
                float value = Float.parseFloat(valueTxtField.getText());
                total.setVisible(true);
                if((irrigationNaturelleCheckbox.isSelected()) && (bleCheckBox.isSelected()) &&(value>=675) )
                    total.setText(zakatText+ " " +((value*10)/100)+" Kg ");
                else
                {
                    if((irrigationArtificiellreCheckBox.isSelected())&&(bleCheckBox.isSelected())&&(value>=675) )
                        total.setText(zakatText+ " " +value*5/100+" Kg ");
                    else
                    {
                        if((irrigationNaturelleCheckbox.isSelected())&&(autreCheckBox.isSelected()) )
                            total.setText(zakatText+ " " + value*10/100+" Kg ");
                        else
                        {
                            if((irrigationArtificiellreCheckBox.isSelected())&&(autreCheckBox.isSelected()) )
                                total.setText(zakatText+ " " + value*5/100+" Kg ");
                            else
                            {
                                total.setText(zakatText+" Quorum n'est pas atteint ");
                            }
                        }
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
