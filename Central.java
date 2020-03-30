


import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Central extends javax.swing.JFrame {


    public Central() {
        initComponents();
        initLists();
        readAllFromFiles();
        disableClearButton();
        initMenusAndMenuItems();
        enableMenus();
        displayExistingTours();
    }
    private void readAllFromFiles(){
	frw = new FileReadWrite(lstActivity, lstViewingSite, lstAdventureSite,  lstTour, lstTourBooking);
	frw.readFromFile();
        this.makeSiteList();
    }
    private void saveAllToFiles(){

        frw = new FileReadWrite(lstActivity, lstViewingSite, lstAdventureSite,  lstTour,    lstTourBooking);
        frw.saveContentsToFile();
    }
        
    private void initLists(){
        this.lstActivity = new ArrayList<>();
        this.lstSite = new ArrayList<>();  
        this.lstTour = new ArrayList<>();       
        this.lstTourBooking = new ArrayList<>();
        this.lstViewingSite = new ArrayList<>();
        this.lstAdventureSite = new ArrayList<>();
             
    }
    
	private void initMenusAndMenuItems(){
            this.miActivityExisting.setEnabled(false);
            this.mnuSite.setEnabled(false);
            this.miSiteNew.setEnabled(false);
            this.miSiteNewAdventureSite.setEnabled(false);
            this.miSiteExisting.setEnabled(false);
            this.mnuTour.setEnabled(false);
            this.miTourNew.setEnabled(false);
            this.miTourExisting.setEnabled(false);
            this.mnuBooking.setEnabled(false);
            this.miBookingNew.setEnabled(false);
            this.miAllBookings.setEnabled(false);

    }
    
	public void enableMenus(){
        if(!this.lstActivity.isEmpty()){
            this.miActivityExisting.setEnabled(true);
            this.mnuSite.setEnabled(true);
            this.miSiteNew.setEnabled(true);
            this.miSiteNewAdventureSite.setEnabled(true);
        }
        if(!this.lstSite.isEmpty()){
            this.miSiteExisting.setEnabled(true);
            this.mnuTour.setEnabled(true);
            this.miTourNew.setEnabled(true);
        }
        if(!this.lstTour.isEmpty()){
            this.miTourExisting.setEnabled(true);
            this.mnuBooking.setEnabled(true);
            this.miBookingNew.setEnabled(true);
        }
        if(!this.lstTourBooking.isEmpty());
            this.miAllBookings.setEnabled(true);

    }
    private void disableClearButton(){
        this.btnclear.setEnabled(false);

    }
    private void enableClearButton(){
         this.btnclear.setEnabled(true);

    }
@SuppressWarnings("unchecked")
    
	private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        display = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        btnclear = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuApp = new javax.swing.JMenu();
        miReadAll = new javax.swing.JMenuItem();
        miDescription = new javax.swing.JMenuItem();
        miSaveAll = new javax.swing.JMenuItem();
        mnuExit = new javax.swing.JMenuItem();
        mnuTour = new javax.swing.JMenu();
        miTourNew = new javax.swing.JMenuItem();
        miTourExisting = new javax.swing.JMenuItem();
        mnuSite = new javax.swing.JMenu();
        miSiteNew = new javax.swing.JMenuItem();
        miSiteNewAdventureSite = new javax.swing.JMenuItem();
        miSiteExisting = new javax.swing.JMenuItem();
        mnuActivity = new javax.swing.JMenu();
        miActivityNew = new javax.swing.JMenuItem();
        miActivityExisting = new javax.swing.JMenuItem();
        mnuBooking = new javax.swing.JMenu();
        miBookingNew = new javax.swing.JMenuItem();
        miAllBookings = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        display.setColumns(20);
        display.setRows(5);
        jScrollPane1.setViewportView(display);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
        );

        btnclear.setText("Clear");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnclear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 489, Short.MAX_VALUE)
                .addComponent(btnExit)
                .addGap(47, 47, 47))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnclear)
                    .addComponent(btnExit))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        mnuApp.setText("App");

        miReadAll.setText("ReadAll");
        miReadAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miReadAllActionPerformed(evt);
            }
        });
        mnuApp.add(miReadAll);

        miDescription.setText("Description");
        miDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDescriptionActionPerformed(evt);
            }
        });
        mnuApp.add(miDescription);

        miSaveAll.setText("SaveAll");
        miSaveAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSaveAllActionPerformed(evt);
            }
        });
        mnuApp.add(miSaveAll);

        mnuExit.setText("Exit");
        mnuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuExitActionPerformed(evt);
            }
        });
        mnuApp.add(mnuExit);

        jMenuBar1.add(mnuApp);

        mnuTour.setText("Tour");

        miTourNew.setText("New");
        miTourNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miTourNewActionPerformed(evt);
            }
        });
        mnuTour.add(miTourNew);

        miTourExisting.setText("Existing");
        miTourExisting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miTourExistingActionPerformed(evt);
            }
        });
        mnuTour.add(miTourExisting);

        jMenuBar1.add(mnuTour);

        mnuSite.setText("Site");

        miSiteNew.setText("New Site");
        miSiteNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSiteNewActionPerformed(evt);
            }
        });
        mnuSite.add(miSiteNew);

        miSiteNewAdventureSite.setText("New Adventure Site");
        miSiteNewAdventureSite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSiteNewAdventureSiteActionPerformed(evt);
            }
        });
        mnuSite.add(miSiteNewAdventureSite);

        miSiteExisting.setText("Existing");
        miSiteExisting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSiteExistingActionPerformed(evt);
            }
        });
        mnuSite.add(miSiteExisting);

        jMenuBar1.add(mnuSite);

        mnuActivity.setText("Activity");

        miActivityNew.setText("New");
        miActivityNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miActivityNewActionPerformed(evt);
            }
        });
        mnuActivity.add(miActivityNew);

        miActivityExisting.setText("Existing");
        miActivityExisting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miActivityExistingActionPerformed(evt);
            }
        });
        mnuActivity.add(miActivityExisting);

        jMenuBar1.add(mnuActivity);

        mnuBooking.setText("Booking");

        miBookingNew.setText("New");
        miBookingNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miBookingNewActionPerformed(evt);
            }
        });
        mnuBooking.add(miBookingNew);

        miAllBookings.setText("All");
        miAllBookings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAllBookingsActionPerformed(evt);
            }
        });
        mnuBooking.add(miAllBookings);

        jMenuBar1.add(mnuBooking);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }
	private void miDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDescriptionActionPerformed
        this.display.setText("Welcome to CQ Tours\nDesigned by Venu\nStudent Id 1234567\nComplete the details of  Activities, Site and Tour details in that order prior to Tour offer and Tour booking");
        this.enableClearButton();
    }
	private void miReadAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miReadAllActionPerformed
        readAllFromFiles();
    }
	
    private void mnuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExitActionPerformed

        exit();
    }
	
    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        clearDisplay();
    }
	private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed

        exit();
    }
	
    private void miTourNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miTourNewActionPerformed
        
		this.setVisible(false);
        Tour newTour = getNewTourDetails();
        this.setVisible(true);
    }
    private void miActivityNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miActivityNewActionPerformed
        
		this.setVisible(false);
        getNewActivityDetails();
        this.setVisible(true);


    }
	
    private void miSiteNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSiteNewActionPerformed

        this.setVisible(false);
        getNewSiteDetails();
        this.setVisible(true);
    }
    private void miSiteNewAdventureSiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSiteNewAdventureSiteActionPerformed
        
		this.setVisible(false);
        getNewAdventureSiteDetails();
        this.setVisible(true);
    }
    private void miSaveAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSaveAllActionPerformed
        
		saveDetailsToFiles();
    }
    private void miActivityExistingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miActivityExistingActionPerformed
        
		displayExistingActivities();
        
	}
    private void miSiteExistingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSiteExistingActionPerformed
        
		displayExistingSites();
       
    }
    private void miTourExistingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miTourExistingActionPerformed
        displayExistingSites();
        displayExistingTours();
        
    }
	
    private void miBookingNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miBookingNewActionPerformed
        
		getNewTourBookingDetails();
        
    }
	
    private void miAllBookingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAllBookingsActionPerformed
        
		displayExistingTourBookings();
    }
	private void saveDetailsToFiles(){
        
		saveAllToFiles();
        this.display.setText("Tour bookings, Tours, Sites and Activities have been stored in files");

    }
   
   private void displayExistingActivities(){
        this.display.setText("Activities\n");
        for(int i = 0; i<this.lstActivity.size(); i++)
            this.display.append(""+(i+1)+" "+lstActivity.get(i));
        this.enableClearButton();
   }
    
	private void displayExistingSites(){
        this.display.setText("Sites\n");
        for(int i = 0; i<this.lstSite.size(); i++)
            this.display.append(""+(i+1)+" "+lstSite.get(i).getName()+"\n");
        this.enableClearButton();
    }
    
	private void displayExistingTours(){
       this.display.setText("Tours\n");
       for(int i = 0; i<this.lstTour.size(); i++)
           this.display.append(""+(i+1)+" "+lstTour.get(i).getName()+" on "+lstTour.get(i).getDateOfTour()+"\n");
       this.enableClearButton();
    }
    
    
	private void displayExistingTourBookings(){
       this.display.setText("Tour bookings\n");
       for(int i = 0; i<this.lstTourBooking.size(); i++){           
           this.display.append(""+(i+1)+" Tour "+lstTourBooking.get(i).getProposedTour().getName()+" on "+lstTourBooking.get(i).getProposedTour().getDateOfTour()+" booked for ");
           this.display.append(""+lstTourBooking.get(i).getCustomerDetails() +"\n");           
       }           
       this.enableClearButton();
    }
    
    private boolean isNotPresent(Activity pActivity){

        if(this.lstActivity.size() > 0)
            for( int i = 0; i<this.lstActivity.size() ; i++)
                if((this.lstActivity.get(i).getName()).equalsIgnoreCase(pActivity.getName()))
                    return false;

        return true;
    }
    
	private boolean isNotPresent(Site pSite){

        if(this.lstSite.size() > 0)
            for( int i = 0; i<this.lstSite.size() ; i++)
                if((this.lstSite.get(i).getName()).equalsIgnoreCase(pSite.getName()))
                    return false;

        return true;
    }
    
	private boolean isNotPresent(Tour pTour){

        if(this.lstTour.size() > 0)
            for( int i = 0; i<this.lstTour.size() ; i++)
                if((this.lstTour.get(i).getName()).equalsIgnoreCase(pTour.getName())&&
                        this.lstTour.get(i).getDateOfTour().isEqual(pTour.getDateOfTour()))
                    return false;

        return true;
    }
    
    private boolean isNotPresent(TourBooking pTourBooking){

        if(this.lstTourBooking.size() > 0)
            for( int i = 0; i<this.lstTourBooking.size() ; i++)
                if((this.lstTourBooking.get(i).getProposedTour().getName()).equalsIgnoreCase(pTourBooking..getName())&&
                        this.lstTour.get(i).getDateOfTour().isEqual(pTour.getDateOfTour()))
                    return false;

        return true;
    }
    
	private void getNewActivityDetails(){
        PanelActivity locPanelActivity = new PanelActivity();
         int result = JOptionPane.showConfirmDialog(this, locPanelActivity, "Enter Activity details. To stop press Cancel Button", JOptionPane.OK_CANCEL_OPTION);
        
		if(result == JOptionPane.OK_OPTION){
            Activity aActivity = (Activity)locPanelActivity.getActivity();
            if (aActivity.getName().equals(""))
                this.display.setText("No new Activity entry found");
            else if(!isNotPresent(aActivity))  //Checking for new activity entry by checking the activity name entered
                this.display.setText("No new Activity entry found");
            else{ 
				this.lstActivity.add(locPanelActivity.getActivity());
                this.display.setText("New Activity:\n");
                this.display.setText(locPanelActivity.getActivity().toString());
            }
        }
        this.enableClearButton();
        this.enableMenus();

    }

    
	private void getNewSiteDetails(){
        PanelSite locPanelSite = new PanelSite();
        int result = JOptionPane.showConfirmDialog(this, locPanelSite, "Enter Site details. To stop press Cancel Button", JOptionPane.OK_CANCEL_OPTION);
        
		if(result == JOptionPane.OK_OPTION){
            Site aSite = locPanelSite.getSite();
            if (aSite.getName().equals(""))
                this.display.setText("No new Site details entered");
            else if(!isNotPresent(aSite))  //Checking for new site entry by checking the site name entered
                this.display.setText("No new Site details entered");
            else{ 
				this.lstViewingSite.add(aSite);
                this.display.setText("New Activity:\n");
                this.display.setText(aSite.toString());
            }
        }
        this.enableClearButton();
        this.enableMenus();
    }

	private void getNewAdventureSiteDetails(){
        PanelAdventureSite locPanelAdventureSite = new PanelAdventureSite(this.lstActivity);
        int result = JOptionPane.showConfirmDialog(this, locPanelAdventureSite, "Enter Site and activity details", JOptionPane.OK_CANCEL_OPTION);
        
		if(result == JOptionPane.OK_OPTION ){
            Site aSite = locPanelAdventureSite.getSite();
            if (aSite.getName().equals(""))
                this.display.setText("No new Site details entered");
            else if(!isNotPresent(aSite))  //Checking for new site entry by checking the site name entered
                this.display.setText("No new Site details entered");
            else{ 
				this.lstAdventureSite.add((AdventureSite)aSite);
                this.display.setText("New Site:\n");
                this.display.setText(aSite.toString());
                this.makeSiteList();
            }
        }
        this.enableClearButton();
        this.enableMenus();

    }
    
    private void makeSiteList(){
        this.lstSite.clear();
        for(Site vs:this.lstViewingSite)
            this.lstSite.add(vs);
        for(AdventureSite as:this.lstAdventureSite)
            this.lstSite.add(as);
        
    }
    
    private Tour getNewTourDetails(){

        PanelTour locPanelTour = new PanelTour(this.lstSite);
        int result = JOptionPane.showConfirmDialog(this, locPanelTour, "Enter Site and activity details", JOptionPane.OK_CANCEL_OPTION);
		Tour aTour = new Tour();
        if(result == JOptionPane.OK_OPTION){
            aTour = locPanelTour.getTour();
            if (aTour.getName().equals(""))
                this.display.setText("No new Tour details entered");
            else if(!isNotPresent(aTour))  
				this.display.setText("No new Tour details entered");
            else{ 
				this.lstTour.add(aTour);
                this.display.setText("New Tour:\n");
                this.display.setText(aTour.toString());
            }
        }
          this.enableClearButton();
          this.enableMenus();
          return aTour;
    }
    
    private boolean isFull(Tour pTour ){
        
        int seatsBooked = getNum(pTour);
        if (seatsBooked == pTour.getMaxPassengers())
            return true;
        
        return false;
    }
    private int getNum(Tour pTour ){
        int count = 0;
        if(!lstTourBooking.isEmpty()){
        for(int i =0; i<this.lstTourBooking.size(); i++)
            if(lstTourBooking.get(i).getProposedTour() == pTour)
                count++;
        }
        return count;
    }

	private TourBooking getNewTourBookingDetails(){

        PanelTourBooking locPanelTourBooking = new PanelTourBooking(this.lstTour,this.lstTourBooking);
        int result = JOptionPane.showConfirmDialog(this, locPanelTourBooking, "Select Tour and enter passenger name", JOptionPane.OK_CANCEL_OPTION);

        TourBooking aTourBooking = new TourBooking();
        if(result == JOptionPane.OK_OPTION){
            
            aTourBooking = locPanelTourBooking.getLatestTourBooking();
            if (aTourBooking.getProposedTour().getName().equals(""))
                this.display.setText("No new Tour booking details entered");
            else if(isFull(aTourBooking.getProposedTour()))
                this.display.setText("The selected Tour is full. New Tour booking has not been stored");    
            else if(!isFull(aTourBooking.getProposedTour())){
                this.lstTourBooking.add(aTourBooking); 
                
                this.display.setText("Latest Tour booking:\n");
                this.display.setText("Tour " +aTourBooking.getProposedTour().getName()+" new passenger "+aTourBooking.getCustomerDetails().toString());
            }
        }
        
        this.enableClearButton();
        this.enableMenus();
        return aTourBooking;
    }
    
    
    private void clearDisplay(){
        this.display.setText("");
    }
    private void exit(){
        int x = JOptionPane.showConfirmDialog(this, "Do you want to close the application?", "Check", JOptionPane.YES_NO_OPTION);
        if( x == 0)
            System.exit(0);
    }

    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Central.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Central.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Central.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Central.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Central().setVisible(true);
            }
        });
    }

    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnclear;
    private javax.swing.JTextArea display;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem miActivityExisting;
    private javax.swing.JMenuItem miActivityNew;
    private javax.swing.JMenuItem miAllBookings;
    private javax.swing.JMenuItem miBookingNew;
    private javax.swing.JMenuItem miDescription;
    private javax.swing.JMenuItem miReadAll;
    private javax.swing.JMenuItem miSaveAll;
    private javax.swing.JMenuItem miSiteExisting;
    private javax.swing.JMenuItem miSiteNew;
    private javax.swing.JMenuItem miSiteNewAdventureSite;
    private javax.swing.JMenuItem miTourExisting;
    private javax.swing.JMenuItem miTourNew;
    private javax.swing.JMenu mnuActivity;
    private javax.swing.JMenu mnuApp;
    private javax.swing.JMenu mnuBooking;
    private javax.swing.JMenuItem mnuExit;
    private javax.swing.JMenu mnuSite;
    private javax.swing.JMenu mnuTour;
    private ArrayList<Tour> lstTour;
    private ArrayList<Site> lstSite;
    private ArrayList<Activity> lstActivity;
    private ArrayList<TourBooking> lstTourBooking;
    private ArrayList<AdventureSite> lstAdventureSite;
    private ArrayList<Site> lstViewingSite;
   
    
    FileReadWrite frw;
}
