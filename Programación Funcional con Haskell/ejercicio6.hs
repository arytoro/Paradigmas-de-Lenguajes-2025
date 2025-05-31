
maximoElementos :: [[a]]->Int
maximoElementos l= maximum [length y| y <- l]
--maximoElementos l= maximum(map length l)