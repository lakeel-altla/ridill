package com.lakeel.altla.ridill.pool;

import com.lakeel.altla.ridill.Vector3;

/**
 * Defines the poolable Vector3.
 */
public class PoolableVector3 extends Vector3 implements ObjectPool.Poolable {

    private static final ThreadLocal<ObjectPool<PoolableVector3>> THREAD_LOCAL = new ThreadLocal<ObjectPool<PoolableVector3>>() {
        @Override
        protected ObjectPool<PoolableVector3> initialValue() {
            return new ObjectPool<>(new ObjectPool.Factory<PoolableVector3>() {
                @Override
                public PoolableVector3 create(ObjectPool<PoolableVector3> pool) {
                    return new PoolableVector3(pool);
                }
            });
        }
    };

    private final ObjectPool<PoolableVector3> pool;

    private boolean active;

    private PoolableVector3(ObjectPool<PoolableVector3> pool) {
        this.pool = pool;
    }

    /**
     * Gets the pool that manages this class's instance.
     *
     * @return The pool that manages this class's instance.
     */
    public static ObjectPool<PoolableVector3> getPool() {
        return THREAD_LOCAL.get();
    }

    /**
     * Gets the poolable matrix from the pool.
     *
     * @return The poolable matrix.
     */
    public static PoolableVector3 get() {
        return getPool().activate();
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
