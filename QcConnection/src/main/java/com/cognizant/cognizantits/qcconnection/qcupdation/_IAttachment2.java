package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.IID;
import com4j.VTID;

@IID("{E9E4C5D3-17CF-481F-ABA5-1A64372879F4}")
public abstract interface _IAttachment2
  extends Com4jObject
{
  @VTID(3)
  public abstract void postVirtual(boolean paramBoolean);
  
  @VTID(4)
  public abstract String convert_CR_REFERENCE_FieldValueToName(String paramString);
  
  @VTID(5)
  public abstract String convert_CR_REFERENCE_FieldValueToFileName(String paramString);
  
  @VTID(6)
  public abstract int convert_CR_REF_TYPE_FieldValue(String paramString);
  
  @VTID(7)
  public abstract void copyToResource(int paramInt, String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation._IAttachment2
 * JD-Core Version:    0.7.0.1
 */