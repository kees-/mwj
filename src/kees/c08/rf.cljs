(ns kees.c08.rf
  (:require [re-frame.core :as re-frame]))

;; ========== SETUP ============================================================
(def default-db
  {})

(def <sub (comp deref re-frame/subscribe))
(def <sub-lazy re-frame/subscribe)
(def >evt re-frame/dispatch)
(def >evt-now re-frame/dispatch-sync)

;; ========== EVENTS ===========================================================
(re-frame/reg-event-db
 ::boot
 (fn [_ _]
   default-db))

;; ========== SUBS =============================================================
(re-frame/reg-sub
 ::test
 (fn [_ _]
   "Does nothing"))
