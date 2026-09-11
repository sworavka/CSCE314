double :: Int -> Int
double x = x * 2

square :: Int -> Int
square x = x * x

isEven :: Int -> Bool
isEven x = mod x 2 == 0

greet :: String -> String
greet name = "Howdy, " ++ name

triple x = x * 3

startingValue :: Int
startingValue = 10

nextValue :: Int
nextValue = double startingValue

finalValue :: Int
finalValue = square nextValue

applyTwice :: (a -> a) -> a -> a
applyTwice f x = f (f x)

addBang :: String -> String
addBang s = s ++ "!"

copyString :: String -> String
copyString [] = []
copyString (c:cs) = c : copyString cs

reverseString :: String -> String
reverseString [] = []
reverseString (c:cs) = reverseString cs ++ [c]

repeatString :: Int -> String -> String
repeatString 0 _ = ""
repeatString n s = s ++ repeatString (n - 1) s
