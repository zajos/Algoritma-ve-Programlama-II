/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package örnek1;

/**
 *
 * @author Emre
 */
public abstract class EvcilHayvan {
    private String isim;
    private int yas;
    private double agirlik;
    public EvcilHayvan(String isim,int yas,double agirlik){
        this.setIsim(isim);
        this.setYas(yas);
        this.setAgirlik(agirlik);
    }
    public String getIsim(){
        return this.isim;
    }
    public int getYas(){
        return this.yas;
    }
    public double getAgirlik(){
        return this.agirlik;
    }
    public void setIsim(String isim){
        this.isim=isim;
    }
    public void setYas(int yas){
        this.yas=yas;
    }
    public void setAgirlik(double agirlik){
        this.agirlik=agirlik;
    }
    public abstract double ilac01Dozaj();
    public abstract double ilac02Dozaj();
    public String toString(){
        return "Ýsim: "+isim+" Yaþ: "+yas+" Aðýrlýk: "+agirlik+" pounds";
    }
    
}
