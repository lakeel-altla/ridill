package com.lakeel.altla.ridill.pool;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public final class MatrixPoolTest {

    @Test
    public void getPool() {
        assertNotNull(MatrixPool.getPool());
    }

    @Test
    public void get() {
        assertNotNull(MatrixPool.get());
    }
}
