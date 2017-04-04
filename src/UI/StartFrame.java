/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Entity.ParkCntrl;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Yongli Wang
 * @author Jingtai Li
 */
public class StartFrame extends javax.swing.JFrame {
    ParkCntrl op;
    
    /**
     * Creates new form NewJFrame
     */
    public StartFrame() {
        initComponents();
        this.setVisible(true);
        StaffinBut.setEnabled(false);
        OutBut.setEnabled(false);
        Paynow.setEnabled(false);
        RegBut.setEnabled(false);
        op= new ParkCntrl();
        this.parkLotLeftRefresh(); 
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                
    }

    /**
     *refresh the space available to the label
     */
    public void parkLotLeftRefresh(){
        int left=op.parkLotLeft();
        this.Left.setText("ParklotLeft: "+left+" spaces");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        Start = new javax.swing.JTabbedPane();
        In = new javax.swing.JPanel();
        StaffinBut = new javax.swing.JButton();
        StaffinIDText = new javax.swing.JTextField();
        PublicinBut = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Left = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        Out = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        TicketNoout = new javax.swing.JTextField();
        OutBut = new javax.swing.JButton();
        Pay = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        TicNoText = new javax.swing.JTextField();
        Paynow = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        RegBut = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        BillBut = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        RegIDText = new javax.swing.JTextField();
        OperatorBut = new javax.swing.JButton();
        QuitBut = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        StaffinBut.setText("Staff In");
        StaffinBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StaffinButMouseClicked(evt);
            }
        });

        StaffinIDText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                StaffinIDTextKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                StaffinIDTextKeyReleased(evt);
            }
        });

        PublicinBut.setText("Public In");
        PublicinBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PublicinButActionPerformed(evt);
            }
        });

        jLabel1.setText("Staff ID:");

        jLabel2.setText("Public:");

        Left.setText("Left");

        jLabel8.setText("Please input your staff ID:");

        jLabel17.setText("Up to 2h: 50p");

        jLabel18.setText("2 to 4h: 1");

        jLabel19.setText("4 to 8h: 2");

        jLabel20.setText("8 to 12h: 3");

        jLabel21.setText("12 to 24h: 5");

        javax.swing.GroupLayout InLayout = new javax.swing.GroupLayout(In);
        In.setLayout(InLayout);
        InLayout.setHorizontalGroup(
            InLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InLayout.createSequentialGroup()
                .addGroup(InLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(InLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(InLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(StaffinIDText, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8)))
                    .addGroup(InLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(StaffinBut)))
                .addGap(54, 54, 54)
                .addGroup(InLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(InLayout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addGroup(InLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(InLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel18))))
                        .addGroup(InLayout.createSequentialGroup()
                            .addComponent(PublicinBut)
                            .addGap(4, 4, 4))
                        .addGroup(InLayout.createSequentialGroup()
                            .addComponent(jLabel21)
                            .addGap(25, 25, 25)))
                    .addComponent(Left))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        InLayout.setVerticalGroup(
            InLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InLayout.createSequentialGroup()
                        .addComponent(Left)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(InLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(StaffinIDText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 108, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InLayout.createSequentialGroup()
                        .addGap(0, 41, Short.MAX_VALUE)
                        .addGroup(InLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel2))
                        .addGap(10, 10, 10)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21)
                        .addGap(18, 18, 18)
                        .addGroup(InLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PublicinBut)
                            .addComponent(StaffinBut))
                        .addGap(16, 16, 16))))
        );

        Start.addTab("In Station", In);

        jLabel12.setText("Ticket Number or ID:");

        TicketNoout.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TicketNooutKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TicketNooutKeyReleased(evt);
            }
        });

        OutBut.setText("Out");
        OutBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OutButActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout OutLayout = new javax.swing.GroupLayout(Out);
        Out.setLayout(OutLayout);
        OutLayout.setHorizontalGroup(
            OutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OutLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TicketNoout, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OutLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(OutBut)
                .addGap(183, 183, 183))
        );
        OutLayout.setVerticalGroup(
            OutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OutLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(OutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(TicketNoout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(OutBut)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        Start.addTab("Out Station", Out);

        jLabel4.setText("Ticket number:");

        TicNoText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TicNoTextKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TicNoTextKeyReleased(evt);
            }
        });

        Paynow.setText("Pay now");
        Paynow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaynowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PayLayout = new javax.swing.GroupLayout(Pay);
        Pay.setLayout(PayLayout);
        PayLayout.setHorizontalGroup(
            PayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PayLayout.createSequentialGroup()
                .addGroup(PayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PayLayout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TicNoText, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PayLayout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(Paynow)))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        PayLayout.setVerticalGroup(
            PayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PayLayout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addGroup(PayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TicNoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(Paynow)
                .addGap(57, 57, 57))
        );

        Start.addTab("Pay", Pay);

        RegBut.setText("Register");
        RegBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegButActionPerformed(evt);
            }
        });

        jLabel7.setText("Please registe first:");

        BillBut.setText("Check Bill");
        BillBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BillButActionPerformed(evt);
            }
        });

        jLabel16.setText("Staff ID:");

        RegIDText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RegIDTextKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RegIDTextKeyReleased(evt);
            }
        });

        OperatorBut.setText("Operator");
        OperatorBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OperatorButActionPerformed(evt);
            }
        });

        QuitBut.setText("CLOSE THE PROGRAM");
        QuitBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitButActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RegIDText, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(RegBut)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BillBut)
                            .addComponent(OperatorBut, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(QuitBut)
                        .addGap(34, 34, 34))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Start))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Start, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(RegIDText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(RegBut))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(BillBut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(OperatorBut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(QuitBut, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
 * register ui
 * @param evt 
 * @return SUCCESS/ID_ALREADY_REG/ID_NOT_EXIST;
 */
    private void RegButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegButActionPerformed
    if(((JButton)evt.getSource()).equals(RegBut)) {
    	   int result3=op.register(RegIDText.getText());
           switch(result3){
           case ParkCntrl.SUCCESS:
        	   JOptionPane.showMessageDialog(null, "Now you can get in the carpark!","Successful",JOptionPane.INFORMATION_MESSAGE);
        	   break;
           case ParkCntrl.ID_NOT_EXIST:
        	   JOptionPane.showMessageDialog(null, "ID not exits!","Wrong ID",JOptionPane.ERROR_MESSAGE);
        	   break;
           case ParkCntrl.ID_ALREADY_REG:
        	   JOptionPane.showMessageDialog(null, "Your ID has already registered.","Wrong ID",JOptionPane.ERROR_MESSAGE);
                   break;
           }
        }    
    }//GEN-LAST:event_RegButActionPerformed
    /**
 * When click BillBut jump to BillDialog
 * @param evt 
 */
    private void BillButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BillButActionPerformed
        if(((JButton)evt.getSource()).equals(this.BillBut)){
            BillDialog billDialog = new BillDialog(this,true,op);
    }
    }//GEN-LAST:event_BillButActionPerformed
/**
 * When click Operator jump to OperatorDialog
 * @param evt 
 */
    private void OperatorButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OperatorButActionPerformed
        if(((JButton)evt.getSource()).equals(this.OperatorBut)){
            OperatorDialog operatorDialog = new OperatorDialog(this,true,op);
        }
    }//GEN-LAST:event_OperatorButActionPerformed
/**
 * public in ui
 * @param evt 
 * @return op.SUCCESS/DAY_UNAVAILABLE/TICKET_EMPTY/PARKFULL;
 */
    private void PublicinButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PublicinButActionPerformed
        if(((JButton)evt.getSource()).equals(PublicinBut)){
            int result=op.publicIn();
            String ticketID;
            
            switch(result){
                case ParkCntrl.SUCCESS:
                    ticketID=op.getTicketID();
                    JOptionPane.showMessageDialog(null, "your ticket ID is"+ticketID,"Please in",JOptionPane.INFORMATION_MESSAGE);
                break;
                case ParkCntrl.DAY_UNAVAILABLE:
                JOptionPane.showMessageDialog(null, "Today isn't open!","Wrong",JOptionPane.ERROR_MESSAGE);
                break;
                case ParkCntrl.TICKET_EMPTY:
                JOptionPane.showMessageDialog(null, "Sorry there is no ticket!","Wrong",JOptionPane.ERROR_MESSAGE);
                break;
                case ParkCntrl.PARK_FULL:
                JOptionPane.showMessageDialog(null, "The carpark is full!","Wrong",JOptionPane.ERROR_MESSAGE);
           
            }
             this.parkLotLeftRefresh();
        }
    }//GEN-LAST:event_PublicinButActionPerformed
/**
 * Staff in text: only when the text field is not empty, the button can be enabled to press.
 * @param evt 
 */
    private void StaffinIDTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_StaffinIDTextKeyReleased
        if(((JTextField)evt.getSource()).equals(this.StaffinIDText)) {
            if(StaffinIDText.getText().isEmpty())
            StaffinBut.setEnabled(false);
            else
            StaffinBut.setEnabled(true);
        }
    }//GEN-LAST:event_StaffinIDTextKeyReleased

/**
 * When click Operator jump to OperatorDialog
 * @param evt 
 */
    private void PaynowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaynowActionPerformed
        if(((JButton)evt.getSource()).equals(this.Paynow)){
            String ID=this.TicNoText.getText();
            int result=op.checkPayable(ID);
            switch(result){
                case ParkCntrl.SUCCESS:
                    PayDialog payDialog = new PayDialog(this,true,op);
                    break; 
                case ParkCntrl.ID_NOT_EXIST:
                    JOptionPane.showMessageDialog(null, "ID not exits","Failed",JOptionPane.ERROR_MESSAGE);
                    break;
                case ParkCntrl.CAR_NOT_PAYABLE:
                    JOptionPane.showMessageDialog(null, "car not payable","Failed",JOptionPane.ERROR_MESSAGE);
                    break;
                case ParkCntrl.ALREADY_CLEAR:
                    JOptionPane.showMessageDialog(null, "your fee is cleared already","Failed",JOptionPane.ERROR_MESSAGE);
                    break;
            }
            }
    }//GEN-LAST:event_PaynowActionPerformed
/**
 * Pay text: only when the text field is not empty, the button can be enabled to press.
 * @param evt 
 */
    private void TicNoTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TicNoTextKeyReleased
        if(((JTextField)evt.getSource()).equals(this.TicNoText)) {
            if(TicNoText.getText().isEmpty())
            Paynow.setEnabled(false);
            else
            Paynow.setEnabled(true);
        }
    }//GEN-LAST:event_TicNoTextKeyReleased

/**
 * Staff&Public out ui
 * @param IDevt 
 * @return op.SUCCESS/ID_NOT_EXIST/CAR_UNOUTABLE;
 */
    private void OutButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OutButActionPerformed
        if(((JButton)evt.getSource()).equals(OutBut)) {
            int result2=op.getOut(TicketNoout.getText());
            switch(result2){
                case ParkCntrl.SUCCESS:
                JOptionPane.showMessageDialog(null, "Please out ","Successful",JOptionPane.INFORMATION_MESSAGE);
                break;
                case ParkCntrl.ID_NOT_EXIST:
                JOptionPane.showMessageDialog(null, "ID not exits","Wrong ID",JOptionPane.ERROR_MESSAGE);
                break;
                case ParkCntrl.CAR_UNOUTABLE:
                JOptionPane.showMessageDialog(null, "Not outable now","Wrong ID",JOptionPane.ERROR_MESSAGE);
            }
        this.parkLotLeftRefresh();
        }
    }//GEN-LAST:event_OutButActionPerformed
/**
 * Out text: only when the text field is not empty, the button can be enabled to press.
 * @param evt 
 */
    private void TicketNooutKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TicketNooutKeyReleased
        if(((JTextField)evt.getSource()).equals(this.TicketNoout)) {
            if(TicketNoout.getText().isEmpty())
            OutBut.setEnabled(false);
            else
            OutBut.setEnabled(true);
        }
    }//GEN-LAST:event_TicketNooutKeyReleased

/**
 * allow staff to come in
 * @param ID     
 * @return SUCCESS/ID_NOT_EXIST/ID_NOT_REG/PARK_FULL
     */
    private void StaffinButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StaffinButMouseClicked
        if(((JButton)evt.getSource()).equals(StaffinBut)) {
            String ID=StaffinIDText.getText();
            int result3=op.staffIn(ID);
            switch(result3){
                case ParkCntrl.SUCCESS:                    
                   JOptionPane.showMessageDialog(null, "Please in ","Successful",JOptionPane.INFORMATION_MESSAGE);
                break;
                case ParkCntrl.ID_NOT_EXIST:
                JOptionPane.showMessageDialog(null, "ID not exits","Wrong ID",JOptionPane.ERROR_MESSAGE);
                break;
                case ParkCntrl.ID_NOT_REG:
                JOptionPane.showMessageDialog(null, "Please register first","ID Problem",JOptionPane.ERROR_MESSAGE);
                break;
                case ParkCntrl.PARK_FULL:
                JOptionPane.showMessageDialog(null, "ParkLot full","failed",JOptionPane.ERROR_MESSAGE);
                break;
                case ParkCntrl.CAR_IN_ALREADY:
                    JOptionPane.showMessageDialog(null, "ID in already","failed",JOptionPane.ERROR_MESSAGE);
                break;
            }
            this.parkLotLeftRefresh();
        }
    }//GEN-LAST:event_StaffinButMouseClicked
/**
 * when click, quit the whole system
 * @param evt 
 */
    private void QuitButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitButActionPerformed
        op.refresh();
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_QuitButActionPerformed

    private void StaffinIDTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_StaffinIDTextKeyTyped
        if(((JTextField)evt.getSource()).equals(this.StaffinIDText)) {
            int input=evt.getKeyChar();
            if((input<KeyEvent.VK_0)|(input>KeyEvent.VK_9))
            evt.consume();
        }        
    }//GEN-LAST:event_StaffinIDTextKeyTyped

    private void TicketNooutKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TicketNooutKeyTyped
        if(((JTextField)evt.getSource()).equals(this.TicketNoout)) {
            int input=evt.getKeyChar();
            if((input<KeyEvent.VK_0)|(input>KeyEvent.VK_9))
            evt.consume();
        }
    }//GEN-LAST:event_TicketNooutKeyTyped

    private void TicNoTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TicNoTextKeyTyped
        if(((JTextField)evt.getSource()).equals(this.TicNoText)) {
            int input=evt.getKeyChar();
            if((input<KeyEvent.VK_0)|(input>KeyEvent.VK_9))
            evt.consume();
        }
    }//GEN-LAST:event_TicNoTextKeyTyped

    private void RegIDTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RegIDTextKeyTyped
        if(((JTextField)evt.getSource()).equals(this.RegBut)) {
            int input=evt.getKeyChar();
            if((input<KeyEvent.VK_0)|(input>KeyEvent.VK_9))
            evt.consume();
        }
    }//GEN-LAST:event_RegIDTextKeyTyped

    private void RegIDTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RegIDTextKeyReleased
         if(((JTextField)evt.getSource()).equals(this.RegIDText)) {
            if(RegIDText.getText().isEmpty())
            RegBut.setEnabled(false);
            else
            RegBut.setEnabled(true);
        }
    }//GEN-LAST:event_RegIDTextKeyReleased
/**
 * @param args the command line arguments
 */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BillBut;
    private javax.swing.JPanel In;
    private javax.swing.JLabel Left;
    private javax.swing.JButton OperatorBut;
    private javax.swing.JPanel Out;
    private javax.swing.JButton OutBut;
    private javax.swing.JPanel Pay;
    private javax.swing.JButton Paynow;
    private javax.swing.JButton PublicinBut;
    private javax.swing.JButton QuitBut;
    private javax.swing.JButton RegBut;
    private javax.swing.JTextField RegIDText;
    private javax.swing.JButton StaffinBut;
    private javax.swing.JTextField StaffinIDText;
    private javax.swing.JTabbedPane Start;
    private javax.swing.JTextField TicNoText;
    private javax.swing.JTextField TicketNoout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    private void setText(Date time) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new StartFrame().setVisible(true);
    }
}
