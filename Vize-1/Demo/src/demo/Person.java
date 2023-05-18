/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;

/**
 *
 * @author Emre
 */
public class Person {
    private String name;
    private ContactInfo contactInformation;
    public Person(){
        name=null;
        contactInformation=null;
    }
    public Person(String name,ContactInfo info){
        this.setName(name);
        this.setContact(info);
    }
    public String getName(){
        return this.name;
    }
    public ContactInfo getContact(){
        return new ContactInfo(contactInformation);
    }
    public void setName(String name){
        this.name=name;
    }
    public void setContact(ContactInfo info){
        this.contactInformation=info;
    }
    public Person(Person original){
        if(original==null){
            System.out.println("Fatal error");
            System.exit(0);
        }
        name=original.name;
        contactInformation=new ContactInfo(original.contactInformation);
    }
    public String toString(){
        return "Ad Soyad: "+name+"\n"+contactInformation.toString();
    }
    public boolean equals(Object other){
        if(other==null){
            return false;
        }
        else if(getClass()!=other.getClass()){
            return false;
        }
        else{
            Person otherP=(Person)other;
            return (name.equals(otherP.name))&&(contactInformation.equals(otherP.contactInformation));
        }
    }
}
