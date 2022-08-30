package General;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ManagerFeedback extends javax.swing.JFrame {

    UserRegistrationInfo mgr = new UserRegistrationInfo();
    String customerReviewsFile = "customerReviews.txt";
    private static Logger logger = LogManager.getLogger();
    
    public ManagerFeedback(String userID, String userPassword) {
        initComponents();
        setTitle("APU Cafeteria Ordering System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        // Set the user ID
        mgr.setUserID(userID);
        mgr.setUserPassword(userPassword);
        userIDTF.setText(userID);
        
        loadOrderHistoryTable();
        
        // Set some text fields to empty when the window loads
        orderIDTF.setText("");
        foodIDTF.setText("");
        foodTF.setText("");
        orderDateTF.setText("");
        
        // Set a placeholder text for feedbackTA
        feedbackTA.setText("-- Select one of the Order ID in the table at the left to display the feedback provided --");
    }

    private void loadOrderHistoryTable(){
        DefaultTableModel orderHistoryTableModel = (DefaultTableModel) custOrderHistoryTable.getModel();
        File file = new File(customerReviewsFile);
        
        try {
            String str;
            BufferedReader br = new BufferedReader(new FileReader(file));
            try {
                while((str = br.readLine()) != null){
                    // Spliting the data into different section using the | delimeter
                    String data[] = str.split("\\|");
                    // Only adding the users orders in the order history
                    // Adding the data into the order history table
                    orderHistoryTableModel.addRow(new Object[]{data[0], data[1], data[2], data[4]});
                }
                br.close();
            } catch (IOException e) {
                logger.error("Exception occurred - " + e.toString());
                JOptionPane.showMessageDialog(null, "Error: File cannot be read.");
            }
        } catch (FileNotFoundException e) {
            logger.error("Exception occurred - " + e.toString());
            JOptionPane.showMessageDialog(null, "Error: File does not exist!");
        }
    }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        headerPanel1 = new javax.swing.JPanel();
        custHomeHeader1 = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        custBackBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        custOrderHistoryTable = new javax.swing.JTable();
        feedbackLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        feedbackTA = new javax.swing.JTextArea();
        orderIDLabel = new javax.swing.JLabel();
        orderIDTF = new javax.swing.JTextField();
        foodIDLabel = new javax.swing.JLabel();
        foodIDTF = new javax.swing.JTextField();
        foodLabel = new javax.swing.JLabel();
        foodTF = new javax.swing.JTextField();
        custIDLabel = new javax.swing.JLabel();
        custIDTF = new javax.swing.JTextField();
        orderDateLabel = new javax.swing.JLabel();
        orderDateTF = new javax.swing.JTextField();
        userPanel1 = new javax.swing.JPanel();
        userDisplayLabel1 = new javax.swing.JLabel();
        userIDTF1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(244, 244, 244));

        headerPanel1.setBackground(new java.awt.Color(255, 255, 255));

        custHomeHeader1.setFont(new java.awt.Font("SF Pro Text", 1, 48)); // NOI18N
        custHomeHeader1.setForeground(new java.awt.Color(0, 0, 0));
        custHomeHeader1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        custHomeHeader1.setText("FEEDBACK");
        custHomeHeader1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        custHomeHeader1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout headerPanel1Layout = new javax.swing.GroupLayout(headerPanel1);
        headerPanel1.setLayout(headerPanel1Layout);
        headerPanel1Layout.setHorizontalGroup(
            headerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(custHomeHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, 803, Short.MAX_VALUE)
                .addContainerGap())
        );
        headerPanel1Layout.setVerticalGroup(
            headerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(custHomeHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addContainerGap())
        );

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("SF Pro Text", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        contentPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(975, 247, -1, 31));

        custBackBtn.setBackground(new java.awt.Color(0, 48, 73));
        custBackBtn.setFont(new java.awt.Font("SF Pro Text", 1, 14)); // NOI18N
        custBackBtn.setForeground(new java.awt.Color(255, 255, 255));
        custBackBtn.setText("BACK");
        custBackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custBackBtnActionPerformed(evt);
            }
        });
        contentPanel.add(custBackBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 440, 100, 30));

        custOrderHistoryTable.setFont(new java.awt.Font("SF Pro Text", 0, 11)); // NOI18N
        custOrderHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Customer ID", "Food ID", "Ordered Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        custOrderHistoryTable.setToolTipText("");
        custOrderHistoryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                custOrderHistoryTableMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                custOrderHistoryTableMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(custOrderHistoryTable);
        if (custOrderHistoryTable.getColumnModel().getColumnCount() > 0) {
            custOrderHistoryTable.getColumnModel().getColumn(0).setPreferredWidth(120);
            custOrderHistoryTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        }

        contentPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 12, 470, 420));

        feedbackLabel.setFont(new java.awt.Font("SF Pro Text", 0, 18)); // NOI18N
        feedbackLabel.setForeground(new java.awt.Color(18, 18, 18));
        feedbackLabel.setText("Feedback");
        contentPanel.add(feedbackLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, -1, 30));

        feedbackTA.setEditable(false);
        feedbackTA.setColumns(20);
        feedbackTA.setFont(new java.awt.Font("SF Pro Text", 0, 11)); // NOI18N
        feedbackTA.setRows(5);
        feedbackTA.setText("-- Select one of the Order ID in the table at the left to display the feedback provided --");
        jScrollPane1.setViewportView(feedbackTA);

        contentPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 460, 190));

        orderIDLabel.setFont(new java.awt.Font("SF Pro Text", 0, 18)); // NOI18N
        orderIDLabel.setForeground(new java.awt.Color(18, 18, 18));
        orderIDLabel.setText("Order ID:");
        contentPanel.add(orderIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, -1, 30));

        orderIDTF.setEditable(false);
        orderIDTF.setFont(new java.awt.Font("SF Pro Text", 0, 12)); // NOI18N
        orderIDTF.setFocusable(false);
        orderIDTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderIDTFActionPerformed(evt);
            }
        });
        contentPanel.add(orderIDTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 330, 32));

        foodIDLabel.setFont(new java.awt.Font("SF Pro Text", 0, 18)); // NOI18N
        foodIDLabel.setForeground(new java.awt.Color(18, 18, 18));
        foodIDLabel.setText("Food ID:");
        contentPanel.add(foodIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, -1, 30));

        foodIDTF.setEditable(false);
        foodIDTF.setFont(new java.awt.Font("SF Pro Text", 0, 12)); // NOI18N
        foodIDTF.setFocusable(false);
        foodIDTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foodIDTFActionPerformed(evt);
            }
        });
        contentPanel.add(foodIDTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, 330, 32));

        foodLabel.setFont(new java.awt.Font("SF Pro Text", 0, 18)); // NOI18N
        foodLabel.setForeground(new java.awt.Color(18, 18, 18));
        foodLabel.setText("Food:");
        contentPanel.add(foodLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, -1, 30));

        foodTF.setEditable(false);
        foodTF.setFont(new java.awt.Font("SF Pro Text", 0, 12)); // NOI18N
        foodTF.setFocusable(false);
        foodTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foodTFActionPerformed(evt);
            }
        });
        contentPanel.add(foodTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, 330, 32));

        custIDLabel.setFont(new java.awt.Font("SF Pro Text", 0, 18)); // NOI18N
        custIDLabel.setForeground(new java.awt.Color(18, 18, 18));
        custIDLabel.setText("Customer ID:");
        contentPanel.add(custIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, -1, 30));

        custIDTF.setEditable(false);
        custIDTF.setFont(new java.awt.Font("SF Pro Text", 0, 12)); // NOI18N
        custIDTF.setFocusable(false);
        custIDTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custIDTFActionPerformed(evt);
            }
        });
        contentPanel.add(custIDTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, 330, 32));

        orderDateLabel.setFont(new java.awt.Font("SF Pro Text", 0, 18)); // NOI18N
        orderDateLabel.setForeground(new java.awt.Color(18, 18, 18));
        orderDateLabel.setText("Ordered Date:");
        contentPanel.add(orderDateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, -1, 30));

        orderDateTF.setEditable(false);
        orderDateTF.setFont(new java.awt.Font("SF Pro Text", 0, 12)); // NOI18N
        orderDateTF.setFocusable(false);
        orderDateTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderDateTFActionPerformed(evt);
            }
        });
        contentPanel.add(orderDateTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 170, 330, 32));

        userPanel1.setBackground(new java.awt.Color(255, 255, 255));
        userPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userDisplayLabel1.setBackground(new java.awt.Color(18, 18, 18));
        userDisplayLabel1.setFont(new java.awt.Font("SF Pro Text", 1, 24)); // NOI18N
        userDisplayLabel1.setForeground(new java.awt.Color(18, 18, 18));
        userDisplayLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userDisplayLabel1.setText("USER ID");
        userPanel1.add(userDisplayLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 40));

        userIDTF1.setBackground(new java.awt.Color(18, 18, 18));
        userIDTF1.setFont(new java.awt.Font("SF Pro Text", 1, 18)); // NOI18N
        userIDTF1.setForeground(new java.awt.Color(0, 102, 155));
        userIDTF1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userIDTF1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        userPanel1.add(userIDTF1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 48, 120, 70));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(userPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(headerPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(headerPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void custBackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custBackBtnActionPerformed
        ManagerHome mgrBack = new ManagerHome(mgr.getUserID(),mgr.getUserPassword());
        mgrBack.setVisible(true);
        this.dispose();
        logger.info("Manager " + mgr.getUserID() + " has attempted to view Manager Home page.");
    }//GEN-LAST:event_custBackBtnActionPerformed

    private void custOrderHistoryTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_custOrderHistoryTableMouseClicked

    }//GEN-LAST:event_custOrderHistoryTableMouseClicked

    private void orderIDTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderIDTFActionPerformed

    }//GEN-LAST:event_orderIDTFActionPerformed

    private void foodIDTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foodIDTFActionPerformed

    }//GEN-LAST:event_foodIDTFActionPerformed

    private void foodTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foodTFActionPerformed

    }//GEN-LAST:event_foodTFActionPerformed

    private void custIDTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custIDTFActionPerformed

    }//GEN-LAST:event_custIDTFActionPerformed

    private void orderDateTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderDateTFActionPerformed

    }//GEN-LAST:event_orderDateTFActionPerformed

    private void custOrderHistoryTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_custOrderHistoryTableMousePressed
        DefaultTableModel orderHistoryTableModel = (DefaultTableModel) custOrderHistoryTable.getModel();
        orderIDTF.setText(orderHistoryTableModel.getValueAt(custOrderHistoryTable.getSelectedRow(),0).toString());
        custIDTF.setText(orderHistoryTableModel.getValueAt(custOrderHistoryTable.getSelectedRow(),1).toString());
        foodIDTF.setText(orderHistoryTableModel.getValueAt(custOrderHistoryTable.getSelectedRow(),2).toString());
        orderDateTF.setText(orderHistoryTableModel.getValueAt(custOrderHistoryTable.getSelectedRow(),3).toString());
        
        File file = new File(customerReviewsFile);
        FileHandling fh = new FileHandling();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            try {
                if (!"NA".equals(fh.locateItemInFile(orderIDTF.getText(), foodIDTF.getText(), file, 0, 2))) {
                    // Get the data that is clicked on and obtain its respective information from customerReviews.txt
                    String line = fh.locateItemInFile(orderIDTF.getText(), foodIDTF.getText(), file, 0, 2);
                    
                    // Strip the line into tokens
                    String[] lineArray = line.split("\\|");
                       
                    // Match the tokens to their respective text field
                    foodTF.setText(lineArray[3]);

                    feedbackTA.setText(lineArray[5]);
                }
                br.close();
                logger.info("Manager " + mgr.getUserID() + " has attempted to view the feedback of Order ID " + orderIDTF.getText() 
                        + "with Food ID " + foodIDTF.getText() + ".");
            } catch (IOException e) {
                logger.error("Exception occurred - " + e.toString());
                JOptionPane.showMessageDialog(null, "Error: File cannot be read.");
            }
        } catch (FileNotFoundException e) {
            logger.error("Exception occurred - " + e.toString());
            JOptionPane.showMessageDialog(null, "Error: File does not exist!");
        }
    }//GEN-LAST:event_custOrderHistoryTableMousePressed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManagerOrderHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerOrderHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerOrderHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerOrderHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ManagerOrderHistory().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton custBackBtn;
    private javax.swing.JLabel custHomeHeader1;
    private javax.swing.JLabel custIDLabel;
    private javax.swing.JTextField custIDTF;
    private javax.swing.JTable custOrderHistoryTable;
    private javax.swing.JLabel feedbackLabel;
    private javax.swing.JTextArea feedbackTA;
    private javax.swing.JLabel foodIDLabel;
    private javax.swing.JTextField foodIDTF;
    private javax.swing.JLabel foodLabel;
    private javax.swing.JTextField foodTF;
    private javax.swing.JPanel headerPanel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel orderDateLabel;
    private javax.swing.JTextField orderDateTF;
    private javax.swing.JLabel orderIDLabel;
    private javax.swing.JTextField orderIDTF;
    private javax.swing.JLabel userDisplayLabel;
    private javax.swing.JLabel userDisplayLabel1;
    private javax.swing.JLabel userIDTF;
    private javax.swing.JLabel userIDTF1;
    private javax.swing.JPanel userPanel;
    private javax.swing.JPanel userPanel1;
    // End of variables declaration//GEN-END:variables
}
