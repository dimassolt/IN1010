public class Hoved {
    public static void main(String[] args){
        Node<Integer> start = new Node<>(67);
        Node<Integer> neste = new Node<>(49);
        Node<Integer> nesteNeste = new Node<>(88);
        start.settNeste(neste);
        neste.settNeste(nesteNeste);
        
        Node<Integer> peker = start;

        while(peker != null){
            System.out.println(peker.element);
            peker = peker.neste;
        }
    }   
}
