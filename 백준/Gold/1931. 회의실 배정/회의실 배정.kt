import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = Integer.parseInt(readLine())

    val q = PriorityQueue(object: Comparator<IntArray> {
        override fun compare(o1: IntArray, o2: IntArray): Int {
            if (o1[1] == o2[1]) {
                return (o1[0]).compareTo(o2[0])
            }
            return o1[1].compareTo(o2[1])
        }
    })
    for (i in 0 until n) {
        val (s, e) = readLine().split(" ").map { it.toInt() }
        q.add(intArrayOf(s, e))
    }

    var endTime = 0
    var cnt = 0
    while (!q.isEmpty()) {
        val cur = q.poll()
        if (cur[0] < endTime) {
            continue
        }
        endTime = cur[1]
        cnt++
    }

    println(cnt)
}