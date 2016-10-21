package com.lakeel.altla.ridill.pool;

import com.lakeel.altla.ridill.Vector3;

public final class Vector3Pool extends ObjectPool<Vector3> {

    private static final ThreadLocal<Vector3Pool> THREAD_LOCAL = new ThreadLocal<Vector3Pool>() {
        @Override
        protected Vector3Pool initialValue() {
            return new Vector3Pool();
        }
    };

    private Vector3Pool() {
        super(new ObjectPool.Factory<Vector3>() {
            @Override
            public Vector3 create() {
                return new Vector3();
            }

            @Override
            public void activate(Vector3 object) {
                object.asZero();
            }

            @Override
            public void passivate(Vector3 object) {
            }
        });
    }

    public static Vector3Pool getInstance() {
        return THREAD_LOCAL.get();
    }
}
