package exercices

import utils.Functions

fun main() {

    fun buildRange(r: String): IntRange = r.split('-')[0].toInt()..r.split('-')[1].toInt()

    val pairs = Functions.readFile("exo4")
        .split("\n")
        .map {
            val splitted = it.split(",")
            buildRange(splitted[0]) to buildRange(splitted[1])
        }

    val containsAll = pairs.count { pair ->
        pair.first.all {
            pair.second.contains(it)
        } ||
                pair.second.all {
                    pair.first.contains(it)
                }
    }

    val containsOne = pairs.count { pair ->
        pair.first.any {
            pair.second.contains(it)
        }
                ||
                pair.second.any {
                    pair.first.contains(it)
                }
    }

    println(containsOne)
}