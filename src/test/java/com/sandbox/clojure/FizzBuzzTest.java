package com.sandbox.clojure;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FizzBuzzTest {
	private FizzBuzz fizzBuzz = new FizzBuzz();

	@Test public void
	generatesFizz_WhenDivisibleBy3() {
		assertThat(fizzBuzz.applyTo(3), is("Fizz"));
		assertThat(fizzBuzz.applyTo(6), is("Fizz"));
	}

	@Test public void
	generatesBuzz_WhenDivisibleBy5() {
		assertThat(fizzBuzz.applyTo(5), is("Buzz"));
		assertThat(fizzBuzz.applyTo(10), is("Buzz"));
	}

	@Test public void
	generatesFizzBuzz_WhenNotDivisibleBy3or5() {
		assertThat(fizzBuzz.applyTo(7), is("FizzBuzz"));
		assertThat(fizzBuzz.applyTo(11), is("FizzBuzz"));
	}
}