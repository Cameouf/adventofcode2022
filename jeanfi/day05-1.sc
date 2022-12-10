
val rawInstructions = """move 1 from 2 to 1
move 3 from 1 to 3
move 2 from 2 to 1
move 1 from 1 to 2"""

val stacks = Array(
  Array("Z", "N"),
  Array("M", "C", "D"),
  Array("P")
)

case class Instruction(quantity: Int, from: Int, to: Int) {}

def parseInput(instructions: String) = {
  instructions
    .split("\n")
    .map(line => {
      val pattern = "move ([0-9]{1,2}) from ([0-9]{1,2}) to ([0-9]{1,2})".r
      val pattern(quantity, from, to) = line
      Instruction(quantity.toInt, from.toInt, to.toInt)
    })
    .foldLeft(stacks)(
    (stacks, instruction) => {
      stacks.zipWithIndex.map {
        case (stack, index) => {
          if(index == instruction.from - 1) {
            stack.slice(0, stack.length - instruction.quantity)
          } else if(index == instruction.to - 1) {
            val fromStack = stacks(instruction.from - 1)
            Array.concat(
              stack,
              fromStack.slice(fromStack.length - instruction.quantity, fromStack.length).reverse
            )
          } else {
            stack
          }
        }
      }
    }
  ).map(s => s.last).mkString

}

parseInput(rawInstructions)


















