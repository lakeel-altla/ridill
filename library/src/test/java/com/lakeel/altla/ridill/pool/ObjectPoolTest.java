package com.lakeel.altla.ridill.pool;

import com.lakeel.altla.ridill.ArgumentNullException;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public final class ObjectPoolTest {

    @Test
    public void scenarioWithTry() {
        ObjectPool<MockObject> pool = new ObjectPool<>(new MockFactory());

        try (MockObject object1 = pool.activate()) {
            assertTrue(object1.active);
            assertEquals(1, pool.getActiveObjectCount());
            assertEquals(0, pool.getPassiveObjectCount());

            try (MockObject object2 = pool.activate()) {
                assertTrue(object2.active);
                assertEquals(2, pool.getActiveObjectCount());
                assertEquals(0, pool.getPassiveObjectCount());

                try (MockObject object3 = pool.activate()) {
                    assertTrue(object3.active);
                    assertEquals(3, pool.getActiveObjectCount());
                    assertEquals(0, pool.getPassiveObjectCount());
                }

                assertEquals(2, pool.getActiveObjectCount());
                assertEquals(1, pool.getPassiveObjectCount());
            }

            assertEquals(1, pool.getActiveObjectCount());
            assertEquals(2, pool.getPassiveObjectCount());
        }

        assertEquals(0, pool.getActiveObjectCount());
        assertEquals(3, pool.getPassiveObjectCount());

        pool.clear();
        assertEquals(0, pool.getActiveObjectCount());
    }

    @Test
    public void scenarioWithoutTry() {
        ObjectPool<MockObject> pool = new ObjectPool<>(new MockFactory());

        MockObject object1 = pool.activate();
        assertTrue(object1.active);
        assertEquals(1, pool.getActiveObjectCount());
        assertEquals(0, pool.getPassiveObjectCount());

        MockObject object2 = pool.activate();
        assertTrue(object2.active);
        assertEquals(2, pool.getActiveObjectCount());
        assertEquals(0, pool.getPassiveObjectCount());

        MockObject object3 = pool.activate();
        assertTrue(object3.active);
        assertEquals(3, pool.getActiveObjectCount());
        assertEquals(0, pool.getPassiveObjectCount());

        pool.passivate(object3);
        assertFalse(object3.active);
        assertEquals(2, pool.getActiveObjectCount());
        assertEquals(1, pool.getPassiveObjectCount());

        pool.passivate(object2);
        assertFalse(object2.active);
        assertEquals(1, pool.getActiveObjectCount());
        assertEquals(2, pool.getPassiveObjectCount());

        pool.passivate(object1);
        assertFalse(object1.active);
        assertEquals(0, pool.getActiveObjectCount());
        assertEquals(3, pool.getPassiveObjectCount());

        pool.clear();
        assertEquals(0, pool.getPassiveObjectCount());
    }

    @Test
    public void returnObjectWithNull() {
        try {
            new ObjectPool<>(new MockFactory()).passivate(null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void returnObjectWithAlreadyReturnedObject() {
        ObjectPool<MockObject> pool = new ObjectPool<>(new MockFactory());
        MockObject object = pool.activate();
        pool.passivate(object);

        try {
            pool.passivate(object);
            fail();
        } catch (IllegalArgumentException e) {
            // expected.
        }
    }

    private final class MockObject implements ObjectPool.Poolable {

        private final ObjectPool<MockObject> pool;

        private boolean active;

        public MockObject(ObjectPool<MockObject> pool) {
            this.pool = pool;
        }

        @Override
        public boolean isActive() {
            return active;
        }

        @Override
        public void onActivate() {
            active = true;
        }

        @Override
        public void onPassivate() {
            active = false;
        }

        @Override
        public void close() {
            pool.passivate(this);
        }
    }

    public final class MockFactory implements ObjectPool.Factory<MockObject> {

        @Override
        public MockObject create(ObjectPool<MockObject> pool) {
            return new MockObject(pool);
        }
    }
}
