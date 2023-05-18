/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quiz.pkg2;
import java.util.Scanner;
/**
 *
 * @author Emre
 */
public class ControllerDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        NumberController nc=new NumberController();
       
        Scanner user_input=new Scanner(System.in);
        System.out.println("Lütfen bir tam sayý giriniz: ");
        int input_num=user_input.nextInt();
        boolean binary=nc.searchBinary(input_num);
        if(binary){
            System.out.println("Girdiðiniz sayý dizide bulunmaktadýr.");
            
        }
        else{
            System.out.println("Girdiðiniz sayý dizide bulunmamaktadýr.");
        }
        System.out.println("Lütfen bir tam sayý daha giriniz: ");
        int input_num2=user_input.nextInt();
        boolean seq=nc.searchSequential(input_num2);
        if(seq){
            System.out.println("Girdiðiniz sayý dizide bulunmaktadýr.");
        }
        else{
            System.out.println("Girdiðiniz sayý dizide bulunmamaktadýr.");
        }
        
        
    }
    
}
