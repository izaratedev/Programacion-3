package src;

import java.util.ArrayList;

import static java.util.Collections.addAll;

public class Tree {

    private TreeNode root;

    public Tree() {
        root = null;
    }


    public void printPreorder() {
         printPreorder(this.root);
    }

    private void printPreorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(" " + root.getValue());
        printPreorder(root.getLeft());
        printPreorder(root.getRight());
    }






    //Insertar nodo

    public void add(Integer value){

        if(this.root == null){
            this.root = new TreeNode(value);
        } else {
            add(this.root,value);
        }

    }

    private void add(TreeNode actual, Integer value){

        if(actual.getValue() > value){
            if(actual.getLeft() == null){
                actual.setLeft(new TreeNode(value));
            }else {
                add(actual.getLeft(),value);
            }
        } else if(actual.getValue() < value){
            if(actual.getRight() == null){
                actual.setRight(new TreeNode(value));
            }else {
                add(actual.getRight(),value);
            }
        }
    }

    public Integer getRoot(){
        return root.getValue();
    }

    public boolean hasElem(Integer value){
        if(this.root == null){
            return false;
        }else {
           return hasElem(this.root, value);
        }
    }

    private boolean hasElem(TreeNode actual, Integer value){
        if(actual.getValue() > value){
            if(actual.getLeft() != null){
                return hasElem(actual.getLeft(),value);
            }else{
                return false;
            }
        } else if(actual.getValue() < value){
            if(actual.getRight() != null){
                return hasElem(actual.getRight(),value);
            }else
                return false;
        }else
            return true;
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public Integer getMaxElem(){
        if(this.root == null){
            throw new IllegalArgumentException("El arbol esta vacio");
        } else {
            return getMaxElem(this.root);
        }
    }

    private Integer getMaxElem(TreeNode actual){
        if(actual.getRight() == null){
            return actual.getValue();
        } else {
            return getMaxElem(actual.getRight());
        }
    }
    public int getHeight(){
        if(this.root == null){
            return -1;
        }else {
            return this.getHeight(this.root);
        }
    }

    private int getHeight(TreeNode actual){

        if(actual == null){
            return -1;
        } else {

            int hLeft = getHeight(actual.getLeft());
            int hRight = getHeight(actual.getRight());

            return Math.max(hLeft, hRight) + 1;
        }
    }


    public ArrayList<Integer> getFrontera(){
        if(this.root == null){
            return new ArrayList<>();
        }
        return this.getFrontera(this.root);
    }

    private ArrayList<Integer> getFrontera(TreeNode actual){
        ArrayList<Integer> frontera = new ArrayList<>();

        if(actual == null){
            return frontera;
        } else {
            if(actual.getLeft() == null && actual.getRight() == null){
                frontera.add(actual.getValue());
            }
            frontera.addAll(getFrontera(actual.getLeft()));
            frontera.addAll(getFrontera(actual.getRight()));
            return frontera;
        }
    }

    public ArrayList<Integer> getLongestBranch(){
        ArrayList<Integer> longestBranch = new ArrayList<>();
        ArrayList<Integer> actualBranch = new ArrayList<>();
        if(this.root == null){
           return longestBranch;
        }
        this.getLongestBranch(this.root, actualBranch, longestBranch);

        return longestBranch;
    }

    private void getLongestBranch(TreeNode actual, ArrayList<Integer> actualBranch, ArrayList<Integer> longestBranch) {
        actualBranch.add(actual.getValue());

        if(actual.getLeft() == null && actual.getRight() == null){
            if(longestBranch.size() < actualBranch.size()){
                longestBranch.clear();
                longestBranch.addAll(actualBranch);
            }
        } else {
            if(actual.getLeft() != null){
                getLongestBranch(actual.getLeft(), actualBranch, longestBranch);
            }
            if(actual.getRight() != null){
                getLongestBranch(actual.getRight(), actualBranch, longestBranch);
            }
        }
        actualBranch.remove(actualBranch.size() - 1);

    }

    public ArrayList<Integer> getElemAtLevel(int level){
        ArrayList<Integer> elemAtLevel = new ArrayList<>();

        if(this.root == null){
            return elemAtLevel;
        } else {
          getElemAtLevel(this.root, elemAtLevel, level);
        }
        return elemAtLevel;
    }
    private void getElemAtLevel(TreeNode actual, ArrayList<Integer> elemAtLevel, int level) {
        if(actual == null){
            return;
        }
        if(level == 0){
            elemAtLevel.add(actual.getValue());
            return;
        }
        getElemAtLevel(actual.getLeft(), elemAtLevel, level - 1);
        getElemAtLevel(actual.getRight(), elemAtLevel, level - 1);

    }

    public boolean delete(Integer value){
        //Si raiz es null retorna falso
        if(this.root == null){
            return false;
        } else {
            if (root.getLeft() == null && root.getRight() == null && this.root.getValue() == value) {
                root = null;
                return true;
            } else if (root.getLeft() == null || root.getRight() == null && this.root.getValue() == value) {
                root = (root.getLeft() != null) ? root.getLeft() : root.getRight();
                return true;
            } else {
                return delete(this.root, null, value);
            }
        }
    }

    private boolean delete(TreeNode actual, TreeNode anterior, Integer value) {
        if(actual == null){
            return false;
        }
        if(actual.getValue().equals(value)){
            boolean borrado = false;
            if(actual.getLeft() == null && actual.getRight() == null){
                borradoUno(actual, anterior);
                borrado = true;
            }else if(actual.getLeft() == null || actual.getRight() == null){
                borradoDos(actual, anterior);
                borrado = true;
            }else {
                borradoTres(actual, anterior);
            }
            return borrado;

        }else if (actual.getValue() > value) {
            return delete(actual.getLeft(), actual, value);
        } else {
            return delete(actual.getRight(), actual, value);
        }
    }

    private void borradoUno(TreeNode actual, TreeNode anterior) {
        if(actual.getValue() > anterior.getValue()){
            anterior.setRight(null);
        }else {
            anterior.setLeft(null);
        }
    }

    private void borradoDos(TreeNode actual, TreeNode anterior) {
        //Preguntar donde tiene rama
        TreeNode aux;

        if(actual.getLeft() != null){
            aux = actual.getLeft();
        }else {
            aux = actual.getRight();
        }

        if(actual.getValue() > anterior.getValue()){
            anterior.setRight(aux);
        }else {
            anterior.setLeft(aux);
        }
    }
    private void borradoTres(TreeNode actual, TreeNode anterior) {
        TreeNode nmisd;

        nmisd = buscarNMISD(actual.getRight());

        delete(actual.getRight(), actual, nmisd.getValue());

        actual.setValue(nmisd.getValue());

    }

    private TreeNode buscarNMISD(TreeNode actual) {

            if(actual.getLeft() == null){
                return actual;
            }else {
                return buscarNMISD(actual.getLeft());
            }
    }

}
