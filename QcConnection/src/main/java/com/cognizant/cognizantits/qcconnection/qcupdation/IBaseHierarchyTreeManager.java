package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.DefaultMethod;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{0225839A-79F8-4493-872C-004FFDDF0CA1}")
public abstract interface IBaseHierarchyTreeManager
  extends Com4jObject
{
  @DISPID(0)
  @VTID(7)
  @DefaultMethod
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject root();
  
  @DISPID(1)
  @VTID(8)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject nodeByPath(String paramString);
  
  @DISPID(2)
  @VTID(9)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject nodeById(int paramInt);
  
  @DISPID(3)
  @VTID(10)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject unattached();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IBaseHierarchyTreeManager
 * JD-Core Version:    0.7.0.1
 */