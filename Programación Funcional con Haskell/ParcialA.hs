-- Sin Recursion
cuentaarticulos::(Integral a)=>[[String]]->[String]->a
cuentaarticulos x y= sum [1|p<-x,q<-p,elem q y]

-- Recursivo
cuentaarticulosB::(Integral a)=>[[String]]->[String]->a
cuentaarticulosB [] _ = 0
cuentaarticulosB (x:xs) y= auxiliar x y + cuentaarticulosB xs y

auxiliar::(Integral a)=>[String]->[String]->a
auxiliar [] _= 0
auxiliar (x:xs) y
 |elem x y= 1+ auxiliar xs y
 |otherwise= auxiliar xs y

-- Seguimiento
test::(Integral a)=>[[a]]->[[a]]
test []=[]
test x = (head x):(test (map tail (tail x)))