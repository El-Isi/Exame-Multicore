import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.RecursiveAction;

public class SearchWord extends RecursiveAction {
    Scanner entrada = null;
    int numeroDeLinea = 1;
    String linea;
    String texto;
    File file;
    ArrayList<ArrayList<String>> archivos_con_palabra;
    ArrayList<String> archivos = new ArrayList<>();
    boolean contiene;

    SearchWord(Scanner entrada, String texto, File file, ArrayList<ArrayList<String>> archivos_con_palabra, boolean contiene, int linea) throws FileNotFoundException {
        this.entrada = new Scanner(file);
        this.texto = texto;
        this.file = file;
        this.contiene = contiene;
        this.numeroDeLinea = linea;
        this.archivos_con_palabra = archivos_con_palabra;
    }

    @Override
    protected  void compute() {
        while (entrada.hasNext()) {
            linea = entrada.nextLine();
            if (linea.contains(texto)) {
                archivos.add(file.getName());
                archivos.add(texto);
                archivos.add(Long.toString(file.length()));
                archivos_con_palabra.add(archivos);
                contiene = true;
            }
            numeroDeLinea++; //se incrementa el contador de líneas
        }
    }
}