package com.lakeel.altla.ridill.pool;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public final class PoolableVector3Test {

    @Test
    public void test() {
        PoolableVector3 vector = PoolableVector3.get();

        assertTrue(vector.isActive());
        assertEquals(0, vector.x, 0);
        assertEquals(0, vector.y, 0);
        assertEquals(0, vector.z, 0);
        assertEquals(1, PoolableVector3.getPool().getActiveObjectCount());
        assertEquals(0, PoolableVector3.getPool().getPassiveObjectCount());

        vector.set(1, 2, 3);

        assertEquals(1, vector.x, 0);
        assertEquals(2, vector.y, 0);
        assertEquals(3, vector.z, 0);

        vector.close();

        assertFalse(vector.isActive());
        assertEquals(0, vector.x, 0);
        assertEquals(0, vector.y, 0);
        assertEquals(0, vector.z, 0);
        assertEquals(0, PoolableVector3.getPool().getActiveObjectCount());
        assertEquals(1, PoolableVector3.getPool().getPassiveObjectCount());
    }
}
