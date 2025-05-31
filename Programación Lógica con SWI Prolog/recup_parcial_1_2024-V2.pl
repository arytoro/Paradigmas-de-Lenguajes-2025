equipocatedra(algoritmos, [docente(mario, titular), docente(hugo, adjunto), docente(monica, jtp)]).
equipocatedra(basica, [docente(jorge, adjunto), docente(marisa, jtp)]).
equipocatedra(computacion, [docente(nestor, titular), docente(liliana, adjunto)]).

/*
a) equipocatedra(X,[docente(A,titular)|_]).
b) equipocatedra(X,[_|[]]).
c) equipocatedra(_,[docente(isabel,titular)|_]).
*/


nomCant(X,Y):-equipocatedra(X,L),cantidad(L,Y).
cantidad([],0).
cantidad([_|L],R):-cantidad(L,A),R is A+1.
