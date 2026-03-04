package src;

public class Main {
    public static void main(String[] args) {

        Tree tree = new Tree();




        tree.add(6);
        tree.add(4);
        tree.add(19);
        tree.add(3);
        tree.add(2);
        tree.add(5);
        tree.add(12);
        tree.add(27);
        tree.add(10);
        tree.add(9);

        tree.printPreorder();

        System.out.println(" ");

        System.out.println(tree.delete(25));

        tree.printPreorder();
    }
}
