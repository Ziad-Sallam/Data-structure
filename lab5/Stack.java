//import java.util.Arrays;
//import java.util.Objects;
//import java.util.Scanner;
//
//interface IStack<T> {
//    /**
//     * Removes the element at the top of stack and returns that element.
//     * @return top of stack element, or through exception if empty
//     */
//    public T pop();
//    /**
//     * Get the element at the top of stack without removing it from stack.
//     * @return top of stack element, or through exception if empty
//     */
//    public T peek();
//    /**
//     * Pushes an item onto the top of this stack.
//     * @param element to insert
//     */
//    public void push(T element);
//    /**
//     * Tests if this stack is empty
//     * @return true if stack empty
//     */
//    public boolean isEmpty();
//    public int size();
//}
//
//public class Stack<T> implements IStack<T>{
//    private SingleLinkedList<T> stack;
//
//    @Override
//    public T pop() {
//        if(stack.isEmpty())
//            throw new NullPointerException("Error");
//        T x = stack.get(0);
//        stack.remove(0);
//
//        return x;
//    }
//
//    @Override
//    public T peek() {
//        if(stack.isEmpty())
//            throw new NullPointerException("Error");
//        return stack.get(0);
//    }
//
//    @Override
//    public void push(T element) {
//        stack.add(0,element);
//
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return stack.isEmpty();
//    }
//
//    @Override
//    public int size() {
//        return stack.size();
//    }
//
//    public void print()
//    {
//        stack.print();
//    }
//    public Stack()
//    {
//        stack = new SingleLinkedList<>();
//    }
//
//    public static void main(String[] args) {
//        try{
//        Scanner sc = new Scanner(System.in);
//        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
//        String[] s = sin.split(", ");;
//        int[] arr = new int[s.length];
//        if (s.length == 1 && s[0].isEmpty())
//            {arr = new int[]{};}
//        else {
//            for(int i = 0; i < s.length; ++i)
//                arr[i] = Integer.parseInt(s[i]);
//        }
//        Stack<Integer> stack = new Stack<>();
//        for(int i = arr.length-1; i>-1;i--){
//            stack.push(arr[i]);
//        }
//        String op = sc.nextLine();
//        if(Objects.equals(op, "size")){
//            System.out.println(stack.size());
//        } else if (Objects.equals(op, "peek")) {
//            if(stack.size() == 0){
//                System.out.println("Error");
//                return;
//
//            }
//            System.out.println(stack.peek());
//
//        } else if (Objects.equals(op, "push")) {
//            int x = sc.nextInt();
//            stack.push(x);
//            stack.print();
//
//        }
//        else if (Objects.equals(op, "pop")) {
//            if(stack.size() == 0){
//                System.out.println("Error");
//                return;
//
//            }
//            stack.pop();
//            stack.print();
//
//        }
//        else if (Objects.equals(op, "isEmpty")) {
//            if(stack.isEmpty()) {
//                System.out.println("True");
//            }
//
//            else{
//                    System.out.println("False");
//            }
//
//
//        }
//        else {
//            System.out.println("Error");
//
//        }
//        }
//        catch (Exception e)
//        {
//            throw new NullPointerException("Error");
//        }
//
//
//    }
//}
//
