(ns accumulate)

; (defn accumulate [func coll]
;    (map func coll))

(defn accumulate
  ([func coll]
   (accumulate func coll []))
  ([func coll result]
   (if (empty? coll)
      result
      (recur
        func 
        (rest coll)
        (conj result (-> coll
                         first
                         func))))))

