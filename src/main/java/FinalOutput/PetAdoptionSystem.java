package FinalOutput;

import lombok.ToString;

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
        do{
            System.out.println("1. View Pets\n" +
                    "2. Adopt Pet\n" +
                    "3. Add pet\n" +
                    "4. Remove Pet\n" +
                    "5. Exit");

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
        System.out.println("Enter your name: ");
        String adopterName = input.nextLine();
        selectedPet.adopt();
        System.out.println("Congratulations " + adopterName + "! You adopted " + selectedPet.getName() + "!");
    }

    private void addPet(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of your pet: ");
        String petName = input.nextLine();
        System.out.println("Type (Ex. Dog, Cat, Bird, etc.): ");
        String petType = input.nextLine();
        System.out.println("Age: ");
        byte petAge = input.nextByte();

        pets.add(new Pet(petName, petType, petAge));

    }

    private void removePet() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Pet ID to remove: ");
        int petId = input.nextInt();

        Pet getPet = null;


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

