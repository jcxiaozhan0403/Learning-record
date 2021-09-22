package pojo;

public class Hello {
    private String talk;

    public String getTalk() {
        return talk;
    }

    public void setTalk(String talk) {
        this.talk = talk;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "talk='" + talk + '\'' +
                '}';
    }
}
