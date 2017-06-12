package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{BE73DDAA-AD0F-4A89-8936-0EDA17599273}")
public abstract interface IBaseField2
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract boolean autoUnlock();
  
  @DISPID(1)
  @VTID(8)
  public abstract void autoUnlock(boolean paramBoolean);
  
  @DISPID(2)
  @VTID(9)
  public abstract IMultiValue fieldMultiValue(String paramString);
  
  @DISPID(2)
  @VTID(10)
  public abstract void fieldMultiValue(String paramString, IMultiValue paramIMultiValue);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IBaseField2
 * JD-Core Version:    0.7.0.1
 */