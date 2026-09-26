class Solution {
    public int reverse(int x) {
        long value=0;
        int num=Math.abs(x);
        while(num>0){
            int divid = num%10;
            value=divid+(value*10);
            num=num/10;
        }
       if (x < 0) {
            value = -value;
        }

        if (value > Integer.MAX_VALUE || value < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) value;
    }
}