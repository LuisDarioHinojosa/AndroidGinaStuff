package AndroidHashing;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AppHash {
	public static String md2Hash(int x,String algo) {
		String hexdec = Integer.toHexString(x);
		try {
            MessageDigest md = MessageDigest.getInstance(algo);
            byte[] messageDigest = md.digest(hexdec.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashText = no.toString(16);
            while (hashText.length() < 32) {
                hashText = "0" + hashText;
            }
            return hashText;
            
		}catch(NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
}
