(defproject multi-wget "0.1.0-SNAPSHOT"
  :description "Download binary files in parallel"
  :url "https://github.com/baijian/multi-wget"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojure-contrib "1.2.0"]]
  :main ^:skip-aot multi-wget.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
