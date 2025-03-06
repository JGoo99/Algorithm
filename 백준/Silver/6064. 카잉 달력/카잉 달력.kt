import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sb = StringBuilder()
    val n = Integer.parseInt(readLine())

    for(j in 1..n) {
        val st = StringTokenizer(readLine(), " ")
        val A = Integer.parseInt(st.nextToken())
        val B = Integer.parseInt(st.nextToken())
        val a = Integer.parseInt(st.nextToken()) - 1
        val b = Integer.parseInt(st.nextToken()) - 1

        val gcd = if (A > B) getGCD(A, B) else getGCD(B, A)
        val lcm = (A * B) / gcd

        var result = -1
        for (j in a..lcm step A) {
            if (j % B == b) {
                result = j + 1
                break
            }
        }
        sb.append("${result}\n")
    }
    println(sb)
}

fun getGCD(x: Int, y: Int): Int {
    if (x % y == 0) {
        return y
    }
    return getGCD(y, x % y)
}