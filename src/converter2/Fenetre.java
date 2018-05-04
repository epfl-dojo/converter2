/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author DOJO Team
 */
public class Fenetre extends JFrame {

    private JPanel buttonsPanel = new JPanel();
    private JPanel radioPanelCenter = new JPanel();
    private JPanel inputText = new JPanel();
    //private JPanel sud = new JPanel();
    private JTextField Input = new JTextField();
    private JRadioButton rb1 = new JRadioButton("$2CHF");
    private JRadioButton rb2 = new JRadioButton("CHF2$");
    private JLabel result= new JLabel();
    private JButton convert = new JButton("Convert");
    private JButton reset = new JButton("Reset");
    
    
            
    public Fenetre() {
        this.setTitle("Converter"); // Titre de la fenêtre
        //this.setSize(550, 250); // Taille de la fenêtre en (x,y)
        this.setLocationRelativeTo(null); // La fenêtre apparaît au milieu de l'écran
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Action à la fermeture de la fenêtre
        this.setResizable(false); // Possibilité de redimensionner la
        this.setLayout(new BorderLayout());
        
        this.buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
        //this.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonsPanel.add(convert);
        buttonsPanel.add(Box.createRigidArea(new Dimension(5,0)));
        buttonsPanel.add(reset);
        convert.addActionListener(new Clickconvert());
        // reset.addActionListener(l);
        add(buttonsPanel, BorderLayout.SOUTH);
        
        radioPanelCenter.setLayout(new BoxLayout(radioPanelCenter, BoxLayout.X_AXIS));
        radioPanelCenter.add(rb1);
        radioPanelCenter.add(rb2);
        radioPanelCenter.add(result);
        radioPanelCenter.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(radioPanelCenter, BorderLayout.CENTER);

        inputText.add(Input);
        Input.setPreferredSize(new Dimension(100,20));
        
        add(inputText, BorderLayout.NORTH);
        
        //this.setContentPane(container);
        pack();
        this.setVisible(true);
               
    }

    // ***
    class Clickconvert implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    
    }
}
