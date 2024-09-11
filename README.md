
# Coffee Machine

## Overview

This is a simple Java program that simulates the operations of a coffee machine. It tracks resources like water, milk, coffee beans, and disposable cups, and allows users to perform various actions like buying coffee, refilling resources, and collecting money.

## Features

- **Buy Coffee**: You can choose from three types of coffee—Espresso, Latte, and Cappuccino.
- **Fill Resources**: Refill the coffee machine with water, milk, coffee beans, and cups.
- **Take Money**: Collect all the money earned from coffee sales.
- **Check Remaining Resources**: Display the current resource levels (water, milk, coffee beans, cups, and money).
- **Exit**: Quit the program.

## Usage

### Main Menu Actions

After starting the program, you'll be prompted with the following options:

- `buy`: Buy a coffee.
- `fill`: Refill the machine's resources.
- `take`: Collect all the money earned.
- `remaining`: Show the remaining resources.
- `exit`: Exit the program.

### Buying Coffee

When selecting the `buy` option, you can choose from the following coffee types:

1. **Espresso**: Requires 250 ml of water, 16 g of coffee beans, and 1 disposable cup.
2. **Latte**: Requires 350 ml of water, 75 ml of milk, 20 g of coffee beans, and 1 disposable cup.
3. **Cappuccino**: Requires 200 ml of water, 100 ml of milk, 12 g of coffee beans, and 1 disposable cup.

The program checks whether the machine has enough resources to make the selected coffee. If there are insufficient resources, a message will be displayed, and the machine will not make the coffee.

### Filling Resources

When selecting the `fill` option, you'll be prompted to input the amount of water, milk, coffee beans, and cups you want to add to the machine.

### Taking Money

When selecting the `take` option, all the money earned by selling coffee will be collected, and the balance will reset to $0.

### Checking Remaining Resources

When selecting the `remaining` option, the current levels of water, milk, coffee beans, cups, and money will be displayed.

### Exiting

Selecting the `exit` option will terminate the program.

## Example

```
Write action (buy, fill, take, remaining, exit):
> buy
What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:
> 1
I have enough resources, making you an espresso!
Write action (buy, fill, take, remaining, exit):
> remaining
The coffee machine has:
150 ml of water
540 ml of milk
104 g of coffee beans
8 disposable cups
$554 of money
Write action (buy, fill, take, remaining, exit):
```

## Installation

To run this program:

1. Install [Java](https://www.java.com/en/download/).
2. Save the program code to a file named `CoffeeMachine.java`.
3. Compile and run the program using the following commands:

```bash
javac CoffeeMachine.java
java CoffeeMachine
```


