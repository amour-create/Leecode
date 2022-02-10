public class lecodeMain {
    public static void main(String[] args) {
//        int[] arrayRefVar = {0,3,5,9};


        int target = 7;
        Solution solution = new Solution();
        int result = solution.fib(target);
        System.out.println("fib: " + result);

        int result_taibo = solution.tribonacci(target);
        System.out.println("fib: " + result_taibo);

        int climbStairs = solution.climbStairs(target);
        System.out.println("climbStairs: " + climbStairs);

        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        int costs = solution.minCostClimbingStairs(cost);
        System.out.println("minCostClimbingStairs: " + costs);

        //背包问题
        int maxW = Integer.MIN_VALUE;//结果放在maxW中
        int[] weight = {2,2,4,6,3};//物品的重量
        int n = 5;//物品的个数
        int w = 9;//背包承受的最大重量
        int biggest_weight = solution.backpack(weight, n, w);
        System.out.println("背包最大承重为：" + biggest_weight);


    }

}
