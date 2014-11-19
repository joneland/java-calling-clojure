package com.sandbox.clojure;

import clojure.java.api.Clojure;
import clojure.lang.IFn;

import static clojure.java.api.Clojure.read;
import static clojure.java.api.Clojure.var;

public class FizzBuzz {
	private static final String FIZZBUZZ_NAMESPACE = "com.sandbox.clojure.fizzbuzz";

	private static final IFn REQUIRE = var("clojure.core", "require");
	private static final IFn FIZZBUZZ = var(FIZZBUZZ_NAMESPACE, "apply-to");

	public FizzBuzz() {
		REQUIRE.invoke(read(FIZZBUZZ_NAMESPACE));
	}

	public String applyTo(Integer number) {
		return (String) FIZZBUZZ.invoke(number);
	}
}