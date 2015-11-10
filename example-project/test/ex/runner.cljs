(ns ex.runner
  (:require [cljs.test :as test]
            [doo.runner :refer-macros [doo-all-tests doo-tests]]
            [ex.project-ns-test]))

;"This namespace contains a hook to run all of the selected
;namespaces.  We have to pull in all of the namespaces that we want
;to test. There is no easy way to pull in *all* namespaces."

(enable-console-print!)

(doo-tests 'ex.project-ns-test)
