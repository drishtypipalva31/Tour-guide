
public class PanelSite extends javax.swing.JPanel {

    private Site aSite = new Site();
    public PanelSite() {
        initComponents();
        initTextFields();
        
    }
    private void initTextFields(){
        txtSiteName.setColumns(TourValues.TEXT_WIDTH);
        txtDescription.setColumns(TourValues.TEXT_WIDTH);
    }
    private boolean getSiteName(){
        if (txtSiteName.getText().equalsIgnoreCase("")){
            this.lblError.setText("Enter Site Name");
            return false;
        }
        return true;
    }
    
    public Site getSite(){
        boolean ok = validateFieldValues();
        Site aSite = new Site();
        if(ok){
            aSite.setName(txtSiteName.getText());
            aSite.setDescription(this.txtDescription.getText());
        }
        return aSite;
    }
    private boolean validateFieldValues(){
        if(getSiteName())            
              return true;  
        else 
            return false;
    }
    
    

    
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSiteName = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        lblError = new javax.swing.JLabel();
        btnMakeSite = new javax.swing.JButton();

        jLabel1.setText("Site");

        jLabel2.setText("Site Name");

        jLabel3.setText("Description");

        btnMakeSite.setText("Make Site");
        btnMakeSite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMakeSiteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jLabel1)
                        .addGap(117, 117, 117)
                        .addComponent(lblError))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSiteName, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                            .addComponent(txtDescription)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnMakeSite)))
                .addContainerGap(415, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblError))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSiteName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(btnMakeSite)
                .addContainerGap(231, Short.MAX_VALUE))
        );
    }
    private void btnMakeSiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMakeSiteActionPerformed
        boolean ok = validateFieldValues();
        if(!ok)
            this.lblError.setText("Enter site name");
        else
            this.lblError.setText("");
    }
	private javax.swing.JButton btnMakeSite;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblError;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtSiteName;
    private Site aSite;
}
