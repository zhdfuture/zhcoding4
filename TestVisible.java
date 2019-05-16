import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Stack;

public class TestVisible {
    public int data;
    public int times;

    //记录数字和收集的次数
    public TestVisible(int value) {
        this.data = data;
        this.times = 1;
    }

    public static int nextIndex(int i, int size) {   //返回下一个位置

        if (i < size - 1) {
            return i + 1;
        } else {
            return 0;
        }
    }

    public static int getNumbers(int n) {
        if (n == 1) {
            return 0;
        } else {
            return n * (n - 1) / 2;       //C(n,2)
        }
    }

    public static int VisibleNumber(int[] array) {
        if (array == null || array.length < 2) {
            return 0;   //可见对数为0
        }
        int mIndex = 0;        //最大值的位置
        for (int i = 0; i < array.length; i++) {
            if (array[mIndex] < array[i]) {
                mIndex = i;
            } else {
                mIndex= mIndex;
            }

        }
        Stack<TestVisible> stack = new Stack<TestVisible>();
        stack.push(new TestVisible(array[mIndex]));     //（最大值，1)入栈
        int index = nextIndex(mIndex, array.length);   //沿next方向遍历
        int resultNumber = 0;     //统计山峰对
        while (index != mIndex) {     //若相等，则转完一圈回来了
            while (!stack.isEmpty()&&stack.peek().data < array[index]) {  //和栈顶比较，若该数大，则弹出栈顶元素
                int k = stack.pop().times;
                resultNumber += getNumbers(k) + 2 * k;
            }
            if (!stack.isEmpty()&&stack.peek().data == array[index]) {
                stack.peek().times++;  //数字一样就合并
            } else {
                stack.push(new TestVisible(array[index]));
            }
            index = nextIndex(index, array.length);
        }

            while (stack.size() > 2) {      //弹出的记录不是栈中最后一个记录，也不是倒数第二个
                int times = stack.pop().times;
                resultNumber += getNumbers(times) + 2 * times;
            }
            while (stack.size() == 2) {   //弹出的记录是栈中倒数第二个
                int times = stack.pop().times;
                if (stack.peek().times == 1) {
                    resultNumber += getNumbers(times) + times;
                } else {

                    resultNumber += getNumbers(times) + 2 * times;
                }

            }

            resultNumber += getNumbers(stack.pop().times);  //弹出最后一个记录


        return resultNumber;

    }

    public static void main(String[] args) {
        System.out.println("please input the array: ");
        Scanner scan = new Scanner(new BufferedInputStream(System.in));
        while (scan.hasNext()) {
            int n = scan.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scan.nextInt();
            }

            System.out.println(VisibleNumber(array));
        }
    }
}