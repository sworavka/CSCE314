countRange :: Int -> Int -> [Int]
countRange a b = [a .. b]

firstMultiples :: Int -> Int -> [Int]
firstMultiples a b = take b [a, a + a ..]

squaresThrough :: Int -> [Int]
squaresThrough a = take a [x * x | x <- [1 ..]]

multiplesThrough :: Int -> Int -> [Int]
multiplesThrough a b = take b [x | x <- [1 .. b], mod x a == 0]

scaleValues :: Int -> [Int] -> [Int]
scaleValues a b = map (* a) b

keepAbove :: Int -> [Int] -> [Int]
keepAbove a b = filter (> a) b

sumSquaresThrough :: Int -> Int
sumSquaresThrough a = foldr (+) 0 (squaresThrough a)

sumScaledMultiples :: Int -> Int -> Int -> Int
sumScaledMultiples a b c = foldr (+) 0 (scaleValues b (multiplesThrough a c))
