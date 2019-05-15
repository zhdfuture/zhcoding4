import java.util.HashSet;
import java.util.Set;

public class Test2 {
    public static int getNext(int num) {
        int result = 0;
        result = result + (num % 10) * (num % 10);
        num = num / 10;  //123/10=12
        if (num == 0) {
            return result;
        } else {
            return result + getNext(num);
        }
    }
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            int flag = getNext(n);
            if (set.contains(flag)) {
                return false;
            } else {
                set.add(flag);
                n = flag;
            }
        }
        return true;

    }



    public static void main(String[] args) {
        Test2 test=new Test2();
        System.out.println(test.isHappy(5));
    }
}