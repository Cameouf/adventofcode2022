
val input = """2-4,6-8
2-3,4-5
5-7,7-9
2-8,3-7
6-6,4-6
2-6,4-8"""

def parseSections(input: String) = {
  input
    .split(",")
    .map(s => s.split("-").map(s => s.toInt))
    .map(s => (s(0) to s(1)).toArray)
}

def hasIntersection(input: Array[Array[Int]]) = {
  input(0).intersect(input(1)).length > 0 ||
    input(1).intersect(input(0)).length > 0
}

def parseInput(input: String) = {
  input
    .split("\n")
    .map(parseSections)
    .map(hasIntersection)
    .count(s => s)
}

parseInput(input)





















