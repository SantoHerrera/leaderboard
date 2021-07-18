(defproject leaderboard "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [com.github.seancorfield/next.jdbc "1.1.646"]
                 [com.stuartsierra/component "1.0.0"]
                 [compojure/compojure "1.6.2"]
                 [ring/ring "1.9.2"]
                 [ring/ring-defaults "0.3.2"]
                 [selmer/selmer "1.12.33"]
                 [org.xerial/sqlite-jdbc "3.34.0"]]
  :main ^:skip-aot leaderboard.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
