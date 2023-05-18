/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;

/**
 *
 * @author Emre
 */
public class ContactInfo {
    private String homeAdress;
    private String telNumber;
    private String eMail;
    public ContactInfo(){
    homeAdress=null;
    telNumber=null;
    eMail=null;
    }
    public ContactInfo(String homeAdress,String telNumber,String eMail){
        this.setHomeAdress(homeAdress);
        this.setTelNumber(telNumber);
        this.setEmail(eMail);
    }
    public String getHomeAdress(){
        return homeAdress;
    }
    public String getTelNumber(){
        return telNumber;
    }
    public String getEmail(){
        return eMail;
    }
    public void setHomeAdress(String homeAdress){
        this.homeAdress=homeAdress;
    }
    public void setTelNumber(String telNumber){
        this.telNumber=telNumber;
    }
    public void setEmail(String eMail){
        this.eMail=eMail;
    }
    public ContactInfo(ContactInfo original){
        if(original==null){
            System.out.println("Fatal error.");
            System.exit(0);
        }
        homeAdress=original.homeAdress;
        telNumber=original.telNumber;
        eMail=original.eMail;
    }
    public String toString(){
        return "Ev adres: "+homeAdress+", Telefon no: "+telNumber+", E-posta: "+eMail;
    }
    public boolean equals(Object other){
        if(other==null){
            return false;
        }
        else if(getClass()!=other.getClass()){
            return false;
        }
        else{
            ContactInfo otherC=(ContactInfo)other;
            return (homeAdress.equals(otherC.homeAdress))&&(telNumber.equals(otherC.telNumber))&&(eMail.equals(otherC.eMail));
        }
    }
}
