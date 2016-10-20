package com.lakeel.altla.ridill;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public final class Vector3Test {

    @Test
    public void constructor() {
        Vector3 vector = new Vector3();

        assertEquals(0, vector.x, 0);
        assertEquals(0, vector.y, 0);
        assertEquals(0, vector.z, 0);
    }

    @Test
    public void constructorFloat() {
        Vector3 vector = new Vector3(1);

        assertEquals(1, vector.x, 0);
        assertEquals(1, vector.y, 0);
        assertEquals(1, vector.z, 0);
    }

    @Test
    public void constructorFloatFloatFloat() {
        Vector3 vector = new Vector3(1, 2, 3);

        assertEquals(1, vector.x, 0);
        assertEquals(2, vector.y, 0);
        assertEquals(3, vector.z, 0);
    }

    @Test
    public void createOne() {
        Vector3 vector = Vector3.createOne();

        assertEquals(1, vector.x, 0);
        assertEquals(1, vector.y, 0);
        assertEquals(1, vector.z, 0);
    }

    @Test
    public void createUnitX() {
        Vector3 vector = Vector3.createUnitX();

        assertEquals(1, vector.x, 0);
        assertEquals(0, vector.y, 0);
        assertEquals(0, vector.z, 0);
    }

    @Test
    public void createUnitY() {
        Vector3 vector = Vector3.createUnitY();

        assertEquals(0, vector.x, 0);
        assertEquals(1, vector.y, 0);
        assertEquals(0, vector.z, 0);
    }

    @Test
    public void createUnitZ() {
        Vector3 vector = Vector3.createUnitZ();

        assertEquals(0, vector.x, 0);
        assertEquals(0, vector.y, 0);
        assertEquals(1, vector.z, 0);
    }

    @Test
    public void createUp() {
        Vector3 vector = Vector3.createUp();

        assertEquals(0, vector.x, 0);
        assertEquals(1, vector.y, 0);
        assertEquals(0, vector.z, 0);
    }

    @Test
    public void createDown() {
        Vector3 vector = Vector3.createDown();

        assertEquals(0, vector.x, 0);
        assertEquals(-1, vector.y, 0);
        assertEquals(0, vector.z, 0);
    }

    @Test
    public void createLeft() {
        Vector3 vector = Vector3.createLeft();

        assertEquals(-1, vector.x, 0);
        assertEquals(0, vector.y, 0);
        assertEquals(0, vector.z, 0);
    }

    @Test
    public void createRight() {
        Vector3 vector = Vector3.createRight();

        assertEquals(1, vector.x, 0);
        assertEquals(0, vector.y, 0);
        assertEquals(0, vector.z, 0);
    }

    @Test
    public void createForward() {
        Vector3 vector = Vector3.createForward();

        assertEquals(0, vector.x, 0);
        assertEquals(0, vector.y, 0);
        assertEquals(-1, vector.z, 0);
    }

    @Test
    public void createBackward() {
        Vector3 vector = Vector3.createBackward();

        assertEquals(0, vector.x, 0);
        assertEquals(0, vector.y, 0);
        assertEquals(1, vector.z, 0);
    }

    @Test
    public void add() {
        Vector3 left = new Vector3(1, 2, 3);
        Vector3 right = new Vector3(4, 5, 6);
        Vector3 result = new Vector3();

        Vector3.add(left, right, result);

        assertEquals(1, left.x, 0);
        assertEquals(2, left.y, 0);
        assertEquals(3, left.z, 0);

        assertEquals(4, right.x, 0);
        assertEquals(5, right.y, 0);
        assertEquals(6, right.z, 0);

        assertEquals(5, result.x, 0);
        assertEquals(7, result.y, 0);
        assertEquals(9, result.z, 0);
    }

    @Test
    public void addArgumentNullException() {
        try {
            Vector3.add(null, new Vector3(), new Vector3());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }

        try {
            Vector3.add(new Vector3(), null, new Vector3());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }

        try {
            Vector3.add(new Vector3(), new Vector3(), null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void subtract() {
        Vector3 left = new Vector3(1, 2, 3);
        Vector3 right = new Vector3(4, 5, 6);
        Vector3 result = new Vector3();

        Vector3.subtract(left, right, result);

        assertEquals(1, left.x, 0);
        assertEquals(2, left.y, 0);
        assertEquals(3, left.z, 0);

        assertEquals(4, right.x, 0);
        assertEquals(5, right.y, 0);
        assertEquals(6, right.z, 0);

        assertEquals(-3, result.x, 0);
        assertEquals(-3, result.y, 0);
        assertEquals(-3, result.z, 0);
    }

    @Test
    public void subtractArgumentNullException() {
        try {
            Vector3.subtract(null, new Vector3(), new Vector3());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }

        try {
            Vector3.subtract(new Vector3(), null, new Vector3());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }

        try {
            Vector3.subtract(new Vector3(), new Vector3(), null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void multiplyVector3Vector3Vector3() {
        Vector3 left = new Vector3(1, 2, 3);
        Vector3 right = new Vector3(4, 5, 6);
        Vector3 result = new Vector3();

        Vector3.multiply(left, right, result);

        assertEquals(1, left.x, 0);
        assertEquals(2, left.y, 0);
        assertEquals(3, left.z, 0);

        assertEquals(4, right.x, 0);
        assertEquals(5, right.y, 0);
        assertEquals(6, right.z, 0);

        assertEquals(4, result.x, 0);
        assertEquals(10, result.y, 0);
        assertEquals(18, result.z, 0);
    }

    @Test
    public void multiplyVector3Vector3Vector3ArgumentNullException() {
        try {
            Vector3.multiply(null, new Vector3(), new Vector3());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }

        try {
            Vector3.multiply(new Vector3(), null, new Vector3());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }

        try {
            Vector3.multiply(new Vector3(), new Vector3(), null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void multiplyVector3FloatVector3() {
        Vector3 value = new Vector3(1, 2, 3);
        Vector3 result = new Vector3();

        Vector3.multiply(value, 10, result);

        assertEquals(1, value.x, 0);
        assertEquals(2, value.y, 0);
        assertEquals(3, value.z, 0);

        assertEquals(10, result.x, 0);
        assertEquals(20, result.y, 0);
        assertEquals(30, result.z, 0);
    }

    @Test
    public void multiplyVector3FloatVector3ArgumentNullException() {
        try {
            Vector3.multiply(null, 0, new Vector3());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }

        try {
            Vector3.multiply(new Vector3(), 0, null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void divideVector3Vector3Vector3() {
        Vector3 left = new Vector3(10);
        Vector3 right = new Vector3(1, 2, 5);
        Vector3 result = new Vector3();

        Vector3.divide(left, right, result);

        assertEquals(10, left.x, 0);
        assertEquals(10, left.y, 0);
        assertEquals(10, left.z, 0);

        assertEquals(1, right.x, 0);
        assertEquals(2, right.y, 0);
        assertEquals(5, right.z, 0);

        assertEquals(10, result.x, 0);
        assertEquals(5, result.y, 0);
        assertEquals(2, result.z, 0);
    }

    @Test
    public void divideVector3Vector3Vector3ArgumentNullException() {
        try {
            Vector3.divide(null, new Vector3(), new Vector3());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }

        try {
            Vector3.divide(new Vector3(), null, new Vector3());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }

        try {
            Vector3.divide(new Vector3(), new Vector3(), null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void divideVector3FloatVector3() {
        Vector3 value = new Vector3(10);
        Vector3 result = new Vector3();

        Vector3.divide(value, 2, result);

        assertEquals(10, value.x, 0);
        assertEquals(10, value.y, 0);
        assertEquals(10, value.z, 0);

        assertEquals(5, result.x, 0);
        assertEquals(5, result.y, 0);
        assertEquals(5, result.z, 0);
    }

    @Test
    public void divideVector3FloatVector3ArgumentNullException() {
        try {
            Vector3.divide(null, 1, new Vector3());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }

        try {
            Vector3.divide(new Vector3(), 0, null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void negate() {
        Vector3 value = new Vector3(1, 2, 3);
        Vector3 result = new Vector3();

        Vector3.negate(value, result);

        assertEquals(1, value.x, 0);
        assertEquals(2, value.y, 0);
        assertEquals(3, value.z, 0);

        assertEquals(-1, result.x, 0);
        assertEquals(-2, result.y, 0);
        assertEquals(-3, result.z, 0);
    }

    @Test
    public void negateArgumentNullException() {
        try {
            Vector3.negate(null, new Vector3());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }

        try {
            Vector3.negate(new Vector3(), null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void dot() {
        Vector3 left = new Vector3(1, 2, 3);
        Vector3 right = new Vector3(4, 5, 6);

        float result = Vector3.dot(left, right);

        assertEquals(1, left.x, 0);
        assertEquals(2, left.y, 0);
        assertEquals(3, left.z, 0);

        assertEquals(4, right.x, 0);
        assertEquals(5, right.y, 0);
        assertEquals(6, right.z, 0);

        // e = (1 * 4) + (2 * 5) + (3 + 6)
        //   = 4 + 10 + 18
        //   = 32
        assertEquals(32, result, 0);
    }

    @Test
    public void dotArgumentNullException() {
        try {
            Vector3.dot(null, new Vector3());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }

        try {
            Vector3.dot(new Vector3(), null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void cross() {
        Vector3 left = new Vector3(1, 2, 3);
        Vector3 right = new Vector3(4, 5, 6);
        Vector3 result = new Vector3();

        Vector3.cross(left, right, result);

        assertEquals(1, left.x, 0);
        assertEquals(2, left.y, 0);
        assertEquals(3, left.z, 0);

        assertEquals(4, right.x, 0);
        assertEquals(5, right.y, 0);
        assertEquals(6, right.z, 0);

        // x = (2 * 6) - (3 * 5)
        //   = 12 - 15
        //   = -3
        assertEquals(-3, result.x, 0);
        // y = (3 * 4) - (1 * 6)
        //   = 12 - 6
        //   = 6
        assertEquals(6, result.y, 0);
        // y = (1 * 5) - (2 * 4)
        //   = 5 - 8
        //   = -3
        assertEquals(-3, result.z, 0);
    }

    @Test
    public void crossVector3Vector3Vector3ArgumentNullException() {
        try {
            Vector3.cross(null, new Vector3(), new Vector3());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }

        try {
            Vector3.cross(new Vector3(), null, new Vector3());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }

        try {
            Vector3.cross(new Vector3(), new Vector3(), null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void distanceSquared() {
        Vector3 value1 = new Vector3(1, 2, 3);
        Vector3 value2 = new Vector3(4, 6, 8);

        float result = Vector3.distanceSquared(value1, value2);

        assertEquals(1, value1.x, 0);
        assertEquals(2, value1.y, 0);
        assertEquals(3, value1.z, 0);

        assertEquals(4, value2.x, 0);
        assertEquals(6, value2.y, 0);
        assertEquals(8, value2.z, 0);

        // x = 1 - 4 = -3
        // y = 2 - 6 = -4
        // z = 3 - 8 = -5
        // e = (-3 * -3) + (-4 * -4) + (-5 * -5)
        //   = 9 + 16 + 25
        //   = 50
        assertEquals(50, result, 0);
    }

    @Test
    public void distanceSquaredArgumentNullException() {
        try {
            Vector3.distanceSquared(null, new Vector3());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }

        try {
            Vector3.distanceSquared(new Vector3(), null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void distance() {
        Vector3 value1 = new Vector3(1, 2, 3);
        Vector3 value2 = new Vector3(4, 6, 8);

        float result = Vector3.distance(value1, value2);

        assertEquals(1, value1.x, 0);
        assertEquals(2, value1.y, 0);
        assertEquals(3, value1.z, 0);

        assertEquals(4, value2.x, 0);
        assertEquals(6, value2.y, 0);
        assertEquals(8, value2.z, 0);

        // x = 1 - 4 = -3
        // y = 2 - 6 = -4
        // z = 3 - 8 = -5
        // e = sqrt((-3 * -3) + (-4 * -4) + (-5 * -5))
        //   = sqrt(9 + 16 + 25)
        //   = sqrt(50)
        assertEquals((float) Math.sqrt(50), result, 0);
    }

    @Test
    public void distanceArgumentNullException() {
        try {
            Vector3.distance(null, new Vector3());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }

        try {
            Vector3.distance(new Vector3(), null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void normalizeVector3Vector3() {
        Vector3 value = new Vector3(1);
        Vector3 result = new Vector3();

        Vector3.normalize(value, result);

        assertEquals(1, value.x, 0);
        assertEquals(1, value.y, 0);
        assertEquals(1, value.z, 0);

        // length = sqrt(3)
        // inverse = 1 / sqrt(3)
        assertEquals(1 / (float) Math.sqrt(3), result.x, 0);
        assertEquals(1 / (float) Math.sqrt(3), result.y, 0);
        assertEquals(1 / (float) Math.sqrt(3), result.z, 0);
    }

    @Test
    public void normalizeArgumentNullException() {
        try {
            Vector3.normalize(null, new Vector3());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }

        try {
            Vector3.normalize(new Vector3(), null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void lengthSquared() {
        Vector3 value = new Vector3(1);

        float result = value.lengthSquared();

        assertEquals(1, value.x, 0);
        assertEquals(1, value.y, 0);
        assertEquals(1, value.z, 0);

        assertEquals(3, result, 0);
    }

    @Test
    public void length() {
        Vector3 value = new Vector3(1);

        float result = value.length();

        assertEquals(1, value.x, 0);
        assertEquals(1, value.y, 0);
        assertEquals(1, value.z, 0);

        assertEquals((float) Math.sqrt(3), result, 0);
    }

    @Test
    public void normalize() {
        Vector3 value = new Vector3(1);

        value.normalize();

        // length = sqrt(3)
        // inverse = 1 / sqrt(3)
        assertEquals(1 / (float) Math.sqrt(3), value.x, 0);
        assertEquals(1 / (float) Math.sqrt(3), value.y, 0);
        assertEquals(1 / (float) Math.sqrt(3), value.z, 0);
    }

    @Test
    public void setVector3() {
        Vector3 value = new Vector3(2, 3, 4);
        Vector3 result = new Vector3(1);

        result.set(value);

        assertEquals(2, result.x, 0);
        assertEquals(3, result.y, 0);
        assertEquals(4, result.z, 0);
    }

    @Test
    public void setVector3WithNull() {
        Vector3 vector = new Vector3();

        try {
            vector.set((Vector3) null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void setFloatFloatFloat() {
        Vector3 result = new Vector3(1);

        result.set(2, 3, 4);

        assertEquals(2, result.x, 0);
        assertEquals(3, result.y, 0);
        assertEquals(4, result.z, 0);
    }

    @Test
    public void setFloatArray() {
        Vector3 result = new Vector3(1);

        result.set(new float[] {
                2, 3, 4
        });

        assertEquals(2, result.x, 0);
        assertEquals(3, result.y, 0);
        assertEquals(4, result.z, 0);
    }

    @Test
    public void setFloatArrayWithNull() {
        Vector3 vector = new Vector3();

        try {
            vector.set((float[]) null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void setFloatArrayWithInvalidLengthArray() {
        Vector3 vector = new Vector3();

        try {
            vector.set(new float[0]);
            fail();
        } catch (IllegalArgumentException e) {
            // expected.
        }

        try {
            vector.set(new float[4]);
            fail();
        } catch (IllegalArgumentException e) {
            // expected.
        }
    }

    @Test
    public void toArray() {
        Vector3 vector = new Vector3(1, 2, 3);
        float[] result = new float[3];

        vector.toArray(result);

        assertEquals(1, result[0], 0);
        assertEquals(2, result[1], 0);
        assertEquals(3, result[2], 0);
    }

    @Test
    public void toArrayWithNull() {
        Vector3 vector = new Vector3();

        try {
            vector.toArray(null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void toArrayWithInvalidLengthArray() {
        Vector3 vector = new Vector3();

        try {
            vector.toArray(new float[] {});
            fail();
        } catch (IllegalArgumentException e) {
            //expected.
        }

        try {
            vector.toArray(new float[4]);
            fail();
        } catch (IllegalArgumentException e) {
            //expected.
        }
    }

    @Test
    public void equals() {
        Vector3 left = new Vector3(1, 2, 3);
        Vector3 right = new Vector3(1, 2, 3);

        assertTrue(left.equals(left));
        assertTrue(left.equals(right));

        assertFalse(left.equals(null));
        assertFalse(left.equals(new Object()));
    }
}
