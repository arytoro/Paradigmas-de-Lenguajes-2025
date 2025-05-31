-- Recursivo
traduce::[String]->[[String]]->[String]
traduce [] _ = []
traduce (x:xs) y = auxiliar x y ++ traduce xs y

auxiliar::String->[[String]]->[String]
auxiliar _ []=["*"]
auxiliar x (y:ys)
 |elem x y= tail y
 |otherwise= auxiliar x ys
 
