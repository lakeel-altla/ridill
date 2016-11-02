package com.lakeel.altla.ridill.pool;

import com.lakeel.altla.ridill.ArgumentNullException;
import com.lakeel.altla.ridill.pool.Pool.Factory;
import com.lakeel.altla.ridill.pool.Pool.Holder;
import com.lakeel.altla.ridill.pool.Pool.Recycler;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public final class PoolTest {

    @Test
    public void constructor() {
        new Pool<>(new Factory<Mock>() {
            @Override
            public Mock create() {
                return null;
            }
        }, new Recycler<Mock>() {
            @Override
            public void recycle(Mock object) {

            }
        });
    }

    @Test
    public void constructorWithNull() {
        try {
            new Pool<>(null, new Recycler<Object>() {
                @Override
                public void recycle(Object object) {
                }
            });
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }

        try {
            new Pool<>(new Factory<Object>() {
                @Override
                public Object create() {
                    return null;
                }
            }, null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void get() {
        final Mock mock = new Mock();

        Pool<Mock> pool = new Pool<>(new Factory<Mock>() {
            @Override
            public Mock create() {
                return mock;
            }
        }, new Recycler<Mock>() {
            @Override
            public void recycle(Mock object) {
            }
        });

        assertSame(mock, pool.get().get());
    }

    @Test
    public void recycle() {
        final Mock mock = new Mock();

        Pool<Mock> pool = new Pool<>(new Factory<Mock>() {
            @Override
            public Mock create() {
                return mock;
            }
        }, new Recycler<Mock>() {
            @Override
            public void recycle(Mock object) {
                object.recycled = true;
            }
        });

        Holder<Mock> holder = pool.get();
        pool.recycle(holder);

        assertTrue(mock.recycled);
    }

    @Test
    public void recycleWithNull() {
        Pool<Mock> pool = new Pool<>(new Factory<Mock>() {
            @Override
            public Mock create() {
                return new Mock();
            }
        }, new Recycler<Mock>() {
            @Override
            public void recycle(Mock object) {
            }
        });

        try {
            pool.recycle(null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void tryWithHolder() {
        final Mock mock = new Mock();

        Pool<Mock> pool = new Pool<>(new Factory<Mock>() {
            @Override
            public Mock create() {
                return mock;
            }
        }, new Recycler<Mock>() {
            @Override
            public void recycle(Mock object) {
                object.recycled = true;
            }
        });

        try (Holder<Mock> holder = pool.get()) {
        }

        assertTrue(mock.recycled);
    }

    @Test
    public void getActiveObjectCount() {
        Pool<Mock> pool = new Pool<>(new Factory<Mock>() {
            @Override
            public Mock create() {
                return new Mock();
            }
        }, new Recycler<Mock>() {
            @Override
            public void recycle(Mock object) {
            }
        });

        assertEquals(0, pool.getActiveObjectCount());

        try (Holder<Mock> holder1 = pool.get()) {
            assertEquals(1, pool.getActiveObjectCount());

            try (Holder<Mock> holder2 = pool.get()) {
                assertEquals(2, pool.getActiveObjectCount());

                try (Holder<Mock> holder3 = pool.get()) {
                    assertEquals(3, pool.getActiveObjectCount());
                }

                assertEquals(2, pool.getActiveObjectCount());
            }

            assertEquals(1, pool.getActiveObjectCount());
        }

        assertEquals(0, pool.getActiveObjectCount());
    }

    @Test
    public void getPassiveObjectCount() {
        Pool<Mock> pool = new Pool<>(new Factory<Mock>() {
            @Override
            public Mock create() {
                return new Mock();
            }
        }, new Recycler<Mock>() {
            @Override
            public void recycle(Mock object) {
            }
        });

        assertEquals(0, pool.getPassiveObjectCount());

        try (Holder<Mock> holder1 = pool.get()) {

            try (Holder<Mock> holder2 = pool.get()) {

                try (Holder<Mock> holder3 = pool.get()) {
                }

                assertEquals(1, pool.getPassiveObjectCount());
            }

            assertEquals(2, pool.getPassiveObjectCount());
        }

        assertEquals(3, pool.getPassiveObjectCount());
    }

    private class Mock {

        boolean recycled;
    }
}
