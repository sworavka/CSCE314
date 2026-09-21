type Vector = [Int]

vectorAdd :: Vector -> Vector -> Vector
vectorAdd [] [] = []
vectorAdd (x : xs) (y : ys) = x + y : vectorAdd xs ys

vectorSubtract :: Vector -> Vector -> Vector
vectorSubtract [] [] = []
vectorSubtract (x : xs) (y : ys) = x - y : vectorSubtract xs ys

scalarMultiply :: Int -> Vector -> Vector
scalarMultiply x y = map (x *) y

dotProduct :: Vector -> Vector -> Int
dotProduct [] [] = 0
dotProduct (x : xs) (y : ys) = x * y + dotProduct xs ys

vectorSum :: Vector -> Int
vectorSum x = foldr (+) 0 x

countPositive :: Vector -> Int
countPositive x = length (filter (> 0) x)

magnitudeSquared :: Vector -> Int
magnitudeSquared x = dotProduct x x

distanceSquared :: Vector -> Vector -> Int
distanceSquared x y = magnitudeSquared (vectorSubtract x y)
