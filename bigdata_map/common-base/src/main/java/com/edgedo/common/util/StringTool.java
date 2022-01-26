package com.edgedo.common.util;



import java.util.regex.Pattern;

public class StringTool {

    public static final boolean testPhone(String phone){
        Pattern p = Pattern.compile("^1\\d{10}$");
        return p.matcher(phone).matches();
    }

    public static final boolean testEmail(String email){

        Pattern p = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
        return p.matcher(email).matches();
    }

    public static final boolean testUserCode(String userCode){

        Pattern p = Pattern.compile("^[a-zA-Z]\\w{5,23}");
        return p.matcher(userCode).matches();
    }

    public static final String getEncodePhoneNum(String phoneNum){
        return phoneNum.substring(0, 3)+"****" + phoneNum.substring(7);
    }

    /**
     * 加密重要编号  隐藏中间几位
     * @return
     */
    public static final String encodeImportentNum(String num){
        if(num==null|| num.length()<6){
            return num;
        }else{
            String num1 = num.substring(0,3);
            String num2 = num.substring(num.length()-3,num.length());
            int s = num.length()-6;
            String str ="";
            for(int i =0;i<s;i++){
                str+="*";
            }
            num = num1+str+num2;
            return num;
        }
    }

    /**
     * 加密重要编号  隐藏后四位
     * @return
     */
    public static final String encodeImportentNum1(String num){
        if(num==null|| num.length()<4){
            return num;
        }else{
            num = num.substring(0,num.length()-4) +"****";
            return num;
        }
    }

   
    public static final boolean testUrl(String target){
        Pattern pattern = Pattern
                .compile("^([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/])+$");
        return pattern.matcher(target).matches();
    }

    /**
     * 根据类型生成编号，不是每日从头记录
     * @param type
     * @param length
     * @return
     */
    /*public static final String genDateCode(String type,int length){
        PtCodeTypeGenService genService = IocUtil.getBean(PtCodeTypeGenService.class);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String prefix = sdf.format(new Date());
        Long number = genService.genCode(type, length);
        String after = String.format("%0" + length + "d", number);
        return type+prefix+after;

    }*/



    /**
     * 根据类型生成编号，每日从头记录
     * @param type
     * @param length
     * @return
     */
    /*public static String genDateCode2(String type,int length) {
        PtCodeTypeGenService genService = IocUtil.getBean(PtCodeTypeGenService.class);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String prefix = sdf.format(new Date());
        type = type+prefix;
        Long number = genService.genCode(type,length);
        String after = String.format("%0"+length+"d", number);
        return type+after;
    }*/

    /*public static long genDateCodeNumLong(String type,int length) {
        PtCodeTypeGenService genService = IocUtil.getBean(PtCodeTypeGenService.class);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String prefix = sdf.format(new Date());
        type = type+prefix;
        Long number = genService.genCode(type,length);
        return number;
    }*/

    /*public static void main(String[] args){
        System.out.print(testUrl("sf"));
    }*/

}
