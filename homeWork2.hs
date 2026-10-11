-- Part 1
data Expr
    = Value Int
    | Add Expr Expr
    | Subtract Expr Expr
    | Multiply Expr Expr
    | Divide Expr Expr
    deriving (Show, Eq)

-- Part 3
removeSpaces :: String -> String
removeSpaces [] = []
removeSpaces (x:xs) = if x == ' ' then removeSpaces xs else x : removeSpaces xs

parseExpression :: String -> Expr
parseExpression str = 
    let str' = removeSpaces str
    in case str' of
        [] -> error "Empty expression"
        _  -> parseAddSub str'

-- Part 6
-- 10-3-2=5
parseAddSub :: String -> Expr
parseAddSub str = 
    let (left, op, right) = splitAtOperator str ['+', '-']
    in case op of
        '+' -> Add (parseAddSub left) (parseAddSub right)
        '-' -> Subtract (parseAddSub left) (parseAddSub right)
        _   -> parseMulDiv str

-- Part 7
parseMulDiv :: String -> Expr
parseMulDiv str =
    let (left, op, right) = splitAtOperator str ['*', '/']
    in case op of
        '*' -> Multiply (parseMulDiv left) (parseMulDiv right)
        '/' -> Divide (parseMulDiv left) (parseMulDiv right)
        _   -> parseNumber str

-- Part 4
parseNumber :: String -> Expr
parseNumber str = Value (read str :: Int)

eval :: Expr -> Int
eval (Value n) = n
eval (Add e1 e2) = eval e1 + eval e2
eval (Subtract e1 e2) = eval e1 - eval e2
eval (Multiply e1 e2) = eval e1 * eval e2
eval (Divide e1 e2) = eval e1 `div` eval e2

showExpr :: Expr -> String
showExpr (Value n) = show n
showExpr (Add e1 e2) = "Add (" ++ showExpr e1 ++ " " ++ showExpr e2 ++ ")"
showExpr (Subtract e1 e2) = "Subtract (" ++ showExpr e1 ++ " " ++ showExpr e2 ++ ")"
showExpr (Multiply e1 e2) = "Multiply (" ++ showExpr e1 ++ " " ++ showExpr e2 ++ ")"
showExpr (Divide e1 e2) = "Divide (" ++ showExpr e1 ++ " " ++ showExpr e2 ++ ")"

calculate :: String -> Int
calculate str = eval (parseExpression (removeSpaces str))

splitAtOperator :: String -> [Char] -> (String, Char, String)
splitAtOperator str ops =
    let (left, rest) = break (`elem` ops) str
    in case rest of
        [] -> (left, ' ', "")
        (op:right) -> (left, op, right)