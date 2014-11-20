(ns com.sandbox.clojure.finder)

(defn sort-by-age-and-get-name-of
  [position]
  (fn [group]
    (->
      (sort-by :age group)
      position
      :name)))

(defn youngest
  [group]
  ((sort-by-age-and-get-name-of first) group))

(defn oldest
  [group]
  ((sort-by-age-and-get-name-of last) group))
