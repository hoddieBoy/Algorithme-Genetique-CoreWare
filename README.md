# COREWARE

## Introduction

Application fournissant une interface graphique et un algorithm génétique
pour le jeu de CoreWar. Il est possible de savoir le vainqueur de la partie en
verifiant le score du joueur. Le score d'un joueur est le nombre d'instruction
DAT excecuter par son adversaire.
La generation d'un programme peut mettre du temps donc patienter jusqu'à l'ouverture
de la fenetre qui vous propose de choisir le warrior où l'on doit charger le programme généré

Les sources java de l'application sont tous dans le repertoire src/

## Utilitaire de commandes

Les commandes principales sont :
    -"ant init" a utilisé au premier téléchargement du programme(Obligatoire)
    -"ant install" pour installer toutes les librairies externes
    -"ant compile" pour compiler tout le projet
    -"ant javadoc" pour générer la javadoc (le fichier principal est alors doc/index.html) 
    -"ant clean" pour nettoyer le projet
    -"ant packaging" pour créer un jar contenant tous les .class
    -"ant run" pour lancer le programme (lancer au prealable "ant init")

## Notices

Le jar de l'application se trouvera dans le dossier dist/
Pour excecuter le jar veuillez taper la commande 
    java -jar dist/Corewar.jar

Ces commandes provoqueront l'installation des librairies externes (ce qui nécessite une connexion
internet) ainsi que la compilation.

La seule librairie externe utilisée est la librairie lombook qui est indispensable au bon fonctionnement
du projet

NB: Toute les commande sont à taper dans le repertoire principal de l'application
