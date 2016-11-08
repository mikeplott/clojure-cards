(ns clojure-cards.core
  (:gen-class))

(def suits [:clubs :spades :hearts :diamonds])
(def ranks (range 1 14))

(defn create-deck []
  (set
    (for [suit suits
          rank ranks]
      {:suit suit :rank rank})))

(defn create-hands [deck]
  (set
    (for [c1 deck
          c2 (disj deck c1)
          c3 (disj deck c1 c2)
          c4 (disj deck c1 c2 c3)]
      #{c1 c2 c3 c4})))
  
(def test-hand #{{:suit :spades :rank 1}
                 {:suit :spades :rank 2}
                 {:suit :spades :rank 3}
                 {:suit :spades :rank 4}})

(map (fn [c] (:suit c)) test-hand)

(map :suit test-hand)

(set (map :suit test-hand))


(defn flush? [hand]
  (= 1 (count (set (map :suit hand)))))

;(defn straight-flush? [hand]
 ; (= 1 (count (set (map :suit hand)))
  ;   (sequential? (set (map :rank hand)))))

(defn straight-flush? [hand]
  (seq? (seq hand)))

;(defn straight-flush? [hand]
 ; (= 1 (count (set (map :suit hand)))
  ;   (seq? (seq (map :rank hand)))))

;(defn straight-flush? [hand]
 ; (sequential? hand))

;(defn straight? [hand]
 ; (= 4 (count (set (map :rank hand))))
  ;(sequential? hand))

(defn straight? [hand]
  (= 4 (count (set (map :rank hand))))
  (seq? (seq hand)))

(defn four-of-a-kind? [hand]
  (= 1 (count (set (map :rank hand)))))

(defn three-of-a-kind? [hand]
  (= 2 (count (set (map :rank hand)))))

;(defn straight-flush? [hand]
 ; (flush? hand
  ;  (sequential? hand)))

;(defn straight-flush? [hand]
 ; (if flush? [hand]
  ;  (= 4 (count (set (map :rank hand)))
   ;    (sequential? hand)))


;(defn straight-flush? [hand]
 ; (= 1 (count (set (map :suit hand)))
  ;   (= 4 (count (set (map :rank hand))))
   ;  (sequential? hand)))
    
  

(defn -main [& args]
  (let [deck (create-deck)
        hands (create-hands deck)
        ;hands (filter flush? hands)
        ;hands (filter straight-flush? hands)]
        ;hands (filter straight? hands)]
        ;hands (filter four-of-a-kind? hands)]
        hands (filter three-of-a-kind? hands)]
    (println (count hands))))
  

