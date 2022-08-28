package General;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ManagerAuditLog extends javax.swing.JFrame {

    UserRegistrationInfo mgr = new UserRegistrationInfo();
    String auditLogFile = "logs/AuditLogs.log";
    private static Logger logger = LogManager.getLogger();
    
    public ManagerAuditLog(String userID, String userPassword) {
        initComponents();
        setTitle("APU Cafeteria Ordering System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        mgr.setUserID(userID);
        mgr.setUserPassword(userPassword);
        
        // Turn off auto resize for the columns in auditLogTable
        auditLogTable.setAutoResizeMode(auditLogTable.AUTO_RESIZE_OFF);
        
        // Load the auditLogTable
        loadAuditLogTable();
        
        // Set some text fields to empty when the window loads
        filterTF.setText("");
    }

    private void loadAuditLogTable(){
        DefaultTableModel auditLogTableModel = (DefaultTableModel) auditLogTable.getModel();
        File file = new File(auditLogFile);
        
        try {
            String str;
            BufferedReader br = new BufferedReader(new FileReader(file));
            try {
                while((str = br.readLine()) != null){
                    // Spliting the data into different section using the | delimeter
                    String data[] = str.split("\\~");
                    // Adding the data into the auditLogTable
                    auditLogTableModel.addRow(new Object[]{data[0], data[1], data[2], data[4], data[5]});
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
        custHomeHeader = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        searchBtn = new javax.swing.JButton();
        filterLabel = new javax.swing.JLabel();
        filterTF = new javax.swing.JTextField();
        mgrBackBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        auditLogTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(244, 244, 244));

        headerPanel1.setBackground(new java.awt.Color(255, 255, 255));

        custHomeHeader.setFont(new java.awt.Font("SF Pro Text", 1, 48)); // NOI18N
        custHomeHeader.setForeground(new java.awt.Color(0, 0, 0));
        custHomeHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        custHomeHeader.setText("AUDIT LOG");
        custHomeHeader.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        custHomeHeader.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout headerPanel1Layout = new javax.swing.GroupLayout(headerPanel1);
        headerPanel1.setLayout(headerPanel1Layout);
        headerPanel1Layout.setHorizontalGroup(
            headerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(custHomeHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        headerPanel1Layout.setVerticalGroup(
            headerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(custHomeHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addContainerGap())
        );

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("SF Pro Text", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        contentPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(975, 247, -1, 31));

        searchBtn.setBackground(new java.awt.Color(0, 48, 73));
        searchBtn.setFont(new java.awt.Font("SF Pro Text", 1, 14)); // NOI18N
        searchBtn.setForeground(new java.awt.Color(255, 255, 255));
        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });
        contentPanel.add(searchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 430, 90, 30));

        filterLabel.setFont(new java.awt.Font("SF Pro Text", 0, 18)); // NOI18N
        filterLabel.setForeground(new java.awt.Color(18, 18, 18));
        filterLabel.setText("Filter:");
        contentPanel.add(filterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, -1, 30));

        filterTF.setFont(new java.awt.Font("SF Pro Text", 0, 12)); // NOI18N
        filterTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterTFActionPerformed(evt);
            }
        });
        contentPanel.add(filterTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 330, 32));

        mgrBackBtn.setBackground(new java.awt.Color(0, 48, 73));
        mgrBackBtn.setFont(new java.awt.Font("SF Pro Text", 1, 14)); // NOI18N
        mgrBackBtn.setForeground(new java.awt.Color(255, 255, 255));
        mgrBackBtn.setText("BACK");
        mgrBackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mgrBackBtnActionPerformed(evt);
            }
        });
        contentPanel.add(mgrBackBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 440, 100, 30));

        auditLogTable.setFont(new java.awt.Font("SF Pro Text", 0, 11)); // NOI18N
        auditLogTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Log Level", "Date", "Time", "Page", "Details"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        auditLogTable.setToolTipText("");
        auditLogTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                auditLogTableMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                auditLogTableMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(auditLogTable);
        if (auditLogTable.getColumnModel().getColumnCount() > 0) {
            auditLogTable.getColumnModel().getColumn(0).setResizable(false);
            auditLogTable.getColumnModel().getColumn(0).setPreferredWidth(60);
            auditLogTable.getColumnModel().getColumn(1).setResizable(false);
            auditLogTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            auditLogTable.getColumnModel().getColumn(2).setResizable(false);
            auditLogTable.getColumnModel().getColumn(2).setPreferredWidth(60);
            auditLogTable.getColumnModel().getColumn(3).setResizable(false);
            auditLogTable.getColumnModel().getColumn(3).setPreferredWidth(150);
            auditLogTable.getColumnModel().getColumn(4).setResizable(false);
            auditLogTable.getColumnModel().getColumn(4).setPreferredWidth(700);
        }

        contentPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 950, 400));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(headerPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(headerPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                .addContainerGap())
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

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        DefaultTableModel auditLogTableModel = (DefaultTableModel) auditLogTable.getModel();
        
        // Refreshes the table for the filtered input
        auditLogTableModel.setRowCount(0);
        File file = new File(auditLogFile);
        String query = filterTF.getText();
        try {
            String str;
            String line;
            BufferedReader br = new BufferedReader(new FileReader(file));
            try {
                while((line = br.readLine()) != null){
                    // If the query exists in any log, print that particular line
                    if (!"NA".equals(FileHandling.filterLines(query,line))) {
                        str = FileHandling.filterLines(query,line);
                        // Spliting the data into different section using the ~ delimeter
                        String data[] = str.split("\\~");
                        // Adding the data into the auditLogTable
                        auditLogTableModel.addRow(new Object[]{data[0], data[1], data[2], data[4], data[5]});
                    }
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
        logger.info("Manager " + mgr.getUserID() + " has filtered the feedbacks with the query \"" + query + "\".");
    }//GEN-LAST:event_searchBtnActionPerformed

    private void filterTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterTFActionPerformed
        
    }//GEN-LAST:event_filterTFActionPerformed

    private void mgrBackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mgrBackBtnActionPerformed
        ManagerHome mgrBack = new ManagerHome(mgr.getUserID(),mgr.getUserPassword());
        mgrBack.setVisible(true);
        this.dispose();
        logger.info("Manager " + mgr.getUserID() + " has attempted to view Manager Home page.");
    }//GEN-LAST:event_mgrBackBtnActionPerformed

    private void auditLogTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_auditLogTableMouseClicked

    }//GEN-LAST:event_auditLogTableMouseClicked

    private void auditLogTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_auditLogTableMousePressed
       
    }//GEN-LAST:event_auditLogTableMousePressed

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
    private javax.swing.JTable auditLogTable;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel custHomeHeader;
    private javax.swing.JLabel filterLabel;
    private javax.swing.JTextField filterTF;
    private javax.swing.JPanel headerPanel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton mgrBackBtn;
    private javax.swing.JButton searchBtn;
    // End of variables declaration//GEN-END:variables
}
