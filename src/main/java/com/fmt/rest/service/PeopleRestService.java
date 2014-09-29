package com.fmt.rest.service;

import java.util.Collection;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.hibernate.validator.constraints.Length;

import com.fmt.rest.service.annotations.PeopleService;
import com.fmt.rest.service.annotations.Person;

@Path( "/people" ) 
public class PeopleRestService {
    @Inject private PeopleService peopleService;

    // REST methods here
    @Produces( { MediaType.APPLICATION_JSON } )
    @Path( "/{email}" )
    @GET
    public @Valid Person getPerson( 
            @Length( min = 5, max = 255 ) @PathParam( "email" ) final String email ) {
        return peopleService.getByEmail( email );
    }

    @Produces( { MediaType.APPLICATION_JSON } )
    @GET
    public @Valid Collection< Person > getPeople( 
            @Min( 1 ) @QueryParam( "count" ) @DefaultValue( "1" ) final int count ) {
        return peopleService.getPeople( count );
    }

}
