package heejin.server.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityUtil {
	
    private static byte[] digest(String alg, byte[] input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(alg);
        return md.digest(input);
    }

    public static String getCryptoMD5String(String inputValue) throws Exception {
        if( inputValue == null ) throw new Exception("Can't conver to Message Digest 5 String value!!");
        byte[] ret = digest("MD5", inputValue.getBytes());
        
        // Stringify
        StringBuffer sb = new StringBuffer(); 
		for(int i = 0 ; i < ret.length ; i++){
			sb.append(Integer.toString((ret[i]&0xff) + 0x100, 16).substring(1));
		}
		
        return sb.toString();
    }

}
