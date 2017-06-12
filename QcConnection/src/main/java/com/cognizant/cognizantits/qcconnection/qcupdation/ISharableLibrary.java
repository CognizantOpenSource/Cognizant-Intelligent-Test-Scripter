package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{8BFFECB5-B1CB-4A13-BDD1-D71ABD17197B}")
public abstract interface ISharableLibrary
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract IList usedByInfo();
  
  @VTID(7)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object usedByInfo(int paramInt);
  
  @DISPID(2)
  @VTID(8)
  public abstract ILibraryOperationResult importLibraryVerification(String paramString1, String paramString2, int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ISharableLibrary
 * JD-Core Version:    0.7.0.1
 */