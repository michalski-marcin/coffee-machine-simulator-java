import java.util.Scanner;

public class CoffeeMachine {

    private static int water = 400;
    private static int milk = 540;
    private static int coffeeBeans = 120;
    private static int cups = 9;
    private static int money = 550;

    private enum State {
        MAIN_MENU, BUY_MENU, FILL_WATER, FILL_MILK, FILL_BEANS, FILL_CUPS, EXIT
    }

    private static State currentState = State.MAIN_MENU;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Write action (buy, fill, take, remaining, exit):");

        while (true) {
            String input = scanner.nextLine();
            action(input);

            if (currentState == State.EXIT) {
                break;
            }

            if (currentState == State.MAIN_MENU) {
                System.out.println("Write action (buy, fill, take, remaining, exit):");
            }
        }

        scanner.close();
    }

    public static void action(String input) {
        switch (currentState) {
            case MAIN_MENU:
                handleMainMenu(input);
                break;
            case BUY_MENU:
                handleBuyMenu(input);
                break;
            case FILL_WATER:
                water += Integer.parseInt(input);
                currentState = State.FILL_MILK;
                System.out.println("Write how many ml of milk you want to add:");
                break;
            case FILL_MILK:
                milk += Integer.parseInt(input);
                currentState = State.FILL_BEANS;
                System.out.println("Write how many grams of coffee beans you want to add:");
                break;
            case FILL_BEANS:
                coffeeBeans += Integer.parseInt(input);
                currentState = State.FILL_CUPS;
                System.out.println("Write how many disposable cups you want to add:");
                break;
            case FILL_CUPS:
                cups += Integer.parseInt(input);
                currentState = State.MAIN_MENU;
                System.out.println("Resources updated!");
                break;
            case EXIT:
                break;
        }
    }

    private static void handleMainMenu(String input) {
        switch (input) {
            case "buy":
                currentState = State.BUY_MENU;
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                break;
            case "fill":
                currentState = State.FILL_WATER;
                System.out.println("Write how many ml of water you want to add:");
                break;
            case "take":
                System.out.println("I gave you $" + money);
                money = 0;
                break;
            case "remaining":
                printRemaining();
                break;
            case "exit":
                currentState = State.EXIT;
                break;
            default:
                System.out.println("Unknown action. Try again.");
                break;
        }
    }

    private static void handleBuyMenu(String input) {
        if (input.equals("back")) {
            currentState = State.MAIN_MENU;
            return;
        }

        int choice = Integer.parseInt(input);
        boolean enoughIngredients = true;

        switch (choice) {
            case 1: // espresso
                if (water < 250) {
                    enoughIngredients = false;
                    System.out.println("Sorry, not enough water!");
                }
                if (coffeeBeans < 16) {
                    enoughIngredients = false;
                    System.out.println("Sorry, not enough coffee beans!");
                }
                if (enoughIngredients) {
                    water -= 250;
                    coffeeBeans -= 16;
                    money += 4;
                    cups -= 1;
                    System.out.println("I have enough resources, making you an espresso!");
                }
                break;
            case 2: // latte
                if (water < 350) {
                    enoughIngredients = false;
                    System.out.println("Sorry, not enough water!");
                }
                if (milk < 75) {
                    enoughIngredients = false;
                    System.out.println("Sorry, not enough milk!");
                }
                if (coffeeBeans < 20) {
                    enoughIngredients = false;
                    System.out.println("Sorry, not enough coffee beans!");
                }
                if (enoughIngredients) {
                    water -= 350;
                    milk -= 75;
                    coffeeBeans -= 20;
                    money += 7;
                    cups -= 1;
                    System.out.println("I have enough resources, making you a latte!");
                }
                break;
            case 3: // cappuccino
                if (water < 200) {
                    enoughIngredients = false;
                    System.out.println("Sorry, not enough water!");
                }
                if (milk < 100) {
                    enoughIngredients = false;
                    System.out.println("Sorry, not enough milk!");
                }
                if (coffeeBeans < 12) {
                    enoughIngredients = false;
                    System.out.println("Sorry, not enough coffee beans!");
                }
                if (enoughIngredients) {
                    water -= 200;
                    milk -= 100;
                    coffeeBeans -= 12;
                    money += 6;
                    cups -= 1;
                    System.out.println("I have enough resources, making you a cappuccino!");
                }
                break;
            default:
                System.out.println("Unknown coffee selection.");
                break;
        }
        currentState = State.MAIN_MENU;
    }

    private static void printRemaining() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
    }
}
