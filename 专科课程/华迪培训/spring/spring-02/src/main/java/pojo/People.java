package pojo;

import org.springframework.beans.factory.annotation.Autowired;

public class People {

    /**注意：配置文件中的bean标签的id值要与实体类的属性名一致**/

    private String name;
    @Autowired
    private Dog dog;
    @Autowired
    private Cat cat;

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", dog=" + dog +
                ", cat=" + cat +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName001(String name) {//name
        this.name = name;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

/*    public void setCat(Cat cat) {
        this.cat = cat;
    }*/
}
