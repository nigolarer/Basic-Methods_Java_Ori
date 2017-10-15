
public class DuplicationInArray_Failed2 {
    public static void doFunc(int[] a){
        int i = 0;
        int temp;
        //for(int i = 0;i<a.length;i++) {
          while (i<a.length){
             // System.out.println("i = "+i+" a[i] = "+a[i]+" a[a[i]] = "+a[a[i]]);
            //if (a[i] != i && a[a[i]] != a[i]) {
              if (a[i]!=i&&a[a[i]] != a[i]){
                      temp = a[a[i]] ;
                      a[a[i]] = a[i];
                      a[i] = temp;
            }
            else if(a[a[i]] == a[i]&&a[i]!=i){
                 // System.out.println(a[i]);

                System.out.println(""+a[i++]+" is duplicated");
            }
            else{
                i++;
                  //System.out.println(i++);
              }
          /*  for (int in : a) {
                  System.out.print(in);
              }*/
            //  System.out.println("");
        }
        for(int in:a){
            System.out.print(in);
          }
     }
    public static void main(String[] args) {
        int[] a = {0,1,2,3,4,5};
        //System.out.println(""+a[0]);
        if (doInspect(a)) {
            doFunc(a);
        }

    }

    private static boolean doInspect(int[] a) {
        for (int in : a) {
            if (in>=a.length){
                System.out.println("illegal num");
                return false;
            }
        }
        return true;
    }
}
