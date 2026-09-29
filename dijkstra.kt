// dijkstra.kt
// Competitive programming - Dijkstra (Kotlin)
// Usage: compile with kotlinc or run with Kotlin/JVM. Assumes 0-based input by default.

import java.io.BufferedInputStream
import java.util.PriorityQueue
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

fun dijkstra(g: Array<MutableList<Pair<Int, Long>>>, s: Int): Pair<LongArray, IntArray> {
    val n = g.size
    val dist = LongArray(n) { Long.MAX_VALUE / 4 }
    val pred = IntArray(n) { -1 }
    val pq = PriorityQueue(compareBy<Pair<Long, Int>> { it.first })
    dist[s] = 0L
    pq.add(Pair(0L, s))
    while (pq.isNotEmpty()) {
        val (d, u) = pq.remove()
        if (d != dist[u]) continue
        for ((v, w) in g[u]) {
            if (dist[u] + w < dist[v]) {
                dist[v] = dist[u] + w
                pred[v] = u
                pq.add(Pair(dist[v], v))
            }
        }
    }
    return Pair(dist, pred)
}

fun main() {
    val fs = FastScanner()
    val n = fs.nextInt()
    val m = fs.nextInt()
    val g = Array(n) { mutableListOf<Pair<Int, Long>>() }
    repeat(m) {
        var u = fs.nextInt()
        var v = fs.nextInt()
        val w = fs.nextLong()
        // If input is 1-based uncomment the next two lines:
        // u--; v--
        g[u].add(Pair(v, w))
        // For undirected graphs also add: g[v].add(Pair(u, w))
    }
    val s = 0 // change source or read from input
    val (dist, pred) = dijkstra(g, s)
    for (i in 0 until n) {
        if (dist[i] >= Long.MAX_VALUE / 8) println("$i: -1") else println("$i: ${dist[i]}")
    }
}
