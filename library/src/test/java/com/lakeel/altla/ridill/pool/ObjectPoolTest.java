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

        try (PooledObject<MockObject> pooledObject1 = pool.activate()) {
            MockObject object1 = pooledObject1.get();
            assertTrue(object1.isActive);
            assertEquals(1, pool.getActiveObjectCount());
            assertEquals(0, pool.getPassiveObjectCount());

            try (PooledObject<MockObject> pooledObject2 = pool.activate()) {
                MockObject object2 = pooledObject2.get();
                assertTrue(object2.isActive);
                assertEquals(2, pool.getActiveObjectCount());
                assertEquals(0, pool.getPassiveObjectCount());

                try (PooledObject<MockObject> pooledObject3 = pool.activate()) {
                    MockObject object3 = pooledObject3.get();
                    assertTrue(object3.isActive);
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

        PooledObject<MockObject> pooledObject1 = pool.activate();
        MockObject object1 = pooledObject1.get();
        assertTrue(object1.isActive);
        assertEquals(1, pool.getActiveObjectCount());
        assertEquals(0, pool.getPassiveObjectCount());

        PooledObject<MockObject> pooledObject2 = pool.activate();
        MockObject object2 = pooledObject2.get();
        assertTrue(object2.isActive);
        assertEquals(2, pool.getActiveObjectCount());
        assertEquals(0, pool.getPassiveObjectCount());

        PooledObject<MockObject> pooledObject3 = pool.activate();
        MockObject object3 = pooledObject3.get();
        assertTrue(object3.isActive);
        assertEquals(3, pool.getActiveObjectCount());
        assertEquals(0, pool.getPassiveObjectCount());

        pool.passivate(pooledObject3);
        assertFalse(object3.isActive);
        assertEquals(2, pool.getActiveObjectCount());
        assertEquals(1, pool.getPassiveObjectCount());

        pool.passivate(pooledObject2);
        assertFalse(object2.isActive);
        assertEquals(1, pool.getActiveObjectCount());
        assertEquals(2, pool.getPassiveObjectCount());

        pool.passivate(pooledObject1);
        assertFalse(object1.isActive);
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
        PooledObject<MockObject> holder = pool.activate();
        pool.passivate(holder);

        try {
            pool.passivate(holder);
            fail();
        } catch (IllegalArgumentException e) {
            // expected.
        }
    }

    public final class MockFactory implements ObjectPool.Factory<MockObject> {

        @Override
        public MockObject create() {
            return new MockObject();
        }

        @Override
        public void activate(MockObject object) {
            object.isActive = true;
        }

        @Override
        public void passivate(MockObject object) {
            object.isActive = false;
        }
    }

    private final class MockObject {

        private boolean isActive;
    }
}
