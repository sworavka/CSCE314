-- ranges
numbers :: [Int]
numbers = [1 .. 10]

evens :: [Int]
evens = [2, 4 .. 20]

countByFives :: [Int]
countByFives = [5, 10 .. 50]

naturals :: [Int]
naturals = [1 ..]

evenStream :: [Int]
evenStream = [2, 4 ..]

-- List Comprehensions

squares :: [Int]
squares = [x * x | x <- evenStream]

multiplesOfThree :: [Int]
multiplesOfThree = [x | x <- [1 .. 30], mod x 3 == 0]

evenSquares :: [Int]
evenSquares = [x * x | x <- [1 .. 20], even x]

-- named helper functions

triple :: Int -> Int
triple x = x * 3

isLarge :: Int -> Bool
isLarge x = x > 20

-- Higher Order functions

tripledNumbers :: [Int]
tripledNumbers = map triple numbers

largeTriples :: [Int]
largeTriples = filter isLarge tripledNumbers

totalLargeTriples :: Int
totalLargeTriples = foldr (+) 0 largeTriples

-- exitTicket

-- gen list (one range one comp), higher orderfunction on each (different)

cntByQuadruplesR :: [Int]
cntByQuadruplesR = [4, 8 .. 40]

cntByQuadruplesC :: [Int]
cntByQuadruplesC = [x * 4 | x <- numbers]

tripledQuadruples :: [Int]
tripledQuadruples = map triple cntByQuadruplesR

largeQuadruples :: [Int]
largeQuadruples = filter isLarge cntByQuadruplesC
