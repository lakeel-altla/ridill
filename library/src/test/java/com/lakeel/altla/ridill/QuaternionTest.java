package com.lakeel.altla.ridill;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
        Quaternion result = new Quaternion(1, 2, 3, 4);
        Quaternion expected = new Quaternion(-1, -2, -3, 4);

        result.conjugate();

        assertEquals(expected, result);
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
