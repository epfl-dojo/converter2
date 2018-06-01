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
import javax.swing.border.Border;

/**
 *
 * @author DOJO Team
 */
public class Fenetre extends JFrame {
    
    private JPanel container = new JPanel();
    private JPanel panel_SUP = new JPanel();
    private JPanel panel_INF = new JPanel();
    private JTextField txt_CHF = new JTextField();
    private JTextField txt_EURO = new JTextField();
    private JRadioButton rb_CHF2EURO = new JRadioButton("CHF => EURO");
    private JRadioButton rb_EURO2CHF = new JRadioButton("EURO => CHF");
    private JLabel lbl_CHF = new JLabel("CHF ");
    private JLabel lbl_EURO = new JLabel(" EURO");
    private JButton btn_Convert = new JButton("Convert");
    private JButton btn_Reset = new JButton("Reset");
    private ButtonGroup btngrp = new ButtonGroup();
    
    public Fenetre() {
        this.setTitle("Converter"); // Titre de la fenêtre
        this.setSize(450, 120); // Taille de la fenêtre en (x,y)
        this.setLocationRelativeTo(null); // La fenêtre apparaît au milieu de l'écran
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Action à la fermeture de la fenêtre
        this.setResizable(false); // Possibilité de redimensionner la
        this.setLayout(new BorderLayout());

        this.setContentPane(container);
        
        btngrp.add(rb_CHF2EURO);
        btngrp.add(rb_EURO2CHF);
        rb_CHF2EURO.setSelected(true);
        txt_CHF.setEditable(true);
        txt_EURO.setEditable(false);
       
        rb_CHF2EURO.addActionListener(new CHFListener());
        rb_EURO2CHF.addActionListener(new EUROListener());
        
        Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        container.setBorder(padding);
        container.setLayout(new BorderLayout());
        panel_SUP.setLayout(new BoxLayout(panel_SUP, BoxLayout.X_AXIS));
        panel_SUP.add(lbl_CHF);
        panel_SUP.add(txt_CHF);
        panel_SUP.add(rb_CHF2EURO);
        panel_SUP.add(rb_EURO2CHF);
        panel_SUP.add(txt_EURO);
        panel_SUP.add(lbl_EURO);
        panel_SUP.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(panel_SUP, BorderLayout.CENTER);



        container.add(panel_SUP, BorderLayout.NORTH);

     
        panel_INF.add(btn_Convert);
        panel_INF.add(Box.createRigidArea(new Dimension(5, 0)));
        panel_INF.add(btn_Reset);
        btn_Convert.addActionListener(new Clickconvert());
        container.add(panel_INF, BorderLayout.SOUTH);

        this.setVisible(true);

    }

    // ***
    class Clickconvert implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }
    
    class CHFListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
             txt_CHF.setEditable(true);
             txt_EURO.setEditable(false);
        }

    }
     class EUROListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            txt_CHF.setEditable(false);
            txt_EURO.setEditable(true);
        }

    }
}
