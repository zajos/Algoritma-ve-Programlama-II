
package proje;
import java.util.Scanner;

public class DoublyLinkedList {
    //head and tail nodes
    private Node head;
    private Node tail;
    //adding new node with data to the list in order
    public void insertSorted(Movie data){
        Node newNode=new Node(data,null,null);
        //if list is empty
        if(getHead()==null){
            head=newNode;
            tail=newNode;
        }
        //add to the beginnig of the list
        else if(data.getDate()<=getHead().getData().getDate()||(data.getDate()==getHead().getData().getDate()&& data.getTitle().compareToIgnoreCase(getHead().getData().getTitle())<0)){
            newNode.setNext(getHead());
            getHead().setPrevious(newNode);
            head=newNode;
        }
        //add to the end of the list
        else if(data.getDate()>=getTail().getData().getDate() || (data.getDate()==getTail().getData().getDate()&&data.getTitle().compareToIgnoreCase(getTail().getData().getTitle())>0) ){
            newNode.setPrevious(getTail());
            getTail().setNext(newNode);
            tail=newNode;
        }
        //add to the middle of the list
        else{
            Node current=getHead();
            while(current.getNext()!=null &&
            (data.getDate()>current.getNext().getData().getDate() || 
            (data.getDate()==current.getNext().getData().getDate()&&data.getTitle().compareToIgnoreCase(current.getNext().getData().getTitle())>0))){
                current=current.getNext();
            }
            newNode.setPrevious(current);
            newNode.setNext(current.getNext());
            current.getNext().setPrevious(newNode);
            current.setNext(newNode);
        }
    }
    //finding the movie whose name is entered from the list and printing it
    public void matchIsFound(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Filmin adý:");
        String title=sc.nextLine();
        Node current=head;
        while(current!=null){
            if(current.getData().getTitle().equalsIgnoreCase(title)){
                System.out.println(current.getData().toString());
                break;
            }
            current=current.getNext();
            
        }
        if(current==null){
            System.out.println("Aradýðýnýz film bulunamamýþtýr!");
        }
    }
    //find and delete the movie whose name is entered from the list
    public void delete(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Filmin adý:");
        String title=scan.nextLine();
        Node current=head;
        
        while(current!=null){
            if(current.getData().getTitle().equalsIgnoreCase(title)){
                //if current's previous node is exist
                if (current.getPrevious() != null) {
                    current.getPrevious().setNext(current.getNext());
                } 
                //if current's previous node is not exist. which means current is head
                else{
                    head = current.getNext();
                }
                //if current's next node is exist
                if (current.getNext() != null) {
                    current.getNext().setPrevious(current.getPrevious());
                }
                //if current's next node is not exist. which means current is tail
                else {
                    tail = current.getPrevious();
                }
                System.out.println("Ýstediðiniz film envanterden silinmiþtir!");
                return; 
            }
            current=current.getNext();
        }
        System.out.println("Aradýðýnýz film bulunamamýþtýr!");
    }
    //printing movies made before 2000
    public void printFromMillenium(){
        Node current=getHead();
        while (current!=null&&current.getData().getDate()<2000){
            System.out.print(current.getData().toString());
            current=current.getNext();
        }
    }
    //toString override
    @Override
    public String toString(){
        Node current=getHead();
        String finalTxt="";
        while (current!=null){
            finalTxt=finalTxt+current.getData().toString();
            current=current.getNext();
        }
        return finalTxt;
    }
    //toString method backwards
    public String toStringBackwards(){
        Node current=getTail();
        String finalTxt="";
        while (current!=null){
            finalTxt=finalTxt+current.getData().toString();
            current=current.getPrevious();
        }
        return finalTxt;
    }
    //get methods to head and tail
    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }
    
    


}
