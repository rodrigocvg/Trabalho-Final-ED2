import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class App {


    //Carrega o arquivo contendo os vetores que vão compor um vértice
    public static ArrayList<ArrayList<Integer>> leArquivo() throws NumberFormatException, IOException{
        ArrayList<ArrayList<Integer>> lista = new ArrayList<>();
        try {
    
            FileReader ent = new FileReader ( "E:\\ED2\\TrabalhoFinal\\src\\listasVertices.txt" );
            BufferedReader br = new BufferedReader (ent);
            String linha ;
            String [] campos;
            while (( linha = br. readLine ()) != null )
            {
                ArrayList<Integer> l = new ArrayList<>();
                campos = linha.split(";");
                for(int i =0;i<campos.length;i++){

                    l.add(Integer.parseInt(campos[i]));

                }
                lista.add(l);
                
            }
            br.close();
        } 
        catch (ArrayIndexOutOfBoundsException erro)
        {
        System .out. println (" Erro na leitura do arquivo");
        }
        return lista;
    }



    public static Grafo comparaVertices(Grafo g) throws ArrayIndexOutOfBoundsException{
        Grafo g2 = new Grafo();
        float semelhancas = 0;
        for(int i=0;i<g.vertices.size();i++){
                for(int j =0;j<g.vertices.get(i).adj.size();j++){

                    for(int k =0;k<g.vertices.get(i).adj.get(j).numeros.size();k++){
                        if(g.vertices.get(i).numeros.contains(g.vertices.get(i).adj.get(j).numeros.get(k))){
                            g.vertices.get(i).adj.get(j).semelhancas++;
                            g.vertices.get(i).semelhancas++;
                            semelhancas++;
                        }
                    }
                }
        }

        float qtd = 0;
        for(int i=0;i<g.vertices.size();i++){
            if(g.vertices.get(i).semelhancas>0){
                qtd++;
            }
        }

        float media;
        media = semelhancas/qtd;
        System.out.println("Semelhancas totais dos vertices do grafo = "+ semelhancas);
        System.out.println("Quantidade de vertices que possuem semelhança: " + qtd);
            System.out.println("Mediana das semelhancas = " + media);

            for(int i=0;i<g.vertices.size();i++){


                if(g.vertices.get(i).semelhancas >= media){
                        
                            g2.addVertice(g.vertices.get(i).numeros);
                            //System.out.println("Tamanho lista adj do vertice " + i +" = " + g.vertices.get(i).adj.size());
                        for(int j =0;j<g.vertices.get(i).adj.size();j++){
                            if(g.vertices.get(i).adj.get(j).semelhancas>= media){
                                g2.vertices.get(i).addAdj(g.vertices.get(i).adj.get(j));
                            }
                        }   
                }
            }
        return g2;
    }


    public static void main(String[] args) throws ArrayIndexOutOfBoundsException,IOException{
        // SIMILIARIDADE DE UM VERTICE PARA OUTRO É A QUANTIDADE DE INTEIROS
        Grafo g = new Grafo(); //Grafo original

        ArrayList<ArrayList<Integer>> arquivo = leArquivo();

        Vertice[] vertices = new Vertice[20];


        for(int i =0;i<arquivo.size();i++){
            //Adicionando os vértices no grafo a partir de um arquivo
            vertices[i] = g.addVertice(arquivo.get(i));
        }


        //Adicionando adjacências no grafo original
        vertices[0].addAdj(vertices[4]);
        vertices[0].addAdj(vertices[5]);
        vertices[1].addAdj(vertices[6]);
        vertices[1].addAdj(vertices[3]);
        vertices[2].addAdj(vertices[3]);
        vertices[2].addAdj(vertices[7]);
        vertices[2].addAdj(vertices[3]);
        vertices[2].addAdj(vertices[8]);
        vertices[3].addAdj(vertices[9]);
        vertices[3].addAdj(vertices[8]);
        vertices[4].addAdj(vertices[8]);
        vertices[4].addAdj(vertices[11]);
        vertices[4].addAdj(vertices[6]);
        vertices[5].addAdj(vertices[8]);
        vertices[5].addAdj(vertices[11]);
        vertices[5].addAdj(vertices[0]);
        vertices[6].addAdj(vertices[10]);
        vertices[6].addAdj(vertices[11]);
        vertices[7].addAdj(vertices[8]);
        vertices[7].addAdj(vertices[11]);
        vertices[9].addAdj(vertices[8]);
        vertices[9].addAdj(vertices[11]);
        vertices[8].addAdj(vertices[0]);
        vertices[8].addAdj(vertices[11]);
        vertices[10].addAdj(vertices[8]);
        vertices[11].addAdj(vertices[8]);
        vertices[0].addAdj(vertices[12]);    //adicionar vértice 1;2
        vertices[0].addAdj(vertices[13]);     //adicionar vertice 8;7;6;5
        vertices[2].addAdj(vertices[14]);     //adicionar vertice 17;16;15;14

        //Printando o grafo original
        System.out.println(g.toString());

        //Chamando o método para criar o novo grafo a partir das adjacencias que possuem semelhanças
        Grafo g2 = comparaVertices(g);
        System.out.println("--------------------------------------");
        System.out.println("Grafo NOVO\n" + g2.toString2());

    }
}
