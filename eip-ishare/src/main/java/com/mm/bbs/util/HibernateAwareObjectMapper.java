package com.mm.bbs.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

public class HibernateAwareObjectMapper extends  ObjectMapper{
	
	public HibernateAwareObjectMapper() {
        registerModule(new Hibernate4Module());
    }
}
