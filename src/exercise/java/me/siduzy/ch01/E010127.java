package me.siduzy.ch01;

public class E010127 {

    private static long count = 0;

    /*
            if n = 100, k = 50:
     1st: (N-1, k, p) + (N-1, k-1, p)
     2nd: (N-2, k, p) + (N-2, k-1, p) | (N-2, k-1, p) + (N-2, k-2, p)
     3rd: (N-3, k, p) + (N-3, k-1, p) | (N-3, k-1, p) + (N-3, k-2, p) | (N-3, k-1, p) + (N-3, k-2, p) | (N-3, k-2, p) + (N-3, k-3, p)
     100th: 2 ^ (100+1)
     Nth: 2 ^ (N+1)
     */
    public static double binomial(int N, int k, double p) {
        count++;
        if (N == 0 && k == 0) return 1.0;
        if (N < 0 || k < 0) return 0.0;
        return (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
    }

    public static double binomial2(int N, int k, double p) {
        Double[][] cache = new Double[N + 1][k + 1];
        return binomialWithCache(N, k, p, cache);
    }

    public static double binomialWithCache(int N, int k, double p, Double[][] cache) {
        count++;
        if (N == 0 && k == 0) return 1.0;
        if (N < 0 || k < 0) return 0.0;
        if (cache[N][k] == null) {
            cache[N][k] = (1.0 - p) * binomialWithCache(N - 1, k, p, cache) + p * binomialWithCache(N - 1, k - 1, p, cache);
        }
        return cache[N][k];
    }

    public static void main(String[] args) {
        System.out.println(binomial(10, 5, 0.25));
        System.out.println(count);
        count = 0;
        System.out.println("--------------------------------------------");
        System.out.println(binomial2(10, 5, 0.25));
        System.out.println(count);
    }
}
