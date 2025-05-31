enlace::(Integral a)=>[[a]]->[[a]]->[[a]]
enlace [] _=[]
enlace (x:xs) y = auxiliar x y : enlace xs y

auxiliar::(Integral a)=> [a]->[[a]]->[a]
auxiliar x []= head x:[(-1)]
auxiliar x (y:ys)
 |last x == head y= head x:tail y
 |otherwise= auxiliar x ys
 
 -- Seguimiento
sigue::(Integral a)=>[a]->[[a]]
sigue []=[]
sigue (x:xs)= (otra x xs)++sigue xs