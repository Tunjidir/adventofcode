import java.io.File

fun main() {

    fun getCalibrationPart1(): Int {
        var result = 0
        readInput("input.txt").forEach {
            val digits = it.replace("[^0-9]".toRegex(), "")
            val firstAndLast = "${digits[0]}${digits[digits.length - 1]}"
            result += firstAndLast.toInt()
        }
        return result
    }

    fun getCalibrationPart2() {
        val input = readInput("input.txt")
        val digits = listOf("", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
        val sum = input.sumOf { s ->
            val d = buildString {
                for (i in s.indices) {
                    when (s[i]) {
                        in '0'..'9' -> append(s[i])
                        else -> {
                            val ss = s.substring(i)
                            for (j in 1..9) if (ss.startsWith(digits[j])) {
                                append('0' + j)
                            }
                        }
                    }
                }
            }
            "${d.first()}${d.last()}".toLong()
        }
        println(sum)
    }
//println(getCalibrationPart1())
    println(getCalibrationPart2())
}