import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sb = StringBuilder()
    val n = Integer.parseInt(readLine())

    val q = PriorityQueue<Int>(object : Comparator<Int> {
        override fun compare(o1: Int, o2:Int): Int {
            val O1 = Math.abs(o1)
            val O2 = Math.abs(o2)
            if (O1 == O2) {
                return Integer.compare(o1, o2)
            }
            return Integer.compare(O1, O2)
        }
    })

    for (i in 1 .. n) {
        when (val cur = Integer.parseInt(readLine())) {
            0 -> if (!q.isEmpty()) sb.append("${q.poll()}\n") else sb.append("0\n")
            else -> q.add(cur)
        }
    }
    print(sb)
}