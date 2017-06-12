package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.VTID;

@IID("{0936F9CD-8DD6-44CF-A658-D9C062DB3ACA}")
public abstract interface IAuditRecordAdder
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract void addAuditRecord(@MarshalAs(NativeType.Dispatch) Com4jObject paramCom4jObject);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IAuditRecordAdder
 * JD-Core Version:    0.7.0.1
 */