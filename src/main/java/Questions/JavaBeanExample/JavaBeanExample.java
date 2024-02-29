package Questions.JavaBeanExample;

import java.io.Serializable;

// Expected Output Value: 50
public class JavaBeanExample implements Serializable {
    private String name;
    private int age;

    public JavaBeanExample() {
    }

    public JavaBeanExample(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name.toUpperCase();
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        JavaBeanExample bean = new JavaBeanExample();
        System.out.println("Name: " + bean.getName() + ", Age: " + bean.getAge());
    }
}
