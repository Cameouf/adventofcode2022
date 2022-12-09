trait Gesture {
  def score: Int
}
case class Rock() extends Gesture {
  override def score: Int = 1
}
case class Paper() extends Gesture {
  override def score: Int = 2
}
case class Scissors() extends Gesture {
  override def score: Int = 3
}
case class Round(
                  opponentMove: Gesture,
                  playerMove: Gesture
                ) {}

def gestureFactory(input: String): Gesture = {
  input match {
    case o if o == "X" || o == "A" => Rock()
    case o if o == "Y" || o == "B" => Paper()
    case o if o == "Z" || o == "C" => Scissors()
  }
}

val WIN  = 6
val DRAW = 3
val LOSS = 0

def getRoundScore(
                   opponentMove: Gesture,
                   playerMove: Gesture
                 ): Int = {
  val result = (opponentMove, playerMove) match {
    case (o: Rock,     p: Rock)        => DRAW
    case (o: Rock,     p: Paper)       => WIN
    case (o: Rock,     p: Scissors)    => LOSS
    case (o: Paper,    p: Rock)        => LOSS
    case (o: Paper,    p: Paper)       => DRAW
    case (o: Paper,    p: Scissors)    => WIN
    case (o: Scissors, p: Rock)        => WIN
    case (o: Scissors, p: Paper)       => LOSS
    case (o: Scissors, p: Scissors)    => DRAW
  }
  result + playerMove.score
}

// A X Rock
// B Y Paper
// C Z Scissors
val moves = List(
  Round(Rock(), Paper()),
  Round(Paper(), Rock()),
  Round(Scissors(), Scissors())
)

def parseInput(input: String): List[Round] = {
  input.split("\n")
    .map(x => x.split(" ").map(gestureFactory))
    .map(x => Round(x(0), x(1)))
    .toList
}

val input = """A Y
B X
C Z"""

parseInput(input).foldLeft(0)(
  (totalScore, round) => {
    totalScore + getRoundScore(round.opponentMove, round.playerMove)
  }
)





















