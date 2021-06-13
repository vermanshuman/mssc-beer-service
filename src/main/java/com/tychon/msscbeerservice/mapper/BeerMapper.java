package com.tychon.msscbeerservice.mapper;

import com.tychon.msscbeerservice.domain.Beer;
import com.tychon.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beertoBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDTO);
}
