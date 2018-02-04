(ns reader)

(declare pizza-prompt)

(defn slices->pies
  [n-slices-str]
  (try
    (let [n-slices (Long. n-slices-str)]
      (long (Math/ceil (/ n-slices 8))))
    (catch Exception e
      (println "I didn't catch that.")
      (pizza-prompt)
      nil)))

(defn format-pizzas
  [n-pizzas]
  (format "%,d" n-pizzas))

(defn pizza-prompt
  []
  (println "How many pizza slices?")
  (when-let [pizzas (slices->pies (read-line))]
    (println
     (cond
        (= pizzas 1) "Got it! 1 pizza 🍕 coming right up!"
        (> pizzas 100) (str "Uhhh ain't nobody got time for " (format-pizzas pizzas) " pizzas 🍕!")
        (> pizzas 1) (str "Great! " (format-pizzas pizzas) " pizzas 🍕 coming right up!")
        :else "Fine. No pizza 🍕 for you!"))))

(defn -main []
  (pizza-prompt))
