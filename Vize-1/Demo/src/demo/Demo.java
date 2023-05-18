/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package demo;

/**
 *
 * @author Emre
 */
public class Demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ContactInfo info=new ContactInfo("Ýzmir/Bornova","056489997501","niyazikocaman@gmail.com");
        Person birey=new Person("Niyazi Kocaman",info);
        Bus otobus=new Bus("Mercedes","16 BDS 52",birey,150,18);
        System.out.println(otobus.toString());
        System.out.println("Ödenmesi gereken vergi miktarý: "+otobus.calculateTax());
        Bus otobusKopya=new Bus(otobus);
        System.out.println("Kopyayla orijinal eþit mi? "+otobusKopya.equals(otobus));
    }
    
}
