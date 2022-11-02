package String_;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Locale;

public class Test {
    public static void main(String[] args) {
        StringBuilder sb= new StringBuilder();
        StringBuffer sbf = new StringBuffer();
    }
    public static void mainbud(String[] args) {
        String str = "abcedf";
        for (int i = 0; i < 10; i++) {
            str+=i;
        }
        System.out.println(str);
    }
    public static void mainbu(String[] args) {
        String str = "abcedf";
        str += "123";
        System.out.println(str);
    }
    public static void mainappend(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("abcdef").append("999");
        sb.append("123456");
        System.out.println(sb.toString());

    }
    public static void mainconcat(String[] args) {
        String str = "abcdef";
        String ret = str.concat("bit");
        System.out.println(ret);
    }
    public static void mainuplow(String[] args) {
        String str = "abcdefABC";
        String ret = str.toLowerCase();
        System.out.println(ret);
    }
    public static void maintrim(String[] args) {
        String str = "      ab  sdc dscg  ";
        System.out.println(str.trim());
    }
    public static void mainsub(String[] args) {
        String str = "abcd";
        String sub = str.substring(1,3);
        System.out.println(sub);
    }
    public static void mainsplit1
            (String[] args) {
        String str =  "192.168.1.1";
        String[] strings =  str.split("\\.",3);
        for (String s:
             strings) {
            System.out.println(s);
        }

    }
    public static void mainsplit(String[] args) {
        String str = "name=zhangsan&age=19";
        String[] strings = str.split("&");
        for (String ret:
             strings) {

            System.out.println(ret);
            String[] ss = ret.split("=");
            for (String s:
                 ss) {
                System.out.println(s);
            }
        }
    }
    public static void mainreplace(String[] args) {
        String str = "abababcacbd";
        System.out.println(str.replaceFirst("ab", "gg"));

    }
    public static void mainfind(String[] args) {
        String str = "abcdebcdf";
        String tmp = "bcd";
        System.out.println(str.contains(tmp));
        System.out.println(str.indexOf(tmp,3));
        System.out.println(str.lastIndexOf(tmp,3));
        System.out.println(str.startsWith("c",2));
        System.out.println(str.endsWith("cdd"));
    }
    public static void mainc(String[] args) {
        String str1 = "abc";
        String str2 = "Abc";
        int ret = str1.compareTo(str2);
        System.out.println(str1.equalsIgnoreCase(str2));
        System.out.println(ret);

    }
    public static void mainb(String[] args) throws UnsupportedEncodingException {
        byte[] bytes = {97,98,99,100};
        String str = new String(bytes,1,3);
        System.out.println(str);
        String str2 = "abcd";
        byte[] bytess = str2.getBytes();
        System.out.println(Arrays.toString(bytess));
    }


    public static boolean isNumberChar(String s){
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean flg = Character.isDigit(c);
            if(flg == false){
                return false;
            }
            /*if(c<'0' || c>'9' ){
                return false;
            }*/
        }
        return true;
    }
    public static void maina(String[] args) {
        String str = "12345678";
        System.out.println(isNumberChar(str));
    }
    public static void main10(String[] args) {
        char[] val = {'a','b','c','d','e'};
        String str = new String(val,1,3);
        System.out.println(str);

        String str2 = "hello";
        char ch = str2.charAt(2);
        System.out.println(ch);
        char[] chars = str2.toCharArray();
        System.out.println(Arrays.toString(chars));
    }

    public static void main9(String[] args) {
        String str1 = "11";

        String str2 = new String("1") + new String("1");
        str2.intern();

        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
    }
    public static void main8(String[] args) {
        String str2 = new String("1") + new String("1");
        str2.intern();
        String str1 = "11";

        System.out.println(str1 == str2);
    }
    public static void main6(String[] args) {
        String str1 = "11";
        String str2 = new String("1") + new String("1");
        System.out.println(str1 == str2);
    }
    public static void main5(String[] args) {
        String str1 = "hello";
        String str2 = "he"+"llo";
        String str3 = "he";
        String str4 = str3 +"llo";
        System.out.println(str1 == str4   );

    }

    public static void main4(String[] args) {
        String str1 = "hello";
        String str2 = new String("hello");
        //System.out.println(str1==str2);

    }

    public static void func(String s, char[] array){
        s = "lll";
        array[0] = 'p';
    }
    public static void main3(String[] args) {
        String str = "abcdef";
        char[] chars = {'b','a','c'};
        func(str,chars);
        System.out.println(str);
        System.out.println(Arrays.toString(chars));
    }
    public static void main2(String[] args) {
        String str = "abcdef";
        String str2 = str;
        System.out.println(str);
        System.out.println(str2);
        str = "hhh";
        System.out.println(str);
        System.out.println(str2);




    }
    public static void main1(String[] args) {
        String str = "abcdef";

        String str2 = new String("hello");
        char[] chars = {'a','b','c','d'};
        String str3 = new String(chars);
        System.out.println(str3);

    }
}
