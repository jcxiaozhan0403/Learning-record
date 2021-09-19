public class Test {
    public static void main(String[] args) {
        //arraycopy 复制
        //src-原数组 srcPos-从哪个位置开始复制0 dest-目标数组 destPos-目标数组的位置 length-复制的长度
        int[] arr = {20, 18, 39, 3};
        int[] dest = new int [4];
        //System.arraycopy(src, srcPos, dest, destPos, length);
        System.arraycopy(arr, 0, dest, 0, 4);
        for (int i : dest) {
            System.out.println(i);
        }
        // 返回当前系统时间(毫秒)
        System.currentTimeMillis();

        // Arrays.copyOf(original, newLength)
    }
}
