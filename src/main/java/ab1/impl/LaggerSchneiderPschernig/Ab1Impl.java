package ab1.impl.LaggerSchneiderPschernig;

import ab1.Ab1;



public class Ab1Impl implements Ab1 {



	@Override
	public boolean isHeap(int i, int j, int[] data) {

		/* algorithm to check if array fulfills heap-condition
		i= beginning of array
		j= end of array
		 */

		//an array with a length of one qualifies as heap, return true
		if (data.length==1){
			return true;
		}

		else if (i*2+1>j && j/2<j*2+1){
			return false;
		}
		//checks if conditions are not met to be heap, returns false
		for (int k = i; k < j/2; k++) {
			if (data[k-1]<data[2*k-1] || data[k-1]<data[2*k]){
				return false;
			}
		}
		//otherwise return true
		return true;
		}

	@Override
	public void toHeap(int[] data) { //Algorithmus zum Aufbau eine Max-Heaps
		for (int i = data.length / 2; i > 0; i--) {
			buildHeap(data, i, data.length);
		}
	}

	//method to build Heap, as seen on the lecture notes
	private void buildHeap(int[]data, int i, int j){
		int k=i;
		int m=2*k;
		int x=data[i-1];

		while (m<=j){
			if (m<j && data[m-1]<data[m]){
				m=m+1;
			}
			if (x>=data[m-1]){
				break;
			}
			data[k-1]=data[m-1];
			k=m;
			m=2*k;
		}
		data[k-1]=x;

	}
	//swap method
	private void swap(int[]data, int i, int childIndex){
		int k=data[i];
		data[i]=data[childIndex];
		data[childIndex]=k;
	}

	@Override
	public void heapsort(int[] data) { //Heapsort-Algorithm
		//always be aware that array index starts with 0 but heap with 1
		for (int i = (data.length / 2) ; i > 0; i--) {
			buildHeap(data, i, data.length);
		}

			//sorting
			for (int i = data.length-1; i > 0; i--) {
				swap(data, i, 0);
				buildHeap(data, 1, i);
				//isHeap(0,i,data);
			}
		}


	@Override
	public ListNode insert(ListNode head, int value) {

		return null;
	}


	@Override
	public ListNode search(ListNode head, int value) {
		/*
		head - list to search through
		value - to value to search for
		return - first element with searched value
		 */


		//check as long as the pointer doesn't point to null, which means the end of the list
		while (head!=null) {
			//check if the value in the current element equals the value that is being searched for
			if (head.value == value) {
				return head;
				//if not, then move to next element
			} else {
				head=head.next;
			}
		}
		return null;
	}

	@Override
	public ListNode minimum(ListNode head) {
		// YOUR CODE HERE
		return null;
	}

	@Override
	public void mergesort(int[] data) {
	/*
	check if array is longer or equal to 2
	if no, it won't be necessary to sort it
	if yes, split length in half and store in new variable
	this will determine length of new arrays
	create new arrays for left and right
	it is possible that if the array length is uneven that one side is bigger
	that's why the left gets middle as length and the right length-middle
	 */
		if (data.length >= 2) {

			int middle = data.length / 2;
			int[] left = new int[middle];
			int[] right = new int[data.length - middle];

			/*
			this separates the array in left and right
			as long as you as possible the array will be divided - recursive call
			 */

			for (int i = 0; i < middle; i++) {
				left[i] = data[i];
			}
			for (int i = middle; i < data.length; i++) {
				right[i - middle] = data[i];
			}
			mergesort(left);
			mergesort(right);

			merge(data, left, right);
		}
		/*
		if the array length is less than 2,
		there is no sorting necessary
		and it will just return the array
		 */
		else return;
		}

	private void merge(int[] data, int[] left, int[] right){

		int indexL=0;
		int indexR=0;
		int indexFinal=0;

		/*
		as long as the both sides (arrays) are not empty
		check if the value in the left array is smaller or equal to the one in the right array
		if yes, store value of left array in data array
		if no, store value of right array in data array
		 */

		while (indexL<left.length && indexR<right.length){
			if(left[indexL]<=right[indexR]){
				data[indexFinal]=left[indexL];
				indexFinal++;
				indexL++;
			}
			else{
				data[indexFinal]=right[indexR];
				indexFinal++;
				indexR++;
			}
		}

		while (indexL<left.length){
			data[indexFinal]=left[indexL];
			indexFinal++;
			indexL++;
		}

		while (indexR<right.length){
			data[indexFinal]=right[indexR];
			indexFinal++;
			indexR++;
		}

	}
}
