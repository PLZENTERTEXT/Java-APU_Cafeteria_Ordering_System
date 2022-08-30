package General;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ManagerApproval extends javax.swing.JFrame {
    
    UserRegistrationInfo mgr = new UserRegistrationInfo();
    FileHandling fh  = new FileHandling();
    String mgrFile = "mgrAccount.txt";
    private static Logger logger = LogManager.getLogger();

    public ManagerApproval(String userID, String userPassword) {
        initComponents();
        setTitle("APU Cafeteria Ordering System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        mgr.setUserID(userID);
        mgr.setUserPassword(userPassword);
        loadManagerTable();
    }
    
    //Used to load the mannager accounts table
    public void loadManagerTable() {
        //Creating object for the JTable
        DefaultTableModel mgrApprovalTableModel = (DefaultTableModel) mgrApprovalTable.getModel();
        mgrApprovalTableModel.setRowCount(0); //Setting the row count back to 0
        File file = new File(mgrFile);
        
        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader(file));
            try{
                while((line = br.readLine()) != null){  
                    
                    //Splits the line into multiple sections
                    String data[] = line.split("\\|");     
                    //Adds each line into the table row by row
                    mgrApprovalTableModel.addRow(new Object[] {data[0], data[1], data[3], data[4]});
                }
                br.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error: File cannot be read.");
            }            
        }catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        custHomeHeader = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mgrApprovalTable = new javax.swing.JTable();
        mgrBackBtn = new javax.swing.JButton();
        mgrRejectBtn = new javax.swing.JButton();
        mgrApprovalBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(244, 244, 244));

        headerPanel.setBackground(new java.awt.Color(255, 255, 255));

        custHomeHeader.setFont(new java.awt.Font("SF Pro Text", 1, 48)); // NOI18N
        custHomeHeader.setForeground(new java.awt.Color(0, 0, 0));
        custHomeHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        custHomeHeader.setText("MANAGER APPROVAL");
        custHomeHeader.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        custHomeHeader.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(custHomeHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE)
                .addContainerGap())
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(custHomeHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addContainerGap())
        );

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("SF Pro Text", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));

        mgrApprovalTable.setFont(new java.awt.Font("SF Pro Text", 0, 12)); // NOI18N
        mgrApprovalTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Manager ID", "Name", "Email", "Approval Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(mgrApprovalTable);

        mgrBackBtn.setBackground(new java.awt.Color(0, 48, 73));
        mgrBackBtn.setFont(new java.awt.Font("SF Pro Text", 1, 24)); // NOI18N
        mgrBackBtn.setForeground(new java.awt.Color(255, 255, 255));
        mgrBackBtn.setText("BACK");
        mgrBackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mgrBackBtnActionPerformed(evt);
            }
        });

        mgrRejectBtn.setBackground(new java.awt.Color(0, 48, 73));
        mgrRejectBtn.setFont(new java.awt.Font("SF Pro Text", 1, 24)); // NOI18N
        mgrRejectBtn.setForeground(new java.awt.Color(255, 255, 255));
        mgrRejectBtn.setText("REJECT");
        mgrRejectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mgrRejectBtnActionPerformed(evt);
            }
        });

        mgrApprovalBtn.setBackground(new java.awt.Color(0, 48, 73));
        mgrApprovalBtn.setFont(new java.awt.Font("SF Pro Text", 1, 24)); // NOI18N
        mgrApprovalBtn.setForeground(new java.awt.Color(255, 255, 255));
        mgrApprovalBtn.setText("APPROVE");
        mgrApprovalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mgrApprovalBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addComponent(mgrBackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addComponent(mgrRejectBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mgrApprovalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(16, Short.MAX_VALUE))
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addComponent(mgrApprovalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(mgrRejectBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                .addComponent(mgrBackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40))))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
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

    private void mgrBackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mgrBackBtnActionPerformed
        ManagerHome mgrBack = new ManagerHome(mgr.getUserID(), mgr.getUserPassword());
        mgrBack.setVisible(true);
        this.dispose();
        logger.info("Manager " + mgr.getUserID() + " has attempted to view Manager Home page.");
    }//GEN-LAST:event_mgrBackBtnActionPerformed

    //Removes managers credentials from both the table and the text file
    private void mgrRejectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mgrRejectBtnActionPerformed
        DefaultTableModel mgrApprovalTableModel = (DefaultTableModel) mgrApprovalTable.getModel();
        String managerID;
        
        //Uses the selected row from the table and stores it in a variable
        managerID = mgrApprovalTableModel.getValueAt(mgrApprovalTable.getSelectedRow(),0).toString();
        File file = new File(mgrFile);
        
        //Removes the selected row from the file entirely
        fh.removeLine(file, 0, managerID);
        
        //Loads the manager table again
        loadManagerTable();
        logger.info("Manager " + mgr.getUserID() + " has rejected Manager " + managerID + ".");
    }//GEN-LAST:event_mgrRejectBtnActionPerformed

    //Edits the managers approval status to "APPROVED"
    private void mgrApprovalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mgrApprovalBtnActionPerformed
        DefaultTableModel mgrApprovalTableModel = (DefaultTableModel) mgrApprovalTable.getModel();
        String managerID;
        
        //Uses the selected row from the table and stores it in a variable
        managerID = mgrApprovalTableModel.getValueAt(mgrApprovalTable.getSelectedRow(),0).toString();
        File file = new File(mgrFile);
        
        //Rewrites the contents of the file with the new editted line for the manager to be "APPROVED"
        fh.rewriteContent(file, 0, managerID, "APPROVED");
        
        //Loads the manager table again
        loadManagerTable();
        logger.info("Manager " + mgr.getUserID() + " has approved Manager " + managerID + ".");
    }//GEN-LAST:event_mgrApprovalBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel custHomeHeader;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mgrApprovalBtn;
    private javax.swing.JTable mgrApprovalTable;
    private javax.swing.JButton mgrBackBtn;
    private javax.swing.JButton mgrRejectBtn;
    // End of variables declaration//GEN-END:variables
}
