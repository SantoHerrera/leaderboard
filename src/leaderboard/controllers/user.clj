(ns leaderboard.controllers.user
  "The main controller for the user management portion of this app."
  (:gen-class)
  (:require [ring.util.response :as resp]
            [selmer.parser :as tmpl]))

(def ^:private changes
  "Count the number of changes (since the last reload)."
  (atom 0))

(defn render-page
  "Each handler function here adds :application/view to the request
  data to indicate which view file they want displayed. This allows
  us to put the rendering logic in one place instead of repeating it
  for every handler."
  [req]
  ; what does data do?
  ;
  (let [data (assoc (:params req) :changes @changes)
        view (:application/view req "default")
        html (tmpl/render-file (str "views/user/" view ".html") data)]
    (-> (resp/response (tmpl/render-file "layouts/default.html"
                                         (assoc data :body [:safe html])))
        (resp/content-type "text/html"))))

(defn default
  [req]
  (assoc-in req [:params :message]
                (str "Welcome to the User Manager application demo! "
                     "This uses just Compojure, Ring, and Selmer.")))
