(ns kees.c08.rf
  (:require [re-frame.core :as re-frame :refer [reg-event-db reg-event-fx reg-sub reg-fx path]]))

;; ========== SETUP ============================================================
(def default-db
  {:routing {:route nil}})

(def <sub (comp deref re-frame/subscribe))
(def <sub-lazy re-frame/subscribe)
(def >evt re-frame/dispatch)
(def >evt-now re-frame/dispatch-sync)

;; ========== EVENTS ===========================================================
(reg-event-db
 ::boot
 (fn [_ _]
   ; Bad! Rewrite using fx
   (assoc-in default-db [:routing :route] (-> js/window .-location .-hash))))

; Fired when browser event handler detects change of hash
(reg-event-db
 ::handle
 (path [:routing])
 (fn [routing [_ e]]
   (let [hash-val (->> e .-newURL js/URL. .-hash rest (reduce str))]
     (js/console.log hash-val)
     (assoc routing :route hash-val))))

;; ========== SUBS =============================================================
(reg-sub
 ::test
 (fn [_ _]
   "Does nothing"))

; Returns the STRING stored in state to compare against routes in views.
(reg-sub
 ::current-route
 (fn [db _]
   (-> db :routing :route)))
