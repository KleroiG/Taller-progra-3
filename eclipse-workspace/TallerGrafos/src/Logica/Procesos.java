package Logica;
import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import edu.uci.ics.jung.graph.*;
import edu.uci.ics.jung.visualization.*;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Procesos {

    public static void main(String[] args) {
        Graph<String, String> grafo = new UndirectedSparseGraph<String, String>();
        grafo.addVertex("Bogota");
        grafo.addVertex("Medellin");
        grafo.addVertex("Cali");
        grafo.addVertex("Barranquilla");
        grafo.addVertex("Cartagena");
        grafo.addVertex("Tunja");
        grafo.addVertex("Sogamoso");
        grafo.addVertex("Nobsa");
        grafo.addVertex("Santa marta");
        grafo.addVertex("Cocuy");
        grafo.addVertex("Villavicencio");
        grafo.addVertex("Yopal");
        grafo.addVertex("Guajira");
        grafo.addVertex("Arauca");
        grafo.addVertex("Ibague");
        grafo.addVertex("Iza");

        grafo.addEdge("6.13", "Arauca", "Yopal");
        grafo.addEdge("0.50", "Iza", "Sogamoso");
        grafo.addEdge("13.35", "Arauca", "Bucaramanga");
        grafo.addEdge("10.10", "Bogota", "Medellin");
        grafo.addEdge("12.00", "Bogota", "Cali");
        grafo.addEdge("8.10", "Medellin", "Cali");
        grafo.addEdge("5.00", "Barranquilla", "Cartagena");
        grafo.addEdge("1.11", "Tunja", "Sogamoso");
        grafo.addEdge("3.19", "Sogamoso", "Yopal");
        grafo.addEdge("4.30", "Bogota", "Villavicencio");
        grafo.addEdge("0.10", "Sogamoso", "Nobsa");
        grafo.addEdge("2.29", "Tunja", "Bogota");
        grafo.addEdge("5.58", "Sogamoso", "Cocuy");
        grafo.addEdge("7.55", "Bucaramanga", "Cocuy");
        grafo.addEdge("4.19", "Santa marta", "Guajira");
        grafo.addEdge("7.07", "Tunja", "Bucaramanga");
        grafo.addEdge("6.46", "Cartagena", "Medellin");
        grafo.addEdge("3.15", "Cartagena", "Barranquilla");
        grafo.addEdge("2.10", "Santa marta", "Barranquilla");
        grafo.addEdge("4.15", "Bucaramanga", "Santa marta");
        grafo.addEdge("5.17", "Ibague", "Bogota");
        grafo.addEdge("6.02", "Ibague", "Cali");
        

        
        VisualizationViewer<String, String> vv = new VisualizationViewer<String, String>(
                new FRLayout<String, String>(grafo), new Dimension(1000, 600));

        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<String>());
        vv.getRenderer().getVertexLabelRenderer().setPosition(Renderer.VertexLabel.Position.CNTR);

        JFrame frame = new JFrame("Grafo de ciudades de Colombia");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vv);
        frame.pack();
        frame.setVisible(true);

        double distanciaRecorrida=0.0;
        
        DijkstraShortestPath<String, String> dijkstra = new DijkstraShortestPath<String, String>(grafo);
        String ciudadInicial = JOptionPane.showInputDialog( "Digite la ciudad origen:");
        String ciudadFinal = JOptionPane.showInputDialog("Digite la ciudad destino:");
       try {
        for (String v : dijkstra.getPath(ciudadInicial, ciudadFinal)) {
        	distanciaRecorrida+=Double.valueOf(v);
            
        }
       JOptionPane.showMessageDialog(null,"La ruta más corta desde " + ciudadInicial + " hasta " + ciudadFinal + " son " + distanciaRecorrida + " Horas");
       } catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "La ciudad ingresada no es valida");
		}
    }
}
