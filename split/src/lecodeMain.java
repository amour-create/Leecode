public class lecodeMain {
    public static void main(String[] args) {
        int[] arrayRefVar = {0,3,5,9};
        int target = 10;
        Solution solution = new Solution();
        int result = solution.search(arrayRefVar, target);
        System.out.println(result);
    }

}
