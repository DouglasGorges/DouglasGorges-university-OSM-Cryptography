package application;

import java.util.Scanner;

public class RailFence {

	private static Scanner in;

	public static void main(String args[]) {

		System.out.println("Create a key (some small numbers):");
		in = new Scanner(System.in);
		int key = in.nextInt();
		System.out.println("Enter the text for encryption");
		in = new Scanner(System.in);
		String text = in.next();

		encrypt(text, key);

		System.out.println("Enter the key:");
		key = in.nextInt();
		System.out.println("Enter the encrypted text for decryption:");
		String encryptedText = in.next();

		decrypt(encryptedText, key);

	}

	public static void encrypt(String text, int key) {
		StringBuilder encryptedText = new StringBuilder();
		boolean goDown = false;
		int j = 0;
		int columns = text.length();
		char[][] matrix = new char[key][columns];
		for (int i = 0; i < columns; i++) {
			if (j == (key - 1) || j == 0) {
				goDown = !goDown;
			}
			matrix[j][i] = text.charAt(i);
			if (goDown) {
				j++;
			} else {
				j--;
			}
		}
		for (int i = 0; i < key; i++) {
			for (int k = 0; k < columns; k++) {
				if (matrix[i][k] != 0) {
					encryptedText.append(matrix[i][k]);
				}
			}
		}
		System.out.printf("Encrypted text: %s %n %n", encryptedText);
	}

	public static void decrypt(String str, int key) {
		StringBuilder decryptedText = new StringBuilder();
		boolean goDown = false;
		int j = 0;
		int columns = str.length();
		int index = 0;
		char[][] matrix = new char[key][columns];
		for (int i = 0; i < columns; i++) {
			if (j == (key - 1) || j == 0) {
				goDown = !goDown;
			}
			matrix[j][i] = '*';
			if (goDown) {
				j++;
			} else {
				j--;
			}
		}

		for (int i = 0; i < key; i++) {
			for (int k = 0; k < columns; k++) {
				if (matrix[i][k] == '*' && index < str.length()) {
					matrix[i][k] = str.charAt(index++);
				}
			}
		}
		goDown = false;
		j = 0;
		for (int i = 0; i < columns; i++) {
			if (j == (key - 1) || j == 0) {
				goDown = !goDown;
			}
			decryptedText.append(matrix[j][i]);
			if (goDown) {
				j++;
			} else {
				j--;
			}
		}
		System.out.printf("Decrypted text: %s %n %n", decryptedText);
	}
}