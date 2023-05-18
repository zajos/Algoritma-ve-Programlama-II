/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package �rnek1;

/**
 *
 * @author Emre
 */
public class Dog extends EvcilHayvan{
    private String cins;
    public Dog(String isim,int yas,double agirlik,String cins){
        super(isim,yas,agirlik);
        this.setCins(cins);
    }
    public String getCins(){
        return this.cins;
    }
    public void setCins(String cins){
        this.cins=cins;
    }
    public String toString(){
       return "T�r: K�pek Cins: "+cins+"\n"+super.toString();
    }
    @Override
    public double ilac01Dozaj(){
        return (getAgirlik()/2.2)*(0.03/10);
    }
    @Override
    public double ilac02Dozaj(){
        return (getAgirlik()/2.2)*(0.5/12);
    }
}
