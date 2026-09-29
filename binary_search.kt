// binary_search.kt
// Competitive programming - Binary Search (Kotlin)
// Usage: compile with kotlinc or run with Kotlin/JVM. Assumes 0-based input by default.

import java.io.BufferedInputStream
import kotlin.system.exitProcess

private class FastScanner {
    private val input = BufferedInputStream(System.`in`)
    private val buffer = ByteArray(1 shl 16)
    private var len = 0
    private var ptr = 0

    private fun read(): Int {
        if (ptr >= len) {
            len = input.read(buffer)
            ptr = 0
            if (len <= 0) return -1
        }
        return buffer[ptr++].toInt()
    }

    fun nextInt(): Int {
        var c = read()
        while (c <= 32 && c >= 0) c = read()
        if (c == -1) exitProcess(0)
        var sign = 1
        if (c == '-'.code) {
            sign = -1
            c = read()
        }
        var res = 0
        while (c > 32) {
            res = res * 10 + (c - '0'.code)
            c = read()
        }
        return res * sign
    }
}

// Returns index of any occurrence of 'key' in sorted array 'a', or -1 if not found.
// O(log n), 0-based index.
fun binarySearchIdx(a: IntArray, key: Int): Int {
    var l = 0
    var r = a.size - 1
    while (l <= r) {
        val m = l + (r - l) / 2
        when {
            a[m] == key -> return m
            a[m] < key -> l = m + 1
            else -> r = m - 1
        }
    }
    return -1
}

// Returns first index i such that a[i] >= key (lower_bound behavior). If none, returns a.size.
fun lowerBoundIdx(a: IntArray, key: Int): Int {
    var l = 0
    var r = a.size
    while (l < r) {
        val m = l + (r - l) / 2
        if (a[m] < key) l = m + 1 else r = m
    }
    return l
}

// Returns first index i such that a[i] > key (upper_bound behavior). If none, returns a.size.
fun upperBoundIdx(a: IntArray, key: Int): Int {
    var l = 0
    var r = a.size
    while (l < r) {
        val m = l + (r - l) / 2
        if (a[m] <= key) l = m + 1 else r = m
    }
    return l
}

fun main() {
    val fs = FastScanner()
    val n = fs.nextInt()
    val a = IntArray(n) { fs.nextInt() }
    // If input is 1-based uncomment the next loop to convert to 0-based values where needed
    // for (i in a.indices) a[i]--
    a.sort()

    val q = fs.nextInt()
    repeat(q) {
        val x = fs.nextInt()
        val idx = binarySearchIdx(a, x)
        println(idx) // prints -1 if not found
    }
}
