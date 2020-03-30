


import java.util.ArrayList;
import javax.swing.SpinnerNumberModel;


public class PanelActivity extends javax.swing.JPanel {


    public PanelActivity() {
        initComponents();
        initTextField(TourValues.TEXT_WIDTH);
        initSpinner();
        this.lstActivity = new ArrayList();
       
    }
    
    private void initTextField(int pSize){
        this.txtActivityName.setText("");
        this.txtActivityName.setColumns(pSize);
        
    }
  
    private boolean getActivityNameEntered(){
        if (txtActivityName.getText().isEmpty()||txtActivityName.getText().equalsIgnoreCase("")){
            this.lblError.setText("Enter Activity Name");
            return false;
        }
        return true;
    }
    private int getDuration(){
         return (int)this.spDuration.getValue();            
    }
    
	public Activity getActivity(){
        boolean ok = validateFieldValues();
        Activity aActivity = new Activity();
        if(ok ){
            aActivity.setName(txtActivityName.getText());
            aActivity.setDurationInMinutes(getDuration());            
        }        
        return aActivity;
    }
    
    private boolean validateFieldValues(){
        if(getActivityNameEntered())
            return true;
        return false;
    }
    private void initSpinner(){
        this.spDuration.setModel(new SpinnerNumberModel(20,20,120,10));
    }

    @SuppressWarnings("unchecked")
   private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtActivityName = new javax.swing.JTextField();
        spDuration = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();
        btnMakeActivity = new javax.swing.JButton();

        jLabel1.setText("Activity");

        jLabel2.setText("Activity Name");

        jLabel3.setText("Activity Duration");

        jLabel4.setText("minutes");

        btnMakeActivity.setText("MakeActivity");
        btnMakeActivity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMakeActivityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblError))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtActivityName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(spDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel4)))))
                .addContainerGap(168, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnMakeActivity)
                .addGap(27, 27, 27))
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
                    .addComponent(txtActivityName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(spDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(27, 27, 27)
                .addComponent(btnMakeActivity)
                .addContainerGap(143, Short.MAX_VALUE))
        );
    }
    private void btnMakeActivityActionPerformed(java.awt.event.ActionEvent evt) {
		if(!validateFieldValues())
           this.lblError.setText("Enter Activity name");
       else
           this.lblError.setText("");
               
    }

    private javax.swing.JButton btnMakeActivity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblError;
    private javax.swing.JSpinner spDuration;
    private javax.swing.JTextField txtActivityName;
	private ArrayList<Activity> lstActivity;
}
