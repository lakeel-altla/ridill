package com.lakeel.altla.ridill.pool;

import com.lakeel.altla.ridill.Matrix;

public final class MatrixPool extends ObjectPool<Matrix> {

    private static final ThreadLocal<MatrixPool> THREAD_LOCAL = new ThreadLocal<MatrixPool>() {
        @Override
        protected MatrixPool initialValue() {
            return new MatrixPool();
        }
    };

    private MatrixPool() {
        super(new Factory<Matrix>() {
            @Override
            public Matrix create() {
                return new Matrix();
            }

            @Override
            public void activate(Matrix object) {
                object.asZero();
            }

            @Override
            public void passivate(Matrix object) {
            }
        });
    }

    public static MatrixPool getInstance() {
        return THREAD_LOCAL.get();
    }
}
