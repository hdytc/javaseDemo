package string;

public class KMP {
    int[] next;
    char[] srcChars;
    char[] dstChars;
    public KMP(String src,String dst) {
        initNext(dst);
        //System.out.println(Arrays.toString(next));
        srcChars = src.toCharArray();
        dstChars = dst.toCharArray();
    }

    private void initNext(String dst) {
        next = new int[dst.length()];
        for(int i=1;i<=dst.length()-1;i++) {
            String substr = dst.substring(0,i);
            for(int j=substr.length()-1;j>=1;j--) {
                String first = substr.substring(0,j);
                String last = substr.substring(substr.length()-j,substr.length());
                if (first.equals(last)) {
                    next[i] = j;
                }
            }
        }
    }
    public int getIndex() {
        int i=0,j=0;
        while (i <= srcChars.length - 1) {
            if (srcChars[i + j] == dstChars[j]) {
                j++;
            } else {
                i += j + 1 -next[j];
                j = next[j];
            }
            if (j == dstChars.length) {
                return i;
            }
        }
        return -1;
    }
}


