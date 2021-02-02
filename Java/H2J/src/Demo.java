public class Demo{
    public static void main(String[] args) {
        int a[] = {8,4,2,5};

        for(int i =0;i<a.length-1 ; i++){
            for (int j = i+1; j<a.length;j++){
                if(a[i] > a[j]){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        for (int x = 0;x<a.length;x++){
            System.out.println(a[x]);
        }
    }
}