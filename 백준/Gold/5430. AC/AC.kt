import java.util.*
import kotlin.collections.ArrayDeque

fun main() = with(System.`in`.bufferedReader()) {
    val t = Integer.parseInt(readLine())
    val sb = StringBuilder()

    for (i in 0 until t) {
        val order = readLine().toCharArray()

        val arrLength = readLine().toInt()
        val st = StringTokenizer(readLine(), "[|,|]")
        val deq = ArrayDeque<Int>(arrLength)
        for (j in 0 until arrLength) {
            deq.add(st.nextToken().toInt())
        }

        var left = true
        var error = false
        for (j in order.indices) {
            when {
                order[j] == 'R' -> {
                    left = !left
                }

                order[j] == 'D' -> {
                    if (deq.isEmpty()) {
                        error = true
                        break
                    }

                    if (left) {
                        deq.removeFirst()
                    } else {
                        deq.removeLast()
                    }
                }
            }
        }
        if (error) {
            sb.append("error\n")
        } else {
            sb.append("[")
            if (!deq.isEmpty()) {
                if (left) {
                    sb.append(deq.removeFirst())
                    while (!deq.isEmpty()) {
                        sb.append(",${deq.removeFirst()}")
                    }
                } else {
                    sb.append(deq.removeLast())
                    while (!deq.isEmpty()) {
                        sb.append(",${deq.removeLast()}")
                    }
                }
            }
            sb.append("]\n")
        }
    }
    print(sb)
}