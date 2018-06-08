/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.border.Border;


/**
 *
 * @author DOJO Team
 */
public class Fenetre extends JFrame {
    
    private double taux = getTaux();
    private JPanel container = new JPanel();
    private JPanel panel_SUP = new JPanel();
    private JPanel panel_INF = new JPanel();
    private JTextField txt_CHF = new JTextField();
    private JTextField txt_EURO = new JTextField();
    private JRadioButton rb_CHF2EURO = new JRadioButton("CHF => EURO");
    private JRadioButton rb_EURO2CHF = new JRadioButton("EURO => CHF");
    private JLabel lbl_CHF = new JLabel("CHF ");
    private JLabel lbl_EURO = new JLabel(" EURO");
    private Bouton btn_Convert = new Bouton("Convert", Color.BLUE, Color.WHITE, new Font("Verdana", Font.BOLD, 10) );
    private Bouton btn_Reset = new Bouton("Reset", Color.BLACK, Color.WHITE, new Font("Verdana", Font.BOLD, 10) );
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
        btn_Reset.addActionListener(new ClickReset());
        container.add(panel_INF, BorderLayout.SOUTH);

        this.setVisible(true);

    }
    
    public double getTaux() {
        // @TODO: get the TAUX from the web
        //JSONObject json = new JSONObject(IOUtils.toString(new URL("http://data.fixer.io/api/latest?access_key=9e978e3268e89b820d0f577c31a7049b&base=EUR&symbols=CHF"), Charset.forName("UTF-8")));
        return 1.2;
    }

    // ***
    class Clickconvert implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(rb_CHF2EURO.isSelected()) {
                double CHF = Double.parseDouble(txt_CHF.getText())*(1/taux);
                txt_EURO.setText(new DecimalFormat("##.##").format(CHF));
                
            } else {
                double EURO = Double.parseDouble(txt_EURO.getText())*taux;
                txt_CHF.setText(new DecimalFormat("##.##").format(EURO));

            }
        }

    }
    
    class ClickReset implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            txt_CHF.setText("");
            txt_EURO.setText("");
            rb_CHF2EURO.setSelected(false);
            rb_EURO2CHF.setSelected(false);
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
