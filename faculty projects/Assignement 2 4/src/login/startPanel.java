
package login ;

import game.gamePanel;
import matrixPanel.createMatrix;

import javax.swing.*;
import java.awt.*;

public class startPanel extends javax.swing.JPanel {

    private JPanel matrix ;
    private JFrame window ;

    public startPanel(JFrame window) {
        initComponents();
        this.window = window ;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        Player1 = new javax.swing.JTextField();
        Player2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
//        RulesButton = new javax.swing.JButton();
        StartButton = new javax.swing.JButton();
        M6x6 = new javax.swing.JRadioButton();
        M10x10 = new javax.swing.JRadioButton();
        M14x14 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel1.setText("Player 1");

        jLabel2.setText("Player 2");

//        RulesButton.setText("Game rules");
//        RulesButton.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                RulesButtonActionPerformed(evt);
//            }
//        });

        StartButton.setText("Start");
        StartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(M6x6);
        M6x6.setText("6x6");
        M6x6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M6x6ActionPerformed(evt);
            }
        });

        buttonGroup1.add(M10x10);
        M10x10.setText("10x10");
        M10x10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M10x10ActionPerformed(evt);
            }
        });

        buttonGroup1.add(M14x14);
        M14x14.setText("14x14");
        M14x14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M14x14ActionPerformed(evt);
            }
        });

        jLabel3.setText("Credits : CN4F59");

        jLabel4.setText("Mode");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(90, 90, 90)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                       .addComponent(StartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(30, 30, 30)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(M6x6)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(Player2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLabel2))
                                                        .addComponent(M14x14)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(Player1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(M10x10))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel4)
                                                                        .addComponent(jLabel1)))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel3)))
                                .addGap(130, 130, 130))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(M6x6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(M10x10)
                                        .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(M14x14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Player1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1)
                                        .addComponent(StartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Player2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addGap(100, 100, 100)
                                .addComponent(jLabel3))
        ));
    }// </editor-fold>



    private void StartButtonActionPerformed(java.awt.event.ActionEvent evt) {
//        System.out.println(buttonGroup1.getSelection());
        window.getContentPane().removeAll();
        window.setContentPane(new gamePanel(this.matrix, this.window));
        window.pack();
    }

    private void M6x6ActionPerformed(java.awt.event.ActionEvent evt) {
        matrix = new createMatrix(6,6);
    }

    private void M10x10ActionPerformed(java.awt.event.ActionEvent evt) {
        matrix = new createMatrix(10,10);
    }

    private void M14x14ActionPerformed(java.awt.event.ActionEvent evt) {
        matrix = new createMatrix(14,14);
    }


    // Variables declaration - do not modify
    private javax.swing.JRadioButton M10x10;
    private javax.swing.JRadioButton M14x14;
    private javax.swing.JRadioButton M6x6;
    private javax.swing.JTextField Player1;
    private javax.swing.JTextField Player2;
//    private javax.swing.JButton RulesButton;
    private javax.swing.JButton StartButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration
}
