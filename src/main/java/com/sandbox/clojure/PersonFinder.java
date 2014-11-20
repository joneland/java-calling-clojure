package com.sandbox.clojure;

import clojure.lang.IFn;

import java.util.List;

import static clojure.java.api.Clojure.read;
import static clojure.java.api.Clojure.var;

public class PersonFinder {
	private static final String JAVA_DATA_NAMESPACE = "clojure.java.data";
	private static final String PERSON_FINDER_NAMESPACE = "com.sandbox.clojure.personfinder";

	private static final IFn REQUIRE = var("clojure.core", "require");
	private static final IFn FROM_JAVA = var(JAVA_DATA_NAMESPACE, "from-java");

	private static final IFn OLDEST = var(PERSON_FINDER_NAMESPACE, "oldest");
	private static final IFn YOUNGEST = var(PERSON_FINDER_NAMESPACE, "youngest");

	public PersonFinder() {
		REQUIRE.invoke(read(JAVA_DATA_NAMESPACE));
		REQUIRE.invoke(read(PERSON_FINDER_NAMESPACE));
	}

	public String findYoungestIn(List<Person> group) {
		return (String) YOUNGEST.invoke(withClojureRepresentationOf(group));
	}

	public String findOldestIn(List<Person> group) {
		return (String) OLDEST.invoke(withClojureRepresentationOf(group));
	}

	private Object withClojureRepresentationOf(Object object) {
		return FROM_JAVA.invoke(object);
	}
}