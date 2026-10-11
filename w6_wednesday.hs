import GHC.Base (VecElem (Int64ElemRep))
import System.Posix (SystemID (version))

-- Part 1: A familiar binary tree

data Tree a
  = Leaf a
  | Node (Tree a) (Tree a)
  deriving (Show, Eq)

tree1 :: Tree Int
tree1 =
  Node
    (Node (Leaf 1) (Leaf 2))
    (Node (Leaf 3) (Leaf 4))

tree2 :: Tree Int
tree2 =
  Node
    (Leaf 5)
    ( Node
        (Leaf 10)
        ( Node
            (Leaf 15)
            (Leaf 20)
        )
    )

-- Part 2:

mapTree :: (a -> b) -> Tree a -> Tree b
mapTree f (Leaf x) =
  Leaf (f x)
mapTree f (Node left right) =
  Node
    (mapTree f left)
    (mapTree f right)

doubleValue :: Int -> Int
doubleValue x = x * 2

squaredTree :: Tree Int
squaredTree = mapTree (^ 2) tree1

doubledTree :: Tree Int
doubledTree = mapTree doubleValue tree2

-- Part 3: Folding a Tree

foldTree :: (a -> b) -> (b -> b -> b) -> Tree a -> b
foldTree leafFn nodeFn (Leaf x) =
  leafFn x
foldTree leafFn nodeFn (Node left right) =
  nodeFn
    (foldTree leafFn nodeFn left)
    (foldTree leafFn nodeFn right)

-- functions with foldTree
treeSize :: Tree a -> Int
treeSize =
  foldTree
    (const 1)
    (+)

treeSum :: Tree Int -> Int
treeSum =
  foldTree
    id
    (+)

treeLeaves :: Tree a -> [a]
treeLeaves =
  foldTree
    (\x -> [x])
    (++)

treeMaximum :: Tree Int -> Int
treeMaximum =
  foldTree
    id
    max

treeHeight :: Tree a -> Int
treeHeight =
  foldTree
    (const 0)
    ( \leftHeight rightHeight ->
        1 + max leftHeight rightHeight
    )

-- Part 4: Applying a quadratic function to a tree

quadratic :: Int -> Int
quadratic x = x ^ 2 + 3 * x + 4

quadraticTree :: Tree Int
quadraticTree = mapTree quadratic tree1

quadraticLambdaTree :: Tree Int
-- quadraticLambdaTree = mapTree (\x -> x ^ 2 + 3 * x + 4) tree1
quadraticLambdaTree = mapTree (\x -> 1001) tree1

-- Exit Ticket
-- own quadratic, map to tree, lambda version

quadraticExit :: Int -> Int
quadraticExit x = x ^ 2 + 4 * x + 6

quadraticTreeExit :: Tree Int
quadraticTreeExit = mapTree quadraticExit tree1

quadraticLambdaTreeExit :: Tree Int
quadraticLambdaTreeExit = mapTree (\x -> x ^ 2 + 4 * x + 6) tree1
