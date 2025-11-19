package FinalOutput;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Pet {
    private int id;
    private String name;
    private String type;
    private int age;
    private boolean adopted;
    private static int idCounter;
    public Pet(String name,String type, int age){
        this.id = idCounter++;
        this.name = name;
        this.type = type;
        this.age = age;
        this.adopted = false;
    }

    public void adopt(){
        this.adopted = true;
    }
    @Override
    public String toString(){
        return id + " - " + name + " (" + type + ", Age: " + age + ")"
                + (adopted ? " [ADOPTED]" : "");
    }
}
