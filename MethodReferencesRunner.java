package com.in28minutes.basicfunctinalprogramming;

import java.util.List;

public class MethodReferencesRunner {

	public static void print(Integer number) {
		System.out.println(number);
	}

	public static boolean isEven(Integer number) {
		return number % 2 == 0;
	}

	public static void main(String[] args) {
		List.of("Ant", "Bat", "Cat", "Dog", "Elephant").stream().map(element -> element.length())
				.forEach(element -> System.out.println(element));

		List.of("Ant", "Bat", "Cat", "Dog", "Elephant").stream().map(String::length)
				.forEach(MethodReferencesRunner::print);

		System.out.println(
				List.of(23, 45, 67, 34).stream().filter(MethodReferencesRunner::isEven).max(Integer::compare).get());

	}

}
