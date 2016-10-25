package com.lakeel.altla.ridill.pool;

import com.lakeel.altla.ridill.Vector3;

import org.junit.Assert;
import org.junit.Test;

public final class Vector3PoolTest {

    @Test
    public void getInstance() {
        Vector3Pool pool = Vector3Pool.getInstance();

        Assert.assertEquals(Vector3.class, pool.activate().getClass());
    }
}
