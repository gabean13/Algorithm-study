class Solution {
    public int solution(int[] arr) {
        int num = arr[0];
        for(int i = 1; i < arr.length; i++) {
            num = (num * arr[i]) / gcd(num, arr[i]);
        }
        
        return num;
    }
    
    static public int gcd(int a, int b) {
        int temp;
        while(b != 0) {
            temp = a % b;
            a = b;
            b = temp;
        }
        
        return a;
    }
}