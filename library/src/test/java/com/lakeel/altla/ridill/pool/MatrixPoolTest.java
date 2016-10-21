package com.lakeel.altla.ridill.pool;

import com.lakeel.altla.ridill.Matrix;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public final class MatrixPoolTest {

    @Test
    public void getInstance() {
        MatrixPool pool = MatrixPool.getInstance();

        assertEquals(Matrix.class, pool.borrowObject().getClass());
    }
}
