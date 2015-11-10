(ns ^:figwheel-always ex.project-ns-test
  (:require [cljs.test :refer-macros [deftest is testing]]))

(deftest some-test
  (testing "Does Cljs still support correct addition?"
    (is (= 2 (+ 1 0 1)))
    (is (= 4 (+ 2 2))
        "2+2 should always make a 5")))
