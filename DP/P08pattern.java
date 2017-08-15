class P08pattern{
    public static void  main(String[] args) {
        String str1 = "caaa*b";
        String str2 = "caaaaab";
        if (check(str1)) {
            System.out.println(process(str2.toCharArray(), str1.toCharArray(), 0, 0));
        }else {
            System.out.println(false);
        }
    }
    public static boolean check(String exp){
        if (exp == null || exp.length() == 0) {
            return false;
        }
        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == '*'){
                if (i == 0 || exp.charAt(i - 1) == '*') {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean process(char[] s, char[] p, int si, int pi){
        if (pi == p.length) {
            return si == s.length;
        }
        if ((pi + 1 == p.length) || (p[pi+ 1] != '*')) {
            return si != s.length && (s[si] == p[pi] || p[pi] == '.') && process(s, p, si + 1, pi + 1);
        }
        while (si < s.length && (s[si] == p[pi] || p[pi] == '.')) {
            if (process(s, p, si, pi + 2)) {
                return true;
            }
            si++;
        }
        return process(s, p, si, pi + 2);
    }	
}