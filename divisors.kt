// divisors.kt
// Competitive programming - divisors of a number (Kotlin)
// Usage: compile with kotlinc or run with Kotlin/JVM. Assumes input n (Long).

import java.io.BufferedInputStream
import kotlin.system.exitProcess
import kotlin.math.sqrt

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

    fun nextLong(): Long {
        var c = read()
        while (c <= 32 && c >= 0) c = read()
        if (c == -1) exitProcess(0)
        var sign = 1
        if (c == '-'.code) {
            sign = -1
            c = read()
        }
        var res = 0L
        while (c > 32) {
            res = res * 10 + (c - '0'.code)
            c = read()
        }
        return res * sign
    }
}

fun divisors(n: Long, proper: Boolean = false): LongArray {
    val ds = ArrayList<Long>()
    var i = 1L
    while (i <= n / i) {
        if (n % i == 0L) {
            val a = i
            val b = n / i
            if (!(proper && a == n)) ds.add(a)
            if (b != a && !(proper && b == n)) ds.add(b)
        }
        ++i
    }
    ds.sort()
    return ds.toLongArray()
}

fun main() {
    val fs = FastScanner()
    val n = fs.nextLong()
    val ds = divisors(n, proper = false)
    println(ds.joinToString(" "))
}
