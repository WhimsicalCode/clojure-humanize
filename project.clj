(defproject clojure-humanize "0.2.3-SNAPSHOT"
  :description "produce human readable strings in clojure"
  :url "https://github.com/trhura/clojure-humanize"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [org.clojure/math.numeric-tower "0.0.5"]
                 [clj-time "0.15.2"]
                 [com.andrewmcveigh/cljs-time "0.5.2"]]
  :profiles {:dev {:dependencies [[org.clojure/clojurescript "1.11.60"]]
                   :plugins [[lein-cljsbuild "1.1.8"]]}}
  :cljsbuild {:builds {:test
                       {:source-paths ["src" "test"]
                        :compiler {:optimizations :whitespace
                                   :pretty-print true
                                   :output-dir "target/js/test"
                                   :output-to "target/humanize-test.js"
                                   :source-map "target/humanize-test.js.map"}}}
              :test-commands {"cljs" ["phantomjs"
                                      "phantom/unit-test.js"
                                      "phantom/unit-test.html"]}}
  :aliases {"test-all" ["do"
                        "test" "clojure.contrib.cljc-test,"
                        "cljsbuild" "test"
                        ]})
