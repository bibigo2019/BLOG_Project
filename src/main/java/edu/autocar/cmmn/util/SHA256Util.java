package edu.autocar.cmmn.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class SHA256Util {
	public static String generateSalt() {
		byte[] salt = new byte[8];

		// 랜덤 8바이트 데이터 생성 
		Random random = new Random();
		random.nextBytes(salt);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < salt.length; i++) {
			// byte 값을 Hex 값으로 바꾸기
			sb.append(String.format("%02x", salt[i]));
		}
		return sb.toString();
	}

	public static String getEncrypt(String source, String salt) {
		String result = "";
		String temp = source + salt;
		byte[] bytes = temp.getBytes();
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(bytes);
			byte[] byteData = md.digest();
			// 바이트를 문자열로 변환
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(String.format("%02x", byteData[i]));
			}
			result = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return result;
	}
}
