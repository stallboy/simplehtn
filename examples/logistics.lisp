(defdomain logistics
   (
    (:operator (!load-truck ?obj ?truck ?loc)
               ()
               ((obj-at ?obj ?loc) (:protection (truck-at ?truck ?loc)))
               ((in-truck ?obj ?truck)))

    (:operator (!unload-truck ?obj ?truck ?loc)
               ()
               ((in-truck ?obj ?truck) (:protection (truck-at ?truck ?loc)))
               ((obj-at ?obj ?loc)))

    (:operator (!load-airplane ?obj ?airplane ?loc)
               ()
               ((obj-at ?obj ?loc) (:protection (airplane-at ?airplane ?loc)))
               ((in-airplane ?obj ?airplane)))

    (:operator (!unload-airplane ?obj ?airplane ?loc)
               ()
               ((in-airplane ?obj ?airplane) (:protection (airplane-at ?airplane ?loc)))
               ((obj-at ?obj ?loc)))

    (:operator (!drive-truck ?truck ?loc-from ?loc-to)
               ()
               ((truck-at ?truck ?loc-from))
               ((truck-at ?truck ?loc-to) (:protection (truck-at ?truck ?loc-to))))

    (:operator (!fly-airplane ?airplane ?airport-from ?airport-to)
               ()
               ((airplane-at ?airplane ?airport-from))
               ((airplane-at ?airplane ?airport-to) (:protection (airplane-at ?airplane ?airport-to))))


    (:operator (!add-protection ?g)
               ()
               ()
               ((:protection ?g))
               )

    (:operator (!delete-protection ?g)
               ()
               ((:protection ?g))
               ()
               )

    (:method (obj-at ?obj ?loc-goal)
             ; 城市内走车辆
             ((in-city ?loc-goal ?city-goal)
              (obj-at ?obj ?loc-now)
              (in-city ?loc-now ?city-goal)
              (truck ?truck ?city-goal)
              )
            ((in-city-delivery ?truck ?obj ?loc-now ?loc-goal))

      ; 城市间，车 - 飞机 - 车
      ((in-city ?loc-goal ?city-goal)
       (obj-at ?obj ?loc-now)
       (in-city ?loc-now ?city-now)
       (different ?city-goal ?city-now)
       (truck ?truck-now ?city-now)
       (truck ?truck-goal ?city-goal)
       (airport ?airport-now) (in-city ?airport-now ?city-now)
       (airport ?airport-goal) (in-city ?airport-goal ?city-goal))

      ((in-city-delivery ?truck-now ?obj ?loc-now ?airport-now)
                (air-deliver-obj ?obj ?airport-now ?airport-goal)
                (in-city-delivery ?truck-goal ?obj ?airport-goal ?loc-goal)))

    (:method (in-city-delivery ?truck ?obj ?loc-from ?loc-to)
             ((same ?loc-from ?loc-to))
             ()

             ((in-city ?loc-from ?city)
              (truck ?truck ?city))
             ((truck-at ?truck ?loc-from)
                       (:immediate !load-truck ?obj ?truck ?loc-from)
                       (truck-at ?truck ?loc-to)
                       (:immediate !unload-truck ?obj ?truck ?loc-to)))


    (:method (truck-at ?truck ?loc-to)

             ((truck-at ?truck ?loc-from)
              (different ?loc-from ?loc-to))
             ((:immediate !drive-truck ?truck ?loc-from ?loc-to))

             ((truck-at ?truck ?loc-from)
              (same ?loc-from ?loc-to))
             ((:immediate !add-protection (truck-at ?truck ?loc-to))))

    (:method (air-deliver-obj ?obj ?airport-from ?airport-to)
             airplane-at-the-current-airport
             ((airplane-at ?airplane ?airport-from))
             ((:immediate !add-protection (airplane-at
?airplane ?airport-from))
                       (!load-airplane ?obj ?airplane ?airport-from)
                       (fly-airplane ?airplane ?airport-to)
                       (!unload-airplane ?obj ?airplane ?airport-to))

             ((airplane-at ?airplane ?any-airport))
             ((:immediate !fly-airplane ?airplane
?any-airport ?airport-from)
                       (!load-airplane ?obj ?airplane ?airport-from)
                       (fly-airplane ?airplane ?airport-to)
                       (!unload-airplane ?obj ?airplane ?airport-to)))

    (:method (fly-airplane ?airplane ?airport-to)
             airplane-already-there
             ((airplane-at ?airplane ?airport-to))
             ((:immediate !add-protection (airplane-at ?airplane ?airport-to)))

             fly-airplane-in
             ((airplane-at ?airplane ?airport-from))
             ((:immediate !fly-airplane ?airplane ?airport-from ?airport-to)))


    (:- (same ?x ?x) nil)
    (:- (different ?x ?y) ((not (same ?x ?y))))
    ))
