package application;

import java.util.Scanner;

public class EncryptDecrypt {

	private static Scanner in;

	public static void main(String arg[]) {

		System.out.println("Enter the key:");
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

		boolean goDown = false;
		int j = 0;
		int columns = text.length();
		char[][] matrix = new char[key][columns];
		String encryptedText = "";

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

		System.out.print("Encrypted text: ");

		for (int i = 0; i < key; i++) {
			for (int k = 0; k < columns; k++) {
				if (matrix[i][k] != 0) {
					encryptedText += matrix[i][k];
				}
			}
		}

		System.out.println(encryptedText);

	}

	public static void decrypt(String str, int key) {

		boolean checkdown = false;
		int j = 0;
		int row = key;
		int col = str.length();
		char[][] a = new char[row][col];

		// first of all mark the key position by * in the matrix
		for (int i = 0; i < col; i++) {
			if (j == 0 || j == row - 1)
				checkdown = !checkdown;

			a[j][i] = '*';
			if (checkdown)
				j++;
			else
				j--;

		}

		// now enter the character of cipheetext in the matrix positon that have *
		// symbol
		int index = 0;

		for (int i = 0; i < row; i++) {
			for (int k = 0; k < col; k++) {

				if (a[i][k] == '*' && index < str.length()) {
					a[i][k] = str.charAt(index++);

				}

			}

		}

		// visit each character in key order as character are put in the encryption
		// function
		for (int i = 0; i < row; i++) {
			for (int k = 0; k < col; k++) {
				System.out.print(a[i][k] + "\t");
			}
			System.out.println();
		}

		checkdown = false;
		String s = "";
		j = 0;

		for (int i = 0; i < col; i++) {
			if (j == 0 || j == row - 1)
				checkdown = !checkdown;

			s += a[j][i];

			if (checkdown)
				j++;
			else
				j--;

		}

		System.out.print(s);// print the text that was decrypted by rail fence cipher

	}
}