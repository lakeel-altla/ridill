package com.lakeel.altla.ridill.pool;

import com.lakeel.altla.ridill.ArgumentNullException;

import java.util.ArrayDeque;
import java.util.Deque;

public final class Pool<T> {

    private final Factory<T> factory;

    private final Recycler<T> recycler;

    private final Deque<Holder<T>> deque = new ArrayDeque<>();

    private int activeObjectCount;

    public Pool(Factory<T> factory, Recycler<T> recycler) {
        if (factory == null) throw new ArgumentNullException("factory");
        if (recycler == null) throw new ArgumentNullException("recycler");

        this.factory = factory;
        this.recycler = recycler;
    }

    public Holder<T> get() {
        Holder<T> holder = deque.poll();
        if (holder == null) {
            T object = factory.create();
            if (object == null) throw new RecyclerException("The recycler must not return null.");

            holder = new Holder<>(this, object);
        }

        holder.active = true;
        activeObjectCount++;

        return holder;
    }

    public void recycle(Holder<T> holder) {
        if (holder == null) throw new ArgumentNullException("holder");

        holder.active = false;
        recycler.recycle(holder.get());
        deque.push(holder);
        activeObjectCount--;
    }

    public int getActiveObjectCount() {
        return activeObjectCount;
    }

    public int getPassiveObjectCount() {
        return deque.size();
    }

    public static final class Holder<T> implements AutoCloseable {

        private final Pool<T> pool;

        private final T object;

        private boolean active;

        Holder(Pool<T> pool, T object) {
            this.pool = pool;
            this.object = object;
        }

        @Override
        public void close() {
            if (!active) throw new IllegalStateException("This holder is already closed.");

            pool.recycle(this);
        }

        public T get() {
            return object;
        }
    }

    public interface Factory<T> {

        T create();
    }

    public interface Recycler<T> {

        void recycle(T object);
    }

    public static final class RecyclerException extends RuntimeException {

        public RecyclerException(String message) {
            super(message);
        }
    }
}
