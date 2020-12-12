package com.ernest.umber.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-12T10:34:18")
@StaticMetamodel(UserAccount.class)
public class UserAccount_ extends EntityModel_ {

    public static volatile SingularAttribute<UserAccount, Boolean> resetPassword;
    public static volatile SingularAttribute<UserAccount, String> emailAddress;
    public static volatile SingularAttribute<UserAccount, String> userPassword;
    public static volatile SingularAttribute<UserAccount, String> userAccountStatus;
    public static volatile SingularAttribute<UserAccount, String> fullName;
    public static volatile SingularAttribute<UserAccount, String> telephone;
    public static volatile SingularAttribute<UserAccount, String> userAccountType;

}