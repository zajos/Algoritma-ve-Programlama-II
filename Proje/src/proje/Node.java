
package proje;

public class Node {
    private Movie data;
    private Node next;
    private Node previous;
        
    //default constructor method
    public Node(){
        data=null;
        next=null;
        previous=null;
    }
    //parameterized constructor method
    public Node(Movie movie, Node previousNode,Node nextNode){
        data=movie;
        next=nextNode;
        previous=previousNode;
    }
    //getter/setter methods
    public void setData(Movie data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Movie getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrevious() {
        return previous;
    }
        
}
