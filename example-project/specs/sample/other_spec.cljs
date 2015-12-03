(ns sample.other-spec
  (:require-macros [speclj.core :refer [describe it should should-not run-specs]])
  (:require [speclj.core]))


(describe "Buffalo Bill"
          (it "puts the lotion on"
              (should false)))
(run-specs)
