

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class TourBooking {
    private Tour proposedTour;
    private Person passenger;


    public TourBooking() {
    }

    public TourBooking(Tour proposedTour) {
        this.proposedTour = proposedTour;
    }

    public TourBooking(Tour proposedTour, Person passenger) {
        this.proposedTour = proposedTour;
        this.passenger = passenger;
    }

    public Person getPassenger() {
        return passenger;
    }

    public void setPassenger(Person passenger) {
        this.passenger = passenger;
    }
    

    public Tour getProposedTour() {
        return proposedTour;
    }

    public void setProposedTour(Tour proposedTour) {
        this.proposedTour = proposedTour;
    }

    

    @Override
    public String toString() {
        
            return "Tour =" + proposedTour + "\n passengers = " + getCustomerDetails()+ '\n';
        
    }
    public String getCustomerDetails(){
        return   passenger.getName();
    }
    
    public String toFileString(){
        return ""+this.getProposedTour().getName()+","+this.getCustomerDetails()+System.getProperty("line.separator");
    }
}
