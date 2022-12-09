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

//def gestureFactory(input: String): Gesture = {
//  input match {
//    case o if o == "X" || o == "A" => Rock()
//    case o if o == "Y" || o == "B" => Paper()
//    case o if o == "Z" || o == "C" => Scissors()
//  }
//}

def manufactureLoss(input: List[String]): List[Gesture] = {
  input(0) match {
    case "A" => List(Rock(), Scissors())
    case "B" => List(Paper(), Rock())
    case "C" => List(Scissors(), Paper())
  }
}
def manufactureDraw(input: List[String]): List[Gesture] = {
  input(0) match {
    case "A" => List(Rock(), Rock())
    case "B" => List(Paper(), Paper())
    case "C" => List(Scissors(), Scissors())
  }
}
def manufactureWin(input: List[String]): List[Gesture] = {
  input(0) match {
    case "A" => List(Rock(), Paper())
    case "B" => List(Paper(), Scissors())
    case "C" => List(Scissors(), Rock())
  }
}

def gestureFactory(input: List[String]): List[Gesture] = {
  input(1) match {
    case "X" => manufactureLoss(input)
    case "Y" => manufactureDraw(input)
    case "Z" => manufactureWin(input)
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

def parseInput(input: String): List[Round] = {
  input.split("\n")
    .map(x => x.split(" ").toList)
    .map(gestureFactory)
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





















