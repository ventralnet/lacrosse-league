class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/" 
        {
            controller = "team"
        }   
		"500"(view:'/error')
	}
}
