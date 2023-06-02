package com.hokay.budgetier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

import javax.annotation.PostConstruct;

@Configuration
public class MongoConfiguration {

    private final MappingMongoConverter mongoConverter;

    @Autowired
    public MongoConfiguration(MappingMongoConverter mappingMongoConverter) {
        this.mongoConverter = mappingMongoConverter;
    }

    @PostConstruct
    public void setUpMongoEscapeCharacterAndTypeMapperConversion() {
        mongoConverter.setMapKeyDotReplacement("_"); // This will remove _class: key
        mongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
    }

}
