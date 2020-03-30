
public class TourGuide extends Person{
    String languageSpoken = "English";

    public TourGuide(String Name) {
        super(Name);
    }

    public TourGuide() {
    }

    public String getLanguageSpoken() {
        return languageSpoken;
    }

    public void setLanguageSpoken(String languageSpoken) {
        this.languageSpoken = languageSpoken;
    }

    @Override
    public String toString() {
        return "\nTourGuide " +super.toString()+ " fluent in = " + languageSpoken + '\n';
    }
    
	public String toFileString(){
        return String.format("%s,%s", this.getName()+this.getLanguageSpoken());
    }
   
    
}
