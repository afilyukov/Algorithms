import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private final static int NB_COUNT = 100;

    public static void main(String[] args) {
        List<Notebook> notebooks = generateNotebooks();
        notebooks = SortNotebook.sort(notebooks);

        printNotebooks(notebooks);

}

    private static void printNotebooks(List<Notebook> notebooks) {
        for (Notebook nb : notebooks) {
            System.out.println(nb);
        }
    }

    private static ArrayList<Notebook> generateNotebooks(){
        ArrayList<Notebook> notebooks = new ArrayList<>();
        for (int i = 0; i < NB_COUNT; i++) {
            notebooks.add(generateNewNotebook());
        }
        return notebooks;
    }

    private static Notebook generateNewNotebook(){
        Random random = new Random();
        BigDecimal price = BigDecimal.valueOf(random.nextInt(20)*100+50);
        int memory = (random.nextInt(4)*5 + 4);
        Notebook.Vendor vendor = Notebook.Vendor.values()[random.nextInt(Notebook.Vendor.values().length)];
        return new Notebook(price, memory, vendor);
    }
}