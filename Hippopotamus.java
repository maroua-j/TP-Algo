public class Hippopotamus {
    public String nom;
    public double poids;
    public double tusksSize;

    /*****************Constructeur******************/
    Hippopotamus(String nom, float poids, float tusksSize) {
        this.nom = nom;
        this.poids = poids;
        this.tusksSize = tusksSize;
    }

    public void eat() {
        this.poids += 1;
    }

    public void swim() {
        this.poids -= 0.3;
    }

    public String fight(Hippopotamus hippo) {
        if (this.tusksSize > hippo.tusksSize)
            return this.nom + " a gagné le combat !";
        else  if (this.tusksSize < hippo.tusksSize)
            return hippo.nom + " a gagné le combat !";
        else
            return "Match nul !";
    }

    public void cicleVie() {
        for (int j=1; j<=21; j++) {
            for(int i=1; i<=15; i++) {
                eat();
                eat();
                swim();
                swim();
                swim();
            }

            System.out.println("Fin de la journée " + j + " : " + this.toString());
        }
    }

    public String toString() {
        return "Nom : " + this.nom + ", poids : " + this.poids + ", défense : " + this.tusksSize;
    }
}