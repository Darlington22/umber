package com.ernest.umber.entity;

import com.ernest.umber.entity.Company;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-12T10:34:18")
@StaticMetamodel(PlateDistribution.class)
public class PlateDistribution_ extends EntityModel_ {

    public static volatile SingularAttribute<PlateDistribution, Integer> quantity;
    public static volatile SingularAttribute<PlateDistribution, Integer> startNumber;
    public static volatile SingularAttribute<PlateDistribution, String> prefix;
    public static volatile SingularAttribute<PlateDistribution, String> rangeOfPlate;
    public static volatile SingularAttribute<PlateDistribution, String> invoiceNumber;
    public static volatile SingularAttribute<PlateDistribution, Date> transDate;
    public static volatile SingularAttribute<PlateDistribution, Company> company;
    public static volatile SingularAttribute<PlateDistribution, Integer> endNumber;

}