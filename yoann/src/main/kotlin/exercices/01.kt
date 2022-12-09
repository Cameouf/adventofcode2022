package exercices
import utils.Functions

fun main(args: Array<String>) {
    val input = Functions.readFile("exo1")

    val sumList: List<Int> = input.split("\n\n").map {
        it.split("\n").sumOf {value -> value.toInt() }
    }

    println(sumList.sortedDescending().take(3).sum())
    println(sumList.indexOf(sumList.max()))

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}