(defproject org.clojure.clr/core.specs.alpha "0.4.74"
  :description "Port of clojure.org/core.specs.alpha to ClojureCLR"
  :url "https://github.com/clojure/clr.core.specs.alpha"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure.clr/spec.alpha "0.5.238"]]
  :deploy-repositories [["clojars" {:url "https://clojars.org/repo/"
                                    :sign-releases  false}]]
  :warn-on-reflection true
  :source-paths ["src/main/clojure"]
  :test-paths ["src/test/clojure"] 
  :min-lein-version "2.0.0"
  :plugins [[lein-clr "0.2.1"]]
  :clr {:cmd-templates  {:clj-exe   [[?PATH "mono"] [CLJCLR19_40 %1]]
                         :clj-dep   [[?PATH "mono"] ["target/clr/clj/Debug 4.0" %1]]
                         :clj-url   "http://sourceforge.net/projects/clojureclr/files/clojure-clr-1.4.1-Debug-4.0.zip/download"
                         :clj-zip   "clojure-clr-1.4.1-Debug-4.0.zip"
                         :curl      ["curl" "--insecure" "-f" "-L" "-o" %1 %2]
                         :nuget-ver [[?PATH "mono"] [*PATH "nuget.exe"] "install" %1 "-Version" %2]
                         :nuget-any [[?PATH "mono"] [*PATH "nuget.exe"] "install" %1]
                         :unzip     ["unzip" "-d" %1 %2]
                         :wget      ["wget" "--no-check-certificate" "--no-clobber" "-O" %1 %2]}
        ;; for automatic download/unzip of ClojureCLR,
        ;; 1. make sure you have curl or wget installed and on PATH,
        ;; 2. uncomment deps in :deps-cmds, and
        ;; 3. use :clj-dep instead of :clj-exe in :main-cmd and :compile-cmd
        :deps-cmds      [; [:wget  :clj-zip :clj-url] ; edit to use :curl instead of :wget
                         ; [:unzip "../clj" :clj-zip]
                         ]
        :main-cmd      [:clj-exe "Clojure.Main.exe"]
        :compile-cmd   [:clj-exe "Clojure.Compile.exe"]})
