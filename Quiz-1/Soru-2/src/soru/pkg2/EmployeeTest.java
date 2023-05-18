
//Mevlüt Emre Okumuþ 05220000971
package soru.pkg2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class EmployeeTest {
   
    public static void main(String args[]) {
    
        Employee employee=new Employee();
        String[] properties={};
        String[] employees_storage=new String[0];
        int count=0;
        try{
            FileReader dosya=new FileReader("girdiQuiz1.txt");
            BufferedReader reader=new BufferedReader(dosya);
            
            
            while(true){
            String line=reader.readLine();
            count++;   
            if(line!=null){
                properties=line.split("\\,");
            }
            
            if(line!=null && properties.length>1){
                
                String ad_soyad=properties[0];
                int sicil_no=Integer.parseInt(properties[1]);
                String departman=properties[2];
                String pozisyon=properties[3];
                employee=new Employee(ad_soyad,sicil_no,departman,pozisyon);
                
            
            }
            else if(line==null || line.isEmpty()){
                break;
            }
            else if(line.matches("Default")){
                employee=new Employee();
                
                    }
            employees_storage=Arrays.copyOf(employees_storage, count);
            employees_storage[count-1]=employee.toString();
            System.out.println(employee.toString());
            }
            
        }
         
        catch(IOException e){
            System.out.println("Bazý hatalar oluþtu!");
            System.exit(0);
        }
       
    }
}
 

        
   
            
       
    

    
        
        
       
    
    
    

