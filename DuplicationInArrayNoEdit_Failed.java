public class DuplicationInArrayNoEdit_Failed {
    public static void main(String[] args) {
        int[] a = {2, 1, 2, 2, 3, 3, 5};
        if (doValid(a)) {
            int s = doFunc(a, 0, a.length);
        }
    }

    private static int doFunc(int[] a,int low,int high) {
        int count = 0;
        if (low < high) {
            for(int i = 0;i<a.length;i++) {
                if (a[i]<=high&&a[i]>=low) {
                    count++;
                }
            }
            if (count > high - low) {
               int num1 =  doFunc(a, low, high / 2);
               int num2 = doFunc(a, high / 2, high);

            }
        }
    return 0;
    }

    private static boolean doValid(int[] a) {
        return true;
    }

}
