import java.io.*
import java.util.*

val dx = intArrayOf(0, 0, -1, 1)
val dy = intArrayOf(-1, 1, 0, 0)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var st = StringTokenizer(readLine(), " ")
    val n = Integer.parseInt(st.nextToken())
    val m = Integer.parseInt(st.nextToken())
    val map = Array(n) { IntArray(m) }
    val visit = Array(n) { BooleanArray(m) }

    val q = LinkedList<Int>()
    for (i in map.indices) {
        st = StringTokenizer(readLine(), " ")
        for (j in map[i].indices) {
            map[i][j] = Integer.parseInt(st.nextToken())
            if (map[i][j] == 2) {
                q.add(i)
                q.add(j)
                map[i][j] = 0
            }
        }
    }

    while (!q.isEmpty()) {
        val i = q.poll()
        val j = q.poll()

        for (idx in 0 until 4) {
            val nextI = i + dy[idx]
            val nextJ = j + dx[idx]

            if (nextI > -1 && nextI < n && nextJ > -1 && nextJ < m && !visit[nextI][nextJ] && map[nextI][nextJ] != 0) {
                visit[nextI][nextJ] = true
                q.add(nextI)
                q.add(nextJ)
                map[nextI][nextJ] = map[i][j] + 1
            }
        }
    }

    val sb = StringBuilder()
    for (i in map.indices) {
        for (j in map[i].indices) {
            if (map[i][j] == 1 && !visit[i][j]) {
                sb.append("-1 ")
            } else {
                sb.append("${map[i][j]} ")
            }
        }
        sb.append("\n")
    }
    print(sb)
}