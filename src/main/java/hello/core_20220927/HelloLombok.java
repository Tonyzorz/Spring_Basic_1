package hello.core_20220927;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("aasdf");

        String name = helloLombok.getName();
        System.out.println("name = " + name);
    }
}
