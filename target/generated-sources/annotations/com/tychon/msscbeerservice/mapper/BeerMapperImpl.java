package com.tychon.msscbeerservice.mapper;

import com.tychon.msscbeerservice.domain.Beer;
import com.tychon.msscbeerservice.domain.Beer.BeerBuilder;
import com.tychon.msscbeerservice.web.model.BeerDto;
import com.tychon.msscbeerservice.web.model.BeerDto.BeerDtoBuilder;
import com.tychon.msscbeerservice.web.model.BeerStyleEnum;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-13T08:35:18+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (JetBrains s.r.o.)"
)
@Component
public class BeerMapperImpl implements BeerMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public BeerDto beertoBeerDto(Beer beer) {
        if ( beer == null ) {
            return null;
        }

        BeerDtoBuilder beerDto = BeerDto.builder();

        beerDto.id( beer.getId() );
        if ( beer.getVersion() != null ) {
            beerDto.version( beer.getVersion().intValue() );
        }
        beerDto.createdDate( dateMapper.asOffsetDateTime( beer.getCreatedDate() ) );
        beerDto.lastModifiedDate( dateMapper.asOffsetDateTime( beer.getLastModifiedDate() ) );
        beerDto.beerName( beer.getBeerName() );
        if ( beer.getBeerStyle() != null ) {
            beerDto.beerStyle( Enum.valueOf( BeerStyleEnum.class, beer.getBeerStyle() ) );
        }
        beerDto.upc( beer.getUpc() );
        beerDto.price( beer.getPrice() );

        return beerDto.build();
    }

    @Override
    public Beer beerDtoToBeer(BeerDto beerDTO) {
        if ( beerDTO == null ) {
            return null;
        }

        BeerBuilder beer = Beer.builder();

        beer.id( beerDTO.getId() );
        if ( beerDTO.getVersion() != null ) {
            beer.version( beerDTO.getVersion().longValue() );
        }
        beer.createdDate( dateMapper.asTimestamp( beerDTO.getCreatedDate() ) );
        beer.lastModifiedDate( dateMapper.asTimestamp( beerDTO.getLastModifiedDate() ) );
        beer.beerName( beerDTO.getBeerName() );
        if ( beerDTO.getBeerStyle() != null ) {
            beer.beerStyle( beerDTO.getBeerStyle().name() );
        }
        beer.upc( beerDTO.getUpc() );
        beer.price( beerDTO.getPrice() );

        return beer.build();
    }
}
