package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{47E4C767-87DA-409F-A70E-04B3FCE28BCE}")
public abstract interface _IBaseFactory
  extends Com4jObject
{
  @VTID(3)
  @ReturnValue(type=NativeType.VARIANT)
  public abstract Object listRefresh(String paramString);
  
  @VTID(4)
  public abstract void removeCachedList(String paramString);
  
  @VTID(5)
  public abstract IList getCachedList(String paramString);
  
  @VTID(6)
  public abstract void putCachedList(String paramString, IList paramIList);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation._IBaseFactory
 * JD-Core Version:    0.7.0.1
 */