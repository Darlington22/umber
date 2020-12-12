package com.ernest.umber.entity;

import com.ernest.umber.entity.UserAccount;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-12T10:34:18")
@StaticMetamodel(EntityModel.class)
public class EntityModel_ { 

    public static volatile SingularAttribute<EntityModel, Boolean> deleted;
    public static volatile SingularAttribute<EntityModel, UserAccount> updatedBy;
    public static volatile SingularAttribute<EntityModel, UserAccount> createdBy;
    public static volatile SingularAttribute<EntityModel, String> id;
    public static volatile SingularAttribute<EntityModel, Date> updatedOn;
    public static volatile SingularAttribute<EntityModel, Boolean> updated;
    public static volatile SingularAttribute<EntityModel, Date> createdOn;
    public static volatile SingularAttribute<EntityModel, String> deletedBy;

}