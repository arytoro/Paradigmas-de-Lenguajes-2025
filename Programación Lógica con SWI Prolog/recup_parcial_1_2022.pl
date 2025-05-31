afiliado([juan, hugo, mario, alicia]).
docente(hugo).
noDocente(juan).
noDocente(alicia).
limpieza(mario).
grupoFamiliar(juan, [carlos, ana, carolina]).
grupoFamiliar(hugo, [mauricio]).
grupoFamiliar(mario, []).
grupoFamiliar(alicia, [evangelina, virginia, andres]).

ver(Y, Z):- afiliado(X), sigue(X, Y, Z).
sigue([], [], []).
sigue([X|Y], [X|L], Z):- docente(X), sigue(Y, L, Z), !.
sigue([X|Y], Z, [X|L]):- noDocente(X), sigue(Y, Z, L), !.
sigue([_|Y], Z, L):- sigue(Y, Z, L), !.

generarListaFamNum(L):-afiliado(X),famNum(X,L).
famNum([],[]).
famNum([X|L],[X|A]):-grupoFamiliar(X,B),longitud(B,C),C>=3,famNum(L,A),!.
famNum([_|L],A):-famNum(L,A).
longitud([],0).
longitud([_|L],R):-longitud(L,A),R is A+1.


