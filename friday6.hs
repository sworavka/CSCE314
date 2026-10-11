-- CSCE 314 - Friday 6
-- TextTree

data TextTree
  = Word String
  | Join TextTree TextTree
  deriving (Show, Eq)

-- ------------------------------------------------------------
-- Sample Trees
-- ------------------------------------------------------------

smallTree :: TextTree
smallTree =
  Join
    (Word "functional")
    ( Join
        (Word "programming")
        (Word "matters")
    )

messageTree :: TextTree
messageTree =
  Join
    ( Join
        ( Join
            (Word "functional")
            (Word "programming")
        )
        ( Join
            (Word "uses")
            (Word "small")
        )
    )
    ( Join
        ( Join
            (Word "composable")
            (Word "functions")
        )
        ( Join
            (Word "to")
            ( Join
                (Word "model")
                (Word "structure")
            )
        )
    )

-- ------------------------------------------------------------
-- 1 . wordCount
-- ------------------------------------------------------------

wordCount :: TextTree -> Int
wordCount (Word _) = 1
wordCount (Join left right) = wordCount (left) + wordCount (right)

-- ------------------------------------------------------------
-- 2. treeWords
-- ------------------------------------------------------------

treeWords :: TextTree -> [String]
treeWords (Word s) = [s]
treeWords (Join left right) = treeWords left ++ treeWords right

-- ------------------------------------------------------------
-- 3. renderText
-- ------------------------------------------------------------

renderText :: TextTree -> String
renderText tree = unwords (treeWords tree)

-- ------------------------------------------------------------
-- 4. totalCharacters
-- ------------------------------------------------------------

totalCharacters :: TextTree -> Int
totalCharacters (Word s) = length s
totalCharacters (Join left right) = totalCharacters left + totalCharacters right

-- ------------------------------------------------------------
-- 5. longestWord
-- ------------------------------------------------------------

longestWord :: TextTree -> String
longestWord (Word s) = s
longestWord (Join left right)
  | length (longestWord left) >= length (longestWord right) = longestWord left
  | otherwise = longestWord right

-- ------------------------------------------------------------
-- 6 . mapWords
-- ------------------------------------------------------------

mapWords :: (String -> String) -> TextTree -> TextTree
mapWords f (Word x) =
  Word (f x)
mapWords f (Join left right) =
  Join
    (mapWords f left)
    (mapWords f right)

-- ------------------------------------------------------------
-- 7. treeSummary
-- ------------------------------------------------------------

treeSummary :: TextTree -> (Int, Int)
treeSummary tree = (wordCount tree, totalCharacters tree)

-- ------------------------------------------------------------
-- Challenge: foldTextTree
-- ------------------------------------------------------------

foldTextTree ::
  (String -> a) ->
  (a -> a -> a) ->
  TextTree ->
  a
foldTextTree wordFn joinFn (Word x) =
  wordFn x
foldTextTree wordFn joinFn (Join left right) =
  joinFn
    (foldTextTree wordFn joinFn left)
    (foldTextTree wordFn joinFn right)

-- ------------------------------------------------------------
-- Challenge: wordCountFold
-- ------------------------------------------------------------

wordCountFold :: TextTree -> Int
wordCountFold tree = foldTextTree (const 1) (+) tree
