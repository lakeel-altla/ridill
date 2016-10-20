package com.lakeel.altla.ridill;

import java.util.Objects;

/**
 * Defines a matrix.
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
     * Multiplies the row vector by the matrix.
     *
     * @param left   The source row vector.
     * @param right  The source matrix.
     * @param result The row vector that holds the result.
     */
    public static void multiply(Vector4 left, Matrix right, Vector4 result) {
        if (left == null) throw new ArgumentNullException("left");
        if (right == null) throw new ArgumentNullException("right");
        if (result == null) throw new ArgumentNullException("result");

        result.x = (left.x * right.m11) + (left.y * right.m21) + (left.z * right.m31) + (left.w * right.m41);
        result.y = (left.x * right.m12) + (left.y * right.m22) + (left.z * right.m32) + (left.w * right.m42);
        result.z = (left.x * right.m13) + (left.y * right.m23) + (left.z * right.m33) + (left.w * right.m43);
        result.w = (left.x * right.m14) + (left.y * right.m24) + (left.z * right.m34) + (left.w * right.m44);
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
            result.setZero();
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
     */
    public void set(Matrix value) {
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
     */
    public void set(float m11, float m12, float m13, float m14,
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

    /**
     * Sets values in row-major order.
     *
     * @param values The values in row-major order.
     */
    public void setInRowMajorOrder(float[] values) {
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
    }

    /**
     * Sets values in column-major order.
     *
     * @param values The values in column-major order.
     */
    public void setInColumnMajorOrder(float[] values) {
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
    }

    /**
     * Sets 0 into all elements.
     */
    public void setZero() {
        set(0, 0, 0, 0,
            0, 0, 0, 0,
            0, 0, 0, 0,
            0, 0, 0, 0);
    }

    /**
     * Sets elements of the identity matrix.
     */
    public void setIdentity() {
        set(1, 0, 0, 0,
            0, 1, 0, 0,
            0, 0, 1, 0,
            0, 0, 0, 1);
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

    /**
     * Defines the culculation of a look-at matrix.
     */
    public static class LookAt {

        private final Vector3 mXAxis = new Vector3();

        private final Vector3 mYAxis = new Vector3();

        private final Vector3 mZAxis = new Vector3();

        /**
         * Calculates a look-at matrix.
         *
         * @param position The position of a camera.
         * @param target   The look-at target of a camera.
         * @param up       The up vector of a camera.
         */
        public void calculate(Vector3 position, Vector3 target, Vector3 up, Matrix result) {
            Vector3.subtract(position, target, mZAxis);
            mZAxis.normalize();

            Vector3.cross(up, mZAxis, mXAxis);
            mXAxis.normalize();

            Vector3.cross(mZAxis, mXAxis, mYAxis);
            mYAxis.normalize();

            result.setIdentity();

            result.m11 = mXAxis.x;
            result.m21 = mXAxis.y;
            result.m31 = mXAxis.z;

            result.m12 = mYAxis.x;
            result.m22 = mYAxis.y;
            result.m32 = mYAxis.z;

            result.m13 = mZAxis.x;
            result.m23 = mZAxis.y;
            result.m33 = mZAxis.z;

            result.m14 = -Vector3.dot(mXAxis, position);
            result.m24 = -Vector3.dot(mYAxis, position);
            result.m34 = -Vector3.dot(mZAxis, position);
        }
    }
}
