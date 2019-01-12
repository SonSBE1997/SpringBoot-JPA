package com.team1.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Project name: Team1-SpringBoot-JPA
 * Package name: com.team1.controller
 * File name: ABCZ.java
 * Author: ...Hai95
 * Created date: Jan 11, 2019
 * Created time: 8:49:43 AM
 */
@Generated(value= "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MenuRole.class)
public class MenuRole_ {
	public static volatile SingularAttribute<MenuRole, Integer> id;
	public static volatile SingularAttribute<MenuRole, Menu> menu;
	public static volatile SingularAttribute<MenuRole, Role> role;
}
