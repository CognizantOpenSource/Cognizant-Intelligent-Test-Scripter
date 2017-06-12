package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{9B1C51AD-A124-465D-96EE-39DB5168FEFC}")
public abstract interface IExtensionServiceProvider
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract ITDConnection qcConnection();
  
  @DISPID(2)
  @VTID(8)
  public abstract Com4jObject webConnection();
  
  @DISPID(3)
  @VTID(9)
  public abstract ICacheManager cacheManager();
  
  @DISPID(4)
  @VTID(10)
  public abstract ISystemFieldService systemFieldService();
  
  @DISPID(5)
  @VTID(11)
  public abstract IDataServiceProvider dataServiceProvider();
  
  @DISPID(6)
  @VTID(12)
  public abstract ICustomizationPermissionService customizationPermission();
  
  @DISPID(7)
  @VTID(13)
  public abstract IFactoryService factoryService();
  
  @DISPID(8)
  @VTID(14)
  public abstract IExtendedStorage extendedStorage(String paramString1, String paramString2);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IExtensionServiceProvider
 * JD-Core Version:    0.7.0.1
 */