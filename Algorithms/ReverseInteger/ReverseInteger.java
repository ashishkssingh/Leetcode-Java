package Algorithms.ReverseInteger;

class ReverseInteger {

    public int reverse(int x) {
        int reverse = 0;
        while(x != 0){
            int tail = x % 10;
            int newResult = reverse*10 + tail;
            if((newResult - tail)/10 != reverse){
                return 0;
            }
            reverse = newResult;
            x = x / 10;
        }
        return reverse;
    }


    public static void main(String[] args){
        ReverseInteger reverse = new ReverseInteger();
        System.out.println(reverse.reverse(-123));
    }
}
