package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{0EEC8C98-2379-4B90-BB09-EBBA9B2A73E1}")
public abstract interface ICacheManager
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract int cacheKey();
  
  @DISPID(2)
  @VTID(8)
  public abstract String cachedData(String paramString1, String paramString2);
  
  @DISPID(2)
  @VTID(9)
  public abstract void cachedData(String paramString1, String paramString2, String paramString3);
  
  @DISPID(3)
  @VTID(10)
  public abstract void removeCachedData(String paramString1, String paramString2, int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ICacheManager
 * JD-Core Version:    0.7.0.1
 */