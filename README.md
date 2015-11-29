## Tuto installation projet

- Installer le projet avec IDEA

    Créer un nouveau projet sur IDEA. L'IDE devrait vous proposer de créer le projet à partir d'un repo hébergé sur github.

- Télécharger Play 1.3.1 ([lien documentation Play](https://www.playframework.com/documentation/1.3.x/home))

  - Télécharger la lib en bas de la page  : [Framework Play 1.3.1](https://www.playframework.com/download)
  - La désarchiver quelque part

A partir de là, il faut appliquer une des deux méthodes. C'est au choix.
Si soucis avec la première, contacter Léo.
Avec la deuxième, Julien.

## Méthode sans ajouter la lib play au PATH

-   Configurer l'IDE
  - Ouvrir les préférences du logiciel et rechercher "playframework" dans le moteur de recherche. In the Working directory field, specify the Play framework working directory. This is the directory from which the commands of the play command-line utility are run. ![img1](/tuto/img1.png)

  - Ajouter la commande Play à son path et executer `play idealize` dans le terminal d'IDEA:  

            MAC-Leo:ISOIS_Nuit-info-2015 Leo$ export PATH={path to play}/:$PATH
            MAC-Leo:ISOIS_Nuit-info-2015 Leo$ play idealize
            ~        _            _
            ~  _ __ | | __ _ _  _| |
            ~ | '_ \| |/ _' | || |_|
            ~ |  __/|_|\____|\__ (_)
            ~ |_|            |__/   
            ~
            ~ play! 1.3.1, https://www.playframework.com
            ~
            ~ OK, the application is ready for Intellij Idea
            ~ Use File, Open Project... to open "nuitinfo2015.ipr"
            ~
    - Ouvrir les configuration du projet (Open module settings). Ajouter au projet IDEA une Global librarie play.1.3.1 ![img3](/tuto/img3.png)
    - Sur la vue module onglet dependencies, checker play.1.3.1 ![img2](/tuto/img2.png)


Voila, j'espère que votre IDE va faire le reste. Normalement vous devriez pouvoir lancer les tests JUnit et lancer le serveur sur le port 9000 avec la configuration suivante : ![img4](/tuto/img4.png)

## Méthode en ajoutant la lib play au path

- Ajouter la lib play a votre path (export PATH=$PATH:/CHEMIN/VERS/PLAY/play-1.3.1)
- Ouvrir votre projet
- Afficher la console (Alt + F12)
- "play run" lance l'application. Elle est disponible sur http://localhost:9000/
