package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{AA21670C-D2C5-44D4-91A1-F00EDC953D8D}")
public abstract interface IProjectUser
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract int id();
  
  @DISPID(2)
  @VTID(8)
  public abstract String userName();
  
  @DISPID(3)
  @VTID(9)
  public abstract String fullName();
  
  @DISPID(4)
  @VTID(10)
  public abstract String description();
  
  @DISPID(5)
  @VTID(11)
  public abstract String email();
  
  @DISPID(6)
  @VTID(12)
  public abstract boolean isAdmin();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IProjectUser
 * JD-Core Version:    0.7.0.1
 */