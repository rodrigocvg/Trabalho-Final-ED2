import java.util.ArrayList;
import java.util.List;

public class Vertice {

    public ArrayList<Integer> numeros;
    public List<Vertice> adj; // mudei pra vertice
    public int semelhancas;

    public Vertice(ArrayList<Integer> x) {
        this.numeros = new ArrayList<>();
        for(int i =0;i<x.size();i++){
            this.numeros.add(x.get(i));
        }
        
        this.adj = new ArrayList<Vertice>();
    }



    void addAdj(Vertice e) {
        adj.add(e);
    }
    





    public List<Vertice> getAdj() {
        return adj;
    }

    public void setAdj(List<Vertice> adj) {
        this.adj = adj;
    }

    
  

}