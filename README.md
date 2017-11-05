# Quil Isometric

[![Clojars Project](https://img.shields.io/clojars/v/kieranbrowne/quil-isometric.svg)](https://clojars.org/kieranbrowne/quil-isometric)

A clojure library for isometric imagery.

## Example

```clj
(ns my-sketch.core
  (:require 
    [quil.core :as q]
    [quil-isometric.core :as iso]))

(defn setup []
  ;; set sketch to use orthogonal rendering
  (q/ortho))

(defn draw []
  ;; set background to white
  (q/background 255)
  ;; draw iso metric grid with units of 10 pixels
  (iso/grid 10)
  ;; 
  (iso/with-iso
    (q/box 150)))

(q/defsketch my-sketch
  :title "Isometric design"
  :renderer :p3d ;; (must be :p3d or :opengl)
  :setup setup
  :draw draw 
  :size [500 500])
```

## License

Copyright © 2017 Kieran Browne

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
