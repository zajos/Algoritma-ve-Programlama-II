/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package spellchecker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Emre
 */
public class SpellChecker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashTable dictionary=new HashTable();
        System.out.println("Loading dictionary...");
        try{
            Scanner inputStream=new Scanner(new File("words.txt"));
            while(inputStream.hasNextLine()){
                String dictWord=inputStream.nextLine();
                dictWord=dictWord.toLowerCase();
                dictWord=removePunct(dictWord);
                dictionary.put(dictWord);
            }
            inputStream.close();
        }
        catch(IOException a){
            System.out.println("Error occured from the dictionary file!"); 
        }
        try{
            Scanner inputStream=new Scanner(new File("checkme.txt"));
            int lineNum=0;
            while(inputStream.hasNextLine()){
                lineNum++;
                String line=inputStream.nextLine();
                StringTokenizer wordFactory=new StringTokenizer(line);
                while(wordFactory.hasMoreTokens()){
                    String word=wordFactory.nextToken();
                    checkWord(word,lineNum,dictionary);
                }
            }
            inputStream.close();
        }
        catch(IOException e){
            System.out.println("Error occured while reading file!");
        }
    }
    public static String removePunct(String s){
        String noPunct="";
        int sLength=s.length();
        for(int i=0;i<sLength;i++){
            char c=s.charAt(i);
            if(((c>='a')&&(c<='z'))||((c>='A')&&(c<='Z'))||((c>='0')&&(c<='9'))){
                noPunct+=c;
            }
        }
        return noPunct;
    }
    public static void checkWord(String word,int lineNum,HashTable dictionary){
        String tempWord;
        tempWord=word.toLowerCase();
        tempWord=removePunct(tempWord);
        if(tempWord.length()>0&& !dictionary.containsString(tempWord)){
            System.out.println(tempWord+" may be misspelled on "+lineNum+". line.");
        }
    }
}
