package com.lakeel.altla.ridill;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public final class Vector4Test {

    @Test
    public void constructor() {
        Vector4 vector = new Vector4();

        assertEquals(0, vector.x, 0);
        assertEquals(0, vector.y, 0);
        assertEquals(0, vector.z, 0);
        assertEquals(0, vector.w, 0);
    }

    @Test
    public void constructorFloat() {
        Vector4 vector = new Vector4(1);

        assertEquals(1, vector.x, 0);
        assertEquals(1, vector.y, 0);
        assertEquals(1, vector.z, 0);
        assertEquals(1, vector.w, 0);
    }

    @Test
    public void constructorFloatFloatFloat() {
        Vector4 vector = new Vector4(1, 2, 3, 4);

        assertEquals(1, vector.x, 0);
        assertEquals(2, vector.y, 0);
        assertEquals(3, vector.z, 0);
        assertEquals(4, vector.w, 0);
    }

    @Test
    public void add() {
        Vector4 left = new Vector4(1, 2, 3, 4);
        Vector4 right = new Vector4(5, 6, 7, 8);
        Vector4 result = new Vector4();

        Vector4.add(left, right, result);

        assertEquals(6, result.x, 0);
        assertEquals(8, result.y, 0);
        assertEquals(10, result.z, 0);
        assertEquals(12, result.w, 0);
    }

    @Test
    public void addArgumentNullException() {
        try {
            Vector4.add(null, new Vector4(), new Vector4());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }

        try {
            Vector4.add(new Vector4(), null, new Vector4());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }

        try {
            Vector4.add(new Vector4(), new Vector4(), null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void subtract() {
        Vector4 left = new Vector4(1, 2, 3, 4);
        Vector4 right = new Vector4(5, 6, 7, 8);
        Vector4 result = new Vector4();

        Vector4.subtract(left, right, result);

        assertEquals(-4, result.x, 0);
        assertEquals(-4, result.y, 0);
        assertEquals(-4, result.z, 0);
        assertEquals(-4, result.w, 0);
    }

    @Test
    public void subtractArgumentNullException() {
        try {
            Vector4.subtract(null, new Vector4(), new Vector4());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }

        try {
            Vector4.subtract(new Vector4(), null, new Vector4());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }

        try {
            Vector4.subtract(new Vector4(), new Vector4(), null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void multiplyVector4Vector4Vector4() {
        Vector4 left = new Vector4(1, 2, 3, 4);
        Vector4 right = new Vector4(5, 6, 7, 8);
        Vector4 result = new Vector4();

        Vector4.multiply(left, right, result);

        assertEquals(5, result.x, 0);
        assertEquals(12, result.y, 0);
        assertEquals(21, result.z, 0);
        assertEquals(32, result.w, 0);
    }

    @Test
    public void multiplyVector4Vector4Vector4WithNull() {
        try {
            Vector4.multiply(null, new Vector4(), new Vector4());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }

        try {
            Vector4.multiply(new Vector4(), null, new Vector4());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }

        try {
            Vector4.multiply(new Vector4(), new Vector4(), null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void multiplyVector4FloatVector4() {
        Vector4 value = new Vector4(1, 2, 3, 4);
        Vector4 result = new Vector4();

        Vector4.multiply(value, 10, result);

        assertEquals(10, result.x, 0);
        assertEquals(20, result.y, 0);
        assertEquals(30, result.z, 0);
        assertEquals(40, result.w, 0);
    }

    @Test
    public void multiplyVector4FloatVector4WithNull() {
        try {
            Vector4.multiply(null, 0, new Vector4());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }

        try {
            Vector4.multiply(new Vector4(), 0, null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void divideVector4Vector4Vector4() {
        Vector4 left = new Vector4(10);
        Vector4 right = new Vector4(1, 2, 5, 10);
        Vector4 result = new Vector4();

        Vector4.divide(left, right, result);

        assertEquals(10, result.x, 0);
        assertEquals(5, result.y, 0);
        assertEquals(2, result.z, 0);
        assertEquals(1, result.w, 0);
    }

    @Test
    public void divideVector4Vector4Vector4WithNull() {
        try {
            Vector4.divide(null, new Vector4(), new Vector4());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }

        try {
            Vector4.divide(new Vector4(), null, new Vector4());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }

        try {
            Vector4.divide(new Vector4(), new Vector4(), null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void divideVector4FloatVector4() {
        Vector4 value = new Vector4(10);
        Vector4 result = new Vector4();

        Vector4.divide(value, 2, result);

        assertEquals(5, result.x, 0);
        assertEquals(5, result.y, 0);
        assertEquals(5, result.z, 0);
        assertEquals(5, result.w, 0);
    }

    @Test
    public void divideVector4FloatVector4WithNull() {
        try {
            Vector4.divide(null, 1, new Vector4());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }

        try {
            Vector4.divide(new Vector4(), 0, null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void negate() {
        Vector4 value = new Vector4(1, 2, 3, 4);
        Vector4 result = new Vector4();

        Vector4.negate(value, result);

        assertEquals(-1, result.x, 0);
        assertEquals(-2, result.y, 0);
        assertEquals(-3, result.z, 0);
        assertEquals(-4, result.w, 0);
    }

    @Test
    public void negateWithNull() {
        try {
            Vector4.negate(null, new Vector4());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }

        try {
            Vector4.negate(new Vector4(), null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void dot() {
        Vector4 left = new Vector4(1, 2, 3, 4);
        Vector4 right = new Vector4(5, 6, 7, 8);

        float result = Vector4.dot(left, right);

        // e = (1 * 5) + (2 * 6) + (3 + 7) + (4 * 8)
        //   = 5 + 12 + 21 + 32
        //   = 70
        assertEquals(70, result, 0);
    }

    @Test
    public void dotWithNull() {
        try {
            Vector4.dot(null, new Vector4());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }

        try {
            Vector4.dot(new Vector4(), null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void distanceSquared() {
        Vector4 value1 = new Vector4(1, 2, 3, 4);
        Vector4 value2 = new Vector4(5, 7, 9, 11);

        float result = Vector4.distanceSquared(value1, value2);

        // x = 1 - 5 = -4
        // y = 2 - 7 = -5
        // z = 3 - 9 = -6
        // w = 4 - 11 = -7
        // e = (-4 * -4) + (-5 * -5) + (-6 * -6) * (-7 * -7)
        //   = 16 + 25 + 36 + 49
        //   = 126
        assertEquals(126, result, 0);
    }

    @Test
    public void distanceSquaredWithNull() {
        try {
            Vector4.distanceSquared(null, new Vector4());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }

        try {
            Vector4.distanceSquared(new Vector4(), null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void distance() {
        Vector4 value1 = new Vector4(1, 2, 3, 4);
        Vector4 value2 = new Vector4(5, 7, 9, 11);

        float result = Vector4.distance(value1, value2);

        // x = 1 - 5 = -4
        // y = 2 - 7 = -5
        // z = 3 - 9 = -6
        // w = 4 - 11 = -7
        // e = sqrt((-4 * -4) + (-5 * -5) + (-6 * -6) * (-7 * -7))
        //   = sqrt(16 + 25 + 36 + 49)
        //   = sqrt(126)
        assertEquals((float) Math.sqrt(126), result, 0);
    }

    @Test
    public void distanceWithNull() {
        try {
            Vector4.distance(null, new Vector4());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }

        try {
            Vector4.distance(new Vector4(), null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void normalizeVector4Vector4() {
        Vector4 value = new Vector4(1);
        Vector4 result = new Vector4();

        Vector4.normalize(value, result);

        // length = sqrt(4)
        // inverse = 1 / sqrt(4)
        assertEquals(1 / (float) Math.sqrt(4), result.x, 0);
        assertEquals(1 / (float) Math.sqrt(4), result.y, 0);
        assertEquals(1 / (float) Math.sqrt(4), result.z, 0);
        assertEquals(1 / (float) Math.sqrt(4), result.w, 0);
    }

    @Test
    public void normalizeWithNull() {
        try {
            Vector4.normalize(null, new Vector4());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }

        try {
            Vector4.normalize(new Vector4(), null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void lengthSquared() {
        Vector4 value = new Vector4(1);

        float result = value.lengthSquared();

        assertEquals(4, result, 0);
    }

    @Test
    public void length() {
        Vector4 value = new Vector4(1);

        float result = value.length();

        assertEquals((float) Math.sqrt(4), result, 0);
    }

    @Test
    public void normalize() {
        Vector4 vector = new Vector4(1);

        Vector4 result = vector.normalize();

        assertSame(vector, result);
        // length = sqrt(4)
        // inverse = 1 / sqrt(4)
        assertEquals(1 / (float) Math.sqrt(4), vector.x, 0);
        assertEquals(1 / (float) Math.sqrt(4), vector.y, 0);
        assertEquals(1 / (float) Math.sqrt(4), vector.z, 0);
        assertEquals(1 / (float) Math.sqrt(4), vector.w, 0);
    }

    @Test
    public void setVector4() {
        Vector4 vector = new Vector4(1);

        Vector4 result = vector.set(new Vector4(2, 3, 4, 5));

        assertSame(vector, result);
        assertEquals(2, vector.x, 0);
        assertEquals(3, vector.y, 0);
        assertEquals(4, vector.z, 0);
        assertEquals(5, vector.w, 0);
    }

    @Test
    public void setVector4WithNull() {
        Vector4 vector = new Vector4();

        try {
            vector.set((Vector4) null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void setFloatFloatFloatFloat() {
        Vector4 vector = new Vector4(1);

        Vector4 result = vector.set(2, 3, 4, 5);

        assertSame(vector, result);
        assertEquals(2, vector.x, 0);
        assertEquals(3, vector.y, 0);
        assertEquals(4, vector.z, 0);
        assertEquals(5, vector.w, 0);
    }

    @Test
    public void setFloat() {
        Vector4 vector = new Vector4(1);

        Vector4 result = vector.set(7);

        assertSame(vector, result);
        assertEquals(7, vector.x, 0);
        assertEquals(7, vector.y, 0);
        assertEquals(7, vector.z, 0);
        assertEquals(7, vector.w, 0);
    }

    @Test
    public void setFloatArray() {
        Vector4 vector = new Vector4(1);

        Vector4 result = vector.set(new float[] {
                2, 3, 4, 5
        });

        assertSame(vector, result);
        assertEquals(2, vector.x, 0);
        assertEquals(3, vector.y, 0);
        assertEquals(4, vector.z, 0);
        assertEquals(5, vector.w, 0);
    }

    @Test
    public void setFloatArrayWithNull() {
        Vector4 vector = new Vector4();

        try {
            vector.set((float[]) null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void setFloatArrayWithInvalidLengthArray() {
        Vector4 vector = new Vector4();

        try {
            vector.set(new float[0]);
            fail();
        } catch (IllegalArgumentException e) {
            // expected.
        }

        try {
            vector.set(new float[5]);
            fail();
        } catch (IllegalArgumentException e) {
            // expected.
        }
    }

    @Test
    public void asZero() {
        Vector4 vector = new Vector4(7);

        Vector4 result = vector.asZero();

        assertSame(vector, result);
        assertEquals(new Vector4(), result);
    }

    @Test
    public void asOne() {
        Vector4 vector = new Vector4(7);

        Vector4 result = vector.asOne();

        assertSame(vector, result);
        assertEquals(new Vector4(1), result);
    }

    @Test
    public void asUnitX() {
        Vector4 vector = new Vector4(7);

        Vector4 result = vector.asUnitX();

        assertSame(vector, result);
        assertEquals(new Vector4(1, 0, 0, 0), result);
    }

    @Test
    public void asUnitY() {
        Vector4 vector = new Vector4(7);

        Vector4 result = vector.asUnitY();

        assertSame(vector, result);
        assertEquals(new Vector4(0, 1, 0, 0), result);
    }

    @Test
    public void asUnitZ() {
        Vector4 vector = new Vector4(7);

        Vector4 result = vector.asUnitZ();

        assertSame(vector, result);
        assertEquals(new Vector4(0, 0, 1, 0), result);
    }

    @Test
    public void asUnitW() {
        Vector4 vector = new Vector4(7);

        Vector4 result = vector.asUnitW();

        assertSame(vector, result);
        assertEquals(new Vector4(0, 0, 0, 1), result);
    }

    @Test
    public void toArrayFloatArray() {
        Vector4 vector = new Vector4(1, 2, 3, 4);
        float[] result = new float[4];

        vector.toArray(result);

        assertEquals(1, result[0], 0);
        assertEquals(2, result[1], 0);
        assertEquals(3, result[2], 0);
        assertEquals(4, result[3], 0);
    }

    @Test
    public void toArrayFloatArrayWithNull() {
        try {
            new Vector4().toArray(null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void toArrayFloatArrayWithInvalidLengthArray() {
        try {
            new Vector4().toArray(new float[0]);
        } catch (IllegalArgumentException e) {
            // expected.
        }

        try {
            new Vector4().toArray(new float[5]);
        } catch (IllegalArgumentException e) {
            // expected.
        }
    }

    @Test
    public void equals() {
        Vector4 left = new Vector4(1, 2, 3, 4);
        Vector4 right = new Vector4(1, 2, 3, 4);

        assertTrue(left.equals(left));
        assertTrue(left.equals(right));

        assertFalse(left.equals(null));
        assertFalse(left.equals(new Object()));
    }
}
