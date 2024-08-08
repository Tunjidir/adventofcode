
fun main () {
    fun countingCalories() {
        val caloriesPerElf = mutableMapOf<Int, Int>()
        var numberOfElves = 1
        var calories  = 0;
        readInput("input.txt").forEach {
            if (it != "") {
                calories += Integer.parseInt(it)
                caloriesPerElf[numberOfElves] = calories
            }
            if (it == "") {
                numberOfElves++
                calories = 0
            }
        }
        val highestCalories = caloriesPerElf.values.maxOf { it }
        println("Result ${highestCalories}")
    }

    fun top3Calories() {
        val caloriesPerElf = mutableMapOf<Int, Int>()
        var numberOfElves = 1
        var calories  = 0;
        readInput("input.txt").forEach {
            if (it != "") {
                calories += Integer.parseInt(it)
                caloriesPerElf[numberOfElves] = calories
            }
            if (it == "") {
                numberOfElves++
                calories = 0
            }
        }

        //fyi: this is an 0(nLogn) solution because of sorting the list.
        //TODO: refactor to an 0(n) getting rid of the sorting.
        val topThree = caloriesPerElf.values.sortedDescending().take(3).sum()

        println("Result: ${topThree}")

    }

    fun minOperations(logs: Array<String>): Int {
        // main folder
        // operations from the logs
        var counter = 0
        for (s in logs) {
            if (s != "../" && s != "./") {
                counter += 1
            }
            if (s == "../" && counter > 0)  {
                counter -= 1
            }
        }
        return counter
    }

    fun binarySearch() {
        val number = 1..10
    }

    countingCalories()
    top3Calories()
}