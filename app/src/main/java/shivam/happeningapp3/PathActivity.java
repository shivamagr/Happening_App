package shivam.happeningapp3;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.app.Activity;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;


public class PathActivity extends ActionBarActivity{

   // EditText source;
    //EditText dest;
    TextView text,spinnertext, spinnertext2;
    Dijkstra d ;
    Spinner spinner1, spinner2;
    String source, dest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path);

        //source = (EditText)findViewById(R.id.source);
        //dest = (EditText)findViewById(R.id.dest);
        text = (TextView)findViewById(R.id.mypath);

        spinner1 = (Spinner) findViewById(R.id.spinner4);
        spinner2 = (Spinner) findViewById(R.id.spinner5);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.rooms, android.R.layout.simple_spinner_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(onItemSelectedListener1);

        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.rooms, android.R.layout.simple_spinner_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(onItemSelectedListener2);

        //source = spinnertext.toString();
        //dest = spinnertext2.toString();

        //d = new Dijkstra(source.getText().toString(), dest.getText().toString());

       /* d.setstart(source.getText().toString());
        d.setend(dest.getText().toString());*/



    }

    AdapterView.OnItemSelectedListener onItemSelectedListener1 =
            new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    spinnertext = (TextView)view;
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            };
    AdapterView.OnItemSelectedListener onItemSelectedListener2 =
            new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    spinnertext2 = (TextView)view;
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            };

    public void showpath(View view)
    {
        /*ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.rooms, android.R.layout.simple_spinner_item);
        spinner1.setAdapter(adapter);*/
        //spinner1.setOnItemSelectedListener(onItemSelectedListener1);

        /*ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.rooms, android.R.layout.simple_spinner_item);
        spinner2.setAdapter(adapter2);*/
        //spinner2.setOnItemSelectedListener(onItemSelectedListener2);

        source = spinnertext.getText().toString();
        dest = spinnertext2.getText().toString();

        //text.setText(source+","+dest);


        //text.setText("  ");
        d = new Dijkstra(source, dest);
        text.setText(d.main());
        //text.setText(source.getText().toString() + "- " + dest.getText().toString());
    }

    public  void menu(View view)
    {
        Intent i = new Intent(view.getContext(), MainActivity.class);
        startActivity(i);
    }

}


/*******************************************************************************************/

class Dijkstra{

    private static String START ;
    private static String END;

    Dijkstra(String s1, String s2){

        START = s1;
        END = s2;

    }

    private static final Graph.Edge[] GRAPH = {
            new Graph.Edge("Library", "Data Acquisation Centre", 1),
            new Graph.Edge("Data Acquisation Centre","Library",  1),
            new Graph.Edge("Library", "Toilet", 1),
            new Graph.Edge("Toilet","Library",  1),
            new Graph.Edge("Toilet", "Store", 1),
            new Graph.Edge( "Store","Toilet", 1),
            new Graph.Edge("Data Acquisation Centre", "SW2 lab", 1),
            new Graph.Edge( "SW2 lab","Data Acquisation Centre", 1),
            new Graph.Edge("Data Acquisation Centre", "Store", 1),
            new Graph.Edge( "Store","Data Acquisation Centre", 1),
            new Graph.Edge("Store", "x", 1),
            new Graph.Edge("x","Store",  1),
            new Graph.Edge("SW2 lab", "x", 1),
            new Graph.Edge( "x","SW2 lab", 1),
            new Graph.Edge("SW2 lab", "Exam Room", 1),
            new Graph.Edge( "Exam Room","SW2 lab", 1),
            new Graph.Edge("x", "IIIT kota", 1),
            new Graph.Edge( "IIIT kota","x", 1),
            new Graph.Edge("Exam Room", "IIIT kota", 1),
            new Graph.Edge("IIIT kota","Exam Room",  1),
            new Graph.Edge("Exam Room", "Ph.D. Scholars", 1),
            new Graph.Edge( "Ph.D. Scholars","Exam Room", 1),
            new Graph.Edge("IIIT kota", "Project lab", 1),
            new Graph.Edge( "Project lab","IIIT kota", 1),
            new Graph.Edge("Ph.D. Scholars", "Project lab", 1),
            new Graph.Edge("Project lab","Ph.D. Scholars",  1),
            new Graph.Edge("Ph.D. Scholars", "a", 1),
            new Graph.Edge( "a","Ph.D. Scholars", 1),
            new Graph.Edge("Project lab", "c", 1),
            new Graph.Edge( "c","Project lab", 1),
            new Graph.Edge("a", "c", 1),
            new Graph.Edge( "c","a", 1),
            new Graph.Edge("a", "b", 1),
            new Graph.Edge("b","a", 1),
            new Graph.Edge("c", "d", 1),
            new Graph.Edge("d","c",  1),
            new Graph.Edge("b", "d", 1),
            new Graph.Edge("d","b", 1),
            new Graph.Edge("b", "s", 1),
            new Graph.Edge( "s","b", 1),
            new Graph.Edge("d", "s", 1),
            new Graph.Edge( "s","d", 1),
            new Graph.Edge("s", "Dr Meenakshi Tripathi", 1),
            new Graph.Edge("Dr Meenakshi Tripathi","s", 1),
            ////////////////////////////////////////////////////
            new Graph.Edge("Dr Meenakshi Tripathi", "Dr Girdhari Singh", 1),
            new Graph.Edge( "Dr Girdhari Singh","Dr Meenakshi Tripathi", 1),
            new Graph.Edge( "Dr Girdhari Singh","Image Processing lab", 1),
            new Graph.Edge( "Image Processing lab","Dr Girdhari Singh", 1),
            new Graph.Edge( "Dr Meenakshi Tripathi","Image Processing lab", 1),
            new Graph.Edge( "Image Processing lab","Dr Meenakshi Tripathi", 1),
            new Graph.Edge( "s","Dr Vijay Laxmi", 1),
            new Graph.Edge( "Dr Vijay Laxmi","s", 1),
            new Graph.Edge( "Dr Mushtaq Ahmad","Dr Vijay Laxmi", 1),
            new Graph.Edge( "Dr Vijay Laxmi","Dr Mushtaq Ahmad", 1),
            new Graph.Edge( "ISEA lab","Dr Vijay Laxmi", 1),
            new Graph.Edge( "Dr Vijay Laxmi","ISEA lab", 1),
            new Graph.Edge( "ISEA lab","CP-TUT-1", 1),
            new Graph.Edge( "CP-TUT-1","ISEA lab", 1),
            new Graph.Edge( "ISEA lab","Image Processing lab", 1),
            new Graph.Edge( "Image Processing lab","ISEA lab", 1),
            new Graph.Edge( "ISEA lab","CP-TUT-1", 1),
            new Graph.Edge( "CP-TUT-1","ISEA lab", 1),
            new Graph.Edge( "Server lab","CP-TUT-1", 1),
            new Graph.Edge( "CP-TUT-1","Server lab", 1),
            new Graph.Edge( "Server lab","Self Maintenance Cell", 1),
            new Graph.Edge( "Self Maintenance Cell","Server lab", 1),
            new Graph.Edge( "Dr Dinesh Gopinath","Self Maintenance Cell", 1),
            new Graph.Edge( "Self Maintenance Cell","Dr Dinesh Gopinath", 1),
            new Graph.Edge( "Dr Dinesh Gopinath","Toilet1", 1),
            new Graph.Edge( "Toilet1","Dr Dinesh Gopinath", 1),
            new Graph.Edge( "Dr Yogesh Meena","Toilet1", 1),
            new Graph.Edge( "Toilet1","Dr Yogesh Meena", 1),
            new Graph.Edge( "Dr Yogesh Meena","Dr Neeta Nain", 1),
            new Graph.Edge( "Dr Neeta Nain","Dr Yogesh Meena", 1),
            new Graph.Edge( "Seminar Hall","Dr Neeta Nain", 1),
            new Graph.Edge( "Dr Neeta Nain","Seminar Hall", 1),
            new Graph.Edge( "Seminar Hall","LH-CP-3", 1),
            new Graph.Edge( "LH-CP-3","Seminar Hall", 1),
            new Graph.Edge( "Server lab","LH-CP-3", 1),
            new Graph.Edge( "LH-CP-3","Server lab", 1),
            new Graph.Edge( "Image Processing lab","LH-CP-3", 1),
            new Graph.Edge( "LH-CP-3","Image Processing lab", 1),
            /////////
            new Graph.Edge("s", "s1",1),
            new Graph.Edge("s1", "s", 1),
            /***********************************/
            new Graph.Edge("ISEA lab", "Dr Meenakshi Tripathi", 1),
            new Graph.Edge("Dr Meenakshi Tripathi","ISEA lab", 1),
            new Graph.Edge("s1", "Dr Vijay Laxmi", 1),
            new Graph.Edge("Dr Vijay Laxmi","s1", 1),
            new Graph.Edge( "CP-TUT-1","LH-CP-3", 1),
            new Graph.Edge( "LH-CP-3","CP-TUT-1", 1),
            new Graph.Edge( "Seminar Hall","Dr Yogesh Meena", 1),
            new Graph.Edge( "Dr Yogesh Meena","Seminar Hall", 1),
            new Graph.Edge( "Dr Dinesh Gopinath","Dr Yogesh Meena", 1),
            new Graph.Edge( "Dr Yogesh Meena","Dr Dinesh Gopinath", 1),
            new Graph.Edge( "Dr Dinesh Gopinath","Server lab", 1),
            new Graph.Edge( "Server lab","Dr Dinesh Gopinath", 1),
            new Graph.Edge( "LH-CP-3","Dr Yogesh Meena", 1),
            new Graph.Edge( "Dr Yogesh Meena","LH-CP-3", 1),
            new Graph.Edge("ISEA lab", "s1", 1),
            new Graph.Edge("s1","ISEA lab", 1),
            new Graph.Edge("Software Design lab", "s1", 1),
            new Graph.Edge("s1","Software Design lab", 1),
            new Graph.Edge("Office", "Dr Manoj Singh Gaur", 1),
            new Graph.Edge("Dr Manoj Singh Gaur","Office", 1),
            new Graph.Edge("Office", "Software Design lab", 1),
            new Graph.Edge("Software Design lab","Office", 1),
            new Graph.Edge("Network lab", "Embedded System lab", 1),
            new Graph.Edge("Embedded System lab","Network lab", 1),
            new Graph.Edge("Dr Namita Mittal", "Embedded System lab", 1),
            new Graph.Edge("Embedded System lab","Dr Namita Mittal", 1),
            new Graph.Edge("Bb", "Network lab", 1),
            new Graph.Edge("Network lab","Bb", 1),
            new Graph.Edge("Dr Namita Mittal", "Toilet0", 1),
            new Graph.Edge("Toilet0","Dr Namita Mittal", 1),
            new Graph.Edge("s", "ISEA lab", 1),
            new Graph.Edge("ISEA lab","s", 1),
            new Graph.Edge("s", "Dr Vijay Laxmi", 1),
            new Graph.Edge("Dr Vijay Laxmi","s", 1),
            /**********************************/
            new Graph.Edge("s1","Office", 1),
            new Graph.Edge("Office","s1", 1),
            ////////
            new Graph.Edge("s1", "Dr Meenakshi Tripathi", 1),
            new Graph.Edge("Dr Meenakshi Tripathi","s1", 1),
            //////////////////
            new Graph.Edge("s1", "Dr Manoj Singh Gaur", 1),
            new Graph.Edge("Dr Manoj Singh Gaur","s1", 1),
            /////////////////////
            //new Graph.Edge("Office", "Dr Manoj Singh Gaur", 1),
            //new Graph.Edge("Dr Manoj Singh Gaur","Office", 1),
            /*******/
            new Graph.Edge("Office", "Embedded System lab", 1),
            new Graph.Edge("Embedded System lab","Office", 1),
            /////////
            new Graph.Edge("Dr Manoj Singh Gaur","Software Design lab", 1),
            new Graph.Edge("Software Design lab", "Dr Manoj Singh Gaur", 1),
            /////
            new Graph.Edge("Software Design lab", "Embedded System lab", 1),
            new Graph.Edge("Embedded System lab","Software Design lab", 1),
            ///////
            new Graph.Edge("Software Design lab", "Network lab", 1),
            new Graph.Edge("Network lab","Software Design lab", 1),
            // new Graph.Edge("Office", "Embedded System lab", 1),
            new Graph.Edge("s1","Office", 1),
            new Graph.Edge("Office","s1", 1),
            // new Graph.Edge("Embedded System lab","Office", 1),
            new Graph.Edge("Dr Namita Mittal", "Network lab", 1),
            new Graph.Edge("Network lab","Dr Namita Mittal", 1),
            new Graph.Edge("Dr Namita Mittal", "Bb", 1),
            new Graph.Edge("Bb","Dr Namita Mittal", 1),
            new Graph.Edge("Aa", "Bb", 1),
            new Graph.Edge("Bb","Aa", 1),
            new Graph.Edge("Aa", "Embedded System lab", 1),
            new Graph.Edge("Embedded System lab","Aa", 1),
            new Graph.Edge("Bb", "Embedded System lab", 1),
            new Graph.Edge("Embedded System lab","Bb", 1),
            new Graph.Edge("Aa", "Toilet0", 1),
            new Graph.Edge("Toilet0","Aa", 1),
            new Graph.Edge("Bb", "Toilet0", 1),
            new Graph.Edge("Toilet0","Bb", 1),
    };

    /*private String a;
    private String b;*/

   // private static String START ;
   // private static String END;

   //PathActivity p = new PathActivity();



   /* public static void setstart()
    {
        Dijkstra.START = p.source.getText().toString();
    }
    public static void setend()
    {
        Dijkstra.END = p.dest.getText().toString();
    }*/
   /*public static String getpath()
   {
       Graph.Vertex v = new Graph.Vertex(null);
       return v.mypath;
   }*/


    public static String main() {
        Graph g = new Graph(GRAPH);
        //setstart();
        /*String START ;
        String END;*/
        /*START = super.source.getText().toString();
        END = super.dest.getText().toString(); */
        g.dijkstra(START);
        g.printPath(END);
        Graph.Vertex v;
        v = new Graph.Vertex(null);
        return Graph.Vertex.mypath;
        //System.out.println(v.mypath);
        //g.printAllPaths();
    }
}

class Graph {
    private final Map<String, Vertex> graph; // mapping of vertex names to Vertex objects, built from a set of Edges

    /** One edge of the graph (only used by Graph constructor) */
    public static class Edge {
        public final String v1, v2;
        public final int dist;
        public Edge(String v1, String v2, int dist) {
            this.v1 = v1;
            //this.v1 = v2;
            this.v2 = v2;
            this.dist = dist;
        }
    }

    /** One vertex of the graph, complete with mappings to neighbouring vertices */

    public static class Vertex implements Comparable<Vertex> {

        public static String mypath = "your path is :";/*static */

        public final String name;
        public int dist = Integer.MAX_VALUE; // MAX_VALUE assumed to be infinity
        public Vertex previous = null;
        public final Map<Vertex, Integer> neighbours = new HashMap<>();

        public Vertex(String name) {
            this.name = name;
        }

        private void printPath() {
            if (this == this.previous) {
                //System.out.printf("%s", this.name);
                mypath += this.name;
            } else if (this.previous == null) {
                System.out.printf("%s(ur)", this.name);
            } else {
                this.previous.printPath();
                //System.out.printf(" -> %s(%d)", this.name, this.dist);
                mypath += "->" + this.name;
            }
        }

        public int compareTo(@NonNull Vertex other) {
            return Integer.compare(dist, other.dist);
        }
    }

    /** Builds a graph from a set of edges */
    public Graph(Edge[] edges) {
        graph = new HashMap<>(edges.length);/*edges.length->200*/

        //one pass to find all vertices
        for (Edge e : edges) {
            if (!graph.containsKey(e.v1)) graph.put(e.v1, new Vertex(e.v1));
            if (!graph.containsKey(e.v2)) graph.put(e.v2, new Vertex(e.v2));
        }

        //another pass to set neighbouring vertices
        for (Edge e : edges) {
            graph.get(e.v1).neighbours.put(graph.get(e.v2), e.dist);
            //graph.get(e.v2).neighbours.put(graph.get(e.v1), e.dist); // also do this for an undirected graph
        }
    }

    /** Runs dijkstra using a specified source vertex */
    public void dijkstra(String startName) {
        if (!graph.containsKey(startName)) {
            System.err.printf("Graph doesn't contain start vertex \"%s\"\n", startName);
            return;
        }
        final Vertex source = graph.get(startName);
        NavigableSet<Vertex> q = new TreeSet<>();

        // set-up vertices
        for (Vertex v : graph.values()) {
            v.previous = v == source ? source : null;
            v.dist = v == source ? 0 : Integer.MAX_VALUE;
            q.add(v);
        }

        dijkstra(q);
    }

    /** Implementation of dijkstra's algorithm using a binary heap. */
    private void dijkstra(final NavigableSet<Vertex> q) {
        Vertex u, v;
        while (!q.isEmpty()) {

            u = q.pollFirst(); // vertex with shortest distance (first iteration will return source)
            if (u.dist == Integer.MAX_VALUE) break; // we can ignore u (and any other remaining vertices) since they are unreachable

            //look at distances to each neighbour
            for (Map.Entry<Vertex, Integer> a : u.neighbours.entrySet()) {
                v = a.getKey(); //the neighbour in this iteration

                final int alternateDist = u.dist + a.getValue();
                if (alternateDist < v.dist) { // shorter path to neighbour found
                    q.remove(v);
                    v.dist = alternateDist;
                    v.previous = u;
                    q.add(v);
                }
            }
        }
    }

    /** Prints a path from the source to the specified vertex */
    public void printPath(String endName) {
        if (!graph.containsKey(endName)) {
            System.err.printf("Graph doesn't contain end vertex \"%s\"\n", endName);
            return;
        }

        graph.get(endName).printPath();
        System.out.println();
    }
    /** Prints the path from the source to every vertex (output order is not guaranteed) */
    public void printAllPaths() {
        for (Vertex v : graph.values()) {
            v.printPath();
            System.out.println();
        }
    }
}
