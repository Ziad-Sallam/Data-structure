import java.util.Objects;
import java.util.Scanner;

public class SingleLinkedList<T>  implements ILinkedList<T>{

    private class Node{
        T element;
        Node next;

        Node(T e)
        {
            element = e;
            next = null;
        }
        Node(){
            new Node(null);
        }
    }
    private Node head;
    private int size;

    @Override
    public void add(int index,T element) {
        Node new_node = new Node(element);


        if(index > size)
        {

            return;
        }
        if (head == null)
        {
            head = new_node;size++;
            return;
        }
        Node p = head;
        if(index == 0)
        {
            new_node.next=head;
            head = new_node;
            size++;
            return;

        }
        for(int i = 1;i<index;i++){

            p = p.next;
        }
        new_node.next = p.next;
        p.next = new_node;
        size++;

    }

    @Override
    public void add(T element) {
        add(size,element);

    }

    @Override
    public T get(int index) {
        if (index >= size){return null;}
        Node p =head;
        for(int i = 0;i<index;i++)
        {
            p=p.next;
        }
        return p.element;
    }

    @Override
    public void set(int index, T element) {
        if (index >= size){return;}
        Node p =head;
        for(int i = 0;i<index;i++)
        {
            p=p.next;
        }
        p.element = element;

    }

    @Override
    public void clear() {
        head = null;
        size = 0;

    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void remove(int index) {
        Node p = head;
        if(index==0)
        {
            head = head.next;
            size--;
            return;
        }

        for(int i = 0;i<index-1;i++)
        {
            p = p.next;
        }
        p.next = p.next.next;
        size--;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public SingleLinkedList<T> sublist(int fromIndex, int toIndex) {
        Node p = head;
        SingleLinkedList<T> new_list = new SingleLinkedList<T>();
        Node pointer = new_list.head;
        for(int i = 0;i<fromIndex;i++)
        {
            p = p.next;
        }
        for(int i = fromIndex;i< toIndex+1;i++)
        {
            new_list.add(p.element);
            p = p.next;

        }
        return new_list;
    }

    @Override
    public boolean contains(T o) {
        Node p = head;

        for(int i = 0;i<size;i++)
        {
            if(p.element == o)
            {
                return true;
            }
            p = p.next;
        }
        return false;
    }


    public void print()
    {
        if(head == null){
            System.out.println("[]");

            return;
        }

        Node p = head;
        System.out.print("[" + p.element);
        for(int i = 1; i<size;i++)
        {
            p=p.next;
            System.out.print(", "+p.element);
        }
        System.out.print("]\n");


    }
    public SingleLinkedList()
    {
        head = null;

        size = 0;
    }

    public SingleLinkedList(T n)
    {
        head = new Node(n);

        size = 1;
    }

    public SingleLinkedList<Integer> scan(String s)
    {
        SingleLinkedList<Integer> z = new SingleLinkedList<>();
        String[] arr = s.split(", ");
        if (!(arr.length == 1 && arr[0].isEmpty()))
        {
            for(int i = 0;i<arr.length;i++)
            {
                int x = Integer.parseInt(arr[i]);
                z.add(x);
            }

        }
        return z;

    }

}