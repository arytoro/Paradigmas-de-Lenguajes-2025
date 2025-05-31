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

/* Esta opción es mejor, no necesita analizar longitud ya que estamos buscando que haga match con una lista vacía
noGrupoFamiliar:-afiliado(X),miembro(Y,X),grupoFamiliar(Y,[]),writeln(Y).
*/

/*Esta variante es por si piden devolver literalmente una lista, y no listarlos con write*/
mostrarSinGrupoFamiliar(L):-afiliado(X),sinGrupoFamiliar(X,L).
sinGrupoFamiliar([],[]).
sinGrupoFamiliar([X|L],[X|R]):-grupoFamiliar(X,[]),sinGrupoFamiliar(L,R),!.
sinGrupoFamiliar([_|L1],L2):-sinGrupoFamiliar(L1,L2).


miembro(X,[X|_]).
miembro(X,[_|L]):-miembro(X,L).

longitud([],0).
longitud([_|L],R):-longitud(L,A),R is A+1.
