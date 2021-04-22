package ab1.impl.Nachnamen;

import ab1.Ab1;

public class Ab1Impl implements Ab1 {

	@Override
	public boolean isHeap(int i, int j, int[] data) {
		// YOUR CODE HERE
		return false;
	}

	@Override
	public void toHeap(int[] data) {
		// YOUR CODE HERE
	}

	@Override
	public void heapsort(int[] data) {
		// YOUR CODE HERE
	}

	@Override
	public ListNode insert(ListNode head, int value) {
		// YOUR CODE HERE
		return null;
	}

	@Override
	public ListNode search(ListNode head, int value) {
		// YOUR CODE HERE
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
		}

	}
}
