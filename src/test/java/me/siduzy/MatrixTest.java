package me.siduzy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatrixTest {

    @Test
    public void testDot() {
        double[] x = new double[]{1, 2, 3};
        double[] y = new double[]{7, 9, 11};
        Assertions.assertEquals(58, Matrix.dot(x, y));
    }

    @Test
    public void testDotIfNull() {
        double[] x = new double[]{1, 2, 3};
        double[] y = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> Matrix.dot(x, y));
    }

    @Test
    public void testDot_whenLengthNotSame_thenExpectException() {
        double[] x = new double[]{1, 2, 3};
        double[] y = new double[]{1, 2, 3, 4};
        Assertions.assertThrows(IllegalArgumentException.class, () -> Matrix.dot(x, y));
    }

    @Test
    public void testMult() {
        double[][] a = new double[][]{
                {1, 2, 3},
                {4, 5, 6}
        };
        double[][] b = new double[][]{
                {7, 8},
                {9, 10},
                {11, 12}
        };
        double[][] expected = new double[][]{
                {58, 64},
                {139, 154}
        };
        double[][] actual = Matrix.mult(a, b);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testMult_whenNotAbleToMult() {
        double[][] a = new double[][]{
                {1, 2, 3},
                {4, 5, 6}
        };
        double[][] b = new double[][]{
                {7, 8},
                {9, 10}
        };

        Assertions.assertThrows(IllegalArgumentException.class, () -> Matrix.mult(a, b));
    }

    @Test
    public void testTranspose() {
        double[][] a = new double[][]{
                {1, 2, 3},
                {4, 5, 6}
        };
        double[][] expected = new double[][]{
                {1, 4},
                {2, 5},
                {3, 6}
        };
        Assertions.assertArrayEquals(expected, Matrix.transpose(a));
    }

    @Test
    public void testTranspose_withInvalidInput_thenExpectedException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Matrix.transpose(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Matrix.transpose(new double[][]{

        }));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Matrix.transpose(new double[][]{
                {}, {}
        }));
    }

    @Test
    public void testMultWithVector() {
        double[][] a = new double[][]{
                {1, 2},
                {3, 4}
        };
        double[] x = {1, 2};
        double[] expect = {5, 11};
        Assertions.assertArrayEquals(expect, Matrix.mult(a, x));
    }

    @Test
    public void testMultWithVector2() {
        double[] y = new double[]{1, 2};
        double[][] a = new double[][]{
                {1, 2},
                {3, 4}
        };
        double[] expect = {7, 10};
        Assertions.assertArrayEquals(expect, Matrix.mult(y, a));
    }
}
