/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package �rnek1;

/**
 *
 * @author Emre
 */
public class EvcilHayvanDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        EvcilHayvan[] pets=new EvcilHayvan[4];
        Cat kedi1=new Cat("�erafettin",12,8,"Sar�");
        Cat kedi2=new Cat("Zibi",3,5,"Beyaz");
        Dog kopek1=new Dog("Karaba�",4,9,"Golden");
        Dog kopek2=new Dog("G�t",8,12,"Pitbull");
        pets[0]=kedi1;
        pets[1]=kedi2;
        pets[2]=kopek1;
        pets[3]=kopek2;
        for (int i=0;i<4;i++){
            System.out.println(pets[i].toString()+"\n1.ila� dozaj�: "+pets[i].ilac01Dozaj()+"\n2.ila� dozaj�: "+pets[i].ilac02Dozaj());
            
        }
    }
}
