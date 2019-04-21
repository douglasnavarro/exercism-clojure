(ns etl)
(declare expand-item)

(defn transform
  [source]
  (into {} (map expand-item source)))

(defn expand-item
  [item]
  (into {} 
    (map hash-map 
      (map clojure.string/lower-case (second item))
      (repeat (count (second item)) (first item)))))
  

  
      
    


  

