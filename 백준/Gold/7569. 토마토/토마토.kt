import java.util.*
import kotlin.math.max

val dh = intArrayOf(-1, 1, 0, 0, 0, 0)
val di = intArrayOf(0, 0, -1, 1, 0, 0)
val dj = intArrayOf(0, 0, 0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val (m, n, h) = readLine().split(" ").map { it.toInt() }
    val map = Array(h) { Array(n) { IntArray(m) } }

    var cnt = 0
    val q = LinkedList<IntArray>()
    for (k in 0 until h) {
        for (i in 0 until n) {
            val st = StringTokenizer(readLine(), " ")
            for (j in 0 until m) {
                val cur = st.nextToken().toInt()
                if (cur == 0) {
                    continue
                }
                if (cur == 1) {
                    q.add(intArrayOf(k, i, j, 0))
                }
                map[k][i][j] = -1
                cnt++
            }
        }
    }
    if (cnt == h * n * m) {
        println(0)
        return
    }

    var day = 0
    while (!q.isEmpty()) {
        val cur = q.poll() // k i j l
        day = max(day, cur[3])

        for (i in 0 until 6) {
            val curH = cur[0] + dh[i]
            val curI = cur[1] + di[i]
            val curJ = cur[2] + dj[i]

            if (curH > -1 && curH < h && curI > -1 && curI < n && curJ > -1 && curJ < m && map[curH][curI][curJ] != -1) {
                q.add(intArrayOf(curH, curI, curJ, cur[3] + 1))
                map[curH][curI][curJ] = -1
                cnt++
            }
        }
    }
    println(if (cnt == h * n * m) day else -1)
}
