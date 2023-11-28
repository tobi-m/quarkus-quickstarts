package org.acme.hibernate.orm.panache.rest.entity;

import java.time.LocalDate;
import java.util.List;

import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import io.quarkus.rest.data.panache.MethodProperties;
import io.quarkus.rest.data.panache.ResourceProperties;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;


@ResourceProperties(hal = true, path = "my-people")
public interface PeopleResource extends PanacheEntityResource<Person, Long> {

    @MethodProperties(path = "all")
    List<Person> list(Page page, Sort sort);

    @MethodProperties(exposed = false)
    boolean delete(Long id);

    @GET
    //@MethodProperties(path = "date")
    @Path("/date")
    @Produces(MediaType.APPLICATION_JSON)
    default List<Person> findByBirthDate(@QueryParam("date") LocalDate date) {
        return Person.find("birthDate = ?1", date).list();
    }
}
