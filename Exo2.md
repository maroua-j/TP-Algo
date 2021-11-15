//Classe Point
classe Point(x, y)
    x: entier
    y: entier

    début
        fonction getX()
        Debut
            Retourner x
        Fin

        fonction setX(valX)
        Debut
            x = valX
        Fin

        fonction getY()
        Debut
            Retourner y
        Fin

        fonction setY(valY)
        Debut
            y = valY
        Fin

        // - Constructeur
        Point(x, y)
        debut
            this.x = x
            this.y = y
        fin

        // - toString()
        fonction toString()
        debut
            retourner "x = " + this.x + ", y = " + this.y
        fin
fin

programme main()
    point: Point

Debut
    point.setX(1)
    point.setY(2)

    afficher point.toString()
Fin