package com.kirkley.lacrosse

import org.springframework.dao.DataIntegrityViolationException

class TeamController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        render "hello world"
    }
}
