public class Main {
    public static void main(String args[]) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 8, 9, 10};
        int missingInt = getMissingInt(array, 0, array.length-1);
        System.out.println(missingInt);
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
