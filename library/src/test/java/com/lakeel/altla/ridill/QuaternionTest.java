package com.lakeel.altla.ridill;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
    public void equals() {
        Quaternion left = new Quaternion(1, 2, 3, 4);
        Quaternion right = new Quaternion(1, 2, 3, 4);

        assertTrue(left.equals(left));
        assertTrue(left.equals(right));

        assertFalse(left.equals(null));
        assertFalse(left.equals(new Object()));
    }
}
