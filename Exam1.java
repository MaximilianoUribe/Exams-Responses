class Exam1 {
	public static void main(String[] args) {
		double[] arr = {7.1, 8.0, 6.2, 7.2, 9.0, 1.0};
		reverseArray(arr);

		for(int i = 0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}

		double[][] test1 = {{5.1, 2.3, 7.1},
                            {2.0, 7.3},
                            {1.2, 3.1, 5.2, 9.1}};

        double[][] test2 = {{5.1, 2.3, 7.1},
                            {2.0, 7.3, 8.1},
                            {1.2, 3.1, 5.2},
                            {8.2, 9.1, 6.2}};
        System.out.println(isRagged(test1));
        System.out.println(isRagged(test2));

        System.out.println();

        Exam n1 = new Exam(30);
        Exam n2 = new Exam(55);
        Exam n3 = new Exam(5);
        Exam n4 = new Exam(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        System.out.println(countOdds(n1));

        recursivePrint(10);



	}
	//I was asked to reverse an array by not creating a new one 
	//and just changing the values in the array
	static void reverseArray(double[] arr) {
		double[] arr2 = new double[arr.length];
		for(int i = 0; i < arr.length;i++) {
			arr2[i] = arr[i];
		}
		int right = arr.length-1;
		int left = 0;

		while(right > left) {
			arr[left] = arr[right];
			arr[right] = arr2[left];

			right--;
			left++;
		}
	}
	//this is another method to do the reverse an array method
	static void reverseArray2(double[] arr) {
		
		for(int i = 0; i<arr.length/2; i++) {
			double t = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = t;
		}
	}
	//in this methos we want to return true if we have a ragged array
	//and false if we don't have one 
	static boolean isRagged(double[][] arr) {
		int rowLength = arr[0].length;

		for(int i = 1; i<arr.length;i++) {
			if(arr[i].length != rowLength) {
				return true;
			}
		}
		return false;
	}
	//we are cou nting the number of odd numbers in an array
	static int countOdds(Exam head) {
		if(head == null) {
			return 0;
		}


		Exam temp = head;
		int count = 0;

		while(temp!=null) {
			if(temp.data%2 != 0) { 
				count++;
			}
			temp = temp.next;
		}
		return count;
	}
	//mastephensa
	//4n^2 + 5n +2
	//
	//we print a list recursively
	static void recursivePrint(int n) {
		if(n<0) {
			return;
		}
		recursivePrint(n-1);

		System.out.println(n+" ");
	}
}