package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{D42ED49E-B4CD-4434-88E4-CB6A0521EF3A}")
public abstract interface ICustomization3
  extends ICustomization2
{
  @DISPID(17)
  @VTID(23)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject types();
  
  @DISPID(18)
  @VTID(24)
  public abstract String entityDataTables();
  
  @DISPID(19)
  @VTID(25)
  public abstract IList customizableEntitiesTables();
  
  @VTID(25)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object customizableEntitiesTables(int paramInt);
  
  @DISPID(20)
  @VTID(26)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject rbt();
  
  @DISPID(21)
  @VTID(27)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject workflow();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICustomization3
 * JD-Core Version:    0.7.0.1
 */