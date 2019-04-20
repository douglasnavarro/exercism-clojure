(ns isbn-verifier)
(declare parse-isbn calc-isbn switch-X explode get-digits)

(defn isbn?
  [isbn]
  (let [parsed (parse-isbn isbn)]
    (if (empty? parsed)
      false
      (= 0 (calc-isbn (get-digits parsed))))))

(defn parse-isbn
  "Returns empty seq if no match!"
  [isbn]
  (rest (re-matches
          #"([0-9])\-?([0-9]{3})\-?([0-9]{5})\-?([0-9X])",
          isbn)))

(defn calc-isbn
  [digits]
  (mod 
    (reduce + (map * digits (reverse (range 1 11))))
    11))

(defn get-digits
  [parsed]
  (map
    switch-X
    (explode (clojure.string/join parsed))))

(defn switch-X
  [digit]
  (if (= 'X digit)
    10
    digit))

(defn explode
  [number]
  (map read-string (map str (seq (str number)))))
