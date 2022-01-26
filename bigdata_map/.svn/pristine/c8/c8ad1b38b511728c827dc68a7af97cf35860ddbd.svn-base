package com.edgedo.common.util;


import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Tool {

    public Tool() {

    }

    /**
     * 灏嗗瓧绗﹁浆鎹㈡垚int
     * @param strNumber
     * @return
     */
    public static int convertStringToInt(String strNumber) {
        int intNumber = 0;

        if (strNumber != null && !strNumber.equals("")) {
            try {
                intNumber = new Integer(strNumber).intValue();
            } catch (NumberFormatException e) {
                System.out.println("NumberFormatException:>>" + e.toString() + "<<str>>" + strNumber);
            }
            return intNumber;
        } else {
            return 0;
        }
    }

    /**
     * 灏嗗瓧绗﹁浆鎹㈡垚long
     * @param strNumber
     * @return
     */
    public static long convertStringToLong(String strNumber) {
        long lNumber = 0;

        if (strNumber != null && !strNumber.equals("")) {
            try {
                lNumber = Long.parseLong(strNumber);
            } catch (NumberFormatException e) {
                lNumber = 0;
                System.out.println("NumberFormatException:>>" + e.toString() + "<<str>>"
                        + strNumber);
            }
            return lNumber;
        } else {
            return 0;
        }
    }

    /**
     * 灏嗗瓧绗﹁浆鎹㈡垚double
     * @param strNumber
     * @return
     */
    public static double convertStringToDouble(String strNumber) {
        double dNumber = 0;

        if (strNumber != null && !strNumber.equals("")) {
            try {
                dNumber = Double.parseDouble(strNumber);
            } catch (NumberFormatException e) {
                dNumber = 0;
                System.out.println("NumberFormatException:>>" + e.toString() + "<<str>>"
                        + strNumber);
                throw e;
            }
            return dNumber;
        } else {
            return 0;
        }
    }

    /**
     * 灏嗗瓧绗﹁浆鎹㈡垚float
     * @param strNumber
     * @return
     */
    public static float convertStringToFloat(String strNumber) {
        float fNumber = 0;

        if (strNumber != null && !strNumber.equals("")) {
            try {
                fNumber = Float.parseFloat(strNumber);
            } catch (NumberFormatException e) {
                fNumber = 0;
                System.out.println("NumberFormatException:>>" + e.toString() + "<<str>>" + strNumber);
            }
            return fNumber;
        } else {
            return 0;
        }
    }

    /**
     * 鏍煎紡鍖杁ouble
     * @param f 鍘熸暟鎹?
     * @param scale 淇濈暀鐨勫皬鏁颁綅鏁帮紝濡傛灉涓?锛屾寜鍥涜垗浜斿叆鍙栨暣
     * @return
     */
    public static String doubleFormatString(double f, int scale){
    	BigDecimal b = new BigDecimal(f);
    	double f1 = b.setScale(scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    	if(scale==0){
    		return String.valueOf(Integer.parseInt(new java.text.DecimalFormat("0").format(f1)));
    	}
    	return String.valueOf(f1);
    }

    /**
     * 澶嶅埗瀛楃涓?
     * @param s
     * @param iRate
     * @return
     */
    public static String copyString(String s, int iRate) {
        String sRt = "";
        for (int i = 0; i < iRate; i++) {
            sRt += s;
        }

        return sRt;
    }

    /**
     * 灏嗗瓧绗︽暟缁勮浆鎹㈡垚涓哄瓧绗︿覆
     * @param str
     * @return
     */
    public static String convertString(String[] str) {
        String restr = "";
        if (str == null) {
            return "";
        }
        for (int i = 0; i < str.length; i++) {
            restr += str[i];
        }
        return restr;
    }

    /**
     * 瀵瑰瓧绗︿覆杩涜缂栫爜
     * @param str
     * @return
     */
    public static String encodeStr(String str) {
        String s = "";
        byte[] b;
        try {
            b = str.getBytes("ISO8859-1");
            s = new String(b, "UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     * 灏唎bject杞崲鎴愪负瀛楃
     * @param o
     * @return
     */
    public static String convertObject(Object o) {
        String s = "";
        if (o == null) {
            return s;
        } else {
            return o.toString();
        }
    }

    /**
     * 灏唍ull杞崲鎴愪负闀垮害涓?鐨勫瓧绗?
     * @return
     */
    public static String convertNull() {
        return convertObject(null);
    }

    /**
     * 鍘绘帀绌烘牸
     * @param o
     * @return
     */
    public static String kill_Null(Object o) {
        if (o == null) {
            return "";
        } else {
            return String.valueOf(o).trim();
        }
    }

    /**
     * 楠岃瘉鏄惁鏄瓧绗?
     * @param str
     * @param type
     * @return
     */
    public static boolean judgeNum(String str, int type) {
        boolean ret = true;
        if (str == null)
            return ret;
        if (type == 2) {
            final String number = "1234567890 ";
            for (int i = 0; i < str.length(); i++) {

                if (number.indexOf(str.charAt(i)) == -1) {
                    ret = false;
                    break;
                }
            }
        } else {
            try {
                Float.parseFloat(str);
            } catch (NumberFormatException e) {
                ret = false;
            }
        }

        return ret;
    }

    /**
     * 楠岃瘉鏄惁鏄棩鏈?
     * @param sDate
     * @return
     */
    public static boolean isDateString(String sDate) {
        if (sDate == null)
            return true;
        if (sDate.trim().equals(""))
            return true;
        int[] iaMonthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] iaDate = new int[3];
        int year, month, day;

        if (sDate == null)
            return false;
        try {
            int iBeg = sDate.indexOf("-");
            int iEnd = sDate.lastIndexOf("-");
            iaDate[0] = Tool.convertStringToInt(sDate.substring(0, 4));
            iaDate[1] = Tool
                    .convertStringToInt(sDate.substring(iBeg + 1, iEnd));
            iaDate[2] = Tool.convertStringToInt(sDate.substring(iEnd + 1));

            year = iaDate[0];
            month = iaDate[1];
            day = iaDate[2];

            if (year < 1900 || year > 2200)
                return false;
            if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))
                iaMonthDays[1] = 29;
            if (month < 1 || month > 12)
                return false;
            if (day < 1 || day > iaMonthDays[month - 1])
                return false;

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 寰楀埌6浣嶉殢鏈烘暟
     * @return
     * @throws Exception
     */
    public static String getRandom() throws Exception {
        Random ran = new Random();
        int rtn = ran.nextInt(1000000);
        if (rtn < 100000) {
            rtn = rtn * 10;
        }
        return Integer.toString(rtn);
    }

    public static String createUserIdentifier(int number){
		String str = "0123456789";
		StringBuffer buf = new StringBuffer();
		Random r = new Random();
		for(int i=0;i < number;i++){
			buf.append(str.charAt(r.nextInt(str.length())));
		}
		return buf.toString();
	}
    /**
     * 寰楀埌6浣嶉殢鏈烘暟
     * @return
     * @throws Exception
     */
    public static String getRandomID() throws Exception {
        Random ran = new Random();
        int rtn = ran.nextInt(1000000);
        if (rtn < 10000) {
            rtn = rtn * 10;
        }
        return Integer.toString(rtn);
    }

    /**
     * 寰楀埌9浣嶉殢鏈烘暟
     * @return
     * @throws Exception
     */
    public static String getRandomAccount() throws Exception {
        Random ran = new Random();
        int rtn = ran.nextInt(1000000000);
        if (rtn < 10000000) {
            rtn = rtn * 10;
        }
        return Integer.toString(rtn);
    }

    /**
     * 灏嗕互鍒嗗彿涓哄垎闅旂鐨勫瓧绗﹁浆鎹㈡垚涓洪泦鍚?
     * @param phoneStr
     * @return
     */
    public static ArrayList<String> splitStr(String phoneStr) {
        String originStr = phoneStr;
        ArrayList<String> phoneList = new ArrayList<String>();
        int index = originStr.indexOf(';');
        while (index != -1) {
            String phonenum = originStr.substring(0, index);
            phonenum = phonenum.trim();
            phoneList.add(phonenum);
            originStr = originStr.substring(index + 1);
            index = originStr.indexOf(';');
        }
        if (originStr.length() >= 11)
            phoneList.add(originStr);
        return phoneList;
    }

    /**
	 * 鍒ゆ柇鏄惁鍏ㄦ槸鏁板瓧
	 * @param str
	 * @return true 鏄紝false 鍚?
	 */
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}

	/**
	 * 鎻愬彇鏁板瓧
	 * @param str
	 * @return
	 */
	public static String extractionDigital(String str){
		String regEx = "[0-9]*";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		String temp = "";
		while (m.find()) {
			temp += m.group(0);
		}
		return convertObject(temp);
	}

	/**
	 * 鍒ゆ柇鏄惁鏄墜鏈哄彿
	 * @param phoneNumber
	 * @return true 鏄?false 涓嶆槸
	 */
	public static boolean isMobile(String phoneNumber){
		return phoneNumber.matches("^(13|14|15|18)\\d{9}$");
	}

	/**
	 * 鍒ゆ柇鏄惁鏄浐瀹氱數璇?
	 * @param phoneNumber
	 * @return true 鏄紝false 鍚?
	 */
	public static boolean isTelephone(String phoneNumber){
		boolean boo = phoneNumber.matches("^0(([1,2]\\d)|([3-9]\\d{2}))\\d{8}$");
    	if(boo==false){
    		boo = phoneNumber.matches("^0(([1,2]\\d)|([3-9]\\d{2}))\\d{7}$");
    	}
    	return boo;
	}

	public static String toUtf8String(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 0 && c <= 255) {
				sb.append(c);
			} else {
				byte[] b;
				try {
					b = Character.toString(c).getBytes("utf-8");
				} catch (Exception ex) {
					System.out.println(ex);
					b = new byte[0];
				}
				for (int j = 0; j < b.length; j++) {
					int k = b[j];
					if (k < 0)
						k += 256;
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();
	}

	/**
	* 楠岃瘉杈撳叆瀵嗙爜鏉′欢(瀛楃涓庢暟鎹悓鏃跺嚭鐜?
	*
	* @param 寰呴獙璇佺殑瀛楃涓?
	* @return 濡傛灉鏄鍚堟牸寮忕殑瀛楃涓?杩斿洖 <b>true </b>,鍚﹀垯涓?<b>false </b>
	*/
	public static boolean IsPassword(String str) {
		Pattern pattern = Pattern.compile("[A-Za-z]+[0-9]");
		return pattern.matcher(str).matches();
	}
	
	public static boolean isStart;
    /*public static void main(String[] args) throws Exception {
    	*//*int rule = 1;
    	String s = "1348";
    	
    	String[] found = null;
		Pattern p = null;
		if(rule==1){
			p = Pattern.compile("(.{3}|.{0,3})(.{4}|.{0,4})(.{4}|.{0,4})");
		} else if(rule==2){
			p = Pattern.compile("(.{6}|.{0,6})(.{8}|.{0,8})(.{3}|.{0,3})(.{1}|.{0,1})");
		} else if(rule==3){
			p = Pattern.compile("(.{4}|.{0,4})(.{4}|.{0,4})(.{4}|.{0,4})(.{7}|.{0,7})");
		} else if(rule==4){
			p = Pattern.compile("(.{4}|.{0,4})(.{4}|.{0,4})(.{4}|.{0,4})(.{3}|.{0,3})");
		} else if(rule==5){
			p = Pattern.compile(".{4}|.{0,4})(.{4}|.{0,4})(.{4}|.{0,4})(.{4}|.{0,4})(.{3}|.{0,3})");
		} else if(rule==6){
			p = Pattern.compile("(.{4}|.{0,4})(.{4}|.{0,4})(.{4}|.{0,4})(.{5}|.{0,5})");
		} else if(rule==7){
			p = Pattern.compile("(.{2}|.{0,2})(.{4}|.{0,4})(.{4}|.{0,4})(.{4}|.{0,4})(.{4}|.{0,4})");
		} else if(rule==8){
			p = Pattern.compile("(.{4}|.{0,4})(.{4}|.{0,4})(.{4}|.{0,4})(.{4}|.{0,4})(.{3}|.{0,3})");
		} else if(rule==9){
			p = Pattern.compile("(.{4}|.{0,4})(.{4}|.{0,4})(.{4}|.{0,4})(.{4}|.{0,4})(.{2}|.{0,2})");
		}
		if(p!=null){
			Matcher m = p.matcher(s);
	    	if (m.matches()) {
	    		int len = m.groupCount();
	    		found = new String[len];
	    		for (int i = 1; i <= len; i++) {
	    			found[i - 1] = m.group(i);
	    		}
	    	}
		}
		if(found!=null && found.length>0){
			String result = "";
    		for(int i=0;i<found.length;i++){
    			if(!found[i].equals("")){
    				result+=found[i]+" ";
    			}
        	}
    		s=result.trim();
		}
    	
    	System.out.println("s="+s+",length="+s.length());*//*
    	
    	*//*String sql = "c35p6";
    	System.out.println(sql.substring(1, 3));*//*
    	
    	int x = 4;
    	for(int i=0;i<x;i+=3){
    		if(i<=x){
    			System.out.println(i);
    		}
    		if(i+1<=x){
    			System.out.println(i+1);
    		}
    		if(i+2<=x){
    			System.out.println(i+2);
    		}
    		if(i+3<=x){
    			System.out.println(i+3);
    		}
    		System.out.println("=====================");
    	}
    	
    	
    	
    }*/

}
