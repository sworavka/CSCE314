pairDifference :: (Int, Int) -> Int -- 1
pairDifference (a, b) = a - b

reversePair :: (a, b) -> (b, a) -- 2
reversePair (a, b) = (b, a)

sumPair :: (Int, Int) -> Int -- 3
sumPair (x, y) = x + y

makePair :: a -> b -> (a, b) -- 4
makePair x y = (x, y)

data Operation -- 5
  = Add Int Int
  | Subtract Int Int
  | Multiply Int Int
  deriving (Show)

evaluateOperation :: Operation -> Int -- 6
evaluateOperation (Add a b) = a + b
evaluateOperation (Subtract a b) = a - b
evaluateOperation (Multiply a b) = a * b

operationName :: Operation -> String -- 7
operationName (Add _ _) = "addition"
operationName (Subtract _ _) = "subtraction"
operationName (Multiply _ _) = "multiplication"

swapOperation :: Operation -> Operation -- 8
swapOperation (Add num1 num2) = (Add num2 num1)
swapOperation (Subtract num1 num2) = (Subtract num2 num1)
swapOperation (Multiply num1 num2) = (Multiply num2 num1)

totalOperands :: Operation -> Operation -> Int -- 9
totalOperands x y = sumOperand (x) + sumOperand (y)

sumOperand :: Operation -> Int -- helper function
sumOperand (Add x y) = x + y
sumOperand (Subtract x y) = x + y
sumOperand (Multiply x y) = x + y
