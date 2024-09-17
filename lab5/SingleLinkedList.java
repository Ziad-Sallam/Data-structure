//import java.util.Objects;
//import java.util.Scanner;
//
//public class SingleLinkedList<T>  {
//
//    private class Node{
//        T element;
//        Node next;
//
//        Node(T e)
//        {
//            element = e;
//            next = null;
//        }
//        Node(){
//            new Node(null);
//        }
//    }
//    private Node head;
//    private int size;
//
//    public void add(int index,T element) {
//        Node new_node = new Node(element);
//
//
//        if(index > size)
//        {
//
//            return;
//        }
//        if (head == null)
//        {
//            head = new_node;size++;
//            return;
//        }
//        Node p = head;
//        if(index == 0)
//        {
//            new_node.next=head;
//            head = new_node;
//            size++;
//            return;
//
//        }
//        for(int i = 1;i<index;i++){
//
//            p = p.next;
//        }
//        new_node.next = p.next;
//        p.next = new_node;
//        size++;
//
//    }
//
//
//    public void add(T element) {
//        add(size,element);
//
//    }
//
//
//    public T get(int index) {
//        if (index >= size){return null;}
//        Node p =head;
//        for(int i = 0;i<index;i++)
//        {
//            p=p.next;
//        }
//        return p.element;
//    }
//
//
//    public void set(int index, T element) {
//        if (index >= size){return;}
//        Node p =head;
//        for(int i = 0;i<index;i++)
//        {
//            p=p.next;
//        }
//        p.element = element;
//
//    }
//
//
//    public void clear() {
//        head = null;
//        size = 0;
//
//    }
//
//
//    public boolean isEmpty() {
//        return head == null;
//    }
//
//
//    public void remove(int index) {
//        Node p = head;
//        if(index==0)
//        {
//            head = head.next;
//            size--;
//            return;
//        }
//
//        for(int i = 0;i<index-1;i++)
//        {
//            p = p.next;
//        }
//        p.next = p.next.next;
//        size--;
//
//    }
//
//
//    public int size() {
//        return size;
//    }
//
//
//    public void print()
//    {
//        if(head == null){
//            System.out.println("[]");
//
//            return;
//        }
//
//        Node p = head;
//        System.out.print("[" + p.element);
//        for(int i = 1; i<size;i++)
//        {
//            p=p.next;
//            System.out.print(", "+p.element);
//        }
//        System.out.print("]\n");
//
//
//    }
//    public SingleLinkedList()
//    {
//        head = null;
//
//        size = 0;
//    }
//
//    public SingleLinkedList(T n)
//    {
//        head = new Node(n);
//
//        size = 1;
//    }
//
//}