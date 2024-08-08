import java.nio.charset.Charset

fun main() {
    fun valueOfChar(char: Char): Int {
        return if (char.isUpperCase()) {
            char - 'A' + 27
        } else {
            char - 'a' + 1
        }
    }

    fun first() {
        var result = 0
        var set1: Set<Char>
        var set2: Set<Char>

        readInput("input.txt").forEach {
            val first = it.substring(0, it.length / 2)
            val second = it.substring(it.length / 2)
            set1 = first.toCharArray().toMutableSet()
            set2 = second.toCharArray().toSet()
            for (char in set2) {
                if (char in set1) result += valueOfChar(char)
            }
        }

        println("Result: $result")
    }

    fun second() {
        var result = 0
        val lines = readInput("input.txt")
        for (line in lines.windowed(3, 3)) {
            val (first, second, third) = line

            val array = IntArray(52)
            for (char in first) array[valueOfChar(char) - 1] = 1
            for (char in second) {
                val value = valueOfChar(char)
                if (array[value - 1] == 1) array[value - 1] = 2
            }
            for (char in third) {
                val value = valueOfChar(char)
                if (array[value - 1] == 2) {
                    result += value
                    array[value - 1] = 0
                }
            }
        }
        println("Result: ${result}")
    }

    first()
    second()
}
