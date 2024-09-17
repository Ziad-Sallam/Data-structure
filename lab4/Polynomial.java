import java.util.*;
import java.lang.Math;

interface IPolynomialSolver {
    /**
     * Set polynomial terms (coefficients & exponents)
     * @param poly: name of the polynomial
     * @param terms: array of [coefficients][exponents]
     */
    void setPolynomial(char poly, int[] terms);

    /**
     * Print the polynomial in ordered human readable representation
     *
     * @param poly: name of the polynomial
     * @return
     */
    String print(char poly);

    /**
     * Clear the polynomial
     * @param poly: name of the polynomial
     */
    void clearPolynomial(char poly);

    /**
     * Evaluate the polynomial
     * @param poly: name of the polynomial
     * @param value: the polynomial constant value
     * @return the value of the polynomial
     */
    float evaluatePolynomial(char poly, float value);

    /**
     * Add two polynomials
     *
     * @param poly1: first polynomial
     * @param poly2: second polynomial
     * @return the result polynomial
     */
    int[] add(char poly1, char poly2);

    /**
     * Subtract two polynomials
     *
     * @param poly1: first polynomial
     * @param poly2: second polynomial
     * @return the result polynomial
     */
    int[] subtract(char poly1, char poly2);

    /**
     * Multiply two polynomials
     *
     * @param poly1: first polynomial
     * @param poly2: second polynomial
     * @return: the result polynomial
     */
    int[] multiply(char poly1, char poly2);
}

public class Polynomial implements IPolynomialSolver{

    SingleLinkedList<Integer> coffA = new SingleLinkedList<>();
    SingleLinkedList<Integer> coffB = new SingleLinkedList<>();
    SingleLinkedList<Integer> coffC = new SingleLinkedList<>();
    SingleLinkedList<Integer> expA = new SingleLinkedList<>();
    SingleLinkedList<Integer> expC = new SingleLinkedList<>();
    SingleLinkedList<Integer> expB = new SingleLinkedList<>();

    SingleLinkedList<Integer> coffR = new SingleLinkedList<>();
    SingleLinkedList<Integer> expR = new SingleLinkedList<>();
    boolean fa = false,fb = false,fc = false, fr = false;



    @Override
    public void setPolynomial(char poly, int[] terms) {
        switch (poly){

            case 'A':
                if(fa) {
                    clearPolynomial('A');
                }
                fa = true;
                int exp = 0;
                for(int i = terms.length-1;i>-1;i--)
                {

                    coffA.add(terms[i]);
                    expA.add(exp);
                    exp++;
                }
                break;
            case 'B':
                if(fb) {
                    clearPolynomial('B');
                }
                fb = true;
                int exp1 = 0;
                for(int i = terms.length-1;i>-1;i--)
                {
                    coffB.add(terms[i]);
                    expB.add(exp1);
                    exp1++;
                }
                break;
            case 'C':
                if(fc) {
                    clearPolynomial('C');
                }
                fc = true;
                int exp2 = 0;
                for(int i = terms.length-1;i>-1;i--)
                {
                    coffC.add(terms[i]);
                    expC.add(exp2);
                    exp2++;
                }
                break;
            case 'R':
                if(fr) {
                    clearPolynomial('R');
                }

                fr = true;
                int exp3 = 0;
                for(int i = terms.length-1;i>-1;i--)
                {
                    coffR.add(terms[i]);
                    expR.add(exp3);
                    exp3++;
                }
                break;
        }

    }

    @Override
    public String print(char poly) {
        String polyString = "";
        SingleLinkedList<Integer> tempExp = new SingleLinkedList<>();
        SingleLinkedList<Integer> tempCo = new SingleLinkedList<>();
        switch (poly) {
            case 'A':
                tempExp = expA;
                tempCo = coffA;
                break;
            case 'B':
                tempExp = expB;
                tempCo = coffB;
                break;
            case 'C':
                tempExp = expC;
                tempCo = coffC;
                break;
            case 'R':
                tempExp = expR;
                tempCo = coffR;
                break;
        }
//        tempExp.add(tempExp.size()-1,0);
//        tempCo.add(tempCo.size()-1,0);


        for (int i = tempCo.size()-1; i > 0 ; i--) {
            if ((int) tempCo.get(i) == 0) {
                continue;
            }
            if ((int) tempExp.get(i) > 1) {
                if ((int) tempCo.get(i) == 1) {
                    polyString += "x^" + tempExp.get(i);
                }
                else {
                    polyString += tempCo.get(i) + "x^" + tempExp.get(i);
                }
                if ((int) tempCo.get(i - 1) > 0) {
                    polyString += "+";
                }
            }
            if ((int) tempExp.get(i) == 1) {
                if ((int) tempCo.get(i) == 1) {
                    polyString += "x";
                }
                else {
                    polyString += tempCo.get(i) + "x";
                }
                if ((int) tempCo.get(i - 1) > 0) {
                    polyString += "+";
                }
            }
            if ((int) tempExp.get(i) == 0) {
                polyString += tempCo.get(i);
            }
        }
        polyString += tempCo.get(0);
        if(Objects.equals(polyString, "")) {
            return "0";
        }
        return polyString;
    }

    @Override
    public void clearPolynomial(char poly) {
        switch (poly)
        {
            case 'A':
                fa = false;
                coffA.clear();
                expA.clear();
                break;

            case 'B':
                fb =  false;
                coffB.clear();
                expB.clear();
                break;

            case 'C':
                fc =  false;
                coffC.clear();
                expC.clear();
                break;
            case 'R':
                fr =  false;
                coffR.clear();
                expR.clear();
                break;
        }

    }

    @Override
    public float evaluatePolynomial(char poly, float value) {
        SingleLinkedList<Integer> coff = new SingleLinkedList<>(),exp = new SingleLinkedList<>();
        switch (poly)
        {
            case 'A':

                coff = coffA;
                exp = expA;
                break;
            case 'B':
                coff = coffB;
                exp = expB;
                break;
            case 'C':
                coff = coffC;
                exp = expC;
                break;
        }
        float acc = 0;
        for(int i = 0;i<coff.size();i++)
        {
            acc += coff.get(i) * ((float) Math.pow(value,exp.get(i)));
        }
        return acc;
    }

    @Override
    public int[] add(char poly1, char poly2) {
        SingleLinkedList<Integer> coff = new SingleLinkedList<>(),exp = new SingleLinkedList<>();
        switch (poly1)
        {
            case 'A':

                coff = coffA;
                exp = expA;
                break;
            case 'B':
                coff = coffB;
                exp = expB;
                break;
            case 'C':
                coff = coffC;
                exp = expC;
                break;
        }
        SingleLinkedList<Integer> coff1 = new SingleLinkedList<>(),exp1 = new SingleLinkedList<>();
        switch (poly2)
        {
            case 'A':

                coff1 = coffA;
                exp1 = expA;
                break;
            case 'B':
                coff1 = coffB;
                exp1 = expB;
                break;
            case 'C':
                coff1 = coffC;
                exp1 = expC;
                break;
        }

        int max = Math.max(coff.size(),coff1.size());
        int min = Math.min(coff.size(),coff1.size());
        int[] r = new int[max];
        for(int i = 0;i<min;i++)
        {
            r[i] = coff.get(i) + coff1.get(i);
        }
        if(coff.size() > coff1.size()) {
            for (int i = min; i < max; i++) {
                r[i] = coff.get(i);

            }
        }
        else {
            for (int i = min; i < max; i++) {
                r[i] = coff1.get(i);
            }
        }

        for (int i = 0; i < r.length / 2; i++) {
            int t = r[i];
            r[i] = r[r.length - i - 1];
            r[r.length - i - 1] = t;
        }


        return r;
    }

    @Override
    public int[] subtract(char poly1, char poly2) {
        SingleLinkedList<Integer> coff = new SingleLinkedList<>(),exp = new SingleLinkedList<>();
        switch (poly1)
        {
            case 'A':

                coff = coffA;
                exp = expA;
                break;
            case 'B':
                coff = coffB;
                exp = expB;
                break;
            case 'C':
                coff = coffC;
                exp = expC;
                break;
        }
        SingleLinkedList<Integer> coff1 = new SingleLinkedList<>(),exp1 = new SingleLinkedList<>();
        switch (poly2)
        {
            case 'A':

                coff1 = coffA;
                exp1 = expA;
                break;
            case 'B':
                coff1 = coffB;
                exp1 = expB;
                break;
            case 'C':
                coff1 = coffC;
                exp1 = expC;
                break;
        }

        int max = Math.max(coff.size(),coff1.size());
        int min = Math.min(coff.size(),coff1.size());
        int[] r = new int[max];
        for(int i = 0;i<min;i++)
        {
            r[i] = coff.get(i) - coff1.get(i);
        }
        if(coff.size() > coff1.size()) {
            for (int i = min; i < max; i++) {
                r[i] = coff.get(i);

            }
        }
        else {
            for (int i = min; i < max; i++) {
                r[i] = coff1.get(i) *-1;
            }
        }
        for (int i = 0; i < r.length / 2; i++) {
            int t = r[i];
            r[i] = r[r.length - i - 1];
            r[r.length - i - 1] = t;
        }

        return r;
    }

    @Override
    public int[] multiply(char poly1, char poly2) {
        SingleLinkedList<Integer> coff = new SingleLinkedList<>(),exp = new SingleLinkedList<>();
        switch (poly1)
        {
            case 'A':

                coff = coffA;
                exp = expA;
                break;
            case 'B':
                coff = coffB;
                exp = expB;
                break;
            case 'C':
                coff = coffC;
                exp = expC;
                break;
        }
        SingleLinkedList<Integer> coff1 = new SingleLinkedList<>(),exp1 = new SingleLinkedList<>();
        switch (poly2)
        {
            case 'A':

                coff1 = coffA;
                exp1 = expA;
                break;
            case 'B':
                coff1 = coffB;
                exp1 = expB;
                break;
            case 'C':
                coff1 = coffC;
                exp1 = expC;
                break;
        }
        int[] r = new int[coff1.size() + coff.size()-1];


        for(int i = 0;i<coff.size();i++) {
            for(int j = 0;j<coff1.size();j++)
            {
                r[i +j] += coff.get(i) * coff1.get(j);
            }
        }
        for(int i = 0; i < r.length / 2; i++) {
            int temp = r[i];
            r[i] = r[r.length - i - 1];
            r[r.length - i - 1] = temp;
        }


        return r;
    }
    public boolean valid(char poly) {
        switch (poly){
            case 'A':
                return fa;

            case 'B':
                return fb;

            case 'C':
                return fc;

        }
        return false;

    }

    public int[] scan(String st) {

        String[] s = st.split(",");
        int[] terms = new int[s.length];
        if (!(s.length == 1 && s[0].isEmpty())) {
            int exp = s.length - 1;
            for (int i = 0; i < s.length; i++) {
                terms[i] = Integer.parseInt(s[i]);

            }
            return terms;
        }
        else
            return null;
    }

    public static void main(String[] args) {
        int[] termsA = new int[100];
        int[] termsB = new int[100];
        int[] termsC = new int[100];
        char poly1, poly2, poly3;
        char res = 'R';
        Polynomial polynomial = new Polynomial();
        Scanner sc = new Scanner(System.in);
        String st;
        String op = sc.nextLine();
        if (!Objects.equals(op, "set")) {
            System.out.println("Error");
            return;
        }
        poly1 = sc.nextLine().charAt(0);
        switch (poly1) {
            case 'A':
                st = sc.nextLine().replaceAll("[\\[\\]]", "");
                termsA = polynomial.scan(st);
                if(termsA == null) {
                    System.out.println("Error");
                    return;
                }
                else {
                    polynomial.fa = true;
                    polynomial.setPolynomial(poly1, termsA);
                }
                break;
            case 'B':
                st = sc.nextLine().replaceAll("[\\[\\]]", "");
                termsB = polynomial.scan(st);
                if(termsB == null) {
                    System.out.println("Error");
                    return;
                }
                else {
                    polynomial.fb = true;
                    polynomial.setPolynomial(poly1, termsB);
                }
                break;
            case 'C':
                st = sc.nextLine().replaceAll("[\\[\\]]", "");
                termsC = polynomial.scan(st);
                if(termsC == null) {
                    System.out.println("Error");
                    return;
                }
                else {
                    polynomial.fc = true;
                    polynomial.setPolynomial(poly1, termsC);
                }
                break;

            default:
                System.out.println("Error");
                return;
        }

        while (true)
        {
            if(!(sc.hasNextLine()))
            {
                return;
            }
            op = sc.nextLine();
            if(op.equals("set"))
            {
                poly1 = sc.nextLine().charAt(0);
                switch (poly1) {
                    case 'A':
                        st = sc.nextLine().replaceAll("[\\[\\]]", "");
                        termsA = polynomial.scan(st);
                        if(termsA == null) {
                            System.out.println("Error");
                            return;
                        }
                        else {
                            polynomial.fa = true;
                            polynomial.setPolynomial(poly1, termsA);
                        }
                        break;
                    case 'B':
                        st = sc.nextLine().replaceAll("[\\[\\]]", "");
                        termsB = polynomial.scan(st);
                        if(termsB == null) {
                            System.out.println("Error");
                            return;
                        }
                        else {
                            polynomial.fb = true;
                            polynomial.setPolynomial(poly1, termsB);
                        }
                        break;
                    case 'C':
                        st = sc.nextLine().replaceAll("[\\[\\]]", "");
                        termsC = polynomial.scan(st);
                        if(termsC == null) {
                            System.out.println("Error");
                            return;
                        }
                        else {
                            polynomial.fc = true;
                            polynomial.setPolynomial(poly1, termsC);
                        }
                        break;

                    default:
                        System.out.println("Error");
                        return;
                }


            }
            else if(op.equals("print"))
            {
                poly2 = sc.nextLine().charAt(0);
                if(polynomial.valid(poly2))
                {
                    System.out.println(polynomial.print(poly2));

                }
                else {
                    System.out.println("Error");
                    return;
                }

            }
            else if (Objects.equals(op, "add")) {
                poly2 = sc.nextLine().charAt(0);
                poly3 = sc.nextLine().charAt(0);
                if (!(polynomial.valid(poly2) && polynomial.valid(poly3))) {
                    System.out.println("Error");
                    break;
                }
                else {
                    polynomial.setPolynomial(res, polynomial.add(poly2, poly3));
                    System.out.println(polynomial.print(res));
                }
            }
            else if (Objects.equals(op, "sub")) {
                poly2 = sc.nextLine().charAt(0);
                poly3 = sc.nextLine().charAt(0);
                if (!(polynomial.valid(poly2) && polynomial.valid(poly3))) {
                    System.out.println("Error");
                    break;
                }
                else {
                    polynomial.setPolynomial(res, polynomial.subtract(poly2, poly3));
                    System.out.println(polynomial.print(res));
                }
            }
            else if (Objects.equals(op, "mult")) {
                poly2 = sc.nextLine().charAt(0);
                poly3 = sc.nextLine().charAt(0);
                if (!(polynomial.valid(poly2) && polynomial.valid(poly3))) {
                    System.out.println("Error");
                    break;
                }
                else {
                    polynomial.setPolynomial(res, polynomial.multiply(poly2, poly3));
                    System.out.println(polynomial.print(res));
                }
            }
            else if (Objects.equals(op, "clear")) {
                poly2 = sc.nextLine().charAt(0);
                if (!polynomial.valid(poly2)) {
                    System.out.println("Error");
                    break;
                }
                else {
                    polynomial.clearPolynomial(poly2);
                    System.out.println("[]");
                }
            }
            else if (Objects.equals(op, "eval")) {
                poly2 = sc.nextLine().charAt(0);
                float value = sc.nextFloat();
                if (!polynomial.valid(poly2)) {
                    System.out.println("Error");
                    break;
                }
                else {
                    float ans = polynomial.evaluatePolynomial(poly2, value);
                    if(ans == (int) ans){
                        System.out.println((int)ans);
                    }
                    else{
                        System.out.println(ans);
                        break;
                    }
                }
            }
            else {
                System.out.println("Error");
                break;
            }
        }

    }


}