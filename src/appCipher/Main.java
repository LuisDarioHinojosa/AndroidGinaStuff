package appCipher;

import appCipher.AppCipher;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Main {

	public static void main(String[] args) throws IOException,UnsupportedEncodingException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException,NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException,IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
        String clearText ="odioAgina";
        String key = "aeda17fa60187851b74f9928664dd08b333";
        
        System.out.println ("texto claro: " + clearText);
        String c = AppCipher.encryptForDES(clearText, key);
        
        System.out.println("Texto cifrado; " + c);
        String d = AppCipher.decryptForDES(c, key);
        System.out.println("decifrado: " + d);
        

	}

}
