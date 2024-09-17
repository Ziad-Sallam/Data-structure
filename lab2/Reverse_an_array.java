import java.util.*;

public class Reverse_an_array {
    public int[] reverse(int[] array){

        /*Implement your reverse method here*/
        int x = array.length;
        int[] z = new int[x];
        for(int i = 0;i< x;i++){
            z[i] = array[x-i-1];
        }
        return z;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
        String[] s = sin.split(", ");;
        int[] arr = new int[s.length];
        if (s.length == 1 && s[0].isEmpty())
            arr = new int[]{};
        else {
            for(int i = 0; i < s.length; ++i)
                arr[i] = Integer.parseInt(s[i]);
        }
        int[] res = new Reverse_an_array().reverse(arr);
        System.out.print("[");
        for(int i = 0; i < res.length; ++i) {
            System.out.print(res[i]);
            if(i != s.length - 1)
                System.out.print(", ");
        }
        System.out.print("]");
    }
}