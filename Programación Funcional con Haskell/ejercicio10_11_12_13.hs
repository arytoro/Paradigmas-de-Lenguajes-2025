-- Ejercicio 8
eliminarRepetidos :: (Integral a) => [a] -> [a]
eliminarRepetidos []=[]
eliminarRepetidos (x:xs)
 | (elem x xs) = eliminarRepetidos xs
 | otherwise = eliminarRepetidos xs ++ [x]
 
-- Ejercicio 10
union :: (Integral a) => [a] -> [a] -> [a]
union x y
 | x==[] = y
 | otherwise= union (tail x) ((head x):y)
 
principal :: (Integral a) => [a] -> [a] -> [a]
principal x y= eliminarRepetidos(union x y)

-- Ejercicio 11
sumaImag :: (Integral a) => [(a,a)] -> [a]
sumaImag x= [sum (map fst x) , sum (map snd x)]

-- Ejercicio 12
insertarOrden :: (Integral a) => [a] -> a -> [a]
insertarOrden [] y = [y]
insertarOrden (x:xs) y
 | x>y = [y] ++ (x:xs)
 | otherwise = [x] ++ insertarOrden xs y
 
 -- Ejercicio 13
sumarMatrices :: Num a => [[a]] -> [[a]] -> [[a]]
sumarMatrices [] [] = []
sumarMatrices (x:xs) (y:ys) = zipWith (+) x y : sumarMatrices xs ys


