package com.fzu.utils;

public class JudgeUp {
    public static boolean judge(String str,int kk){
        //大写
        String big = "壹贰叁肆伍陆柒捌玖零";//0待定
        //单位
        String wei = "佰拾仟万";
        //小写
        String small = "1234567890";
        //空字符串存结果
        String result = "";
        //flag判断
        int flag=0;
        int l = str.length();
        for (int i = 0; i < l; i++) {
            //取单个字符判断
            char at = str.charAt(i);
            String s = ""+at;
            //先判断第一个
            if(i==0){
                if(big.contains(s)){
                    //是大写的话
                    flag=100;
                    if(s=="拾") {
                        continue;
                    }
                    continue;
                }
                else if(small.contains(s)){
                    //是小写的话
                    if(s=="0"){
                        System.out.println("输入格式错误，开头不能为0");
                        return false;
                    }
                    flag=0;
                    continue;
                }
                else {
                    System.out.println("输入错误");
                    return false;
                }
            }
            //判断最后一位
            else if(i==l-1){
                if(s=="元"){
                    return true;
                }
                if(small.contains(s)){
                    char ch1 = str.charAt(i-1);
                    String s1 = ""+ch1;
                    if(!big.contains(s1)){
                        return false;
                    }
                    return true;
                }
                else if(big.contains(s)){
                    char ch1 = str.charAt(i-1);
                    String s1 = ""+ch1;
                    if(!wei.contains(s1)){
                        return false;
                    }
                    return true;
                }
            }

            else{
                //再判断之后的内容,小写
                if(flag<100){
                    //如果是小写
                    if(small.contains(s)){
                        flag++;
                    }
                    else
                    {
                        System.out.println("格式错误");
                        return false;
                    }
                }
                else if(flag>=100){ //大写
                    //如果是大写big的话
                    if(big.contains(s)){
                        //先++
                        flag++;
                        //得是陆佰陆类型或佰陆佰
                        char ch1 = str.charAt(i-1); //玖
                        String s1 = ""+ch1;
                        if(!wei.contains(s1)){   //仟
                            System.out.println("格式错误");
                            return false;
                        }
                        char ch2 = str.charAt(i+1);
                        String s2 = ""+ch2;
                        if (!wei.contains(s2)){
                            System.out.println("格式错误");
                            return false;
                        }
                        continue;
                    }
                    //如果是单位wei的话
                    else if(wei.contains(s)){
                        char ch1 = str.charAt(i-1);
                        String s1 = ""+ch1;
                        if(!big.contains(s1)){
                            System.out.println("格式错误");
                            return false;
                        }
                        char ch2 = str.charAt(i+1);
                        String s2 = ""+ch2;
                        if(!big.contains(s2)){
                            System.out.println("格式错误");
                            return false;
                        }
                        continue;
                    }
                    //如果是其他或者小写的话
                    else{
                        System.out.println("输入格式错误");
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean bigjudge(String str) {
        boolean flag = false;
        int index = str.indexOf(("亿"));
        if(index == -1) {
            flag = judge(str, 0);
        }
        else {
            if(index == 0) {
                return false;
            }
            String str1 = str.substring(0, index - 1);
            flag = judge(str1,1);
            if(flag == false) {

                return false;
            }

            String str2 = str.substring(index+1);
            flag = judge(str2, 0);
            return flag;
        }
        return true;
    }


}
