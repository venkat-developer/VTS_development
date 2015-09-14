package com.harman.its.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Class handles all type of utilities on String. 
 * @author VAmukapati
 *
 */
public class StringUtils {
	/**
	 * Replacing Special Chars form the stop name.
	 * It replaces ',""/\&*
	 * @param name
	 * @return
	 */
	public static String removeSpecialCharacter(String name) {
		return name.replace(",", "").replace("&", "").replace("'", "").
				replace("-", "").replace(".", "").replace("/", "").replace("\"", "").replace("", "").replace("*", "");
	}
	public static String md5(final String str) {
		try {
			final MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(str.getBytes());
			return asHex(md5.digest());
		} catch (NoSuchAlgorithmException nsae) {
		}
		return "";
	}
	private static final char[] HEX_CHARS = { '0', '1', '2', '3', '4', '5',
		'6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', };
	/**
	 * Turns array of bytes into string representing each byte as unsigned hex
	 * number.
	 * 
	 * @param hash
	 *            Array of bytes to convert to hex-string
	 * @return Generated hex string
	 */
	public static String asHex(final byte hash[]) {
		final char buf[] = new char[hash.length * 2];
		for (int i = 0, x = 0; i < hash.length; i++) {
			buf[x++] = HEX_CHARS[(hash[i] >>> 4) & 0xf];
			buf[x++] = HEX_CHARS[hash[i] & 0xf];
		}
		return new String(buf);
	}

}
