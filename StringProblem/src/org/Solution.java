package org;

import java.util.ArrayList;
import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter String");
		String s=sc.next();
		ArrayList<Character> list=new ArrayList<Character>();
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			char lowerCase = Character.toLowerCase(c);
			char upperCase = Character.toUpperCase(c);
			if(list.contains(upperCase) || list.contains(lowerCase)) {
				if(c=='9') {
					char value = '0';
					while(list.contains(value)) {
			            value++;
					}
					list.add(value);
				}
				else if(c=='z' || c=='Z') {
					int value=0;
					char data=(c=='z'? 'a' : 'A');
					while(list.contains(Character.toUpperCase((char)(data+value))) || list.contains(Character.toLowerCase((char)(data+value)))) {
			            value++;
					}
					list.add((char) (data+value));
				}
				else {
					while(list.contains(Character.toUpperCase(c)) || list.contains(Character.toLowerCase(c))) {
			            c++;
					}
					list.add(c);
				}
			}
			else {
				list.add(c);
			}
		}
		sc.close();
		for(char c:list) {
			System.out.print(c);
		}
	}

}
