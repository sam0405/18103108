package ques1;

public class solution2 {
	public static void main(String[] args) {
		int number = -1;
		byte no_byte = (byte)number;
		char no_char = (char)no_byte;
		int no_int = (int)no_char;
		System.out.println(no_int);
	}
}
// We have stored -1 in an integer variable number.
//Integer ranges from -2^31 to 2^31-1, hence -1 can be stored in integer.
//Then we cast from integer to bytes and store in no_byte which is 8-bit which can store -128 to 127.
//Then we cast from bytes to character and store in no_char which is 26-bit and can store 0 to 2^16-1 values.
//Last, we cast it back to integer and store it in no_int.
//As number -1 is out of range and as it is -1 so 2^16-1 is stored in no_char
//And then when we cast it to no_int, the value printed in 2^16-1.