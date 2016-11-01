package com.lakeel.altla.ridill.pool;

import java.io.Closeable;

/**
 * Defines the holder that contains the actual pooled object.
 *
 * @param <T> The actual pooled object.
 */
public final class PooledObject<T> implements Closeable {

    private final ObjectPool<T> pool;

    private final T object;

    private boolean isActive;

    PooledObject(ObjectPool<T> pool, T object) {
        this.pool = pool;
        this.object = object;
    }

    /**
     * Returns the actual pooled object.
     *
     * @return The actual pooled object.
     */
    public T get() {
        return object;
    }

    /**
     * Returns true if this is active; otherwise false.
     *
     * @return true if this is active; otherwise false.
     */
    boolean isActive() {
        return isActive;
    }

    /**
     * The callback invoked when activated.
     */
    void onActivate() {
        isActive = true;
    }

    /**
     * The callback invoked when passivated.
     */
    void onPassivate() {
        isActive = false;
    }

    /**
     * Returns this instance into the pool.
     */
    @Override
    public void close() {
        pool.passivate(this);
    }
}
