package anton.logvinenko.sorting.lulz;

import anton.logvinenko.sorting.SortAlgorithm;

public class QuickSortShort extends SortAlgorithm {

	public void sort(int[] a) {
		int t = 0, g = a.length, h, c, x, p, l, i;
		int[] s = new int[g];
		s[t] = g - 1;
		while (t > -1) {
			h = s[t--];
			l = t == -1 ? 0 : s[t];
			p = l;
			x = a[h];
			for(i=l;i<=h;i++)
				if (a[i] <= x) {
					c = a[p];
					a[p++] = a[i];
					a[i] = c;
				}
			if (l < p - 2) s[++t] = p - 2;
			if (p < h) s[++t] = h;
		}
	}
}
