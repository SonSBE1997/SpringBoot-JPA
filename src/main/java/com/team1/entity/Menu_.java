package com.team1.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value= "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Menu.class)
public abstract class Menu_ {
	public static volatile SingularAttribute<Menu, Integer> menuId;
	public static volatile SingularAttribute<Menu, String> name;
	public static volatile SingularAttribute<Menu, String> desc;
	public static volatile SingularAttribute<Menu, String> controller;
	public static volatile SingularAttribute<Menu, String> function;
}
