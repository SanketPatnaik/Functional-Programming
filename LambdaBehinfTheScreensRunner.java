package com.in28minutes.basicfunctinalprogramming;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class EvenNumberPredicate implements Predicate<Integer> {
	@Override
	public boolean test(Integer number) {
		return number % 2 == 0;
	}
}

class SystemOutConsumer implements Consumer<Integer> {
	@Override
	public void accept(Integer element) {
		System.out.println(element);
	}
}

class NumberSquareMapper implements Function<Integer, Integer> {
	@Override
	public Integer apply(Integer n) {
		return n * n;
	}
}

public class LambdaBehinfTheScreensRunner {
	public static void main(String[] args) {
		Predicate<? super Integer> evenPredicate = createEvenPredicate();
		Predicate<? super Integer> oddPredicate = createOddPredicate();

		List.of(23, 43, 34, 45, 36, 48).stream().filter(evenPredicate).map(n -> n * n)
				.forEach(e -> System.out.println(e));
		System.out.println("====");

		// .filter(new EvenNumberPredicate())
		// Stream<T> filter(Predicate<? super T> predicate);
		// boolean test(T t);
		List.of(23, 43, 34, 45, 36, 48).stream().filter(new EvenNumberPredicate()).map(n -> n * n)
				.forEach(e -> System.out.println(e));
		System.out.println("====");

		// .forEach(new SystemOutConsumer())
		// forEach(Consumer<? super T> action);
		// void accept(T t);
		List.of(23, 43, 34, 45, 36, 48).stream().filter(new EvenNumberPredicate()).map(n -> n * n)
				.forEach(new SystemOutConsumer());
		System.out.println("====");

		// .map(new NumberSquareMapper())
		// <R> Stream<R> map(Function<? super T, ? extends R> mapper);
		// R apply(T t);
		List.of(23, 43, 34, 45, 36, 48).stream().filter(n -> n % 2 == 0).map(new NumberSquareMapper())
				.forEach(e -> System.out.println(e));
	}

	private static Predicate<? super Integer> createOddPredicate() {
		return n -> n % 2 == 1;
	}

	private static Predicate<? super Integer> createEvenPredicate() {
		return n -> n % 2 == 0;
	}
}