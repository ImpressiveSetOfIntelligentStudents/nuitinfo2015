## Tuto installation projet (OSX)

- Télécharger Play 1.3.1 ([lien documentation Play](https://www.playframework.com/documentation/1.3.x/home))

  - Télécharger la lib en bas de la page  : [Framework Play 1.3.1](https://www.playframework.com/download)
  - La désarchiver quelque part, par exemple /Applications/DevTools/play-1.3.1
  - /!\Conservez ce chemin pour plus tard !


- Ouvrir un terminal dans le workspace de IDEA, chez moi ~/IdeaProjects/
    - ajouter au path l'emplacement de play `export PATH=/Applications/DevTools/play-1.3.1/:$PATH` ou editez le .bash_profile
    - lancer la commande `play new nuitinfo2015`
    - ouvrir le dossier `cd nuitinfo2015`
    - ``git init && git remote add origin https://github.com/ImpressiveSetOfIntelligentStudents/nuitinfo2015.git && git fetch && git reset --hard origin/master && git push --set-upstream origin master``
    - ``play idealize``

    ![gif1](/tuto/gif1.gif)
    
  
- Vous pouvez maintenant ouvrir le fichier ``nuitinfo2015.ipr`` avec Intellij et faire:
    - Afficher la console (Alt + F12)
    - Lancer le projet avec `play run` ou `/Applications/DevTools/play-1.3.1/play run`. Elle est disponible sur [le port 9000](http://localhost:9000/)


- Vous pouvez également crée les Run Configuration Play! en suivant le tutoriel officiel [Running a Play application](https://www.jetbrains.com/idea/help/play-framework-1-x.html#d375214e645)
    - Permet de lancer le serveur avec le bouton "play"
    - Permet de debugger l'application