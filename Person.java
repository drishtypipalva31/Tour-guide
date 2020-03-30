
public class Person {
    String Name;
    public Person(String Name) {
        this.Name = Name;
    }

    public Person() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    @Override
    public String toString() {
        return  "Name : " + Name;
    }
    public String toFileString(){
	return ""+this.getName()+System.getProperty("line.separator");
    }
    
}
