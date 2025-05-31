traspuesta :: [[a]] -> [[a]]
traspuesta x
  | null (head x) = []
  | otherwise = map head x : traspuesta (map tail x)
 