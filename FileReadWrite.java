

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;


public class FileReadWrite {
    private static final String IN_ACTIVITY = "Activity.txt";
    private static final String IN_VIEW_SITE = "ViewSite.txt";
    private static final String IN_ADV_SITE = "AdvSite.txt";
    private static final String IN_TOUR = "Tour.txt";
    
    private static final String IN_TOUR_BOOKING = "TourBooking.txt";
    
    
    private static ArrayList<Activity> lstActivity;
    private static ArrayList<Site> lstViewSite;
    private static ArrayList<AdventureSite> lstAdvSite;
    private static ArrayList<Tour> lstTour;    
    private static ArrayList<TourBooking> lstTourBooking;
    

    public FileReadWrite(ArrayList<Activity> lstA, ArrayList<Site> lstVS, 
            ArrayList<AdventureSite> lstAs, ArrayList<Tour> lstT,  ArrayList<TourBooking> lstTb) {
                   
        lstActivity = lstA;
        lstViewSite = lstVS;
        lstAdvSite = lstAs;
        lstTour = lstT;        
        lstTourBooking = lstTb; 
       
    }

    
    public static ArrayList<Activity> getLstActivity() {
        return lstActivity;
    }

    public static ArrayList<Site> getLstViewSite() {
        return lstViewSite;
    }

    public static ArrayList<AdventureSite> getLstAdvSite() {
        return lstAdvSite;
    }

    public static ArrayList<Tour> getLstTour() {
        return lstTour;
    }
    

    public static ArrayList<TourBooking> getLstTourBooking() {
        return lstTourBooking;
    }

    public void  saveContentsToFile(){

        try {
             
             Formatter outFileActivity = new Formatter(IN_ACTIVITY);

             for (Activity x:this.lstActivity){
                outFileActivity.format("%s",x.toFileString());
              }
             outFileActivity.close();
             
             Formatter outFileViewSite = new Formatter(IN_VIEW_SITE);
             

             for (Site x:this.lstViewSite){
                outFileViewSite.format("%s",x.toFileString());
              }
             outFileViewSite.close();
            
             Formatter outFileAdvSite = new Formatter(IN_ADV_SITE);
             

             for (AdventureSite x:this.lstAdvSite){
                outFileAdvSite.format("%s",x.toFileString());
              }
             outFileAdvSite.close();
             
             Formatter outFileTour= new Formatter(IN_TOUR);
             
             
             for (Tour x:this.lstTour){                
                   outFileTour.format("%s",x.toFileString());
             }
             outFileTour.close();
             
         
            Formatter outFileTourBooking = new Formatter(IN_TOUR_BOOKING);
             
                         
            for (TourBooking x:this.lstTourBooking){
                  outFileTourBooking.format("%s",x.toFileString());
                
            }
             outFileTourBooking.close();
            

            } catch (FileNotFoundException ex) {
                System.out.println("File saving error");
                System.exit(-1);
            } catch (Exception e){
                System.out.println("No details to save");
                System.exit (-2);
            }
        
    }
    
    public void readFromFile(){
        loadActivity(); 
        loadViewSite();
        loadAdvSite();
        loadTour();
        loadBooking();              
    }

    public  void loadActivity( )
    {
        try
        {
            Scanner in = new Scanner(new FileReader(IN_ACTIVITY));
            String strAllFieldsOfActivity;
            
            int intDuration =0;
            String strActivityName;
            String strDuration;
            
         
            if(!in.hasNext()){
                JOptionPane.showMessageDialog(null, "Activity File is empty");
            }
            else {
                while(in.hasNext())

                {
                    strAllFieldsOfActivity = in.nextLine();
                    StringTokenizer tokens = new StringTokenizer(strAllFieldsOfActivity,",");
                    
                    Activity aActivity = new Activity();
                    while(tokens.hasMoreTokens())
                    {

                        strActivityName = tokens.nextToken();
                        strDuration = tokens.nextToken();
    
                        intDuration = Integer.parseInt(strDuration);
                        aActivity = new Activity(strActivityName, intDuration);
                        
                       lstActivity.add(aActivity);

                    }
                }
                in.close();
            } 
		} catch(FileNotFoundException ex)

        {
              JOptionPane.showMessageDialog(null, " Activity Input file not found");
              System.exit(-3);
        } catch(NoSuchElementException ex){

              JOptionPane.showMessageDialog(null, "No such element found in the Activity file"); 
              System.exit(-4);
        }

    }
    public  void loadViewSite( )
    {
        try
        {
            Scanner in = new Scanner(new FileReader(IN_VIEW_SITE));
            String strAllFieldsOfSite;
            
          
            String strSiteName;
            String strSiteDescription;
                     
            if(!in.hasNext()){
                JOptionPane.showMessageDialog(null, "View Site File is empty");
            }
            else {
                while(in.hasNext())

                {
                    strAllFieldsOfSite = in.nextLine();
                    StringTokenizer tokens = new StringTokenizer(strAllFieldsOfSite,",");
                    
                   Site aSite = new Site();
                    while(tokens.hasMoreTokens())
                    {

                        strSiteName = tokens.nextToken();
                        strSiteDescription = tokens.nextToken();
                                               
                        aSite = new Site(strSiteName, strSiteDescription);
                        
                       lstViewSite.add(aSite);

                    }
                }
				in.close();
                
            } 
		} catch(FileNotFoundException ex)

        {
              JOptionPane.showMessageDialog(null, " view Site Input file not found");
              System.exit(-4);
        } catch(NoSuchElementException ex){

              JOptionPane.showMessageDialog(null, "No such element found in the view site file"); 
              System.exit(-5);
        }

    }
    
    public  void loadAdvSite( )
    {
        try
        {
            Scanner in = new Scanner(new FileReader(IN_ADV_SITE));
            String strAllFieldsOfAdvSite;
            
          
            String strSiteName;
            String strSiteDescription;
            int intDuration =0;
            String strActivityName;
            String strDuration;
                     
            if(!in.hasNext()){
                JOptionPane.showMessageDialog(null, "Adv Site File is empty");
            }
            else {
                while(in.hasNext())

                {
                    strAllFieldsOfAdvSite = in.nextLine();
                    StringTokenizer tokens = new StringTokenizer(strAllFieldsOfAdvSite,",");
                    
                   AdventureSite aAdvSite = null;
                   Activity aActivity = null;
                    while(tokens.hasMoreTokens())
                    {
                        strSiteName = tokens.nextToken();
                        strSiteDescription = tokens.nextToken();
                        
                        strActivityName = tokens.nextToken();
                        strDuration = tokens.nextToken();
    
                        intDuration = Integer.parseInt(strDuration);
                        aActivity = new Activity(strActivityName, intDuration);
                                               
                        aAdvSite = new AdventureSite(aActivity,strSiteName, strSiteDescription);
                        
                        lstAdvSite.add(aAdvSite);

                    }
                }
                in.close();
                
            } 
		} catch(FileNotFoundException ex)

        {
              JOptionPane.showMessageDialog(null, " Adv Site Input file not found");
              System.exit(-5);
        } catch(NoSuchElementException ex){

              JOptionPane.showMessageDialog(null, "No such element found in the Adv Site file"); 
              System.exit(-6);
        }
    }
    
    public  void loadTour( )
    {
        try
        {
            Scanner in = new Scanner(new FileReader(IN_TOUR));
            String strAllFieldsOfTour;
                     
            String strTourName;
            String strTourPrice;
            double doubleTourPrice=0;
            String strDateOfTour;
            LocalDate tourDate = null;
            String strMaxPassengers;
            int intMaxPassengers = 0;
            
            TourGuide aTourGuide = new TourGuide();
            String strTourGuideName = "";
            String strTourGuideLanguage = "";
            
            ArrayList<String> lstStrVisits;
            String strSite = "";
            Site aSite = new Site();                    
            if(!in.hasNext()){
                JOptionPane.showMessageDialog(null, "Tour File is empty");
            }
            else {
                while(in.hasNext())

                {
                    strAllFieldsOfTour = in.nextLine();
                    StringTokenizer tokens = new StringTokenizer(strAllFieldsOfTour,",");
                    
                    Tour aTour = new Tour();
                    lstStrVisits = new ArrayList<>();
                   
                    
                    while(tokens.hasMoreTokens())
                    {

                        strTourName = tokens.nextToken();
                        strTourPrice = tokens.nextToken();
                        doubleTourPrice = Double.parseDouble(strTourPrice);
                        
                        strDateOfTour = tokens.nextToken();
                        tourDate = LocalDate.parse(strDateOfTour);
                        strMaxPassengers = tokens.nextToken();
    
                        intMaxPassengers = Integer.parseInt(strMaxPassengers);
                                              
                        strTourGuideName = tokens.nextToken();
                        strTourGuideLanguage = tokens.nextToken();
                        
                        aTourGuide = new TourGuide(strTourGuideName);
                        aTourGuide.setLanguageSpoken(strTourGuideLanguage);
                                                
                        
                        aTour = new Tour(strTourName, doubleTourPrice,tourDate,intMaxPassengers,aTourGuide);  
                        aTour.setVisits(new ArrayList<Site>()); 
                  while(tokens.hasMoreTokens()){
                            strSite = tokens.nextToken();
                            aSite = findFromSiteList(strSite); 
                            
                            aTour.getVisits().add(aSite); 
                        }
                                               
                        lstTour.add(aTour);

                    }

                }

                in.close();
                
            } 
        } catch(FileNotFoundException ex)

        {
              JOptionPane.showMessageDialog(null, " Tour Input file not found");
              System.exit(-7);
        } catch(NoSuchElementException ex){

              JOptionPane.showMessageDialog(null, "No such element found in the Tour file"); 
              System.exit(-8);
        }
    }
    
    
    private Site findFromSiteList(String pSite){
        Site locSite = new Site();
        for(Site s:this.lstViewSite)
            if(s.getName().equalsIgnoreCase(pSite))
                return s;
        for(Site s:this.lstAdvSite)
            if(s.getName().equalsIgnoreCase(pSite))
                return s;
        return locSite; 
    }
    
    private void loadBooking(){
        try
        {
            Scanner in = new Scanner(new FileReader(IN_TOUR_BOOKING));
            String strAllFieldsOfTourBooking = "";
                     
            String strTourName ="";
                       
            ArrayList<Person> lstPersonsInOneTour = new ArrayList<>();
            String strPersonName = "";
            Tour aTour = new Tour();                    
                        if(!in.hasNext()){
                
                JOptionPane.showMessageDialog(null, "Tour booking file is empty");
            }
            else {
                while(in.hasNext())

                {
                    strAllFieldsOfTourBooking = in.nextLine();
                    StringTokenizer tokens = new StringTokenizer(strAllFieldsOfTourBooking,",");
                    
                    TourBooking aTourBooking = new TourBooking();
                    
                    
                    while(tokens.hasMoreTokens())
                    {

                        strTourName = tokens.nextToken();
                        
                                                aTour = findTourByName(strTourName);
                        aTourBooking = new TourBooking(aTour);  
                        aTourBooking.setProposedTour(aTour);
                        
                        strPersonName = tokens.nextToken();                                                  
                        aTourBooking.setPassenger(new Person(strPersonName));
                       
                                               
                        lstTourBooking.add(aTourBooking);

                    }

                }

                in.close();
                
            } 

        } catch(FileNotFoundException ex)

        {
              JOptionPane.showMessageDialog(null, " Tour Booking Input file not found");
              System.exit(-9);
        } catch(NoSuchElementException ex){

              JOptionPane.showMessageDialog(null, "No such element found in the Tour booking file"); 
              System.exit(-10);
        }
        
    }

    private Tour findTourByName(String pTourName){
        Tour locTour = new Tour();
        for(Tour t:this.lstTour)
            if(t.getName().equalsIgnoreCase(pTourName))
                return t;
        return locTour; 
    }
    
}
