package FinalOutput;



import java.util.ArrayList;
import java.util.Scanner;


public class PetAdoptionSystem {

    ArrayList<Pet> pets = new ArrayList<>();

    public void seedPets(){
        pets.add(new Pet("Browny", "Cat", 10));
        pets.add(new Pet( "Max", "Dog", 3));
        pets.add(new Pet("Mittens", "Cat", 1));
        pets.add(new Pet("Buddy", "Dog", 2));
        pets.add(new Pet("Chirpy", "Bird", 1));
        pets.add(new Pet("Snow", "Rabbit", 4));
        pets.add(new Pet("Goldie", "Fish", 1));
        pets.add(new Pet("Shadow", "Dog", 5));
        pets.add(new Pet("Luna", "Cat", 2));
        pets.add(new Pet("Rocky", "Dog", 6));
    }

    public void menu(){
        Scanner input = new Scanner(System.in);
        boolean validInput = true;
        System.out.println("""
██████  ███████ ████████     ██████   █████  ██████  ████████ 
██   ██ ██         ██        ██   ██ ██   ██ ██   ██    ██    
██████  █████      ██        ██   ██ ███████ ██████     ██    
██      ██         ██        ██   ██ ██   ██ ██         ██    
██      ███████    ██        ██████  ██   ██ ██         ██    
                                                              
                PET ADOPTION SYSTEM
""");

        do{
            System.out.print("""
                    1. View Pets
                    2. Adopt Pet
                    3. Add pet
                    4. Remove Pet
                    5. Exit
                    
                    Choice: """);

            byte userInput = input.nextByte();

            switch (userInput){
                case 1: displayPets();
                    break;

                case 2: adoptPet();
                    break;

                case 3: addPet();
                    break;

                case 4:
                    removePet();
                    break;
                case 5:
                    validInput = false;
                    break;
                default:
                    System.out.println("Please enter a valid choice.");
                    break;
            }


        }while (validInput);

    }

    private void displayPets(){

        for(Pet pet: pets){
            System.out.println(pet.toString());
        }
        System.out.println();
    }

    private void adoptPet(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Pet ID to adopt: ");
        byte id = input.nextByte();

        Pet selectedPet = null;

        for(Pet pet : pets){
            if(pet.getId() == id){
                selectedPet = pet;
                break;
            }
        }
        if(selectedPet == null){
            System.out.println("Pet not found!");
            return;
        }
        if(selectedPet.isAdopted()){
            System.out.println("Sorry, this pet has already been adopted!");
            return;
        }
        input.nextLine();
        System.out.print("Enter your name: ");
        String adopterName = input.nextLine();
        selectedPet.adopt();
        System.out.println("Congratulations " + adopterName + "! You adopted " + selectedPet.getName() + "!");
    }

    private void addPet(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the name of your pet: ");
        String petName = input.nextLine();
        String formattedPetName = petName.substring(0,1).toUpperCase() + petName.substring(1);
        System.out.print("Type (Ex. Dog, Cat, Bird, etc.): ");
        String petType = input.nextLine();
        String formattedPetType = petType.substring(0,1).toUpperCase() + petType.substring(1);

        System.out.print("Age: ");
        byte petAge = input.nextByte();

        pets.add(new Pet(formattedPetName, formattedPetType, petAge));

    }

    private void removePet() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Pet ID to remove [press 5 to return]: ");
        int petId = input.nextInt();

        Pet getPet = null;

        if(petId == 5){
            menu();
        }else {
            for (Pet p : pets) {
                if (p.getId() == petId) {
                    getPet = p;
                    break;
                }
            }

            if (getPet != null) {
                System.out.println("You successfully removed " + getPet.getName() + "!");
                pets.remove(getPet);
            } else {
                System.out.println("Pet ID not found!");
            }
        }

    }


}

