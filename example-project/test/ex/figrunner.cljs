(ns ^:figwheel-always ex.figrunner
  (:require [cljs.test :refer-macros [run-all-tests]]
            [ex.project-ns-test]))

(enable-console-print!)

(defn ^:export run []
  (println "running tests")
  (run-all-tests #".*-test$"))
;;