import Data.Fixed (E0)

data Tree a
  = Leaf a
  | Node (Tree a) (Tree a)
  deriving (Show, Eq)

largeTree :: Tree Int
largeTree =
  Node
    ( Node
        ( Node
            ( Node
                ( Node
                    (Leaf 2)
                    (Leaf 5)
                )
                ( Node
                    (Leaf 8)
                    (Leaf 11)
                )
            )
            ( Node
                ( Node
                    (Leaf 14)
                    (Leaf 17)
                )
                ( Node
                    (Leaf 20)
                    (Leaf 23)
                )
            )
        )
        ( Node
            ( Node
                ( Node
                    (Leaf 26)
                    (Leaf 29)
                )
                ( Node
                    (Leaf 32)
                    (Leaf 35)
                )
            )
            ( Node
                (Leaf 38)
                (Leaf 41)
            )
        )
    )
    ( Node
        (Leaf 44)
        (Leaf 47)
    )

treeSize :: Tree a -> Int
treeSize (Leaf _) = 1
treeSize (Node left right) = treeSize left + treeSize right

treeHeight :: Tree a -> Int
treeHeight (Leaf _) = 0
treeHeight (Node left right) = 1 + max (treeHeight left) (treeHeight right)

treeSum :: Tree Int -> Int
treeSum (Leaf n) = n
treeSum (Node left right) = treeSum left + treeSum right

treeLeaves :: Tree a -> [a]
treeLeaves (Leaf n) = [n]
treeLeaves (Node left right) = treeLeaves left ++ treeLeaves right

listToTree :: [Int] -> Tree Int
listToTree (x : []) = Leaf x
listToTree x = Node (listToTree left) (listToTree right)
  where
    left = take ((length x) `div` 2) x
    right = drop ((length x) `div` 2) x
