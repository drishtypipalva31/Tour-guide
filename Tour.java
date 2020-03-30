

import java.time.LocalDate;
import java.util.ArrayList;


public class Tour {
    private String name;
    private double price;
    private LocalDate dateOfTour;
    private int maxPassengers ;
    private ArrayList <Site> visits;
    private TourGuide guide;

    public Tour() {
        name = "";
        visits = new ArrayList<>();
        dateOfTour = LocalDate.now();
        guide= new TourGuide();
    }

    public Tour(String name, double price, ArrayList<Site> visits, LocalDate dateOfTour) {
        this.name = name;
        this.price = price;
        this.visits = visits;
        this.dateOfTour = dateOfTour;

    }

    public Tour(String name, double price, LocalDate dateOfTour, int maxPassengers, TourGuide guide) {
        this.name = name;
        this.price = price;
        this.dateOfTour = dateOfTour;
        this.maxPassengers = maxPassengers;
        this.guide = guide;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
     public int getMaxPassengers(){
         return maxPassengers;
     }
    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<Site> getVisits() {
        return visits;
    }

    public void setVisits(ArrayList<Site> visits) {
        this.visits = visits;
    }

    public LocalDate getDateOfTour() {
        return dateOfTour;
    }

    public void setDateOfTour(LocalDate dateOfTour) {
        this.dateOfTour = dateOfTour;
    }

   

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public TourGuide getGuide() {
        return guide;
    }

    public void setGuide(TourGuide guide) {
        this.guide = guide;
    }
    public String getVisitsNameString(){
        ArrayList<Site> visits = getVisits();
        String result = new String("");
        
            
        for(int i =0;i<visits.size(); i++){
                if(i < visits.size()-1)            
                    result = result + visits.get(i).getName()+",";
                else
                    result = result + visits.get(i).getName()+System.getProperty("line.separator");
           
        }
        return result;
    }
    public String getVisitsString(){
        ArrayList<Site> visits = getVisits();
        String result = new String("");

        for(Site x:visits)
            result = result + x.toString()+",";

        return result;
    }
    @Override
    public String toString() {
        return "Tour name = " + name +"\nGuide : "+ getGuide().toString()+"Price = $" + price +  ", Date Of Tour = " + dateOfTour + ", Max Passengers = " + maxPassengers + "\n" + "Visits "+ getVisitsString() + "\n";
    }
    public String toFileString(){
	        return ""+this.getName()+","+this.getPrice()+","+this.getDateOfTour()+","+this.getMaxPassengers()+","+this.getGuide().getName()+","+this.getGuide().getLanguageSpoken()+","+this.getVisitsNameString()+System.getProperty("line.separator");
    }

}
