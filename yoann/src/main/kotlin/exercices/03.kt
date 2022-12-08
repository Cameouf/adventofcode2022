package exercices

import utils.Functions

fun main() {

    val ruckSacks = Functions.readFile("exo3")
        .split("\n")

    val rucksacksPart1: List<Pair<String, String>> = ruckSacks
        .map {
            Pair(it.take(it.length / 2), it.takeLast(it.length / 2))
        }

    val commonItemsPart1: List<Char> = rucksacksPart1.map { rucksack ->
        rucksack.first.filter { rucksack.second.contains(it) }.toCharArray()[0]
    }

    val rucksacksPart2 =
        ruckSacks.map {
            val position = ruckSacks.indexOf(it)
            if (ruckSacks.size - 1 >= position + 2) {
                listOf(it, ruckSacks[position + 1], ruckSacks[position + 2])
            } else {
                emptyList()
            }
        }

    val rucksacksPart2filtered =
        rucksacksPart2.filter {
            rucksacksPart2.indexOf(it) % 3 == 0
        }

    val commonItemsPart2: List<Char> = rucksacksPart2filtered.flatMap { rucks ->
        rucks[0].filter {
            rucks[1].contains(it) && rucks[2].contains(it)
        }.toCharArray().take(1)
    }


    fun toCharCode(commonItems: List<Char>): List<Int> = commonItems.map {
        if (it.isUpperCase()) it.code - 'A'.code + 27
        else it.code - 'a'.code + 1
    }

    println(
        toCharCode(commonItemsPart2).sum()
    )


}