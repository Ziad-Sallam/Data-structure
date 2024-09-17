import java.util.*;


public class Sum_Even_and_Odd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
        String[] s = sin.split(", ");
        ;
        int[] arr = new int[s.length];
        int even = 0,odd = 0;
        if (s.length == 1 && s[0].isEmpty())
            arr = new int[]{};
        else {
            for (int i = 0; i < s.length; ++i) {
                arr[i] = Integer.parseInt(s[i]);
                if(arr[i] % 2 == 0) even+= arr[i];
                else odd += arr[i];
            }

        }
        System.out.println("["+ even+", "+odd+"]");
    }
}
