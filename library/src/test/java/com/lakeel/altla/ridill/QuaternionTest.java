package com.lakeel.altla.ridill;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public final class QuaternionTest {

    @Test
    public void constructor() {
        Quaternion quaternion = new Quaternion();

        assertEquals(0, quaternion.x, 0);
        assertEquals(0, quaternion.y, 0);
        assertEquals(0, quaternion.z, 0);
        assertEquals(0, quaternion.w, 0);
    }

    @Test
    public void constructorFloatFloatFloat() {
        Quaternion quaternion = new Quaternion(1, 2, 3, 4);

        assertEquals(1, quaternion.x, 0);
        assertEquals(2, quaternion.y, 0);
        assertEquals(3, quaternion.z, 0);
        assertEquals(4, quaternion.w, 0);
    }

    @Test
    public void createFromYawPitchRoll() {
        float yaw = (float) Math.toRadians(90);
        float pitch = (float) Math.toRadians(90);
        float roll = (float) Math.toRadians(90);

        Quaternion result = new Quaternion();
        Quaternion.createFromYawPitchRoll(yaw, pitch, roll, result);

        float w = ((float) Math.cos(roll * 0.5f) * (float) Math.cos(pitch * 0.5f) * (float) Math.cos(yaw * 0.5f)) +
                  ((float) Math.sin(roll * 0.5f) * (float) Math.sin(pitch * 0.5f) * (float) Math.sin(yaw * 0.5f));
        float x = ((float) Math.cos(roll * 0.5f) * (float) Math.sin(pitch * 0.5f) * (float) Math.cos(yaw * 0.5f)) +
                  ((float) Math.sin(roll * 0.5f) * (float) Math.cos(pitch * 0.5f) * (float) Math.sin(yaw * 0.5f));
        float y = ((float) Math.cos(roll * 0.5f) * (float) Math.cos(pitch * 0.5f) * (float) Math.sin(yaw * 0.5f)) -
                  ((float) Math.sin(roll * 0.5f) * (float) Math.sin(pitch * 0.5f) * (float) Math.cos(yaw * 0.5f));
        float z = ((float) Math.sin(roll * 0.5f) * (float) Math.cos(pitch * 0.5f) * (float) Math.cos(yaw * 0.5f)) -
                  ((float) Math.cos(roll * 0.5f) * (float) Math.sin(pitch * 0.5f) * (float) Math.sin(yaw * 0.5f));
        Quaternion expected = new Quaternion(x, y, z, w);

        assertEquals(expected, result);
    }

    @Test
    public void createFromYawPitchRollWithNull() {
        try {
            Quaternion.createFromYawPitchRoll(0, 0, 0, null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void conjugateQuaternionQuaternion() {
        Quaternion source = new Quaternion(1, 2, 3, 4);
        Quaternion result = new Quaternion();
        Quaternion expected = new Quaternion(-1, -2, -3, 4);

        Quaternion.conjugate(source, result);

        assertEquals(expected, result);
    }

    @Test
    public void conjugateQuaternionQuaternionWithNull() {
        try {
            Quaternion.conjugate(null, new Quaternion());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }

        try {
            Quaternion.conjugate(new Quaternion(), null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void conjugate() {
        Quaternion quaternion = new Quaternion(1, 2, 3, 4);
        Quaternion expected = new Quaternion(-1, -2, -3, 4);

        Quaternion result = quaternion.conjugate();

        assertSame(quaternion, result);
        assertEquals(expected, quaternion);
    }

    @Test
    public void setFloatFloatFloatFloat() {
        Quaternion quaternion = new Quaternion();
        Quaternion expected = new Quaternion(1, 2, 3, 4);

        Quaternion result = quaternion.set(1, 2, 3, 4);

        assertSame(quaternion, result);
        assertEquals(expected, quaternion);
    }

    @Test
    public void setFloatArray() {
        Quaternion quaternion = new Quaternion();
        Quaternion expected = new Quaternion(1, 2, 3, 4);

        Quaternion result = quaternion.set(new float[] {
                1, 2, 3, 4
        });

        assertSame(quaternion, result);
        assertEquals(expected, quaternion);
    }

    @Test
    public void setFloatArrayWithNull() {
        try {
            new Quaternion().set(null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void setFloatArrayWithInvalidLengthArray() {
        try {
            new Quaternion().set(new float[0]);
            fail();
        } catch (IllegalArgumentException e) {
            // expected.
        }

        try {
            new Quaternion().set(new float[5]);
            fail();
        } catch (IllegalArgumentException e) {
            // expected.
        }
    }

    @Test
    public void equals() {
        Quaternion left = new Quaternion(1, 2, 3, 4);
        Quaternion right = new Quaternion(1, 2, 3, 4);

        assertTrue(left.equals(left));
        assertTrue(left.equals(right));

        assertFalse(left.equals(null));
        assertFalse(left.equals(new Object()));
    }
}
