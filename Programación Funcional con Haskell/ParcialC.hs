inserta::(Integral a)=> [a]->[a]->[a]
inserta [] y = y
inserta (x:xs) y = inserta xs (auxiliar x y)
 
 
auxiliar::(Integral a)=> a -> [a] -> [a]
auxiliar x []=[x]
auxiliar x (y:ys)
 |x<y= [x] ++ (y:ys)
 |x>y= [y] ++ (auxiliar x ys)
 |otherwise= (y:ys)

