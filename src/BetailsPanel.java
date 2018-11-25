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

class BetailsPanel extends JPanel {

    private final Color bgColor = MaterialColors.INDIGO_300;
    private final String zakatText = "Total Zakat: ";

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
        typeBetailsLabel.setBounds(100, 90, 200, 20);
        typeBetailsLabel.setForeground(Color.white);
        add(typeBetailsLabel);


        JCheckBoxMenuItem choix1=new JCheckBoxMenuItem("chameaux");
        choix1.setBounds(110, 120, 100, 20);
        choix1.setForeground(Color.white);
        choix1.setBackground(bgColor);
        add(choix1);
        betailsTypeBG.add(choix1);

        JCheckBoxMenuItem choix2=new JCheckBoxMenuItem("bovins");
        choix2.setBounds(110, 140, 100, 20);
        choix2.setForeground(Color.white);
        choix2.setBackground(bgColor);
        add(choix2);
        betailsTypeBG.add(choix2);

        JCheckBoxMenuItem choix3=new JCheckBoxMenuItem("ovins");
        choix3.setBounds(110, 160, 100, 20);
        choix3.setForeground(Color.white);
        choix3.setBackground(bgColor);
        add(choix3);
        betailsTypeBG.add(choix3);

        JLabel l =new JLabel("nombre: ");
        l.setBounds(100, 200, 200, 40);
        l.setForeground(Color.white);
        add(l);

        JLabel zakatTextLabel  =new JLabel(zakatText);
        zakatTextLabel.setBounds(130, 300, 500, 20);
        zakatTextLabel.setForeground(Color.white);
        zakatTextLabel.setVisible(false);
        add(zakatTextLabel);


        JLabel errorTxt  =new JLabel("Error ! you should enter a number.");
        errorTxt.setBounds(170, 250, 300, 20);
        errorTxt.setForeground(Color.RED);
        errorTxt.setVisible(false);
        add(errorTxt);


        JTextField numberTextField = new JTextField();
        numberTextField.setBounds(170, 200, 100, 40);
        numberTextField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (errorTxt.isVisible()) errorTxt.setVisible(false);
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9'))) {
                    e.consume();
                }
            }
        });
        add(numberTextField);


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

            if (numberTextField.getText().length() > 0){
                zakatTextLabel.setVisible(true);

                int number = Integer.parseInt(numberTextField.getText());
                System.out.println(number);




                /*
                        Calcul for Chamaux
                 */
                if(choix1.isSelected())
                {
                    if((number>=5)&&(number<=24))
                    {
                        zakatTextLabel.setText(zakatText +number/5+ " C ");
                    }
                    else
                    {
                        if((number>=25)&&(number<=35))
                        {
                            zakatTextLabel.setText(zakatText+ " M ");
                        }
                        else
                        {
                            if((number>=36)&&(number<=45))
                            {
                                zakatTextLabel.setText(zakatText+ " L ");
                            }
                            else
                            {
                                if((number>=46)&&(number<=60))
                                {
                                    zakatTextLabel.setText(zakatText+ " H ");
                                }
                                else
                                {
                                    if((number>=61)&&(number<=75))
                                    {
                                        zakatTextLabel.setText(zakatText+ " J ");
                                    }
                                    else
                                    {
                                        if((number>=76)&&(number<=90))
                                        {
                                            zakatTextLabel.setText(zakatText+ " 2L ");
                                        }
                                        else
                                        {
                                            if((number>=91)&&(number<=120))
                                            {
                                                zakatTextLabel.setText(zakatText+ " 2H ");
                                            }
                                            else
                                            {
                                                if(number>=121)
                                                {
                                                    //code de >120
                                                    for(int h=0;h<=number;h++)
                                                    {
                                                        for(int qq=0;qq<=number;qq++)
                                                        {
                                                            if((number/10)*10==h*50+qq*40)
                                                                zakatTextLabel.setText(zakatText+h+" H et "+qq+" L");
                                                        }
                                                    }

                                                }
                                                else
                                                    zakatTextLabel.setText(zakatText+"Quorum n'est pas atteint ");
                                            }
                                        }
                                    }
                                }
                            }
                        }

                    }
                }
                else if(choix2.isSelected())
                    {
                        if((number>=30)&&(number<=39))
                        {
                            zakatTextLabel.setText(zakatText+" T ");
                        }
                        else
                        {
                            if((number>=40)&&(number<=59))
                            {
                                zakatTextLabel.setText(zakatText+" Mo ");
                            }
                            else
                            {
                                if((number>=60)&&(number<=69))
                                {
                                    zakatTextLabel.setText(zakatText+" 2T ");
                                }
                                else
                                {
                                    if((number>=70)&&(number<=79))
                                    {
                                        zakatTextLabel.setText(zakatText+" Mo+T ");
                                    }
                                    else
                                    {
                                        if((number>=80)&&(number<=89))
                                        {
                                            zakatTextLabel.setText(zakatText+" 2Mo ");
                                        }
                                        else
                                        {
                                            if((number>=90)&&(number<=99))
                                            {
                                                zakatTextLabel.setText(zakatText+" 3T ");
                                            }
                                            else
                                            {
                                                if((number>=100)&&(number<=119))
                                                {
                                                    zakatTextLabel.setText(zakatText+" Mo+2T ");
                                                }
                                                else
                                                {
                                                    if((number>=120)&&(number<=129))
                                                    {
                                                        zakatTextLabel.setText(zakatText+" 3Mo ou 4T ");
                                                    }
                                                    else
                                                    {
                                                        //>120
                                                        if(number>=130)
                                                        {
                                                            for(int mo=0;mo<=number;mo++)
                                                            {
                                                                for(int t=0;t<=number;t++)
                                                                {
                                                                    if((number/10)*10==mo*40+t*30)
                                                                        zakatTextLabel.setText(zakatText+mo+" Mo et "+t+" T");
                                                                }
                                                            }
                                                        }
                                                        else
                                                            zakatTextLabel.setText(zakatText+"Quorum n'est pas atteint ");

                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else if(choix3.isSelected())
                        {
                            /*
                                    Calcul for : les Ovins
                             */



                            if((number>=40)&&(number<=120))
                            {
                                zakatTextLabel.setText(zakatText+" C ");
                            }
                            else
                            {
                                if((number>=121)&&(number<=200))
                                {
                                    zakatTextLabel.setText(zakatText+" 2C ");
                                }
                                else
                                {
                                    if((number>=201)&&(number<=399))
                                    {
                                        zakatTextLabel.setText(zakatText+" 3C ");
                                    }
                                    else
                                    {
                                        if(number>400)
                                        {
                                            zakatTextLabel.setText(zakatText + (number/100) +" C ");
                                        }
                                        else
                                        {
                                            zakatTextLabel.setText(zakatText+" Quorum n'est pas atteint ");
                                        }
                                    }
                                }
                            }
                        } else {
                            errorTxt.setText("Error ! Please select one option");
                            errorTxt.setVisible(true);
                            zakatTextLabel.setVisible(false);
                }
            } else {
                errorTxt.setText("Error ! Please enter a number");
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
