/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Entity.ParkCntrl;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author rlwang
 * @author Jingtai Li
 */
public class BillDialog extends javax.swing.JDialog {
    ParkCntrl op;


    /**
     * Creates new form BillDialog
     * @param parent
     * @param modal
     * @param op
     */
    public BillDialog(java.awt.Frame parent, boolean modal,ParkCntrl op) {
        super(parent, modal);
        initComponents();
        this.op=op;
        this.setVisible(true);
        CheckBut.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        StaffIDText = new javax.swing.JTextField();
        CheckBut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Staff ID:");

        StaffIDText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StaffIDTextActionPerformed(evt);
            }
        });
        StaffIDText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                StaffIDTextKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                StaffIDTextKeyReleased(evt);
            }
        });

        CheckBut.setText("Check Bill");
        CheckBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckButActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StaffIDText, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(133, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CheckBut)
                .addGap(74, 74, 74))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(StaffIDText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(CheckBut)
                .addContainerGap(128, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StaffIDTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StaffIDTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StaffIDTextActionPerformed

    private void CheckButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckButActionPerformed
         if(((JButton)evt.getSource()).equals(CheckBut)){
            String ID = StaffIDText.getText();
            Calendar cal=Calendar.getInstance();
            int result0=op.generateBill(ID,cal);
            switch(result0){
                case ParkCntrl.SUCCESS:
                JOptionPane.showMessageDialog(null, "Bill has already generated ","Successful",JOptionPane.INFORMATION_MESSAGE);
                break;
                case ParkCntrl.ID_NOT_EXIST:
                JOptionPane.showMessageDialog(null, "ID not exits","Wrong ID",JOptionPane.ERROR_MESSAGE);
                break;
                case ParkCntrl.ID_NOT_BILLABLE:
                JOptionPane.showMessageDialog(null, "invalid ID","Wrong ID",JOptionPane.ERROR_MESSAGE);
                break;
                }
         }
    }//GEN-LAST:event_CheckButActionPerformed

    private void StaffIDTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_StaffIDTextKeyReleased
        if(((JTextField)evt.getSource()).equals(this.StaffIDText)) {
            if(StaffIDText.getText().isEmpty())
            CheckBut.setEnabled(false);
            else
            CheckBut.setEnabled(true);
        }
    }//GEN-LAST:event_StaffIDTextKeyReleased

    private void StaffIDTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_StaffIDTextKeyTyped
        if(((JTextField)evt.getSource()).equals(this.CheckBut)) {
            int input=evt.getKeyChar();
            if((input<KeyEvent.VK_0)|(input>KeyEvent.VK_9))
            evt.consume();
        }
    }//GEN-LAST:event_StaffIDTextKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CheckBut;
    private javax.swing.JTextField StaffIDText;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}

