
import java.util.ArrayList;

public class AdventureSite extends Site{
    Activity activity;

    public AdventureSite() {
        activity = new Activity();
    }


    public AdventureSite(Activity activitiy, String name, String desc) {
        super(name, desc);
        this.activity = activitiy;
    }

    public AdventureSite(String name, String desc) {
        super(name, desc);
    }
    
    public Activity getActivitiy() {
        return activity;
    }

    public void setActivitiy(Activity activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "Adventure Site " +super.toString()+  " has activity "+ activity +  '\n';
    }


    public String toFileString(){
        return ""+this.getName()+","+this.getdesc()+","+this.getActivitiy().getName()+","+this.getActivitiy().getDurationInMinutes()+System.getProperty("line.separator");
    }

}
