package groovyConfiguretion195;

/**
 * Created by AOleynikov on 06.09.2018.
 */
public class Contact {
    private String firstName;
    private String lastName;
    private int age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("First name: %s, Last name: %s, Age: ", this.firstName, this.lastName, this.age);
    }
}
