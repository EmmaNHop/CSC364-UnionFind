
//Emma Hopkins -- this code reads the file's data
import java.io.*;
import java.util.*;
public class  Driver5 {
    public static UnionFind UF;
    public static Scanner input;
    public static File f;
    public static String fname;
    public static int x;
    public static int y;
    public static int w;
    public static int numVert;
    public static int numEdge;
    public static int KruskalCost;

    public static void main(String[] args) {
        System.out.print("Please enter a path or name of input file : ");
        input = new Scanner(System.in);
        fname = input.nextLine();
        f = new File(fname);
        try {
            input = new Scanner(f);
        } catch (Exception E) {
            System.out.println("File not found");
        }

        //reads number of vertices and edges
        numVert = Integer.parseInt(input.next());
        numEdge = Integer.parseInt(input.next());

        PriorityQueue<EdgeNode> PQ = new PriorityQueue<>();
        UF = new UnionFind(numVert);

        for(int i = 0; i < numEdge; i++) {
            x = input.nextInt(); //vertex 1 which points to vertex 2
            y = input.nextInt(); //vertex 2
            w = input.nextInt(); //weight of edge

            EdgeNode temp = new EdgeNode(x, y, w);
            PQ.add(temp);
        }


        while (PQ.size() > 0 &&  UF.Size() > 1) {
            EdgeNode E = PQ.poll();

            x = E.getVertex1(); //into int x
            y = E.getVertex2();// into int y

            if(UF.Find(x) != UF.Find(y)){ // edge will not cause a cycle in KruskalMCST
                UF.Union(x,y);
                System.out.println(E.getVertex1() + " " + E.getVertex2() + " Weight: " + E.getWeight());
                KruskalCost += E.getWeight();
            }
        }
        System.out.print("\n");
        System.out.println("Kruskal's Algorithm Cost : " + KruskalCost);
    }
}