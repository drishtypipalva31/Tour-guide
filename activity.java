package A1;
import java.util.ArrayList;
public class Activity {
    private String name ;
    private int duration;

    //constructors
    public Activity() {
        name = "";
        duration =0;
    }
    
    
    public Activity(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    //to display the details of activity
    @Override
    public String toString() {
        return " name = " + name + ", duration (minutes) = " + duration ;
    }
}
