package datastructures;

public class LinkedList {

  private int lenght;
  private Node first;
  private Node last;

  class Node {

    private int data;
    private Node next;

    public Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }

  }

  public void add(int el){

    if(first == null){
      first = new Node(el, last);
    }else if(last == null){
      final Node n = new Node(el, null);
      first.next = n;
      last = n;
    }else{
      final Node n = new Node(el, null);
      last.next = n;
      last = n;
    }

    lenght++;

  }


  public void printall(){

    if(first != null){

      Node el = first;

      do{

        System.out.println(el.data);

        el = el.next;

      }while(el != null);


    }

  }


  public static void main(String[] args){

    LinkedList list = new LinkedList();

    list.add(0);
    list.add(1);
    list.add(2);
    list.add(3);

    list.printall();


  }

}
