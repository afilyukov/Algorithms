public class Main {
    public static void main(String args[]) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 8, 9, 10};
        int missingInt = getMissingInt(array, 0, array.length-1);
        System.out.println(missingInt);

        CiclicQueue<Integer> cq = new CiclicQueue<>(5);
        cq.insert(10);
        cq.insert(20);
        cq.insert(30);
        cq.insert(40);
        cq.insert(50);
        System.out.println(cq.toString());
        cq.remove();
        cq.remove();
        cq.remove();
        System.out.println(cq.toString());
        cq.insert(60);
        cq.insert(70);
        System.out.println(cq.toString());
        cq.insert(80);
        cq.insert(90);
        System.out.println(cq.toString());
        cq.remove();
        System.out.println(cq.toString());
    }

    public static int getMissingInt(int[] intArray, int left, int right) {
        if (right == left + 1) return intArray[right] - 1;
        int pivot = left + (right - left) / 2;
        if (intArray[pivot] == intArray[left] + (intArray[right] - intArray[left]) / 2 - (right - left) % 2)
            return getMissingInt(intArray, pivot, right);
        else
            return getMissingInt(intArray, left, pivot);
    }




}
