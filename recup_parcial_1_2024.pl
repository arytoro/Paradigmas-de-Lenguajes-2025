familia(persona(tomas_garcia, fecha(7,mayo,1980), trabajo(profesor,900)),
        persona(ana_lopez, fecha(10,marzo,1980), trabajo(docente,520)),
        [persona(juan_garcia, fecha(5,enero,2010), estudiante),
         persona(maria_garcia, fecha(12,abril,2012), estudiante)]).

familia(persona(jose_perez, fecha(6,marzo,1975), trabajo(pintor,800)),
        persona(maria_garcia, fecha(12,mayo,1976), trabajo(secretaria,600)),
        [persona(juan_luis_perez, fecha(5,febrero,2005), estudiante),
         persona(maria_jose_perez, fecha(3,julio,2015), estudiante),
         persona(jose_maria_perez, fecha(3,julio,2015), estudiante)]).

familia(persona(juan_luis_perez, fecha(5,febrero,2005), estudiante),
        persona(marisa_salva, fecha(10,mayo,2005), trabajo(comercio,700)),
        [persona(elena_perez, fecha(4,junio,2023), menor)]).

abuelo(X):-familia(persona(X,_,_),_,H),miembro(A,H),A=..L,miembro(Y,L),familia(persona(Y,_,_),_,_).
abuelo(X):-familia(persona(X,_,_),_,H),miembro(A,H),A=..L,miembro(Y,L),familia(_,persona(Y,_,_),_).

miembro(X,[X|_]).
miembro(X,[_|L]):- miembro(X,L).



