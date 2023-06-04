
package proje;

import java.util.ArrayList;

public class Movie {
    private int date;
    private String title;
    private String genre;
    private String director;
    private ArrayList<Actor> actorList;
    //default constructor method
    public Movie(){
        date=0;
        title=null;
        genre=null;
        actorList=null;
    }
    //parameterized constructor method
    public Movie(int date,String title,String genre, String director,ArrayList<Actor> actorList){
        this.date=date;
        this.title=title;
        this.genre=genre;
        this.director=director;
        this.actorList=new ArrayList<>(actorList);
    }
    //copy constructor method
    public Movie(Movie movie){
        this.date=movie.date;
        this.title=movie.title;
        this.genre=movie.genre;
        this.director=movie.director;
        this.actorList=new ArrayList<>(movie.actorList);
    }
    //getter/setter methods
    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public ArrayList<Actor> getActorList() {
        return new ArrayList<>(actorList);
    }

    public void setActorList(ArrayList<Actor> actorList) {
        this.actorList = new ArrayList<>(actorList);
    }
    //custom toString method for ArrayList class
    public static String arrayListToString(ArrayList<Actor> list) {
        if(list!=null){
            String content="";
            for (int i = 0; i < list.size(); i++) {
                content=content+list.get(i).toString();
            }
            return "{"+content+"}";
        }
        return "";
    }
    //toString method override
    @Override
    public String toString(){
        return date+", "+title+", "+genre+", "+director+", "+arrayListToString(actorList)+"\n";
    }
}
