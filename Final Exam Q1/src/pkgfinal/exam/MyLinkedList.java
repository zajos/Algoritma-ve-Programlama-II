/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgfinal.exam;

/**
 *
 * @author Emre
 */
public class MyLinkedList {
    public MyLinkedList() {
        head = tail = null;
 }

    private Node head, tail;

    class Node {
        String item;
        Node next;
        Node prev;
    }
    public void addToStart(String str){
        Node current=new Node();
        current.item=str;
        if(head==null){
            head=current;
        }
        else{
            current.next=head;
            head.prev=current;
            head=current;
        }   
    }
    public String getElement(int i){
        Node current=head;
        int sira=1;
        while(current!=null){
            if(sira==i){
                return current.item;
            }
            current=current.next;
            sira++;
        }
        return null;
    }
    public Node removeHead(){
        Node current=head;
        if(head.next==null){
            head=null;
            return head;
        }
        else{
            head.next.prev=null;
            head=head.next;
        }
        return current;
    }
    public Node removeLast(){
        Node current=tail;
        if(tail.prev==null){
            tail=null;
            return tail;
        }
        else{
            tail.prev.next=null;
            tail=tail.prev;
        }
        return current;
    }
    public Node remove(int i){
        Node current=head;
        String element=getElement(i);
        while(!current.item.equals(element)){
            current=current.next;
        }
        Node temp=current;
        current.next.prev=current.prev;
        current.prev.next=current.next;
        current=null;
        return temp;
    }
    public void printOut(){
        Node current=head;
        String print="";
        while(current!=null){
            print=print+current.item+"\n";
            current=current.next;
        }
        System.out.print(print);
    }


    public int getNodeCount(){
        Node current=head;
        int count=0;
        while(current!=null){
            count++;
            current=current.next;
        }
        return count;
    }
   }// End of class MyLinkedList
   
