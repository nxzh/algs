package me.siduzy.ch01;

public class E010120 {
    /**
     *C alculate the ln to factorial of N. Easy to leak.
     * @param n n
     * @return ln(N!)
     */
    public static double ln_factorialN(int n) {
        double result = 0;
        for (int i = 1; i <=n; i++) {
            result += Math.log(i);
        }
        return result;
    }

    /**
     * Calculate the ln to factorial of N. Easy to leak.
     * @param n n
     * @return ln(N!)
     */
    public static double ln_factorialN2(int n) {
        long factorial = 1;
        for (int i = 1; i <=n; i++) {
            factorial = factorial * i;
        }
        return Math.log(factorial);
    }

    public static void main(String[] args) {
        for (int i = 1; i < 1000; ++i) {
            System.out.println("ln" + i + "! = " + ln_factorialN(i) + " vs " + ln_factorialN2(i));
        }

    }
}
