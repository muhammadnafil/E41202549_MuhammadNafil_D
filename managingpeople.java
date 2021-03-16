/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managingpeople;

/**
 *
 * @author Galuh
 */class Person{
    public String name;
    public int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public int getAge() {
        return this.age;
    }
    public String getName(){
        return this.name;
    }
}
public class managingpeople {
    public static void main(String[] args) {
        Person p1 = new Person("Galuh", 37);
        Person p2 = new Person("Ika", 15);

        if (p1.getAge()==p2.getAge()) {
            System.out.println(p1.getName() + " is the same age as " + p2.getName());
        } else {

            System.out.println(p1.getName() + " is NOT the same age as " + p2.getName());
        }

    }
}