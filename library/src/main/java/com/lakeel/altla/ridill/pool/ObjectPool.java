package com.lakeel.altla.ridill.pool;

import com.lakeel.altla.ridill.ArgumentNullException;

import java.util.ArrayDeque;
import java.util.Deque;

public class ObjectPool<T> {

    private final Deque<T> deque = new ArrayDeque<>();

    private final Factory<T> factory;

    public ObjectPool(Factory<T> factory) {
        this.factory = factory;
    }

    public T borrowObject() {
        T object = deque.poll();
        if (object == null) {
            object = factory.create();
        }

        factory.activate(object);

        return object;
    }

    public void returnObject(T object) {
        if (object == null) throw new ArgumentNullException("object");

        factory.passivate(object);

        deque.push(object);
    }

    public int size() {
        return deque.size();
    }

    public void clear() {
        deque.clear();
    }

    public interface Factory<T> {

        T create();

        void activate(T object);

        void passivate(T object);
    }
}
