public class Text {
    public static void main(String[] args) {
       /* *//**
         * 字符串反转
         *//*
        String s = "abcdefg";
        String b = "";
        for (int i = s.length()-1;i>-1;i--){
            b=b+s.charAt(i);
        }
        System.out.println(b);*/

        /**
         * 字符串去空白
         *//*
        String s = "a bc d e";
        String b ="";
        Character c = ' ';
        for (int i=0;i<s.length();i++){
            if(s.charAt(i) != c){
                b+=s.charAt(i);
            }
        }
        System.out.println(b);*/

    }
}
