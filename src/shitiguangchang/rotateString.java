package shitiguangchang;

/**
 * @Description:�����������һ����λָ�����ѭ�����ƣ�ROL���������и��򵥵����񣬾������ַ���ģ�����ָ�����������
 * ����һ���������ַ�����S���������ѭ������Kλ���������������磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ����
 * ����XYZdefabc�����ǲ��Ǻܼ򵥣�OK���㶨����
 * @author:����ѩ
 * @time:2017��6��19������7:29:19
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
