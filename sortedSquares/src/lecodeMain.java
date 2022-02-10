public class lecodeMain {
    public static void main(String[] args) {
        int[] arrayRefVar = {3,10,-4,-1,0};
        int[] array = {-4};

        Solution solution = new Solution();
        int[] result = solution.mergeSort(arrayRefVar, arrayRefVar.length);
        System.out.println(result);
    }

}
