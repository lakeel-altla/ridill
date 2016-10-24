package com.lakeel.altla.ridill;

import java.util.Objects;

/**
 * Defines a quaternion.
 */
public class Quaternion {

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
     * Creates a quaternion from specified yaw, pitch, and roll angles.
     *
     * @param yaw    The yaw angle in radians.
     * @param pitch  The pitch angle in radians.
     * @param roll   The roll angle in radians.
     * @param result The quaternion that holds the result.
     */
    public static void createFromYawPitchRoll(float yaw, float pitch, float roll, Quaternion result) {
        if (result == null) throw new ArgumentNullException("result");

        // angles (x,y,z) aka (pitch, yaw, roll)

        float halfRoll = roll * 0.5f;
        float halfPitch = pitch * 0.5f;
        float halfYaw = yaw * 0.5f;

        float sinRoll = (float) Math.sin(halfRoll);
        float cosRoll = (float) Math.cos(halfRoll);
        float sinPitch = (float) Math.sin(halfPitch);
        float cosPitch = (float) Math.cos(halfPitch);
        float sinYaw = (float) Math.sin(halfYaw);
        float cosYaw = (float) Math.cos(halfYaw);

        // jMonkeyEngine may use x-z-y order.
        // pitch (x) -> roll (z) -> yaw (y)

        // SharpDX may use z-x-y order.
        // roll (z) -> pitch (x) -> yaw (y)

        // jMonkeyEngine style
//        result.w = (cosRoll * cosPitch * cosYaw - sinRoll * sinPitch * sinYaw);
//        result.x = (cosRoll * sinPitch * cosYaw + sinRoll * cosPitch * sinYaw);
//        result.y = (cosRoll * cosPitch * sinYaw + sinRoll * sinPitch * cosYaw);
//        result.z = (sinRoll * cosPitch * cosYaw - cosRoll * sinPitch * sinYaw);

        // SharpDX style
        result.w = (cosRoll * cosPitch * cosYaw) + (sinRoll * sinPitch * sinYaw);
        result.x = (cosRoll * sinPitch * cosYaw) + (sinRoll * cosPitch * sinYaw);
        result.y = (cosRoll * cosPitch * sinYaw) - (sinRoll * sinPitch * cosYaw);
        result.z = (sinRoll * cosPitch * cosYaw) - (cosRoll * sinPitch * sinYaw);
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
     *
     * @return This instance.
     */
    public Quaternion conjugate() {
        x = -x;
        y = -y;
        z = -z;
        return this;
    }

    /**
     * Sets values into this quaternion.
     *
     * @param x The x-value.
     * @param y The y-value.
     * @param z The z-value.
     * @param w The w-value.
     * @return This instance.
     */
    public Quaternion set(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        return this;
    }

    /**
     * Set values (x, y, z, w) as the array into this quaternion.
     *
     * @param values The values (x, y, z, w).
     * @return This instance.
     */
    public Quaternion set(float[] values) {
        if (values == null) throw new ArgumentNullException("values");
        if (values.length != ELEMENT_COUNT) throw new IllegalArgumentException("The length of 'values' must be 4.");

        return set(values[0], values[1], values[2], values[3]);
    }

    /**
     * Initializes this instance as the quaternion (0, 0, 0, 1).
     *
     * @return This instance.
     */
    public Quaternion asIdentity() {
        return set(0, 0, 0, 1);
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
