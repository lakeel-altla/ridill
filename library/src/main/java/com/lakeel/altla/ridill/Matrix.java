package com.lakeel.altla.ridill;

import com.lakeel.altla.ridill.pool.PoolableMatrix;
import com.lakeel.altla.ridill.pool.PoolableVector3;

import java.util.Objects;

/**
 * Defines a matrix.
 * Ridill uses column vectors when applying matrix multiplications.
 */
public class Matrix {

    public static final int ELEMENT_COUNT = 16;

    /**
     * The value at row 1 column 1 of the matrix.
     */
    public float m11;

    /**
     * The value at row 1 column 2 of the matrix.
     */
    public float m12;

    /**
     * The value at row 1 column 3 of the matrix.
     */
    public float m13;

    /**
     * The value at row 1 column 4 of the matrix.
     */
    public float m14;

    /**
     * The value at row 2 column 1 of the matrix.
     */
    public float m21;

    /**
     * The value at row 2 column 2 of the matrix.
     */
    public float m22;

    /**
     * The value at row 2 column 3 of the matrix.
     */
    public float m23;

    /**
     * The value at row 2 column 4 of the matrix.
     */
    public float m24;

    /**
     * The value at row 3 column 1 of the matrix.
     */
    public float m31;

    /**
     * The value at row 3 column 2 of the matrix.
     */
    public float m32;

    /**
     * The value at row 3 column 3 of the matrix.
     */
    public float m33;

    /**
     * The value at row 3 column 4 of the matrix.
     */
    public float m34;

    /**
     * The value at row 4 column 1 of the matrix.
     */
    public float m41;

    /**
     * The value at row 4 column 2 of the matrix.
     */
    public float m42;

    /**
     * The value at row 4 column 3 of the matrix.
     */
    public float m43;

    /**
     * The value at row 4 column 4 of the matrix.
     */
    public float m44;

    /**
     * Initializes a new instance of Matrix.
     */
    public Matrix() {
    }

    /**
     * Initializes a new instance of Matrix.
     *
     * @param m11 The value to assign at row 1 column 1 of the matrix.
     * @param m12 The value to assign at row 1 column 2 of the matrix.
     * @param m13 The value to assign at row 1 column 3 of the matrix.
     * @param m14 The value to assign at row 1 column 4 of the matrix.
     * @param m21 The value to assign at row 2 column 1 of the matrix.
     * @param m22 The value to assign at row 2 column 2 of the matrix.
     * @param m23 The value to assign at row 2 column 3 of the matrix.
     * @param m24 The value to assign at row 2 column 4 of the matrix.
     * @param m31 The value to assign at row 3 column 1 of the matrix.
     * @param m32 The value to assign at row 3 column 2 of the matrix.
     * @param m33 The value to assign at row 3 column 3 of the matrix.
     * @param m34 The value to assign at row 3 column 4 of the matrix.
     * @param m41 The value to assign at row 4 column 1 of the matrix.
     * @param m42 The value to assign at row 4 column 2 of the matrix.
     * @param m43 The value to assign at row 4 column 3 of the matrix.
     * @param m44 The value to assign at row 4 column 4 of the matrix.
     */
    public Matrix(float m11, float m12, float m13, float m14,
                  float m21, float m22, float m23, float m24,
                  float m31, float m32, float m33, float m34,
                  float m41, float m42, float m43, float m44) {
        this.m11 = m11;
        this.m12 = m12;
        this.m13 = m13;
        this.m14 = m14;
        this.m21 = m21;
        this.m22 = m22;
        this.m23 = m23;
        this.m24 = m24;
        this.m31 = m31;
        this.m32 = m32;
        this.m33 = m33;
        this.m34 = m34;
        this.m41 = m41;
        this.m42 = m42;
        this.m43 = m43;
        this.m44 = m44;
    }

    public static Matrix createIdentity() {
        Matrix matrix = new Matrix();
        matrix.m11 = 1;
        matrix.m22 = 1;
        matrix.m33 = 1;
        matrix.m44 = 1;
        return matrix;
    }

    /**
     * Creates a translation matrix.
     *
     * @param x      The value to translate by on the x-axis.
     * @param y      The value to translate by on the y-axis.
     * @param z      The value to translate by on the z-axis.
     * @param result The matrix that holds the result.
     */
    public static void createTranslation(float x, float y, float z, Matrix result) {
        if (result == null) throw new ArgumentNullException("result");

        result.set(1, 0, 0, x,
                   0, 1, 0, y,
                   0, 0, 1, z,
                   0, 0, 0, 1);
    }

    /**
     * Creates a translation matrix.
     *
     * @param position Values to translate by on the x, y, and z axes.
     * @param result   The matrix that holds the result.
     */
    public static void createTranslation(Vector3 position, Matrix result) {
        if (position == null) throw new ArgumentNullException("position");
        if (result == null) throw new ArgumentNullException("result");

        createTranslation(position.x, position.y, position.z, result);
    }

    /**
     * Creates a scale matrix.
     *
     * @param x      The value to scale by on the x-axis.
     * @param y      The value to scale by on the y-axis.
     * @param z      The value to scale by on the z-axis.
     * @param result The matrix that holds the result.
     */
    public static void createScale(float x, float y, float z, Matrix result) {
        if (result == null) throw new ArgumentNullException("result");

        result.set(x, 0, 0, 0,
                   0, y, 0, 0,
                   0, 0, z, 0,
                   0, 0, 0, 1);
    }

    /**
     * Creates a scale matrix.
     *
     * @param scale  Values to scale by on the x, y, and z axes.
     * @param result The matrix that holds the result.
     */
    public static void createScale(Vector3 scale, Matrix result) {
        if (scale == null) throw new ArgumentNullException("scale");
        if (result == null) throw new ArgumentNullException("result");

        createScale(scale.x, scale.y, scale.z, result);
    }

    /**
     * Creates a scale matrix.
     *
     * @param scale  The value to scale by.
     * @param result The matrix that holds the result.
     */
    public static void createScale(float scale, Matrix result) {
        if (result == null) throw new ArgumentNullException("result");

        createScale(scale, scale, scale, result);
    }

    /**
     * Creates a matrix that rotates around the x-axis.
     *
     * @param radians The angle to rotate around the x-axis.
     * @param result  The matrix that holds the result.
     */
    public static void createRotationX(float radians, Matrix result) {
        if (result == null) throw new ArgumentNullException("result");

        float cos = (float) Math.cos(radians);
        float sin = (float) Math.sin(radians);

        result.set(1, 0, 0, 0,
                   0, cos, -sin, 0,
                   0, sin, cos, 0,
                   0, 0, 0, 1);
    }

    /**
     * Creates a matrix that rotates around the y-axis.
     *
     * @param radians The angle to rotate around the y-axis.
     * @param result  The matrix that holds the result.
     */
    public static void createRotationY(float radians, Matrix result) {
        if (result == null) throw new ArgumentNullException("result");

        float cos = (float) Math.cos(radians);
        float sin = (float) Math.sin(radians);

        result.set(cos, 0, sin, 0,
                   0, 1, 0, 0,
                   -sin, 0, cos, 0,
                   0, 0, 0, 1);
    }

    /**
     * Creates a matrix that rotates around the z-axis.
     *
     * @param radians The angle to rotate around the z-axis.
     * @param result  The matrix that holds the result.
     */
    public static void createRotationZ(float radians, Matrix result) {
        if (result == null) throw new ArgumentNullException("result");

        float cos = (float) Math.cos(radians);
        float sin = (float) Math.sin(radians);

        result.set(cos, -sin, 0, 0,
                   sin, cos, 0, 0,
                   0, 0, 1, 0,
                   0, 0, 0, 1);
    }

    /**
     * Creates a matrix that rotates around an arbitrary vector.
     *
     * @param axis    The axis to rotate around.
     * @param radians The angle to rotate around the vector.
     * @param result  The matrix that holds the result.
     */
    public static void createFromAxisAngle(Vector3 axis, float radians, Matrix result) {
        if (axis == null) throw new ArgumentNullException("axis");
        if (result == null) throw new ArgumentNullException("result");

        float x = axis.x;
        float y = axis.y;
        float z = axis.z;
        float cos = (float) Math.cos(radians);
        float sin = (float) Math.sin(radians);
        float xx = x * x;
        float yy = y * y;
        float zz = z * z;
        float xy = x * y;
        float xz = x * z;
        float yz = y * z;

        float m11 = xx + (cos * (1.0f - xx));
        float m12 = (xy - (cos * xy)) - (sin * z);
        float m13 = (xz - (cos * xz)) + (sin * y);
        float m21 = (xy - (cos * xy)) + (sin * z);
        float m22 = yy + (cos * (1.0f - yy));
        float m23 = (yz - (cos * yz)) - (sin * x);
        float m31 = (xz - (cos * xz)) - (sin * y);
        float m32 = (yz - (cos * yz)) + (sin * x);
        float m33 = zz + (cos * (1.0f - zz));

        result.set(m11, m12, m13, 0,
                   m21, m22, m23, 0,
                   m31, m32, m33, 0,
                   0, 0, 0, 1);
    }

    /**
     * Creates a rotation matrix from a quaternion.
     *
     * @param quaternion The quaternion to create the matrix from.
     * @param result     The matrix that holds the result.
     */
    public static void createFromQuaternion(Quaternion quaternion, Matrix result) {
        if (quaternion == null) throw new ArgumentNullException("quaternion");
        if (result == null) throw new ArgumentNullException("result");

        // (1.0f - 2.0f*qy*qy - 2.0f*qz*qz, 2.0f*qx*qy - 2.0f*qz*qw,        2.0f*qx*qz + 2.0f*qy*qw,        0.0f,
        //  2.0f*qx*qy + 2.0f*qz*qw,        1.0f - 2.0f*qx*qx - 2.0f*qz*qz, 2.0f*qy*qz - 2.0f*qx*qw,        0.0f,
        //  2.0f*qx*qz - 2.0f*qy*qw,        2.0f*qy*qz + 2.0f*qx*qw,        1.0f - 2.0f*qx*qx - 2.0f*qy*qy, 0.0f,
        //  0.0f,                           0.0f,                           0.0f,                           1.0f)

        float xx = quaternion.x * quaternion.x;
        float yy = quaternion.y * quaternion.y;
        float zz = quaternion.z * quaternion.z;
        float xy = quaternion.x * quaternion.y;
        float zw = quaternion.z * quaternion.w;
        float zx = quaternion.z * quaternion.x;
        float yw = quaternion.y * quaternion.w;
        float yz = quaternion.y * quaternion.z;
        float xw = quaternion.x * quaternion.w;

        float m11 = 1.0f - (2.0f * (yy + zz));
        float m12 = 2.0f * (xy - zw);
        float m13 = 2.0f * (zx + yw);
        float m21 = 2.0f * (xy + zw);
        float m22 = 1.0f - (2.0f * (zz + xx));
        float m23 = 2.0f * (yz - xw);
        float m31 = 2.0f * (zx - yw);
        float m32 = 2.0f * (yz + xw);
        float m33 = 1.0f - (2.0f * (yy + xx));

        result.set(m11, m12, m13, 0,
                   m21, m22, m23, 0,
                   m31, m32, m33, 0,
                   0, 0, 0, 1);
    }

    /**
     * Creates a look-at matrix.
     *
     * @param position The position of a camera.
     * @param target   The look-at target of a camera.
     * @param up       The up vector of a camera.
     * @param result   The matrix that holds the result.
     */
    public static void createLookAt(Vector3 position, Vector3 target, Vector3 up, Matrix result) {
        if (position == null) throw new ArgumentNullException("position");
        if (target == null) throw new ArgumentNullException("target");
        if (up == null) throw new ArgumentNullException("up");
        if (result == null) throw new ArgumentNullException("result");

        try (PoolableVector3 xaxis = PoolableVector3.get();
             PoolableVector3 yaxis = PoolableVector3.get();
             PoolableVector3 zaxis = PoolableVector3.get()) {

            Vector3.subtract(position, target, zaxis);
            zaxis.normalize();

            Vector3.cross(up, zaxis, xaxis);
            xaxis.normalize();

            Vector3.cross(zaxis, xaxis, yaxis);
            yaxis.normalize();

            result.asIdentity();

            result.m11 = xaxis.x;
            result.m21 = xaxis.y;
            result.m31 = xaxis.z;

            result.m12 = yaxis.x;
            result.m22 = yaxis.y;
            result.m32 = yaxis.z;

            result.m13 = zaxis.x;
            result.m23 = zaxis.y;
            result.m33 = zaxis.z;

            result.m14 = -Vector3.dot(xaxis, position);
            result.m24 = -Vector3.dot(yaxis, position);
            result.m34 = -Vector3.dot(zaxis, position);
        }
    }

    /**
     * Creates a perspective projection matrix.
     *
     * @param left   The minimum x-value of the view volume at the near view plane.
     * @param right  The maximum x-value of the view volume at the near view plane.
     * @param bottom The minimum y-value of the view volume at the near view plane.
     * @param top    The maximum y-value of the view volume at the near view plane.
     * @param near   The distance to the near view plane.
     * @param far    The istance to of the far view plane.
     * @param result The matrix that holds the result.
     */
    public static void createPerspectiveOffCenter(float left, float right, float bottom, float top,
                                                  float near, float far, Matrix result) {
        if (result == null) throw new ArgumentNullException("result");

        // glFrustum code:
        // | 2n / (r - l),            0,  (r + l) / (r - l),              0 |
        // |            0, 2n / (t - b),  (t + b) / (t - b),              0 |
        // |            0,            0, -(f + n) / (f - n), -2fn / (f - n) |
        // |            0,            0,                 -1,              0 |

        float invWidth = 1.0f / (right - left);
        float invHeight = 1.0f / (top - bottom);
        float invDepth = 1.0f / (far - near);

        float m11 = 2.0f * near * invWidth;
        float m13 = (right + left) * invWidth;
        float m22 = 2.0f * near * invHeight;
        float m23 = (top + bottom) * invHeight;
        float m33 = -(far + near) * invDepth;
        float m34 = -(2.0f * far * near) * invDepth;
        float m43 = -1.0f;

        result.set(m11, 0, m13, 0,
                   0, m22, m23, 0,
                   0, 0, m33, m34,
                   0, 0, m43, 0);
    }

    /**
     * Creates a perspective projection matrix.
     *
     * @param width  The width of the view volume at the near view plane.
     * @param height The height of the view volume at the near view plane.
     * @param near   The distance to the near view plane.
     * @param far    The istance to of the far view plane.
     * @param result The matrix that holds the result.
     */
    public static void createPerspective(float width, float height, float near, float far, Matrix result) {
        if (result == null) throw new ArgumentNullException("result");

        // equals to createPerspectiveOffCenter(-w/2, w/2, -h/2, h/2, n, f)

        float invWidth = 1.0f / width;
        float invHeight = 1.0f / height;
        float invDepth = 1.0f / (far - near);

        float m11 = (2.0f * near) * invWidth;
        float m22 = (2.0f * near) * invHeight;
        float m33 = -(far + near) * invDepth;
        float m34 = -(2.0f * far * near) * invDepth;
        float m43 = -1.0f;

        result.set(m11, 0, 0, 0,
                   0, m22, 0, 0,
                   0, 0, m33, m34,
                   0, 0, m43, 0);
    }

    /**
     * Creates a perspective projection matrix based on a field of view.
     *
     * @param fov         The field of view in the y direction, in radians.
     * @param aspectRatio The aspect ratio, defined as view space width divided by height.
     * @param near        The distance to the near view plane.
     * @param far         The istance to of the far view plane.
     * @param result      The matrix that holds the result.
     */
    public static void createPerspectiveFieldOfView(float fov, float aspectRatio, float near, float far,
                                                    Matrix result) {
        if (result == null) throw new ArgumentNullException("result");

        // yScale = 1/tan(fov/2)
        // xScale = yScale/aspectRatio
        // w = 2*n/xScale
        // h = 2*n/yScale
        // equals to createPerspectiveOffCenter(-w/2, w/2, -h/2, h/2, n, f)

        float yScale = (float) (1.0f / Math.tan(fov * 0.5f));
        float xScale = yScale / aspectRatio;
        float invDepth = 1.0f / (far - near);

        float m11 = xScale;
        float m22 = yScale;
        float m33 = -(far + near) * invDepth;
        float m34 = -(2.0f * far * near) * invDepth;
        float m43 = -1.0f;

        result.set(m11, 0, 0, 0,
                   0, m22, 0, 0,
                   0, 0, m33, m34,
                   0, 0, m43, 0);
    }

    /**
     * Creates an orthogonal projection matrix.
     *
     * @param left   The minimum x-value of the view volume at the near view plane.
     * @param right  The maximum x-value of the view volume at the near view plane.
     * @param bottom The minimum y-value of the view volume at the near view plane.
     * @param top    The maximum y-value of the view volume at the near view plane.
     * @param near   The distance to the near view plane.
     * @param far    The istance to of the far view plane.
     * @param result The matrix that holds the result.
     */
    public static void createOrthographicOffCenter(float left, float right, float bottom, float top,
                                                   float near, float far, Matrix result) {
        if (result == null) throw new ArgumentNullException("result");

        // glOrtho code:
        // | 2 / (r - l),           0,            0, (r + l) / (r - l) |
        // |           0, 2 / (t - b),            0, (t + b) / (t - b) |
        // |           0,           0, -2 / (f - n), (f + n) / (f - n) |
        // |           0,           0,            0,                 1 |

        float invWidth = 1.0f / (right - left);
        float invHeight = 1.0f / (top - bottom);
        float invDepth = 1.0f / (far - near);

        float m11 = 2.0f * invWidth;
        float m14 = (right + left) * invWidth;
        float m22 = 2.0f * invHeight;
        float m24 = (top + bottom) * invHeight;
        float m33 = -2.0f * invDepth;
        float m34 = (far + near) * invDepth;
        float m44 = 1.0f;

        result.set(m11, 0, 0, m14,
                   0, m22, 0, m24,
                   0, 0, m33, m34,
                   0, 0, 0, m44);
    }

    /**
     * Creates an orthogonal projection matrix.
     *
     * @param width  The width of the view volume at the near view plane.
     * @param height The height of the view volume at the near view plane.
     * @param near   The distance to the near view plane.
     * @param far    The istance to of the far view plane.
     * @param result The matrix that holds the result.
     */
    public static void createOrthographic(float width, float height, float near, float far, Matrix result) {
        if (result == null) throw new ArgumentNullException("result");

        // equals to createOrthographicOffCenter(-w/2, w/2, -h/2, h/2, n, f).

        float invDepth = 1.0f / (far - near);

        float m11 = 2.0f / width;
        float m22 = 2.0f / height;
        float m33 = -2.0f * invDepth;
        float m34 = (far + near) * invDepth;
        float m44 = 1.0f;

        result.set(m11, 0, 0, 0,
                   0, m22, 0, 0,
                   0, 0, m33, m34,
                   0, 0, 0, m44);
    }

    /**
     * Extracts the scalar, translation, and rotation components from a scale/rotate/translate Matrix.
     *
     * @param scale       The scalar component of the transform matrix.
     * @param rotation    The rotation component of the transform matrix.
     * @param translation The translation component of the transform matrix.
     * @return true if the Matrix can be decomposed; false otherwise.
     */
    public boolean decompose(Vector3 scale, Quaternion rotation, Vector3 translation) {
        if (scale == null) throw new ArgumentNullException("scale");
        if (rotation == null) throw new ArgumentNullException("rotation");
        if (translation == null) throw new ArgumentNullException("translation");

        translation.set(m14, m24, m34);

        //Scaling is the length of the rows.
        scale.x = (float) Math.sqrt((m11 * m11) + (m21 * m21) + (m31 * m31));
        scale.y = (float) Math.sqrt((m12 * m12) + (m22 * m22) + (m32 * m32));
        scale.z = (float) Math.sqrt((m13 * m13) + (m23 * m23) + (m33 * m33));

        //If any of the scaling factors are zero, than the rotation Matrix can not exist.
        if (Math.abs(scale.x) == 0 || Math.abs(scale.y) == 0 || Math.abs(scale.z) == 0) {
            rotation.asIdentity();
            return false;
        }

        //The rotation is the left over Matrix after dividing out the scaling.
        try (PoolableMatrix rotationMatrix = PoolableMatrix.get()) {
            rotationMatrix.m11 = m11 / scale.x;
            rotationMatrix.m21 = m21 / scale.x;
            rotationMatrix.m31 = m31 / scale.x;

            rotationMatrix.m12 = m12 / scale.y;
            rotationMatrix.m22 = m22 / scale.y;
            rotationMatrix.m32 = m32 / scale.y;

            rotationMatrix.m13 = m13 / scale.z;
            rotationMatrix.m23 = m23 / scale.z;
            rotationMatrix.m33 = m33 / scale.z;

            rotationMatrix.m44 = 1f;

            Quaternion.createFromRotationMatrix(rotationMatrix, rotation);
        }

        return true;
    }

    /**
     * Adds two matrices.
     *
     * @param left   The first source matrix.
     * @param right  The second source matrix.
     * @param result The matrix that holds the result.
     */
    public static void add(Matrix left, Matrix right, Matrix result) {
        if (left == null) throw new ArgumentNullException("left");
        if (right == null) throw new ArgumentNullException("right");
        if (result == null) throw new ArgumentNullException("result");

        result.m11 = left.m11 + right.m11;
        result.m12 = left.m12 + right.m12;
        result.m13 = left.m13 + right.m13;
        result.m14 = left.m14 + right.m14;
        result.m21 = left.m21 + right.m21;
        result.m22 = left.m22 + right.m22;
        result.m23 = left.m23 + right.m23;
        result.m24 = left.m24 + right.m24;
        result.m31 = left.m31 + right.m31;
        result.m32 = left.m32 + right.m32;
        result.m33 = left.m33 + right.m33;
        result.m34 = left.m34 + right.m34;
        result.m41 = left.m41 + right.m41;
        result.m42 = left.m42 + right.m42;
        result.m43 = left.m43 + right.m43;
        result.m44 = left.m44 + right.m44;
    }

    /**
     * Subtracts two matrices.
     *
     * @param left   The first source matrix.
     * @param right  The second source matrix.
     * @param result The matrix that holds the result.
     */
    public static void subtract(Matrix left, Matrix right, Matrix result) {
        if (left == null) throw new ArgumentNullException("left");
        if (right == null) throw new ArgumentNullException("right");
        if (result == null) throw new ArgumentNullException("result");

        result.m11 = left.m11 - right.m11;
        result.m12 = left.m12 - right.m12;
        result.m13 = left.m13 - right.m13;
        result.m14 = left.m14 - right.m14;
        result.m21 = left.m21 - right.m21;
        result.m22 = left.m22 - right.m22;
        result.m23 = left.m23 - right.m23;
        result.m24 = left.m24 - right.m24;
        result.m31 = left.m31 - right.m31;
        result.m32 = left.m32 - right.m32;
        result.m33 = left.m33 - right.m33;
        result.m34 = left.m34 - right.m34;
        result.m41 = left.m41 - right.m41;
        result.m42 = left.m42 - right.m42;
        result.m43 = left.m43 - right.m43;
        result.m44 = left.m44 - right.m44;
    }

    /**
     * Multiplies two matrices.
     *
     * @param left   The first source matrix.
     * @param right  The second source matrix.
     * @param result The matrix that holds the result.
     */
    public static void multiply(Matrix left, Matrix right, Matrix result) {
        if (left == null) throw new ArgumentNullException("left");
        if (right == null) throw new ArgumentNullException("right");
        if (result == null) throw new ArgumentNullException("result");

        result.m11 = (left.m11 * right.m11) + (left.m12 * right.m21) + (left.m13 * right.m31) + (left.m14 * right.m41);
        result.m12 = (left.m11 * right.m12) + (left.m12 * right.m22) + (left.m13 * right.m32) + (left.m14 * right.m42);
        result.m13 = (left.m11 * right.m13) + (left.m12 * right.m23) + (left.m13 * right.m33) + (left.m14 * right.m43);
        result.m14 = (left.m11 * right.m14) + (left.m12 * right.m24) + (left.m13 * right.m34) + (left.m14 * right.m44);
        result.m21 = (left.m21 * right.m11) + (left.m22 * right.m21) + (left.m23 * right.m31) + (left.m24 * right.m41);
        result.m22 = (left.m21 * right.m12) + (left.m22 * right.m22) + (left.m23 * right.m32) + (left.m24 * right.m42);
        result.m23 = (left.m21 * right.m13) + (left.m22 * right.m23) + (left.m23 * right.m33) + (left.m24 * right.m43);
        result.m24 = (left.m21 * right.m14) + (left.m22 * right.m24) + (left.m23 * right.m34) + (left.m24 * right.m44);
        result.m31 = (left.m31 * right.m11) + (left.m32 * right.m21) + (left.m33 * right.m31) + (left.m34 * right.m41);
        result.m32 = (left.m31 * right.m12) + (left.m32 * right.m22) + (left.m33 * right.m32) + (left.m34 * right.m42);
        result.m33 = (left.m31 * right.m13) + (left.m32 * right.m23) + (left.m33 * right.m33) + (left.m34 * right.m43);
        result.m34 = (left.m31 * right.m14) + (left.m32 * right.m24) + (left.m33 * right.m34) + (left.m34 * right.m44);
        result.m41 = (left.m41 * right.m11) + (left.m42 * right.m21) + (left.m43 * right.m31) + (left.m44 * right.m41);
        result.m42 = (left.m41 * right.m12) + (left.m42 * right.m22) + (left.m43 * right.m32) + (left.m44 * right.m42);
        result.m43 = (left.m41 * right.m13) + (left.m42 * right.m23) + (left.m43 * right.m33) + (left.m44 * right.m43);
        result.m44 = (left.m41 * right.m14) + (left.m42 * right.m24) + (left.m43 * right.m34) + (left.m44 * right.m44);
    }

    /**
     * Multiplies the matrix by the column vector.
     *
     * @param left   The source matrix.
     * @param right  The source column vector.
     * @param result The column vector that holds the result.
     */
    public static void multiply(Matrix left, Vector4 right, Vector4 result) {
        if (left == null) throw new ArgumentNullException("left");
        if (right == null) throw new ArgumentNullException("right");
        if (result == null) throw new ArgumentNullException("result");

        result.x = (left.m11 * right.x) + (left.m12 * right.y) + (left.m13 * right.z) + (left.m14 * right.w);
        result.y = (left.m21 * right.x) + (left.m22 * right.y) + (left.m23 * right.z) + (left.m24 * right.w);
        result.z = (left.m31 * right.x) + (left.m32 * right.y) + (left.m33 * right.z) + (left.m34 * right.w);
        result.w = (left.m41 * right.x) + (left.m42 * right.y) + (left.m43 * right.z) + (left.m44 * right.w);
    }

    /**
     * Calculates the transpose of a matrix.
     *
     * @param value  The source matrix.
     * @param result The matrix that holds the result.
     */
    public static void transpose(Matrix value, Matrix result) {
        if (value == null) throw new ArgumentNullException("value");
        if (result == null) throw new ArgumentNullException("result");

        result.m11 = value.m11;
        result.m12 = value.m21;
        result.m13 = value.m31;
        result.m14 = value.m41;
        result.m21 = value.m12;
        result.m22 = value.m22;
        result.m23 = value.m32;
        result.m24 = value.m42;
        result.m31 = value.m13;
        result.m32 = value.m23;
        result.m33 = value.m33;
        result.m34 = value.m43;
        result.m41 = value.m14;
        result.m42 = value.m24;
        result.m43 = value.m34;
        result.m44 = value.m44;
    }

    /**
     * Calculates the inverse of a matrix.
     *
     * @param value  The source matrix.
     * @param result The matrix that holds the result.
     */
    public static void invert(Matrix value, Matrix result) {
        if (value == null) throw new ArgumentNullException("value");
        if (result == null) throw new ArgumentNullException("result");

        float b0 = (value.m31 * value.m42) - (value.m32 * value.m41);
        float b1 = (value.m31 * value.m43) - (value.m33 * value.m41);
        float b2 = (value.m34 * value.m41) - (value.m31 * value.m44);
        float b3 = (value.m32 * value.m43) - (value.m33 * value.m42);
        float b4 = (value.m34 * value.m42) - (value.m32 * value.m44);
        float b5 = (value.m33 * value.m44) - (value.m34 * value.m43);

        float d11 = value.m22 * b5 + value.m23 * b4 + value.m24 * b3;
        float d12 = value.m21 * b5 + value.m23 * b2 + value.m24 * b1;
        float d13 = value.m21 * -b4 + value.m22 * b2 + value.m24 * b0;
        float d14 = value.m21 * b3 + value.m22 * -b1 + value.m23 * b0;

        float det = value.m11 * d11 - value.m12 * d12 + value.m13 * d13 - value.m14 * d14;
        if (Math.abs(det) == 0.0f) {
            result.asZero();
            return;
        }

        det = 1f / det;

        float a0 = (value.m11 * value.m22) - (value.m12 * value.m21);
        float a1 = (value.m11 * value.m23) - (value.m13 * value.m21);
        float a2 = (value.m14 * value.m21) - (value.m11 * value.m24);
        float a3 = (value.m12 * value.m23) - (value.m13 * value.m22);
        float a4 = (value.m14 * value.m22) - (value.m12 * value.m24);
        float a5 = (value.m13 * value.m24) - (value.m14 * value.m23);

        float d21 = value.m12 * b5 + value.m13 * b4 + value.m14 * b3;
        float d22 = value.m11 * b5 + value.m13 * b2 + value.m14 * b1;
        float d23 = value.m11 * -b4 + value.m12 * b2 + value.m14 * b0;
        float d24 = value.m11 * b3 + value.m12 * -b1 + value.m13 * b0;

        float d31 = value.m42 * a5 + value.m43 * a4 + value.m44 * a3;
        float d32 = value.m41 * a5 + value.m43 * a2 + value.m44 * a1;
        float d33 = value.m41 * -a4 + value.m42 * a2 + value.m44 * a0;
        float d34 = value.m41 * a3 + value.m42 * -a1 + value.m43 * a0;

        float d41 = value.m32 * a5 + value.m33 * a4 + value.m34 * a3;
        float d42 = value.m31 * a5 + value.m33 * a2 + value.m34 * a1;
        float d43 = value.m31 * -a4 + value.m32 * a2 + value.m34 * a0;
        float d44 = value.m31 * a3 + value.m32 * -a1 + value.m33 * a0;

        result.m11 = +d11 * det;
        result.m12 = -d21 * det;
        result.m13 = +d31 * det;
        result.m14 = -d41 * det;
        result.m21 = -d12 * det;
        result.m22 = +d22 * det;
        result.m23 = -d32 * det;
        result.m24 = +d42 * det;
        result.m31 = +d13 * det;
        result.m32 = -d23 * det;
        result.m33 = +d33 * det;
        result.m34 = -d43 * det;
        result.m41 = -d14 * det;
        result.m42 = +d24 * det;
        result.m43 = -d34 * det;
        result.m44 = +d44 * det;
    }

    /**
     * Sets the elements of the specified matrix into this ones.
     *
     * @param value The source matrix.
     * @return This instance.
     */
    public Matrix set(Matrix value) {
        if (value == null) throw new ArgumentNullException("value");

        m11 = value.m11;
        m12 = value.m12;
        m13 = value.m13;
        m14 = value.m14;
        m21 = value.m21;
        m22 = value.m22;
        m23 = value.m23;
        m24 = value.m24;
        m31 = value.m31;
        m32 = value.m32;
        m33 = value.m33;
        m34 = value.m34;
        m41 = value.m41;
        m42 = value.m42;
        m43 = value.m43;
        m44 = value.m44;

        return this;
    }

    /**
     * Sets elements.
     *
     * @param m11 The value to assign at row 1 column 1 of the matrix.
     * @param m12 The value to assign at row 1 column 2 of the matrix.
     * @param m13 The value to assign at row 1 column 3 of the matrix.
     * @param m14 The value to assign at row 1 column 4 of the matrix.
     * @param m21 The value to assign at row 2 column 1 of the matrix.
     * @param m22 The value to assign at row 2 column 2 of the matrix.
     * @param m23 The value to assign at row 2 column 3 of the matrix.
     * @param m24 The value to assign at row 2 column 4 of the matrix.
     * @param m31 The value to assign at row 3 column 1 of the matrix.
     * @param m32 The value to assign at row 3 column 2 of the matrix.
     * @param m33 The value to assign at row 3 column 3 of the matrix.
     * @param m34 The value to assign at row 3 column 4 of the matrix.
     * @param m41 The value to assign at row 4 column 1 of the matrix.
     * @param m42 The value to assign at row 4 column 2 of the matrix.
     * @param m43 The value to assign at row 4 column 3 of the matrix.
     * @param m44 The value to assign at row 4 column 4 of the matrix.
     * @return This instance.
     */
    public Matrix set(float m11, float m12, float m13, float m14,
                      float m21, float m22, float m23, float m24,
                      float m31, float m32, float m33, float m34,
                      float m41, float m42, float m43, float m44) {
        this.m11 = m11;
        this.m12 = m12;
        this.m13 = m13;
        this.m14 = m14;
        this.m21 = m21;
        this.m22 = m22;
        this.m23 = m23;
        this.m24 = m24;
        this.m31 = m31;
        this.m32 = m32;
        this.m33 = m33;
        this.m34 = m34;
        this.m41 = m41;
        this.m42 = m42;
        this.m43 = m43;
        this.m44 = m44;

        return this;
    }

    /**
     * Sets values in row-major order.
     *
     * @param values The values in row-major order.
     * @return This instance.
     */
    public Matrix setInRowMajorOrder(float[] values) {
        if (values == null) throw new ArgumentNullException("values");
        if (values.length != ELEMENT_COUNT) {
            throw new IllegalArgumentException("'values' must be an array of length 16.");
        }

        m11 = values[0];
        m12 = values[1];
        m13 = values[2];
        m14 = values[3];

        m21 = values[4];
        m22 = values[5];
        m23 = values[6];
        m24 = values[7];

        m31 = values[8];
        m32 = values[9];
        m33 = values[10];
        m34 = values[11];

        m41 = values[12];
        m42 = values[13];
        m43 = values[14];
        m44 = values[15];

        return this;
    }

    /**
     * Sets values in column-major order.
     *
     * @param values The values in column-major order.
     * @return This instance.
     */
    public Matrix setInColumnMajorOrder(float[] values) {
        if (values == null) throw new ArgumentNullException("values");
        if (values.length != ELEMENT_COUNT) {
            throw new IllegalArgumentException("'values' must be an array of length 16.");
        }

        m11 = values[0];
        m21 = values[1];
        m31 = values[2];
        m41 = values[3];

        m12 = values[4];
        m22 = values[5];
        m32 = values[6];
        m42 = values[7];

        m13 = values[8];
        m23 = values[9];
        m33 = values[10];
        m43 = values[11];

        m14 = values[12];
        m24 = values[13];
        m34 = values[14];
        m44 = values[15];

        return this;
    }

    /**
     * Sets 0 into all elements.
     *
     * @return This instance.
     */
    public Matrix asZero() {
        return set(0, 0, 0, 0,
                   0, 0, 0, 0,
                   0, 0, 0, 0,
                   0, 0, 0, 0);
    }

    /**
     * Sets elements of the identity matrix.
     *
     * @return This instance.
     */
    public Matrix asIdentity() {
        return set(1, 0, 0, 0,
                   0, 1, 0, 0,
                   0, 0, 1, 0,
                   0, 0, 0, 1);
    }

    /**
     * Gets the translation vector.
     *
     * @param result The vector that holds the result.
     */
    public void getTranslation(Vector3 result) {
        if (result == null) throw new ArgumentNullException("result");

        result.set(m14, m24, m34);
    }

    /**
     * Sets the translation vector.
     *
     * @param value The translation vector.
     * @return This instance.
     */
    public Matrix setTranslation(Vector3 value) {
        if (value == null) throw new ArgumentNullException("value");

        m14 = value.x;
        m24 = value.y;
        m34 = value.z;

        return this;
    }

    /**
     * Gets the right vector.
     *
     * @param result The vector that holds the result.
     */
    public void getRight(Vector3 result) {
        if (result == null) throw new ArgumentNullException("result");

        result.set(m11, m21, m31);
    }

    /**
     * Sets the right vector.
     *
     * @param value The right vector.
     * @return This instance.
     */
    public Matrix setRight(Vector3 value) {
        if (value == null) throw new ArgumentNullException("value");

        m11 = value.x;
        m21 = value.y;
        m31 = value.z;

        return this;
    }

    /**
     * Gets the left vector.
     *
     * @param result The vector that holds the result.
     */
    public void getLeft(Vector3 result) {
        if (result == null) throw new ArgumentNullException("result");

        result.set(-m11, -m21, -m31);
    }

    /**
     * Sets the left vector.
     *
     * @param value The left vector.
     * @return This instance.
     */
    public Matrix setLeft(Vector3 value) {
        if (value == null) throw new ArgumentNullException("value");

        m11 = -value.x;
        m21 = -value.y;
        m31 = -value.z;

        return this;
    }

    /**
     * Gets the down vector.
     *
     * @param result The vector that holds the result.
     */
    public void getDown(Vector3 result) {
        if (result == null) throw new ArgumentNullException("result");

        result.set(m12, m22, m32);
    }

    /**
     * Sets the down vector.
     *
     * @param value The down vector.
     * @return This instance.
     */
    public Matrix setDown(Vector3 value) {
        if (value == null) throw new ArgumentNullException("value");

        m12 = value.x;
        m22 = value.y;
        m32 = value.z;

        return this;
    }

    /**
     * Gets the up vector.
     *
     * @param result The vector that holds the result.
     */
    public void getUp(Vector3 result) {
        if (result == null) throw new ArgumentNullException("result");

        result.set(-m12, -m22, -m32);
    }

    /**
     * Sets the up vector.
     *
     * @param value The up vector.
     * @return This instance.
     */
    public Matrix setUp(Vector3 value) {
        if (value == null) throw new ArgumentNullException("value");

        m12 = -value.x;
        m22 = -value.y;
        m32 = -value.z;

        return this;
    }

    /**
     * Gets the backward vector.
     *
     * @param result The vector that holds the result.
     */
    public void getBackward(Vector3 result) {
        if (result == null) throw new ArgumentNullException("result");

        result.set(m13, m23, m33);
    }

    /**
     * Sets the backward vector.
     *
     * @param value The backward vector.
     * @return This instance.
     */
    public Matrix setBackward(Vector3 value) {
        if (value == null) throw new ArgumentNullException("value");

        m13 = value.x;
        m23 = value.y;
        m33 = value.z;

        return this;
    }

    /**
     * Gets the forward vector.
     *
     * @param result The vector that holds the result.
     */
    public void getForward(Vector3 result) {
        if (result == null) throw new ArgumentNullException("result");

        result.set(-m13, -m23, -m33);
    }

    /**
     * Sets the forward vector.
     *
     * @param value The forward vector.
     * @return This instance.
     */
    public Matrix setForward(Vector3 value) {
        if (value == null) throw new ArgumentNullException("value");

        m13 = -value.x;
        m23 = -value.y;
        m33 = -value.z;

        return this;
    }

    /**
     * Copies values into the array in row-major order.
     *
     * @param result The array that holds the result.
     */
    public void toArrayInRowMajorOrder(float[] result) {
        if (result == null) throw new ArgumentNullException("result");
        if (result.length != ELEMENT_COUNT) throw new IllegalArgumentException("The length of 'result' must be 16.");

        result[0] = m11;
        result[1] = m12;
        result[2] = m13;
        result[3] = m14;

        result[4] = m21;
        result[5] = m22;
        result[6] = m23;
        result[7] = m24;

        result[8] = m31;
        result[9] = m32;
        result[10] = m33;
        result[11] = m34;

        result[12] = m41;
        result[13] = m42;
        result[14] = m43;
        result[15] = m44;
    }

    /**
     * Copies values into the array in column-major order.
     *
     * @param result The array that holds the result.
     */
    public void toArrayInColumnMajorOrder(float[] result) {
        if (result == null) throw new ArgumentNullException("result");
        if (result.length != ELEMENT_COUNT) throw new IllegalArgumentException("The length of 'result' must be 16.");

        result[0] = m11;
        result[1] = m21;
        result[2] = m31;
        result[3] = m41;

        result[4] = m12;
        result[5] = m22;
        result[6] = m32;
        result[7] = m42;

        result[8] = m13;
        result[9] = m23;
        result[10] = m33;
        result[11] = m43;

        result[12] = m14;
        result[13] = m24;
        result[14] = m34;
        result[15] = m44;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return Float.compare(matrix.m11, m11) == 0 &&
               Float.compare(matrix.m12, m12) == 0 &&
               Float.compare(matrix.m13, m13) == 0 &&
               Float.compare(matrix.m14, m14) == 0 &&
               Float.compare(matrix.m21, m21) == 0 &&
               Float.compare(matrix.m22, m22) == 0 &&
               Float.compare(matrix.m23, m23) == 0 &&
               Float.compare(matrix.m24, m24) == 0 &&
               Float.compare(matrix.m31, m31) == 0 &&
               Float.compare(matrix.m32, m32) == 0 &&
               Float.compare(matrix.m33, m33) == 0 &&
               Float.compare(matrix.m34, m34) == 0 &&
               Float.compare(matrix.m41, m41) == 0 &&
               Float.compare(matrix.m42, m42) == 0 &&
               Float.compare(matrix.m43, m43) == 0 &&
               Float.compare(matrix.m44, m44) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(m11, m12, m13, m14, m21, m22, m23, m24, m31, m32, m33, m34, m41, m42, m43, m44);
    }

    @Override
    public String toString() {
        return "Matrix{" +
               "m11=" + m11 +
               ", m12=" + m12 +
               ", m13=" + m13 +
               ", m14=" + m14 +
               ", m21=" + m21 +
               ", m22=" + m22 +
               ", m23=" + m23 +
               ", m24=" + m24 +
               ", m31=" + m31 +
               ", m32=" + m32 +
               ", m33=" + m33 +
               ", m34=" + m34 +
               ", m41=" + m41 +
               ", m42=" + m42 +
               ", m43=" + m43 +
               ", m44=" + m44 +
               '}';
    }
}
