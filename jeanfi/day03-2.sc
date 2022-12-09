
val input = """vJrwpWtwJgWrhcsFMMfFFhFp
jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
PmmdzqPrVvPwwTWBwg
wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
ttgJtRGJQctTZtZT
CrZsJsPPZsGzwwsLwLmpwMDw"""

def getPriority(letter: Char): Int = {
  letter.isUpper match {
    case false  => ('a' to 'z').indexOf(letter) + 1
    case true => ('A' to 'Z').indexOf(letter) + 27
  }
}

def parseInput(input: String) = {
  input.split("\n")
    .map(s => s.toCharArray)
    .grouped(3).toArray
    .map(s => s(0).intersect(s(1)).intersect(s(2)).distinct.head)
    .map(getPriority)
    .sum
}

parseInput(input)





















