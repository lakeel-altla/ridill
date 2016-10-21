package com.lakeel.altla.ridill;

import java.util.Objects;

/**
 * Defines a quaternion.
 */
public class Quaternion {

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
    public Quaternion() {
    }

    /**
     * Initializes a new instance.
     *
     * @param x The initial value for the x-component.
     * @param y The initial value for the y-component.
     * @param z The initial value for the z-component.
     * @param w The initial value for the w-component.
     */
    public Quaternion(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    /**
     * Creates the conjugate of a specified quaternion.
     *
     * @param value  The source quaternion.
     * @param result The quaternion that holds the result.
     */
    public static void conjugate(Quaternion value, Quaternion result) {
        if (value == null) throw new ArgumentNullException("value");
        if (result == null) throw new ArgumentNullException("result");

        result.x = -value.x;
        result.y = -value.y;
        result.z = -value.z;
        result.w = value.w;
    }

    /**
     * Transforms this into its conjugate.
     */
    public void conjugate() {
        x = -x;
        y = -y;
        z = -z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quaternion that = (Quaternion) o;
        return Float.compare(that.x, x) == 0 &&
               Float.compare(that.y, y) == 0 &&
               Float.compare(that.z, z) == 0 &&
               Float.compare(that.w, w) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z, w);
    }

    @Override
    public String toString() {
        return "Quaternion{" +
               "x=" + x +
               ", y=" + y +
               ", z=" + z +
               ", w=" + w +
               '}';
    }
}
