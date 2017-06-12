package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{CAFABBC2-CE43-48CD-A6AC-2DBDA404C076}")
public abstract interface ISupportEntityTypes
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract IList getTypedFields(String paramString);
  
  @DISPID(2)
  @VTID(8)
  public abstract boolean isFieldRelevantToType(String paramString1, String paramString2);
  
  @DISPID(3)
  @VTID(9)
  public abstract boolean isFieldRequiredInType(String paramString1, String paramString2);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ISupportEntityTypes
 * JD-Core Version:    0.7.0.1
 */