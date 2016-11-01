package com.lakeel.altla.ridill.pool;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public final class PoolableMatrixTest {

    @Test
    public void test() {
        PoolableMatrix matrix = PoolableMatrix.get();

        assertTrue(matrix.isActive());
        assertEquals(0, matrix.m11, 0);
        assertEquals(0, matrix.m12, 0);
        assertEquals(0, matrix.m13, 0);
        assertEquals(0, matrix.m14, 0);
        assertEquals(0, matrix.m21, 0);
        assertEquals(0, matrix.m22, 0);
        assertEquals(0, matrix.m23, 0);
        assertEquals(0, matrix.m24, 0);
        assertEquals(0, matrix.m31, 0);
        assertEquals(0, matrix.m32, 0);
        assertEquals(0, matrix.m33, 0);
        assertEquals(0, matrix.m34, 0);
        assertEquals(0, matrix.m41, 0);
        assertEquals(0, matrix.m42, 0);
        assertEquals(0, matrix.m43, 0);
        assertEquals(0, matrix.m44, 0);
        assertEquals(1, PoolableMatrix.getPool().getActiveObjectCount());
        assertEquals(0, PoolableMatrix.getPool().getPassiveObjectCount());

        matrix.set(11, 12, 13, 14,
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

        matrix.close();

        assertFalse(matrix.isActive());
        assertEquals(0, matrix.m11, 0);
        assertEquals(0, matrix.m12, 0);
        assertEquals(0, matrix.m13, 0);
        assertEquals(0, matrix.m14, 0);
        assertEquals(0, matrix.m21, 0);
        assertEquals(0, matrix.m22, 0);
        assertEquals(0, matrix.m23, 0);
        assertEquals(0, matrix.m24, 0);
        assertEquals(0, matrix.m31, 0);
        assertEquals(0, matrix.m32, 0);
        assertEquals(0, matrix.m33, 0);
        assertEquals(0, matrix.m34, 0);
        assertEquals(0, matrix.m41, 0);
        assertEquals(0, matrix.m42, 0);
        assertEquals(0, matrix.m43, 0);
        assertEquals(0, matrix.m44, 0);
        assertEquals(0, PoolableMatrix.getPool().getActiveObjectCount());
        assertEquals(1, PoolableMatrix.getPool().getPassiveObjectCount());
    }
}
