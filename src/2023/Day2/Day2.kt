fun main() {

    fun part1() {
        val colors = listOf("red", "green", "blue")
        val numbers = listOf(12, 13, 14)
        val input = readInput("input.txt")
        var id = 0
        var sum = 0
        for (w in input) {
            id++
            val st = w.substringAfter("Game $id: ").split(";")
            println(st)
            var ok = true
            for (xy in st) {
                val sp = xy.trim().split(",")
                for (s in sp) {
                    val (ns, cs) = s.trim().split(" ")
                    val n = ns.toInt()
                    val c = colors.indexOf(cs)
                    if (n > numbers[c]) ok = false
                }
            }
            if (ok) sum += id
        }
        println(sum)
    }

    fun part2() {
        val colors = listOf("red", "green", "blue")
        val input = readInput("input.txt")
        var id = 0
        var sum = 0L
        for (w in input) {
            id++
            val st = w.substringAfter("Game $id: ").split(";")
            println(st)
            val m = IntArray(3)
            for (xy in st) {
                val sp = xy.trim().split(",")
                for (s in sp) {
                    val (ns, cs) = s.trim().split(" ")
                    val n = ns.toInt()
                    val c = colors.indexOf(cs)
                    m[c] = maxOf(m[c], n)
                }
            }
            sum += m[0].toLong() * m[1] * m[2]
        }
        println(sum)
    }

    part2()
}
