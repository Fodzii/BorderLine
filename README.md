# BorderLine

PROJET BORDERLINE

----------------------------------------------------------------------

I-AUTEURS : 

Fabien BLANCHETON (Alternant)
Alaric QUACHERO (Alternant)

----------------------------------------------------------------------

I-CONCEPT DU JEU : 

a) Déroulements

  Le jeu se déroule dans un cadre où le jouer contrôle une ligne. Son but sera d'effectuer des tracés d'un bord à l'autre du cadre (où d'un bord au même bord). Une fois le tracé effectué, la zone comprise entre la ligne et le bord se colorera. Un ou plusieurs points (choix de l'utilisateur) se déplacera/ont au sein du cadre.
  
b) But

  Le but du joueur sera de "coincer" le ou les points dans une zone colorée sans être touché par ce dernier durant le tracé (il ne pourra pas être touché si il est sur un bord, que cela soit le bord du cardre ou la zone colorée).
  Le joueur aura gagné s'il parvient à "coincer" le point/tout les points dans une zone colorée ou si il réussit à colorer un certain pourcentage du cadre.
  
c) Déplacements

  Les déplacement s'effecturont horizontalement ou verticalement (pour la ligne, les points se déplaçant de manière aléatoire). Pour se faire quatre flèches (boutons) seront mis à disposition de l'utilisateur afin d'effectuer les déplacements

----------------------------------------------------------------------

II-TRAVAIL PREVU (EN FONCTION DE LA FICHE "Projet Android : DAM 2016/2017") :

1. Ajouter la sélection d’un objet dans l’écran de sélection :
On pourrait potentiellement proposer à l'utilisateur de choisir une autre forme qu'un point (une fusée par exemple) mais cela ne fait pas parti de nos priorités étant donné que beaucoup d'autres choses sont à gérer.

2. Afficher l’objet sélectionné dans l’écran de jeu :
L'utilisateur ne sélectionnera pas d'objet (sauf si nous avons le temps de permettre cela), donc il n'y aura pas l'affichage d'un objet sélectionné, mais un point sera affiché.

3. Ajouter un intrus de votre choix :
Nous n'ajouterons pas d'intrus étant donné qu'il n'y a pas d'utilité d'avoir un intrus pour notre projet.

4. Animer les objets de manière aléatoire* :
Nos points se déplaceront de manière aléatoire.

5. Gérer la sélection de l’intrus par le joueur :
Il n'y aura pas de gestion de sélection de l'intrus par le joueur, étant donné qu'il n'y a pas d'intrus dans notre jeu.

6. Ajouter des vibrations lorsqu’il se passe un évènement important :
Des vibrations seront ressenties lorqu'un point touche la ligne lors du tracé. Cela dépendra de la gestion du cas de défaite (voir III).

7. Afficher le score du joueur :
On pourrait afficher en lieu de score le pourcentage de zone recouvert par l'utilisateur. Nous ferrons cela si les autres foctionnalités seront faites en temps voulu (voir III).

8. Ajouter la sélection d’une couleur dans l’écran de sélection :
Nous mettrons à disposition de l'utilisateur le choix de la couleur du/des points et de la zone colorée.

9. Afficher l’objet sélectionné, dans la couleur sélectionnée :
L'affichage sera géré en fonction des paramètres séléctionnés.

10. Ajouter la sélection d’un nombre dans l’écran de sélection :
L'utilisateur pourra sélectionner le nombre de points (ce nombre pouvant aller de 1 à 5).

11. Afficher n fois l’objet sélectionné, dans la couleur sélectionnée :
L'affichage sera géré en fonction des paramètres séléctionnés.

12. Ajouter des sons adéquates lorsqu’il se passe un évènement surprenant :
Lorsque l'utilisateur gagnera une partie, un son de victoire l'avertira. Lorsqu'il perd une partie (lorqu'un point touche la ligne lors du tracé), en plus de la vibration, un son de défaite préviendra l'utilisateur.
On pourra éventuellement, selon le temps que nous disposont, mettre une musique d'ambiance.
Cela dépendra évidemment de la gestion des cas de victoire / défaite que nous auront pu faire (voir III).

13. Ajouter la sélection d’une vitesse dans l’écran de sélection :
L'utilisateur pourra sélectionner la vitesse des points qu'il désire.

14. Animer les objets avec la vitesse sélectionnée :
L'affichage sera géré en fonction des paramètres séléctionnés.

15. Ajouter un menu de configuration pour le niveau de difficulté :
Un menu de configuration pour le niveau de difficulté est utile que s'il y a une gestion de niveau de difficulté, ce qui sera, je pense, pas notre cas.

16. Ajouter des niveaux de difficulté :
La difficulté est liée aux paramètres choisis par l'utilisateur. Il serait possible de régler ces paramètres sur des valeurs convenues selon des niveaux de difficultés choisis. Cependant, nous préférons laisser entièrement le choix à l'utilisateur concernant les paramètres. De ce fait, nous n'ajouterons de "niveaux de difficulté".

----------------------------------------------------------------------

III-AUTRES TACHES A REALISER :

Certaines de ces fonctionnalités sont complexes à réaliser et nous n'aurons peut être pas le temps de toutes les mettre en place. Nous essaierons cependant d'en développer le plus grand nombre possible.

1. On proposera aussi à l'utilisateur de choisir la taille du/des point(s). 

2. Nous essaierons, en plus des conditions citées précédemment, d'établir un fichier de préférence dans lequel nous enregistrerons les choix de l'utilisateur.

3. En plus de cela nous essaierons de gérer correctement les collisions entre les points et la ligne (cela risque d'être un tâche complexe et on risque de ne pas parvenir à la finir).

4. Nous essaierons de gérer la colorisation d'une zone et son inaccessibilité au(x) point(s) (cette tâche aussi risque de s'avérer difficile et nous risquons de manquer de temps pour l'effectuer).

5. Nous essaierons de créer l'image du / des point(s) par le biais d'une description dans un fichier xml. Si nous ne parvenons pas à faire ceci, les points seront dessinés directement dans le canvas à l'aide d'une fonction (Canvas.drawCircle) ou par le biais d'une image au format png d'un point.
