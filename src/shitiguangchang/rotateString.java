package shitiguangchang;

/**
 * @Description:汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，
 * 即“XYZdefabc”。是不是很简单？OK，搞定它！
 * @author:王丽雪
 * @time:2017年6月19日下午7:29:19
 */
public class rotateString {
	public String LeftRotateString(String str,int n) {
        if(str == null || str.length() == 0 || n <= 0){
        	return str;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(n));
        sb.append(str.substring(0, n));
        return sb.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rotateString r = new rotateString();
		System.out.print(r.LeftRotateString("abcXYZdef", 10));
	}

}
