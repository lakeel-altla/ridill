package com.lakeel.altla.ridill;

import java.util.Objects;

/**
 * Defines a vector with 4 components.
 */
public class Vector4 {

    public static final int ELEMENT_COUNT = 4;

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
     * The w-component.
     */
    public float w;

    /**
     * Initializes a new instance.
     */
    public Vector4() {
    }

    /**
     * Initializes a new instance.
     *
     * @param value The value to initialize each component to.
     */
    public Vector4(float value) {
        this(value, value, value, value);
    }

    /**
     * Initializes a new instance.
     *
     * @param x The initial value for the x-component.
     * @param y The initial value for the y-component.
     * @param z The initial value for the z-component.
     * @param w The initial value for the w-component.
     */
    public Vector4(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    /**
     * Adds two vectors.
     *
     * @param left   The first source vector.
     * @param right  The second source vector.
     * @param result The vector that holds the result.
     */
    public static void add(Vector4 left, Vector4 right, Vector4 result) {
        if (left == null) throw new ArgumentNullException("left");
        if (right == null) throw new ArgumentNullException("right");
        if (result == null) throw new ArgumentNullException("result");

        result.x = left.x + right.x;
        result.y = left.y + right.y;
        result.z = left.z + right.z;
        result.w = left.w + right.w;
    }

    /**
     * Subtracts two vectors.
     *
     * @param left   The first source vector.
     * @param right  The second source vector.
     * @param result The vector that holds the result.
     */
    public static void subtract(Vector4 left, Vector4 right, Vector4 result) {
        if (left == null) throw new ArgumentNullException("left");
        if (right == null) throw new ArgumentNullException("right");
        if (result == null) throw new ArgumentNullException("result");

        result.x = left.x - right.x;
        result.y = left.y - right.y;
        result.z = left.z - right.z;
        result.w = left.w - right.w;
    }

    /**
     * Multiplies the components of two vectors by each other.
     *
     * @param left   The first source vector.
     * @param right  The second source vector.
     * @param result The vector that holds the result.
     */
    public static void multiply(Vector4 left, Vector4 right, Vector4 result) {
        if (left == null) throw new ArgumentNullException("left");
        if (right == null) throw new ArgumentNullException("right");
        if (result == null) throw new ArgumentNullException("result");

        result.x = left.x * right.x;
        result.y = left.y * right.y;
        result.z = left.z * right.z;
        result.w = left.w * right.w;
    }

    /**
     * Multiplies a vector by a scalar value.
     *
     * @param value  The source vector.
     * @param scale  The scale.
     * @param result The vector that holds the result.
     */
    public static void multiply(Vector4 value, float scale, Vector4 result) {
        if (value == null) throw new ArgumentNullException("value");
        if (result == null) throw new ArgumentNullException("result");

        result.x = value.x * scale;
        result.y = value.y * scale;
        result.z = value.z * scale;
        result.w = value.w * scale;
    }

    /**
     * Divides the components of a vector by the components of another vector.
     *
     * @param left   The first source vector.
     * @param right  The second source vector.
     * @param result The vector that holds the result.
     */
    public static void divide(Vector4 left, Vector4 right, Vector4 result) {
        if (left == null) throw new ArgumentNullException("left");
        if (right == null) throw new ArgumentNullException("right");
        if (result == null) throw new ArgumentNullException("result");

        result.x = left.x / right.x;
        result.y = left.y / right.y;
        result.z = left.z / right.z;
        result.w = left.w / right.w;
    }

    /**
     * Divides a vector by a scalar value.
     *
     * @param value  The source vector.
     * @param scale  The scale.
     * @param result The vector that holds the result.
     */
    public static void divide(Vector4 value, float scale, Vector4 result) {
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
    public static void negate(Vector4 value, Vector4 result) {
        if (value == null) throw new ArgumentNullException("value");
        if (result == null) throw new ArgumentNullException("result");

        result.x = -value.x;
        result.y = -value.y;
        result.z = -value.z;
        result.w = -value.w;
    }

    /**
     * Calculates the dot product of two vectors.
     *
     * @param left  The first source vector.
     * @param right The second source vector.
     * @return The result.
     */
    public static float dot(Vector4 left, Vector4 right) {
        if (left == null) throw new ArgumentNullException("left");
        if (right == null) throw new ArgumentNullException("right");

        return (left.x * right.x) + (left.y * right.y) + (left.z * right.z) + (left.w * right.w);
    }

    /**
     * Calculates the squared distance between two vectors.
     *
     * @param value1 The first source vector.
     * @param value2 The second source vector.
     * @return The result.
     */
    public static float distanceSquared(Vector4 value1, Vector4 value2) {
        if (value1 == null) throw new ArgumentNullException("value1");
        if (value2 == null) throw new ArgumentNullException("value2");

        float x = value1.x - value2.x;
        float y = value1.y - value2.y;
        float z = value1.z - value2.z;
        float w = value1.w - value2.w;

        return (x * x) + (y * y) + (z * z) + (w * w);
    }

    /**
     * Calculates the distance between two vectors.
     *
     * @param value1 The first source vector.
     * @param value2 The second source vector.
     * @return The result.
     */
    public static float distance(Vector4 value1, Vector4 value2) {
        return (float) Math.sqrt(distanceSquared(value1, value2));
    }

    /**
     * Creates a unit vector from the specified vector.
     *
     * @param value  The source vector.
     * @param result The vector that holds the result.
     */
    public static void normalize(Vector4 value, Vector4 result) {
        if (value == null) throw new ArgumentNullException("value");
        if (result == null) throw new ArgumentNullException("result");

        result.set(value);
        result.normalize();
    }

    /**
     * Calculates the length of the vector squared.
     *
     * @return The length of the vector squared.
     */
    public float lengthSquared() {
        return (x * x) + (y * y) + (z * z) + (w * w);
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
    public Vector4 normalize() {
        float length = length();
        if (0 < length) {
            float inverse = 1.0f / length;
            x *= inverse;
            y *= inverse;
            z *= inverse;
            w *= inverse;
        }
        return this;
    }

    /**
     * Sets the components of the specified vector into this ones.
     *
     * @param value The source vector.
     * @return This instance.
     */
    public Vector4 set(Vector4 value) {
        if (value == null) throw new ArgumentNullException("value");

        return set(value.x, value.y, value.z, value.w);
    }

    /**
     * Sets values into this components.
     *
     * @param x The value for the x-component.
     * @param y The value for the y-component.
     * @param z The value for the z-component.
     * @param w The value for the w-component.
     * @return This instance.
     */
    public Vector4 set(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        return this;
    }

    /**
     * Sets the array into this components.
     *
     * @param values The values for components.
     * @return This instance.
     */
    public Vector4 set(float[] values) {
        if (values == null) throw new ArgumentNullException("values");
        if (values.length != ELEMENT_COUNT) throw new IllegalArgumentException("The length of 'values' must be 4.");

        return set(values[0], values[1], values[2], values[3]);
    }

    /**
     * Initializes this instance as the vector (1, 1, 1, 1).
     *
     * @return This instance.
     */
    public Vector4 asOne() {
        return set(1, 1, 1, 1);
    }

    /**
     * Initializes this instance as the vector (1, 0, 0, 0).
     *
     * @return This instance.
     */
    public Vector4 asUnitX() {
        return set(1, 0, 0, 0);
    }

    /**
     * Initializes this instance as the vector (0, 1, 0, 0).
     *
     * @return This instance.
     */
    public Vector4 asUnitY() {
        return set(0, 1, 0, 0);
    }

    /**
     * Initializes this instance as the vector (0, 0, 1, 0).
     *
     * @return This instance.
     */
    public Vector4 asUnitZ() {
        return set(0, 0, 1, 0);
    }

    /**
     * Initializes this instance as the vector (0, 0, 0, 1).
     *
     * @return This instance.
     */
    public Vector4 asUnitW() {
        return set(0, 0, 0, 1);
    }

    /**
     * Copies components into the array.
     *
     * @param result The array that holds the result.
     */
    public void toArray(float[] result) {
        if (result == null) throw new ArgumentNullException("result");
        if (result.length != ELEMENT_COUNT) throw new IllegalArgumentException("The length of 'result' must be 4.");

        result[0] = x;
        result[1] = y;
        result[2] = z;
        result[3] = w;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector4 vector4 = (Vector4) o;
        return Float.compare(vector4.x, x) == 0 &&
               Float.compare(vector4.y, y) == 0 &&
               Float.compare(vector4.z, z) == 0 &&
               Float.compare(vector4.w, w) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z, w);
    }

    @Override
    public String toString() {
        return "Vector4{" +
               "x=" + x +
               ", y=" + y +
               ", z=" + z +
               ", w=" + w +
               '}';
    }
}
