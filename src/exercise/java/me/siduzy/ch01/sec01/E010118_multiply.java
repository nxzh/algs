package me.siduzy.ch01.sec01;

public class E010118_multiply {
    // (2, 25) = (2, 0b11001) = (2*2^4 + 2*2^3 + 0 + 0 + 2*2^0) = 50
    // (3, 11) = (3, 0b1011) = (3*2^3 + 0 + 3*2^1 + 3*2^0) =  24 + 6 + 3 = 33
    public static int multiply(int a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("a and b are expected as positive numbers.");
        }
        if (b == 0) {
            return 0;
        }
        if ((b & 0b1) == 0) return multiply(a << 1, b >> 1);
        return multiply(a << 1, b >> 1) + a;
    }

    // (2, 25)  = (4, 12) * 2 = (16, 6) * 2 = (256, 3) * 2 = (65536, 1) * 256 * 2  = (65536*2, 0) * 65536 * 256 * 2 =33554432
    //          = (2, 0b11001) = 2^(2^4) * 2^(2^3) * 1 * 1 * 2^(2^0) = 65536 * 256 * 2 = 33554432
    // (3, 11)  = (3, 0b1011) = 3^(2^3) * 3^(2^1) * 3^(3^1) = 6561 * 9 * 3 =
    public static int mystery2(int a, int b) {
        if (b == 0) {
            return 1;
        }
        if ((b & 0b1) == 0) return mystery2(a * a, b / 2);
        return mystery2(a * a, b / 2) * a;
    }

    public static void testMultiply() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                System.out.println("i: " + i + ", j: " + j + " -> " + multiply(i, j));
            }
        }
    }

    public static void main(String[] args) {
//        testMultiply();
        int n = mystery2(3, 11);
        System.out.println(n);
    }
}
