// Classe Beneficiaire

classe Beneficiaire(idBenef, IBAN, nom, prenom)
    // idBenef créé automatiquement (autoincrement)
    idBenef : entier
    IBAN : chaine
    nom : chaine
    prenom : chaine
    // JJ/MM/YYYY HH:MM:SS
    dateAjoutUpdate : date

debut
    // - constructeur
    Beneficiaire(IBAN, nom, prenom)
    debut
        this.IBAN = IBAN
        this.nom = nom
        this.prenom = prenom
        this.dateAjoutUpdate = dateAujourdhui
    fin

    // - GETTERS & SETTERS
    fonction getIdBenef() : entier
    debut
        retourner idBenef
    fin

    fonction getNom() : chaine
    debut
        retourner nom
    fin

    fonction setNom(nom)
    debut
        this.nom = nom
    fin

    fonction getPrenom() : chaine
    debut
        retourner prenom
    fin

    fonction setPrenom(prenom)
    debut
        this.prenom = prenom
    fin

    fonction getIBAN() : chaine
    debut
        retourner IBAN
    fin

    fonction setIBAN(IBAN)
    debut
        this.IBAN = IBAN
        this.dateAjoutUpdate = dateAujourdhui
    fin

    fonction getDateAjoutUpdate() : date
    debut
        retourner dateAjoutUpdate
    fin

    // - getInfoBenef() : Retourne une chaine avec les info du bénéficiaire
    fonction getInfoBenef() : chaine
    debut
        retourner "Nom : " + nom + \n +
                  "Prenom : " + prenom + \n +
                  "IBAN : " + IBAN
    fin
fin