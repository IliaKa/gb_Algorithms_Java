public class Main {
    public static void main(String[] args) {
        System.out.println(exponentiationRec(2, 10));
        System.out.println(exponentiation(2, 10));
    }

    //a^n
    static int exponentiationRec(int a, int b) {
        if (a == 0 && b == 0) {
            throw new ArithmeticException("NaN");
        } else if (a == 0) {
            return 0;
        } else if (b == 0) {
            return 1;
        } else if (a == 1 || b == 1) {
            return a;


        } else if (b % 2 == 0) {
            return exponentiationRec(a, b / 2) * exponentiationRec(a, b / 2);
        } else {
            return exponentiationRec(a, b - 1) * a;
        }
    }

    static int exponentiation(int a, int b) {
        int exp = 1;
        while (b > 0) {
            exp *= a;
            b--;
        }
        return exp;
    }

}