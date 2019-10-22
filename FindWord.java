import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class FindWord {

    public static void main(String[] args) {
        ForkJoinPool imp = new ForkJoinPool(4);
        ForkJoinPool files = new ForkJoinPool(4);
        ForkJoinPool search = new ForkJoinPool(4);

        Scanner entrada = null;
        String linea;
        int numeroDeLinea;
        boolean contiene = false;
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce texto a buscar: ");
        String texto = sc.nextLine();

        try {
            //guardamos el path del fichero en la variable ruta
            String[] ruta = {
                    "C:\\Users\\el_re\\Desktop\\Examen\\Ejemplo1.txt",
                    "C:\\Users\\el_re\\Desktop\\Examen\\Ejemplo2.txt",
                    "C:\\Users\\el_re\\Desktop\\Examen\\Ejemplo3.txt",
                    "C:\\Users\\el_re\\Desktop\\Examen\\Ejemplo4.txt",
                    "C:\\Users\\el_re\\Desktop\\Examen\\Deportes\\Deporte1.txt",
                    "C:\\Users\\el_re\\Desktop\\Examen\\Deportes\\Deporte2.txt",
                    "C:\\Users\\el_re\\Desktop\\Examen\\Deportes\\Deporte3.txt",
                    "C:\\Users\\el_re\\Desktop\\Examen\\Deportes\\Deporte4.txt",
                    "C:\\Users\\el_re\\Desktop\\Examen\\Deportes\\Frutas\\Fruta1.txt",
                    "C:\\Users\\el_re\\Desktop\\Examen\\Deportes\\Frutas\\Fruta2.txt",
                    "C:\\Users\\el_re\\Desktop\\Examen\\Deportes\\Frutas\\Fruta3.txt",
                    "C:\\Users\\el_re\\Desktop\\Examen\\Deportes\\Frutas\\Fruta4.txt",
                    "C:\\Users\\el_re\\Desktop\\Examen\\Deportes\\Frutas\\Materias\\Materia1.txt",
                    "C:\\Users\\el_re\\Desktop\\Examen\\Deportes\\Frutas\\Materias\\Materia2.txt",
                    "C:\\Users\\el_re\\Desktop\\Examen\\Deportes\\Frutas\\Materias\\Materia3.txt",
                    "C:\\Users\\el_re\\Desktop\\Examen\\Deportes\\Frutas\\Materias\\Materia4.txt"
            };
            //creamos un objeto File asociado al fichero seleccionado
            File[] f = new File[ruta.length];
            ArrayList<ArrayList<String>> archivos_con_palabra = new ArrayList<>();
            for (int i = 0; i < f.length; i++){
                numeroDeLinea = 1;
                f[i] = new File(ruta[i]);
                //creamos un Scanner para leer el fichero
                //mostramos el nombre del fichero
                SearchWord Sword = new SearchWord(entrada, texto, f[i], archivos_con_palabra, contiene, numeroDeLinea);
                search.invoke(Sword);

            }

            float[] sizes = new float[archivos_con_palabra.size()];
            GetSize ObtenerTamaño = new GetSize(archivos_con_palabra, sizes);
            files.invoke(ObtenerTamaño);

            PrintSize ImprimirTamaños = new PrintSize(archivos_con_palabra, archivos_con_palabra.size());
            imp.invoke(ImprimirTamaños);

        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (entrada != null) {
                entrada.close();
            }
        }
    }
}