package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{3A3FE6C4-6DE7-47AB-8BF1-EE578637596A}")
public abstract interface IExtensionData
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract String name();
  
  @DISPID(2)
  @VTID(8)
  public abstract String displayName();
  
  @DISPID(3)
  @VTID(9)
  public abstract String uiDataProviderId();
  
  @DISPID(4)
  @VTID(10)
  public abstract String version();
  
  @DISPID(5)
  @VTID(11)
  public abstract String otaDataProviderId();
  
  @DISPID(6)
  @VTID(12)
  public abstract IList modules();
  
  @VTID(12)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object modules(int paramInt);
  
  @DISPID(7)
  @VTID(13)
  public abstract String repositoryRoot();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IExtensionData
 * JD-Core Version:    0.7.0.1
 */