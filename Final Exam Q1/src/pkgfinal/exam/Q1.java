/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkgfinal.exam;
import java.util.Stack;
/**
 *
 * @author Emre
 */
public class Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyLinkedList myList=new MyLinkedList();
        myList.addToStart("Eleman 5");
        myList.addToStart("Eleman 4");
        myList.addToStart("Eleman 3");
        myList.addToStart("Eleman 2");
        myList.addToStart("Eleman 1");
        myList.remove(3);
        myList.printOut();
        Stack<String> stack=new Stack<>();
        for(int i=1;i<myList.getNodeCount()+1;i++){
            stack.push(myList.getElement(i));
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
    
}
