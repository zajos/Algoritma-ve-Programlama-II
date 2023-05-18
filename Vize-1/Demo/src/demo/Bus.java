/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;

/**
 *
 * @author Emre
 */
public class Bus extends Vehicle{
    private int capacity;
    private int ageOfBus;
    public Bus(){
        capacity=0;
        ageOfBus=0;
    }
    public Bus(String brand,String licence,Person owner,int capacity,int age){
        super(brand,licence,owner);
        this.setCapacity(capacity);
        this.setAge(age);
    }
    public int getCapacity(){
        return this.capacity;
    }
    public int getAge(){
        return this.ageOfBus;
    }
    public void setCapacity(int capacity){
        this.capacity=capacity;
    }
    public void setAge(int age){
        this.ageOfBus=age;
    }
    public Bus(Bus original){
        this(original.getBrand(),original.getLicencePlate(),original.getOwner(),original.getCapacity(),original.getAge());
    }
    @Override
    public int calculateTax(){
        if(ageOfBus<5){
            return 4000;
        }
        else if(ageOfBus>5&&ageOfBus<10){
            return 3000;
        }
        else{
            return 2000;
        }
    }
    public String toString(){
        return "Otobüs kapasitesi: "+capacity+", Otobüsün yaþý: "+ageOfBus+"\n"+super.toString();
    }
    public boolean equals(Object other){
        if(other==null){
            return false;
        }
        else if(getClass()!=other.getClass()){
            return false;
        }
        else{
            Bus otherB=(Bus)other;
            return (this.getBrand().equals(otherB.getBrand()))&&(this.getAge()==(otherB.getAge()))&&(this.getCapacity()==(otherB.getCapacity()))
                    &&(this.getLicencePlate().equals(otherB.getLicencePlate()))&&(this.getOwner().equals(otherB.getOwner()));
        }
    }
}
