package org.movie.app;

import org.glassfish.jersey.server.ResourceConfig;

public class MovieApp extends ResourceConfig {
    public MovieApp() {
        // Define the package which contains the service classes.
        packages("org.movie.rest");
    }
}
