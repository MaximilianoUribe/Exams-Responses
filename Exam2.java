class Exam2 {
	public static void main(String[] args) {
		System.out.println(getRevSemiVowels("Yadfwafy"));
		//declare the whole linked list
		//and using the linked list for the functions
		StrNode n1 = new StrNode("abc");
		StrNode n2 = new StrNode("xyzx");
		StrNode n3 = new StrNode("axcsd");
		StrNode n4 = new StrNode("klmxc");
		StrNode n5 = new StrNode("t123");

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;

		System.out.println(countEvenLengthStrings(n1));
	}
	//we are given a string and we want to check if it contains the letter
	//(y,Y,w,W) and we want to return the them in order
	//from end to start
	static String getRevSemiVowels(String given) {
		//once the string has no length we return an 
		//empty string
		if(given.length() == 0)
			return "";
		//we make recursive calls until we have an empty string
		//we decreade the length of the string by one every time
		String result = getRevSemiVowels(given.substring(1));
		//if the letter equals one of the requirements we add
		//them to the string
		if(given.charAt(0)=='Y' || given.charAt(0)=='y' || given.charAt(0)=='w' || given.charAt(0)=='W'){
			result += given.charAt(0);
		}
		//return the string that only contains the asked characters
		return result;
	}
	//we want to check return the number of even length words 
	//that are inside the linked list 
	static int countEvenLengthStrings(StrNode head) {
		//if we don't have nothing we return 0
		if(head == null)
			return 0;
		//if we only have one node or one node left we return 0
		//or 1 depending on the length of data
		if(head.next==null){
			//sum one if the word lenght is even
			if(head.data.length()%2==0){
				return 1;
			}else{
				//if is not even just not sum nothing
				return 0;
			}
		}
		//we go to the last node and then start from there 
		int sum = countEvenLengthStrings(head.next);
		//we check if 
		if(head.data.length()%2==0){
			return sum+1;
		}else{
			return sum;
		}
	}
}