var input = "random"
var found = 0
var index = 14
while(found == 0 && input.length > 13) {
  if(input.slice(0, 14).distinct.length < 14) {
    input = input.slice(1, input.length)
    index+=1
  } else {
    found = index
  }
}
print(found)