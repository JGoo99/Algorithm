import java.util.*
import kotlin.math.max

val di = intArrayOf(-1, 1, 0, 0)
val dj = intArrayOf(0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val (m, n) = readLine().split(" ").map { it.toInt() }
    val board = Array(n) { BooleanArray(m) }

    var cnt = 0
    val q = LinkedList<IntArray>()
    for (i in 0 until n) {
        val st = StringTokenizer(readLine(), " ")
        for (j in 0 until m) {
            val tomato = st.nextToken().toInt()
            if (tomato == 0) {
                continue
            }
            if (tomato == 1) {
                q.add(intArrayOf(i, j, 0))
            }
            board[i][j] = true
            cnt++
        }
    }

    var day = 0
    while (!q.isEmpty()) {
        if (cnt == n * m) {
            println(if (day == 0) 0 else day + 1)
            return
        }
        val tomato = q.poll() // i j len
        day = tomato[2]

        for (k in 0 until 4) {
            val curI = tomato[0] + di[k]
            val curJ = tomato[1] + dj[k]

            if (curI > -1 && curI < n && curJ > -1 && curJ < m && !board[curI][curJ]) {
                q.add(intArrayOf(curI, curJ, tomato[2] + 1))
                board[curI][curJ] = true
                cnt++
            }
        }
    }
    println(-1)
}