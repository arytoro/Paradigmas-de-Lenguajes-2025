-- x= "joya"
--ejer3::[Char]->[Char]
--ejer3 x= [drop i x| i <- [0..(length x)]]

--funcion::(Integral a)=>[[a]]->[[a]]
--funcion []=[]
--funcion x= (head x):(funcion (map tail (tail x)))

unir::(Ord a)=>[a]->[a]->[a]
unir [] y= y
unir (x:xs) y= unir xs (auxiliar x y)

auxiliar::(Ord a)=>a->[a]->[a]
auxiliar x []=[x]
auxiliar x (y:ys)
 |x <= y = x:(y:ys)
 |otherwise= y:auxiliar x ys