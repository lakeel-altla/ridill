package com.lakeel.altla.ridill.pool;

import com.lakeel.altla.ridill.ArgumentNullException;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Defines the object pool.
 *
 * @param <T> The type of the pooled object.
 */
public class ObjectPool<T> {

    private final Deque<PooledObject<T>> deque = new ArrayDeque<>();

    private final Factory<T> factory;

    private int activeObjectCount;

    /**
     * Creates this instance.
     *
     * @param factory The factory that creates pooled objects.
     */
    public ObjectPool(Factory<T> factory) {
        this.factory = factory;
    }

    /**
     * Activates an object from this pool.
     *
     * @return An object from this pool.
     */
    public PooledObject<T> activate() {
        PooledObject<T> pooledObject = deque.poll();
        if (pooledObject == null) {
            pooledObject = new PooledObject<>(this, factory.create());
        }

        factory.activate(pooledObject.get());
        pooledObject.onActivate();
        activeObjectCount++;

        return pooledObject;
    }

    /**
     * Passivates an object into this pool.
     *
     * @param pooledObject An object to be returned.
     */
    public void passivate(PooledObject<T> pooledObject) {
        if (pooledObject == null) throw new ArgumentNullException("pooledObject");
        if (!pooledObject.isActive()) throw new IllegalArgumentException("PooledObject is already passive.");

        factory.passivate(pooledObject.get());
        pooledObject.onPassivate();
        activeObjectCount--;

        deque.push(pooledObject);
    }

    /**
     * Returns the number of active objects.
     *
     * @return The number of active objects.
     */
    public int getActiveObjectCount() {
        return activeObjectCount;
    }

    /**
     * Returns the number of passive objects.
     *
     * @return The number of passive objects.
     */
    public int getPassiveObjectCount() {
        return deque.size();
    }

    /**
     * Removes all passive objects in this pool.
     */
    public void clear() {
        deque.clear();
    }

    /**
     * Defines the factory class that creates the pooled object.
     *
     * @param <T> The type of the pooled object.
     */
    public interface Factory<T> {

        /**
         * Creates a new pooled object.
         *
         * @return A new pooled object.
         */
        T create();

        /**
         * Activates the passive object.
         *
         * @param object The object to be active.
         */
        void activate(T object);

        /**
         * Passivates the active object.
         *
         * @param object The object to be passive.
         */
        void passivate(T object);
    }
}
