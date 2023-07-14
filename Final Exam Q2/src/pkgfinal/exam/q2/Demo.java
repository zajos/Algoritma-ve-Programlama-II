/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkgfinal.exam.q2;

/**
 *
 * @author Emre
 */
public class Demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashTable table=new HashTable();
        table.put("köpek");
        table.put("kedi");
        table.put("aslan");
        table.put("kaplan");
        table.put("su aygýrý");
        table.printHashTable();
        table.delete("aslan");
        table.printHashTable();
    }
    
}
