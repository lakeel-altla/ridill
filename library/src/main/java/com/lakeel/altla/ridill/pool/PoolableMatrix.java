package com.lakeel.altla.ridill.pool;

import com.lakeel.altla.pool.ObjectPool;
import com.lakeel.altla.ridill.Matrix;

/**
 * Defines the poolable Matrix.
 */
public class PoolableMatrix extends Matrix implements ObjectPool.Poolable {

    private static final ThreadLocal<ObjectPool<PoolableMatrix>> THREAD_LOCAL =
            new ThreadLocal<ObjectPool<PoolableMatrix>>() {
                @Override
                protected ObjectPool<PoolableMatrix> initialValue() {
                    return new ObjectPool<>(new ObjectPool.Factory<PoolableMatrix>() {
                        @Override
                        public PoolableMatrix create(ObjectPool<PoolableMatrix> pool) {
                            return new PoolableMatrix(pool);
                        }
                    });
                }
            };

    private final ObjectPool<PoolableMatrix> pool;

    private boolean active;

    private PoolableMatrix(ObjectPool<PoolableMatrix> pool) {
        this.pool = pool;
    }

    /**
     * Gets the pool that manages this class's instance.
     *
     * @return The pool that manages this class's instance.
     */
    public static ObjectPool<PoolableMatrix> getPool() {
        return THREAD_LOCAL.get();
    }

    /**
     * Gets the poolable matrix from the pool.
     *
     * @return The poolable matrix.
     */
    public static PoolableMatrix get() {
        ObjectPool<PoolableMatrix> pool = THREAD_LOCAL.get();
        return pool.activate();
    }

    /**
     * Returns true if this instance is active; otherwise false.
     *
     * @return true if this instance is active; otherwise false.
     */
    @Override
    public boolean isActive() {
        return active;
    }

    /**
     * Activates this instance.
     */
    @Override
    public void onActivate() {
        active = true;
    }

    /**
     * Passivates this instance and sets zero into all components.
     */
    @Override
    public void onPassivate() {
        asZero();
        active = false;
    }

    /**
     * Returns this instance into the pool.
     */
    @Override
    public void close() {
        pool.passivate(this);
    }
}
