import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {

    private final int iconTxtGap = 20;

   public HomePanel() {
        setLayout(null);
        setBackground(MaterialColors.PURPLE_500);

        JLabel title =new JLabel("Zakat Calculator");
        title.setForeground(Color.white);
        title.setFont(title.getFont().deriveFont(50f));
        title.setBounds(150, 30, 400, 100);
        add(title);

        JLabel chooseTxt = new JLabel("Choose from the following categories");
        chooseTxt.setForeground(MaterialColors.WHITE);
        chooseTxt.setFont(chooseTxt.getFont().deriveFont(15f));
        chooseTxt.setBounds(200,120,300,50);
        add(chooseTxt);

        /*
            Buttons Block

         */
        JButton agrecoleBtn = new JButton("Agrecole");
        agrecoleBtn.setBackground(MaterialColors.GREEN_400);
        agrecoleBtn.setBounds(50,200,150,40);
        MaterialUIMovement.add(agrecoleBtn,MaterialColors.GREEN_100);
        agrecoleBtn.setIcon(new ImageIcon(this.getClass().getResource("/icons/agriculture.png")));
        agrecoleBtn.setHorizontalAlignment(SwingConstants.LEFT);
        agrecoleBtn.setIconTextGap(iconTxtGap);
        agrecoleBtn.addActionListener(e -> Home.swap(this,new AgrecolePanel()));
        add(agrecoleBtn);

        JButton argentBtn = new JButton("Argent");
        argentBtn.setBackground(MaterialColors.GREEN_400);
        argentBtn.setBounds(250,200,150,40);
        MaterialUIMovement.add(argentBtn,MaterialColors.GREEN_100);
        argentBtn.setIcon(new ImageIcon(this.getClass().getResource("icons/cash-100.png")));
        argentBtn.setHorizontalAlignment(SwingConstants.LEFT);
        argentBtn.setIconTextGap(iconTxtGap);
        argentBtn.addActionListener(e -> Home.swap(this, new ArgentPanel()));
        add(argentBtn);

        JButton betailsBtn = new JButton("Betails");
        betailsBtn.setBackground(MaterialColors.GREEN_400);
        betailsBtn.setBounds(460,200,150,40);
        MaterialUIMovement.add(betailsBtn,MaterialColors.GREEN_100);
        betailsBtn.setIcon(new ImageIcon(getClass().getResource("/icons/cow.png")));
        betailsBtn.setHorizontalAlignment(SwingConstants.LEFT);
        betailsBtn.setIconTextGap(iconTxtGap);
        betailsBtn.addActionListener(e -> Home.swap(this, new BetailsPanel()));
        add(betailsBtn);

        JButton orBtn = new JButton("Or (Gold)");
        orBtn.setBackground(MaterialColors.GREEN_400);
        orBtn.setBounds(160,270,150,40);
        MaterialUIMovement.add(orBtn,MaterialColors.GREEN_100);
        orBtn.setIcon(new ImageIcon(this.getClass().getResource("/icons/gold-white.png")));
        orBtn.setHorizontalAlignment(SwingConstants.LEFT);
        orBtn.setIconTextGap(iconTxtGap);
        orBtn.addActionListener(e -> Home.swap(this, new OrPanel()));
        add(orBtn);

        JButton numeraireBtn = new JButton("Numeraires");
        numeraireBtn.setBackground(MaterialColors.GREEN_400);
        numeraireBtn.setBounds(340,270,150,40);
        MaterialUIMovement.add(numeraireBtn,MaterialColors.GREEN_100);
        numeraireBtn.setHorizontalAlignment(SwingConstants.LEFT);
        numeraireBtn.setIconTextGap(iconTxtGap);
        numeraireBtn.addActionListener(e -> Home.swap(this, new NumerairesPanel()));
        add(numeraireBtn);

        JButton exitBtn = new JButton("EXIT");
        exitBtn.setBackground(MaterialColors.RED_400);
        exitBtn.setBounds(580,420,80,30);
        MaterialUIMovement.add(exitBtn,MaterialColors.RED_200);
        exitBtn.addActionListener(e -> System.exit(0));
        add(exitBtn);

    }



}




