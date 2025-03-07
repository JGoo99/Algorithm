import java.util.*
import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = Integer.parseInt(readLine())
    val map = Array(n) { IntArray(n) }
    for (i in map.indices) {
        val st = StringTokenizer(readLine(), " ")
        for (j in map[i].indices) {
            map[i][j] = Integer.parseInt(st.nextToken())
        }
    }

    for (i in map.indices) {
        val q = LinkedList<Int>()
        val visit = Array(n) { BooleanArray(n) }
        q.add(i)
        visit[i][i] = true

        while (!q.isEmpty()) {
            val node = q.poll()

            for (j in map[node].indices) {
                if (map[node][j] == 1 && !visit[node][j]) {
                    map[i][j] = 1
                    q.add(j)
                    visit[node][j] = true
                }
            }
        }
    }

    val sb = StringBuilder()
    for (i in map.indices) {
        for (j in map[i].indices) {
            sb.append("${map[i][j]} ")
        }
        sb.append("\n")
    }
    print(sb)
}