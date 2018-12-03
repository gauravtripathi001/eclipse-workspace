
public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	int[] a= {2,4,1,7,3};
	is(a);
	for(int i=0;i<a.length;i++) {
		System.out.println(a[i]);
	}
	}
	public static void is(int[] a) {
		for(int i=0;i<a.length;i++) {
			int hole=i;
			int value=a[hole];
			while(hole>0 && a[hole-1]>value) {
				a[hole]=a[hole-1];
				hole=hole-1;
			}
			a[hole]=value;
			}
	}

}
