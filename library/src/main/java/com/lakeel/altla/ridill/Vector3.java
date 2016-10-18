package com.lakeel.altla.ridill;

import java.util.Objects;

/**
 * Defines a vector with three components.
 */
public class Vector3 {

    /**
     * Gets or sets the x-component of the vector.
     */
    public float x;

    /**
     * Gets or sets the y-component of the vector.
     */
    public float y;

    /**
     * Gets or sets the z-component of the vector.
     */
    public float z;

    /**
     * Initializes a new instance of Vector3.
     */
    public Vector3() {
    }

    /**
     * Initializes a new instance of Vector3.
     *
     * @param value A value to initialize each component to.
     */
    public Vector3(float value) {
        this(value, value, value);
    }

    /**
     * Initializes a new instance of Vector3.
     *
     * @param x An initial value for the x-component of the vector.
     * @param y An initial value for the y-component of the vector.
     * @param z An initial value for the z-component of the vector.
     */
    public Vector3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Creates a vector (1, 1, 1).
     *
     * @return A vector (1, 1, 1).
     */
    public static Vector3 createOne() {
        return new Vector3(1);
    }

    /**
     * Creates a x unit vector (1, 0, 0).
     *
     * @return A vector (1, 0, 0).
     */
    public static Vector3 createUnitX() {
        return new Vector3(1, 0, 0);
    }

    /**
     * Creates a y unit vector (0, 1, 0).
     *
     * @return A vector (0, 1, 0).
     */
    public static Vector3 createUnitY() {
        return new Vector3(0, 1, 0);
    }

    /**
     * Creates a z unit vector (0, 0, 1).
     *
     * @return A vector (0, 0, 1).
     */
    public static Vector3 createUnitZ() {
        return new Vector3(0, 0, 1);
    }

    /**
     * Creates a unit vector designating up (0, 1, 0).
     *
     * @return A vector (0, 1, 0).
     */
    public static Vector3 createUp() {
        return new Vector3(0, 1, 0);
    }

    /**
     * Creates a unit vector designating down (0, -1, 0).
     *
     * @return A uvector (0, -1, 0).
     */
    public static Vector3 createDown() {
        return new Vector3(0, -1, 0);
    }

    /**
     * Creates a unit vector designating right (-1, 0, 0).
     *
     * @return A vector (-1, 0, 0).
     */
    public static Vector3 createLeft() {
        return new Vector3(-1, 0, 0);
    }

    /**
     * Creates a unit vector designating left (1, 0, 0).
     *
     * @return A vector (1, 0, 0).
     */
    public static Vector3 createRight() {
        return new Vector3(1, 0, 0);
    }

    /**
     * Creates a unit vector designating forward in a right-handed coordinate system (0, 0, −1).
     *
     * @return A vector (0, 0, -1).
     */
    public static Vector3 createForward() {
        return new Vector3(0, 0, -1);
    }

    /**
     * Creates a unit vector designating backward in a right-handed coordinate system (0, 0, −1).
     *
     * @return A vector (0, 0, -1).
     */
    public static Vector3 createBackward() {
        return new Vector3(0, 0, 1);
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
     */
    public void normalize() {
        float length = length();
        if (0 < length) {
            float inverse = 1.0f / length;
            x *= inverse;
            y *= inverse;
            z *= inverse;
        }
    }

    /**
     * Sets the components of the specified vector into this ones.
     *
     * @param value The source vector.
     */
    public void set(Vector3 value) {
        x = value.x;
        y = value.y;
        z = value.z;
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
