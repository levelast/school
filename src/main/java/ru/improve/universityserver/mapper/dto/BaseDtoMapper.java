package ru.improve.universityserver.mapper.dto;

import org.apache.commons.collections4.CollectionUtils;
import org.assertj.core.util.Lists;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface BaseDtoMapper<Pojo, Dto> {

    Dto toDto(Pojo pojo);

    Pojo toPojo(Dto dto);

    default List<Dto> toDtoList(Collection<Pojo> pojoCollection) {
        if (CollectionUtils.isEmpty(pojoCollection)) {
            return Lists.emptyList();
        }
        return pojoCollection.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    default List<Pojo> toPojoList(Collection<Dto> dtoCollection) {
        if (CollectionUtils.isEmpty(dtoCollection)) {
            return Lists.emptyList();
        }
        return dtoCollection.stream()
                .map(this::toPojo)
                .collect(Collectors.toList());
    }
}
