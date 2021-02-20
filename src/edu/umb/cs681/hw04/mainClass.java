package edu.umb.cs681.hw04;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class mainClass {

	public static void main(String[] args) {

		// initiate the dataset
		GroceryStore apple = new GroceryStore("Apple", "Fruit", 1.99F, 12, false,
				LocalDateTime.of(LocalDate.of(2021, 3, 15), LocalTime.of(12, 00, 00)));
		GroceryStore lettuce = new GroceryStore("Lettuce", "Vegetables", 3.99F, 14, true,
				LocalDateTime.of(LocalDate.of(2021, 3, 15), LocalTime.of(12, 00, 00)));
		GroceryStore beets = new GroceryStore("Beets", "Vetgetables", 1.99F, 100, true,
				LocalDateTime.of(LocalDate.of(2021, 3, 15), LocalTime.of(2, 00, 00)));
		GroceryStore nappa = new GroceryStore("Nappa Cabbage", "Vegetables", 4.49F, 87, true,
				LocalDateTime.of(LocalDate.of(2021, 3, 15), LocalTime.of(12, 00, 00)));
		GroceryStore pear = new GroceryStore("Pear", "Fruit", 1.49F, 12, false,
				LocalDateTime.of(LocalDate.of(2021, 1, 15), LocalTime.of(12, 00, 00)));
		GroceryStore pineapple = new GroceryStore("Pineapple", "Fruit", 2.99F, 12, true,
				LocalDateTime.of(LocalDate.of(2021, 5, 15), LocalTime.of(12, 00, 00)));
		GroceryStore chicken = new GroceryStore("Chicken Thigh", "Meat", 4.49F, 11, true,
				LocalDateTime.of(LocalDate.of(2021, 3, 15), LocalTime.of(12, 00, 00)));
		GroceryStore mango = new GroceryStore("Mango", "Fruit", 3.99F, 12, false,
				LocalDateTime.of(LocalDate.of(2021, 4, 15), LocalTime.of(12, 00, 00)));
		GroceryStore tomatoes = new GroceryStore("Tomatoes", "Vegetables", 1.49F, 52, true,
				LocalDateTime.of(LocalDate.of(2021, 2, 15), LocalTime.of(12, 00, 00)));
		GroceryStore strawberry = new GroceryStore("Strawberry", "Fruit", 5.99F, 12, true,
				LocalDateTime.of(LocalDate.of(2021, 3, 15), LocalTime.of(12, 00, 00)));
		GroceryStore cucumber = new GroceryStore("Cucumber", "Vegetables", 1.10F, 87, false,
				LocalDateTime.of(LocalDate.of(2021, 3, 15), LocalTime.of(12, 00, 00)));
		GroceryStore pepper = new GroceryStore("Red pepper", "Vegetables", 2.49F, 87, true,
				LocalDateTime.of(LocalDate.of(2021, 5, 15), LocalTime.of(12, 00, 00)));
		GroceryStore beef = new GroceryStore("Steak", "Meat", 11.49F, 100, true,
				LocalDateTime.of(LocalDate.of(2021, 1, 15), LocalTime.of(12, 00, 00)));
		GroceryStore pork = new GroceryStore("Pork Spare Rib", "Meat", 5.49F, 200, true,
				LocalDateTime.of(LocalDate.of(2021, 3, 15), LocalTime.of(12, 00, 00)));

		// Grocery list of item
		ArrayList<GroceryStore> grocery = new ArrayList<>();
		grocery.add(apple);
		grocery.add(strawberry);
		grocery.add(lettuce);
		grocery.add(beets);
		grocery.add(nappa);
		grocery.add(pear);
		grocery.add(pineapple);
		grocery.add(chicken);
		grocery.add(mango);
		grocery.add(tomatoes);
		grocery.add(cucumber);
		grocery.add(pepper);
		grocery.add(beef);
		grocery.add(pork);

		////////////////// Now we can use Stream API to filter out Meat, Vegetables,
		////////////////// Fruits.
		// Which one item in the grocery list is expired?
		// Is quality checked for each particular item ?
		// Find max, min, count number of item in the list

		// print all item list out
		System.out.println("********************************List of all items********************************");
		printTitle();
		grocery.stream().forEach((GroceryStore gs) -> System.out.println(gs.toString()));
		System.out.println("\n");

		System.out.println();
		System.out.println(
				"********************************List of all checked quality vegetables items********************************");
		printTitle();
		grocery.stream().filter((GroceryStore gs) -> gs.getType().equals("Vegetables"))
				.filter((GroceryStore gs) -> gs.isCheckQuality())
				.forEach((GroceryStore gs) -> System.out.println(gs.toString()));

		System.out.println();
		System.out.println(
				"********************************List of all checked quality meat items********************************");
		printTitle();
		grocery.stream().filter((GroceryStore gs) -> gs.getType().equals("Meat"))
				.filter((GroceryStore gs) -> gs.isCheckQuality())
				.forEach((GroceryStore gs) -> System.out.println(gs.toString()));

		System.out.println();
		System.out.println(
				"********************************List of all checked quality fruits items********************************");
		printTitle();
		grocery.stream().filter((GroceryStore gs) -> gs.getType().equals("Vegetables"))
				.filter((GroceryStore gs) -> gs.isCheckQuality())
				.forEach((GroceryStore gs) -> System.out.println(gs.toString()));

		System.out.println();
		System.out.println(
				"********************************List of all sorted vegetables based on its quantity********************************");
		printTitle();
		grocery.stream().filter((GroceryStore gs) -> gs.getType().equals("Vegetables"))
				.sorted((GroceryStore gs1, GroceryStore gs2) -> gs2.getItemQuantity() - gs1.getItemQuantity())
				.forEach((GroceryStore gs) -> System.out.println(gs.toString()));

		System.out.println();
		System.out.println("********************************List of all expired items********************************");
		printTitle();
		grocery.stream()
				.filter((GroceryStore gs1) -> gs1.getCreationTime().toLocalDate().toString()
						.compareTo(LocalDate.now().toString()) < 0)
				.forEach((GroceryStore gs) -> System.out.println(gs.toString()));

		System.out.println();
		System.out.println(
				"********************************Finding maximum price of Fruit********************************");
		printTitle();
		GroceryStore maxFruit = grocery.stream().filter((GroceryStore gs) -> gs.getType().equals("Fruit"))
				.max(Comparator.comparing((GroceryStore gs) -> gs.getItemPrice())).get();
		System.out.println(maxFruit.toString());

		System.out.println();
		System.out.println(
				"********************************Finding maximum price of Meat********************************");
		printTitle();
		GroceryStore maxMeat = grocery.stream().filter((GroceryStore gs) -> gs.getType().equals("Meat"))
				.max(Comparator.comparing((GroceryStore gs) -> gs.getItemPrice())).get();
		System.out.println(maxMeat.toString());

		System.out.println();
		System.out.println(
				"********************************Finding min price of Vegetables********************************");
		printTitle();
		GroceryStore minVegetables = grocery.stream().filter((GroceryStore gs) -> gs.getType().equals("Vegetables"))
				.min(Comparator.comparing((GroceryStore gs) -> gs.getItemPrice())).get();
		System.out.println(minVegetables.toString());

		System.out.println();
		System.out.println(
				"********************************Finding total items of Fruits********************************");
		System.out.println("Total items of Fruit is "
				+ grocery.stream().filter((GroceryStore gs) -> gs.getType().equals("Fruit")).count());

		System.out.println();
		System.out
				.println("********************************Finding total items of Meat********************************");
		System.out.println("Total items of Meat is "
				+ grocery.stream().filter((GroceryStore gs) -> gs.getType().equals("Meat")).count());

		System.out.println();
		System.out.println(
				"********************************Finding total items of Grocery********************************");
		System.out.println("Total items of grocery is " + grocery.stream().count());

		System.out.println();
		System.out.println(
				"********************************Finding min price of Vegetables by using reduce function********************************");

		Float minVegetables1 = grocery.stream().filter((GroceryStore gs) -> gs.getType().equals("Vegetables"))
				.map((GroceryStore gs) -> gs.getItemPrice()).reduce((result, price) -> {
					if (Float.compare(result, price) >= 0) {
						return price;
					} else
						return result;
				}).get();

		System.out.println(minVegetables1);

		System.out.println();
		System.out.println(
				"********************************Finding min price of Fruit by using reduce function********************************");

		Float minFruit1 = grocery.stream().filter((GroceryStore gs) -> gs.getType().equals("Fruit"))
				.map((GroceryStore gs) -> gs.getItemPrice()).reduce((result, price) -> {
					if (Float.compare(result, price) >= 0) {
						return price;
					} else
						return result;
				}).get();

		System.out.println(minFruit1);

		System.out.println();
		System.out.println(
				"********************************Finding max price of Meat by using reduce function********************************");

		Float maxMeat1 = grocery.stream().filter((GroceryStore gs) -> gs.getType().equals("Meat"))
				.map((GroceryStore gs) -> gs.getItemPrice()).reduce((result, price) -> {
					if (Float.compare(result, price) < 0) {
						return price;
					} else
						return result;
				}).get();

		System.out.println(maxMeat1);

		System.out.println();
		System.out.println(
				"********************************Finding total items of Vegetables by using reduce function********************************");
		System.out.println("Total items of grocery is " +

				grocery.stream().filter((GroceryStore gs) -> gs.getType().equals("Vegetables"))
						.map((GroceryStore gs) -> gs.getItemName()).distinct()
						.reduce(0, (result, price) -> ++result, (finalResult, intermediateResult) -> finalResult));
	}

	public static void printTitle() {
		System.out.println();
		String title = String.format("%-20s %-20s %-20s %-20s %-30s %-20s ", "Item Name", "Type", "Price($)",
				"Quantity(lbs)", "Is quality checked?", "Expired Date");
		for (int i = 0; i < 140; i++) {
			System.out.print("-");
		}
		System.out.println();
		System.out.println(title);
		for (int i = 0; i < 140; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

}
