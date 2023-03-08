package com.outplay.bookservice.core.utilities.mappers;

import org.modelmapper.ModelMapper;

/**
 * @author Gokalp on 5.03.2023
 * @project javaMicroservice
 */
public interface ModelMapperService {
    ModelMapper forResponse();
    ModelMapper forRequest();
}
