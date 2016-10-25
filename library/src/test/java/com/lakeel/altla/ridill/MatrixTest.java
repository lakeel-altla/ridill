package com.lakeel.altla.ridill;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public final class MatrixTest {

    @Test
    public void constructor() {
        Matrix matrix = new Matrix();

        assertEquals(0, matrix.m11, 0);
        assertEquals(0, matrix.m21, 0);
        assertEquals(0, matrix.m31, 0);
        assertEquals(0, matrix.m41, 0);

        assertEquals(0, matrix.m12, 0);
        assertEquals(0, matrix.m22, 0);
        assertEquals(0, matrix.m32, 0);
        assertEquals(0, matrix.m42, 0);

        assertEquals(0, matrix.m13, 0);
        assertEquals(0, matrix.m23, 0);
        assertEquals(0, matrix.m33, 0);
        assertEquals(0, matrix.m43, 0);

        assertEquals(0, matrix.m14, 0);
        assertEquals(0, matrix.m24, 0);
        assertEquals(0, matrix.m34, 0);
        assertEquals(0, matrix.m44, 0);
    }

    @Test
    public void constructorFloat16() {
        Matrix matrix = new Matrix(11, 12, 13, 14,
                                   21, 22, 23, 24,
                                   31, 32, 33, 34,
                                   41, 42, 43, 44);

        assertEquals(11, matrix.m11, 0);
        assertEquals(12, matrix.m12, 0);
        assertEquals(13, matrix.m13, 0);
        assertEquals(14, matrix.m14, 0);

        assertEquals(21, matrix.m21, 0);
        assertEquals(22, matrix.m22, 0);
        assertEquals(23, matrix.m23, 0);
        assertEquals(24, matrix.m24, 0);

        assertEquals(31, matrix.m31, 0);
        assertEquals(32, matrix.m32, 0);
        assertEquals(33, matrix.m33, 0);
        assertEquals(34, matrix.m34, 0);

        assertEquals(41, matrix.m41, 0);
        assertEquals(42, matrix.m42, 0);
        assertEquals(43, matrix.m43, 0);
        assertEquals(44, matrix.m44, 0);
    }

    @Test
    public void createIdentity() {
        Matrix expected = new Matrix(1, 0, 0, 0,
                                     0, 1, 0, 0,
                                     0, 0, 1, 0,
                                     0, 0, 0, 1);
        Matrix result = Matrix.createIdentity();

        assertEquals(expected, result);
    }

    @Test
    public void createTranslationFloatFloatFloatMatrix() {
        Matrix result = new Matrix();
        Matrix expected = new Matrix(1, 0, 0, 14,
                                     0, 1, 0, 24,
                                     0, 0, 1, 34,
                                     0, 0, 0, 1);

        Matrix.createTranslation(14, 24, 34, result);

        assertEquals(expected, result);
    }

    @Test
    public void createTranslationFloatFloatFloatMatrixWithNull() {
        try {
            Matrix.createTranslation(0, 0, 0, null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void createTranslationVector3() {
        Matrix result = new Matrix();
        Matrix expected = new Matrix(1, 0, 0, 14,
                                     0, 1, 0, 24,
                                     0, 0, 1, 34,
                                     0, 0, 0, 1);

        Matrix.createTranslation(new Vector3(14, 24, 34), result);

        assertEquals(expected, result);
    }

    @Test
    public void createTranslationVector3WithNull() {
        try {
            Matrix.createTranslation(null, new Matrix());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }

        try {
            Matrix.createTranslation(new Vector3(), null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void createScaleFloatFloatFloatMatrix() {
        Matrix result = new Matrix();
        Matrix expected = new Matrix(11, 0, 0, 0,
                                     0, 22, 0, 0,
                                     0, 0, 33, 0,
                                     0, 0, 0, 1);

        Matrix.createScale(11, 22, 33, result);

        assertEquals(expected, result);
    }

    @Test
    public void createScaleFloatFloatFloatMatrixWithNull() {
        try {
            Matrix.createScale(0, 0, 0, null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void createScaleVector3Matrix() {
        Matrix result = new Matrix();
        Matrix expected = new Matrix(11, 0, 0, 0,
                                     0, 22, 0, 0,
                                     0, 0, 33, 0,
                                     0, 0, 0, 1);

        Matrix.createScale(new Vector3(11, 22, 33), result);

        assertEquals(expected, result);
    }

    @Test
    public void createScaleVector3MatrixWithNull() {
        try {
            Matrix.createScale(null, new Matrix());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }

        try {
            Matrix.createScale(new Vector3(), null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void createScaleFloatMatrix() {
        Matrix result = new Matrix();
        Matrix expected = new Matrix(7, 0, 0, 0,
                                     0, 7, 0, 0,
                                     0, 0, 7, 0,
                                     0, 0, 0, 1);

        Matrix.createScale(7, result);

        assertEquals(expected, result);
    }

    @Test
    public void createScaleFloatMatrixWithNull() {
        try {
            Matrix.createScale(0, null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void createRotationX() {
        Matrix result = new Matrix();
        Matrix expected = new Matrix(1, 0, 0, 0,
                                     0, (float) Math.cos(7), -(float) Math.sin(7), 0,
                                     0, (float) Math.sin(7), (float) Math.cos(7), 0,
                                     0, 0, 0, 1);

        Matrix.createRotationX(7, result);

        assertEquals(expected, result);
    }

    @Test
    public void createRotationXWithNull() {
        try {
            Matrix.createRotationX(0, null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void createRotationY() {
        Matrix result = new Matrix();
        Matrix expected = new Matrix((float) Math.cos(7), 0, (float) Math.sin(7), 0,
                                     0, 1, 0, 0,
                                     -(float) Math.sin(7), 0, (float) Math.cos(7), 0,
                                     0, 0, 0, 1);

        Matrix.createRotationY(7, result);

        assertEquals(expected, result);
    }

    @Test
    public void createRotationYWithNull() {
        try {
            Matrix.createRotationY(0, null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void createRotationZ() {
        Matrix result = new Matrix();
        Matrix expected = new Matrix((float) Math.cos(7), -(float) Math.sin(7), 0, 0,
                                     (float) Math.sin(7), (float) Math.cos(7), 0, 0,
                                     0, 0, 1, 0,
                                     0, 0, 0, 1);

        Matrix.createRotationZ(7, result);

        assertEquals(expected, result);
    }

    @Test
    public void createRotationZWithNull() {
        try {
            Matrix.createRotationZ(0, null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void createFromAxisAngle() {
        Matrix result = new Matrix();

        float x = 1;
        float y = 2;
        float z = 3;

        float m11 = x * x + (float) Math.cos(7) * (1 - x * x);
        float m12 = x * y - (float) Math.cos(7) * x * y - z * (float) Math.sin(7);
        float m13 = x * z - (float) Math.cos(7) * x * z + y * (float) Math.sin(7);

        float m21 = y * x - (float) Math.cos(7) * y * x + z * (float) Math.sin(7);
        float m22 = y * y + (float) Math.cos(7) * (1 - y * y);
        float m23 = y * z - (float) Math.cos(7) * y * z - x * (float) Math.sin(7);

        float m31 = z * x - (float) Math.cos(7) * z * x - y * (float) Math.sin(7);
        float m32 = z * y - (float) Math.cos(7) * z * y + x * (float) Math.sin(7);
        float m33 = z * z + (float) Math.cos(7) * (1 - z * z);

        Matrix expected = new Matrix(m11, m12, m13, 0,
                                     m21, m22, m23, 0,
                                     m31, m32, m33, 0,
                                     0, 0, 0, 1);

        Matrix.createFromAxisAngle(new Vector3(x, y, z), 7, result);

        assertEquals(expected, result);
    }

    @Test
    public void createFromAxisAngleWithNull() {
        try {
            Matrix.createFromAxisAngle(null, 0, new Matrix());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }

        try {
            Matrix.createFromAxisAngle(new Vector3(), 0, null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void createFromQuaternion() {
        Matrix result = new Matrix();

        float x = 2;
        float y = 3;
        float z = 4;
        float w = 1;

        // (1.0f - 2.0f*qy*qy - 2.0f*qz*qz, 2.0f*qx*qy - 2.0f*qz*qw,        2.0f*qx*qz + 2.0f*qy*qw,        0.0f,
        //  2.0f*qx*qy + 2.0f*qz*qw,        1.0f - 2.0f*qx*qx - 2.0f*qz*qz, 2.0f*qy*qz - 2.0f*qx*qw,        0.0f,
        //  2.0f*qx*qz - 2.0f*qy*qw,        2.0f*qy*qz + 2.0f*qx*qw,        1.0f - 2.0f*qx*qx - 2.0f*qy*qy, 0.0f,
        //  0.0f,                           0.0f,                           0.0f,                           1.0f)
        float m11 = 1 - 2 * y * y - 2 * z * z;
        float m12 = 2 * x * y - 2 * z * w;
        float m13 = 2 * x * z + 2 * y * w;
        float m21 = 2 * x * y + 2 * z * w;
        float m22 = 1 - 2 * x * x - 2 * z * z;
        float m23 = 2 * y * z - 2 * x * w;
        float m31 = 2 * x * z - 2 * y * w;
        float m32 = 2 * y * z + 2 * x * w;
        float m33 = 1 - 2 * x * x - 2 * y * y;

        Matrix expected = new Matrix(m11, m12, m13, 0,
                                     m21, m22, m23, 0,
                                     m31, m32, m33, 0,
                                     0, 0, 0, 1);

        Matrix.createFromQuaternion(new Quaternion(x, y, z, w), result);

        assertEquals(expected, result);
    }

    @Test
    public void createFromQuaternionWithNull() {
        try {
            Matrix.createFromQuaternion(null, new Matrix());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }

        try {
            Matrix.createFromQuaternion(new Quaternion(), null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void createPerspectiveOffCenter() {
        // glFrustum code:
        // | 2n / (r - l),            0,  (r + l) / (r - l),              0 |
        // |            0, 2n / (t - b),  (t + b) / (t - b),              0 |
        // |            0,            0, -(f + n) / (f - n), -2fn / (f - n) |
        // |            0,            0,                 -1,              0 |

        float r = -4;
        float l = 5;
        float t = 8;
        float b = 1;
        float n = 1;
        float f = 10;
        float tolerance = 0.0001f;

        Matrix result = new Matrix();
        Matrix.createPerspectiveOffCenter(l, r, b, t, n, f, result);

        assertEquals(2 * n / (r - l), result.m11, tolerance);
        assertEquals(0, result.m12, tolerance);
        assertEquals((r + l) / (r - l), result.m13, tolerance);
        assertEquals(0, result.m14, tolerance);

        assertEquals(0, result.m21, tolerance);
        assertEquals(2 * n / (t - b), result.m22, tolerance);
        assertEquals((t + b) / (t - b), result.m23, tolerance);
        assertEquals(0, result.m24, tolerance);

        assertEquals(0, result.m31, tolerance);
        assertEquals(0, result.m32, tolerance);
        assertEquals(-(f + n) / (f - n), result.m33, tolerance);
        assertEquals(-2 * f * n / (f - n), result.m34, tolerance);

        assertEquals(0, result.m41, tolerance);
        assertEquals(0, result.m42, tolerance);
        assertEquals(-1, result.m43, tolerance);
        assertEquals(0, result.m44, tolerance);
    }

    @Test
    public void createPerspectiveOffCenterWithNull() {
        try {
            Matrix.createPerspectiveOffCenter(-1, 1, -1, 1, 0, 1, null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void createPerspective() {
        // glFrustum code:
        // | 2n / (r - l),            0,  (r + l) / (r - l),              0 |
        // |            0, 2n / (t - b),  (t + b) / (t - b),              0 |
        // |            0,            0, -(f + n) / (f - n), -2fn / (f - n) |
        // |            0,            0,                 -1,              0 |

        // createPerspective(...) equals to createPerspectiveOffCenter(-w/2, w/2, -h/2, h/2, n, f)

        float w = 30;
        float h = 20;
        float n = 1;
        float f = 10;
        float tolerance = 0.0001f;

        Matrix result = new Matrix();
        Matrix.createPerspective(w, h, n, f, result);

        Matrix expected = new Matrix();
        Matrix.createPerspectiveOffCenter(-w / 2, w / 2, -h / 2, h / 2, n, f, expected);

        assertEquals(expected.m11, result.m11, tolerance);
        assertEquals(expected.m12, result.m12, tolerance);
        assertEquals(expected.m13, result.m13, tolerance);
        assertEquals(expected.m14, result.m14, tolerance);

        assertEquals(expected.m21, result.m21, tolerance);
        assertEquals(expected.m22, result.m22, tolerance);
        assertEquals(expected.m23, result.m23, tolerance);
        assertEquals(expected.m24, result.m24, tolerance);

        assertEquals(expected.m31, result.m31, tolerance);
        assertEquals(expected.m32, result.m32, tolerance);
        assertEquals(expected.m33, result.m33, tolerance);
        assertEquals(expected.m34, result.m34, tolerance);

        assertEquals(expected.m41, result.m41, tolerance);
        assertEquals(expected.m42, result.m42, tolerance);
        assertEquals(expected.m43, result.m43, tolerance);
        assertEquals(expected.m44, result.m44, tolerance);
    }

    @Test
    public void createPerspectiveWithNull() {
        try {
            Matrix.createPerspective(1, 1, 0, 1, null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void createPerspectiveFieldOfView() {
        // glFrustum code:
        // | 2n / (r - l),            0,  (r + l) / (r - l),              0 |
        // |            0, 2n / (t - b),  (t + b) / (t - b),              0 |
        // |            0,            0, -(f + n) / (f - n), -2fn / (f - n) |
        // |            0,            0,                 -1,              0 |

        // yScale = 1/tan(fov/2)
        // xScale = yScale/aspectRatio
        // w = 2*n/xScale
        // h = 2*n/yScale
        // equals to createPerspectiveOffCenter(-w/2, w/2, -h/2, h/2, n, f)

        float fov = (float) Math.PI / 2;
        float aspectRatio = 16 / 9;
        float near = 1;
        float far = 1000;
        float tolerance = 0.0001f;

        Matrix result = new Matrix();
        Matrix.createPerspectiveFieldOfView(fov, aspectRatio, near, far, result);

        float yScale = 1 / (float) Math.tan(fov / 2);
        float xScale = yScale / aspectRatio;
        float w = 2 * near / xScale;
        float h = 2 * near / yScale;

        Matrix expected = new Matrix();
        Matrix.createPerspectiveOffCenter(-w / 2, w / 2, -h / 2, h / 2, near, far, expected);

        assertEquals(expected.m11, result.m11, tolerance);
        assertEquals(expected.m12, result.m12, tolerance);
        assertEquals(expected.m13, result.m13, tolerance);
        assertEquals(expected.m14, result.m14, tolerance);

        assertEquals(expected.m21, result.m21, tolerance);
        assertEquals(expected.m22, result.m22, tolerance);
        assertEquals(expected.m23, result.m23, tolerance);
        assertEquals(expected.m24, result.m24, tolerance);

        assertEquals(expected.m31, result.m31, tolerance);
        assertEquals(expected.m32, result.m32, tolerance);
        assertEquals(expected.m33, result.m33, tolerance);
        assertEquals(expected.m34, result.m34, tolerance);

        assertEquals(expected.m41, result.m41, tolerance);
        assertEquals(expected.m42, result.m42, tolerance);
        assertEquals(expected.m43, result.m43, tolerance);
        assertEquals(expected.m44, result.m44, tolerance);
    }

    @Test
    public void createPerspectiveFieldOfViewWithNull() {
        try {
            Matrix.createPerspectiveFieldOfView(1, 1, 0, 1, null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void createOrthographicOffCenter() {
        // glOrtho code:
        // | 2 / (r - l),           0,            0, (r + l) / (r - l) |
        // |           0, 2 / (t - b),            0, (t + b) / (t - b) |
        // |           0,           0, -2 / (f - n), (f + n) / (f - n) |
        // |           0,           0,            0,                 1 |

        float r = -4;
        float l = 5;
        float t = 8;
        float b = 1;
        float n = 1;
        float f = 10;
        float tolerance = 0.0001f;

        Matrix result = new Matrix();
        Matrix.createOrthographicOffCenter(l, r, b, t, n, f, result);

        assertEquals(2 * n / (r - l), result.m11, tolerance);
        assertEquals(0, result.m12, tolerance);
        assertEquals(0, result.m13, tolerance);
        assertEquals((r + l) / (r - l), result.m14, tolerance);

        assertEquals(0, result.m21, tolerance);
        assertEquals(2 / (t - b), result.m22, tolerance);
        assertEquals(0, result.m23, tolerance);
        assertEquals((t + b) / (t - b), result.m24, tolerance);

        assertEquals(0, result.m31, tolerance);
        assertEquals(0, result.m32, tolerance);
        assertEquals(-2 / (f - n), result.m33, tolerance);
        assertEquals((f + n) / (f - n), result.m34, tolerance);

        assertEquals(0, result.m41, tolerance);
        assertEquals(0, result.m42, tolerance);
        assertEquals(0, result.m43, tolerance);
        assertEquals(1, result.m44, tolerance);

    }

    @Test
    public void createOrthographicOffCenterWithNull() {
        try {
            Matrix.createOrthographicOffCenter(-1, 1, -1, 1, 0, 1, null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void createOrthographic() {
        // glOrtho code:
        // | 2 / (r - l),           0,            0, (r + l) / (r - l) |
        // |           0, 2 / (t - b),            0, (t + b) / (t - b) |
        // |           0,           0, -2 / (f - n), (f + n) / (f - n) |
        // |           0,           0,            0,                 1 |

        // createOrthographic(...) is equals to createOrthographicOffCenter(-w/2, w/2, -h/2, h/2, n, f).


        float w = 30;
        float h = 20;
        float n = 1;
        float f = 10;
        float tolerance = 0.0001f;

        Matrix result = new Matrix();
        Matrix.createOrthographic(w, h, n, f, result);

        Matrix expected = new Matrix();
        Matrix.createOrthographicOffCenter(-w / 2, w / 2, -h / 2, h / 2, n, f, expected);

        assertEquals(expected.m11, result.m11, tolerance);
        assertEquals(expected.m12, result.m12, tolerance);
        assertEquals(expected.m13, result.m13, tolerance);
        assertEquals(expected.m14, result.m14, tolerance);

        assertEquals(expected.m21, result.m21, tolerance);
        assertEquals(expected.m22, result.m22, tolerance);
        assertEquals(expected.m23, result.m23, tolerance);
        assertEquals(expected.m24, result.m24, tolerance);

        assertEquals(expected.m31, result.m31, tolerance);
        assertEquals(expected.m32, result.m32, tolerance);
        assertEquals(expected.m33, result.m33, tolerance);
        assertEquals(expected.m34, result.m34, tolerance);

        assertEquals(expected.m41, result.m41, tolerance);
        assertEquals(expected.m42, result.m42, tolerance);
        assertEquals(expected.m43, result.m43, tolerance);
        assertEquals(expected.m44, result.m44, tolerance);
    }

    @Test
    public void createOrthographicWithNull() {
        try {
            Matrix.createOrthographic(1, 1, 0, 1, null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void decompose() {
        float tolerance = 0.0001f;

        Vector3 scaleVector = new Vector3(2, 3, 4);

        Quaternion quaternion = new Quaternion();
        float yaw = (float) Math.toRadians(90);
        float pitch = (float) Math.toRadians(90);
        float roll = (float) Math.toRadians(90);
        Quaternion.createFromYawPitchRoll(yaw, pitch, roll, quaternion);

        Vector3 translationVector = new Vector3(10, 20, 30);

        Matrix scale = new Matrix();
        Matrix.createScale(scaleVector, scale);

        Matrix rotation = new Matrix();
        Matrix.createFromQuaternion(quaternion, rotation);

        Matrix translation = new Matrix();
        Matrix.createTranslation(translationVector, translation);

        Matrix temp = new Matrix();
        Matrix.multiply(translation, rotation, temp);
        Matrix transform = new Matrix();
        Matrix.multiply(temp, scale, transform);

        Vector3 resultScale = new Vector3();
        Quaternion resultRotation = new Quaternion();
        Vector3 resultTranslation = new Vector3();
        boolean result = transform.decompose(resultScale, resultRotation, resultTranslation);

        assertTrue(result);

        assertEquals(scaleVector.x, resultScale.x, tolerance);
        assertEquals(scaleVector.y, resultScale.y, tolerance);
        assertEquals(scaleVector.z, resultScale.z, tolerance);

        assertEquals(quaternion.x, resultRotation.x, tolerance);
        assertEquals(quaternion.y, resultRotation.y, tolerance);
        assertEquals(quaternion.z, resultRotation.z, tolerance);
        assertEquals(quaternion.w, resultRotation.w, tolerance);

        assertEquals(translationVector.x, resultTranslation.x, tolerance);
        assertEquals(translationVector.y, resultTranslation.y, tolerance);
        assertEquals(translationVector.z, resultTranslation.z, tolerance);
    }

    @Test
    public void decomposeWithNoRotationMatrix() {
        boolean result1 = new Matrix(0, 1, 1, 0,
                                     0, 1, 1, 0,
                                     0, 1, 1, 0,
                                     0, 0, 0, 1).decompose(new Vector3(), new Quaternion(), new Vector3());
        assertFalse(result1);

        boolean result2 = new Matrix(1, 0, 1, 0,
                                     1, 0, 1, 0,
                                     1, 0, 1, 0,
                                     0, 0, 0, 1).decompose(new Vector3(), new Quaternion(), new Vector3());
        assertFalse(result2);

        boolean result3 = new Matrix(1, 1, 0, 0,
                                     1, 1, 0, 0,
                                     1, 1, 0, 0,
                                     0, 0, 0, 1).decompose(new Vector3(), new Quaternion(), new Vector3());
        assertFalse(result3);
    }

    @Test
    public void decomposeWithNull() {
        try {
            new Matrix().decompose(null, new Quaternion(), new Vector3());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }

        try {
            new Matrix().decompose(new Vector3(), null, new Vector3());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }

        try {
            new Matrix().decompose(new Vector3(), new Quaternion(), null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void lookAt() {
        Matrix result = new Matrix();
        float tolerance = 0.0001f;

        Matrix.createLookAt(new Vector3(0, 0, 1), new Vector3(0, 0, -1), new Vector3(0, 1, 0), result);

        assertEquals(1, result.m11, tolerance);
        assertEquals(0, result.m21, tolerance);
        assertEquals(0, result.m31, tolerance);

        assertEquals(0, result.m12, tolerance);
        assertEquals(1, result.m22, tolerance);
        assertEquals(0, result.m32, tolerance);

        assertEquals(0, result.m13, tolerance);
        assertEquals(0, result.m23, tolerance);
        assertEquals(1, result.m33, tolerance);

        assertEquals(0, result.m14, tolerance);
        assertEquals(0, result.m24, tolerance);
        assertEquals(-1, result.m34, tolerance);

        assertEquals(0, result.m41, 0);
        assertEquals(0, result.m42, 0);
        assertEquals(0, result.m43, 0);
        assertEquals(1, result.m44, 0);
    }


    @Test
    public void lookAtWithNull() {
        try {
            Matrix.createLookAt(null, new Vector3(), new Vector3(), new Matrix());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }

        try {
            Matrix.createLookAt(new Vector3(), null, new Vector3(), new Matrix());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }

        try {
            Matrix.createLookAt(new Vector3(), new Vector3(), null, new Matrix());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }

        try {
            Matrix.createLookAt(new Vector3(), new Vector3(), new Vector3(), null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void add() {
        Matrix left = new Matrix(1, 2, 3, 4,
                                 5, 6, 7, 8,
                                 9, 10, 11, 12,
                                 13, 14, 15, 16);
        Matrix right = new Matrix(1, 2, 3, 4,
                                  5, 6, 7, 8,
                                  9, 10, 11, 12,
                                  13, 14, 15, 16);
        Matrix result = new Matrix();
        Matrix expected = new Matrix(2, 4, 6, 8,
                                     10, 12, 14, 16,
                                     18, 20, 22, 24,
                                     26, 28, 30, 32);

        Matrix.add(left, right, result);

        assertEquals(expected, result);
    }

    @Test
    public void addWithNull() {
        try {
            Matrix.add(null, new Matrix(), new Matrix());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }

        try {
            Matrix.add(new Matrix(), null, new Matrix());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }

        try {
            Matrix.add(new Matrix(), new Matrix(), null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void subtract() {
        Matrix left = new Matrix(1, 2, 3, 4,
                                 5, 6, 7, 8,
                                 9, 10, 11, 12,
                                 13, 14, 15, 16);
        Matrix right = new Matrix(0, 1, 2, 3,
                                  4, 5, 6, 7,
                                  8, 9, 10, 11,
                                  12, 13, 14, 15);
        Matrix result = new Matrix();
        Matrix expected = new Matrix(1, 1, 1, 1,
                                     1, 1, 1, 1,
                                     1, 1, 1, 1,
                                     1, 1, 1, 1);

        Matrix.subtract(left, right, result);

        assertEquals(expected, result);
    }

    @Test
    public void subtractWithNull() {
        try {
            Matrix.subtract(null, new Matrix(), new Matrix());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }

        try {
            Matrix.subtract(new Matrix(), null, new Matrix());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }

        try {
            Matrix.subtract(new Matrix(), new Matrix(), null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void multiplyMatrixMatrixMatrix() {
        Matrix left = new Matrix(11, 12, 13, 14,
                                 21, 22, 23, 24,
                                 31, 32, 33, 34,
                                 41, 42, 43, 44);
        Matrix right = new Matrix(11, 12, 13, 14,
                                  21, 22, 23, 24,
                                  31, 32, 33, 34,
                                  41, 42, 43, 44);
        Matrix result = new Matrix();

        Matrix.multiply(left, right, result);

        assertEquals((11 * 11) + (12 * 21) + (13 * 31) + (14 * 41), result.m11, 0);
        assertEquals((11 * 12) + (12 * 22) + (13 * 32) + (14 * 42), result.m12, 0);
        assertEquals((11 * 13) + (12 * 23) + (13 * 33) + (14 * 43), result.m13, 0);
        assertEquals((11 * 14) + (12 * 24) + (13 * 34) + (14 * 44), result.m14, 0);

        assertEquals((21 * 11) + (22 * 21) + (23 * 31) + (24 * 41), result.m21, 0);
        assertEquals((21 * 12) + (22 * 22) + (23 * 32) + (24 * 42), result.m22, 0);
        assertEquals((21 * 13) + (22 * 23) + (23 * 33) + (24 * 43), result.m23, 0);
        assertEquals((21 * 14) + (22 * 24) + (23 * 34) + (24 * 44), result.m24, 0);

        assertEquals((31 * 11) + (32 * 21) + (33 * 31) + (34 * 41), result.m31, 0);
        assertEquals((31 * 12) + (32 * 22) + (33 * 32) + (34 * 42), result.m32, 0);
        assertEquals((31 * 13) + (32 * 23) + (33 * 33) + (34 * 43), result.m33, 0);
        assertEquals((31 * 14) + (32 * 24) + (33 * 34) + (34 * 44), result.m34, 0);

        assertEquals((41 * 11) + (42 * 21) + (43 * 31) + (44 * 41), result.m41, 0);
        assertEquals((41 * 12) + (42 * 22) + (43 * 32) + (44 * 42), result.m42, 0);
        assertEquals((41 * 13) + (42 * 23) + (43 * 33) + (44 * 43), result.m43, 0);
        assertEquals((41 * 14) + (42 * 24) + (43 * 34) + (44 * 44), result.m44, 0);
    }

    @Test
    public void multiplyMatrixMatrixMatrixWithNull() {
        try {
            Matrix.multiply(null, new Matrix(), new Matrix());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }

        try {
            Matrix.multiply(new Matrix(), null, new Matrix());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }

        try {
            Matrix.multiply(new Matrix(), new Matrix(), null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void multiplyMatrixVector4Vector4() {
        Matrix left = new Matrix(11, 12, 13, 14,
                                 21, 22, 23, 24,
                                 31, 32, 33, 34,
                                 41, 42, 43, 44);
        Vector4 right = new Vector4(1, 2, 3, 4);
        Vector4 result = new Vector4();

        Matrix.multiply(left, right, result);

        assertEquals((11 * 1) + (12 * 2) + (13 * 3) + (14 * 4), result.x, 0);
        assertEquals((21 * 1) + (22 * 2) + (23 * 3) + (24 * 4), result.y, 0);
        assertEquals((31 * 1) + (32 * 2) + (33 * 3) + (34 * 4), result.z, 0);
        assertEquals((41 * 1) + (42 * 2) + (43 * 3) + (44 * 4), result.w, 0);
    }


    @Test
    public void multiplyMatrixVector4Vector4WithNull() {
        try {
            Matrix.multiply(null, new Vector4(), new Vector4());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }

        try {
            Matrix.multiply(new Matrix(), null, new Vector4());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }

        try {
            Matrix.multiply(new Matrix(), new Vector4(), null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void transpose() {
        Matrix matrix = new Matrix(11, 12, 13, 14,
                                   21, 22, 23, 24,
                                   31, 32, 33, 34,
                                   41, 42, 43, 44);
        Matrix result = new Matrix();
        Matrix expected = new Matrix(11, 21, 31, 41,
                                     12, 22, 32, 42,
                                     13, 23, 33, 43,
                                     14, 24, 34, 44);

        Matrix.transpose(matrix, result);

        assertEquals(expected, result);
    }

    @Test
    public void transposeWithNull() {
        try {
            Matrix.transpose(null, new Matrix());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }

        try {
            Matrix.transpose(new Matrix(), null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void invert() {
        //
        // Checks inv(inv(M)).
        //

        Matrix matrix = new Matrix(9, 1, 1, 1,
                                   1, 9, 1, 1,
                                   1, 1, 9, 1,
                                   1, 1, 1, 9);
        Matrix result = new Matrix();
        Matrix inverseInverse = new Matrix();
        float tolerance = 0.0001f;

        Matrix.invert(matrix, result);
        Matrix.invert(result, inverseInverse);

        assertEquals(matrix.m11, inverseInverse.m11, tolerance);
        assertEquals(matrix.m12, inverseInverse.m12, tolerance);
        assertEquals(matrix.m13, inverseInverse.m13, tolerance);
        assertEquals(matrix.m14, inverseInverse.m14, tolerance);

        assertEquals(matrix.m21, inverseInverse.m21, tolerance);
        assertEquals(matrix.m22, inverseInverse.m22, tolerance);
        assertEquals(matrix.m23, inverseInverse.m23, tolerance);
        assertEquals(matrix.m24, inverseInverse.m24, tolerance);

        assertEquals(matrix.m31, inverseInverse.m31, tolerance);
        assertEquals(matrix.m32, inverseInverse.m32, tolerance);
        assertEquals(matrix.m33, inverseInverse.m33, tolerance);
        assertEquals(matrix.m34, inverseInverse.m34, tolerance);

        assertEquals(matrix.m41, inverseInverse.m41, tolerance);
        assertEquals(matrix.m42, inverseInverse.m42, tolerance);
        assertEquals(matrix.m43, inverseInverse.m43, tolerance);
        assertEquals(matrix.m44, inverseInverse.m44, tolerance);

        //
        // Checks M * inv(M) = identity.
        //

        Matrix identity = new Matrix();
        Matrix.multiply(matrix, result, identity);

        assertEquals(1, identity.m11, tolerance);
        assertEquals(0, identity.m12, tolerance);
        assertEquals(0, identity.m13, tolerance);
        assertEquals(0, identity.m14, tolerance);

        assertEquals(0, identity.m21, tolerance);
        assertEquals(1, identity.m22, tolerance);
        assertEquals(0, identity.m23, tolerance);
        assertEquals(0, identity.m24, tolerance);

        assertEquals(0, identity.m31, tolerance);
        assertEquals(0, identity.m32, tolerance);
        assertEquals(1, identity.m33, tolerance);
        assertEquals(0, identity.m34, tolerance);

        assertEquals(0, identity.m41, tolerance);
        assertEquals(0, identity.m42, tolerance);
        assertEquals(0, identity.m43, tolerance);
        assertEquals(1, identity.m44, tolerance);

        //
        // Checks that there are no inverse for the matrix.
        //

        Matrix noInverse = new Matrix(1, 1, 1, 1,
                                      1, 1, 1, 1,
                                      1, 1, 1, 1,
                                      1, 1, 1, 1);
        Matrix noInverseResult = new Matrix();
        Matrix noInverseExpected = new Matrix();

        Matrix.invert(noInverse, noInverseResult);

        assertEquals(noInverseExpected, noInverseResult);
    }

    @Test
    public void invertWithNull() {
        try {
            Matrix.invert(null, new Matrix());
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }

        try {
            Matrix.invert(new Matrix(), null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void setMatrix() {
        Matrix matrix = new Matrix();
        Matrix value = new Matrix(11, 12, 13, 14,
                                  21, 22, 23, 24,
                                  31, 32, 33, 34,
                                  41, 42, 43, 44);
        Matrix expected = new Matrix(11, 12, 13, 14,
                                     21, 22, 23, 24,
                                     31, 32, 33, 34,
                                     41, 42, 43, 44);

        Matrix result = matrix.set(value);

        assertSame(matrix, result);
        assertEquals(expected, matrix);
    }

    @Test
    public void setMatrixWithNull() {
        try {
            new Matrix().set(null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void setFloat16() {
        Matrix matrix = new Matrix();
        Matrix expected = new Matrix(11, 12, 13, 14,
                                     21, 22, 23, 24,
                                     31, 32, 33, 34,
                                     41, 42, 43, 44);

        Matrix result = matrix.set(11, 12, 13, 14,
                                   21, 22, 23, 24,
                                   31, 32, 33, 34,
                                   41, 42, 43, 44);

        assertSame(matrix, result);
        assertEquals(expected, matrix);
    }

    @Test
    public void setInColumnMajorOrder() {
        Matrix matrix = new Matrix();
        Matrix result = matrix.setInColumnMajorOrder(new float[] {
                11, 21, 31, 41,
                12, 22, 32, 42,
                13, 23, 33, 43,
                14, 24, 34, 44
        });
        Matrix expected = new Matrix(11, 12, 13, 14,
                                     21, 22, 23, 24,
                                     31, 32, 33, 34,
                                     41, 42, 43, 44);

        assertSame(matrix, result);
        assertEquals(expected, matrix);
    }

    @Test
    public void setInColumnMajorOrderWithNull() {
        try {
            new Matrix().setInColumnMajorOrder(null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void setInColumnMajorOrderWithInvalidLengthArray() {
        try {
            new Matrix().setInColumnMajorOrder(new float[0]);
            fail();
        } catch (IllegalArgumentException e) {
            // expected.
        }

        try {
            new Matrix().setInColumnMajorOrder(new float[17]);
            fail();
        } catch (IllegalArgumentException e) {
            // expected.
        }
    }

    @Test
    public void setInRowMajorOrder() {
        Matrix matrix = new Matrix();
        Matrix result = matrix.setInRowMajorOrder(new float[] {
                11, 12, 13, 14,
                21, 22, 23, 24,
                31, 32, 33, 34,
                41, 42, 43, 44
        });
        Matrix expected = new Matrix(11, 12, 13, 14,
                                     21, 22, 23, 24,
                                     31, 32, 33, 34,
                                     41, 42, 43, 44);

        assertSame(matrix, result);
        assertEquals(expected, matrix);
    }

    @Test
    public void setInRowMajorOrderWithNull() {
        try {
            new Matrix().setInRowMajorOrder(null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void setInRowMajorOrderWithInvalidLengthArray() {
        try {
            new Matrix().setInRowMajorOrder(new float[0]);
            fail();
        } catch (IllegalArgumentException e) {
            // expected.
        }

        try {
            new Matrix().setInRowMajorOrder(new float[17]);
            fail();
        } catch (IllegalArgumentException e) {
            // expected.
        }
    }

    @Test
    public void get() {
        Matrix matrix = new Matrix(11, 12, 13, 14,
                                   21, 22, 23, 24,
                                   31, 32, 33, 34,
                                   41, 42, 43, 44);

        assertEquals(11, matrix.get(0, 0), 0);
        assertEquals(12, matrix.get(0, 1), 0);
        assertEquals(13, matrix.get(0, 2), 0);
        assertEquals(14, matrix.get(0, 3), 0);

        assertEquals(21, matrix.get(1, 0), 0);
        assertEquals(22, matrix.get(1, 1), 0);
        assertEquals(23, matrix.get(1, 2), 0);
        assertEquals(24, matrix.get(1, 3), 0);

        assertEquals(31, matrix.get(2, 0), 0);
        assertEquals(32, matrix.get(2, 1), 0);
        assertEquals(33, matrix.get(2, 2), 0);
        assertEquals(34, matrix.get(2, 3), 0);

        assertEquals(41, matrix.get(3, 0), 0);
        assertEquals(42, matrix.get(3, 1), 0);
        assertEquals(43, matrix.get(3, 2), 0);
        assertEquals(44, matrix.get(3, 3), 0);
    }

    @Test
    public void getWithInvalidIndex() {
        try {
            new Matrix().get(-1, 0);
            fail();
        } catch (IndexOutOfBoundsException e) {
            // expected.
        }

        try {
            new Matrix().get(4, 0);
            fail();
        } catch (IndexOutOfBoundsException e) {
            // expected.
        }

        try {
            new Matrix().get(0, -1);
            fail();
        } catch (IndexOutOfBoundsException e) {
            // expected.
        }

        try {
            new Matrix().get(0, 4);
            fail();
        } catch (IndexOutOfBoundsException e) {
            // expected.
        }
    }

    @Test
    public void getInRowMajorOrder() {
        Matrix matrix = new Matrix(11, 12, 13, 14,
                                   21, 22, 23, 24,
                                   31, 32, 33, 34,
                                   41, 42, 43, 44);

        int index = 0;

        assertEquals(11, matrix.getInRowMajorOrder(index++), 0);
        assertEquals(12, matrix.getInRowMajorOrder(index++), 0);
        assertEquals(13, matrix.getInRowMajorOrder(index++), 0);
        assertEquals(14, matrix.getInRowMajorOrder(index++), 0);

        assertEquals(21, matrix.getInRowMajorOrder(index++), 0);
        assertEquals(22, matrix.getInRowMajorOrder(index++), 0);
        assertEquals(23, matrix.getInRowMajorOrder(index++), 0);
        assertEquals(24, matrix.getInRowMajorOrder(index++), 0);

        assertEquals(31, matrix.getInRowMajorOrder(index++), 0);
        assertEquals(32, matrix.getInRowMajorOrder(index++), 0);
        assertEquals(33, matrix.getInRowMajorOrder(index++), 0);
        assertEquals(34, matrix.getInRowMajorOrder(index++), 0);

        assertEquals(41, matrix.getInRowMajorOrder(index++), 0);
        assertEquals(42, matrix.getInRowMajorOrder(index++), 0);
        assertEquals(43, matrix.getInRowMajorOrder(index++), 0);
        assertEquals(44, matrix.getInRowMajorOrder(index), 0);
    }

    @Test
    public void getInRowMajorOrderWithInvalidIndex() {
        try {
            new Matrix().getInRowMajorOrder(-1);
            fail();
        } catch (IndexOutOfBoundsException e) {
            // expected.
        }

        try {
            new Matrix().getInRowMajorOrder(16);
            fail();
        } catch (IndexOutOfBoundsException e) {
            // expected.
        }
    }

    @Test
    public void getInColumnMajorOrder() {
        Matrix matrix = new Matrix(11, 12, 13, 14,
                                   21, 22, 23, 24,
                                   31, 32, 33, 34,
                                   41, 42, 43, 44);

        int index = 0;

        assertEquals(11, matrix.getInColumnMajorOrder(index++), 0);
        assertEquals(21, matrix.getInColumnMajorOrder(index++), 0);
        assertEquals(31, matrix.getInColumnMajorOrder(index++), 0);
        assertEquals(41, matrix.getInColumnMajorOrder(index++), 0);

        assertEquals(12, matrix.getInColumnMajorOrder(index++), 0);
        assertEquals(22, matrix.getInColumnMajorOrder(index++), 0);
        assertEquals(32, matrix.getInColumnMajorOrder(index++), 0);
        assertEquals(42, matrix.getInColumnMajorOrder(index++), 0);

        assertEquals(13, matrix.getInColumnMajorOrder(index++), 0);
        assertEquals(23, matrix.getInColumnMajorOrder(index++), 0);
        assertEquals(33, matrix.getInColumnMajorOrder(index++), 0);
        assertEquals(43, matrix.getInColumnMajorOrder(index++), 0);

        assertEquals(14, matrix.getInColumnMajorOrder(index++), 0);
        assertEquals(24, matrix.getInColumnMajorOrder(index++), 0);
        assertEquals(34, matrix.getInColumnMajorOrder(index++), 0);
        assertEquals(44, matrix.getInColumnMajorOrder(index), 0);
    }

    @Test
    public void getInColumnMajorOrderWithInvalidIndex() {
        try {
            new Matrix().getInColumnMajorOrder(-1);
            fail();
        } catch (IndexOutOfBoundsException e) {
            // expected.
        }

        try {
            new Matrix().getInColumnMajorOrder(16);
            fail();
        } catch (IndexOutOfBoundsException e) {
            // expected.
        }
    }

    @Test
    public void asZero() {
        Matrix matrix = new Matrix(9, 9, 9, 9,
                                   9, 9, 9, 9,
                                   9, 9, 9, 9,
                                   9, 9, 9, 9);
        Matrix expected = new Matrix();

        Matrix result = matrix.asZero();

        assertSame(matrix, result);
        assertEquals(expected, matrix);
    }

    @Test
    public void asIdentity() {
        Matrix matrix = new Matrix(9, 9, 9, 9,
                                   9, 9, 9, 9,
                                   9, 9, 9, 9,
                                   9, 9, 9, 9);
        Matrix expected = new Matrix(1, 0, 0, 0,
                                     0, 1, 0, 0,
                                     0, 0, 1, 0,
                                     0, 0, 0, 1);

        Matrix result = matrix.asIdentity();

        assertSame(matrix, result);
        assertEquals(expected, matrix);
    }

    @Test
    public void getTranslation() {
        Matrix matrix = new Matrix(0, 0, 0, 14,
                                   0, 0, 0, 24,
                                   0, 0, 0, 34,
                                   0, 0, 0, 0);

        Vector3 result = new Vector3();
        matrix.getTranslation(result);

        assertEquals(new Vector3(14, 24, 34), result);
    }

    @Test
    public void getTranslationWithNull() {
        try {
            new Matrix().getTranslation(null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void setTranslation() {
        Matrix matrix = new Matrix();
        Matrix expected = new Matrix(0, 0, 0, 14,
                                     0, 0, 0, 24,
                                     0, 0, 0, 34,
                                     0, 0, 0, 0);

        Matrix result = matrix.setTranslation(new Vector3(14, 24, 34));

        assertSame(matrix, result);
        assertEquals(expected, result);
    }

    @Test
    public void setTranslationWithNull() {
        try {
            new Matrix().setTranslation(null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void getRight() {
        Matrix matrix = new Matrix(11, 0, 0, 0,
                                   21, 0, 0, 0,
                                   31, 0, 0, 0,
                                   0, 0, 0, 0);

        Vector3 result = new Vector3();
        matrix.getRight(result);

        assertEquals(new Vector3(11, 21, 31), result);
    }

    @Test
    public void getRightWithNull() {
        try {
            new Matrix().getRight(null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void setRight() {
        Matrix matrix = new Matrix();
        Matrix expected = new Matrix(11, 0, 0, 0,
                                     12, 0, 0, 0,
                                     13, 0, 0, 0,
                                     0, 0, 0, 0);

        Matrix result = matrix.setRight(new Vector3(11, 12, 13));

        assertSame(matrix, result);
        assertEquals(expected, result);
    }

    @Test
    public void setRightWithNull() {
        try {
            new Matrix().setRight(null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void getLeft() {
        Matrix matrix = new Matrix(11, 0, 0, 0,
                                   21, 0, 0, 0,
                                   31, 0, 0, 0,
                                   0, 0, 0, 0);

        Vector3 result = new Vector3();
        matrix.getLeft(result);

        assertEquals(new Vector3(-11, -21, -31), result);
    }

    @Test
    public void getLeftWithNull() {
        try {
            new Matrix().getLeft(null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void setLeft() {
        Matrix matrix = new Matrix();
        Matrix expected = new Matrix(-11, 0, 0, 0,
                                     -12, 0, 0, 0,
                                     -13, 0, 0, 0,
                                     0, 0, 0, 0);

        Matrix result = matrix.setLeft(new Vector3(11, 12, 13));

        assertSame(matrix, result);
        assertEquals(expected, result);
    }

    @Test
    public void setLeftWithNull() {
        try {
            new Matrix().setLeft(null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void getDown() {
        Matrix matrix = new Matrix(0, 12, 0, 0,
                                   0, 22, 0, 0,
                                   0, 32, 0, 0,
                                   0, 0, 0, 0);

        Vector3 result = new Vector3();
        matrix.getDown(result);

        assertEquals(new Vector3(12, 22, 32), result);
    }

    @Test
    public void getDownWithNull() {
        try {
            new Matrix().getDown(null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void setDown() {
        Matrix matrix = new Matrix();
        Matrix expected = new Matrix(0, 12, 0, 0,
                                     0, 22, 0, 0,
                                     0, 32, 0, 0,
                                     0, 0, 0, 0);

        Matrix result = matrix.setDown(new Vector3(12, 22, 32));

        assertSame(matrix, result);
        assertEquals(expected, result);
    }

    @Test
    public void setDownWithNull() {
        try {
            new Matrix().setRight(null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void getUp() {
        Matrix matrix = new Matrix(0, 12, 0, 0,
                                   0, 22, 0, 0,
                                   0, 32, 0, 0,
                                   0, 0, 0, 0);

        Vector3 result = new Vector3();
        matrix.getUp(result);

        assertEquals(new Vector3(-12, -22, -32), result);
    }

    @Test
    public void getUpWithNull() {
        try {
            new Matrix().getUp(null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void setUp() {
        Matrix matrix = new Matrix();
        Matrix expected = new Matrix(0, -12, 0, 0,
                                     0, -22, 0, 0,
                                     0, -32, 0, 0,
                                     0, 0, 0, 0);

        Matrix result = matrix.setUp(new Vector3(12, 22, 32));

        assertSame(matrix, result);
        assertEquals(expected, result);
    }

    @Test
    public void setUpWithNull() {
        try {
            new Matrix().setUp(null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void getBackward() {
        Matrix matrix = new Matrix(0, 0, 13, 0,
                                   0, 0, 23, 0,
                                   0, 0, 33, 0,
                                   0, 0, 0, 0);

        Vector3 result = new Vector3();
        matrix.getBackward(result);

        assertEquals(new Vector3(13, 23, 33), result);
    }

    @Test
    public void getBackwardWithNull() {
        try {
            new Matrix().getBackward(null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void setBackward() {
        Matrix matrix = new Matrix();
        Matrix expected = new Matrix(0, 0, 13, 0,
                                     0, 0, 23, 0,
                                     0, 0, 33, 0,
                                     0, 0, 0, 0);

        Matrix result = matrix.setBackward(new Vector3(13, 23, 33));

        assertSame(matrix, result);
        assertEquals(expected, result);
    }

    @Test
    public void setBackwardWithNull() {
        try {
            new Matrix().setBackward(null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void getForward() {
        Matrix matrix = new Matrix(0, 0, 13, 0,
                                   0, 0, 23, 0,
                                   0, 0, 33, 0,
                                   0, 0, 0, 0);

        Vector3 result = new Vector3();
        matrix.getForward(result);

        assertEquals(new Vector3(-13, -23, -33), result);
    }

    @Test
    public void getForwardWithNull() {
        try {
            new Matrix().getForward(null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void setForward() {
        Matrix matrix = new Matrix();
        Matrix expected = new Matrix(0, 0, -13, 0,
                                     0, 0, -23, 0,
                                     0, 0, -33, 0,
                                     0, 0, 0, 0);

        Matrix result = matrix.setForward(new Vector3(13, 23, 33));

        assertSame(matrix, result);
        assertEquals(expected, result);
    }

    @Test
    public void setForwardWithNull() {
        try {
            new Matrix().setForward(null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void toArrayInRowMajorOrder() {
        float[] expected = {
                11, 12, 13, 14,
                21, 22, 23, 24,
                31, 32, 33, 34,
                41, 42, 43, 44
        };
        float[] result = new float[16];

        Matrix matrix = new Matrix();
        matrix.setInRowMajorOrder(expected);
        matrix.toArrayInRowMajorOrder(result);

        assertArrayEquals(expected, result, 0);
    }

    @Test
    public void toArrayInRowMajorOrderWithNull() {
        try {
            new Matrix().toArrayInRowMajorOrder(null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void toArrayInRowMajorOrderWithInvalidLengthArray() {
        try {
            new Matrix().toArrayInRowMajorOrder(new float[0]);
            fail();
        } catch (IllegalArgumentException e) {
            // expected.
        }

        try {
            new Matrix().toArrayInRowMajorOrder(new float[17]);
            fail();
        } catch (IllegalArgumentException e) {
            // expected.
        }
    }

    @Test
    public void toArrayInColumnMajorOrder() {
        float[] expected = {
                11, 21, 31, 41,
                12, 22, 32, 42,
                13, 23, 33, 43,
                14, 24, 34, 44
        };
        float[] result = new float[16];

        Matrix matrix = new Matrix();
        matrix.setInColumnMajorOrder(expected);
        matrix.toArrayInColumnMajorOrder(result);

        assertArrayEquals(expected, result, 0);
    }

    @Test
    public void toArrayInColumnMajorOrderWithNull() {
        try {
            new Matrix().toArrayInColumnMajorOrder(null);
            fail();
        } catch (ArgumentNullException e) {
            // expected.
        }
    }

    @Test
    public void toArrayInColumnMajorOrderWithInvalidLengthArray() {
        try {
            new Matrix().toArrayInColumnMajorOrder(new float[0]);
            fail();
        } catch (IllegalArgumentException e) {
            // expected.
        }

        try {
            new Matrix().toArrayInColumnMajorOrder(new float[17]);
            fail();
        } catch (IllegalArgumentException e) {
            // expected.
        }
    }

    @Test
    public void equals() {
        Matrix matrix1 = new Matrix(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        Matrix matrix2 = new Matrix(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        Matrix matrix3 = new Matrix(9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9);

        assertTrue(matrix1.equals(matrix1));
        assertTrue(matrix1.equals(matrix2));

        assertFalse(matrix1.equals(matrix3));
        assertFalse(matrix1.equals(null));
        assertFalse(matrix1.equals(new Object()));
    }

    @Test
    public void testHashCode() {
        Matrix matrix1 = new Matrix(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        Matrix matrix2 = new Matrix(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        Matrix matrix3 = new Matrix(9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9);

        assertTrue(matrix1.hashCode() == matrix2.hashCode());
        assertFalse(matrix1.hashCode() == matrix3.hashCode());
    }
}
