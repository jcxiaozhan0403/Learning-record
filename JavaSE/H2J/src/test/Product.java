package test;

/**
 * @author John.Cena
 * @date 2023/3/17 18:03
 * @Description:
 */
public class Product {
    /**
     * 快餐 A 默认为汉堡
     */
    private String BuildA = "汉堡";
    /**
     * 快餐 B 默认为可乐
     */
    private String BuildB = "可乐";
    /**
     * 快餐 C 默认为薯条
     */
    private String BuildC = "薯条";
    /**
     * 快餐 D 默认为甜点
     */
    private String BuildD = "甜点";

    public String getBuildA() {
        return BuildA;
    }
    public void setBuildA(String buildA) {
        BuildA = buildA;
    }
    public String getBuildB() {
        return BuildB;
    }
    public void setBuildB(String buildB) {
        BuildB = buildB;
    }
    public String getBuildC() {
        return BuildC;
    }
    public void setBuildC(String buildC) {
        BuildC = buildC;
    }
    public String getBuildD() {
        return BuildD;
    }
    public void setBuildD(String buildD) {
        BuildD = buildD;
    }
    @Override
    public String toString() {
        return "Product{" +
                "BuildA='" + BuildA + '\'' +
                ", BuildB='" + BuildB + '\'' +
                ", BuildC='" + BuildC + '\'' +
                ", BuildD='" + BuildD + '\'' +
                '}';
    }
}
