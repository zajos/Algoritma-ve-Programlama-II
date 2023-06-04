
package proje;

public class Actor {
    private String name;
    private String gender;
    private String country; //nationality of the actor
    //default constructor method
    public Actor(){
        name=null;
        gender=null;
        country=null;
    }
    //parameterized constructor method
    public Actor(String name,String gender,String country){
        this.name=name;
        this.gender=gender;
        this.country=country;
    }
    //copy constructor method
    public Actor(Actor actor){
        this.name=actor.name;
        this.gender=actor.gender;
        this.country=actor.country; 
    }
    //getter/setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    //toString method override
    @Override
    public String toString(){
        return "("+name+", "+gender+", "+country+")";
    }
}
