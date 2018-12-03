
public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A= {1,4,2,3,5,6};
		MS(A);
		for(int i=0;i<A.length;i++)
			System.out.println(A[i]);
	}

	public static void MS(int[] A) {
		int n=A.length;
		if(n<2) {
			return;
		}
		int nL=n/2, nR=n-nL;
		int[] L=new int[nL];
		int[] R=new int[nR];
		
		for(int i=0;i<nL;i++) {
			L[i]=A[i];
		}
		for(int i=nL;i<n;i++) {
			R[i-nL]=A[i];
		}
		
		MS(L);
		MS(R);
		Merge(A,L,R);
	}
	public static int[] Merge(int[] A,int[] L,int[] R) {
		int i=0,j=0,k=0;
		int n=A.length,nL=L.length, nR=R.length;
		while(i<nL && j<nR) {
			if(L[i]<=R[j]) {
				A[k]=L[i];
				i++;
			}
			else {
				A[k]=R[j];
				j++;
			}
			k++;
		}
		while(i<nL) {
			A[k]=L[i];
			i++;
			k++;
		}
		while(j<nR) {
			A[k]=R[j];
			j++;
			k++;
		}
		return A;
	}
}
