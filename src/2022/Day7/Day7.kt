import java.io.File

fun main() {

    fun traverseFilesAndDirectories(): Map<String, Int> {
        val map = hashMapOf("" to 0)
        var current = ""
        File("input.txt").forEachLine { line ->
            val split = line.split(" ")
            if (split[0] == "$") {
                if (split[1] == "cd") {
                    current = when (split[2]) {
                        "/" -> ""
                        ".." -> current.substringBeforeLast("/").also {
                            map[it] = map.getOrDefault(it, 0) + map.getOrDefault(current, 0)
                        }

                        else -> current + "/" + split[2]
                    }
                }
            } else if (split[0] == "dir") {
                map.getOrPut(current + "/" + split[1]) { 0 }
            } else {
                map[current] = map.getOrDefault(current, 0) + split[0].toInt()
            }
        }
        while (current != "") {
            current = current.substringBeforeLast("/").also {
                map[it] = map.getOrDefault(it, 0) + map.getOrDefault(current, 0)
            }
        }
        return map
    }

    fun part1() {
        val result = traverseFilesAndDirectories().values.filter { it <= 100_000 }.sum()
        println(result)
    }

    fun part2() {
        val map = traverseFilesAndDirectories()
        val usedSpace = map.getValue("")
        val availableSpace = 70_000_000 - usedSpace
        val neededSpace = 30_000_000 - availableSpace
        if (neededSpace < 0) {
            println(0)
        } else {
            var toDelete = Int.MAX_VALUE
            for ((_, value) in map) {
                if (value in neededSpace until toDelete) toDelete = value
            }
            println(toDelete)
        }
    }

    part1()
    part2()
}