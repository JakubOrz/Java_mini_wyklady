public class GenerycznyNode<T>{

    private T zawartosc;
    private GenerycznyNode<T> next;

    public GenerycznyNode(T parameter){
        this.zawartosc = parameter;
    }

    public T getZawartosc(){
        return zawartosc;
    }

    public void setZawartosc(T element){
        this.zawartosc = element;
    }

    public void setNext(GenerycznyNode<T> next){
        this.next = next;
    }

    public GenerycznyNode<T> getNext(){
        return this.next;
    }
}
