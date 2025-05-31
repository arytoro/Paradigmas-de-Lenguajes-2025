contar :: (Integral a) => [a] -> a
contar x= sum[ 1 | y <- x, mod y 2 == 0]