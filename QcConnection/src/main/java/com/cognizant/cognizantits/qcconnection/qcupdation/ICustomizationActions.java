package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{E746670E-69C7-4DC1-93BC-9B4662B6015D}")
public abstract interface ICustomizationActions
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract IList actions();
  
  @VTID(7)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object actions(int paramInt);
  
  @DISPID(2)
  @VTID(8)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject action(String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICustomizationActions
 * JD-Core Version:    0.7.0.1
 */