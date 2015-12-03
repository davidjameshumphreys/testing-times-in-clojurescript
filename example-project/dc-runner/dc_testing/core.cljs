(ns dc-testing.core
  (:require
   [sablono.core :as sab :include-macros true])
  (:require-macros
   [devcards.core :as dc :refer [defcard deftest]]
   [cljs.test :refer [is testing]]))

(enable-console-print!)

(defcard first-card
  (sab/html [:div
             [:h1 "This is your first devcard!"]]))

(defcard second-card
  {:something true})

(deftest some-regular-tests
         (testing "basic math"
           (is (= 9 (* 3 3)))
           (testing "wishful thinking"
             (is (= 0 (/ 9 0))))))

(defn calc-bmi [bmi-data]
  (let [{:keys [height weight bmi] :as data} bmi-data
        h (/ height 100)]
    (if (nil? bmi)
      (assoc data :bmi (/ weight (* h h)))
      (assoc data :weight (* bmi h h)))))

(defn slider [bmi-data param value min max]
  (sab/html
    [:input {:type      "range" :value value :min min :max max
             :style     {:width "100%"}
             :on-change (fn [e]
                          (swap! bmi-data assoc param (.-target.value e))
                          (when (not= param :bmi)
                            (swap! bmi-data assoc :bmi nil)))}]))

(defn bmi-component [bmi-data]
  (let [{:keys [weight height bmi]} (calc-bmi @bmi-data)
        [color diagnose] (cond
                           (< bmi 18.5) ["orange" "underweight"]
                           (< bmi 25) ["inherit" "normal"]
                           (< bmi 30) ["orange" "overweight"]
                           :else ["red" "obese"])]
    (sab/html
      [:div
       [:h3 "BMI calculator"]
       [:div
        [:span (str "Height: " (int height) "cm")]
        (slider bmi-data :height height 100 220)]
       [:div
        [:span (str "Weight: " (int weight) "kg")]
        (slider bmi-data :weight weight 30 150)]
       [:div
        [:span (str "BMI: " (int bmi) " ")]
        [:span {:style {:color color}} diagnose]
        (slider bmi-data :bmi bmi 10 50)]])))

(defcard bmi-calculator
         "*Code taken from the Reagent readme.*"
         (fn [data-atom _] (bmi-component data-atom))
         {:height 180 :weight 80}
         {:inspect-data true
          :frame        true
          :history      true})

(defn main []
  ;; conditionally start the app based on wether the #main-app-area
  ;; node is on the page
  (if-let [node (.getElementById js/document "main-app-area")]
    (js/React.render (sab/html [:div "Main app area in here..."]) node)))

(main)

;; remember to run lein figwheel and then browse to
;; http://localhost:3449/cards.html
