
public class TestHeapSort {
	
	public void TestHeapSort(int arr[] , int n) {
		// TODO Auto-generated constructor stub
		for (int i = n-1; i>=0;i--) {
			heapRebuild(arr,i); //put the array in proper max heap order
		}
		int last=n-1;
		int[] temp = new int[n];
		for (int i=n;i>=0;i--) {
			swap(arr,0,last); // replace the largest int with the last element in the heap
			temp[i] = arr[last];
			arr[i]=0;
			heapRebuild(arr,i);
		}
		for(int j=0;j<=n-1;j++) {
			System.out.println(temp[j]);
		}
		
	}
		

	private void heapRebuild(int[] arr, int k) {//arrange array elements into proper heap order 
		int p = (k-1)/2;
		if (arr[p]<arr[k]);
			swap(arr,p,k);
		if (p>=1)
			heapRebuild(arr,k-1);
			
		
	}
		
	private void swap(int[] arr, int start, int end) { // swap two points in an array
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end]=temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[]= {10,9,6,3,2,5};
		TestHeapSort trial = new TestHeapSort();
		trial.TestHeapSort(array,5);
		
	}

}
