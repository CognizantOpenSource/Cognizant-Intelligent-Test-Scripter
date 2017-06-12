package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{1CD20510-7700-42B6-83AB-4AFC0419318D}")
public abstract interface ICustomizationUsersGroups
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject addGroup(String paramString);
  
  @DISPID(2)
  @VTID(8)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject group(String paramString);
  
  @DISPID(3)
  @VTID(9)
  public abstract void removeGroup(String paramString);
  
  @DISPID(4)
  @VTID(10)
  public abstract IList groups();
  
  @VTID(10)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object groups(int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICustomizationUsersGroups
 * JD-Core Version:    0.7.0.1
 */