(defproject example-project "0.1.0-SNAPSHOT"
  :description "An example project to show off different ways to test"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.122"]
                 ;; Speclj needs to be in deps AND plugins
                 [speclj "3.3.0"]

                 [devcards "0.2.0-8"]]

  :plugins [[lein-cljsbuild "1.1.0"]
            [lein-doo "0.1.6-SNAPSHOT"]
            [speclj "3.3.0"]
            [lein-figwheel "0.4.1"]]

  :clean-targets ^{:protect false} ["resources/public/js/compiled"
                                    "target"]

  :source-paths ["src"]

  :aliases {"try-doo-phantom" ["doo" "phantom"]
            "try-speclj-auto" ["cljsbuild" "auto" "build2"]
            "try-speclj"      ["cljsbuild" "once" "build2"]
            "try-devcards"    ["figwheel" "devcards"]
            "try-figwheel"    ["figwheel" "build3"]}
  :doo {:build "build1"}

  :cljsbuild {:builds
              [;; for lein doo
               {:id           "build1"
                :source-paths ["src" "test"]
                ;; don't quote the name if you want to use devcards.
                :compiler     {:main                 "ex.runner"
                               :asset-path           "js/compiled/out"
                               :output-to            "resources/public/js/compiled/example_project.js"
                               :output-dir           "resources/public/js/compiled/build1"
                               :source-map-timestamp true
                               :optimizations        :simple}}

               ;; for lein speclj
               {:id             "build2"
                :source-paths   ["src" "specs"]
                :compiler       {:optimizations        :simple
                                 :asset-path           "js/compiled/out"
                                 :output-to            "resources/public/js/compiled/example_project.js"
                                 :output-dir           "resources/public/js/compiled/build2"
                                 :source-map-timestamp true}
                :notify-command ["phantomjs" "bin/speclj" "resources/public/js/compiled/example_project.js"]}

               {:id           "devcards"
                :source-paths ["src"]
                :figwheel     {:devcards true}
                :compiler     {:main                 "dc-testing.core"
                               :asset-path           "js/compiled/out"
                               :output-to            "resources/public/js/compiled/devcards_example_project.js"
                               :output-dir           "resources/public/js/compiled/out"
                               :source-map-timestamp true}}
               {:id           "build3"
                :source-paths ["src"]
                :figwheel     {:on-jsload "ex.figrunner/run"}
                :compiler     {:main                 "example-project.core"
                               :asset-path           "js/compiled/out"
                               :output-to            "resources/public/js/compiled/example_project.js"
                               :output-dir           "resources/public/js/compiled/out"
                               :source-map-timestamp true}}
               ]}
  :figwheel {:css-dirs ["resources/public/css"]})
