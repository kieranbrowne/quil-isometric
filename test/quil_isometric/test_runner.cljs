(ns quil-isomorphic.test-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [quil-isomorphic.core-test]))

(doo-tests 'quil-isomorphic.core-test)
