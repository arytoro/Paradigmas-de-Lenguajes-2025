sumaPoli::(Integral a)=>[[a]]->[[a]]->[[a]]
sumaPoli [] y= y
sumaPoli (x:xs) y= sumaPoli xs (auxiliar x y)

auxiliar::(Integral a)=> [a]->[[a]]->[[a]]
auxiliar x []=[x]
auxiliar x (y:ys)
 |last x == last y= [head x + head y,last x]:ys
 |last x > last y= x: (y:ys)
 |otherwise= y:(auxiliar x ys)


