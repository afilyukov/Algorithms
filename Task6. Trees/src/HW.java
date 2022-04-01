import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;

public class HW {
    public static void main(String[] args) {
        List<Tree> treeList = new LinkedList<>();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < 20; i++) {
            Tree tree = new Tree();
            for (int j = 0; j <= 10; j++) {
                tree.insert(25 - random.nextInt(25));
            }
            treeList.add(tree);
        }

        int count = 0;
        for (int i = 0; i < treeList.size(); i++) {
            count += treeList.get(i).balance() ? 1 : 0;
        }

        System.out.println(String.format("%s %d", "Total trees count:", treeList.size()));
        System.out.println(String.format("%s %d%s", "Balanced:", count * 100 / treeList.size(), "%"));
    }
}