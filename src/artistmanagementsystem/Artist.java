
package artistmanagementsystem;

public class Artist {
    
    private int id;
    private String name;
    private int age;
    private String lastName;

    public Artist(int id, String name, int age, String lastName) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.lastName = lastName;
    }

    Artist() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Artist{" + "id=" + id + ", name=" + name + ", age=" + age + ", lastName=" + lastName + '}';
    }
    
    
}
