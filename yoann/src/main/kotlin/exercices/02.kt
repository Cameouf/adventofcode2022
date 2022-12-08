package exercices

import utils.Functions


fun main() {

    val sameFormatMapping: HashMap<String, String> = HashMap()
    sameFormatMapping["X"] = "A"
    sameFormatMapping["Y"] = "B"
    sameFormatMapping["Z"] = "C"

    val winAgainst: HashMap<String, String> = HashMap()
    winAgainst["B"] = "A"
    winAgainst["C"] = "B"
    winAgainst["A"] = "C"

    val scoreForCoup: HashMap<String, Int> = HashMap()
    scoreForCoup["A"] = 1
    scoreForCoup["B"] = 2
    scoreForCoup["C"] = 3

    val looseAgainst: HashMap<String, String> = HashMap()
    looseAgainst["A"] = "B"
    looseAgainst["B"] = "C"
    looseAgainst["C"] = "A"


    val input: String = Functions.readFile("exo2")
    val gamespart1: List<Pair<String, String>> = input.split("\n").map {
        val splited = it.split(" ")
        Pair(
            sameFormatMapping.get(splited[1])!!,
            splited[0]
        )
    }

    val gamespart2: List<Pair<String, String>> = input.split("\n").map {
        val splited = it.split(" ")
        Pair(
            when (splited[1]) {
                "X" -> winAgainst[splited[0]]!!
                "Y" -> splited[0]
                else -> looseAgainst[splited[0]]!!
            },
            splited[0]
        )
    }

    fun results(games: List<Pair<String, String>>): Int =
        games.sumOf {
            scoreForCoup[it.first]!! +
                    if (it.first == it.second) 3
                    else if (winAgainst[it.first] == it.second) 6
                    else 0
        }

    println(
        results(gamespart2)
    )
}