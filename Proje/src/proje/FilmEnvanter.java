
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
                    + "Bilgileri dosyadan okutmak için (1)\n"
                    + "Film bilgisi giriþi için (2)\n"
                    + "Adýný gireceðiniz filmi ekranda görmek için (3)\n"
                    + "Adýný gireceðiniz filmi envanterden silmek için (4)\n"
                    + "Envanteri eskiden yeniye doðru görmek için (5)\n"
                    + "Envanteri yeniden eskiye doðru görmek için (6)\n"
                    + "Envanterde bulunan 2000 yýlýndan önce yapýlmýþ tüm film bilgilerini görmek için (7)\n"
                    + "Kaydedip çýkmak için (8)\n");
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
                    System.out.println("Lütfen seçeneklerden birini seçiniz!"); 
                }
                else if(choice!=8){
                    System.out.println("Baþka bir iþlem yapmak ister misiniz (e/h)?");
                    again=sc.next();
                    //mistext check
                    while(!again.equalsIgnoreCase("e")&&!again.equalsIgnoreCase("h")){
                        System.out.println("Lütfen 'e' veya 'h' giriniz!");
                        again=sc.next();         
                    }
                }
            }
            catch(InputMismatchException e){
                System.out.println("Lütfen seçeneklerden birini seçiniz!");
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
            System.out.println("Filmin çýkýþ yýlý baþta olmalýdýr.");
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
            System.out.println("Dosya okunmuþtur.");
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
            System.out.println("Filmin yapým yýlý:");
            //exception handling to integer value 
            try{
                movie.setDate(scan.nextInt());
            } 
            catch(InputMismatchException a){
                System.out.println("Lütfen yapým yýlýný tam sayý olarak giriniz!");
                userInput(movieList);
            }
            //movie string inputs
            System.out.println("Filmin adý:");
            movie.setTitle(scan.next());
            System.out.println("Filmin türü:");
            movie.setGenre(scan.next());
            System.out.println("Filmin yönetmeni:");
            movie.setDirector(scan.next());
            //actor string inputs loop
            while(actorAgain.equalsIgnoreCase("e")){
                Actor actor=new Actor();
                System.out.println("Filmde oynayan "+actorCount+". oyuncunun adý:");
                actor.setName(scan.next());
                System.out.println("Cinsiyeti:");
                actor.setGender(scan.next());
                System.out.println("Vatandaþý olduðu ülke:");
                actor.setCountry(scan.next());
                actorList.add(actor);
                actorCount++;
                System.out.println("Bu filme baþka bir aktör eklemek ister misiniz (e/h)?");
                actorAgain=scan.next();
                while(!actorAgain.equalsIgnoreCase("e")&&!actorAgain.equalsIgnoreCase("h")){
                    System.out.println("Lütfen 'e' veya 'h' giriniz!");
                    actorAgain=scan.next(); 
                }
            }
            movie.setActorList(actorList);
            movieList.insertSorted(movie);
            System.out.println("Baþka bir film eklemek ister misiniz (e/h)?");
            movieAgain=scan.next();
            while(!movieAgain.equalsIgnoreCase("e")&&!movieAgain.equalsIgnoreCase("h")){
                System.out.println("Lütfen 'e' veya 'h' giriniz!");
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
            System.out.println("Envanter dosyaya kaydedilmiþtir.");
        }
        catch(IOException e){
            System.out.println("Dosya kaydedilirken hatayla karþýlaþýldý!");
        }
            
    }

}
