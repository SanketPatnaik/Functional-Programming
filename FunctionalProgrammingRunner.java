package com.in28minutes.basicfunctinalprogramming;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FunctionalProgrammingRunner {

	public static void main(String[] args) {
		List<String> list = List.of("Apple", "Bat", "Cat", "Dog");
		List<Integer> list2 = List.of(88, 63, 92, 49, 64, 13, 82, 21, 92, 33, 76, 87, 44, 32, 12, 72);
		List<Integer> numbers = List.of(4, 6, 8, 13, 3, 15);

		printListWithFunctionalProgramming(list);
		System.out.println();
		printFilteredListWithFunctionalProgramming(list);
		System.out.println();
		printSumOfListWithFunctionalProgramming(list2, list);
		System.out.println();
		System.out.println(findSumOfNumbers(numbers));
		System.out.println(findSumOfNumbersWithFP(numbers));
		System.out.println(findSumOfOddNumbersWithFP(numbers));
		printSquaresOfFirst10Integers();
		System.out.println();
		printListWithLowerCase();
		System.out.println();
		printTheLengthOfEachElement();
		System.out.println();
		System.out.println(findTheMaxNumberFromAListWithFP(numbers));
		System.out.println(returnAListOfOddNumbersFromAGivenList(numbers));
		System.out.println(returnAListOfEvenNumbersFromAGivenList(numbers));
		System.out.println(createAListOfFirst10IntegersWithFP());

	}
	private static void printListWithFunctionalProgramming(List<String> list) {
		list.stream().forEach(element -> System.out.print(element + " "));
	}
	private static void printFilteredListWithFunctionalProgramming(List<String> list) {
		list.stream().filter(element -> element.endsWith("at")).forEach(element -> System.out.print(element + " "));
	}

	private static void printSumOfListWithFunctionalProgramming(List<Integer> list2, List<String> list) {
		System.out.println(list2.stream().reduce(0, (number1, number2) -> number1 + number2));
		System.out.println(
				list2.stream().filter(element -> element % 2 == 0).reduce(0, (number1, number2) -> number1 + number2));
		System.out.println(
				list2.stream().filter(element -> element % 2 == 1).reduce(0, (number1, number2) -> number1 + number2));
	}

	public static int findSumOfNumbers(List<Integer> numbers) {
		int sum = 0;
		for (Integer number : numbers) {
			sum = sum + number;
		}
		return sum;
	}

	public static int findSumOfNumbersWithFP(List<Integer> numbers) {
		return numbers.stream().reduce(0, (number1, number2) -> {
			System.out.println(number1 + " " + number2);
			return number1 + number2;
		});
	}

	public static int findSumOfOddNumbersWithFP(List<Integer> numbers) {
		return numbers.stream().filter(element -> element % 2 == 1).reduce(0, (number1, number2) -> number1 + number2);
	}

	public static void printSquaresOfFirst10Integers() {
		IntStream.range(1, 11).map(element -> element * element).forEach(element -> System.out.print(element + " "));
	}

	public static void printListWithLowerCase() {
		List.of("Apple", "Ant", "Bat").stream().map(element -> element.toLowerCase())
				.forEach(element -> System.out.println(element));

	}

	public static void printTheLengthOfEachElement() {
		List.of("Apple", "Ant", "Bat").stream()
				.forEach(element -> System.out.println(element + " : " + element.length()));
	}

	public static int findTheMaxNumberFromAListWithFP(List<Integer> numbers) {
		return numbers.stream().max((n1, n2) -> Integer.compare(n1, n2)).get();
	}

	public static List<Integer> returnAListOfOddNumbersFromAGivenList(List<Integer> numbers) {
		return numbers.stream().filter(element -> element % 2 == 1).collect(Collectors.toList());
	}

	public static List<Integer> returnAListOfEvenNumbersFromAGivenList(List<Integer> numbers) {
		return numbers.stream().filter(element -> element % 2 == 0).collect(Collectors.toList());
	}

	public static List<Integer> createAListOfFirst10IntegersWithFP() {
		return IntStream.range(1, 11).map(element -> element * element).boxed().collect(Collectors.toList());
	}




}
