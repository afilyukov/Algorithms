public class Main {

    public static void main(String[] args) {
        Graph<String> graph = new Graph<>(10);
        graph.addVertex("Москва"); //0
        graph.addVertex("Тула");    //1
        graph.addVertex("Рязань");  //2
        graph.addVertex("Калуга");  //3
        graph.addVertex("Липецк");  //4
        graph.addVertex("Тамбов");  //5
        graph.addVertex("Орел");    //6
        graph.addVertex("Саратов"); //7
        graph.addVertex("Курс");    //8
        graph.addVertex("Воронеж");//9

        graph.addAdjacency(0, 1);
        graph.addAdjacency(0, 2);
        graph.addAdjacency(0, 3);
        graph.addAdjacency(1, 4);
        graph.addAdjacency(2, 5);
        graph.addAdjacency(3, 6);
        graph.addAdjacency(5, 7);
        graph.addAdjacency(6, 8);
        graph.addAdjacency(4, 9);
        graph.addAdjacency(5, 2);

        System.out.println(graph.getWay(graph.getVertex(9)));
    }
}