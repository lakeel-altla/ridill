package com.lakeel.altla.ridill.pool;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public final class Vector3PoolTest {

    @Test
    public void getPool() {
        assertNotNull(Vector3Pool.getPool());
    }

    @Test
    public void get() {
        assertNotNull(Vector3Pool.get());
    }
}
