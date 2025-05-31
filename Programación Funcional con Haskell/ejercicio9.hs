binario :: (Integral a) => a -> [a]
binario x
 | x<2 = [x]
 | otherwise= (mod x 2) : binario (div x 2)