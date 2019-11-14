package application;

import java.util.Scanner;

public class EncryptDecrypt {

	public static void main(String arg[]) {

		System.out.println("Enter the number of rails:");
		Scanner in = new Scanner(System.in);
		int rails = in.nextInt();

		System.out.println("Enter the plaintext for encryption");
		Scanner inn = new Scanner(System.in);
		String plaintext = inn.next();

		encryption(plaintext, rails);

		System.out.println("------------------Decryption process start----------");

		System.out.println("Enter the number of rails:");
		rails = in.nextInt();
		System.out.println("Enter the ciphertext for decryption:");
		String ciphertext = in.next();
		decryption(ciphertext, rails);

	}

	public static void encryption(String str, int rails) {

		boolean checkdown = false; // check whether it is moving downward or upward
		int j = 0;
		int row = rails; // no of row is the no of rails entered by user
		int col = str.length(); // column length is the size of string
		char[][] a = new char[row][col];
		// we create a matrix of a of row *col size

		for (int i = 0; i < col; i++) { // matrix visitin in rails order and putting the character of plaintext

			if (j == 0 || j == row - 1)
				checkdown = !checkdown;
			a[j][i] = str.charAt(i);
			if (checkdown) {

				j++;
			} else
				j--;
		}

		// visiting the matrix in usual order to get ciphertext
		for (int i = 0; i < row; i++) {
			for (int k = 0; k < col; k++) {
				System.out.print(a[i][k] + "  ");
			}
			System.out.println();
		}
		String en = "";

		System.out.println("----------------------");
		for (int i = 0; i < row; i++) {
			for (int k = 0; k < col; k++) {
				if (a[i][k] != 0)
					en = en + a[i][k];

			}

		}
		System.out.println(en);// printing the ciphertext

	}

	public static void decryption(String str, int rails) {

		boolean checkdown = false;
		int j = 0;
		int row = rails;
		int col = str.length();
		char[][] a = new char[row][col];

		// first of all mark the rails position by * in the matrix
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

		// visit each character in rails order as character are put in the encryption
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

		System.out.print(s);// print the plaintext that was decrypted by rail fence cipher

	}
}