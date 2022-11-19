package com.fzu.utils;

import java.math.BigDecimal;

public class UppercaseToLowercase {
    private static char[] cnNum = new char[]{'零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖'};
    private static char[] unitArr = new char[]{'厘', '分', '角', '圆', '拾', '佰', '百', '仟', '千', '万', '亿'};

    public static BigDecimal chinese2Number(String chineseNumber) {
        BigDecimal result = new BigDecimal(0);
        int lastUnitIndex = 0, num = 0;
        boolean nor = true; //nor这个标记，专门用来标记是否同时存在“亿” 和 “万”这两个单位。
        chineseNumber = chineseNumber.replace("元", "圆");
        for (int i = 0; i < chineseNumber.length(); i++) {
            boolean isUnit = true; //标记当前位是否是单位，而不是数字
            char c = chineseNumber.charAt(i);
            for (int j = 0; j < cnNum.length; j++) {
                // 是数字
                if (c == cnNum[j]) {
                    // 数字值 = 索引
                    num = j;
                    isUnit = false;
                    break;
                }
            }
            if (isUnit) {
                // 第一个就是单位，如：拾伍万圆整
                if (i == 0) {
                    num = 1;
                }
                int unitIndex = getUnitIndex(c);
                BigDecimal unit = getUnit(c);
                BigDecimal yi = new BigDecimal("100000000.00"); //1亿
                if (unitIndex > lastUnitIndex) {
                    result = result.add(new BigDecimal(num)).multiply(unit);
                } else {
                    result = result.add(new BigDecimal(num).multiply(unit));
                }

                if (nor && result.compareTo(yi) > -1) {
                    for (int k = i + 1; k < chineseNumber.length(); k++) {
                        char tmp = chineseNumber.charAt(k);
                        if (tmp == unitArr[9]) {
                            result = result.divide(new BigDecimal("10000.00"));
                            nor = false;
                        }
                    }
                }

                lastUnitIndex = unitIndex;
                num = 0;
            }
        }
        return result.setScale(2, BigDecimal.ROUND_DOWN);
    }

    private static int getUnitIndex(char c) {
        for (int j = 0; j < unitArr.length; j++) {
            if (c == unitArr[j]) {
                return j;
            }
        }
        return 0;
    }

    private static BigDecimal getUnit(char c) {
        double num = 0;
        int unitIndex = getUnitIndex(c);
        switch (unitIndex) {
            // '厘', '分', '角', '圆', '拾', '佰', '仟', '万', '亿'
            case 4:
                num = 10;
                break;
            case 5:
                num = 100;
                break;
            case 6:
                num = 100;
                break;
            case 7:
                num = 1000;
                break;
            case 8:
                num = 1000;
                break;
            case 9:
                num = 10000;
                break;
            case 10:
                num = 100000000;
                break;
            case 3:
                num = 1;
                break;
            case 2:
                num = 0.1;
                break;
            case 1:
                num = 0.01;
                break;
            case 0:
                num = 0.001;
                break;
            default:
                break;
        }
        return new BigDecimal(num);
    }
}
