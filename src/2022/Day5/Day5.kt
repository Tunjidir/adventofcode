import java.io.File

fun main() {
    fun reorder(retainOrder: Boolean) {

        File("input.txt").useLines { lineSequence ->
            val lines = lineSequence.iterator()
            val entries = mutableListOf<ArrayDeque<Char>>()
            for (line in lines) {
                if (line.isEmpty()) break
                for ((index, j) in (1 until line.length step 4).withIndex()) {
                    val entry = line[j]
                    if (entry != ' ') {
                        while (index > entries.lastIndex) entries.add(ArrayDeque())
                        entries[index].add(entry)
                    }
                }
            }
            for (line in lines) {
                val commands = line.split(" ")
                val count = commands[1].toInt()
                val start = commands[3].toInt() - 1
                val end = commands[5].toInt() - 1
                if (retainOrder) buildList {
                    repeat(count) { add(entries[start].removeFirst()) }
                }.asReversed().forEach { entries[end].addFirst(it) }
                else repeat(count) {
                    entries[end].addFirst(entries[start].removeFirst())
                }
            }
            val result = entries.joinToString("") { it.first().toString() }
            println(result)
        }
    }

    fun first() {
        reorder(false)
    }

    fun second() {
        reorder(true)
    }

    first()
    second()
}