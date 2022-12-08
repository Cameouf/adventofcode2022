function compareNumbers(a, b) {
  return a - b;
}

let transform = (input) => 
  input.match(/([0-9]+\n)*/g)
        .filter(x => x != "")
        .map(x => 
          x.split("\n")
          .slice(0, -1)
          .map(x => parseInt(x))
          .reduce((a,c) => a+c, 0) 
        )
        .sort(compareNumbers)
        .reverse()
        .slice(0, 3)
        .reduce((a,c) => a+c, 0) 