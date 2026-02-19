public class NodeDouble<T>  {

   private T info;
   private NodeDouble<T> former;
   private NodeDouble<T> next;


    public NodeDouble(){
        info = null;
        next = null;
        former = null;
    }

    public NodeDouble(T info, NodeDouble<T> former, NodeDouble<T> next){
        this.info = info;
        this.former = former;
        this.next = next;
    }

    public T getInfo() {
        return info;
    }

    public NodeDouble<T> getNext() {
        return next;
    }

    public void setNext(NodeDouble<T> next) {
        this.next = next;
    }

    public NodeDouble<T> getFormer() {
        return former;
    }

    public void setFormer(NodeDouble<T> former) {
        this.former = former;
    }
}
