public class Test {
    public static void main(String[] args) {
        // Manipulation classe Hippopotamus :
        Hippopotamus hippo1 = new Hippopotamus("hippo1", 500, 7);
        Hippopotamus hippo2 = new Hippopotamus("hippo2", 350, 5);
        Hippopotamus hippo3 = new Hippopotamus("hippo3", 230, 3);
        
        System.out.println(hippo1.fight(hippo2));
        hippo3.cicleVie();


        // Manipulation classe Point :
        Point point = new Point(1, 2);

        System.out.println(point.toString());


        // Manipulation classe Circle :
        Circle cercle = new Circle(point, 5);
        Point pointTest = new Point(2, 6);

        System.out.println(cercle.toString());
        System.out.println(cercle.containsPoint(pointTest));
    }
}