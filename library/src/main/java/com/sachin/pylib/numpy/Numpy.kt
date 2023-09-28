package com.sachin.pylib.numpy

import com.chaquo.python.PyObject
import com.chaquo.python.Python

class Numpy {
    private val numpyModule: PyObject = Python.getInstance().getModule("numpylib")

    fun zeros(dimension: Int): Array<Double> {
        return numpyModule.callAttr("create_zeros_array", dimension)
            .toJava(Array<Double>::class.java)
    }

    fun ones(dimension: Int): Array<Double> {
        return numpyModule.callAttr("create_ones_array", dimension)
            .toJava(Array<Double>::class.java)
    }

    fun arange(start: Int, stop: Int, step: Int = 1): Array<Int> {
        return numpyModule.callAttr("create_arange_array", start, stop, step)
            .toJava(IntArray::class.java).toTypedArray()

    }

    fun arange(start: Double, stop: Double, step: Double = 1.0): Array<Double> {
        return numpyModule.callAttr("create_arange_array", start, stop, step)
            .toJava(DoubleArray::class.java).toTypedArray()

    }

    fun linspace(start: Int, stop: Int, space: Int): Array<Double> {
        return numpyModule.callAttr("create_linspace_array", start, stop, space)
            .toJava(DoubleArray::class.java).toTypedArray()
    }

    fun linspace(start: Double, stop: Double, space: Int): Array<Double> {
        return numpyModule.callAttr("create_linspace_array", start, stop, space)
            .toJava(DoubleArray::class.java).toTypedArray()

    }

    fun reshape(array: Array<Int>, m: Int, n: Int): Array<Array<Int>> {
        return numpyModule.callAttr("reshape_array", array, m, n)
            .toJava(Array<Array<Int>>::class.java)
    }

    fun transpose(array: Array<Array<Int>>): Array<Array<Int>> {
        return numpyModule.callAttr("transpose_array", array)
            .toJava(Array<Array<Int>>::class.java)
    }

    fun split(array: Array<Int>, parts: Int): Array<IntArray> {
        return numpyModule.callAttr("split_array", array, parts)
            .toJava(Array<IntArray>::class.java)
    }

    fun min(array: Array<Int>): Int {
        return numpyModule.callAttr("find_min_value", array)
            .toJava(Int::class.java)
    }

    fun max(array: Array<Int>): Int {
        return numpyModule.callAttr("find_max_value", array)
            .toJava(Int::class.java)
    }

    fun min(array: Array<Array<Int>>): Int {
        return numpyModule.callAttr("find_min_value", array)
            .toJava(Int::class.java)
    }

    fun max(array: Array<Array<Int>>): Int {
        return numpyModule.callAttr("find_max_value", array)
            .toJava(Int::class.java)
    }

    fun mean(array: Array<Int>): Double {
        return mean(arrayOf(array))
    }

    fun mean(array: Array<Array<Int>>): Double {
        return numpyModule.callAttr("calculate_mean", array)
            .toJava(Double::class.java)
    }

    fun std(array: Array<Int>): Double {
        return std(arrayOf(array))
    }

    fun std(array: Array<Array<Int>>): Double {
        return numpyModule.callAttr("calculate_std", array)
            .toJava(Double::class.java)
    }

    fun sum(array: Array<Int>): Double {
        return sum(arrayOf(array))
    }

    fun sum(array: Array<Array<Int>>): Double {
        return numpyModule.callAttr("calculate_sum", array)
            .toJava(Double::class.java)
    }

    fun dot(arr1: Array<Int>, arr2: Array<Int>): Double {
        return numpyModule.callAttr("compute_dot_product", arr1, arr2)
            .toJava(Double::class.java)
    }

    fun sort(array: Array<Int>): Array<Int> {
        return numpyModule.callAttr("sort_array", array)
            .toJava(Array<Int>::class.java)
    }

    fun sort(array: Array<Array<Int>>): Array<Array<Int>> {
        return numpyModule.callAttr("sort_array", array)
            .toJava(Array<Array<Int>>::class.java)
    }

    fun unique(array: Array<Int>): Array<Int> {
        return unique(arrayOf(array))
    }

    fun unique(array: Array<Array<Int>>): Array<Int> {
        return numpyModule.callAttr("find_unique_elements", array)
            .toJava(Array<Int>::class.java)
    }

    fun clip(array: Array<Int>, min: Int, max: Int): Array<Int> {
        return numpyModule.callAttr("clip_array", array, min, max)
            .toJava(Array<Int>::class.java)
    }

    fun clip(array: Array<Array<Int>>, min: Int, max: Int): Array<Array<Int>> {
        return numpyModule.callAttr("clip_array", array, min, max)
            .toJava(Array<Array<Int>>::class.java)
    }

    fun clip(array: Array<Double>, min: Double, max: Double): Array<Double> {
        return numpyModule.callAttr("clip_array", array, min, max)
            .toJava(Array<Double>::class.java)
    }

    fun clip(array: Array<Array<Double>>, min: Double, max: Double): Array<Array<Double>> {
        return numpyModule.callAttr("clip_array", array, min, max)
            .toJava(Array<Array<Double>>::class.java)
    }

    fun argmax(array: Array<Int>): Int {
        return numpyModule.callAttr("find_index_of_max_value", array).toJava(Int::class.java)
    }

    fun argmax(array: Array<Array<Int>>): Int {
        return numpyModule.callAttr("find_index_of_max_value", array).toJava(Int::class.java)
    }

    fun argmax(array: Array<Double>): Int {
        return numpyModule.callAttr("find_index_of_max_value", array).toJava(Int::class.java)
    }

    fun argmax(array: Array<Array<Double>>): Int {
        return numpyModule.callAttr("find_index_of_max_value", array).toJava(Int::class.java)
    }

    fun argmax(array: Array<Array<Int>>, axis: Int): Array<Int> {
        return numpyModule.callAttr("find_index_of_max_value", array, axis)
            .toJava(Array<Int>::class.java)
    }

    fun argmax(array: Array<Array<Double>>, axis: Int): Array<Int> {
        return numpyModule.callAttr("find_index_of_max_value", array, axis)
            .toJava(Array<Int>::class.java)
    }

}

private const val TAG = "Numpy"