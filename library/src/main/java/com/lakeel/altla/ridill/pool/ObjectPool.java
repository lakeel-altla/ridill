package com.lakeel.altla.ridill.pool;

import com.lakeel.altla.ridill.ArgumentNullException;

import java.io.Closeable;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Defines the object pool.
 *
 * @param <T> The type of the poolable object.
 */
public class ObjectPool<T extends ObjectPool.Poolable> {

    private final Deque<T> deque = new ArrayDeque<>();

    private final Factory<T> factory;

    private int activeObjectCount;

    /**
     * Creates this instance.
     *
     * @param factory The factory that creates poolable objects.
     */
    public ObjectPool(Factory<T> factory) {
        this.factory = factory;
    }

    /**
     * Activates an object from this pool.
     *
     * @return An object from this pool.
     */
    public T activate() {
        T poolable = deque.poll();
        if (poolable == null) {
            poolable = factory.create(this);
        }

        poolable.onActivate();
        activeObjectCount++;

        return poolable;
    }

    /**
     * Passivates an object into this pool.
     *
     * @param poolable An object to be returned.
     */
    public void passivate(T poolable) {
        if (poolable == null) throw new ArgumentNullException("poolable");
        if (!poolable.isActive()) throw new IllegalArgumentException("'poolable' is already passive.");

        poolable.onPassivate();
        activeObjectCount--;

        deque.push(poolable);
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
     * Defines the poolable object.
     */
    public interface Poolable extends Closeable {

        /**
         * Returns true if this instance is active; otherwise false.
         *
         * @return true if this instance is active; otherwise false.
         */
        boolean isActive();

        /**
         * The callback method invoked when this instance become active.
         */
        void onActivate();

        /**
         * The callback method invoked when this instance become passive.
         */
        void onPassivate();
    }

    /**
     * Defines the factory class that creates the poolable object.
     *
     * @param <T> The type of the poolable object.
     */
    public interface Factory<T extends ObjectPool.Poolable> {

        /**
         * Creates a new poolable object.
         *
         * @param pool The pool that manages the new poolable object.
         * @return A new poolable object.
         */
        T create(ObjectPool<T> pool);
    }
}
