# PlanetWarsProyectoM3
## Membres:
---
-Sergio Herrera
-Jordi Cañas
-Carles Aguilar
-Robert Sánchez
-Susana Figueroa

## Descripció:
---
Projecte 2 del mòdul 15 de la clase AMS1 de programació d'aplicacións multiplataforma.
Consta d'un joc similar a Ogame en el que l'usuari poseeix planetes propis amb recursos, que es regeneren cada cert temps, i una armada, composta per naus i defenses 
estàtiques, que serveixen per protegir-nos d'atacs d'invasors que volen destruïr-nos. En resum, l'usuari ha d'invertir els recursos generats pel seu planeta en naus 
i defenses per tal de derrotar als invasors en batalles espacials i així protegir-se i a més, si guanya, obtenir uns plusos de recursos, de gran ajuda davant futures
invasións més difícils de superar.

## Requisits previs:
---
-IDE per a codi java OOP.
-Base de dades de oracle database

## Instruccións d'instal·lació i primer ús:
---
Instal·la la base de dades oracle i crea un usuari 'PLANETWARS' identificat per 'PLANETWARS'.
Dona-li estructura i inserta les dades necessaries fent ús dels scripts 1->4 (per ordre).

Per a obrir el joc cal executar des de l'IDE de preferència (capaç d'executar codi java) la classe java 'TerminalGame', situada a la ruta 'M3/src/paqueteMain/' des de
l'arrel del repositori.
Una vegada a dins, et farà falta registrar-te (prement la tecla '2' al menú), creant un perfil amb nom d'usuari i contrasenya que et permetrà fer loguin (tecla '1').
Ja fet el 'loguin', serà el moment de conquerir un planeta seleccionant l'opció corresponent del menú (tecla '+') i donant-li un nom a aquest.
Automaticament, rere batejar el planeta, apareixerà el menú de status on podràs:
Consultar els recursos dels que disposes al planeta (tecla '1').
Comprar naus i defenses per a la Teva armada (tecla 2, a escollir entre naus (1) o defenses (2)).
Millorar les tecnologíes del planeta (tecla '3', millora les característiques d'atac i defensa de les naus i defenses estàtiques que poseeixes).

Cada 3 minuts reps recursos per a les teves inversions i una amenaça d'atac i descripció de la flota enemiga. Aprofita per millorar la teva armada. 2 minuts després
començarà la lluita i, amb sort, seràs vençedor.
