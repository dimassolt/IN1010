public class Node<E>{
    protected E element;
    protected Node<E> neste = null;
    public Node(E element){
        this.element = element;
    }
    public void settNeste(Node<E> neste){
        this.neste = neste;
    }
}