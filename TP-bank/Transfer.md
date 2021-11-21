// Classe Transfer

classe Transfer(idTransfer, idCompte, beneficiaire, dateEnvoi, montant, description)
    // AutoIncermented
    idTransfer : entier
    // Identifiant du compte qui a réalisé le transfert
    idCompte : entier
    beneficiaire : Beneficiaire
    dateEnvoi : date
    montant : double
    devise : chaine
    description : chaine

debut
    // - constructeur
    Transfer(idCompte, beneficiaire, dateEnvoie, montant, devise, description)
    debut
        this.idCompte = idCompte
        this.beneficiaire = beneficiaire
        this.montant = montant
        this.devise = devise
        this.description = description

        si dateEnvoi != null alors
            this.dateEnvoi = dateEnvoi
        sinon
            this.dateEnvoi = dateAujourdhui
        finsi
    fin
fin

/**************************************************************************/

programme Transfer(compte, beneficiaire)
    transfer : Transfer
    compte : Compte
    beneficiaire : Beneficiaire
    montant : double
    devise : chaine
    description : chaine
    dateEnvoi : date
    pays : chaine

debut
    afficher "Saisissez le montant que vous voulez transférer"
    saisir montant

    afficher "Saisissez une description (optionnel)"
    saisir description

    afficher "Saisissez la date d'envoi (si vide alors aujourdhui)"
    saisir dateEnvoi

    // On suppose que l'on peut faire un transfert même si on n'a pas assez d'argent
    // Tester si le bénéficiaire a été ajouté / modifié il y a minimum 24h

    si (beneficiaire.getDateAjoutUpdate() + 24h) > dateEnvoi alors
        afficher "Le bénéficiaire n'a pas encore été confirmé !"
    sinon
        // Tester si le bénéficiaire est français ou étranger
        si extraire(beneficiare.getIBAN(), 0, 1) == "FR" alors
            transfer = Transfer(compte.getIdCompte(), beneficiaire, dateEnvoi, montant, "euro", description)
            compte.getClient().setSolde(compte.getClient().getSolde() - montant)
        sinon
            // On enlève le montant saisi en euro ensuite on le stock dans le transfert converti
            compte.getClient().setSolde(compte.getClient().getSolde() - montant)
            pays = extraire(beneficiare.getIBAN(), 0, 1)

            // On suppose que la fonction transformerToDevise(...) renvoie un montant converti de l'euro vers la devise du pays
            montant = pays.transformerToDevise(montant)
            devise = pays.getDevise()
            transfer = Transfer(compte.getIdCompte(), beneficiaire, dateEnvoi, montant, devise, description)
        finsi
    finsi
fin