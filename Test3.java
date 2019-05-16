import java.util.Scanner;

public class Test3 {
    public static char function(String str){
        int[] hash=new int[256];
        char[] chars=str.toCharArray();
        for(int i=0;i<chars.length;i++){
            char ch=chars[i];
            if(ch>='a'&&ch<='z'||ch>='A'&&ch<='Z'){
                hash[ch]++;   //次数
                if(hash[ch]==3){
                    return ch;
                }
            }
        }
        return '0';
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("please input the string: ");
        String str=scan.nextLine();
        System.out.println(function(str));
    }
}
