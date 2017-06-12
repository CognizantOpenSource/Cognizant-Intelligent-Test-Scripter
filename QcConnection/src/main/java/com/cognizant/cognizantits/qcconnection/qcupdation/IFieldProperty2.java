package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{F5DEB618-2CF4-44A1-81A1-00922B9C4F5B}")
public abstract interface IFieldProperty2
  extends IFieldProperty
{
  @DISPID(28)
  @VTID(35)
  public abstract boolean isCanGroup();
  
  @DISPID(29)
  @VTID(36)
  public abstract boolean isSearchable();
  
  @DISPID(30)
  @VTID(37)
  public abstract boolean isMultiValue();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IFieldProperty2
 * JD-Core Version:    0.7.0.1
 */