package com.test;

public class Test03 {
	public static void main(String[] args) {
		String ipStr = "192.168.1.1";
//		ipStr = ipStr.replaceAll("\\.", "");
//		int parseInt = Integer.parseInt(ipStr);
//		System.out.println(parseInt);
//		String hexString = Integer.toHexString(parseInt);
//		System.out.println(hexString);
//		Integer a = 192;
//		System.out.println(Integer.toHexString(a));
		String stringToHexString = Test03.stringToHexString(ipStr);
		System.out.println(stringToHexString);
	}
	
	public static String stringToHexString(String strPart) {
        String hexString = "";
        for (int i = 0; i < strPart.length(); i++) {
            int ch = (int) strPart.charAt(i);
            String strHex = Integer.toHexString(ch); 
            hexString = hexString + strHex;
        }
        return hexString;
    }

	
}
