/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz.pkg2;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;



public class NumberController {
    private int[] intArray=new int[20];
    private Scanner dosya=null;
    public int[] Constructor() {
        try{
            dosya=new Scanner(new FileInputStream("Numbers.txt"));
        }
        catch(FileNotFoundException e){
            System.out.println("File not found!");
            System.exit(0);
        }
        for(int i=0;i<=intArray.length-1;i++){
            intArray[i]=dosya.nextInt();
        }
        bubbleSort(intArray);
        return(intArray);
        
    }
    public static void bubbleSort(int[] array){
        int n = array.length;  
        int temp = 0;  
         for(int i=0; i < n; i++){  
                 for(int j=1; j < (n-i); j++){  
                          if(array[j-1] > array[j]){   
                                 temp = array[j-1];  
                                 array[j-1] = array[j];  
                                 array[j] = temp;  
    }
                 }
         }
    }
    public boolean searchBinary(int sayi){
        int low=0;
        int high =Constructor().length-1;
            while (low <= high){
            int mid = (low + high) / 2;
            int mid_number = Constructor()[mid];
            
            if (sayi == mid_number){
                return true;
            }
            if (sayi < mid_number){
                high = mid - 1;
            }
            if (sayi > mid_number){
                low = mid + 1;
            }
        }
            return false;
            
        
    }
    public boolean searchSequential(int sayi){
        for(int i=0;i<=Constructor().length-1;i++){
            if(sayi==Constructor()[i]){
                return true;
            }
        }
        return false;
    }
}

    
