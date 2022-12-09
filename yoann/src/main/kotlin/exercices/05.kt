package exercices

import utils.Functions
import java.util.*

fun main() {

    val inputStacks = Functions.readFile("exo05stack")
        .replace("    ", " []")
        .replace(" ", ",")
        .replace("[]", "[ ]")
        .split("\n")

    val inputCommands = Functions.readFile("exo5command")
        .replace("move ", "")
        .replace(" from ", ",")
        .replace(" to ", ",")
        .split("\n")
        .map { row ->
            val command = row.split(",")
            Triple<Int, Int, Int>(
                command[0].toInt(),
                command[1].toInt(),
                command[2].toInt()
            )
        }

    val stacks: List<MutableList<Char>> =
        inputStacks.fold(
            (0 until inputStacks[0].split(",").size).map {
                LinkedList<Char>()
            }
        ) { total, nxt ->
            val values = nxt.split(",").map {
                it.replace("[", "").replace("]", "")
            }
            total.zip(values)
                .forEach { pair ->
                    if (pair.second.isNotBlank())
                        pair.first.add(pair.second[0])
                }
            total
        }
            .map {
                it.asReversed()
            }

    fun processing(stacks: List<MutableList<Char>>, commands: List<Triple<Int, Int, Int>>): List<MutableList<Char>> {
        val copy = ArrayList(stacks)
        commands.forEach {
            val move = copy[it.second - 1].takeLast(it.first)
            copy[it.second - 1].removeAll(move)
            copy[it.third - 1].addAll(move)
        }
        return copy
    }

    stacks[1].add('H')
    stacks[1].removeAll(stacks[1].takeLast(1))

    println(
        processing(
            stacks,
            inputCommands
        ).map {
            it.takeLast(1)
        }.flatten()
            .joinToString("")

    )


}