// Classe Compte

classe Compte(idCompte, identifiant, mdp, client)
    // idCompte : Autoincremented
    idCompte : entier
    identifiant : chaine
    mdp : chaine
    // Un compte appli ne peut etre relié qu'à un seul client
    client : Client
    beneficiaires : Beneficiaire[]

debut
    // - constructeur
    Compte()

    // GETTERS & SETTERS
    fonction getIdCompte() : entier
    debut
        retourner idCompte
    fin

    fonction getIdentifiant() : chaine
    debut
        retourner identifiant
    fin

    fonction setIdentifiant(identifiant)
    debut
        this.identifiant = identifiant
    fin

    fonction getMDP() : chaine
    debut
        retourner mdp
    fin

    fonction setMDP(mdp)
    debut
        this.mdp = mdp
    fin

    fonction getClient() : Client
    debut
        retourner this.client
    fin

    fonction setClient(client)
    debut
        this.client = client
    fin

    fonction getBeneficiaires() : Beneficiaire[]
    debut
        retourner this.beneficiaires
    fin

    /* - getCompteIdentifiant(identifiant) : 
    ** retourne un objet Compte en se basant sur l'identifiant (unique)
    */
    fonction getCompteIdentifiant(identifiant) : Compte
        compte : Compte
    debut
        compte = chercherBDD(identifiant)
        si compte != null alors
            retourner compte
        sinon
            ERROR "Cet identifiant n'existe pas !"
        finsi
    fin

    // - getInfoClient() : Retourner une chaine avec les infos du client
    fonction getInfoClient() : chaine
    debut
        retourner "Nom : " + this.client.getNom() + \n +
                  "Prenom : " + this.client.getPrenom() + \n +
                  "Adresse : " + this.client.getAdresse() + \n +
                  "Date de naissance : " + str(this.client.getDateNaissance()) + \n +
                  "IBAN : " + this.client.getIBAN() + \n +
                  "Votre solde actuel est de : " + str(this.client.getSolde()) 
    fin

    // - addBenef(beneficiaire) : Ajouter un nouveau bénéficiaire
    fonction addBenef(beneficiaire)
    debut
        pourchaque benef dans this.beneficiaires
            si beneficiaire == benef alors
                ERROR "Ce bénéficiaire existe déjà !"
            finsi
        finpourchaque

        // Si le bénéficiaire n'existe pas alors on le rajoute
        this.beneficiaires.add(beneficiaire)
    fin

    // - updateBenef(beneficiaire) : Modifier un bénéficiaire qu'on sélectionne
    fonction updateBenef(beneficiaire)
    debut
        pourchaque benef dans this.beneficiaires
            si beneficiaire.getIdBenef() == benef.getIdBenef() alors
                benef.setNom(beneficiaire.getNom())
                benef.setPrenom(beneficiaire.getPrenom())
                benef.setIBAN(beneficiaire.getIBAN())
                sortie de la boucle
            finsi
        finpourchaque
    fin

    // - deleteBenef(beneficiaire) : Supprimer un bénéficiaire
    fonction deleteBenef(beneficiaire)
    debut
        pourchaque benef dans this.beneficiaires
            si beneficiaire == benef alors
                benef.supprimer()
                sortir de la boucle
            finsi
        finpourchaque
    fin
fin

/**************************************************************************/

programme authentification(boutonCreation)
    boutonCreation : booleen
    IBAN : chaine
    client : Client
    identifiant : chaine
    mdp : chaine
    compte : Compte

debut
    si boutonCreation alors
        // - Création d'un compte Appli pour un client avec IBAN
        afficher "Saisissez votre IBAN"
        saisir IBAN
        
        // try-catch
        essayer
            client = client.getClientIBAN(IBAN)

            afficher "Saisissez un identifiant"
            saisir identifiant
            faire
                afficher "Saisissez votre mot de passe"
                saisir mdp
                si mdp pasAssezFort alors
                    mdp = null
                finsi
            jusqu'a mdp != null

            client.creerCompte(identifiant, mdp)
            afficher "Votre compte Appli a bien été créé !"

        catch ERREUR e
            afficher e
        finEssayer

    sinon
        // Connexion à un compte (en supposant que les identifiants sont uniques)
        afficher "Saisissez un identifiant"
        saisir identifiant

        // try-catch
        essayer
            compte = compte.getCompteIdentifiant(identifiant)

            // 3 essais pour le mot de passe
            pour i de 1 à 3
                afficher "Saisissez votre mot de passe"
                saisir mdp

                si compte.getMDP() == mdp alors
                    afficher "Connexion réussie, bienvenu(e) à la page d'acceuil !"
                    sortir de la boucle
                sinon si i == 3
                    ERROR "Votre compte est bloqué après 3 mauvais essais !" 
                finsi
            finpour

        catch ERROR e
            afficher e
    finsi
        
fin