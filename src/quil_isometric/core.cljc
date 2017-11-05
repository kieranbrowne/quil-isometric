(ns quil-isometric.core
  (:require [quil.core :as q]))

#?(:clj  (def PI  (float Math/PI))
   :cljs (def PI  (.-PI js/Math)))

(defn grid [u]
  (q/push-matrix)
  (dotimes [i 3]
    (q/with-translation [(/ (q/width) 2) (/ (q/height) 2) -1000]
      (q/scale 1 0.86026)
      (q/with-rotation [(q/radians (* i 120))]
        (doseq [n (range -1000 (q/width) u)]
          (q/line n -1000 n 1000)))))
  (q/pop-matrix))

(defmacro with-iso [& body]
  `(do
    (q/push-matrix)
    (q/translate (/ (q/width) 2) (/ (q/height) 2))
    (q/rotate-x (- (/ PI 6)))
    (q/rotate-y 
      (+ (q/radians 45)
         (q/sin (q/map-range 
                  (q/mouse-x) 
                  0 (q/width) 0 (/ PI 2)))))
    ~@body
    (q/pop-matrix)))

