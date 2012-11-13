package com.kirkley.lacrosse

import com.kirkley.lacrosse.Location

class LocationController {

    def show() {
        def locations = Location.findAll()
        [locations:locations]
    }   
    
}
