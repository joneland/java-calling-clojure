(ns com.sandbox.clojure.fizzbuzz)

(defn divisible-by
  [divisor]
    (fn [number]
      (zero? (mod number divisor))))

(defn apply-to
  "Returns Fizz, Buzz or FizzBuzz depending on number"
  [number]
    (cond
      ((divisible-by 3) number) "Fizz"
      ((divisible-by 5) number) "Buzz"
      :else "FizzBuzz"))