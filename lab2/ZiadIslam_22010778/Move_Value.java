import java.util.*;


public class Move_Value {
    public static int[] moveValue(int[] array, int value) {
        int[] z = new int[array.length];
        int x = array.length;
        int j = x-1;
        int y=0;
        for(int i =0;i<x;i++)
        {
            if(array[i] == value){
                z[j] = array[i];
                j--;
            }
            else{

                z[y] = array[i];
                y++;
            }
        }
        return z;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
        String[] s = sin.split(", ");
        ;
        int[] arr = new int[s.length];

        if (s.length == 1 && s[0].isEmpty())
            arr = new int[]{};
        else {
            for (int i = 0; i < s.length; ++i) {
                arr[i] = Integer.parseInt(s[i]);

            }

        }
        int value = sc.nextInt();
        int[] z = new int[arr.length];
        z = moveValue(arr,value);
        System.out.println(Arrays.toString(z));

    }
}
