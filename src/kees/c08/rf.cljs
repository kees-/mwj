(ns kees.c08.rf
  (:require [re-frame.core :as re-frame :refer [reg-event-db reg-event-fx reg-sub reg-fx reg-cofx inject-cofx path]]))

;; ========== SETUP ============================================================
(def default-db
  {:routing {:route ""}})

(def <sub (comp deref re-frame/subscribe))
(def <sub-lazy re-frame/subscribe)
(def >evt re-frame/dispatch)
(def >evt-now re-frame/dispatch-sync)

; Covers two cases in one handler.
; 1. Notices any change of URL;
;    meaning to dispatch a change of content all you need is a NORMAL <a> !
; 2. Handles back and forward buttons which would otherwise be "unseen."
(reg-fx
 :add-hash-handler
 (fn []
   (.addEventListener js/window "hashchange" #(>evt [::handle %]))))

(reg-fx
 :add-class
 (fn [[id class]]
   (-> (.getElementById js/document id) .-classList (.add class))))

(reg-fx
 :remove-class
 (fn [[id class]]
   (-> (.getElementById js/document id) .-classList (.remove class))))

; Pulls current hash value straight from browser
(reg-cofx
 :current-hash
 (fn [cofx _]
   (assoc cofx :hash (->> js/window .-location .-hash rest (reduce str)))))

;; ========== EVENTS ===========================================================
; 1. Gets current hash by cofx
; 2. Adds an event handler to watch hash
; 3. Mounts default db WITH hash
(reg-event-fx
 ::boot
 [(inject-cofx :current-hash)]
 (fn [{:keys [hash]} _]
   {:db (assoc-in default-db [:routing :route] hash)
    :fx [[:add-hash-handler nil]]}))

; Fired when browser event handler detects change of hash
(reg-event-db
 ::handle
 (path [:routing])
 (fn [routing [_ e]]
   (let [hash-val (->> e .-newURL js/URL. .-hash rest (reduce str))]
     (assoc routing :route hash-val))))

(reg-event-fx
 ::add-class
 (fn [_ [_ id class]]
   {:fx [[:add-class [id class]]]}))

(reg-event-fx
 ::remove-class
 (fn [_ [_ id class]]
   {:fx [[:remove-class [id class]]]}))

(reg-event-fx
 ::logo-light-mode
 (fn [_ _]
   {:fx [[:remove-class ["logo-container" "logo-container-dark"]]
         [:remove-class ["logo" "logo-dark"]]
         [:add-class ["logo-container" "logo-container-light"]]
         [:add-class ["logo" "logo-light"]]
         [:remove-class ["ph" "teal"]]]}))

(reg-event-fx
 ::logo-dark-mode
 (fn [_ _]
   {:fx [[:remove-class ["logo-container" "logo-container-light"]]
         [:remove-class ["logo" "logo-light"]]
         [:add-class ["logo-container" "logo-container-dark"]]
         [:add-class ["logo" "logo-dark"]]
         [:add-class ["ph" "teal"]]]}))

;; ========== SUBS =============================================================
; Returns the STRING stored in state to compare against routes in views.
(reg-sub
 ::current-route
 (fn [db _]
   (-> db :routing :route)))
