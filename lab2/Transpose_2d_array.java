import java.util.Arrays;
import java.util.Scanner;

public class Transpose_2d_array {

    public static int[][] transpose(int[][] array) {
        int r = array.length;
        int c = array[0].length;
    	int[][] z = new int[c][r];
        for(int i = 0; i<c;i++)
        {
            for(int j = 0; j<r;j++)
            {
                z[i][j] = array[j][i];
            }
        }
        return z;
    }
    public static void main(String[] args){
        // T
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        str = str.substring(0,0) + '\0' + str.substring(1);
        str = str.substring(0,1) + '\0' + str.substring(2);



        str = str.substring(0,str.length()-2) + '\0' + str.substring(str.length()-1);
        str = str.substring(0,str.length()-1) + '\0' ;



        str = str.replaceAll("\0","");


        String[] rows = str.split("], \\[");

        int[][] arr = new int[rows.length][rows[0].split(", ").length];

        for (int i = 0; i < rows.length; i++) {
            String[] elements = rows[i].split(", ");


            for (int j = 0; j < elements.length; j++) {
                try {
                    arr[i][j] = Integer.parseInt(elements[j]);
                }
                catch (NumberFormatException e){
                    System.out.println("[[]]");
                    return;
                }

            }
        }


        System.out.println(Arrays.deepToString(transpose(arr)));


    }


}