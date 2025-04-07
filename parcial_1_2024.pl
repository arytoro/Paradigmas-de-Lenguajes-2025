afiliado([juan,hugo,mario,ana]).
activo(hugo).
pasivo(juan).
pasivo(ana).
adherente(mario).
grupoFamiliar(juan,[carlos,susy,carolina]).
grupoFamiliar(hugo,[mauricio]).
grupoFamiliar(mario,[]).
grupoFamiliar(ana,[ale,virginia,andres]).
mostrar(Y,Z):- afiliado(X),busca(X,Y,Z).
busca([],[],[]).
busca([X|Y],[X|L],Z):-activo(X),busca(Y,L,Z),!.
busca([X|Y],Z,[X|L]):-pasivo(X),busca(Y,Z,L),!.
busca([_|Y],Z,L):-busca(Y,Z,L),!.

noGrupoFamiliar:-afiliado(X),miembro(Y,X),grupoFamiliar(Y,Z),longitud(Z,Long),Long is 0, writeln(Y).

miembro(X,[X|_]).
miembro(X,[_|L]):-miembro(X,L).

longitud([],0).
longitud([_|L],R):-longitud(L,A),R is A+1.
