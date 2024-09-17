import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;



public class LinkedQueue<T> implements IQueue<T>{
    private DoubleLinkedList<T> queue = new DoubleLinkedList<>();
    @Override
    public void enqueue(T item) {
        queue.add(0,item);
    }

    @Override
    public T dequeue() {
        T x = queue.get(queue.size()-1);
        queue.remove(queue.size()-1);

        return x;
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public int size() {
        return queue.size();
    }
    public  void print(){
        queue.print();
    }

    public static void main(String[] args) {
        LinkedQueue<Integer> x = new LinkedQueue<>();
        Scanner sc= new Scanner(System.in);

        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
        String[] s = sin.split(", ");;
        int[] arr = new int[s.length];
        if (s.length == 1 && s[0].isEmpty())
            {arr = new int[]{};}
        else {
            for(int i = 0; i < s.length; ++i)
                arr[i] = Integer.parseInt(s[i]);
        }
        for(int i = arr.length-1; i>-1;i--){
            x.enqueue(arr[i]);
        }


        String op = sc.nextLine();
        if(Objects.equals(op, "size")){
            System.out.println(x.size());
        }

        else if (Objects.equals(op, "dequeue")) {
            if(x.size() == 0){
                System.out.println("Error");
                return;

            }
            System.out.println(x.dequeue());

        }


        else if (Objects.equals(op, "enqueue")) {
            int z = sc.nextInt();
            x.enqueue(z);
            x.print();

        }





        else if (Objects.equals(op, "isEmpty")) {
            if(x.isEmpty()) {
                System.out.println("True");
            }

            else{
                    System.out.println("False");
            }


        }
        else {
            System.out.println("Error");

        }

    }
}




