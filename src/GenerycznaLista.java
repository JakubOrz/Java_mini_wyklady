public class GenerycznaLista<T extends Checkable> {

private GenerycznyNode<T> first;
private GenerycznyNode<T> last;
private int count;

public GenerycznaLista(){
    this.first = null;
    this.count = 0;
}

public GenerycznaLista<T> add(T element){
    this.count ++;

    if (!element.validate()){
        System.out.println("Niepoprawny element");
        return this;
    }

    if (this.first == null){
        this.first = new GenerycznyNode<T>(element);
        this.last = this.first;
    }
    else {
        this.last.setNext(new GenerycznyNode<T>(element));
        this.last = this.last.getNext();
    }
    return this;
}

public void showAll(){
    GenerycznyNode<T> tmp = this.first;
    while (tmp != null){
        System.out.println(tmp.getZawartosc().toString());
        tmp = tmp.getNext();
    }
}



}
