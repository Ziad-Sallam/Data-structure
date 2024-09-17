import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface IExpressionEvaluator {

    /**
     * Takes a symbolic/numeric infix expression as input and converts it to
     * postfix notation. There is no assumption on spaces between terms or the
     * length of the term (e.g., two digits symbolic or numeric term)
     *
     * @param expression infix expression
     * @return postfix expression
     */

    public String infixToPostfix(String expression);


    /**
     * Evaluate a postfix numeric expression, with a single space separator
     * @param expression postfix expression
     * @return the expression evaluated value
     */

    public int evaluate(String expression);

}
public class Evaluator implements IExpressionEvaluator {

    public String a;
    public String b;
    public String c;
    public String sa,sb,sc;



    @Override
    public  String infixToPostfix(String expression) {
        Stack<Character> a = new Stack<>();

        String postfix = "";
        char p;

        for (int i = 0; i < expression.length(); i++) {
            char x = expression.charAt(i);
            if (!(rank(x) > 0)){
                postfix += x;
            }else if (x == ')'){

                while ((p = a.pop()) != '('){
                    postfix += p;
                }
            }else{
                while (!a.isEmpty() && x != '('){
                    if(rank(a.peek()) >= rank(x)){
                        postfix += a.pop();
                    }else{
                        break;
                    }
                }
                a.push(x);
            }
        }
        while (!a.isEmpty() && a.peek()!='('){
            postfix += a.pop();
        }
        if(!a.isEmpty()  ){
            throw new NullPointerException("Error");
        }
        return postfix;
    }

    @Override
    public int evaluate(String expression){
        Stack<Integer> stack = new Stack<>();
        sa = sa.replaceAll("a","");
        a=sa;
        a = a.replaceAll("=-","_");
        a= a.replaceAll("=","%");

        sb = sb.replaceAll("b","");
        b=sb;
        b= b.replaceAll("=-","_");
        b= b.replaceAll("=","%");

        sc = sc.replaceAll("c","");
        c=sc;
        c= c.replaceAll("=-","_");
        c= c.replaceAll("=","%");
        String eval = expression;
        eval = (expression).replaceAll("a",a);
        eval = eval.replaceAll("b",b);
        eval = eval.replaceAll("c",c);
        expression = eval;


        int x , y ;
        char[] ch = expression.toCharArray();

        for(int i=0;i<ch.length;i++) {



            if(stack.size()==1 && i==ch.length-1) {
                y = -1 * (int)stack.pop() ;

                return y;
            }

            if(stack.size()==1 &&ch[i]!='_' && ch[i]!='%') {

                int w = -1 * (int)stack.pop() ;
                stack.push(w);

            }


            else if(ch[i]=='_') {
                int r=1;

                int u = -1*(int)(ch[i+1]-'0');

                i++;
                if(i<ch.length-1){
                    u *= -1;
                    i++;
                    while(i<ch.length-1 && !(rank(ch[i])>0) && ch[i]!='_' && ch[i]!='%'){

                        u*= Math.pow(10,1);


                        u = u + (int)(ch[i]-'0');

                        i++;
                    }
                    u *=-1;
                    i--;
                }
                stack.push(u);



            }else if(ch[i]=='%') {
                int r=1;

                int u = (int)(ch[i+1]-'0');


                i++;
                if(i<ch.length-1){
                    i++;
                    while(i<ch.length-1 && !(rank(ch[i])>0) && ch[i]!='_' && ch[i]!='%'){

                        u*= Math.pow(10,1);

                        u+= (int)(ch[i]-'0');
                        i++;

                    }
                    i--;
                }


                stack.push(u);


            }else {

                y = (int)stack.pop();
                x = (int)stack.pop();
                switch(ch[i]) {
                    case '+':
                        stack.push(x+y);
                        break;
                    case '-':

                        stack.push(x-y);
                        break;
                    case '*':
                        stack.push(x*y);
                        break;
                    case '/':{

                        stack.push(x/y);

                    }; break;
                    case '^':
                        if(y<0){
                            stack.push(0) ;
                        }else{
                            stack.push((int)Math.pow(x,y));
                        }
                        break;

                }
            }

        }
        return (int)stack.pop();
    }

    public static int rank(char z)
    {
        switch (z){

            case '^':
                return 4;
            case '/':
                return 3;
            case '*':
                return 3;
            case '-':
                return 2;
            case '+':
                return 2;
            case '(':
                return 1;
            case ')':
                return 1;

        }
        return -1;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Evaluator obj = new Evaluator();
        String expression = scan.nextLine();


        expression = expression.replace("+--","+");
        if(expression.startsWith("--")){
            expression = expression.replaceFirst("--","");
        }
        expression = expression.replace("*--","*");
        expression = expression.replace("/--","/");
        expression = expression.replace("^--","^");
        if(!(expression.startsWith("--"))&&expression.contains("--")){
            expression = expression.replaceAll("--","+");
        }

        try{
            char[] d = expression.toCharArray();
            if(d[0]=='('){

            }else if( (d[0]!='-'&&(rank(d[0]) > 0)) || (rank(d[d.length - 1]) > 0) && d[d.length -1 ]!=')' ){
                throw new NullPointerException("Error");
            }


            for(int i=0;i<d.length-1;i++){

                if((d[i]=='+' || d[i]=='*' || d[i]=='/' || d[i]=='^') && (d[i+1]=='-')){

                    throw new NullPointerException("Error");
                }
                if(rank(d[i]) > 0 && d[i]!=')'){
                    if( (d[i+1] =='*') ||(d[i+1]=='/') || (d[i+1]=='^') ||(d[i+1] == '+')){
                        throw new NullPointerException("Error");
                    }
                }

                if(((d[i]=='(' && i>0 ) && (d[i-1]=='a' || d[i-1]=='b' || d[i-1]=='c')) ||(( d[i]==')') && (d[i+1]=='a' || d[i+1]=='b' || d[i+1]=='c'))){
                    throw new NullPointerException("Error");
                }
                if((d[i]=='a' || d[i]=='b' || d[i]=='c') && (d[i+1]=='a' || d[i+1]=='b' || d[i+1]=='c') ){
                    throw new NullPointerException("Error");
                }

            }


            System.out.println(obj.infixToPostfix(expression));

            obj.sa=scan.nextLine();
            obj.sb=scan.nextLine();
            obj.sc=scan.nextLine();


            System.out.println(obj.evaluate(obj.infixToPostfix(expression)));

        }catch(Exception ex){
            System.out.println("Error");
        }
    }
}

class SingleLinkedList<T>  {

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


    public void add(T element) {
        add(size,element);

    }


    public T get(int index) {
        if (index >= size){return null;}
        Node p =head;
        for(int i = 0;i<index;i++)
        {
            p=p.next;
        }
        return p.element;
    }


    public void set(int index, T element) {
        if (index >= size){return;}
        Node p =head;
        for(int i = 0;i<index;i++)
        {
            p=p.next;
        }
        p.element = element;

    }


    public void clear() {
        head = null;
        size = 0;

    }


    public boolean isEmpty() {
        return head == null;
    }


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


    public int size() {
        return size;
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

}


interface IStack<T> {
    /**
     * Removes the element at the top of stack and returns that element.
     * @return top of stack element, or through exception if empty
     */
    public T pop();
    /**
     * Get the element at the top of stack without removing it from stack.
     * @return top of stack element, or through exception if empty
     */
    public T peek();
    /**
     * Pushes an item onto the top of this stack.
     * @param element to insert
     */
    public void push(T element);
    /**
     * Tests if this stack is empty
     * @return true if stack empty
     */
    public boolean isEmpty();
    public int size();
}

class Stack<T> implements IStack<T>{
    private SingleLinkedList<T> stack;

    @Override
    public T pop() {
        if(stack.isEmpty())
            throw new NullPointerException("Error");
        T x = stack.get(0);
        stack.remove(0);

        return x;
    }

    @Override
    public T peek() {
        if(stack.isEmpty())
            throw new NullPointerException("Error");
        return stack.get(0);
    }

    @Override
    public void push(T element) {
        stack.add(0,element);

    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int size() {
        return stack.size();
    }

    public void print()
    {
        stack.print();
    }
    public Stack()
    {
        stack = new SingleLinkedList<>();
    }

    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(System.in);
            String sin = sc.nextLine().replaceAll("\\[|\\]", "");
            String[] s = sin.split(", ");;
            int[] arr = new int[s.length];
            if (s.length == 1 && s[0].isEmpty())
            {arr = new int[]{};}
            else {
                for(int i = 0; i < s.length; ++i)
                    arr[i] = Integer.parseInt(s[i]);
            }
            Stack<Integer> stack = new Stack<>();
            for(int i = arr.length-1; i>-1;i--){
                stack.push(arr[i]);
            }
            String op = sc.nextLine();
            if(Objects.equals(op, "size")){
                System.out.println(stack.size());
            } else if (Objects.equals(op, "peek")) {
                if(stack.size() == 0){
                    System.out.println("Error");
                    return;

                }
                System.out.println(stack.peek());

            } else if (Objects.equals(op, "push")) {
                int x = sc.nextInt();
                stack.push(x);
                stack.print();

            }
            else if (Objects.equals(op, "pop")) {
                if(stack.size() == 0){
                    System.out.println("Error");
                    return;

                }
                stack.pop();
                stack.print();

            }
            else if (Objects.equals(op, "isEmpty")) {
                if(stack.isEmpty()) {
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
        catch (Exception e)
        {
            throw new NullPointerException("Error");
        }


    }
}

