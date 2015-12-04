## Compilation et déploiement de l'application web sur BlueMix (OSX)

0. Pré-requis
    - Outils en ligne de commande Git
    - Apache Ant 1.9.x
    - Play! Framework 1.3.1
    - Installation de l'outil en ligne de commande CloudFoundry (https://github.com/cloudfoundry/cli)
    - Configuration de l'outil`
        * ``cf login -a https://api.ng.bluemix.net -o "benoit.sauvere+bluemixndli2015@gmail.com" -s "isoisndli2015"``
        * Login: benoit.sauvere+bluemixndli2015@gmail.com
        * Password: ********* (cf base de données KeePass commune)
        * Default application: NuitDeLinfo2015


1. Checkout des sources
    - ``git clone "https://github.com/ImpressiveSetOfIntelligentStudents/nuitinfo2015.git"``

2. Compilation des sources et création du war
    - ``play dependencies``
    - ``ant -f build/build.xml war``
       * Génère une fichier *.war* dans le folder ``build/dist/``

2. Déploiement des nouvelles sources
    - ``cf push "NuitDeLinfo2015" -m 1024M -p build/dist/ISOIS-NuitDeLinfo2015-.......war``

L'application est déployée et accessible ici : [http://nuitdelinfo2015.mybluemix.net/](http://nuitdelinfo2015.mybluemix.net/)



