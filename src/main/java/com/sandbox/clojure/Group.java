package com.sandbox.clojure;

import clojure.lang.IFn;

import java.util.ArrayList;
import java.util.List;

import static clojure.java.api.Clojure.read;
import static clojure.java.api.Clojure.var;

public class Group {
	private static final String JAVA_DATA_NAMESPACE = "clojure.java.data";
	private static final String PERSON_FINDER_NAMESPACE = "com.sandbox.clojure.finder";

	private static final IFn REQUIRE = var("clojure.core", "require");
	private static final IFn FROM_JAVA = var(JAVA_DATA_NAMESPACE, "from-java");
	private static final IFn TO_JAVA = var(JAVA_DATA_NAMESPACE, "to-java");

	private static final IFn OLDEST = var(PERSON_FINDER_NAMESPACE, "oldest");
	private static final IFn YOUNGEST = var(PERSON_FINDER_NAMESPACE, "youngest");

	private List<Person> group = new ArrayList<Person>();

	public Group() {
		REQUIRE.invoke(read(JAVA_DATA_NAMESPACE));
		REQUIRE.invoke(read(PERSON_FINDER_NAMESPACE));
	}

	public void add(Person person) {
		group.add(person);
	}

	public Person findYoungest() {
		return find(YOUNGEST);
	}

	public Person findOldest() {
		return find(OLDEST);
	}

	private Person find(IFn function) {
		Object person = function.invoke(FROM_JAVA.invoke(group));
		return (Person) TO_JAVA.invoke(Person.class, person);
	}
}