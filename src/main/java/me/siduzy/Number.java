package me.siduzy;

public class Number {

    /**
     * Greatest common divisor of two numbers
     *
     * @param m first number
     * @param n second number
     * @return gcd
     */
    public static int gcd(int m, int n) {
        if (n == 0) {
            return m;
        }
        int r = m % n;
        return gcd(n, r); // if m < n, then gcd(n, r) will switch the numbers
    }

    /**
     * Least common multiple of two numbers
     *
     * @param m first number
     * @param n second number
     * @return lcm
     */
    public static int lcm(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        return Math.abs(m * n) / gcd(m,n);
    }

    public static void main(String[] args) {
        int j = Number.gcd(355, 241);
        System.out.println(j);
        j = Number.lcm(10, 20);
        System.out.println(j);
    }
}
