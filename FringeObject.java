public class FringeObject implements Comparable <FringeObject> {
    private Node current;
    private Node prev;
    private double g;
    private double f;

    public FringeObject(Node current, Node prev, double g, double f){
        this.current = current;
        this.prev = prev;
        this.g = g;
        this.f = f;
    }
    public Node getCurrent(){return current;}
    public Node getPrev() {return prev;}
    public double getG() {return g;}
    public double getF() {return f;}

    //for priorityQueue in A_Search
    @Override
    public int compareTo(FringeObject fringeObject) {
        if(this.f<fringeObject.f){
            return -1;
        }
        else if(this.f>fringeObject.f){
            return 1;
        }
        else{
            return 0;
        }
    }
}
