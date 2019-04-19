(ns collatz-conjecture)

(defn collatz
  ([num]
    (if (or (< num 0) (= 0 num))
      (throw (Throwable. "invalid input"))
      (collatz num 0)))
  ([num call-count]
   (if (= 1 num)
     call-count
     (if (even? num)
       (recur (/ num 2) (inc call-count))
       (recur (inc (* num 3)) (inc call-count))))))
 
