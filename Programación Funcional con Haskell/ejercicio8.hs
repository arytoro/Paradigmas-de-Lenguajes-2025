eliminarRepetidos :: (Integral a) => [a] -> [a]
eliminarRepetidos []=[]
eliminarRepetidos (x:xs)
 | (elem x xs) = eliminarRepetidos xs
 | otherwise = [x] ++ eliminarRepetidos xs
 