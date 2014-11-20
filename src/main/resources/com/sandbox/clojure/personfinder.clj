(ns com.sandbox.clojure.personfinder)

(defn sort-by-age-and-return
  [position]
  (fn [group]
    (->
      (sort-by :age group)
      position
      :name)))

(defn youngest
  [group]
  ((sort-by-age-and-return first) group))

(defn oldest
  [group]
  ((sort-by-age-and-return last) group))
