/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;

/**
 *
 * @author Emre
 */
public abstract class Vehicle {
    private String brand;
    private String licencePlate;
    private Person owner;
    public Vehicle(){
        brand=null;
        licencePlate=null;
        owner=null;
    }
    public Vehicle(String brand,String licence,Person owner){
        this.setBrand(brand);
        this.setLicencePlate(licence);
        this.setOwner(owner);
    }
    public String getBrand(){
        return this.brand;
    }
    public String getLicencePlate(){
        return this.licencePlate;
    }
    public Person getOwner(){
        return new Person(owner);
    }
    public void setBrand(String brand){
        this.brand=brand;
    }
    public void setLicencePlate(String licence){
        this.licencePlate=licence;
    }
    public void setOwner(Person owner){
        this.owner=owner;
    }
    public Vehicle(Vehicle original){
        if(original==null){
            System.out.println("Fatal error");
            System.exit(0);
        }
        brand=original.brand;
        licencePlate=original.licencePlate;
        owner=new Person(original.owner);
    }
    public String toString(){
        return "Marka: "+brand+", Plaka: "+licencePlate+"\nSahibinin Bilgileri:\n"+owner.toString();
    }
    public boolean equals(Object other){
        if(other==null){
            return false;
        }
        else if(getClass()!=other.getClass()){
            return false;
        }
        else{
            Vehicle otherV=(Vehicle)other;
            return (brand.equals(otherV.brand))&&(licencePlate.equals(otherV.licencePlate))&&(owner.equals(otherV.owner));
        }
    }
    public abstract int calculateTax();
}
