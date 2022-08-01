(ns kees.c08.views.signup
  (:require [reagent.core :as reagent]
            [kees.c08.utils.loader :as loader]))

(defn loading
  []
  [:div.loading
   [:img
    {:src "/_asset/loading.gif"}]])

(def ^:private fd-externs
  (let [timestamp (-> (.now js/Date) (/ 120000) (js/Math.floor) (* 60))
        fdjs (str "https://assets.flodesk.com/universal.js?v=" timestamp)
        fdmjs (str "https://assets.flodesk.com/universal.mjs?v=" timestamp)]
    {#(true? (.-fdLoaded js/window)) "/_js/preFlodesk.js"
     ; The following two tests are the same
     ; Just so the hashmap has unique keys
     #(exists? (aget js/window "fd")) fdjs
     #(.hasOwnProperty js/window "fd") fdmjs}))

(defn- contact-capture
  "Returns an identifying :div and renders internal Flodesk logic."
  []
  (let [id "5fd5468ccdc040ff3b12248e"]
    (reagent/create-class
     {:display-name id
      :component-did-mount
      (fn [_]
        (.fd js/window
             "form"
             #js{:formId id
                 :containerEl (str "#fd-form-" id)}))
      :reagent-render
      (fn [_]
        [:div {:id (str "fd-form-" id)}])})))

(defn- form-loader
  "Component for just-in-time script loading.
   Replaces the need for header scripts called asynchronously on page load."
  [id]
  [loader/load-js
   {:scripts fd-externs
    :loading [loading]
    :loaded  [contact-capture {:id id}]}])

;; ========== PUBLIC ===========================================================
(defn style
  []
  [[:#logo-container {:border-left "1.5px solid darkcyan"
                      :border-right "1.5px solid darkcyan"
                      :color "teal"
                      :background "transparent"}]
   [:.logo::before :.logo::after {:color "teal"}]
   [:.loading {:display "block"
               :margin "0 auto"
               :padding "2rem"
               :width "max-content"}]
   [:#ph {:color "teal"
          :background "transparent"}]
   [:#signup {:background "lightblue"
              :margin "2rem auto 0"
              :max-width "fit-content"}
    [:input {:background "ivory"
             :border "1px inset powderblue"}]
    [:button {:background "mintcream"
              :border-radius ".3rem"
              :margin-top ".5rem"
              :box-shadow "0 0 4px 0 #e7f7f6"}
     [:&:hover {:background "#ebfffa"}]]
    [:hr {:max-width "60%"
          :margin ".75rem auto -.75rem"
          :height "1.5px"
          :border-width "0"
          :background "ivory"}]
    [:article {:text-align "center"
               :padding "2rem .75rem 0"
               :margin "0 auto"
               :font-family "sans-serif"
               :line-height "1.25"
               :font-weight "800"
               :text-transform "uppercase"
               :font-size "2rem"
               :max-width "30rem"}]]
   [:#signup-link {:visibility "hidden"}]
   [:#signup-list {:background "honeydew"
                   :padding-left "1rem"
                   :padding-right "1rem"}]])

(defn main
  []
  [:div#signup-list.full
   [:div#signup
    [:article "Sign up for the MWJ mailing list for more:"]
    [:hr]
    [form-loader]]])

; Creative testimonial "horses"
