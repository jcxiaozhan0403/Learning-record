/**
 * @author John.Cena
 * @date 2023/3/5 20:27
 * @Description:
 */
public class Test {
    public static void main(String[] args) {

    }

    long long* Fibonacci(size_t n){
        if (n ==0){
            return NUll;
        }
        long long* fibArray = (long long*)malloc((n+1)*sizeof(long long));
        fibArray[0] = 0;
        fibArray[1] = 1;
        for (int i = 2; i <= n; ++i) {
            fibArray[i] = fibArray[i-1] + fibArray[i-2];
        }
        return fibArray;
    }
}
