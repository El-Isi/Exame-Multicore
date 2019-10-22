import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.concurrent.RecursiveAction;

public class PrintSize extends RecursiveAction{

    ArrayList<ArrayList<String>> data;
    int files;
    DecimalFormat df = new DecimalFormat("#.00");

    PrintSize(ArrayList<ArrayList<String>> data, int files){
        this.data = data;
        this.files = files;
    }

    @Override
    protected  void compute() {
        for (int i = 0; i < files; i++) {
            System.out.println("El archivo " + data.get(i).get(0) + ":");
            System.out.println(df.format(Float.parseFloat(data.get(i).get(2))) + " bytes");
        }
    }
}