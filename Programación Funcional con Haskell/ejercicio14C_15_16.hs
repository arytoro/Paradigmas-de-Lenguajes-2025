-- Ejercicio 14 C
funcionA :: (Integral a) => [[a]] -> [a]
funcionA l= [x|xs <- l,x <- xs]

-- Ejercicio 15
buscar::[[Char]]->[[Char]]
buscar []=[]
buscar (x:xs)= [p|p<-x,elem p ['a'..'z']]:buscar xs

-- Ejercicio 16
pp::(Integral a) => [[a]] -> [a]
pp [] = []
pp (x:xs) = [head x] ++ pp xs
