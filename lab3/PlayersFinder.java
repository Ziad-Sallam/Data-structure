import java.awt.*;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


interface IPlayersFinder {

    /**
     * Search for players locations at the given photo
     *
     * @param photo     Two dimension array of photo contents
     *                  Will contain between 1 and 50 elements, inclusive
     * @param team      Identifier of the team
     * @param threshold Minimum area for an element
     *                  Will be between 1 and 10000, inclusive
     * @return Array of players locations of the given team
     */
    java.awt.Point[] findPlayers(String[] photo, int team, int threshold);

}


public class PlayersFinder implements IPlayersFinder{
    /*
       Implement your class here
    */
    public static int r,c,r_min,r_max,c_min,c_max,n_square, count=0;
    public static ArrayList<Point> box = new ArrayList<>();

    public static int get_max_x(ArrayList<Point> x)
    {
        int ans = Integer.MIN_VALUE;
        for(Point i : x)
        {
            if(i.x > ans)
            {
                ans = i.x;
            }
        }
        return ans;
    }
    public static int get_min_x(ArrayList<Point> x)
    {
        int ans = Integer.MAX_VALUE;
        for(Point i : x)
        {
            if(i.x < ans)
            {
                ans = i.x;
            }
        }
        return ans;
    }
    public static int get_min_y(ArrayList<Point> x)
    {
        int ans = Integer.MAX_VALUE;
        for(Point i : x)
        {
            if(i.y < ans)
            {
                ans = i.y;
            }
        }
        return ans;
    }
    public static int get_max_y(ArrayList<Point> x)
    {
        int ans = Integer.MIN_VALUE;
        for(Point i : x)
        {
            if(i.y > ans)
            {
                ans = i.y;
            }
        }
        return ans;
    }


    public static String change(String x, int i)
    {
        StringBuilder y = new StringBuilder(x);
        y.setCharAt(i,'t');
        x = String.valueOf(y);
        return x;
    }

    public static Point[] sort_points(Point[] points)
    {
        Point[] x = new Point[count];
        System.arraycopy(points, 0, x, 0, count);
        Arrays.sort(x,(p1,p2) -> Integer.compare(p1.x,p2.x));
        return x;
    }

    public static void FindCentre(String[] photo,int team,int i,int j, int threshold)
    {

        box.add(new Point(i,j));
        photo[i] = change(photo[i],j);

        n_square++;


        if(j-1 > -1 && photo[i].charAt(j-1) == Character.forDigit(team,10))
        {

            FindCentre(photo, team, i, j-1, threshold);

        }

        if(j+1 < c && photo[i].charAt(j+1) == Character.forDigit(team,10))
        {

            FindCentre(photo, team, i, j+1, threshold);

        }

        if(i+1 < r && photo[i+1].charAt(j) == Character.forDigit(team,10))
        {

            FindCentre(photo, team, i+1, j, threshold);

        }
        if(i-1 > -1 && photo[i-1].charAt(j) == Character.forDigit(team,10))
        {

            FindCentre(photo, team, i-1, j, threshold);

        }

        int x = (c_max + c_min) +1;
        int y = (r_max + r_min) +1;

    }

    @Override
    public Point[] findPlayers(String[] photo, int team, int threshold) {
        Point[] point = new Point[50];

        for(int i = 0;i<r;i++)
        {
            for(int j = 0; j< c;j++)
            {
                if(photo[i].charAt(j) ==  Character.forDigit(team,10))
                {
                    r_min =Integer.MAX_VALUE;
                    r_max =Integer.MIN_VALUE;
                    c_min =Integer.MAX_VALUE;
                    c_max =Integer.MIN_VALUE;
                    n_square = 0;

                    box.clear();

                    FindCentre(photo, team,i,j,threshold);

                    if( n_square * 4 >= threshold)
                    {
                        Point temp2 = new Point();
                        temp2.y = get_min_x(box) + get_max_x(box) + 1;
                        temp2.x = get_min_y(box) + get_max_y(box) + 1;

                        point[count] = temp2;
                        count++;

                    }

                }
            }
        }

        return point;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String z = scanner.nextLine();
        String[] parts = z.split(",");

        r = Integer.parseInt(parts[0].trim());
        c = Integer.parseInt(parts[1].trim());
        if(r == 0 || c == 0){System.out.println("[]"); return;}
        String[] photo = new String[r];

        for(int i = 0;i<r;i++)
        {
            photo[i] =scanner.nextLine();
        }
        int team = scanner.nextInt();
        int threshold = scanner.nextInt();
        PlayersFinder x = new PlayersFinder();
        Point[] points = x.findPlayers(photo, team, threshold);
        points = sort_points(points);

        try {
            System.out.print('[');
            for (int i = 0; i < count - 1; i++) {
                System.out.print("(" + points[i].x + ", " + points[i].y + ")" + ", ");


            }
            System.out.print("(" + points[count - 1].x + ", " + points[count - 1].y + ")");
            System.out.print("]");
            return;
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("]");
        }

    }
}