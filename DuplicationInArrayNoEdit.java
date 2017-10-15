public class DuplicationInArrayNoEdit {
    static int doCount(int[] a, int low, int high){
        int count = 0;
        for(int i = 0;i<a.length;i++) {
            if(a[i]>=low &&a[i]<=high)
                count++;
        }
        return count;
    }
    static int doFunc(int[] a){
        int low = 0;
        int high = a.length-1;
        int count = 0;
        while (low <= high) {
          count = doCount(a, low, high);
            if (high == low) {
                if (count > 1) {
                    return high;
                } else {
                    break;
                }
            }
            if (count > ((low + high))/ 2 - low + 1) {
                high = (low + high) / 2;
            }else {
                low = (low + high) / 2 + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[]a = {1,2,2,3,3,3,1,4,};
        int count = doFunc(a);
        System.out.println(count);
    }
}
