import java.util.*;

public class AQueue<T>  implements IQueue<T>{
    Vector<T> q = new Vector<>();
    int size = 0;
    @Override
    public void enqueue(T item) {
        q.add(0,item);
        size++;


    }

    @Override
    public T dequeue() {
        T ele = q.lastElement();
        q.remove(size-1);

        return ele;
    }

    @Override
    public boolean isEmpty() {

        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
    void print(){

        System.out.println(q.toString());
    }
    public static void main(String[] args) {
        AQueue<Integer> x = new AQueue<>();
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
            x.dequeue();
            x.print();

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
