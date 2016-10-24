package com.lakeel.altla.ridill;

import java.util.Objects;

/**
 * Defines a vector with 3 components.
 */
public class Vector3 {

    public static final int ELEMENT_COUNT = 3;

    /**
     * The x-component.
     */
    public float x;

    /**
     * The y-component.
     */
    public float y;

    /**
     * The z-component.
     */
    public float z;

    /**
     * Initializes a new instance.
     */
    public Vector3() {
    }

    /**
     * Initializes a new instance.
     *
     * @param value The value to initialize each component to.
     */
    public Vector3(float value) {
        this(value, value, value);
    }

    /**
     * Initializes a new instance.
     *
     * @param x The initial value for the x-component.
     * @param y The initial value for the y-component.
     * @param z The initial value for the z-component.
     */
    public Vector3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Adds two vectors.
     *
     * @param left   The first source vector.
     * @param right  The second source vector.
     * @param result The vector that holds the result.
     */
    public static void add(Vector3 left, Vector3 right, Vector3 result) {
        if (left == null) throw new ArgumentNullException("left");
        if (right == null) throw new ArgumentNullException("right");
        if (result == null) throw new ArgumentNullException("result");

        result.x = left.x + right.x;
        result.y = left.y + right.y;
        result.z = left.z + right.z;
    }

    /**
     * Subtracts two vectors.
     *
     * @param left   The first source vector.
     * @param right  The second source vector.
     * @param result The vector that holds the result.
     */
    public static void subtract(Vector3 left, Vector3 right, Vector3 result) {
        if (left == null) throw new ArgumentNullException("left");
        if (right == null) throw new ArgumentNullException("right");
        if (result == null) throw new ArgumentNullException("result");

        result.x = left.x - right.x;
        result.y = left.y - right.y;
        result.z = left.z - right.z;
    }

    /**
     * Multiplies the components of two vectors by each other.
     *
     * @param left   The first source vector.
     * @param right  The second source vector.
     * @param result The vector that holds the result.
     */
    public static void multiply(Vector3 left, Vector3 right, Vector3 result) {
        if (left == null) throw new ArgumentNullException("left");
        if (right == null) throw new ArgumentNullException("right");
        if (result == null) throw new ArgumentNullException("result");

        result.x = left.x * right.x;
        result.y = left.y * right.y;
        result.z = left.z * right.z;
    }

    /**
     * Multiplies a vector by a scalar value.
     *
     * @param value  The source vector.
     * @param scale  The scale.
     * @param result The vector that holds the result.
     */
    public static void multiply(Vector3 value, float scale, Vector3 result) {
        if (value == null) throw new ArgumentNullException("value");
        if (result == null) throw new ArgumentNullException("result");

        result.x = value.x * scale;
        result.y = value.y * scale;
        result.z = value.z * scale;
    }

    /**
     * Divides the components of a vector by the components of another vector.
     *
     * @param left   The first source vector.
     * @param right  The second source vector.
     * @param result The vector that holds the result.
     */
    public static void divide(Vector3 left, Vector3 right, Vector3 result) {
        if (left == null) throw new ArgumentNullException("left");
        if (right == null) throw new ArgumentNullException("right");
        if (result == null) throw new ArgumentNullException("result");

        result.x = left.x / right.x;
        result.y = left.y / right.y;
        result.z = left.z / right.z;
    }

    /**
     * Divides a vector by a scalar value.
     *
     * @param value  The source vector.
     * @param scale  The scale.
     * @param result The vector that holds the result.
     */
    public static void divide(Vector3 value, float scale, Vector3 result) {
        if (value == null) throw new ArgumentNullException("value");
        if (result == null) throw new ArgumentNullException("result");

        multiply(value, 1.0f / scale, result);
    }

    /**
     * Create a vector pointing in the opposite direction.
     *
     * @param value  The source vector.
     * @param result The vector that holds the result.
     */
    public static void negate(Vector3 value, Vector3 result) {
        if (value == null) throw new ArgumentNullException("value");
        if (result == null) throw new ArgumentNullException("result");

        result.x = -value.x;
        result.y = -value.y;
        result.z = -value.z;
    }

    /**
     * Calculates the dot product of two vectors.
     *
     * @param left  The first source vector.
     * @param right The second source vector.
     * @return The result.
     */
    public static float dot(Vector3 left, Vector3 right) {
        if (left == null) throw new ArgumentNullException("left");
        if (right == null) throw new ArgumentNullException("right");

        return (left.x * right.x) + (left.y * right.y) + (left.z * right.z);
    }

    /**
     * Calculates the cross product of two vectors.
     *
     * @param left   The first source vector.
     * @param right  The second source vector.
     * @param result The vector that holds the result.
     */
    public static void cross(Vector3 left, Vector3 right, Vector3 result) {
        if (left == null) throw new ArgumentNullException("left");
        if (right == null) throw new ArgumentNullException("right");
        if (result == null) throw new ArgumentNullException("result");

        result.x = (left.y * right.z) - (left.z * right.y);
        result.y = (left.z * right.x) - (left.x * right.z);
        result.z = (left.x * right.y) - (left.y * right.x);
    }

    /**
     * Calculates the squared distance between two vectors.
     *
     * @param value1 The first source vector.
     * @param value2 The second source vector.
     * @return The result.
     */
    public static float distanceSquared(Vector3 value1, Vector3 value2) {
        if (value1 == null) throw new ArgumentNullException("value1");
        if (value2 == null) throw new ArgumentNullException("value2");

        float x = value1.x - value2.x;
        float y = value1.y - value2.y;
        float z = value1.z - value2.z;

        return (x * x) + (y * y) + (z * z);
    }

    /**
     * Calculates the distance between two vectors.
     *
     * @param value1 The first source vector.
     * @param value2 The second source vector.
     * @return The result.
     */
    public static float distance(Vector3 value1, Vector3 value2) {
        return (float) Math.sqrt(distanceSquared(value1, value2));
    }

    /**
     * Creates a unit vector from the specified vector.
     *
     * @param value  The source vector.
     * @param result The vector that holds the result.
     */
    public static void normalize(Vector3 value, Vector3 result) {
        if (value == null) throw new ArgumentNullException("value");
        if (result == null) throw new ArgumentNullException("result");

        result.set(value);
        result.normalize();
    }

    /**
     * Transforms the vector by the quaternion.
     *
     * @param vector     The vector to transform.
     * @param quaternion The quaternion to apply.
     * @param result     The vector that holds the result.
     */
    public static void transform(Vector3 vector, Quaternion quaternion, Vector3 result) {
        if (vector == null) throw new ArgumentNullException("vector");
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

        result.x = m11 * vector.x + m12 * vector.y + m13 * vector.z;
        result.y = m21 * vector.y + m22 * vector.y + m23 * vector.z;
        result.z = m31 * vector.z + m32 * vector.y + m33 * vector.z;
    }

    /**
     * Calculates the length of the vector squared.
     *
     * @return The length of the vector squared.
     */
    public float lengthSquared() {
        return x * x + y * y + z * z;
    }

    /**
     * Calculates the length of the vector.
     *
     * @return The length of the vector.
     */
    public float length() {
        return (float) Math.sqrt(lengthSquared());
    }

    /**
     * Turns the current vector into a unit vector.
     *
     * @return This instance.
     */
    public Vector3 normalize() {
        float length = length();
        if (0 < length) {
            float inverse = 1.0f / length;
            x *= inverse;
            y *= inverse;
            z *= inverse;
        }
        return this;
    }

    /**
     * Sets components of the specified vector into this ones.
     *
     * @param value The source vector.
     * @return This instance.
     */
    public Vector3 set(Vector3 value) {
        if (value == null) throw new ArgumentNullException("value");

        x = value.x;
        y = value.y;
        z = value.z;

        return this;
    }

    /**
     * Sets values into this components.
     *
     * @param x The value for the x-component.
     * @param y The value for the y-component.
     * @param z The value for the z-component.
     * @return This instance.
     */
    public Vector3 set(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    /**
     * Sets the value into this components.
     *
     * @param value The value to initialize each component to.
     * @return This instance.
     */
    public Vector3 set(float value) {
        return set(value, value, value);
    }

    /**
     * Sets the array into this components.
     *
     * @param values The values for components.
     * @return This instance.
     */
    public Vector3 set(float[] values) {
        if (values == null) throw new ArgumentNullException("values");
        if (values.length != ELEMENT_COUNT) throw new IllegalArgumentException("The length of 'values' must be 3.");

        x = values[0];
        y = values[1];
        z = values[2];

        return this;
    }

    /**
     * Initializes this instance as the vector (0, 0, 0).
     *
     * @return This instance.
     */
    public Vector3 asZero() {
        return set(0);
    }

    /**
     * Initializes this instance as the vector (1, 1, 1).
     *
     * @return This instance.
     */
    public Vector3 asOne() {
        return set(1);
    }

    /**
     * Initializes this instance as the vector (1, 0, 0).
     *
     * @return This instance.
     */
    public Vector3 asUnitX() {
        return set(1, 0, 0);
    }

    /**
     * Initializes this instance as the vector (0, 1, 0).
     *
     * @return This instance.
     */
    public Vector3 asUnitY() {
        return set(0, 1, 0);
    }

    /**
     * Initializes this instance as the vector (0, 0, 1).
     *
     * @return This instance.
     */
    public Vector3 asUnitZ() {
        return set(0, 0, 1);
    }

    /**
     * Initializes this instance as the vector (0, 1, 0).
     *
     * @return This instance.
     */
    public Vector3 asUp() {
        return set(0, 1, 0);
    }

    /**
     * Initializes this instance as the vector (0, -1, 0).
     *
     * @return This instance.
     */
    public Vector3 asDown() {
        return set(0, -1, 0);
    }

    /**
     * Initializes this instance as the vector (-1, 0, 0).
     *
     * @return This instance.
     */
    public Vector3 asLeft() {
        return set(-1, 0, 0);
    }

    /**
     * Initializes this instance as the vector (1, 0, 0).
     *
     * @return This instance.
     */
    public Vector3 asRight() {
        return set(1, 0, 0);
    }

    /**
     * Initializes this instance as the vector (0, 0, -1).
     *
     * @return This instance.
     */
    public Vector3 asForward() {
        return set(0, 0, -1);
    }

    /**
     * Initializes this instance as the vector (0, 0, 1).
     *
     * @return This instance.
     */
    public Vector3 asBackward() {
        return set(0, 0, 1);
    }

    /**
     * Copies components into the array.
     *
     * @param result The array that holds the result.
     */
    public void toArray(float[] result) {
        if (result == null) throw new ArgumentNullException("result");
        if (result.length != ELEMENT_COUNT) throw new IllegalArgumentException("The length of 'result' must be 3.");

        result[0] = x;
        result[1] = y;
        result[2] = z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Vector3 other = (Vector3) obj;
        return x == other.x && y == other.y && z == other.z;
    }

    @Override
    public String toString() {
        return "Vector3{" +
               "x=" + x +
               ", y=" + y +
               ", z=" + z +
               '}';
    }
}
