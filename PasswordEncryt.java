package array;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
// ghfghfghfghf
public class PasswordEncryt {
	public static void main(String args[]) throws NoSuchAlgorithmException, InvalidKeySpecException{
		String originalpass = "Trans@1234";
		String generateSecuredPass = generatePasswordEncrypt(originalpass);
		
		System.out.println(generateSecuredPass);
		
	}
	
	private static String generatePasswordEncrypt(String password) throws NoSuchAlgorithmException, InvalidKeySpecException{
		int iterations = 1000;
		char[] chars = password.toCharArray();
		byte[] salt = getSalt().getBytes();
		
		PBEKeySpec ps = new PBEKeySpec(chars, salt, iterations, 2000 * 8);
		SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		byte[] hash = skf.generateSecret(ps).getEncoded();
		return iterations + ":" + toHex(salt) + ":" + toHex(hash);
		
	}

	private static String toHex(byte[] array) {
		BigInteger bi = new BigInteger(1, array);
		String hex = bi.toString(16);
		return hex;
	}

	private static String getSalt() throws NoSuchAlgorithmException {
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		byte[] salt = new byte[16];
		sr.nextBytes(salt);
		return salt.toString();
	}
	
	public static boolean validatePassword(String original, String storege){
		try{
			String[] parts = storege.split(":");
			int iterations = Integer.parseInt(parts[0]);
			byte[] salt = fromHex(parts[1]);
			byte[] hash = fromHex(parts[2]);
			
			PBEKeySpec ps = new PBEKeySpec(original.toCharArray(), salt, iterations, hash.length * 8);
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			byte[] testHash = skf.generateSecret(ps).getEncoded();
			
			int diff = hash.length ^ testHash.length;
			for(int i=0; i < hash.length && i < testHash.length; i++){
				diff |= hash[i] ^ testHash[i];
			}
			return diff == 0;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private static byte[] fromHex(String hex) {
		byte[] bytes = new byte[hex.length() / 2];
		for(int i = 0; i<bytes.length; i++){
			bytes[i] = (byte)Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
		}
		return bytes;
	}
}
