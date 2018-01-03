package anton.logvinenko.sorting.lulz;

import anton.logvinenko.sorting.SortAlgorithm;

public class BubbleSortShort extends SortAlgorithm {
	public void sort(int[]a){int d=0;while(d==0){d=1;int i,c;for(i=0;i<a.length-1;i++){if(a[i]>a[i+1]){c=a[i];a[i]=a[i+1];a[i+1]=c;d=0;}}}}
}

