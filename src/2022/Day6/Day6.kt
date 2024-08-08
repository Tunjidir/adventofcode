

import java.io.File

fun main() {

    //your subroutine needs to identify the first position where the four most recently received characters were all different.
//set of characters.
    fun first() {

        File("input.txt").useLines {
            val input = it.first().toString()
            for (index in 0..input.length - 4) {
                val char = input.substring(index, index + 4)
                val set = char.toCharArray().toSet()
                if (char.length == set.size) {
                    println("result: ${index + 4}")
                    break;
                }
            }
        }
    }

    fun second() {
        File("input.txt").useLines {
            val input = it.first().toString()
            for (index in 0..input.length - 14) {
                val char = input.substring(index, index + 14)
                val set = char.toCharArray().toSet()
                if (char.length == set.size) {
                    println("result: ${index + 14}")
                    break;
                }
            }
        }
    }

    first()
    second()
}