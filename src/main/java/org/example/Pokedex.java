package org.example;

/* Program Description: a mini pokedex */




import java.util.Scanner;
public class Pokedex {

    public static void printOptions () {
        System.out.println(" POKEDEX ver 1.0 \n \n1. Add Pokemon \n2. Delete Pokemon\n3. View Stored Pokemon\n4. Edit Pokemon\n5. Battle  \n6. Exit \n");
    }





    public static void main (String args[]){

        /* Declarations */


        Scanner sc = new Scanner(System.in);
        Pokemon Pokedex[] = new Pokemon[100];
        int ans = 0;
        int numOfEntries = 0;
        String Name;
        int Health;
        int Damage;
        String NameToDelete;
        String NameToUpdate;
        int i = 0;
        String PokemonA;
        String PokemonB;
        int a = 0;
        int b = 0;




        do {
            printOptions();										// Calls printOptions method
            ans = Integer.parseInt (sc.nextLine());



            if (ans == 1) {										// Add Pokemon
                for (i=0; i < Pokedex.length; i++) {
                    if (Pokedex[i] == null) {
                        System.out.println("Pokemon Name: ");
                        Name  = sc.nextLine();
                        System.out.println("Pokemon Health: ");
                        Health = Integer.parseInt(sc.nextLine());
                        System.out.println("Pokemon Damage: ");
                        Damage = Integer.parseInt(sc.nextLine());
                        Pokedex[i] = new Pokemon (Name, Health, Damage) ;
                        break;
                    }
                }
            }



            else if (ans == 2) {											// Delete Pokemon
                System.out.println("Delete Pokemon: ");
                NameToDelete = sc.nextLine();
                for (i=0; i < Pokedex.length; i++) {
                    if (Pokedex[i] != null) {
                        if (Pokedex[i].getName().equals(NameToDelete)){
                            Pokedex[i] = null;
                            numOfEntries --;
                        }
                    }
                }
            }





            else if (ans == 3) {												// View stored Pokemon
                for (i=0; i<100; i++) {
                    if (Pokedex[i] !=null) {
                        System.out.println(Pokedex[i].getName() + "\n" + Pokedex[i].getHealth() + "\n" + Pokedex[i].getHealth() + "\n");
                    }
                }
            }



            else if (ans ==4) {													// Edit existing Pokemon
                System.out.println("Edit Pokemon: ");
                NameToUpdate = sc.nextLine();
                for (i=0; i < Pokedex.length; i++) {
                    if (Pokedex[i] !=null) {
                        if (Pokedex[i].getName().equals(NameToUpdate))
                        {
                            System.out.println("New Name: ");
                            Name = sc.nextLine();
                            System.out.println("New Health: ");
                            Health = Integer.parseInt(sc.nextLine());
                            System.out.println("New Damage: ");
                            Damage = Integer.parseInt(sc.nextLine());
                            Pokedex[i].setName(Name);
                            Pokedex[i].setHealth(Health);
                            Pokedex[i].setDamage(Damage);

                        }
                    }
                }
            }



            else if (ans ==5 ){ 													// Battle


                System.out.println("1st Pokemon to battle: ");
                PokemonA = sc.nextLine();
                System.out.println("2nd Pokemon to battle: ");
                PokemonB = sc.nextLine();



                for (i=0; i < Pokedex.length; i++) {
                    if (Pokedex[i] !=null) {
                        if (Pokedex[i].getName().equals(PokemonA))
                        {
                            a = i;


                        }


                        else if (Pokedex[i].getName().equals(PokemonB))
                        {
                            b = i;

                        }
                    }
                }

                Pokedex[a].attack(Pokedex[b]);
                Pokedex[b].attack(Pokedex[a]);







            }
        } while (ans != 6);
    }

}
