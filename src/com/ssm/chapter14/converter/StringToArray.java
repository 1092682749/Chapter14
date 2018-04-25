package com.ssm.chapter14.converter;

import oracle.jdbc.internal.OracleTypeMetaData;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.util.StringUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class StringToArray implements ConditionalGenericConverter {

    private final ConversionService conversionService;

    public StringToArray(ConversionService conversionService){
        this.conversionService = conversionService;
    }

    @Override
    public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
        return this.conversionService.canConvert(sourceType,targetType.getElementTypeDescriptor());
    }

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return Collections.singleton(new ConvertiblePair(String.class,Object[].class));
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        if (source == null)
        {
            return null;
        }
        String string = (String)source;
        String[] fields = StringUtils.commaDelimitedListToStringArray(string);
        Object target = Array.newInstance(targetType.getElementTypeDescriptor().getType(),fields.length);
        for (int i = 0; i < fields.length; i++)
        {
            String sourceElement = fields[i];
            Object targetElement = this.conversionService.convert(sourceElement.trim(),sourceType,targetType.getElementTypeDescriptor());
            Array.set(target,i,targetElement);
        }
        return target;
    }
}
