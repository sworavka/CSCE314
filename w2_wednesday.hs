import Data.Fixed (E0)
import Foreign (allocaArray0)

student :: (String, Int)
student = ("Ada", 95)

firstOfPair :: (a, b) -> a
firstOfPair (x, _) = x

secondOfPair :: (a, b) -> b
secondOfPair (_, y) = y

swapPair :: (a, b) -> (b, a)
swapPair (x, y) = (y, x)

firstItem :: [a] -> a
firstItem (x : xs) = x

restOfList :: [a] -> [a]
restOfList (_ : xs) = xs

copyList :: [a] -> [a]
copyList [] = []
copyList (x : xs) = x : copyList xs

data TrafficLight
  = Red
  | Yellow
  | Green
  deriving (Show, Eq)

trafficAction :: TrafficLight -> String
trafficAction Red = "Stop"
trafficAction Yellow = "Caution"
trafficAction Green = "Go"

data Shape
  = Circle Double
  | Rectangle Double Double
  | Square Double
  deriving (Show)

area :: Shape -> Double
area (Circle r) = pi * r * r
area (Rectangle w h) = w * h
area (Square s) = s * s

data IntList
  = Empty
  | Cons Int IntList
  deriving (Show)

exampleList :: IntList
exampleList = Cons 4 (Cons 7 (Cons 2 Empty))

sumIntList :: IntList -> Int
sumIntList Empty = 0
sumIntList (Cons x xs) = x + sumIntList xs

lengthIntList :: IntList -> Int
lengthIntList Empty = 0
lengthIntList (Cons _ xs) = 1 + lengthIntList xs

-- print, sum, length

exampleList2 :: IntList
exampleList2 = Cons 1 (Cons 2 (Cons 3 (Cons 4 (Cons 5 Empty))))
