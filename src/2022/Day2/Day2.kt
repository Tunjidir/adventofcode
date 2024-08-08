

fun main() {
    fun day1() {
        val values = mapOf('A' to 1, 'B' to 2, 'C' to 3, 'X' to 1, 'Y' to 2, 'Z' to 3)
        val wins = mapOf('A' to 'Y', 'B' to 'Z', 'C' to 'X')
        val lose = mapOf('A' to 'Z', 'B' to 'X', 'C' to 'Y')
        var result = 0
        readInput("input.txt").forEach { it ->
            val (opponent, expectation) = it.split(" ").map { it[0] }
            result += when (expectation) {
                lose[opponent] -> values.getValue(expectation)
                wins[opponent] -> 6 + values.getValue(expectation)
                else  -> 3 + values.getValue(expectation)

            }
        }
        println("Result $result")
    }

    fun day2() {
        val values = mapOf('A' to 1, 'B' to 2, 'C' to 3)
        val wins = mapOf('A' to 'B', 'B' to 'C', 'C' to 'A')
        val lose = mapOf('A' to 'C', 'B' to 'A', 'C' to 'B')
        var result = 0
        readInput("input.txt").forEach {
            val (opponent, expectation) = it.split(" ").map { it[0] }
            result += when (expectation) {
                'X' -> values.getValue(lose.getValue(opponent))
                'Y' -> 3 + values.getValue(opponent)
                'Z' -> 6 + values.getValue(wins.getValue(opponent))
                else -> error("Not valid")
            }
        }
        println("Result $result")
    }

    day1()
    day2()
}