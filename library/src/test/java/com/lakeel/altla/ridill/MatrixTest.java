package com.lakeel.altla.ridill;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public final class MatrixTest {

    @Test
    public void constructor() {
        Matrix matrix = new Matrix();

        assertEquals(0, matrix.m11, 0);
        assertEquals(0, matrix.m21, 0);
        assertEquals(0, matrix.m31, 0);
        assertEquals(0, matrix.m41, 0);

        assertEquals(0, matrix.m12, 0);
        assertEquals(0, matrix.m22, 0);
        assertEquals(0, matrix.m32, 0);
        assertEquals(0, matrix.m42, 0);

        assertEquals(0, matrix.m13, 0);
        assertEquals(0, matrix.m23, 0);
        assertEquals(0, matrix.m33, 0);
        assertEquals(0, matrix.m43, 0);

        assertEquals(0, matrix.m14, 0);
        assertEquals(0, matrix.m24, 0);
        assertEquals(0, matrix.m34, 0);
        assertEquals(0, matrix.m44, 0);
    }

    @Test
    public void constructorFloat16() {
        Matrix matrix = new Matrix(11, 12, 13, 14,
                                   21, 22, 23, 24,
                                   31, 32, 33, 34,
                                   41, 42, 43, 44);

        assertEquals(11, matrix.m11, 0);
        assertEquals(12, matrix.m12, 0);
        assertEquals(13, matrix.m13, 0);
        assertEquals(14, matrix.m14, 0);

        assertEquals(21, matrix.m21, 0);
        assertEquals(22, matrix.m22, 0);
        assertEquals(23, matrix.m23, 0);
        assertEquals(24, matrix.m24, 0);

        assertEquals(31, matrix.m31, 0);
        assertEquals(32, matrix.m32, 0);
        assertEquals(33, matrix.m33, 0);
        assertEquals(34, matrix.m34, 0);

        assertEquals(41, matrix.m41, 0);
        assertEquals(42, matrix.m42, 0);
        assertEquals(43, matrix.m43, 0);
        assertEquals(44, matrix.m44, 0);
    }

    @Test
    public void createIdentity() {
        Matrix expected = new Matrix(1, 0, 0, 0,
                                     0, 1, 0, 0,
                                     0, 0, 1, 0,
                                     0, 0, 0, 1);
        Matrix result = Matrix.createIdentity();

        assertEquals(expected, result);
    }

    @Test
    public void add() {
        Matrix left = new Matrix(1, 2, 3, 4,
                                 5, 6, 7, 8,
                                 9, 10, 11, 12,
                                 13, 14, 15, 16);
        Matrix right = new Matrix(1, 2, 3, 4,
                                  5, 6, 7, 8,
                                  9, 10, 11, 12,
                                  13, 14, 15, 16);
        Matrix result = new Matrix();
        Matrix expected = new Matrix(2, 4, 6, 8,
                                     10, 12, 14, 16,
                                     18, 20, 22, 24,
                                     26, 28, 30, 32);

        Matrix.add(left, right, result);

        assertEquals(expected, result);
    }

    @Test
    public void addWithNull() {
        try {
            Matrix.add(null, new Matrix(), new Matrix());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }

        try {
            Matrix.add(new Matrix(), null, new Matrix());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }

        try {
            Matrix.add(new Matrix(), new Matrix(), null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void subtract() {
        Matrix left = new Matrix(1, 2, 3, 4,
                                 5, 6, 7, 8,
                                 9, 10, 11, 12,
                                 13, 14, 15, 16);
        Matrix right = new Matrix(0, 1, 2, 3,
                                  4, 5, 6, 7,
                                  8, 9, 10, 11,
                                  12, 13, 14, 15);
        Matrix result = new Matrix();
        Matrix expected = new Matrix(1, 1, 1, 1,
                                     1, 1, 1, 1,
                                     1, 1, 1, 1,
                                     1, 1, 1, 1);

        Matrix.subtract(left, right, result);

        assertEquals(expected, result);
    }

    @Test
    public void subtractWithNull() {
        try {
            Matrix.subtract(null, new Matrix(), new Matrix());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }

        try {
            Matrix.subtract(new Matrix(), null, new Matrix());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }

        try {
            Matrix.subtract(new Matrix(), new Matrix(), null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void multiplyMatrixMatrixMatrix() {
        Matrix left = new Matrix(11, 12, 13, 14,
                                 21, 22, 23, 24,
                                 31, 32, 33, 34,
                                 41, 42, 43, 44);
        Matrix right = new Matrix(11, 12, 13, 14,
                                  21, 22, 23, 24,
                                  31, 32, 33, 34,
                                  41, 42, 43, 44);
        Matrix result = new Matrix();

        Matrix.multiply(left, right, result);

        assertEquals((11 * 11) + (12 * 21) + (13 * 31) + (14 * 41), result.m11, 0);
        assertEquals((11 * 12) + (12 * 22) + (13 * 32) + (14 * 42), result.m12, 0);
        assertEquals((11 * 13) + (12 * 23) + (13 * 33) + (14 * 43), result.m13, 0);
        assertEquals((11 * 14) + (12 * 24) + (13 * 34) + (14 * 44), result.m14, 0);

        assertEquals((21 * 11) + (22 * 21) + (23 * 31) + (24 * 41), result.m21, 0);
        assertEquals((21 * 12) + (22 * 22) + (23 * 32) + (24 * 42), result.m22, 0);
        assertEquals((21 * 13) + (22 * 23) + (23 * 33) + (24 * 43), result.m23, 0);
        assertEquals((21 * 14) + (22 * 24) + (23 * 34) + (24 * 44), result.m24, 0);

        assertEquals((31 * 11) + (32 * 21) + (33 * 31) + (34 * 41), result.m31, 0);
        assertEquals((31 * 12) + (32 * 22) + (33 * 32) + (34 * 42), result.m32, 0);
        assertEquals((31 * 13) + (32 * 23) + (33 * 33) + (34 * 43), result.m33, 0);
        assertEquals((31 * 14) + (32 * 24) + (33 * 34) + (34 * 44), result.m34, 0);

        assertEquals((41 * 11) + (42 * 21) + (43 * 31) + (44 * 41), result.m41, 0);
        assertEquals((41 * 12) + (42 * 22) + (43 * 32) + (44 * 42), result.m42, 0);
        assertEquals((41 * 13) + (42 * 23) + (43 * 33) + (44 * 43), result.m43, 0);
        assertEquals((41 * 14) + (42 * 24) + (43 * 34) + (44 * 44), result.m44, 0);
    }

    @Test
    public void multiplyMatrixMatrixMatrixWithNull() {
        try {
            Matrix.multiply(null, new Matrix(), new Matrix());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }

        try {
            Matrix.multiply(new Matrix(), null, new Matrix());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }

        try {
            Matrix.multiply(new Matrix(), new Matrix(), null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void multiplyMatrixVector4Vector4() {
        Matrix left = new Matrix(11, 12, 13, 14,
                                 21, 22, 23, 24,
                                 31, 32, 33, 34,
                                 41, 42, 43, 44);
        Vector4 right = new Vector4(1, 2, 3, 4);
        Vector4 result = new Vector4();

        Matrix.multiply(left, right, result);

        assertEquals((11 * 1) + (12 * 2) + (13 * 3) + (14 * 4), result.x, 0);
        assertEquals((21 * 1) + (22 * 2) + (23 * 3) + (24 * 4), result.y, 0);
        assertEquals((31 * 1) + (32 * 2) + (33 * 3) + (34 * 4), result.z, 0);
        assertEquals((41 * 1) + (42 * 2) + (43 * 3) + (44 * 4), result.w, 0);
    }


    @Test
    public void multiplyMatrixVector4Vector4WithNull() {
        try {
            Matrix.multiply(null, new Vector4(), new Vector4());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }

        try {
            Matrix.multiply(new Matrix(), null, new Vector4());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }

        try {
            Matrix.multiply(new Matrix(), new Vector4(), null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void transpose() {
        Matrix matrix = new Matrix(11, 12, 13, 14,
                                   21, 22, 23, 24,
                                   31, 32, 33, 34,
                                   41, 42, 43, 44);
        Matrix result = new Matrix();
        Matrix expected = new Matrix(11, 21, 31, 41,
                                     12, 22, 32, 42,
                                     13, 23, 33, 43,
                                     14, 24, 34, 44);

        Matrix.transpose(matrix, result);

        assertEquals(expected, result);
    }

    @Test
    public void transposeWithNull() {
        try {
            Matrix.transpose(null, new Matrix());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }

        try {
            Matrix.transpose(new Matrix(), null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void invert() {
        //
        // Checks inv(inv(M)).
        //

        Matrix matrix = new Matrix(9, 1, 1, 1,
                                   1, 9, 1, 1,
                                   1, 1, 9, 1,
                                   1, 1, 1, 9);
        Matrix result = new Matrix();
        Matrix inverseInverse = new Matrix();
        float tolerance = 0.0001f;

        Matrix.invert(matrix, result);
        Matrix.invert(result, inverseInverse);

        assertEquals(matrix.m11, inverseInverse.m11, tolerance);
        assertEquals(matrix.m12, inverseInverse.m12, tolerance);
        assertEquals(matrix.m13, inverseInverse.m13, tolerance);
        assertEquals(matrix.m14, inverseInverse.m14, tolerance);

        assertEquals(matrix.m21, inverseInverse.m21, tolerance);
        assertEquals(matrix.m22, inverseInverse.m22, tolerance);
        assertEquals(matrix.m23, inverseInverse.m23, tolerance);
        assertEquals(matrix.m24, inverseInverse.m24, tolerance);

        assertEquals(matrix.m31, inverseInverse.m31, tolerance);
        assertEquals(matrix.m32, inverseInverse.m32, tolerance);
        assertEquals(matrix.m33, inverseInverse.m33, tolerance);
        assertEquals(matrix.m34, inverseInverse.m34, tolerance);

        assertEquals(matrix.m41, inverseInverse.m41, tolerance);
        assertEquals(matrix.m42, inverseInverse.m42, tolerance);
        assertEquals(matrix.m43, inverseInverse.m43, tolerance);
        assertEquals(matrix.m44, inverseInverse.m44, tolerance);

        //
        // Checks M * inv(M) = identity.
        //

        Matrix identity = new Matrix();
        Matrix.multiply(matrix, result, identity);

        assertEquals(1, identity.m11, tolerance);
        assertEquals(0, identity.m12, tolerance);
        assertEquals(0, identity.m13, tolerance);
        assertEquals(0, identity.m14, tolerance);

        assertEquals(0, identity.m21, tolerance);
        assertEquals(1, identity.m22, tolerance);
        assertEquals(0, identity.m23, tolerance);
        assertEquals(0, identity.m24, tolerance);

        assertEquals(0, identity.m31, tolerance);
        assertEquals(0, identity.m32, tolerance);
        assertEquals(1, identity.m33, tolerance);
        assertEquals(0, identity.m34, tolerance);

        assertEquals(0, identity.m41, tolerance);
        assertEquals(0, identity.m42, tolerance);
        assertEquals(0, identity.m43, tolerance);
        assertEquals(1, identity.m44, tolerance);

        //
        // Checks that there are no inverse for the matrix.
        //

        Matrix noInverse = new Matrix(1, 1, 1, 1,
                                      1, 1, 1, 1,
                                      1, 1, 1, 1,
                                      1, 1, 1, 1);
        Matrix noInverseResult = new Matrix();
        Matrix noInverseExpected = new Matrix();

        Matrix.invert(noInverse, noInverseResult);

        assertEquals(noInverseExpected, noInverseResult);
    }

    @Test
    public void invertWithNull() {
        try {
            Matrix.invert(null, new Matrix());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }

        try {
            Matrix.invert(new Matrix(), null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void setMatrix() {
        Matrix result = new Matrix();
        Matrix value = new Matrix(11, 12, 13, 14,
                                  21, 22, 23, 24,
                                  31, 32, 33, 34,
                                  41, 42, 43, 44);
        Matrix expected = new Matrix(11, 12, 13, 14,
                                     21, 22, 23, 24,
                                     31, 32, 33, 34,
                                     41, 42, 43, 44);

        result.set(value);

        assertEquals(expected, result);
    }

    @Test
    public void setMatrixWithNull() {
        try {
            new Matrix().set(null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void setFloat16() {
        Matrix result = new Matrix();
        Matrix expected = new Matrix(11, 12, 13, 14,
                                     21, 22, 23, 24,
                                     31, 32, 33, 34,
                                     41, 42, 43, 44);

        result.set(11, 12, 13, 14,
                   21, 22, 23, 24,
                   31, 32, 33, 34,
                   41, 42, 43, 44);

        assertEquals(expected, result);
    }

    @Test
    public void setInColumnMajorOrder() {
        Matrix matrix = new Matrix();
        matrix.setInColumnMajorOrder(new float[] {
                11, 21, 31, 41,
                12, 22, 32, 42,
                13, 23, 33, 43,
                14, 24, 34, 44
        });
        Matrix expected = new Matrix(11, 12, 13, 14,
                                     21, 22, 23, 24,
                                     31, 32, 33, 34,
                                     41, 42, 43, 44);

        assertEquals(expected, matrix);
    }

    @Test
    public void setInColumnMajorOrderWithNull() {
        try {
            new Matrix().setInColumnMajorOrder(null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void setInColumnMajorOrderWithInvalidLengthArray() {
        try {
            new Matrix().setInColumnMajorOrder(new float[0]);
            fail();
        } catch (IllegalArgumentException e) {
            // expected.
        }

        try {
            new Matrix().setInColumnMajorOrder(new float[17]);
            fail();
        } catch (IllegalArgumentException e) {
            // expected.
        }
    }

    @Test
    public void setInRowMajorOrder() {
        Matrix matrix = new Matrix();
        matrix.setInRowMajorOrder(new float[] {
                11, 12, 13, 14,
                21, 22, 23, 24,
                31, 32, 33, 34,
                41, 42, 43, 44
        });
        Matrix expected = new Matrix(11, 12, 13, 14,
                                     21, 22, 23, 24,
                                     31, 32, 33, 34,
                                     41, 42, 43, 44);

        assertEquals(expected, matrix);
    }

    @Test
    public void setInRowMajorOrderWithNull() {
        try {
            new Matrix().setInRowMajorOrder(null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void setInRowMajorOrderWithInvalidLengthArray() {
        try {
            new Matrix().setInRowMajorOrder(new float[0]);
            fail();
        } catch (IllegalArgumentException e) {
            // expected.
        }

        try {
            new Matrix().setInRowMajorOrder(new float[17]);
            fail();
        } catch (IllegalArgumentException e) {
            // expected.
        }
    }

    @Test
    public void setZero() {
        Matrix expected = new Matrix();
        Matrix result = new Matrix(9, 9, 9, 9,
                                   9, 9, 9, 9,
                                   9, 9, 9, 9,
                                   9, 9, 9, 9);

        result.setZero();

        assertEquals(expected, result);
    }

    @Test
    public void setIdentity() {
        Matrix expected = new Matrix(1, 0, 0, 0,
                                     0, 1, 0, 0,
                                     0, 0, 1, 0,
                                     0, 0, 0, 1);
        Matrix result = new Matrix(9, 9, 9, 9,
                                   9, 9, 9, 9,
                                   9, 9, 9, 9,
                                   9, 9, 9, 9);
        result.setIdentity();

        assertEquals(expected, result);
    }

    @Test
    public void toArrayInRowMajorOrder() {
        float[] expected = {
                11, 12, 13, 14,
                21, 22, 23, 24,
                31, 32, 33, 34,
                41, 42, 43, 44
        };
        float[] result = new float[16];

        Matrix matrix = new Matrix();
        matrix.setInRowMajorOrder(expected);
        matrix.toArrayInRowMajorOrder(result);

        assertArrayEquals(expected, result, 0);
    }

    @Test
    public void toArrayInRowMajorOrderWithNull() {
        try {
            new Matrix().toArrayInRowMajorOrder(null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void toArrayInRowMajorOrderWithInvalidLengthArray() {
        try {
            new Matrix().toArrayInRowMajorOrder(new float[0]);
            fail();
        } catch (IllegalArgumentException e) {
            // expected.
        }

        try {
            new Matrix().toArrayInRowMajorOrder(new float[17]);
            fail();
        } catch (IllegalArgumentException e) {
            // expected.
        }
    }

    @Test
    public void toArrayInColumnMajorOrder() {
        float[] expected = {
                11, 21, 31, 41,
                12, 22, 32, 42,
                13, 23, 33, 43,
                14, 24, 34, 44
        };
        float[] result = new float[16];

        Matrix matrix = new Matrix();
        matrix.setInColumnMajorOrder(expected);
        matrix.toArrayInColumnMajorOrder(result);

        assertArrayEquals(expected, result, 0);
    }

    @Test
    public void toArrayInColumnMajorOrderWithNull() {
        try {
            new Matrix().toArrayInColumnMajorOrder(null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void toArrayInColumnMajorOrderWithInvalidLengthArray() {
        try {
            new Matrix().toArrayInColumnMajorOrder(new float[0]);
            fail();
        } catch (IllegalArgumentException e) {
            // expected.
        }

        try {
            new Matrix().toArrayInColumnMajorOrder(new float[17]);
            fail();
        } catch (IllegalArgumentException e) {
            // expected.
        }
    }

    @Test
    public void equals() {
        Matrix matrix1 = new Matrix(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        Matrix matrix2 = new Matrix(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        Matrix matrix3 = new Matrix(9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9);

        assertTrue(matrix1.equals(matrix1));
        assertTrue(matrix1.equals(matrix2));

        assertFalse(matrix1.equals(matrix3));
        assertFalse(matrix1.equals(null));
        assertFalse(matrix1.equals(new Object()));
    }

    @Test
    public void testHashCode() {
        Matrix matrix1 = new Matrix(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        Matrix matrix2 = new Matrix(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        Matrix matrix3 = new Matrix(9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9);

        assertTrue(matrix1.hashCode() == matrix2.hashCode());
        assertFalse(matrix1.hashCode() == matrix3.hashCode());
    }

    @Test
    public void lookAt() {
        Matrix.LookAt lookAt = new Matrix.LookAt();
        Matrix result = new Matrix();
        float tolerance = 0.0001f;

        lookAt.calculate(new Vector3(0, 0, 1), new Vector3(0, 0, -1), Vector3.createUp(), result);

        assertEquals(1, result.m11, tolerance);
        assertEquals(0, result.m21, tolerance);
        assertEquals(0, result.m31, tolerance);

        assertEquals(0, result.m12, tolerance);
        assertEquals(1, result.m22, tolerance);
        assertEquals(0, result.m32, tolerance);

        assertEquals(0, result.m13, tolerance);
        assertEquals(0, result.m23, tolerance);
        assertEquals(1, result.m33, tolerance);

        assertEquals(0, result.m14, tolerance);
        assertEquals(0, result.m24, tolerance);
        assertEquals(-1, result.m34, tolerance);

        assertEquals(0, result.m41, 0);
        assertEquals(0, result.m42, 0);
        assertEquals(0, result.m43, 0);
        assertEquals(1, result.m44, 0);
    }
}
