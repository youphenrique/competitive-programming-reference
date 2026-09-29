// bfs.kt
// Competitive programming - BFS (Kotlin)
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

fun bfs(g: Array<MutableList<Int>>, s: Int): Pair<IntArray, IntArray> {
    val n = g.size
    val dist = IntArray(n) { -1 }
    val pred = IntArray(n) { -1 }
    val q = ArrayDeque<Int>()
    dist[s] = 0
    q.addLast(s)
    while (q.isNotEmpty()) {
        val u = q.removeFirst()
        for (v in g[u]) {
            if (dist[v] == -1) {
                dist[v] = dist[u] + 1
                pred[v] = u
                q.addLast(v)
            }
        }
    }
    return Pair(dist, pred)
}

fun main() {
    val fs = FastScanner()
    val n = fs.nextInt()
    val m = fs.nextInt()
    val g = Array(n) { mutableListOf<Int>() }
    repeat(m) {
        var u = fs.nextInt()
        var v = fs.nextInt()
        // If input is 1-based uncomment the next two lines:
        // u--; v--
        g[u].add(v)
        // For undirected graphs also add: g[v].add(u)
    }
    val s = 0 // change source or read from input
    val (dist, pred) = bfs(g, s)
    // Print distances (index: distance)
    for (i in 0 until n) {
        println("$i: ${dist[i]}")
    }
}
