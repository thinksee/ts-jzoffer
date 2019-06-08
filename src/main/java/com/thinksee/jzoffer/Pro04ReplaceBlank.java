package com.thinksee.jzoffer;

/**
 * @author thinksee
 * @since 2019-5-28
 * 实现一个函数，把字符串中的每个空格替换成"%20"；
 * "We are happy." ----> "We%20are%20happy."
 */
public class Pro04ReplaceBlank {
    static char[] replaceBlank(char[] str){
        int numberOfBlank = 0;
        for(int i = 0; i < str.length; ++i){
            if(str[i] == ' '){
                ++numberOfBlank;
            }
        }
        char[] result = new char[str.length + 2 * numberOfBlank];
        for(int i = result.length - 1, j = str.length - 1; j >= 0; --j){
            if(str[j] == ' '){
                result[i--] = '0';
                result[i--] = '2';
                result[i--] = '%';
            }else{
                result[i--] = str[j];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println("We%20are%20happy.");
        String str = "We are happy.";
        System.out.println(String.valueOf(replaceBlank(str.toCharArray())));
    }
}
