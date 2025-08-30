package com.nt.arrayString;

import java.util.*;

 class Code{
	
	public String encode (List<String>strs) {
		if(strs.size()==0) {
			return Character.toString((char)258);
		}
		String separate = Character.toString((char)257);
		StringBuilder sb = new StringBuilder();
		for(String s : strs) {
			sb.append(s);
			sb.append(separate);
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
	
	public List<String> decode (String s){
		if(s.equals(Character.toString((char)258))) {
			return new ArrayList();
		}
		String separate = Character.toString((char)257);
		return Arrays.asList(s.split(separate,-1));
	}
}

public class EncodeDecode {
	public static void main(String[] args) {
        Code c = new Code();

        // Example input
        List<String> strs = Arrays.asList("hello", "world", "java", "encode/decode");

        // Encode
        String encoded = c.encode(strs);
        System.out.println("Encoded: " + encoded);

        // Decode
        List<String> decoded = c.decode(encoded);
        System.out.println("Decoded: " + decoded);
	}     
}
