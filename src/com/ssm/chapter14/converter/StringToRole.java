package com.ssm.chapter14.converter;

import com.ssm.chapter14.pojo.Role;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

public class StringToRole implements Converter<String,Role> {

    @Override
    public Role convert(String source) {
        if (StringUtils.isEmpty(source))
        {
            return null;
        }
        if (source.indexOf('-') == -1)
        {
            return null;
        }
        String arr[] = source.split("-");
        if (arr.length != 3)
        {
            return null;
        }
        Role role = new Role();
        role.setId(Long.parseLong(arr[0]));
        role.setRoleName(arr[1]);
        role.setNote(arr[2]);
        return role;
    }
}
