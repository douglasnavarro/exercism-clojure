(ns robot-name)


(defn- rand-robot-numbers
  []
  (apply str (take 3 (repeatedly #(str (rand-int 9))))))

(defn- rand-robot-chars
  []
  (apply str (take 2 (repeatedly #(char (+ (rand 26) 65))))))

(defn- gen-name
  []
  (str (rand-robot-chars) (rand-robot-numbers)))

(defn robot
  []
  (atom (gen-name)))

(defn robot-name
  [robot]
  (deref robot))

(defn reset-name
  [robot-instance]
  (let [new-name (gen-name)]
    (if (= new-name (:name robot-instance))
        (recur robot-instance)
        (reset! robot-instance new-name))))
