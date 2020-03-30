


import java.util.ArrayList;

public class Activity {
    private String name ;
    private int Duration;

    //constructors
    public Activity() {
        name = "";
        Duration =0;
    }


    public Activity(String name, int Duration) {
        this.name = name;
        this.Duration = Duration;
    }


    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return Duration;
    }

    public void setDuration(int Duration) {
        this.Duration = Duration;
    }


    @Override
    public String toString() {
        return " name = " + name + ", duration = " + Duration + " minutes\n";
    }

    public String toFileString(){
	        return ""+this.getName()+","+this.getDuration()+System.getProperty("line.separator");
    }


}
