package com.sachin.app.pylib

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import com.sachin.pylib.numpy.Numpy
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class NumpyTest {
    private lateinit var numpy: Numpy

    @Before
    fun setUp() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        if (!Python.isStarted()) {
            Python.start(AndroidPlatform(appContext))
        }
        numpy = Numpy()
    }

    @Test
    fun testZeros() {
        val dimension = 5
        val expected = arrayOf(0.0, 0.0, 0.0, 0.0, 0.0)
        val result = numpy.zeros(dimension)
        assertArrayEquals(expected, result)
    }

    @Test
    fun testOnes() {
        val dimension = 5
        val expected = arrayOf(1.0, 1.0, 1.0, 1.0, 1.0)
        val result = numpy.ones(dimension)
        assertArrayEquals(expected, result)
    }

    @Test
    fun testArangeWithIntParams() {
        val start = 1
        val stop = 10
        val step = 2
        val expected = arrayOf(1, 3, 5, 7, 9)
        val result = numpy.arange(start, stop, step)
        assertArrayEquals(expected, result)
    }

    @Test
    fun testArangeWithDoubleParams() {
        val start = 1.0
        val stop = 4.0
        val step = 0.5
        val expected = arrayOf(1.0, 1.5, 2.0, 2.5, 3.0, 3.5)
        val result = numpy.arange(start, stop, step)
        assertArrayEquals(expected, result)
    }

    @Test
    fun testLinspaceWithIntParams() {
        val start = 1
        val stop = 10
        val space = 4
        val expected = arrayOf(1.0, 4.0, 7.0, 10.0)
        val result = numpy.linspace(start, stop, space)
        assertArrayEquals(expected, result)
    }

    @Test
    fun testLinspaceWithDoubleParams() {
        val start = 1.0
        val stop = 10.0
        val space = 3
        val expected = arrayOf(1.0, 5.5, 10.0)
        val result = numpy.linspace(start, stop, space)
        assertArrayEquals(expected, result)
    }

    @Test
    fun testReshape() {
        val array = arrayOf(1, 2, 3, 4, 5, 6)
        val m = 2
        val n = 3
        val result = numpy.reshape(array, m, n)

        val expected = arrayOf(
            arrayOf(1, 2, 3),
            arrayOf(4, 5, 6)
        )
        assertArrayEquals(expected, result)
    }

    @Test
    fun testTranspose() {
        val array = arrayOf(
            arrayOf(1, 2, 3),
            arrayOf(4, 5, 6)
        )

        val result = numpy.transpose(array)

        val expected = arrayOf(
            arrayOf(1, 4),
            arrayOf(2, 5),
            arrayOf(3, 6)
        )

        assertArrayEquals(expected, result)
    }

    @Test
    fun testSplit() {
        val array = arrayOf(1, 2, 3, 4, 5, 6)
        val parts = 3

        val result = numpy.split(array, parts)

        val expected = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4),
            intArrayOf(5, 6)
        )

        assertArrayEquals(expected, result)
    }

    @Test
    fun testMin() {
        val array = arrayOf(1, 2, 3, 4, 5)
        val result = numpy.min(array)
        assertEquals(1, result)
    }

    @Test
    fun testMax() {
        val array = arrayOf(1, 2, 3, 4, 5)
        val result = numpy.max(array)
        assertEquals(5, result)
    }

    @Test
    fun testMinWithNestedArray() {
        val array = arrayOf(arrayOf(1, 2), arrayOf(3, 4), arrayOf(5, 6))
        val result = numpy.min(array)
        assertEquals(1, result)
    }

    @Test
    fun testMaxWithNestedArray() {
        val array = arrayOf(arrayOf(1, 2), arrayOf(3, 4), arrayOf(5, 6))
        val result = numpy.max(array)
        assertEquals(6, result)
    }

    @Test
    fun testMean() {
        val array = arrayOf(1, 2, 3, 4, 5)
        val result = numpy.mean(array)
        assertEquals(3.0, result, 0.0001)
    }

    @Test
    fun testMeanWithNestedArray() {
        val array = arrayOf(arrayOf(1, 2), arrayOf(3, 4), arrayOf(5, 6))
        val result = numpy.mean(array)
        assertEquals(3.5, result, 0.0001)
    }

    @Test
    fun testStd() {
        val array = arrayOf(1, 2, 3, 4, 5)
        val result = numpy.std(array)
        assertEquals(1.4142, result, 0.0001)
    }

    @Test
    fun testStdWithNestedArray() {
        val array = arrayOf(arrayOf(1, 2), arrayOf(3, 4), arrayOf(5, 6))
        val result = numpy.std(array)
        assertEquals(1.7078, result, 0.0001)
    }

    @Test
    fun testSum() {
        val array = arrayOf(1, 2, 3, 4, 5)
        val result = numpy.sum(array)
        assertEquals(15.0, result, 0.0001)
    }

    @Test
    fun testSumWithNestedArrays() {
        val array = arrayOf(arrayOf(1, 2), arrayOf(3, 4), arrayOf(5, 6))
        val result = numpy.sum(array)
        assertEquals(21.0, result, 0.0001)
    }

    @Test
    fun testDot() {
        val arr1 = arrayOf(1, 2, 3)
        val arr2 = arrayOf(4, 5, 6)
        val result = numpy.dot(arr1, arr2)
        assertEquals(32.0, result, 0.0001)
    }

    @Test
    fun testSort() {
        val array = arrayOf(3, 1, 2, 4, 5)
        val result = numpy.sort(array)
        val expected = arrayOf(1, 2, 3, 4, 5)
        assertArrayEquals(expected, result)
    }

    @Test
    fun testSortWithNestedArray() {
        val array = arrayOf(arrayOf(3, 1, 2), arrayOf(4, 6, 5), arrayOf(9, 7, 8))
        val result = numpy.sort(array)
        val expected = arrayOf(
            arrayOf(1, 2, 3),
            arrayOf(4, 5, 6),
            arrayOf(7, 8, 9)
        )
        assertArrayEquals(expected, result)
    }

    @Test
    fun testUnique() {
        val array = arrayOf(1, 2, 3, 2, 1, 4, 4, 5)
        val result = numpy.unique(array)
        val expected = arrayOf(1, 2, 3, 4, 5)
        assertArrayEquals(expected, result)
    }

    @Test
    fun testUniqueWithNestedArray() {
        val array = arrayOf(arrayOf(1, 2), arrayOf(3, 2), arrayOf(1, 4), arrayOf(3, 4))
        val result = numpy.unique(array)
        val expected = arrayOf(1, 2, 3, 4)
        assertArrayEquals(expected, result)
    }

    @Test
    fun testClipArray() {
        val array = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        val result = numpy.clip(array, 2, 7)
        val expected = arrayOf(2, 2, 3, 4, 5, 6, 7, 7, 7)
        assertArrayEquals(expected, result)
    }

    @Test
    fun testClipWithNestedArray() {
        val array = arrayOf(arrayOf(1, 2, 3), arrayOf(4, 5, 6), arrayOf(7, 8, 9))
        val result = numpy.clip(array, 2, 7)
        val expected = arrayOf(arrayOf(2, 2, 3), arrayOf(4, 5, 6), arrayOf(7, 7, 7))
        assertArrayEquals(expected, result)
    }

    @Test
    fun testClipArrayWithDoubleParams() {
        val array = arrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0)
        val result = numpy.clip(array, 1.5, 7.5)
        val expected = arrayOf(1.5, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 7.5, 7.5)
        assertArrayEquals(expected, result)
    }

    @Test
    fun testClipWithNestedArrayAndDoubleParams() {
        val array = arrayOf(arrayOf(1.0, 2.0, 3.0), arrayOf(4.0, 5.0, 6.0))
        val result = numpy.clip(array, 1.5, 4.5)
        val expected = arrayOf(arrayOf(1.5, 2.0, 3.0), arrayOf(4.0, 4.5, 4.5))
        assertArrayEquals(expected, result)
    }

    @Test
    fun testArgmax() {
        val array = arrayOf(1, 2, 3, 4, 5)
        val result = numpy.argmax(array)
        assertEquals(4, result)
    }

    @Test
    fun testArgmaxWithNestedArray() {
        val array = arrayOf(
            arrayOf(1, 2, 3),
            arrayOf(4, 5, 6),
            arrayOf(7, 8, 9)
        )
        val result = numpy.argmax(array)
        assertEquals(8, result)
    }

    @Test
    fun testArgmaxWithAxis0() {
        val array = arrayOf(
            arrayOf(1, 3, 5),
            arrayOf(4, 9, 2)
        )
        val result = numpy.argmax(array, axis = 0)
        val expected = arrayOf(1, 1, 0)
        assertArrayEquals(expected, result)
    }

    @Test
    fun testArgmaxWithAxis1() {
        val array = arrayOf(
            arrayOf(1, 3, 5),
            arrayOf(4, 9, 2)
        )
        val result = numpy.argmax(array, axis = 1)
        val expected = arrayOf(2, 1)
        assertArrayEquals(expected, result)
    }

    @Test
    fun testArgmaxWithDoubleArrayAndAxis0() {
        val array = arrayOf(
            arrayOf(1.0, 3.0, 5.0),
            arrayOf(4.0, 9.0, 2.0)
        )
        val result = numpy.argmax(array, axis = 0)
        val expected = arrayOf(1, 1, 0)
        assertArrayEquals(expected, result)
    }

    @Test
    fun testArgmaxWithDoubleArrayAndAxis1() {
        val array = arrayOf(
            arrayOf(1.0, 3.0, 5.0),
            arrayOf(4.0, 9.0, 2.0)
        )
        val result = numpy.argmax(array, axis = 1)
        val expected = arrayOf(2, 1)
        assertArrayEquals(expected, result)
    }

    @Test
    fun testArgmaxWithDoubleParams() {
        val array = arrayOf(1.0, 2.0, 3.0, 4.0, 5.0)
        val result = numpy.argmax(array)
        assertEquals(4, result)
    }

    @Test
    fun testArgmaxWithNestedArrayAndDoubleParams() {
        val array = arrayOf(
            arrayOf(1.0, 2.0, 3.0),
            arrayOf(4.0, 5.0, 6.0),
            arrayOf(7.0, 8.0, 9.0)
        )
        val result = numpy.argmax(array)
        assertEquals(8, result)
    }
}