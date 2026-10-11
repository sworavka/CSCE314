-- zipWith
sums :: [Int]
sums = zipWith (+) [1, 2, 3] [10, 20, 30]

products :: [Int]
products = zipWith (*) [1 ..] [2, 4, 6, 8]

-- zip with our own functions
combineScore :: Int -> Int -> Int
combineScore exam bonus = exam + bonus

combineScores :: [Int]
combineScores = zipWith combineScore [70, 82, 91] [5, 3, 4]

largeOfTwo :: Int -> Int -> Int
largeOfTwo a b = max a b

bestValues :: [Int]
bestValues = zipWith largeOfTwo [3, 12, 7, 20] [5, 10, 9, 18]

-- binary tree
data Tree a = Leaf a | Node (Tree a) (Tree a)
  deriving (Show)

smallTree :: Tree Int
smallTree = Node (Leaf 3) (Leaf 4)

largeTree :: Tree Int
largeTree =
  Node
    (Node (Leaf 2) (Leaf 5))
    (Node (Leaf 7) (Leaf 1))

tree8 :: Tree Int
tree8 =
  Node
    ( Node
        ( Node
            (Leaf 1)
            (Leaf 2)
        )
        ( Node
            (Leaf 3)
            (Leaf 4)
        )
    )
    ( Node
        ( Node
            (Leaf 5)
            (Leaf 6)
        )
        ( Node
            (Leaf 7)
            (Leaf 8)
        )
    )

tree16 :: Tree Int
tree16 =
  Node
    ( Node
        ( Node
            ( Node
                (Leaf 1)
                (Leaf 2)
            )
            ( Node
                (Leaf 3)
                (Leaf 4)
            )
        )
        ( Node
            ( Node
                (Leaf 5)
                (Leaf 6)
            )
            ( Node
                (Leaf 7)
                (Leaf 8)
            )
        )
    )
    ( Node
        ( Node
            ( Node
                (Leaf 1)
                (Leaf 2)
            )
            ( Node
                (Leaf 3)
                (Leaf 4)
            )
        )
        ( Node
            ( Node
                (Leaf 5)
                (Leaf 6)
            )
            ( Node
                (Leaf 7)
                (Leaf 8)
            )
        )
    )

wordTree :: Tree String
wordTree = Node (Leaf "Left") (Leaf "Right")

-- structural recursion: count leaves
treeSize :: Tree a -> Int
treeSize (Leaf _) = 1
treeSize (Node left right) = (treeSize left) + (treeSize right)

treeHeight :: Tree a -> Int
treeHeight (Leaf _) = 0
treeHeight (Node left right) = 1 + max (treeHeight left) (treeHeight right)

sumTree :: Tree Int -> Int
sumTree (Leaf n) = n
sumTree (Node left right) = sumTree left + sumTree right
