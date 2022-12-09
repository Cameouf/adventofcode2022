package utils;

import java.io.File

object Functions {

    fun readFile(fileName: String): String = File("adventofcode2022/yoann/inputs/$fileName.txt").readText()

}
