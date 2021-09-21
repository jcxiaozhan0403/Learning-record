public class MyInterfaceImpl implements MyInterface<String>{
    @Override
    public String server(String s) {
        System.out.println(s);
        return s;
    }
}
