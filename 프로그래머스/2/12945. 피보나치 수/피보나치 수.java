class Solution {
    static long[] arr;
    public int solution(int n) {
        arr = new long[n+1];
        arr[0] = 0;
        arr[1] = 1;
        int idx = 2;
        while(idx <= n) {
            arr[idx] = arr[idx - 1] + arr[idx - 2];
            arr[idx] %= 1234567;
            idx++;
        }
        return (int)arr[n];
    }
}