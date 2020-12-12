package com.ernest.umber.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-12T10:34:18")
@StaticMetamodel(DvPlate.class)
public class DvPlate_ extends EntityModel_ {

    public static volatile SingularAttribute<DvPlate, Date> expiryDate;
    public static volatile SingularAttribute<DvPlate, Date> issuedDate;
    public static volatile SingularAttribute<DvPlate, String> serialNumber;
    public static volatile SingularAttribute<DvPlate, String> issuedTo;
    public static volatile SingularAttribute<DvPlate, String> prefix;
    public static volatile SingularAttribute<DvPlate, String> batch;
    public static volatile SingularAttribute<DvPlate, Boolean> assigned;
    public static volatile SingularAttribute<DvPlate, Integer> plateNumber;
    public static volatile SingularAttribute<DvPlate, String> fullPlateNumber;

}