## Tuto installation projet

- Télécharger Play 1.3.1 ([lien documentation Play](https://www.playframework.com/documentation/1.3.x/home))

  - Télécharger la lib en bas de la page  : [Framework Play 1.3.1](https://www.playframework.com/download)
  - La désarchiver quelque part, par exemple /Applications/DevTools/play-1.3.1

- Ouvrir un terminal dans le workspace de IDEA, chez moi ~/IdeaProjects/
- ajouter au path l'emplacement de play `export PATH=/Applications/DevTools/play-1.3.1/:$PATH` ou editez le .bash_profile
- lancer la commande `play new nuitinfo2015`
- ouvrir le dossier `cd nuitinfo2015`
- git init, git remote add origin <url du depot>, git reset --hard origin master
- vous pouvez maintenant ouvrir le ficheir nuitinfo2015.ipr avec Intellij.
- Lancer le projet avec `play run` ou `/Applications/DevTools/play-1.3.1/`
 503  rm app/controllers/Application.java
 504  git pull
 505  git pull origin master
 506  rm app/views/Application/index.html
 507  git pull
 508  git pull origin master
 509  rm app/views/errors/404.html
 510  git pull
 511  git pull origin master
 512  rm app/views/errors/500.html
 513  git pull origin master
 514  rm app/views/main.html
 515  git pull origin master
 516  rm conf/application.conf
 517  git pull origin master
 518  rm conf/dependencies.yml
 519  git pull origin master
 520  rm conf/messages
 521  git pull origin master
 522  git pull origin master -f
 523  git pull origin master --force
 524  git pull --force origin master
 525  git pull origin master
 526  rm conf/routes
 527  git pull origin master
 528  rm -fr documentation/
 529  git pull origin master
 530  rm -fr test/
 531  git pull origin maste
 532  git pull origin master

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
