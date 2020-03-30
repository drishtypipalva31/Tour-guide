
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PanelTour extends javax.swing.JPanel {

    public PanelTour() {
        panelLstSite = new ArrayList<>();
        initComponents();
        initTextFields();
        fillListBox();
        this.listBoxSite.getSelectionModel().addListSelectionListener(new ListSelectionHandler());
        btnSelectionCompleted.setEnabled(false);
        this.selectedSites = new ArrayList<>();
        
    }
 
     public PanelTour(ArrayList<Site> pList) {
        panelLstSite = pList;
        initComponents();
        initTextFields();
        fillListBox();
        this.listBoxSite.getSelectionModel().addListSelectionListener(new ListSelectionHandler());
        this.selectedSites = new ArrayList<>();
    }
    private void fillListBox(){
       DefaultListModel siteNames = new DefaultListModel();
        for(Site s:this.panelLstSite)
           siteNames.addElement(s.getName());
        this.listBoxSite.setModel(siteNames);
     } 
    
        
    
    private void initTextFields(){
        this.txtTourName.setColumns(TourValues.TEXT_WIDTH);
        this.txtToutGuide.setColumns(TourValues.TEXT_WIDTH);
        this.txtTourGuideLanguage.setColumns(TourValues.TEXT_WIDTH);
        this.txtDate.setColumns(TourValues.TEXT_WIDTH);
        this.txtPrice.setColumns(TourValues.TEXT_WIDTH);
        this.txtMaximumPassengers.setColumns(TourValues.TEXT_WIDTH);
        this.txtDate.setText(LocalDate.now().toString());
        
    }
    public boolean validTourName(){
        if (txtTourName.getText().equalsIgnoreCase(""))
            return false;
        return true;
    }
    private boolean validateFieldValues(){
        if(validTourName())
            return true;
        return false;
    }
    class ListSelectionHandler implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
        
            lsm = (ListSelectionModel)e.getSource();

            int start = e.getFirstIndex();
            int end = e.getLastIndex();

            if (lsm.isSelectionEmpty()) {
                taSelectionResult.append("Selected sites are\n");
            } else {
                btnSelectionCompleted.setEnabled(true);

            }
        }
    }
    
	public void makeTour(){
        if ( validateFields()){
            aTour.setName(this.txtTourName.getText());
            aTour.setPrice(Double.parseDouble(this.txtPrice.getText()));
            aTour.setDateOfTour(LocalDate.parse(this.txtDate.getText()));
            aTour.setMaxPassengers(Integer.parseInt(this.txtMaximumPassengers.getText()));
            aTour.setVisits(this.selectedSites);
            aTour.setGuide(makeGuide());
        }
        
    }
    private boolean validateFields(){
        boolean validTourName = false;
        boolean validPrice = false;
        boolean validDate = false;
        boolean validMaxPassengers = false;;
        boolean validGuideName = false;
        validTourName = checkTourName();
        validPrice = checkPrice();
        validDate = checkDate();
        validMaxPassengers = checkMaxPassengers();
        validGuideName = checkGuideName();
        if(validTourName &&validPrice &&validDate  &&validMaxPassengers  &&validGuideName )
            return true;
        else   
            return false;
    }
    private boolean checkTourName(){
      boolean ok = false;
      
      if(this.txtTourName.getText().equalsIgnoreCase("")){
          ok = false;
          this.lblError.setText("Enter tour name");
      }
      else
          ok = true;
      
      return ok;
    }
    private boolean checkPrice(){
        this.lblError.setText("");
        boolean ok = false;
        if(this.txtPrice.getText().isEmpty()){
            ok = false;
            this.lblError.setText("Enter value for Ticket price");
        }
        else if(this.txtPrice.getText().equalsIgnoreCase("")){
          ok = false;
          this.lblError.setText("Enter Ticket price");
        }
        else{
            try{
                double d = Double.parseDouble(this.txtPrice.getText());
                if(d > 0)
                    ok = true;                
            }catch(Exception e){
                this.lblError.setText("Enter valid price");
                this.txtPrice.setText("");
                return ok;                
            }      
        }
        return ok;
    }
    private boolean checkDate(){
        boolean ok = false;
        if(this.txtDate.getText().equalsIgnoreCase(""))  
			{ 
            ok = false;
            this.lblError.setText("Enter Date in YYYY-MM-DD");           
        }
        else {
            try{
                LocalDate d = LocalDate.parse(this.txtDate.getText().toString());
                ok = true;                
            }catch(Exception e){
                this.lblError.setText("Enter valid Date in YYYY-MM-DD");
                this.txtDate.setText("");
                return ok;                
            }  
            ok = true;
        }
        return ok;
    }
    private boolean checkMaxPassengers(){
        boolean ok = false;
        if(this.txtMaximumPassengers.getText().isEmpty()){
          ok = false;
          this.lblError.setText("Enter value for maximum passengers");
        }
        else if(this.txtMaximumPassengers.getText().equalsIgnoreCase("")){
          ok = false;
          this.lblError.setText("Enter value for maximum passengers");
        }
        else{
            try{
                int i = Integer.parseInt(this.txtMaximumPassengers.getText());
                if(i>0)
                    ok = true;                
            }catch(Exception e){
                this.lblError.setText("Enter valid integer for maximum passengers");
                this.txtMaximumPassengers.setText("");
                return ok;                
            }      
        }
      
      return ok;
    }
    private boolean checkGuideName(){
        boolean ok = false;
        if(this.txtToutGuide.getText().equalsIgnoreCase(""))
        {
          ok = false;
          this.lblError.setText("Enter Guide Name");
        }
        else
          ok = true;
      return ok;
    }
    public TourGuide makeGuide(){
        TourGuide locTourGuide = new TourGuide();
        locTourGuide.setName(this.txtToutGuide.getText());
        locTourGuide.setLanguageSpoken(this.txtTourGuideLanguage.getText());
        return locTourGuide;
    }
    public Tour getTour(){
	makeTour();
        return aTour;
    }

    @SuppressWarnings("unchecked")
     private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listBoxSite = new javax.swing.JList<>();
        txtTourName = new javax.swing.JTextField();
        btnSelectionCompleted = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMaximumPassengers = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        taSelectionResult = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        txtToutGuide = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTourGuideLanguage = new javax.swing.JTextField();
        btnCreateTour = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();

        jLabel1.setText("Tour");

        jLabel2.setText("Tour Name");

        jScrollPane1.setViewportView(listBoxSite);

        btnSelectionCompleted.setText("Add selected sites");
        btnSelectionCompleted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectionCompletedActionPerformed(evt);
            }
        });

        jLabel3.setText("Ticket Price");

        jLabel4.setText("Date YYYY-MM-DD");

        jLabel5.setText("Select sites from the list");

        jLabel6.setText("Maximum passengers");

        taSelectionResult.setColumns(20);
        taSelectionResult.setRows(5);
        jScrollPane2.setViewportView(taSelectionResult);

        jLabel7.setText("Selected sites");

        jLabel8.setText("Tour Guide");

        jLabel9.setText("Tour Guide Language");

        btnCreateTour.setText("Create Tour");
        btnCreateTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateTourActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(80, 80, 80)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaximumPassengers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTourName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSelectionCompleted, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtToutGuide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTourGuideLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCreateTour))
                            .addComponent(jLabel7)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(jLabel1)
                        .addGap(140, 140, 140)
                        .addComponent(lblError)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCreateTour))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblError))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTourName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txtToutGuide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txtTourGuideLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtMaximumPassengers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(btnSelectionCompleted)))))
                .addGap(45, 45, 45))
        );
    }
    private void btnSelectionCompletedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectionCompletedActionPerformed
        this.selectedSites = getSelectedSitesForTour();
        this.taSelectionResult.append(this.selectedSites.toString());
        
    }
    private void btnCreateTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateTourActionPerformed
        makeTour();
    }
    private ArrayList getSelectedSitesForTour(){
        this.selectedSites = new ArrayList<>();
        int minIndex = lsm.getMinSelectionIndex();
        int maxIndex = lsm.getMaxSelectionIndex();
        for (int i = minIndex; i <= maxIndex; i++) {
            if (lsm.isSelectedIndex(i)) {
                this.selectedSites.add(this.panelLstSite.get(i));
            }
        }
        return selectedSites;
        
    }

    private javax.swing.JButton btnCreateTour;
    private javax.swing.JButton btnSelectionCompleted;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblError;
    private javax.swing.JList<String> listBoxSite;
    private javax.swing.JTextArea taSelectionResult;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtMaximumPassengers;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtTourGuideLanguage;
    private javax.swing.JTextField txtTourName;
    private javax.swing.JTextField txtToutGuide;
    private ArrayList<Site> panelLstSite;
    private ArrayList<Site> selectedSites;
    Tour aTour = new Tour();
    TourGuide aGuide = new TourGuide();
    ListSelectionModel lsm ;
}
