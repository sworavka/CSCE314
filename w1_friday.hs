-- 1 done
cube :: Int -> Int
cube x = x * x * x

-- 2 done
addThree :: Int -> Int -> Int -> Int
addThree x y z = x + y + z

-- 3 done
surround :: Char -> String -> String
surround char str = [char] ++ str ++ [char]

-- 4 done
applyThreeTimes :: (a -> a) -> a -> a
applyThreeTimes f x = f (f (f x))
-- applyThreeTimes f x = f . f . f x

-- 5 done
combineResults :: (Int -> Int) -> (Int-> Int) -> Int -> Int
combineResults a b c = (a c) + (b c)

-- 6 done
sumTo :: Int -> Int
sumTo 0 = 0
sumTo x = x + sumTo(x - 1)

-- 7 done
countDown :: Int -> [Int]
countDown 0 = []
countDown x = x : (countDown(x-1))

-- 8 done
duplicateChars :: String -> String
duplicateChars "" = ""
duplicateChars (s:sx) = s : s : duplicateChars(sx)
