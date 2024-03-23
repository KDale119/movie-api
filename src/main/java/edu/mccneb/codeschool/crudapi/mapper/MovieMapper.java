package edu.mccneb.codeschool.crudapi.mapper;

import edu.mccneb.codeschool.crudapi.model.ExternalMovieAPI;
import edu.mccneb.codeschool.crudapi.model.Movie;
import edu.mccneb.codeschool.crudapi.model.Results;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    @Mapping(source = "movie.id", target = "id")
    @Mapping(source = "movie.releaseDate", target = "releaseDate")
    @Mapping(source = "results.overview", target = "overview")

    Movie mapMovie(Results results, Movie movie);
}
