
public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int[] A= {1,5,2,3,6};
BS(A);
for(int i=0;i<A.length;i++)
System.out.println(A[i]);
	}
	public static void BS(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;
 
            // Swap the found minimum element with the first
            // element
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }
	}
	
}
