package com.zx.mall.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 常用正则表达式
 */
public class RegexUtil {
	
	/** 匹配中文字符的正则表达式 */
	public static final String chinese_regex = "[\u4e00-\u9fa5]";
	/** 匹配空白行的正则表达式 */
	public static final String empty_line_regex = "\\n\\s*\\r";
	/** 匹配URL的正则表达式 */
	public static final String url_regex = "(?i)(http:|https:)//[^\u4e00-\u9fa5]+";
	/** 匹配邮箱的正则表达式 */
	public static final String email_regex = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
	/** 匹配正整数 */
	public static final String positive_num_regex = "^[1-9]\\d*$";
	/** 匹配字母。数字，下划线，中文 */
	public static final String corrent_input = "^[0-9a-zA-Z_\u4e00-\u9FA5]+$";
	/** 匹配12位昵称 */
	public static final String corrent_nick_input = "^[0-9a-zA-Z\u4E00-\u9FA5_]{1,12}$";
	/** 手机号码正则表达式 */
	public static final String mobile = "^((13[0-9])|(15[^4,\\D])|(18[0,2-9])|(147)|(145)|(178))\\d{8}$";
	//顺序表
	static String orderStr="";
	static{
		for(int i=33;i<127;i++){
			orderStr+=Character.toChars(i)[0];
		}
	}
	//判断是否有顺序
	public static boolean isOrder(String str){
		//赐除掉重复连续的字符 
		String tmp = matcher(str);
		if(!tmp.matches("((\\d)|([a-z])|([A-Z]))+")){
			return false;
		}
		return orderStr.contains(tmp);
	}
	//判断是否相同
	public static boolean isSame(String str){
		String regex=str.substring(0,1)+"{"+str.length()+"}";
		return str.matches(regex);
	}

	public static boolean isNormal(String str){
		return str.matches("^[\\d_a-zA-Z]{6,12}$");
	}
	
	/** 
	 * 赐除掉重复连续的字符 
	 * @author deno 
	 */  
	private static String matcher(String str) {  
        //创建一个List   
        List<String> list = new ArrayList<String>();  
        //创建匹配的模式  
        Pattern pattern = Pattern.compile("(.)\\1*");  
        //匹配器  
        Matcher matcher = pattern.matcher(str);  
        //查找与该模式匹配的子序列。从str 里面 查找出 与 此模式 "(.)\\1*"  相匹配的 子序列。如果存在，返回true，如果不存在，返回false.  
        while (matcher.find()){  
            //返回匹配的子序列，并加入到list里面。  
            list.add(matcher.group());  
        }  
        //对分好组的List，进行排序。根据指定比较器产生的顺序对指定列表进行排序。把重复的序列排在前面。  
        Collections.sort(list, new Comparator<String>() {  
            public int compare(String o1, String o2) {  
                return o2.length() - o1.length();  
            }  
        });  
        //找到连续重复的字符,加入到数组中。  
        String[] strings = list.toArray(new String[0]);  
        //找出连续并且重复的子序列。并且把这些连续重复的子序列替换为一个字符。  
        for(int i=0 ;i<=strings.length-1;i++){  
            if(strings[i].length()>1){  
            	str=str.replace(strings[i],strings[i].substring(0, 1));  
            }  
        }  
        //返回把连续重复的字符赐除掉的字符序列。  
        return str;  
    }  
	
	/**
	 * 判断是否匹配正则表达式
	 * @param str	要匹配的字符串
	 * @param patternStr	正则表达式
	 * @return
	 */
	public static Boolean isMatches(String str, String patternStr) {
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(str);
		if(matcher.matches()) {
			return true;
		}
		return false;
	}
	
	public static boolean isMobile(String s) {
		Pattern pattern = Pattern.compile(mobile);
		Matcher matcher = pattern.matcher(s);
		if(matcher.matches()) {
			return true;
		}
		return false;
	}
	
	/**
	 * 判断是否正常密码
	 * 正常密码定义：
	 * 	1.为6-12位数字字母
	 * 	2.不能为重复字符
	 * 	3.不能为连续字符
	 * @param str	要匹配的字符串
	 * @return
	 */
	public static Boolean verPwd(String str) {
		if(isNormal(str)&&!isSame(str)&&!isOrder(str)) {
			return true;
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		String str = "11213";
		System.out.println(matcher(str));
		if(isNormal(str)){
			System.out.println(1);
		}else{
			System.out.println(2);
		}
	}
}
