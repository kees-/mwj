(ns kees.c08.utils.loader
  (:require [reagent.core :as reagent]
            [goog.net.jsloader :as jsl]
            [goog.html.legacyconversions :as legacy]))

(defn- filter-loaded
  "Take a map of boolean functions to URI locations (local/remote)
   of javascript script files. Returns a list of URIs
   corresponding to false checks."
  [scripts]
  (reduce (fn [check [loaded? src]] (if (loaded?) check (conj check src)))
          []
          scripts))

(defn load-js
  "Takes a map containing a map of scripts and two DOM components.
   The :loading component is displayed until all scripts have been run.
   The :loaded component will render once setup is complete."
  [{:keys [scripts loading loaded]}]
  (let [loaded? (reagent/atom false)]
    (reagent/create-class
     {:component-did-mount
      (fn []
        (let [not-loaded (->> scripts
                              filter-loaded
                              (map legacy/trustedResourceUrlFromString)
                              clj->js)]
          (.then (jsl/safeLoadMany not-loaded)
                 #(reset! loaded? true)
                 #(js/console.info "Scripts not loaded."))))
      :reagent-render
      (fn []
        (if @loaded? loaded loading))})))
