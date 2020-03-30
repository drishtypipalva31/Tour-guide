



import java.util.ArrayList;
import javax.swing.JPanel;


public class PanelAdventureSite extends JPanel {


    
    public PanelAdventureSite() {
        panelLstActivity = new ArrayList<>();
        initComponents();
        fillActivityComboBox();
        
    }

    
    public PanelAdventureSite(ArrayList<Activity> pList) {
        panelLstActivity = pList;
        initComponents();
        initTextFields();
        fillActivityComboBox();
        
    }
    private void fillActivityComboBox(){
        for(Activity a:this.panelLstActivity)
            this.cbxActivity.addItem(a.getName());
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
        AdventureSite aSite = new AdventureSite();
        if(ok){
            aSite.setName(txtSiteName.getText());
            aSite.setDescription(this.txtDescription.getText());
            String activityName = (String)this.cbxActivity.getSelectedItem();
            Activity aActivity= new Activity();
            for(Activity a: panelLstActivity){
                if(a.getName().equalsIgnoreCase(activityName))
                aSite.setActivitiy(a);
            }
                       
        }
        return aSite;
    }
    private boolean validateFieldValues(){
        if(getSiteName())
            return true;
        return false;
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {

        cbxActivity = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txtSiteName = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();
        btnMakeSite = new javax.swing.JButton();

        jLabel3.setText("Description");

        jLabel1.setText("Site");

        jLabel2.setText("Site Name");

        jLabel4.setText("Select Activity");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                        .addComponent(lblError))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(btnMakeSite))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxActivity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSiteName, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(txtDescription))))
                .addContainerGap(257, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblError))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSiteName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxActivity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(39, 39, 39)
                .addComponent(btnMakeSite)
                .addContainerGap(215, Short.MAX_VALUE))
        );
    }
    private void btnMakeSiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMakeSiteActionPerformed
        if(!validateFieldValues())
            this.lblError.setText("Enter Site name");
        else
            this.lblError.setText("");
    }
	
	private javax.swing.JButton btnMakeSite;
    private javax.swing.JComboBox cbxActivity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblError;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtSiteName;
    private ArrayList <Activity> panelLstActivity;
}
