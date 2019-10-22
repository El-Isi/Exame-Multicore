import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.RecursiveAction;

public class GetSize extends RecursiveAction {
    ArrayList<ArrayList<String>> data;
    float[] sizes;
    ArrayList<String> tmp;

    GetSize(ArrayList<ArrayList<String>> data, float[] sizes) {
        this.data = data;
        this.sizes = sizes;
    }

    @Override
    protected void compute() {
        for (int i = 0; i < data.size()-1; i++) {
            if (Float.parseFloat(data.get(i).get(2)) > Float.parseFloat(data.get(i+1).get(2))) {
                tmp = data.get(i);
                data.set(i, data.get(i+1));
                data.set(i+1, tmp);
            }
        }
        for (int i = 0; i < data.size(); i++) {
            sizes[i] = Float.parseFloat(data.get(i).get(2));
        }
    }
}