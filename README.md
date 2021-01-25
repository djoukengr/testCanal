# testCanal
Ce dépot Github contient les sources de l'API et des tests cucumber permettant de tester la feature de modification de l'adresse d'un abonné.
 pour lancer l'API et exécuter les tests merci de suivre les instructions ci-dessous
 
 1. cloner le repertoire gitHub
   git clone https://github.com/djoukengr/testCanal
 2. se positionner dans le repertoire testCanal
    cd testCanal
 3. ensuite dans le repertoire executer les deux commandes ci-dessous selon que vous soyez sur Windows ou linux
    
    WINDOWS
   a. lancer l'api (assurer vous d'avoir la JVM et le compilateur java 1.8 installé)
       mvnw spring-boot:run  // cette commande va télécharger Tomcat et toutes les dépendances nécessaires pour compiler et déployer l'API.
	   
   b.   mvwn test  // permet d'executer les scenarii cucumber en faisant des appels reels sur l'API.
   
   LINUX
   a. donner les droit d'execution au fichier mvnw
       chmod 744 mvnw
   b. lancer l'API
     ./mvnw spring-boot:run
   c. Exécuter les tests (l'execution des tests fera des appels réels sur l'API
     mvnw test
 
 ================================
 Question3. Pour garantir la qualité du code j'ai mis en place.
   a. LA mise en place des tests avec Cucumber et l'execution automatisée des scenarri avec TestNG
   b. la lisibilité du code:
        En mettant les commentaires pour expliquer les traitements un peu complexes
		    En Décomposant les méthodes complexes en petites méthodes simples
		    En Evitant la duplication du code.
		    En utilisant autant que possible les noms intuitifs pour les variables, classes, Methodes  etc.
   c. L'usage du framework Spring qui repose sur le MVC et guarantit une séparation claire entre les données et les traitements facilitant la lecture la compréhension et la maintenabilité du code
      L'usage des Repository Spring pour gerer l'accès et la persistence des données ce qui réduit les risques d'erreur et risque d'injection SQL.
