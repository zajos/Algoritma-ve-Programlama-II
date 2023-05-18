/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package örnek1;

/**
 *
 * @author Emre
 */
public class Cat extends EvcilHayvan {
    private String renk;
    public Cat(String isim,int yas,double agirlik,String renk){
        super(isim,yas,agirlik);
        this.setRenk(renk);
    }
    public String getRenk(){
        return this.renk;
    }
    public void setRenk(String renk){
        this.renk=renk;
    }
    public String toString(){
        return "Tür: Kedi Renk: "+renk+"\n"+super.toString();
    }
    public double ilac01Dozaj(){
        return (getAgirlik()/2.2)*(0.002/10);
    }
    public double ilac02Dozaj(){
        return (getAgirlik()/2.2)*(0.25/12);
    }
}
