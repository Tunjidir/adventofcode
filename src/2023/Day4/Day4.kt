
fun main() {

    fun part() {
        val input = readInput("input.txt")
        var result = 0
        input.forEach { card ->
            val str = card.substringAfter(":")
            val winning = str.substringBefore("|").trim().split("\\s+".toRegex()).map { it.toInt() }
            val own = str.substringAfter("|").trim().split("\\s+".toRegex()).map { it.toInt() }
            var points = 0
            own.forEach {
                if (winning.contains(it)) {
                    points = if (points == 0) 1 else points * 2
                }
            }
            result += points
        }
        println(result)
    }

    fun part2() {
        val input = readInput("input.txt")
        val result = IntArray(input.size) { 1 }
        input.forEachIndexed { index, card ->
            val (winning, one) = card.substringAfter(":").split("|")
            val winningNumbers = winning.trim().split("\\s+".toRegex()).mapTo(hashSetOf()) { it.toInt() }
            val oneNumbers = one.trim().split("\\s+".toRegex()).mapTo(hashSetOf()) { it.toInt() }

            val counter = winningNumbers.intersect(oneNumbers).size
            val repetitions = minOf(result.lastIndex, index + counter) - index
            repeat(repetitions) {
                val nextGame = index + it + 1
                result[nextGame] += result[index]
            }
            //val end = minOf(result.lastIndex, index + counter)
            //for (i in index+1..end) result[i] += result[index]
        }
        val sum = result.reduce { acc, n -> acc + n }
        println(sum)

        // 1 = 1
        // 11 = 2
        // 1111 = 4
        //
        // 11111111 = 8
        // 111111 +8 = 14
        // 1 = 1
        //
        // = 30
    }
    part()
    part2()
}