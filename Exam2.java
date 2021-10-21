class Exam2 {
	public static void main(String[] args) {
		System.out.println(getRevSemiVowels("Yadfwafy"));

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
	static String getRevSemiVowels(String given) {
		if(given.length() == 0)
			return "";

		String result = getRevSemiVowels(given.substring(1));

		if(given.charAt(0)=='Y' || given.charAt(0)=='y' || given.charAt(0)=='w' || given.charAt(0)=='W'){
			result += given.charAt(0);
		}
		return result;
	}
	static int countEvenLengthStrings(StrNode head) {
		if(head == null)
			return 0;
		if(head.next==null){
			if(head.data.length()%2==0){
				return 1;
			}else{
				return 0;
			}
		}
		int sum = countEvenLengthStrings(head.next);

		if(head.data.length()%2==0){
			return sum+1;
		}else{
			return sum;
		}
	}
}