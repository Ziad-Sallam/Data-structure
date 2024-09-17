import java.util.Objects;
import java.util.Scanner;

public class DoubleLinkedList<T> {

    private class DNode{
        T element;
        DNode next,prev;

        DNode(T e)
        {
            element = e;
            next = null;
            prev = null;
        }
        DNode()
        {
            new DNode(null);
        }

    }


    private DNode head,tail;
    private int size;

    public DoubleLinkedList()
    {
        head = null;
        tail = null;
        size = 0;
    }

    private DNode get_node(int index)
    {
        if(index >= size)
        {
            return null;
        }
        DNode p = head;
        for(int i = 0;i<index;i++)
        {
            p=p.next;
        }
        return p;

    }



    public void add(int index, T element) {
        DNode new_node = new DNode(element);

        if(index > size)
        {

            return;
        }

        if (size == 0)
        {
            tail = head;
            head = new_node;size++;
            tail = new_node;
            return;
        }
        else if(index == 0)
        {
            new_node.next = head;
            head.prev = new_node;
            head = new_node;
            size++;
            return;
        }

        else if(size == 1)
        {
            DNode p = new  DNode(element);
            p.prev = tail;
            tail.next = p;
            tail = p;
            size++;
            return;
        }
        else if(index == size)
        {
            new_node.prev = tail;
            tail.next = new_node;
            tail = tail.next;
        }

        DNode p = head;
        for(int i = 1;i<index;i++){

            p = p.next;
        }
        new_node.next = p.next;
        new_node.prev = p;
        p.next = new_node;
        p = p.next;
        p.prev  = new_node;
        size++;

    }


    public void add(T element) {

        add(size,element);

    }


    public T get(int index) {
        DNode p = get_node(index);
        assert p != null;
        return p.element;
    }


    private void set(int index, T element) {
        DNode p = get_node(index);
        assert p != null;
        p.element = element;

    }


    private void clear() {
        head = null;
        tail = null;
        size = 0;

    }


    public boolean isEmpty() {
        return head == null;
    }


    public void remove(int index) {
        if(index ==0)
        {
            if(size == 1){head = null;size--; return;}
            head = head.next;
            head.prev = null;
            size--;
            return;
        }
        DNode  p= get_node(index-1);
        assert p != null;
        if(index == size-1){
            tail = p;
            tail.next = null;
            size--;
            return;
        }

            p.next = p.next.next;
            p = p.next;
            p.prev = p.prev.prev;

        size--;



    }


    public int size() {
        return size;
    }

    public DoubleLinkedList<T> sublist(int fromIndex, int toIndex) {
        DoubleLinkedList<T> new_list = new DoubleLinkedList<>();

        DNode p_tail = get_node(toIndex);
        for(int i = fromIndex;i<=toIndex;i++)
        {
            new_list.add(get(i));

        }

        return new_list;


    }


    public boolean contains(T o) {
        DNode p = head;
        for(int i = 0;i<size;i++)
        {
            if (p.element == o)
            {
                return true;
            }
            p=p.next;
        }
        return false;
    }

    public void print()
    {
        if(head == null){
            System.out.println("[]");

            return;
        }



        DNode p = head;
        System.out.print("[" + p.element);
        for(int i = 1; i<size;i++)
        {
            p=p.next;
            System.out.print(", "+p.element);
        }
        System.out.print("]\n");

    }
    public DoubleLinkedList<Integer> scan(String s)
    {
        DoubleLinkedList<Integer> z = new DoubleLinkedList<>();
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String arr = sc.nextLine().replaceAll("[\\[\\]]", "");

        DoubleLinkedList<Integer> z = new DoubleLinkedList<>();
        z = z.scan(arr);
        String op = sc.nextLine();
        if(Objects.equals(op,"add"))
        {
            int x = sc.nextInt();
            z.add(x);
            z.print();
        }
        else if (Objects.equals(op,"addToIndex")) {
            int index = sc.nextInt();
            if(index > z.size() || index < 0)
            {
                System.out.println("Error");
                return;
            }
            int val = sc.nextInt();

            z.add(index,val);
            z.print();

        }
        else if (Objects.equals(op,"isEmpty"))
        {
            boolean x = z.isEmpty();
            if(x)
            {
                System.out.println("True");
            }
            else {
                System.out.println("False");
            }
        }
        else if (Objects.equals(op,"set"))
        {
            int index = sc.nextInt();
            int val = sc.nextInt();
            if(index > z.size()-1|| index < 0)
            {
                System.out.println("Error");
                return;
            }

            z.set(index,val);
            z.print();

        }
        else if (Objects.equals(op,"get"))
        {
            int x = sc.nextInt();
            if(x > z.size()-1 || x < 0)
            {
                System.out.println("Error");
                return;
            }
            int c = z.get(x);

            System.out.println(c);

        }
        else if (Objects.equals(op,"size"))
        {
            System.out.println(z.size());
        }
        else if (Objects.equals(op,"contains"))
        {

            int val = sc.nextInt();
            boolean x = z.contains(val);
            if(x)
            {
                System.out.println("True");
            }
            else {
                System.out.println("False");
            }
            return;

        }
        else if (Objects.equals(op,"sublist")) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            if(to > z.size()-1 || to < 0 || from > z.size()-1 || from < 0 || from > to)
            {
                System.out.println("Error");
                return;
            }
            DoubleLinkedList<Integer> sub = z.sublist(from,to);
            sub.print();

        }
        else if (Objects.equals(op,"clear"))
        {
            z.clear();
            z.print();
        }
        else if (Objects.equals(op,"remove")) {
            int index = sc.nextInt();
            if(index > z.size()-1 || index < 0)
            {
                System.out.println("Error");
                return;
            }
            z.remove(index);
            z.print();

        }
        else {
            System.out.println("Error");
        }
    }
}