(ns kees.c08.views
  (:require [garden.core :as garden :refer [css]]
            [kees.c08.rf :as rf :refer [<sub >evt]]
            [kees.c08.views.signup :as views.signup]
            [kees.c08.views.fishtank :as views.fishtank]
            [kees.c08.views.horses :as views.horses]))

(defn routes
  "Return the content of a route."
  ; Could be improved, i.e protocol
  [hash]
  (case hash
    "" [views.fishtank/main]
    "list" [views.signup/main]
    "horses" [views.horses/main]
    [views.fishtank/main]))

(defn styles
  [hash]
  (css
   ((case hash
      "" views.fishtank/style
      "list" views.signup/style
      "horses" views.horses/style
      views.fishtank/style))))

;; ========== COMPONENTS =======================================================
(defn ph-number
  []
  [:a#ph
   {:href "tel:+13108481990"}
   [:article "+1 310 848 1990"]])

(defn signup-list
  []
  [:a#signup-link
   {:href "#list"}
   "News"])

(defn logo
  []
  [:a#logo-container
   {:href "#"}
   [:article#logo "MWJ"]])

(defn main
  "Body in charge of rendering the content of the route detected by handler."
  []
  (let [route (<sub [::rf/current-route])]
    [:main (routes route)]))

(defn page-style
  []
  (let [route (<sub [::rf/current-route])]
    (styles route)))

(defn root-panel
  "Main panel always rendered by mount-root."
  []
  [:<>
   [main]
   [:header
    [logo]]
   [:footer
    [ph-number]
    [signup-list]]])
