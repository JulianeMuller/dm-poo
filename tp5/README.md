Partie 1 :

Description des dépendances

Web : Sert à construire des applications web

JPA : Sert à construire des bases de données en SQL.

Hibernate : Pour la base de données

H2 : Sert à avoir une base de donnée en mémoire rapide.

DevTools : Sert à avoir des configurations pour une bonne expérience de développement, comme un redémarrage rapide.

Thymeleaf : Template pour applications.

Spring boot : Permet de faciliter la configuration d'un projet Spring et de réduire le temps alloué au démarrage d'un projet.
Etape 13 :
	1- Nous avons paramétré l'url d'appel /greeting avec cette ligne : @RequestParam(name="nameGET", required=false, defaultValue="World".

	2- Nous avons choisi le fichier HTML à afficher avec cette ligne : @GetMapping("/greeting").

	3- On envoie le nom à qui nous disons bonjour avec cette ligne : model.addAttribute("nomTemplate", nameGET).

Etape 17 :
Avec la classe Adress dans model, on créée une table de données avec les paramètres Id, Creation et content.

Etape 18 :
@Entity informe Hibernate que ma classe est une table.

Etape 20 :
En faisant SELECT * FROM Adress on a bien le contenu de la table adress avec les informations données dans le fichier data.sql.

Etape 23 :
@Autowired est une annotation qui nous permet de faire l’injection de dépendances entre les beans de l’application.

Etape 30 :
Pour ajouter Bootstrap dans notre projet, il suffit de l'ajouter au depedencies dans le pom.

Partie 2 :

Etape 6 : 
1- Oui, on peut la récupérer en s'inscrivant sur le site de Darksky.

2- https://api.darksky.net/forecast/35027a4b564ddb80e37e51e4b2d6118a/"+lat+","+lon+"?lang=fr&exclude=hourly&exclude=daily&exclude=flags&units=si
	--> lag=fr permet de configurer les informations en Français et les exclude permettent d'éviter d'avoir des informations supplémentaires inutiles, le unit=si permet d'avoir les unités dans le système international.

3- Pour passer les paramètres d'appels, il faut mettre une méthode GET à la fin de l'URL : ?nomParametre=valeurParametre.
4- Pour afficher la température et la prévision météo du lieu visé par les coordonnées GPS, il faut les récupérer dans la classe Currently.

