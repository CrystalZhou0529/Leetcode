package com.test.leetcode;

// solution 1 DP
// P[i,j] = true, if P[i+1, j-1]==1 && s[i]==s[j]
// p[i,i] = true
// p[i,i+1] = true, if s[i]==s[i+1]

class solution1 {
	public String longestPalindrome(String s) {
		char ch[] = s.toCharArray();
	    boolean[][] p = new boolean[s.length()][s.length()];
	    int start = -1; int endd = 0;
	    for (int gap = 1; gap<=s.length(); gap+=1) {
	        for (int i=0; i<=s.length()-gap; i++){
	            int j = i+gap-1;
	            if (i==j) {
	                p[i][i] = true;
	                start = i; endd = j;
	            } else if ( (ch[i]==ch[j]) && (j-i==1)) {
	                p[i][j] = true;
	                start = i; endd = j;
	            } else if ( (ch[i]==ch[j]) && (p[i+1][j-1]==true) ) {
	                p[i][j] = true;
	                start = i; endd = j;
	            }
	        }
	    }
	    if (start==-1) {
	        return "";
	    } else {
	        return s.substring(start, endd+1);
	    }
	}
}

 //solution2: dfs, time complexity O(n^2)
class solution2 {
    public int expansion (String s, int start, int endd) {
        while (start>=0 && endd<s.length() && s.charAt(start)==s.charAt(endd)) {
            start -= 1;
            endd += 1;
        }
        return endd-start-1;
    }
    public String longestPalindrome(String s) {
        if (s.length()==0) return "";
        int start=0, endd=0, maxlen=-1;
        for (int i=0; i<s.length()-1; i++) {
            int l1 = expansion(s,i,i);
            int l2 = expansion(s,i,i+1);
            int l = Math.max(l1, l2);
            if (l>maxlen) {
                maxlen = l;
                if (l%2==0) {
                    start = i - l/2 + 1;
                    endd = i + l/2;
                } else {
                    start = i - l/2;
                    endd = i + l/2;
                }
            }
        }
        return s.substring(start, endd+1);
        
    }
}

//solution 3: Manacher's algorithm
// If (i < Right) --> length = min(Right-i, mirror)
// Expansion; L[i]: the time of expansion
// If (i + L[i] > Right) --> center = i; Right = i+l[i]
// Not finished yet

class solution3 {
	public int expansion (String s, int start, int endd) {
		int time=0;
        while (start>=0 && endd<s.length() && s.charAt(start)==s.charAt(endd)) {
            start -= 1;
            endd += 1;
            time += 1;
        }
        return time-1;
    }
	
	char[] addSplit(char[] ch_short) {
		char ch_long[] = new char[ch_short.length*2-1];
		for(int i=0; i<ch_short.length; i++) {
			ch_long[i*2] = ch_short[i];
			if (i!=ch_short.length-1) {
				ch_long[i*2+1] = '/';
			}
		}
		return ch_long;
	}
	
	public String longestPalindrome(String s) {
		char[] ch_short = s.toCharArray();
		char[] ch_long = addSplit(ch_short);
		int start=0, endd=s.length();
		int tot_len=ch_long.length, lef=0, rig=0, mid=0;
		int[] l = new int[tot_len];
		int len=0, max_len=0;
		for (int i=0; i<tot_len; i++) {
			if (i<=rig) {
				len=Math.min(rig-i, l[mid*2-i]);
				l[i]=expansion(s,i-len,i+len);
			} else {
				len=l[mid*2-i];
				l[i]=expansion(s,i-len,i+len);
				
			}
			
		}
		return s.substring(start, endd);
	}
}