package com.kipb.base.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PwdUtil
{
    /**
     * pwd에 숫자가 있는지 판별한다.
     * @param pwd 비밀번호
     * @return 판별여부
     */
    public static boolean isDigit(String pwd)
    {
        String pattern = "[0-9]";
        Matcher matcher = Pattern.compile(pattern).matcher(pwd);
        return matcher.find();
    }

    /**
     * pwd에 공백이 있는지 판별한다.
     * @param pwd 비밀번호
     * @return 판별여부
     */
    public static boolean isWhiteSpace(String pwd)
    {
        String pattern = "(\\s)";
        Matcher matcher = Pattern.compile(pattern).matcher(pwd);
        return matcher.find();
    }

    /**
     * pwd에 특수문자가 있는지 판별한다.
     * @param pwd 비밀번호
     * @return 판별여부
     */
    public static boolean isSPChar(String pwd)
    {
        String pattern = "^[0-9|a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣|\\s]*$";
        Matcher matcher = Pattern.compile(pattern).matcher(pwd);
        return !matcher.find();
    }

    /**
     * pwd에 연속된 숫자 / 문자가 있는지 판별한다.
     * @param pwd 비밀번호
     * @return 판별여부
     */
    public static boolean isContinuous(String pwd)
    {
        int len = pwd.length();
        boolean check = false;
        boolean isPositive = false;
        for(int i = 0; i < len - 1 ; i++)
        {
            char now = pwd.charAt(i);
            char next = pwd.charAt(i+1);
            int value = now - next;
            boolean tempB = value > 0;
            if(Math.abs(value) == 1)
            {
                if(check)
                {
                    if(isPositive == tempB)
                    {
                        return true;
                    }
                }
                isPositive = tempB;
                check = true;
            }
            else{
                check = false;
            }
        }
        return false;
    }

    /**
     * pwd에 같은 문자 / 숫자가 3개이상 반복되는지 판별한다.
     * @param pwd 비밀번호
     * @return 판별여부
     */
    public static boolean isSame(String pwd)
    {
        String pattern = "(\\w)\\1\\1";
        Matcher matcher = Pattern.compile(pattern).matcher(pwd);
        return matcher.find();
    }
}