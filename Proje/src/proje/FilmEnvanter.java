
package proje;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;



public class FilmEnvanter {
    //restart variable
    private static String again="e";
    //file not found variable
    private static boolean fileNotFound=false;
    public static void main(String[] args) {
        DoublyLinkedList movieList=new DoublyLinkedList();
        while(again.equalsIgnoreCase("e")){
            Scanner sc=new Scanner(System.in);
            //user interface
            System.out.print("--Film Envanteri--\n"
                    + "Bilgileri dosyadan okutmak i�in (1)\n"
                    + "Film bilgisi giri�i i�in (2)\n"
                    + "Ad�n� girece�iniz filmi ekranda g�rmek i�in (3)\n"
                    + "Ad�n� girece�iniz filmi envanterden silmek i�in (4)\n"
                    + "Envanteri eskiden yeniye do�ru g�rmek i�in (5)\n"
                    + "Envanteri yeniden eskiye do�ru g�rmek i�in (6)\n"
                    + "Envanterde bulunan 2000 y�l�ndan �nce yap�lm�� t�m film bilgilerini g�rmek i�in (7)\n"
                    + "Kaydedip ��kmak i�in (8)\n");
            //user's choice
            try{
                int choice=sc.nextInt();
                //options from user's choice
                switch(choice){
                    case 1 -> {
                        movieList=new DoublyLinkedList();
                        fileScan(movieList);
                    }
                    case 2 -> userInput(movieList);
                    case 3 -> movieList.matchIsFound();
                    case 4 -> movieList.delete();
                    case 5 -> System.out.println(movieList.toString());
                    case 6 -> System.out.println(movieList.toStringBackwards());
                    case 7 -> movieList.printFromMillenium();
                    case 8 -> { 
                        fileSave(movieList);
                        again="h";
                    }
                }
                //if user did not choice save and exit
                if(choice!=1&&choice!=2&&choice!=3&&choice!=4&&choice!=5&&choice!=6&&choice!=7&&choice!=8){
                    System.out.println("L�tfen se�eneklerden birini se�iniz!"); 
                }
                else if(choice!=8){
                    System.out.println("Ba�ka bir i�lem yapmak ister misiniz (e/h)?");
                    again=sc.next();
                    //mistext check
                    while(!again.equalsIgnoreCase("e")&&!again.equalsIgnoreCase("h")){
                        System.out.println("L�tfen 'e' veya 'h' giriniz!");
                        again=sc.next();         
                    }
                }
            }
            catch(InputMismatchException e){
                System.out.println("L�tfen se�eneklerden birini se�iniz!");
            }

            //if file not found, restart
            if(fileNotFound){
                again="e";
            }
        }
        //exit from the program
        System.exit(0);
    }
    //converting the line read to Movie class
    public static Movie parseMovie(String line){
        Movie movie=new Movie();
        //String array's minimum length is 7, because we need minimum 7 parameters
        String[] tokens=new String[7];
        //split the line to tokens with delimiters
        String[] temp=line.split("\\)\\(|\\)\\}|,\\s*\\{\\(|,\\s*|\\{|\\}|,");
        //if temporary tokens array bigger than or equals to minimum size
        if(temp.length>=tokens.length){
            tokens=temp;
            }
        //if temporary tokens smaller than minimum size
        else{
            System.arraycopy(temp, 0, tokens, 0, temp.length);
            }
        //number of actors
        int actorCount=1;
        ArrayList<Actor> actorList = new ArrayList<>();
        //exception handling to parseInt method
        try{
            movie.setDate(Integer.parseInt(tokens[0]));
            }
        catch(NumberFormatException e){
            System.out.println("Filmin ��k�� y�l� ba�ta olmal�d�r.");
            }
        movie.setTitle(tokens[1]);
        movie.setGenre(tokens[2]);
        movie.setDirector(tokens[3]);
        
        //loop for actor's parameters
        for(int i=0;i<actorCount;i++){
            int index=actorCount*3+3;
            Actor actor=new Actor();
            actor.setName(tokens[index-2]);
            actor.setGender(tokens[index-1]);
            actor.setCountry(tokens[index]);
            actorList.add(actor);
            if(tokens.length>index+1){
                actorCount++;
                int excess=tokens.length-(index+1);
                //if excess of tokens less than 3 change the length of tokens 
                if (excess<3){
                    temp=new String[tokens.length-excess+3];
                    System.arraycopy(tokens, 0, temp, 0, tokens.length);
                    System.out.println(excess);
                    tokens=temp; 
                }
            }
            movie.setActorList(actorList);
        }   
        return movie;
    }
    //file scanning method
    public static void fileScan(DoublyLinkedList movieList){
        Scanner file=null;
        //exception handling
        try{
            file=new Scanner(new File("bilgiler.txt"));
            //line scan loop
            while (file.hasNextLine()){
                String line=file.nextLine();
                //parsing
                Movie movie=parseMovie(line);
                //add to list
                movieList.insertSorted(movie);
            }
            file.close();
            System.out.println("Dosya okunmu�tur.");
        }
        catch(IOException e){
            System.out.println("File not found!");
            fileNotFound=true;
        }
    }   
    //user input for adding movie to the list
    public static void userInput(DoublyLinkedList movieList){
        Scanner scan=new Scanner(System.in);
        scan.useDelimiter("\n");
        String movieAgain="e";
        //restart loop
        while(movieAgain.equalsIgnoreCase("e")){
            String actorAgain="e";
            Movie movie=new Movie();
            int actorCount=1;
            ArrayList<Actor> actorList=new ArrayList<>();
            System.out.println("Filmin yap�m y�l�:");
            //exception handling to integer value 
            try{
                movie.setDate(scan.nextInt());
            } 
            catch(InputMismatchException a){
                System.out.println("L�tfen yap�m y�l�n� tam say� olarak giriniz!");
                userInput(movieList);
            }
            //movie string inputs
            System.out.println("Filmin ad�:");
            movie.setTitle(scan.next());
            System.out.println("Filmin t�r�:");
            movie.setGenre(scan.next());
            System.out.println("Filmin y�netmeni:");
            movie.setDirector(scan.next());
            //actor string inputs loop
            while(actorAgain.equalsIgnoreCase("e")){
                Actor actor=new Actor();
                System.out.println("Filmde oynayan "+actorCount+". oyuncunun ad�:");
                actor.setName(scan.next());
                System.out.println("Cinsiyeti:");
                actor.setGender(scan.next());
                System.out.println("Vatanda�� oldu�u �lke:");
                actor.setCountry(scan.next());
                actorList.add(actor);
                actorCount++;
                System.out.println("Bu filme ba�ka bir akt�r eklemek ister misiniz (e/h)?");
                actorAgain=scan.next();
                while(!actorAgain.equalsIgnoreCase("e")&&!actorAgain.equalsIgnoreCase("h")){
                    System.out.println("L�tfen 'e' veya 'h' giriniz!");
                    actorAgain=scan.next(); 
                }
            }
            movie.setActorList(actorList);
            movieList.insertSorted(movie);
            System.out.println("Ba�ka bir film eklemek ister misiniz (e/h)?");
            movieAgain=scan.next();
            while(!movieAgain.equalsIgnoreCase("e")&&!movieAgain.equalsIgnoreCase("h")){
                System.out.println("L�tfen 'e' veya 'h' giriniz!");
                movieAgain=scan.next(); 
            }
        }
    }
    //saving changes in to the file
    public static void fileSave(DoublyLinkedList movieList){
        try{
            File file=new File("bilgiler.txt");
            FileWriter fileWriter=new FileWriter(file);
            BufferedWriter writer=new BufferedWriter(fileWriter);
            writer.write(movieList.toString());
            writer.close();
            System.out.println("Envanter dosyaya kaydedilmi�tir.");
        }
        catch(IOException e){
            System.out.println("Dosya kaydedilirken hatayla kar��la��ld�!");
        }
            
    }

}
