(ns sample.core-spec
  (:require-macros [speclj.core :refer [describe it should should-not run-specs]])
  (:require [speclj.core]))

(describe "Truth"
          (it "is true"
              (should true))

          (it "is not false"
              (should-not false)))

(describe "Mathematics"
          (it "works"
              (should (even? 2))))
(run-specs)
