// Classe Circle
classe Circle(point, radius) 
    point : Point
    radius : entier

    debut
        // - constructeur
        Circle(point, radius)
        debut
            this.point = point
            this.radius = radius
        fin

        // - area() : calcul l'aire du cercle
        fonction area()
        debut
            retourner pi * radius * radius
        fin

        // - containsPoint(point) : renvoie un Booléen; si le Point est dans le cercle alors TRUE sinon FALSE
        fonction containsPoint(point)
        debut
            si (this.point.getX() - point.getX())² + (this.point.getY() - point.getY())² < this.radius*this.radius alors
                renvoyer true
            sinon
                renvoyer false
            finsi
        fin

        // - toString()
        fonction toString()
        debut
            renvoyer "Le centre du cercle : x = " + this.point.getX() + ", y = " + this.point.getY() + ", rayon = " + this.radius
        fin
    fin
fin

programme main()
    cercle : Circle
    point : Point
    pointTest : Point

Debut
    point(1, 3)
    cercle(point, 5)
    pointTest(2, 6)

    // Afficher les données du cercle
    afficher cercle.toString()

    // Tester si un point est dans notre cercle
    afficher cercle.containsPoint(pointTest)
Fin