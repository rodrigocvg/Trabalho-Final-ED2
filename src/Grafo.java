// Este é um exemplo simples de implementação de grafo representado por lista
// de adjacências

import java.util.List;
import java.util.ArrayList;

public class Grafo {
    List<Vertice> vertices;


    public Grafo() {
        vertices = new ArrayList<Vertice>();
    }





    Vertice addVertice(ArrayList<Integer> nome) {
        
        Vertice v = new Vertice(nome);
        vertices.add(v);
        return v;
    }




    @Override
    public String toString() {
        String r = "";
        try {
            for (Vertice u : vertices) {
                r += "Vertice{";
                for (int i = 0; i < u.numeros.size(); i++) {

                    r += "" + u.numeros.get(i) + ",";
                }
                r += "}";


                int i = 0;
                for (Vertice e : u.adj) {
                    Vertice v = u.adj.get(i);
                    i++;
                    r += " -> {";
                    for (int j = 0; j < v.numeros.size(); j++) {

                        r += v.numeros.get(j) + ",";
                    }
                    r += "}";
                }
                r += "\n";
            }

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("erro");
        }
        return  r;
    }

    public String toString2() throws ArrayIndexOutOfBoundsException {
        String r = "";
        try {
            for (Vertice u : vertices) {
                if (u.adj.size() == 0) {
                    System.out.print("");
                } else {


                    r += "Vertice{";
                    for (int i = 0; i < u.numeros.size(); i++) {
                            r += "" + u.numeros.get(i) + ",";
                    }
                    r += "}";
                    int i = 0;
                    for (Vertice e : u.adj) {
                        Vertice v = u.adj.get(i);
                        i++;

                        r += " -> {"; 
                        for (int j = 0; j < e.numeros.size(); j++) {
                            
                                r += v.numeros.get(j) + ",";
                        }
                        r += "}";
                    }
                    r += "\n";
                }
            }
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("erro");
            }

        
        return  r;
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertice> vertices) {
        this.vertices = vertices;
    }

    



  
}
