public class Solution {

    public int[] sortedSquares(int[] nums) {
        int zeroSplit = 0;
        while(zeroSplit < nums.length && nums[zeroSplit] < 0) zeroSplit++;
        for (int i = zeroSplit; i < nums.length; i++) {
            nums[i] = nums[i]*nums[i];
        }
        for (int i = zeroSplit - 1; i >= 0; i--) {
            int temp = nums[i]*nums[i];
            int k = i;
            for(int j = i + 1; j < nums.length; ++j) {
                if(nums[j] < temp) {
                    nums[k++] = nums[j];
                }
                else
                    break;
            }
            nums[k] = temp;
        }
        return nums;
    }

    public int[] bubbleSort(int[] a, int n) {
        if(n <= 1) return a;

        for(int i = 0; i < n; i++ ){// 提前退出冒泡循环的标志位
            boolean flag = false;
            for(int j = 0; j < n - i - 1; j++) {
                if(a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag) return a;
        }
        return a;
    }

    public int[] insertionSort(int[] a, int n) {
        if(n <= 1) return a;
        for(int i = 0; i < n-1; ++i){
            int j = i+1;// 查找插入的位置
            int temp = a[j];
            for(; j > 0; --j){
                if(a[j-1]>temp)
                    a[j] = a[j-1];// 数据移动
                else
                    break;
            }
            a[j] = temp;
        }
        return a;
    }

    public int[] choseSort(int[] a, int n) {
        if(n <= 1) return a;
        for(int i =0; i < n; i++){
            int min = i;
            int j = i;
            for(; j < n; j++){
                if(a[j] < a[min]) min = j;
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
        return a;
    }

    public int[] mergeSort(int[] a, int n) {
        return mergeSortC(a, 0, n-1);
    }

    private int[] mergeSortC(int[] a, int p, int r) {
        if(p >= r) return a;

        int q = (p+r)/2;

        mergeSortC(a, p, q);
        mergeSortC(a, q+1, r);
        merge(a, p, q, r);
        return a;
    }

    private void merge(int[] a, int ls, int mid, int re) {
        int i = ls, j = mid+1, k = 0;
        int tempLength = re-ls+1;
        int[] temp = new int[tempLength];
        while(i <= mid && j <= re){
            if(a[i] <= a[j]){
                temp[k++] = a[i++];
            }else {
                temp[k++] = a[j++];
            }
        }

        int start = i, end = mid;
        if(j <= re){
            start = j;
            end = re;
        }

        while(start <= end){
            temp[k++] = a[start++];
        }

        for(int m = 0; m < tempLength; m++){
            a[ls+m] = temp[m];
        }
    }

    public int[] quickSort(int[] a, int n) {
        return quickSortc(a, 0, n-1);
    }

    private int[] quickSortc(int[] a, int low, int high) {
        if(low < high){
            int index = getIndex(a, low, high);
            quickSortc(a, low, index-1);
            quickSortc(a, index+1, high);
        }
        return a;
    }

    private int getIndex(int[] a, int low, int high) {
        int tmp = a[low];
        while(low<high){
            while(low < high && a[high]>= tmp){
                high--;
            }
            a[low] = a[high];
            while(low < high && a[low] <= tmp){
                low--;
            }
            a[high] = a[low];
        }
        a[low] = tmp;
        return low;
    }






    public int[] countingSort(int[] a, int n) {
        if(n <= 1) return a;

        int max = a[0];
        for (int i = 1; i < n; ++i) {
            if(max < a[i]) max = a[i];
        }

        int[] c = new int[max+1];
        for (int i = 0; i <= max; ++i) {
            c[i] = 0;
        }

        for (int i = 0; i < n; ++i) {
            c[a[i]]++;   //accumulation
        }

        for (int i = 0; i <= max; ++i) {
            c[i] = c[i-1] + c[i];
        }

        int[] r = new int[n];
        for (int i = n-1; i >= 0; --i) {
            int index = c[a[i]] - 1;
            //a[i] is target
            // c[a[i]] is a[i] accumulation position that is the end position
            r[index] = a[i];
        }

        for (int i = 0; i < n; ++i) {
            a[i] = r[i];
        }

        return a;
    }

    public int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n-1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid +1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
