package lp;

import java.util.List;
import java.util.ArrayList;

public class GetSubSets {
	public static List<boolean[]> getSubSets(int j, int k, int n, boolean[] p) {
		boolean[] b = new boolean[n];
		List<boolean[]> subset = new ArrayList<boolean[]>();
		if (k == 0) {
			for (int i = 0; i < b.length; i++)
				b[i] = false;
			subset.add(b);
		} else {
			int op = 0;
			for (int i = j; i < p.length; i++)
				if (p[i])
					op++;
			if (op == k) {
				for (int i = 0; i < b.length; i++)
					if (p[i])
						b[i] = true;
				subset.add(b);
			} else {
				if (p[j]) {
					List<boolean[]> s1 = getSubSets(j + 1, k - 1, n, p);
					for (int i = 0; i < s1.size(); i++) {
						b = s1.get(i);
						b[j] = true;
						subset.add(b);
					}
				}
				List<boolean[]> s0 = getSubSets(j + 1, k, n, p);
				for (int i = 0; i < s0.size(); i++) {
					b = s0.get(i);
					b[j] = false;
					subset.add(b);
				}
			}
		}
		return subset;
	}

	public static void showSubSet(List<boolean[]> s) {
		int n = s.get(0).length;
		boolean[] b = new boolean[n];
		for (int i = 0; i < s.size(); i++) {
			b = s.get(i);
			System.out.print("{");
			for (int j = 0; j < n; j++)
				if (b[j])
					System.out.print(" " + 1);
				else
					System.out.print(" " + 0);
			System.out.println(" }");
		}
	}
}

	// Experimentar com:
		// int support_size = 2;
		// int total_actions = 8;
		// int dominated_actions = 0;
		// System.out.println("******** " + support_size + "/" + "(" + total_actions + "-" + dominated_actions + ") ********");
		// List<boolean[]> s1=getSubSets(0,support_size,total_actions, new boolean[] {true,true,true,true,true,true,true,true});
		// showSubSet(s1);
		// dominated_actions = 3;
		// System.out.println("******** " + support_size + "/" + "(" + total_actions + "-" + dominated_actions + ") ********");
		// s1=getSubSets(0,support_size,total_actions, new boolean[] {true,true,true,true,true,false,false,false});
		// showSubSet(s1);
		// support_size = 3;
		// total_actions = 5;
		// dominated_actions = 1;
		// System.out.println("******** " + support_size + "/" + "(" + total_actions + "-" + dominated_actions + ") ********");
		// s1=getSubSets(0,support_size,total_actions, new boolean[] {false,true,true,true,true});
		// showSubSet(s1);
