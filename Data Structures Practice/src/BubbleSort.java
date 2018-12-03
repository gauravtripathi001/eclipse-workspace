
public class BubbleSort {

	
	public static void bs(int[] a) {
		int n=a.length;
		for(int k=0;k<n-2;k++) {
			for(int i=0;i<n-1;i++) {
			if(a[i]>a[i+1])
			{
				int temp=a[i];
				a[i]=a[i+1];
				a[i+1]=temp;
			}
			}
		}
	}

}
