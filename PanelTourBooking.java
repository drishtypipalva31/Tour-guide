
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PanelTourBooking extends javax.swing.JPanel {

    public PanelTourBooking() {
        panelLstTours = new ArrayList<>();
        initComponents();
        initTextFields();
        fillTourComboBox();
        
    }
    public PanelTourBooking(ArrayList<Tour> pLstTours, ArrayList<TourBooking> pLstTourBookings ) {
        panelLstTours = pLstTours;
        this.panelLstTourBookings = pLstTourBookings;
        initComponents();
        initTextFields();
        fillTourComboBox();
        
    }
    private void fillTourComboBox(){
        for(Tour t:this.panelLstTours){
          String tourNameAndDate = "";  
          tourNameAndDate = t.getName() + ":" + t.getDateOfTour().toString();
            this.cbxTour.addItem(tourNameAndDate);
        }
     } 
         
    
    private void initTextFields(){
        this.txtCustomerName.setColumns(TourValues.TEXT_WIDTH);
        
        
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        cbxTour = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCustomerName = new javax.swing.JTextField();
        btnAddCustomer = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();

        jLabel1.setText("Tour booking");

        jLabel2.setText("Select Tour");

        jLabel4.setText("Customer Name");

        btnAddCustomer.setText("Add Customer");
        btnAddCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddCustomer)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblError)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbxTour, 0, 166, Short.MAX_VALUE)
                                .addComponent(txtCustomerName)))))
                .addContainerGap(435, Short.MAX_VALUE))
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
                    .addComponent(cbxTour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(btnAddCustomer)
                .addContainerGap(135, Short.MAX_VALUE))
        );
    }
    private void btnAddCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCustomerActionPerformed
        checkName();
    }
    private void checkName(){
        if(this.txtCustomerName.getText().equals(""))
            this.lblError.setText("Enter customer Name");
        if(this.cbxTour.getSelectedIndex()== -1)
            this.lblError.setText("Select the tour");
    }
    private Tour getSelectedTour(){
        Tour selectedTour = new Tour();
        String strTourName = "";
        String strTourDate = "";
        String strGetSelectedTourNameAndDate = this.cbxTour.getSelectedItem().toString();
        StringTokenizer tokens = new StringTokenizer(strGetSelectedTourNameAndDate,":");
               
        strTourName = tokens.nextToken();
        strTourDate = tokens.nextToken();
        
        selectedTour = findTourByNameAndDate(strTourName,strTourDate);
        return selectedTour;
    }
    
    public TourBooking getLatestTourBooking(){
        TourBooking currentTourbooking =  new TourBooking();
        Tour selectedTour = new Tour();
       
        String strTourName = "";
        String strTourDate = "";
        String strGetSelectedTourNameAndDate = this.cbxTour.getSelectedItem().toString();
        StringTokenizer tokens = new StringTokenizer(strGetSelectedTourNameAndDate,":");
               
        strTourName = tokens.nextToken();
        strTourDate = tokens.nextToken();
        
        selectedTour = findTourByNameAndDate(strTourName,strTourDate);
        
        selectedTour = getSelectedTour();
        currentTourbooking.setProposedTour(selectedTour);
        
            
            Person aCustomer = new Person();
            aCustomer.setName(this.txtCustomerName.getText());

            currentTourbooking.setPassenger(aCustomer);
            
        
        return currentTourbooking;
    }
    private Tour findTourByNameAndDate(String pTourName,String pTourDate){
        Tour aTour = new Tour();
        for(Tour t: panelLstTours){
            if(t.getName().equalsIgnoreCase(pTourName) && t.getDateOfTour().isEqual(LocalDate.parse(pTourDate)))
                return t;
        }
        
        return aTour;
        
    }
    private javax.swing.JButton btnAddCustomer;
    private javax.swing.JComboBox cbxTour;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblError;
    private javax.swing.JTextField txtCustomerName;
    private ArrayList<Tour> panelLstTours;
    private ArrayList<TourBooking> panelLstTourBookings;
}
