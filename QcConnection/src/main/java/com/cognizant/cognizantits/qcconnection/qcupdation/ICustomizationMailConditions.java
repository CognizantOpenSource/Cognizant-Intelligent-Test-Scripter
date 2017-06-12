package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{2D05E2CD-60E9-4C56-A05D-D25872A00335}")
public abstract interface ICustomizationMailConditions
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject condition(String paramString, int paramInt);
  
  @DISPID(2)
  @VTID(8)
  public abstract IList conditions();
  
  @VTID(8)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object conditions(int paramInt);
  
  @DISPID(3)
  @VTID(9)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject addCondition(String paramString1, int paramInt, String paramString2);
  
  @DISPID(4)
  @VTID(10)
  public abstract void removeCondition(String paramString, int paramInt);
  
  @DISPID(5)
  @VTID(11)
  public abstract boolean conditionExist(String paramString, int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICustomizationMailConditions
 * JD-Core Version:    0.7.0.1
 */