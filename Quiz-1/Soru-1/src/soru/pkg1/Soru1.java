//Mevlüt Emre Okumuþ 05220000971
package soru.pkg1;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Soru1 {
    static float money;
    static String[] meyveler={"","",""};
    static float toplam_kazanilan;
    static float toplam_harcanan;
    public static void main(String[] args) {
        UserInput();
        Meyveler();
        System.out.print("Çýkan kelimeler: "+Arrays.toString(meyveler)+"\n");
        ParaHesabi();
        Restart();
        
    }
    private static void UserInput(){
        
        Scanner input=new Scanner(System.in) ;
        System.out.print("Lütfen yatýracaðýnýz para miktarýný giriniz (TL): ");
        money=input.nextFloat();
        toplam_harcanan+=money;
    }
    private static void Meyveler(){
        String[] tum_meyveler={"Çilek", "Portakal", "Elma", "Muz", "Kiraz", "Kavun"};
        Random rastgele=new Random();
        int rastgele_sayi;
        String meyve;
        for (int i=0;i<3;i++){
            rastgele_sayi=rastgele.nextInt(6);
            meyve=tum_meyveler[rastgele_sayi];
            meyveler[i]=meyve;
        }
    }
    private static void ParaHesabi(){
        float kazanýlan;
        if(!meyveler[0].equals(meyveler[1])&& !meyveler[1].equals(meyveler[2]) && !meyveler[0].equals(meyveler[2])){
            kazanýlan=0;
        }
        else if(meyveler[0].equals(meyveler[1])&& meyveler[1].equals(meyveler[2])){
            kazanýlan=money*3;
        }
        else{
            kazanýlan=money*2;
        }
        System.out.print(String.format("Kazandýðýnýz para miktarý: %.2f",kazanýlan)+" TL\n");
        toplam_kazanilan+=kazanýlan;
    }
    private static void Restart(){
        String yes_no;
        Scanner input=new Scanner(System.in);
        System.out.print("Tekrar oynamak istiyor musunuz (E/H)? ");
        yes_no=input.nextLine();
        if(yes_no.equals("e")|| yes_no.equals("E")){
            main(new String[0]);
        }
        else if(yes_no.equals("h")|| yes_no.equals("H")){
           System.out.print("Harcadýðýnýz toplam para miktarý: "+String.format("%.2f", toplam_harcanan)+" TL\n");
           System.out.print("Kazandýðýnýz toplam para miktarý: "+String.format("%.2f", toplam_kazanilan)+" TL\n");
           System.out.print("Net kazancýnýz: "+String.format("%.2f",(toplam_kazanilan-toplam_harcanan))+" TL\n");
        }
        else{
           System.out.print("Lütfen geçerli bir cevap giriniz!\n");
           Restart();
        }
        
    }
}

