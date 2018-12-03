
public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A= {1,2,4,3,2,5,6,9};
		QS(A,0,A.length-1);
		for(int i=0;i<A.length;i++) {
			System.out.println(A[i]);
		}
	}
public static void QS(int[] A,int start, int end) {
	if(start<end) {
		int pIndex=partition(A,start,end);
		QS(A,start,pIndex-1);
		QS(A,pIndex+1,end);
	}
}
public static int partition(int[] A,int start,int end) {
	int pIndex=start;
	int pivot=end;
	for(int i=start;i<end;i++) {
		if(A[i]<A[pivot]) {
			int x=A[i];
			A[i]=A[pIndex];
			A[pIndex]=x;
			pIndex++;
		}
	}
	int x=A[pivot];
	A[pivot]=A[pIndex];
	A[pIndex]=x;
	
	return pIndex;
}
}
