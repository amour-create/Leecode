import java.lang.reflect.Array;
import java.util.ArrayList;

public class Solution {
    public int fib(int n) {
        if(n <2) return n;
        //滚动数组
        int p = 0, q = 0, r = 1;
        for(int i = 2; i <= n; i ++)
        {
            p = q;
            q = r;
            r = p+q;
        }
        return r;
    }

    public int tribonacci(int n) {
        if(n <2) return n;
        if(n == 2) return 1;
        //滚动数组
        int p = 0, q = 0, r = 1, s= 1;
        for(int i = 3; i <= n; i ++)
        {
            p = q;
            q = r;
            r = s;
            s = p+q+r;
        }
        return s;
    }

    public int climbStairs(int n){
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }

    private int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if((n & 1) == 1){
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return  ret;
    }

    private int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++ ){
            for (int j = 0; j < 2; j++){
                c[i][j] = a[i][0]*b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i-1] + cost[i - 1], dp[i-2] + cost[i-2]);
        }
        return  dp[n];
    }

    //背包问题
    private int maxW = Integer.MIN_VALUE;//结果放在maxW中
    private int[] weight = {2,2,4,6,3};//物品的重量
    private int n = 5;//物品的个数
    private int w = 9;//背包承受的最大重量
    public void f(int i , int cw) {
        if(cw == w || i == n){
            if(cw > maxW) maxW = cw;
            return;
        }
        f(i+1, cw);
        if(cw + weight[i] <= w ){
            f(i+1, cw + weight[i]);
        }
    }

    //背包问题的备忘录优化方案
    private boolean[][] mem = new boolean[5][10];
    public void f_b(int i, int cw){
        if(cw == w || i == n){
            if(cw > maxW) maxW = cw;
            return;
        }

        if(mem[i][cw]) return;

        f(i+1, cw);
        mem[i+1][cw] = true;

        if(cw + weight[i] < w){
            f(i+1, cw + weight[i]);
            mem[i+1][cw+weight[i]] = true;
        }
    }

    public int knapsack(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w+1];

        if(weight[0]<=w){
            states[0][weight[0]] = true;
        }

        for(int i = 1; i < n; ++i) {
            for(int j = 0; j <= w; ++j){
                if(states[i-1][j] == true) states[i][j] = states[i-1][j];
            }
            for(int j = 0; j <= w-weight[i]; ++j) {
                if (states[i-1][j] == true) states[i][j+weight[i]] = true;
            }
        }

        for(int i = w; i >= 0; --i) {
            if(states[n-1][i] == true) return i;
        }
        return 0;
    }

    public static int knapsack2(int[] items, int n, int w) {
        boolean[] states = new boolean[w+1];
        states[0] = true;
        if(items[0] <= w) {
            states[items[0]] = true;
        }
        for(int i = 1; i < n; ++i) {
            for (int j = w-items[i]; j >=0; --j) {
                if(states[j]== true) states[j+items[i]] = true;
            }
        }
        for(int i = w; i >= 0; --i){
            if(states[i] == true) return i;
        }
        return 0;
    }

    //备忘录方法减免背包问题重复计算
    
    public int maxV = Integer.MIN_VALUE;
    private int[] items = {2,2,4,6,3};
    private int[] value = {3,4,8,9,6};
    private int n_v = 5;
    private int w_v = 9;
    public void f_v(int i, int cw, int cv){
        if(cw == w_v || i == n_v){
            if(cv > maxV) maxV = cv;
        }
        f_v(i+1, cw, cv);
        if(cw + weight[i] <= w){
            f_v(i+1, cw = weight[i], cv+value[i]);
        }
    }

    public static int knapsack3(int[] weight, int[] value, int n, int w){
        int[][] states = new int[n][w+1];
        for (int i = 0; i < n; ++i){
            for(int j = 0; j < w + 1; ++j){
                states[i][j] = -1;
            }
        }
        states[0][0] = 0;
        if (weight[0] <= w) {
            states[0][weight[0]] = value[0];
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j <= w; ++j){
                if (states[i-1][j] >= 0) states[i][j] = states[i-1][j];
            }
            for(int j = 0; j <= w-weight[i]; ++j){
                if (states[i-1][j] >= 0){
                    int v = states[i-1][j] + value[i];
                    if (v > states[i][j+weight[i]]) {
                        states[i][j+weight[i]] = v;
                    }
                }
            }
        }
        int maxvalue = -1;
        for (int j = 0; j <= w; ++j) {
            if(states[n-1][j] > maxvalue) maxvalue = states[n-1][j];
        }
        return maxvalue;
    }



    
    
    
    
    
}
