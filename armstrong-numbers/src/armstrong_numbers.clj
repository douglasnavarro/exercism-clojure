(ns armstrong-numbers)

(declare calc-armstrong explode pow)

(defn armstrong?
  [num]
  (= num (calc-armstrong num)))

(defn calc-armstrong
  [num]
  (reduce
    +
    (map
      #(pow % (count (explode num)))
      (explode num))))

(defn explode
  [number]
  (map read-string (map str (seq (str number)))))

(defn pow [x n]
  (reduce * (repeat n x)))
