(ns com.sandbox.clojure.finder)

(defn sort-by-age-and-get
  [position]
  (fn [group]
    (->
      (sort-by :age group)
      position)))

(defn youngest
  [group]
  ((sort-by-age-and-get first) group))

(defn oldest
  [group]
  ((sort-by-age-and-get last) group))
