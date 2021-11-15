// Classe Hippopotamus
classe Hippopotamus(nom,poids,tusksSize)
    nom : chaine // nom de l'hippo
    poids : réel // poids de l'hippo en kg
    tusksSize : réel // Taille des défenses

    // - constructeur
    Hippopotamus(nom,poids,tusksSize)
    début
        this.nom = nom
        this.poids = poids
        this.tusksSize = tusksSize
    fin

    // - eat() : gagne 1kg
    fonction eat()
    début
        this.poids = this.poids + 1
    fin

    // - swim() : perds 300g
    fonction swim()
    début
        this.poids = this.poids - 0.3
    fin

    // - Hippopotamus fight(Hippopotamus) : celui avec la plus grosse défense gagne
    fonction fight(hippo)
    début
        si this.tusksSize > hippo.tusksSize alors
            retourner this.nom + " a gagné le combat ! "
        sinon si this.tusksSize < hippo.tusksSize alors
            retourner hippo.nom + " a gagné le combat ! "
        sinon
            retourner "Match nul ! "
        finsi
    fin

    // - toString()
    fonction toString()
    debut
        retourner "nom : " + str(nom) + ", poids : " + str(poids) + ", tusksSize : " + str(tusksSize)
    fin

    // - cicleVie() : Démarer le cycle de vie
    fonction cicleVie()
    debut
        // 3 semaines = 21 jours
        pour jour de 1 à 21
            // On boucle sur toutes les heures pendant 15h
            pour i de 1 à 15
                this.eat().eat().swim().swim().swim()
            finpour

            // On affiche le résultat tous les soirs
            afficher "Fin de la journée " + jour + " : " + this.toString()
        finpour
    fin
fin

programme Hippopotame
    hippo1 : Hippopotamus
    hippo2 : Hippopotamus
    hippo3 : Hippopotamus

debut
    hippo1("hippo1", 500, 7)
    hippo2("hippo2", 350, 5)
    hippo3("hippo3", 230, 3)

    afficher hippo1.fight(hippo2) // Devrait afficher que hippo1 a gagné le combat

    // Démarer le cicle de vie pour hippo3
    afficher hippo3.cicleVie()
fin