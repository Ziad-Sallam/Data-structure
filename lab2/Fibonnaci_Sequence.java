import java.util.*;

public class Fibonnaci_Sequence {
    public static int fibonacci(int n) {
        if(n==1) return 0;
        if (n==2) return 1;
        if (n==3) return 1;
        return fibonacci(n-2) + fibonacci(n-1);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println(fibonacci(x));
    }
}