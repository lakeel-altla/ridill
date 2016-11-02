package com.lakeel.altla.ridill.pool;

import com.lakeel.altla.ridill.Matrix;

/**
 * Defines the pool that manages Matrix instances per thread.
 */
public final class MatrixPool {

    private static final ThreadLocal<Pool<Matrix>> THREAD_LOCAL = new ThreadLocal<Pool<Matrix>>() {
        @Override
        protected Pool<Matrix> initialValue() {
            return new Pool<>(new Pool.Factory<Matrix>() {
                @Override
                public Matrix create() {
                    return new Matrix();
                }
            }, new Pool.Recycler<Matrix>() {
                @Override
                public void recycle(Matrix object) {
                    object.asZero();
                }
            });
        }
    };

    private MatrixPool() {
    }

    public static Pool<Matrix> getPool() {
        return THREAD_LOCAL.get();
    }

    public static Pool.Holder<Matrix> get() {
        return getPool().get();
    }
}
