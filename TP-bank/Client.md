// Classe Client

classe Client(idClient, nom, prenom, adresse, dateNaissance, IBAN, solde, idCompte)
    // identifiant client créé automatiquement (autoincrement)
    idClient : entier
    nom : chaine
    prenom : chaine
    adresse : chaine
    dateNaissance : date
    IBAN : chaine
    solde : réel
    // Un client peut avoir 0 ou 1 compte appli
    idCompte : entier 

debut
    // - constructeur (vide)
    Client()

    // - constructeur
    Client(nom, prenom, adresse, dateNaissance, IBAN, solde)
    debut
        this.nom = nom
        this.prenom = prenom
        this.adresse = adresse
        this.dateNaissance = dateNaissance
        this.IBAN = IBAN
        this.solde = solde
    fin

    // - GETTERS & SETTERS
    fonction getIdClient() : entier
    debut
        retourner idClient
    fin

    fonction getIdCompte() : entier
    debut
        retourner idCompte
    fin

    fonction setIdCompte(idCompte)
    debut
        this.idCompte = idCompte
    fin

    fonction getNom() : chaine
    debut
        retourner nom
    fin

    fonction getPrenom() : chaine
    debut
        retourner prenom
    fin

    fonction getAdresse() : chaine
    debut
        retourner adresse
    fin

    fonction getDateNaissance() : date
    debut
        retourner dateNaissance
    fin

    fonction getIBAN() : chaine
    debut
        retourner IBAN
    fin

    fonction getSolde() : réel
    debut
        retourner solde
    fin

    fonction setSolde(solde)
    debut
        this.solde = solde
    fin

    /* - getClientIBAN(IBAN) : retourne un objet Client en utilisant son IBAN
    ** sinon on déclanche une ERREUR
    */
    fonction getClientIBAN(IBAN) : Client
        client : Client
    debut
        client = chercherBDD(IBAN)
        si client != null alors
            retourner client
        sinon
            ERREUR "IBAN non valide"
        finsi
    fin

    // - creerCompte(identifiant, mdp) : Créer un compte appli pour le client
    fonction creerCompte(identifiant, mdp)
        compte : Compte
    debut
        // Vérifier que le client n'a pas déjà un compte Appli
        si this.idCompte != null alors
            ERROR "Le client a déjà un compte Appli !"
        sinon
            compte.setIdentifiant(identifiant)
            compte.setMDP(mdp)
            compte.setClient(this)
            this.idCompte = compte.getIdCompte()
        finsi
    fin
fin

