package com.lakeel.altla.ridill.pool;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public final class ObjectPoolTest {

    @Test
    public void scenario() {
        ObjectPool<MockObject> pool = new ObjectPool<>(new MockFactory());

        MockObject object1 = pool.borrowObject();
        assertFalse(object1.isReleased);

        MockObject object2 = pool.borrowObject();
        assertFalse(object2.isReleased);

        MockObject object3 = pool.borrowObject();
        assertFalse(object3.isReleased);

        pool.returnObject(object1);
        assertTrue(object1.isReleased);
        assertEquals(1, pool.size());

        pool.returnObject(object2);
        assertTrue(object2.isReleased);
        assertEquals(2, pool.size());

        pool.returnObject(object3);
        assertTrue(object3.isReleased);
        assertEquals(3, pool.size());

        pool.clear();
        assertEquals(0, pool.size());
    }

    public final class MockFactory implements ObjectPool.Factory<MockObject> {

        private int counter;

        @Override
        public MockObject create() {
            return new MockObject(counter++);
        }

        @Override
        public void activate(MockObject object) {
            object.isReleased = false;
        }

        @Override
        public void passivate(MockObject object) {
            object.isReleased = true;
        }
    }

    private final class MockObject {

        private final int number;

        private boolean isReleased;

        MockObject(int number) {
            this.number = number;
        }
    }
}
