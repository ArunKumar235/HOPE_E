package Practice.OOPs.Generics;


class Node<T>{
    T val;
    Node<T> next;

    Node(T val){
        this.val = val;
    }

    Node(T val, Node next){
        this.val = val;
        this.next = next;
    }
}

class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    int size;
    LinkedList(){
        this.size = 0;
    }

    public void insertAtLast(T val){
        size++;
        if(head==null){
            head = tail = new Node<>(val);
            return;
        }
        tail.next = new Node<>(val);
        tail = tail.next;
    }

    public void insertAtFirst(T val){
        size++;
        if(head==null){
            head = tail = new Node<>(val);
            return;
        }
        Node<T> temp = new Node<>(val);
        temp.next = head;
        head = temp;
    }

    public void display(){
        Node<T> temp = head;
        while(temp!=null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public void insert(int index, T val){
        if(index==0){
            insertAtFirst(val);
        }else if(index==size){
            insertAtLast(val);
        }else{
            Node<T> dummy = new Node<>(null);
            insertRecursion(index, dummy,  head, val);
        }
        size++;
    }

    private void insertRecursion(int index, Node<T> prev, Node<T> curr, T val){
        if(index==0){
            prev.next = new Node<>(val);
            prev.next.next = curr;
            return;
        }else{
            insertRecursion(index-1, curr, curr.next, val);
        }
    }

    public void delete(int index){
        if(index==0){
            head = head.next;
        }else{
            Node<T> temp = head;
            while(index>1 && temp.next!=null){
                temp = temp.next;
                index--;
            }
            temp.next = temp.next.next;
            tail = temp.next;
        }
        size--;
    }
}


public class CustomLinkedList {
    public static void main(String[] args) {
        LinkedList<Character> ll = new LinkedList<>();
        ll.insertAtFirst('a');
        ll.insertAtLast('b');
        ll.insertAtLast('d');
        ll.insert(2,'c');
        ll.display();
        System.out.println();
        ll.delete(2);
        ll.display();
    }
}
